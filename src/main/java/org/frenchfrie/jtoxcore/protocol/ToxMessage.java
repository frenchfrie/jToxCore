package org.frenchfrie.jtoxcore.protocol;

import java.net.URI;

public interface ToxMessage {

    /**
     * Returns the unique ID of this tox message.
     *
     * @return
     */
    byte getId();

    /**
     * Returns the URI this request uses.
     */
    URI getURI();
}
