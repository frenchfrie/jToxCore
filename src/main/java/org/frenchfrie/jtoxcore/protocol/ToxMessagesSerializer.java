package org.frenchfrie.jtoxcore.protocol;

import com.google.common.base.Function;

public interface ToxMessagesSerializer<T> extends Function<ToxMessage, T> {

    T serialize(ToxMessage message);

}
