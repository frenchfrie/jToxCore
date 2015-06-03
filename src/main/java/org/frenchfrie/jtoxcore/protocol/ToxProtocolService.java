package org.frenchfrie.jtoxcore.protocol;


import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the main entry point for any Tox protocol use. Created after the <code>org.apache.http.protocol.HttpService</code>.
 * Should be supplied with connections and contextes to work.
 * <p>
 * Connections should be state machine that remember if a connection is established, running, closes...
 * </p>
 *
 * @see <a href="http://docs.oracle.com/javase/tutorial/networking/datagrams/clientServer.html">http://docs.oracle.com/javase/tutorial/networking/datagrams/clientServer.html</a>
 */
public class ToxProtocolService {

    private List<ToxMessageListener> messageListeners = new ArrayList<>();

    /**
     * A datagram socket that exchange datagrams over UDP.
     */
    private java.net.DatagramSocket socket;

    public ToxProtocolService() throws SocketException {
        socket = new DatagramSocket();
    }

    private void fireMessageReceived(ToxMessage message) {
        for (ToxMessageListener messageListener : messageListeners) {
            messageListener.messageReceived(message);
        }
    }

    public void sendMessage(ToxMessage message) {
        // TODO: decouple message service to message transport layer.
        // hint: see messages as postcards
    }

    public void addMessageListenner(ToxMessageListener listener) {
        messageListeners.add(listener);
    }

    public void removeMessageListenner(ToxMessageListener listener) {
        messageListeners.remove(listener);
    }

}
