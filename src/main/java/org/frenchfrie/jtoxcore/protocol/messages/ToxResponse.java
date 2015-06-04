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

/**
 * Interface for {@link ToxMessage} response answering a {@link ToxRequest} from a peer. This will be needed
 * for message level check but there will be also an URL check in the service layer.
 * <p>
 * This interface could extends ToxMessage but it is not necessary for now.
 * </p>
 */
public interface ToxResponse extends ToxMessage {

    boolean isMatchingRequest(ToxRequest request);

}
