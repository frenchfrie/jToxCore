package org.frenchfrie.jtoxcore.protocol;

public interface ToxMessagesSerializer {

    byte[] serialize(ToxMessage message);

}
