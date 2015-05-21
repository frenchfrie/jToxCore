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
|  |  |  |  |  |
|  |  |  |  |  |

