package in.bigdolph.jnano.rpc.query.request.ledger;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.bigdolph.jnano.rpc.query.request.RpcRequest;
import in.bigdolph.jnano.rpc.query.response.BlocksResponse;

public class BlocksRetrieveRequest extends RpcRequest<BlocksResponse> {
    
    @Expose
    @SerializedName("hashes")
    private String[] blockHashes;
    
    
    public BlocksRetrieveRequest(String... blockHashes) {
        super("blocks", BlocksResponse.class);
        this.blockHashes = blockHashes;
    }
    
    
    
    public String[] getBlockHashes() {
        return blockHashes;
    }
    
}