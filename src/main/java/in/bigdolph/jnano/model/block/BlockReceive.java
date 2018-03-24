package in.bigdolph.jnano.model.block;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class BlockReceive extends Block {
    
    @Expose
    @SerializedName("previous")
    private String previousBlockHash;
    
    @Expose
    @SerializedName("source")
    private String sourceBlockHash;
    
    
    public BlockReceive() {
        super(BlockType.RECEIVE);
    }
    
    public BlockReceive(String signature, String workSolution, String previousBlockHash, String sourceBlockHash) {
        super(BlockType.RECEIVE, signature, workSolution);
        this.previousBlockHash = previousBlockHash;
        this.sourceBlockHash = sourceBlockHash;
    }
    
    
    
    public final String getPreviousBlockHash() {
        return previousBlockHash;
    }
    
    public final String getSourceBlockHash() {
        return sourceBlockHash;
    }
    
}
