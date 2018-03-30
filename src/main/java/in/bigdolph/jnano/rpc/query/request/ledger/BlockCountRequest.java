package in.bigdolph.jnano.rpc.query.request.ledger;

import in.bigdolph.jnano.rpc.query.request.RPCRequest;
import in.bigdolph.jnano.rpc.query.response.BlockCountResponse;

public class BlockCountRequest extends RPCRequest<BlockCountResponse> {
    
    public BlockCountRequest() {
        super("block_count", BlockCountResponse.class);
    }
    
}
