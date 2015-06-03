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

import java.util.HashSet;
import java.util.Set;

public class FriendsManager {

    private Set<Friend> friendsList = new HashSet<>();


    public void addFriend(Messenger messager, byte[] address, byte[] data) {

        // checks PK is valid

        // checks PK is not own

        // checks message is not empty

        // checks the address checksum field against the real checksum

        // Add the friend

        // init the connection: the big deal happens here (cf new_friend_connection)
        // => If the PK correspond to an already opened connection, only increase lock count
        // =>


        // if connection OK: set the friend status to connected

        // ultimately verify if the friend is connected and send a ONLINE packet

    }

    /**
     * Tox is a messager.
     */
    public static final class Messenger {

    }

}
