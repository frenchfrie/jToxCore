### Crypto request packets - 32 (also...)

    [char with a value of 32]
    [Bob's (The reciever's) Public key (client_id) (32 bytes))]
    [Alice's (The sender's) Public key (client_id) (32 bytes)]
    [Random nonce (24 bytes)]
    [Encrypted message]

The encrypted message is encrypted with crypto_box() (using Bobs public key, Alice's private key and the nonce (randomly generated 24 bytes)) and is a message from Alice in which she tells Bob who she is.

Each node can route the request to the receiver if they are connected to him. This is to bypass bad NATs.
