package org.frenchfrie.jtoxcore.protocol;

import java.net.URL;

/**
 * Container for a {@link ToxMessage} as payload and its remote {@link URL}. This the envelop where the ToxMessage is the
 * letter.
 */
public class ToxMessageContainer {

    private ToxMessage message;

    private URL remoteAdress;

    public ToxMessage getMessage() {
        return message;
    }

    public void setMessage(ToxMessage message) {
        this.message = message;
    }

    public URL getRemoteAdress() {
        return remoteAdress;
    }

    public void setRemoteAdress(URL remoteAdress) {
        this.remoteAdress = remoteAdress;
    }
}
