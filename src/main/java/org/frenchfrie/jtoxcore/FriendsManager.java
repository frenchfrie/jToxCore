package org.frenchfrie.jtoxcore;

import java.util.HashSet;
import java.util.Set;

public class FriendsManager {

    private Set<Friend> friendsList = new HashSet<>();


    public void addFriend(Messenger messager, byte[] address, byte[] data) {

        // checks PK is valid

        // checks PK is not own

        // checks message is not empty

        // checks the address checksum field against the real checksum

        // Add the friend

        // init the connection: the big deal happens here (cf new_friend_connection)
        // => If the PK correspond to an already opened connection, only increase lock count
        // =>


        // if connection OK: set the friend status to connected

        // ultimately verify if the friend is connected and send a ONLINE packet

    }

    /**
     * Tox is a messager.
     */
    public static final class Messenger {

    }

}
