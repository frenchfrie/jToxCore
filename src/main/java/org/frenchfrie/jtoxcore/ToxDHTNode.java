package org.frenchfrie.jtoxcore;

import java.net.URI;
import org.joda.time.DateTime;

/**
 * Representation of a DHT node.
 */
public class ToxDHTNode {

    /**
     * Unique id of the node.
     */
    private int id;

    /**
     * Network location of node.
     */
    private URI uri;

    /**
     * Last time a ping (request or response) was received from this node.
     */
    private DateTime lastPingReceived;

}
