### Prevent traking

Current privacy issues with the Tox DHT: 

1. It makes tracking people across different IPs very easy.
Solution: Have each new DHT use a temporary public/private key pair not related 
to the long term public/private key pair.

2. Metadata on which key is friends to which can be collected (The hardening 
makes this somewhat harder by introducing a bunch of random traffic but not 
impossible.).
Solution: If no long term keys were used in the DHT it would solve this 
problem. (possibly knowing which ip is connected to which is much less 
precious.)


So, it seems all our privacy problems are solved if we can manage to make every 
node in the DHT have a keypair that is not related to the long term keys and is 
generated every session.


So, every node in the DHT now has a temporary keypair not related to their real 
long term one. 

But, how do people find themselves then? We have to add a way for people to 
tell their friends what their DHT public key is. We also have to somehow make 
it so people can send/receive friend requests. This has to be done without 
non-friends being able to find out where a node is.

The solution: Onion routing + enable the storage of some small amount of data 
on DHT nodes.


Alice and bob are friends. Before joining the DHT they generate temporary 
session keypairs to be used for the DHT instead of their long term keys.

Bob finds a bunch of random nodes then picks 3 random working ones (A, B, C).

Bob gets the known working node with an id closest to his real one from his list (D)

Bob then creates an onion (the packet will go through A, B, C and will end up at D) 
announce request packet with his real public key, ping_id as zeros and
searching for his real public key.

Bob will announce response packets and will recursively send onion announce request 
packets to closer and closer nodes until he finds the ones closest to his real public key.

Once he has done this, he will send some onion announce request packets with the right 
ping_id previously received from the node when he queried it to announce himself to the node.

The nodes he announces himself to keep the information to send onion packets to that node in 
memory.

Alice meanwhile searches for the nodes closest to Bobs real id using a temporary keypair and 
announce request packets. She does this until she finds nodes that respond with a ping_id of zero.

She sends data to route request packet with information telling Bob her temporary id in the DHT
(or a friend request if she is not friends with him).

Bob finds her by using her temporary id and they connect to each other.


NOTE: crypto_box is used for all the asymmetric encryption and crypto_secretbox is used for all 
the symmetric. Also every DHT node have a random symmetric key which they use to encrypt the stuff 
in normal get node request that is used to encrypt stuff in the following.

Onion packet (request):

initial (sent from us to node A):

    [uint8_t packet id (128)][nonce]
    [our temp DHT public key]encrypted with our temp DHT private key and the pub key of Node A and the nonce:[ 
    [IP_Port of node B][a random public key]encrypted with the random private key and the pub key of Node B and the nonce:[ 
    [IP_Port of node C][a random public key]encrypted with the random private key and the pub key of Node C and the nonce:[ 
    [IP_Port of node D][data to send to Node D]]]]

(sent from node A to node B):

    [uint8_t packet id (129)][nonce]
    [a random public key]encrypted with the random private key and the pub key of Node B and the nonce:[ 
    [IP_Port of node C][a random public key]encrypted with the random private key and the pub key of Node C and the nonce:[ 
    [IP_Port of node D][data to send to Node D]]][nonce (for the following symmetric encryption)]encrypted with temp symmetric key of Node A: [IP_Port (of us)]

(sent from node B to node C):

    [uint8_t packet id (130)][nonce]
    [a random public key]encrypted with the random private key and the pub key of Node C and the nonce:[ 
    [IP_Port of node D][data to send to Node D]][nonce (for the following symmetric encryption)]
    encrypted with temp symmetric key of Node B:[IP_Port (of Node A)[nonce (for the following symmetric encryption)]
    encrypted with temp symmetric key of Node A: [IP_Port (of us)]]

(sent from node C to node D):

    [data to send to Node D][nonce (for the following symmetric encryption)]encrypted with temp symmetric key of Node C:
    [IP_Port (of Node B)[nonce (for the following symmetric encryption)]
    encrypted with temp symmetric key of Node B:[IP_Port (of Node A)[nonce (for the following symmetric encryption)]
    encrypted with temp symmetric key of Node A: [IP_Port (of us)]]]

Data sent to Node D:

announce request packet:

    [uint8_t packet id (131)][nonce][our real long term public key or a temporary one (see next)]
    encrypted (with our real long term private key if we want to announce ourselves, a temporary one if we are searching for friends) and the pub key of Node D and the nonce:
    [[(32 bytes) ping_id][client id we are searching for][public key that we want those sending back data packets to use.][data to send back in response(fixed size)]]

(if the ping id is zero, respond with a announce response packet)
(If the ping id matches the one the node sent in the announce response and the public key matches the one being searched for, 
add the part used to send data to our list (if the list is full make it replace the furthest entry))

data to route request packet:

    [uint8_t packet id (133)][public key of destination node][nonce][temporary just generated public key]
    encrypted with that temporary private key and the nonce and the public key from the announce response packet of the destination node:[data]
    (if Node D contains the ret data for the node, it sends the stuff in this packet as a data to route response packet to the right node)

The data in the previous packet is in format: 

    [real public key of sender]

encrypted with real private key of the sender, the nonce in the data packet and
the real public key of the receiver:

    [[uint8_t id][data (optional)]]

Data sent to us:
announce response packet:

    [uint8_t packet id (132)][data to send back in response(fixed size)][nonce]
    
encrypted with the DHT private key of Node D, the public key in the request and the nonce:[[uint8_t is_stored]

    [(32 bytes) ping_id if is_stored is 0 or 2, public key that must be used to send data packets if is_stored is 1][Node_Format * (maximum of 8)]]

(if the is_stored is not 0, it means the information to reach the client id we are searching for is stored on this node)
is_stored is 2 as a response to a peer trying to announce himself to tell the
peer that he is currently announced successfully.

data to route response packet:

    [uint8_t packet id (134)][nonce][temporary just generated public key]
    encrypted with that temporary private key, the nonce and the public key from the announce response packet of the destination node:[data]


Onion packet (response):

initial (sent from node D to node C):

    [uint8_t packet id (140)][nonce (for the following symmetric encryption)]encrypted with temp symmetric key of Node C:
    [IP_Port (of Node B)[nonce (for the following symmetric encryption)]
    encrypted with temp symmetric key of Node B:[IP_Port (of Node A)[nonce (for the following symmetric encryption)]
    encrypted with temp symmetric key of Node A: [IP_Port (of us)]]][data to send back]

(sent from node C to node B):

    [uint8_t packet id (141)][nonce (for the following symmetric encryption)]
    encrypted with temp symmetric key of Node B:[IP_Port (of Node A)[nonce (for the following symmetric encryption)]
    encrypted with temp symmetric key of Node A: [IP_Port (of us)]][data to send back]

(sent from node B to node A):

    [uint8_t packet id (142)][nonce (for the following symmetric encryption)]
    encrypted with temp symmetric key of Node A: [IP_Port (of us)][data to send back]

(sent from node A to us):

    [data to send back]


Data packets:

    To tell our friend what our DHT public key is so that he can connect to us we send a data packet 
    with id 156 and the data being:[uint64_t (in network byte order) no_replay, the packet will only be 
    accepted if this number is bigger than the last one received] [our dht public key][Node_Format * (
    maximum of 8) nodes closest to us so that the friend can find us faster]
