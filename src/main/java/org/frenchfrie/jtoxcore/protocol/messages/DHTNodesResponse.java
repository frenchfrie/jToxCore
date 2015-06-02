package org.frenchfrie.jtoxcore.protocol.messages;

import org.frenchfrie.jtoxcore.protocol.ToxMessage;

import static org.frenchfrie.jtoxcore.protocol.messages.ToxMessagesIds.DHT_RESPONSE_ID;

public class DHTNodesResponse implements ToxMessage {
   @Override
   public byte getId() {
      return DHT_RESPONSE_ID;
   }
}