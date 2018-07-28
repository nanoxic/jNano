package in.bigdolph.jnano.rpc.query.request.ledger;

import in.bigdolph.jnano.rpc.query.request.RpcRequest;
import in.bigdolph.jnano.rpc.query.response.BlockCountResponse;

public class BlockCountRequest extends RpcRequest<BlockCountResponse> {
    
    public BlockCountRequest() {
        super("block_count", BlockCountResponse.class);
    }
    
}