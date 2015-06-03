package org.frenchfrie.jtoxcore.protocol.serialization;

import com.google.common.base.Function;
import org.frenchfrie.jtoxcore.protocol.messages.PingResponse;

public class PingResponseSerializer implements Function<PingResponse, byte[]> {

    @Override
    public byte[] apply(PingResponse input) {

        return new byte[0];
    }
}
