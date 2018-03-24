package in.bigdolph.jnano.rpc.query.request.node;

import in.bigdolph.jnano.rpc.query.request.RPCRequest;
import in.bigdolph.jnano.rpc.query.response.RPCResponse;
import in.bigdolph.jnano.rpc.query.response.specific.NodeVersionResponse;

public class NodePeerBootstrapInitializeRequest extends RPCRequest<RPCResponse> {
    
    public NodePeerBootstrapInitializeRequest() {
        super("bootstrap_any", RPCResponse.class);
    }
    
}
