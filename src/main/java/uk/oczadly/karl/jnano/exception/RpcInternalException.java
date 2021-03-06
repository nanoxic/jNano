package uk.oczadly.karl.jnano.exception;

/**
 * Thrown if the node encounters an internal error.
 */
public class RpcInternalException extends RpcException {
    
    public RpcInternalException(String message) {
        super(message);
    }
    
}
