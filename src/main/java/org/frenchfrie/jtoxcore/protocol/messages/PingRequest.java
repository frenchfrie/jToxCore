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
