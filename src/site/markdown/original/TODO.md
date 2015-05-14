# JToxcore todo list.
Welcome to the JToxcore todo list, this is very likely out of date, but either way it's a good jumping off point if
you're looking to see where core is going, or where it could use a little love.

There are 3 sections; In Progress, TODO, and Done. These tasks are somewhat sorted by priority, but that shouldn't be
taken to mean that this is the order tasks will (or should) be completed in.

## In Progress
 - [ ] [TODO] Audio/Video
     - [ ] [DONE] encoding/streaming/decoding
     - [ ] [DONE] Call initiation
     - [ ] [DONE] Encryption
     - [ ] [TODO] Video packet splitting.
     - [ ] [TODO] Auditing.
     - [ ] [TODO] Prevent audio skew (seems to be easily solvable client side.)
     - [ ] [TODO] Group chats, audio done.
 - [ ] Networking:
     - [ ] [TODO] UPnP port forwarding. ([#969](https://github.com/irungentoo/toxcore/pull/969))
     - [ ] [TODO] NAT-PMP port forwarding.
 - [ ] DHT:
     - [ ] [TODO] Metadata collection prevention. (docs/Prevent_Tracking.txt)
     - [ ] [TODO] Hardening against attacks.
     - [ ] [TODO] Optimizing the code.
 - [ ] [DONE] Friend only group chats
     - [ ] [DONE] Networking base.
     - [ ] [TODO] Syncing chat state between clients (nicknames, list of who is in chat, etc...)
     - [ ] [TODO] Group private messages. (and adding friends from group chats using those private messages.)
     - [ ] [TODO] Group file transfers.
 - [ ] [TODO] Friends list syncing
 - [ ] [TODO] Make toxcore thread safe.
 - [ ] [TODO] A way for people to connect to people on Tox if they are behind a bad NAT that blocks UDP (or is
just unpunchable) ([docs/TCP_Network.txt](TCP_Network.txt)) (Current way doesn't scale very well.)

## TODO
 - [ ] [TODO] Make the core save/datafile portable across client versions/different processor architectures.
 - [ ] [TODO] Friend_requests.c:
     - [ ] [TODO] What happens when a friend request is received needs to be changed.
     - [ ] [DONE] Add multiple nospam functionality. ([#1317](https://github.com/irungentoo/toxcore/pull/1317))

 - [ ] [TODO] Offline messaging
 - [ ] [TODO] Security audit from professionals

## Done
 - [ ] [DONE] File transfers
 - [ ] [DONE] IPV6 support
 - [ ] [DONE] Encrypted Saves. (see: toxencryptsave)
