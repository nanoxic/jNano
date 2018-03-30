package in.bigdolph.jnano.rpc.query.request.ledger;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.bigdolph.jnano.rpc.query.request.RpcRequest;
import in.bigdolph.jnano.rpc.query.response.BalanceResponse;

public class AccountBalanceRequest extends RpcRequest<BalanceResponse> {
    
    @Expose
    @SerializedName("account")
    private String account;
    
    
    public AccountBalanceRequest(String account) {
        super("account_balance", BalanceResponse.class);
        this.account = account;
    }
    
    
    
    public String getAccount() {
        return account;
    }
    
}
