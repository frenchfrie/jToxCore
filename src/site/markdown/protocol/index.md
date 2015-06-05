### The Tox protocol specification

TO DO

#### Handshaking process

TODO: insert an UML image

#### Tox messages

| ID  | Name                  | Size           | Format         | Description |
|:---:|:---------------------:|:--------------:|:--------------:|:--------------:|
| 16 | Alive | 1 | [byte(16)] | Sent every 5 seconds to each friend. If none are received from a friend for 15 seconds, the connection times out. |
| 17 | Share relays | 38 to 785 | [byte (17)][up to 16 nodes in DHT packed format] | Sent every couple of minutes to every friend. They are the way TCP relays are shared among friends. |
|  |  |  |  |  |
|  |  |  |  |  |
|  |  |  |  |  |
| 27 | Data packet          |  |  |  |
|  |  |  |  |  |


#### Messaging from Messenger.h

| PACKET_ID_ONLINE              | 24    |
| PACKET_ID_OFFLINE             | 25    |
| PACKET_ID_NICKNAME            | 48    |
| PACKET_ID_STATUSMESSAGE       | 49    |
| PACKET_ID_USERSTATUS          | 50    |
| PACKET_ID_TYPING              | 51    |
| PACKET_ID_MESSAGE             | 64    |
| PACKET_ID_ACTION              | (PACKET_ID_MESSAGE + MESSAGE_ACTION) |
| PACKET_ID_MSI                 | 69    |
| PACKET_ID_FILE_SENDREQUEST    | 80    |
| PACKET_ID_FILE_CONTROL        | 81    |
| PACKET_ID_FILE_DATA           | 82    |
| PACKET_ID_INVITE_GROUPCHAT    | 96    |
| PACKET_ID_ONLINE_PACKET       | 97    |
| PACKET_ID_DIRECT_GROUPCHAT    | 98    |
| PACKET_ID_MESSAGE_GROUPCHAT   | 99    |
| PACKET_ID_LOSSY_GROUPCHAT     | 199   |


All packets starting with a byte in this range can be used for anything:

* PACKET_ID_LOSSLESS_RANGE_START    160
* PACKET_ID_LOSSLESS_RANGE_SIZE     32
* PACKET_LOSSY_AV_RESERVED          8       Number of lossy packet types at start of range reserved for A/V.


#### From TCP_server.h

| TCP_PACKET_ROUTING_REQUEST                | 0 |
| TCP_PACKET_ROUTING_RESPONSE               | 1 |
| TCP_PACKET_CONNECTION_NOTIFICATION        | 2 |
| TCP_PACKET_DISCONNECT_NOTIFICATION        | 3 |
| TCP_PACKET_PING                           | 4 |
| TCP_PACKET_PONG                           | 5 |
| TCP_PACKET_OOB_SEND                       | 6 |
| TCP_PACKET_OOB_RECV                       | 7 |
| TCP_PACKET_ONION_REQUEST                  | 8 |
| TCP_PACKET_ONION_RESPONSE                 | 9 |

#### UDP things from network.h

Great! There are two sets of ids for the tox protocol (Presentation, level 5 to 7 in OSI) depending on the protocol used
underneath as transport layer (level 4)...

| NET_PACKET_PING_REQUEST       | 0     | Ping request packet ID.                             |
| NET_PACKET_PING_RESPONSE      | 1     | Ping response packet ID.                            |
| NET_PACKET_GET_NODES          | 2     | Get nodes request packet ID.                        |
| NET_PACKET_SEND_NODES_IPV6    | 4     | Send nodes response packet ID for other addresses.  |
| NET_PACKET_COOKIE_REQUEST     | 24    | Cookie request packet                               |
| NET_PACKET_COOKIE_RESPONSE    | 25    | Cookie response packet                              |
| NET_PACKET_CRYPTO_HS          | 26    | Crypto handshake packet                             |
| NET_PACKET_CRYPTO_DATA        | 27    | Crypto data packet                                  |
| NET_PACKET_CRYPTO             | 32    | Encrypted data packet ID.                           |
| NET_PACKET_LAN_DISCOVERY      | 33    | LAN discovery packet ID.                            |



https://en.wikipedia.org/wiki/OSI_model