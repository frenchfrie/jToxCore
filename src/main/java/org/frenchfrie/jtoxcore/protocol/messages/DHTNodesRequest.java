package org.frenchfrie.jtoxcore.protocol.messages;

import org.frenchfrie.jtoxcore.protocol.ToxMessage;

import static org.frenchfrie.jtoxcore.protocol.messages.ToxMessagesIds.DHT_REQUEST_ID;

public class DHTNodesRequest implements ToxMessage{
   @Override
   public byte getId() {
      return DHT_REQUEST_ID;
   }
}
