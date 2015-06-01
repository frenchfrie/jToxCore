package org.frenchfrie.jtoxcore;

import org.frenchfrie.jtoxcore.protocol.ToxProtocolService;

import java.util.ArrayList;
import java.util.List;

/**
 * Main controller for all DHT operations. It starts a DHT node on client machine to exchange nodes information.
 */
public class ToxDHT {

    /**
     * List of closest nodes. This list can vary automatically based on
     * <p>
     * <strong>From tox doc:</strong><br/>
     * client list: A list of node ids closest (mathematically see bittorrent doc) to ours matched with
     * ip addresses + port number corresponding to that id and a timestamp containing the time or time since the
     * client was successfully pinged.
     * </p>
     */
    private List<ToxDHTNode> closestNodes = new ArrayList<>();

    /**
     * List of friends nodes and nodes we just want to be connected to.
     * <p>
     * <strong>From tox doc:</strong><br/>
     * "friends" list: A list containing the node_ids of all our "friends" or clients we want to connect to. Also
     * contains the ip addresses + port + node_ids + timestamp(of last ping like in the client list) of the 8 clients
     * closest (mathematically see bittorrent doc) to each "friend"
     * </p>
     */
    private List<ToxDHTNode> selectedNodes = new ArrayList<>();

    /**
     * Needs a protocol service to send and receive DHT nodes messages.
     */
    private ToxProtocolService toxProtocolService;

}
