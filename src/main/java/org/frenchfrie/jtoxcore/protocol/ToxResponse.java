package org.frenchfrie.jtoxcore.protocol;

import java.net.URL;

/**
 * Tox response as the DHT nodes response containing the DHT nodes from a peer.
 */
public class ToxResponse {

   private ToxMessage message;

   private URL origin;

   public ToxMessage getMessage() {
      return message;
   }

   public void setMessage(ToxMessage message) {
      this.message = message;
   }

   public URL getOrigin() {
      return origin;
   }

   public void setOrigin(URL origin) {
      this.origin = origin;
   }
}
