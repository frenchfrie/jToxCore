### JToxcore project

This is where the JToxcore documentation is build based on toxcore documentation to have real specs. There is still some
documentation [here][tox-doc] and [there][tox-wiki].

![High level design](img/uml/HLD.png)

Tox is divided into two main functions: peer discovery and secure communication.

#### Peer discovery

Each peer is identified by is Tox ID generated at launch.
Peer discovery is done through two process: auto discover on the same LAN or added by their ID.

1) User A publish his temporary PK through DHT.
2) Another user (B) can use this PK to make a friend request.
3) User A accept the request

##### DHT

Tox uses DHT protocol to help find peers. A java implementation can be found here: [http://dks.sics.se/jdht/](http://dks.sics.se/jdht/)
The tox DHT works withe a short-term public key regenerated every time the program is restarted. It allow user to advertise
themselves.

The DHT itself live its own life and can even be a project or module by itself. It can be a good starting point with a
partial tox protocol implementation.


#### Communication

Tox maintain a pool of connections bound to friend real public keys. There can be several friends with the same PK and so the same
connection. A connection sends packet every 5s to peer and needs to recieve one at least every 15s to stay alive, else it
automatically closes.







[tox-wiki]: https://wiki.tox.im/Main_Page (tox wiki)
[tox-doc]: https://jenkins.libtoxcore.so/job/Technical_Report/lastSuccessfulBuild/artifact/tox.pdf/ (tox documentation)
