package in.bigdolph.jnano.rpc.query.request.ledger;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.bigdolph.jnano.rpc.query.request.RpcRequest;
import in.bigdolph.jnano.rpc.query.response.BlocksResponse;

public class BlockFetchUncheckedRequest extends RpcRequest<BlocksResponse> {
    
    @Expose
    @SerializedName("count")
    private int count;
    
    
    public BlockFetchUncheckedRequest(int count) {
        super("unchecked", BlocksResponse.class);
        this.count = count;
    }
    
    
    
    public int getCount() {
        return count;
    }
    
}