package uk.oczadly.karl.jnano.rpc.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import uk.oczadly.karl.jnano.rpc.response.RpcResponse;

public abstract class RpcRequest<R extends RpcResponse> {
    
    @Expose
    @SerializedName("action")
    private String actionCommand;
    
    private Class<R> responseClass;
    
    
    public RpcRequest(String actionCommand, Class<R> responseClass) {
        this.actionCommand = actionCommand;
        this.responseClass = responseClass;
    }
    
    
    
    public final String getActionCommand() {
        return this.actionCommand;
    }
    
    public final Class<R> getResponseClass() {
        return this.responseClass;
    }
    
}
