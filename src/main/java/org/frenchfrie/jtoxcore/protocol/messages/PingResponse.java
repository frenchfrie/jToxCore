package org.frenchfrie.jtoxcore.protocol.messages;

import org.frenchfrie.jtoxcore.protocol.ToxMessage;

import static org.frenchfrie.jtoxcore.protocol.messages.ToxMessagesIds.PING_RESPONSE_ID;

/**
 * Message sent to a remote node on reception of a {@link PingRequest ping request}.
 */
public class PingResponse implements ToxMessage, ToxResponse {

    @Override
    public byte getId() {
        return PING_RESPONSE_ID;
    }

    @Override
    public boolean isMatchingRequest(ToxMessage message) {
        return false;
    }
}
