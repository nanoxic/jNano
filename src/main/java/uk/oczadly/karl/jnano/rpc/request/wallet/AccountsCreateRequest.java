package uk.oczadly.karl.jnano.rpc.request.wallet;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import uk.oczadly.karl.jnano.rpc.request.RpcRequest;
import uk.oczadly.karl.jnano.rpc.response.AccountsResponse;

public class AccountsCreateRequest extends RpcRequest<AccountsResponse> {
    
    @Expose
    @SerializedName("wallet")
    private String walletId;
    
    @Expose
    @SerializedName("count")
    private int count;
    
    @Expose
    @SerializedName("work")
    private boolean generateWork;
    
    
    public AccountsCreateRequest(String walletId, int count) {
        this(walletId, count, false);
    }
    
    public AccountsCreateRequest(String walletId, int count, boolean generateWork) {
        super("accounts_create", AccountsResponse.class);
        this.walletId = walletId;
        this.count = count;
        this.generateWork = generateWork;
    }
    
    
    public String getWalletId() {
        return walletId;
    }
    
    public int getCount() {
        return count;
    }
    
    public boolean getGenerateWork() {
        return generateWork;
    }
    
}
