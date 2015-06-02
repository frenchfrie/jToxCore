package org.frenchfrie.jtoxcore.protocol;

import java.net.URL;

/**
 * Tox request as for example the DHT nodes request or ping request.
 */
public class ToxRequest {

   private ToxMessage message;

   private URL recipient;

   public ToxMessage getMessage() {
      return message;
   }

   public void setMessage(ToxMessage message) {
      this.message = message;
   }

   public URL getRecipient() {
      return recipient;
   }

   public void setRecipient(URL recipient) {
      this.recipient = recipient;
   }
}
