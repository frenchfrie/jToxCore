### Handshaking

Alice wants to connect to Bob:

Alice sends a cookie request packet to Bob and gets a cookie response back.

Alice then generates a nonce and a temporary public/private keypair.

Alice then takes that nonce and just generated private key, the obtained 
cookie, creates a new cookie and puts them in a handshake packet, which she 
sends to Bob.

Bob gets the handshake packet, accepts the connection request, then generates a 
nonce and a temporary public/private keypair and sends a handshake packet back 
with this just generated information and with the cookie field being the Other 
Cookie contained in the received handshake.

Both then use these temporary keys to generate the session key, with which every 
data packet sent and received will be encrypted and decrypted. The nonce sent 
in the handshake will be used to encrypt the first data packet sent, the nonce 
+ 1 for the second, the nonce + 2 for the third, and so on.
