/*
 * Copyright 2015 frenchfrie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
