package org.frenchfrie.jtoxcore.protocol.serialization;

import com.google.common.base.Function;
import org.frenchfrie.jtoxcore.protocol.ToxMessage;
import org.frenchfrie.jtoxcore.protocol.messages.PingRequest;
import org.frenchfrie.jtoxcore.protocol.messages.PingResponse;

/**
 * Implementation of serialization for message transport over UDP.
 */
public class ToxMessagesSerializer implements Function<ToxMessage, byte[]> {

    private PingRequestSerializer pingRequestSerializer = new PingRequestSerializer();

    private PingResponseSerializer pingResponseSerializer = new PingResponseSerializer();

    @Override
    public byte[] apply(ToxMessage input) {
        byte[] serializedMessage;
        if (input instanceof PingRequest) {
            serializedMessage = pingRequestSerializer.apply((PingRequest) input);
        } else if (input instanceof PingResponse) {
            serializedMessage = pingResponseSerializer.apply((PingResponse) input);
        } else {
            serializedMessage = new byte[0];
        }
        return serializedMessage;
    }
}
