package org.frenchfrie.jtoxcore.protocol.serialization;

import com.google.common.base.Function;
import org.frenchfrie.jtoxcore.protocol.messages.PingRequest;

public class PingRequestSerializer implements Function<PingRequest, byte[]> {

    @Override
    public byte[] apply(PingRequest input) {

        return new byte[0];
    }
}
