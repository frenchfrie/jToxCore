### The DHT response - 04

On reception of a [DHT request](DHT_nodes_request.html)

    [byte with value: 04]
    [char array  (client node_id), length=32 bytes]
    [random 24 byte nonce]
    [Encrypted with the nonce and private key of the sender:
        [uint8_t number of nodes in this packet]
        [Nodes in node format, length=?? * (number of nodes (maximum of 4 nodes)) bytes]
        [Sendback data, length=8 bytes]
    ]

Node format:

    [uint8_t family (2 == IPv4, 10 == IPv6, 130 == TCP IPv4, 138 == TCP IPv6)]
    [ip (in network byte order), length=4 bytes if ipv4, 16 bytes if ipv6]
    [port (in network byte order), length=2 bytes]
    [char array (node_id), length=32 bytes]




