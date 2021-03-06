package uk.oczadly.karl.jnano.rpc.request.wallet;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import uk.oczadly.karl.jnano.rpc.request.RpcRequest;
import uk.oczadly.karl.jnano.rpc.response.ValidationResponse;

public class WalletPasswordValidateRequest extends RpcRequest<ValidationResponse> {
    
    @Expose
    @SerializedName("wallet")
    private String walletId;
    
    
    public WalletPasswordValidateRequest(String walletId) {
        super("password_valid", ValidationResponse.class);
        this.walletId = walletId;
    }
    
    
    
    public String getWalletId() {
        return walletId;
    }
    
}
