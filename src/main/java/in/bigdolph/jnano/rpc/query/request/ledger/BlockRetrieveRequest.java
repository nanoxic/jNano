package in.bigdolph.jnano.rpc.query.request.ledger;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.bigdolph.jnano.rpc.query.request.RpcRequest;
import in.bigdolph.jnano.rpc.query.response.BlockResponse;

public class BlockRetrieveRequest extends RpcRequest<BlockResponse> {
    
    @Expose
    @SerializedName("hash")
    private String blockHash;
    
    
    public BlockRetrieveRequest(String blockHash) {
        super("block", BlockResponse.class);
        this.blockHash = blockHash;
    }
    
    
    
    public String getBlockHash() {
        return blockHash;
    }
    
}