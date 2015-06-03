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

package org.frenchfrie.jtoxcore.protocol.serialization;

import com.google.common.base.Function;
import org.frenchfrie.jtoxcore.protocol.ToxMessage;
import org.frenchfrie.jtoxcore.protocol.messages.PingRequest;
import org.frenchfrie.jtoxcore.protocol.messages.PingResponse;

/**
 * Implementation of serialization for message transport over UDP.
 */
public class ToxMessagesSerializer implements Function<ToxMessage, byte[]> {

    private PingRequestSerializer pingRequestSerializer = new PingRequestSerializer();

    private PingResponseSerializer pingResponseSerializer = new PingResponseSerializer();

    @Override
    public byte[] apply(ToxMessage input) {
        byte[] serializedMessage;
        if (input instanceof PingRequest) {
            serializedMessage = pingRequestSerializer.apply((PingRequest) input);
        } else if (input instanceof PingResponse) {
            serializedMessage = pingResponseSerializer.apply((PingResponse) input);
        } else {
            serializedMessage = new byte[0];
        }
        return serializedMessage;
    }
}
