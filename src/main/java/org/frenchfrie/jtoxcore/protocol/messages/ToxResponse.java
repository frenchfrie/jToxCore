package org.frenchfrie.jtoxcore.protocol.messages;

import org.frenchfrie.jtoxcore.protocol.ToxMessage;

/**
 * Interface for {@link ToxMessage} response answering a {@link ToxRequest} from a peer. This will be needed
 * for message level check but there will be also an URL check in the service layer.
 * <p>
 * This interface could extends ToxMessage but it is not necessary for now.
 * </p>
 */
public interface ToxResponse {

    boolean isMatchingRequest(ToxMessage message);

}
