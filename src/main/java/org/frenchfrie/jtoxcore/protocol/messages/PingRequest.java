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

package org.frenchfrie.jtoxcore.protocol.messages;

import org.frenchfrie.jtoxcore.protocol.NodeId;

import java.util.Random;

import static org.frenchfrie.jtoxcore.protocol.messages.ToxMessagesIds.PING_REQUEST_ID;

/**
 * Message sent to a remote node to ask for a {@link PingResponse ping response}.
 */
public class PingRequest extends Ping implements ToxRequest {

    public static final int PING_ID_BYTE_SIZE = 8;
    public static final int NONCE_BYTE_SIZE = 24;

    @Override
    public byte getId() {
        return PING_REQUEST_ID;
    }

    @Override
    public boolean isMatchingResponse(ToxResponse response) {
        boolean match = false;
        if (response instanceof PingResponse) {
            PingResponse pingResponse = (PingResponse) response;
            match = pingResponse.getPingId() == getPingId();
        }
        return match;
    }

    public NodeId getClientNodeId() {
        return clientNodeId;
    }

    public void setClientNodeId(NodeId clientNodeId) {
        this.clientNodeId = clientNodeId;
    }

    // TODO: random generation should not be here.
    /**
     * Generate a random ID for this ping request.
     */
    public final void generateId() {
        pingId = new byte[PING_ID_BYTE_SIZE];
        new Random().nextBytes(pingId);
    }

    /**
     * Generate a random nonce for this ping request.
     */
    public final void generateNonce() {
        nonce = new byte[NONCE_BYTE_SIZE];
        new Random().nextBytes(nonce);
    }
}
