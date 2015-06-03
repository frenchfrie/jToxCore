package org.frenchfrie.jtoxcore.protocol.messages;

import org.frenchfrie.jtoxcore.protocol.ToxMessage;

import static org.frenchfrie.jtoxcore.protocol.messages.ToxMessagesIds.PING_REQUEST_ID;

/**
 * Message sent to a remote node to ask for a {@link PingResponse ping response}.
 */
public class PingRequest implements ToxMessage, ToxRequest {

    @Override
    public byte getId() {
        return PING_REQUEST_ID;
    }

    @Override
    public boolean isMatchingResponse(ToxMessage message) {
        return false;
    }
}
