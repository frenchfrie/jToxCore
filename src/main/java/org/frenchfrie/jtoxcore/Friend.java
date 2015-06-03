package org.frenchfrie.jtoxcore;

import org.joda.time.DateTime;

import java.util.List;

public class Friend {

    private enum FriendStatus {
        NO_FRIEND,
        CONNECTED,
    }

    private FriendStatus status;


    private byte[] address;

    private int port;

    private List<Integer> node_ids;

    private DateTime lastPing;

}
