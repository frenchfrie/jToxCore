package org.frenchfrie.jtoxcore.protocol;


import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * This class is the main entry point for any Tox protocol use. Created after the {@link org.apache.http.protocol.HttpService}.
 * Should be supplied with connections and contextes to work.
 *
 * @see <a href="http://docs.oracle.com/javase/tutorial/networking/datagrams/clientServer.html">http://docs.oracle.com/javase/tutorial/networking/datagrams/clientServer.html</a>
 */
public class ToxProtocolService {

    /**
     * A datagram socket that exchange datagrams over UDP.
     */
    private java.net.DatagramSocket socket;

    public ToxProtocolService() throws SocketException {
        socket = new DatagramSocket();
    }
}
