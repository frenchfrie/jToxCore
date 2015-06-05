### DHT nodes request - 02

    [byte with value: 02]
    [char array (client node_id), length=32 bytes]
    [random 24 byte nonce]
    [Encrypted with the nonce and private key of the sender:
        [char array: requested_node_id (node_id of which we want the ip), length=32 bytes]
        [Sendback data (must be sent back unmodified by in the response), length=8 bytes]
    ]


When valid, the distant node sends back a [DHT response](DHT_nodes_response.html) containing a list of nodes.