### Adding a friend

Alice adds bob to her friends list by adding his 32 byte public key (client_id) to her friends list.
2 cases:
case 1: Alice adds Bobs public key and bob waits for Alice to attempt to connect to him.
case 2: Bob and Alice add their respective public keys to their friends list at the same time.

case 1:
Alice sends a onion data (see: Prevent_tracking.txt) packet to bob with the encrypted part containing the [friends request](protocol/32_Friend_request.htm).

Bob receives the request and decrypts the message using the function crypto_box_open()

If the message decrypts successfully: ?

If Alice is already in Bobs friends list: case 2

If Alice is not in Bob's friends list and the nospam is good: Bob is prompt to add Alice and is shown the message from her.

If Bobs accepts Alice's friends request he adds her public key to his friends list.

case 2:
Bob and Alice both have the others public key in their friends list, they are ready for the next step: Connecting to an already added friend

In the next step only crypto_box() is used for encryption and only crypto_box_open() for decryption (just like in the last step.)

