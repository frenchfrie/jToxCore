### Data packet response - 27

Tox message used to transport raw data.

    [uint8_t 27][uint16_t (in network byte order) the last 2 bytes of the nonce used to encrypt this][encrypted with the
    session key and a nonce:[plain data]]


#### Plain data in the data packets:

    [uint32_t our recvbuffers buffer_start, (highest packet number handled + 
    1)][uint32_t packet number if lossless, our sendbuffer buffer_end if 
    lossy][data]

data ids:

* 0: padding (skipped until we hit a non zero (data id) byte)
* 1: packet request packet (lossy packet)
* 2: connection kill packet (lossy packet) (tells the other that the connection is over)
* ...
* 16+: reserved for Messenger usage (lossless packets).
* 192+: reserved for Messenger usage (lossy packets).
* 255: reserved for Messenger usage (lossless packet)

packet request packet:

    [uint8_t (1)][uint8_t num][uint8_t num][uint8_t num]...[uint8_t num]


The list of nums are a list of packet numbers the other is requesting.
In order to get the real packet numbers from this list, take the recvbuffers buffer_start
from the packet, subtract 1 from it and put it in packet_num, then start from the
beginning of the num list: if num is zero, add 255 to packet_num, then do the
next num. If num isn't zero, add its value to packet_num, note that the other
has requested we send this packet again to them, then continue to the next num in
the list.


#### Data packet - 1

packet request packet:

    [uint8_t (1)][uint8_t num][uint8_t num][uint8_t num]...[uint8_t num]


The list of nums are a list of packet numbers the other is requesting.
In order to get the real packet numbers from this list, take the recvbuffers buffer_start
from the packet, subtract 1 from it and put it in packet_num, then start from the
beginning of the num list: if num is zero, add 255 to packet_num, then do the
next num. If num isn't zero, add its value to packet_num, note that the other
has requested we send this packet again to them, then continue to the next num in
the list.



