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
import org.frenchfrie.jtoxcore.protocol.ToxMessage;

public abstract class Ping implements ToxMessage {
    /**
     * Arrays of 8 bytes identifying this ping. Ping request and response ids must match.
     */
    protected byte[] pingId;

    protected NodeId clientNodeId;

    /**
     * 24 bytes nonce to encrypt payload.
     */
    protected byte[] nonce;

    public byte[] getPingId() {
        return pingId;
    }

    public void setPingId(byte[] pingId) {
        this.pingId = pingId;
    }

    public NodeId getClientNodeId() {
        return clientNodeId;
    }

    public void setClientNodeId(NodeId clientNodeId) {
        this.clientNodeId = clientNodeId;
    }

    public byte[] getNonce() {
        return nonce;
    }

    public void setNonce(byte[] nonce) {
        this.nonce = nonce;
    }
}
