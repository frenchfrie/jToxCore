### Handshake - 26

    [uint8_t 26][Cookie][nonce][Encrypted message containing: [random 24 bytes base nonce][session public key of the
    peer (32 bytes)][sha512 hash of the entire Cookie sitting outside the encrypted part][Other Cookie (used by the
    other to respond to the handshake packet)]]

The handshake packet is encrypted using the real private key of the sender, the 
real public key of the receiver and the nonce.