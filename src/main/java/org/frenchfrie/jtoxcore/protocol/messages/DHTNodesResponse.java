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

import static org.frenchfrie.jtoxcore.protocol.messages.ToxMessagesIds.DHT_RESPONSE_ID;

public class DHTNodesResponse implements ToxResponse {
    @Override
    public byte getId() {
        return DHT_RESPONSE_ID;
    }

    @Override
    public boolean isMatchingRequest(ToxRequest request) {
        return false;
    }
}