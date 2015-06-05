### Cookie response - 25

    [uint8_t 25]
    [Random nonce (24 bytes)]
    [Encrypted message containing: [Cookie][uint64_t number (that was sent in the request)]]

Encrypted message is encrypted with sender's DHT private key, receiver's DHT
public key and the nonce.

The Cookie should be basically:

    [nonce]
    [encrypted data:
        [uint64_t time]
        [Sender's real public key (32 bytes)]
        [Sender's DHT public key (32 bytes)]
    ]
