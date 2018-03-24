package in.bigdolph.jnano.rpc.query.request.ledger;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.bigdolph.jnano.rpc.query.request.RPCRequest;
import in.bigdolph.jnano.rpc.query.response.specific.BlockHistoryResponse;
import in.bigdolph.jnano.rpc.query.response.specific.NodeVersionResponse;

public class BlockHistoryRequest extends RPCRequest<BlockHistoryResponse> {
    
    @Expose
    @SerializedName("hash")
    private String blockHash;
    
    @Expose
    @SerializedName("count")
    private int count;
    
    
    public BlockHistoryRequest(String blockHash, int count) {
        super("history", BlockHistoryResponse.class);
        this.blockHash = blockHash;
        this.count = count;
    }
    
    
    
    public String getBlockHash() {
        return blockHash;
    }
    
    public int getCount() {
        return count;
    }
    
}