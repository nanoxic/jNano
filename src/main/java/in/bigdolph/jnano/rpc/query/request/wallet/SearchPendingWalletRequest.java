package in.bigdolph.jnano.rpc.query.request.wallet;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.bigdolph.jnano.rpc.query.request.RpcRequest;
import in.bigdolph.jnano.rpc.query.response.RpcResponse;

public class SearchPendingWalletRequest extends RpcRequest<RpcResponse> {
    
    @Expose
    @SerializedName("wallet")
    private String walletId;
    
    
    public SearchPendingWalletRequest(String walletId) {
        super("search_pending", RpcResponse.class);
        this.walletId = walletId;
    }
    
    
    public String getWalletId() {
        return walletId;
    }
    
}