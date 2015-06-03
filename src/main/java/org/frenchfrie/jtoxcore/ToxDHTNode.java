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

package org.frenchfrie.jtoxcore;

import org.joda.time.DateTime;

import java.net.URI;

/**
 * Representation of a DHT node.
 */
public class ToxDHTNode {

    /**
     * Unique id of the node.
     */
    private int id;

    /**
     * Network location of node.
     */
    private URI uri;

    /**
     * Last time a ping (request or response) was received from this node.
     */
    private DateTime lastPingReceived;

}
