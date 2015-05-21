### The ping - 00, 01

A ping is send every few seconds to distance friends to keep them as "online". The ping request and response are
identical in structure.

    [byte with value: 00 for request, 01 for response]
    [char array (client node_id), length=32 bytes]
    [random 24 byte nonce]
    [Encrypted with the nonce and private key of the sender: [1 byte type (0 for request, 1 for response)]
    [random 8 byte (ping_id)]]

ping_id = a random integer, the response must contain the exact same number as the request
