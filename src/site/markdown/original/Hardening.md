### Hardening

Currently an attacker with sufficient resources could launch a large scale 
denial of service type attack by flooding the Tox network with a bunch of nodes 
that do not act like real nodes to prevent people from finding each other. 

Due to the design of Tox, this is the worst thing an attacker can do to disrupt 
the network.

This solution's goal is to make these denial of service attack very very hard 
to accomplish.

For the network to work every Tox node must:
1. Respond to ping requests.
2. Respond to get node requests with the ids of nodes closest to a queried id 
(It is assumed each nodes know at least the 32 nodes closest to them.)
3. Properly send crypto request packets to their intended destination.

Currently the only thing a node needs to do to be part of the network is 
respond correctly to ping requests. 

The only people we really trust on the network are the nodes in our friends 
list.


The behavior of each Tox node is easily predictable. This means that it possible 
for Tox nodes to test the nodes that they are connected to to see if they 
behave like normal Tox nodes and only send nodes that are confirmed to behave 
like real Tox nodes as part of send node replies when other nodes query them.

If correctly done, this means that to poison the network an attacker can only 
infiltrate the network if his "fake" nodes behave exactly like real nodes 
completely defeating the purpose of the attack. Of course nodes must be 
rechecked regularly to defeat an attack where someone floods the network with 
many good nodes then suddenly turns them all bad.

This also prevents someone from accidentally killing the tox network with a bad 
implementation of the protocol.

Implementation ideas (In Progress):

1. Use our friends to check if the nodes in our close list are good.

EX: If our friend queries a node close to us and it correctly returns our 
ip/port and then sends a crypto request packet to it and it routes it correctly 
to us then it is good.

Problems with this: People don't always have at least one online friend.

2. Pick random nodes (add ourselves some random (fake) friends to increase the 
pool of available nodes) and make then send requests to other nodes, the 
response is then relayed back to us and compared to how the node should have 
behaved. If the node is found to be behaving correctly, it is set as trusted. 
Only trusted nodes are sent in send node packets, that is unless the exact node 
being queried for in the getnode packet is present, it will be sent in the 
sendnode packet even if it is not trusted.

The hypothesis is that if to be part of the network nodes have to behave 
correctly it should prevent disruption from nodes that behave incorrectly.

(This idea is currently being implemented in the harden branch.)
...


### DOC
---

Hardening request packets are sent as crypto request packets (see crypto docs.)
NOTE: currently only get nodes requests are tested in the code which is why 
there is only one test (more will be added soon.)

All hardening requests must contain exactly 768 bytes of data. (The data sent 
must be padded with zeros if it is smaller than that.)

1. Get the information (IP_port, client_id) of the node we want to test.
2. Find a couple random nodes that is not that node (one for each test.)
3. Send crypto request packets to each of these random nodes with the data being:

        [byte with value: 02 (get nodes test request)][struct Node_format (the node to test.)][client_id(32 bytes) the id to query the node with.][padding]

4. The random node receives a packet.
-The packet is a get nodes test request:
    send a get_node request to that node with the id to query in the request.
    when a send_node response is received, send the following response to the 
	person who sent us the get nodes test request packet:
	
        [byte with value: 03 (get nodes test response)][client_id(32 bytes): 
		the id of the tested node][The list of nodes it responded with in IPv6 
		Node format (struct Node_Format)]
   
    PROTIP: (get node requests and response contain an encrypted part that you 
	can use to store information so that you don't 
    have to store in your memory where/if to send back the response from the 
	send node)

5. Receive the test responses.
-If the test(s) pass (the nodes behave in a satisfactory manner), make these 
nodes have priority over those who don't pass the test(s).
