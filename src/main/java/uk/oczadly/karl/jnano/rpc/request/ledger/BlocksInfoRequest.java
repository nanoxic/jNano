package uk.oczadly.karl.jnano.rpc.request.ledger;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import uk.oczadly.karl.jnano.rpc.request.RpcRequest;
import uk.oczadly.karl.jnano.rpc.response.BlocksInfoResponse;

public class BlocksInfoRequest extends RpcRequest<BlocksInfoResponse> {
    
    @Expose
    @SerializedName("hashes")
    private String[] blockHashes;
    
    @Expose
    @SerializedName("pending")
    private boolean fetchPending = true;
    
    @Expose
    @SerializedName("source")
    private boolean fetchSource = true;
    
    @Expose
    @SerializedName("balance")
    private boolean fetchBalance = true;
    
    
    public BlocksInfoRequest(String... blockHashes) {
        super("blocks_info", BlocksInfoResponse.class);
        this.blockHashes = blockHashes;
    }
    
    
    
    public String[] getBlockHashes() {
        return blockHashes;
    }
    
}
