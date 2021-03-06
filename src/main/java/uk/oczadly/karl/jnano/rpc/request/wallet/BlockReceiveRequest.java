package uk.oczadly.karl.jnano.rpc.request.wallet;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import uk.oczadly.karl.jnano.rpc.request.RpcRequest;
import uk.oczadly.karl.jnano.rpc.response.BlockHashResponse;

public class BlockReceiveRequest extends RpcRequest<BlockHashResponse> {
    
    @Expose
    @SerializedName("wallet")
    private String walletId;
    
    @Expose
    @SerializedName("account")
    private String account;
    
    @Expose
    @SerializedName("block")
    private String blockHash;
    
    @Expose
    @SerializedName("work")
    private String workSolution;
    
    
    public BlockReceiveRequest(String walletId, String account, String blockHash) {
        this(walletId, account, blockHash, null);
    }
    
    public BlockReceiveRequest(String walletId, String account, String blockHash, String workSolution) {
        super("receive", BlockHashResponse.class);
        this.walletId = walletId;
        this.account = account;
        this.blockHash = blockHash;
        this.workSolution = workSolution;
    }
    
    
    
    public String getWalletId() {
        return walletId;
    }
    
    public String getAccount() {
        return account;
    }
    
    public String getBlockHash() {
        return blockHash;
    }
    
    public String getWorkSolution() {
        return workSolution;
    }
    
}
