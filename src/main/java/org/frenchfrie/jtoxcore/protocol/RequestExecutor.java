package org.frenchfrie.jtoxcore.protocol;

/**
 * Executor that synchronously sends a request and expect a response.
 */
public interface RequestExecutor {

    ToxMessageContainer executeRequest(ToxMessageContainer request);

}
