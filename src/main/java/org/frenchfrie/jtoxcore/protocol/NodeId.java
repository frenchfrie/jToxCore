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

package org.frenchfrie.jtoxcore.protocol;

import java.util.Arrays;

import static com.google.common.base.Preconditions.checkArgument;

public class NodeId {

    public static final int NODE_ID_BYTE_SIZE = 32;
    private char[] nodeId;

    public NodeId(char[] nodeId) {
        checkArgument(nodeId.length == NODE_ID_BYTE_SIZE, "A node ID must be %i bytes long.", NODE_ID_BYTE_SIZE);
        this.nodeId = Arrays.copyOf(nodeId, NODE_ID_BYTE_SIZE);
    }

    public char[] getNodeId() {
        return nodeId;
    }

}
