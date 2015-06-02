package org.frenchfrie.jtoxcore.protocol.serialization;

import org.frenchfrie.jtoxcore.protocol.ToxMessage;
import org.frenchfrie.jtoxcore.protocol.ToxMessagesSerializer;
import org.frenchfrie.jtoxcore.protocol.messages.PingRequest;

/**
 * Implementation of serialization for message transport over UDP.
 */
public class ToxMessagesSerializerImpl implements ToxMessagesSerializer<byte[]> {

   private PingRequestSerializer pingRequestSerializer;

   @Override
   public byte[] serialize(ToxMessage message) {
      byte[] serializedMessage;
      if (message instanceof PingRequest){

      }
      return serializedMessage;
   }


}
