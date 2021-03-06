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
import org.frenchfrie.jtoxcore.protocol.messages.PingRequest;

public class PingRequestSerializer implements Function<PingRequest, byte[]> {

    @Override
    public byte[] apply(PingRequest input) {
        byte[] serializedPing = new byte[40];
        int size = 1 + 32 + 24 + 1 + 8;

        return new byte[0];
    }
}
