package org.frenchfrie.jtoxcore.protocol.messages;

import org.frenchfrie.jtoxcore.protocol.ToxMessage;

import static org.frenchfrie.jtoxcore.protocol.messages.ToxMessagesIds.DHT_RESPONSE_ID;

public class DHTNodesResponse implements ToxMessage, ToxResponse {
    @Override
    public byte getId() {
        return DHT_RESPONSE_ID;
    }

    @Override
    public boolean isMatchingRequest(ToxMessage message) {
        return false;
    }
}