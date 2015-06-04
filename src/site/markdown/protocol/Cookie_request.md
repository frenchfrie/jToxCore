### Cookie request - 24

    [uint8_t 24][Sender's DHT Public key (32 bytes)][Random nonce (24 bytes)][Encrypted message containing: [Sender's
    real public key (32 bytes)][padding (32 bytes)][uint64_t number (must be sent back untouched in cookie response)]]

Encrypted message is encrypted with sender's DHT private key, receiver's DHT
public key and the nonce.
