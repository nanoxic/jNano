package uk.oczadly.karl.jnano.rpc.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import uk.oczadly.karl.jnano.model.block.Block;

import java.util.Set;

public class BlockFetchUncheckedKeyResponse extends RpcResponse {
    
    @Expose
    @SerializedName("unchecked")
    private Set<UncheckedBlock> blocks;
    
    
    
    public Set<UncheckedBlock> getUncheckedBlocks() {
        return blocks;
    }
    
    
    
    public static class UncheckedBlock {
    
        @Expose
        @SerializedName("key")
        private String key;
    
        @Expose
        @SerializedName("hash")
        private String blockHash;
    
        @Expose
        @SerializedName("contents")
        private Block block;
    
        
        public String getKey() {
            return key;
        }
    
        public String getBlockHash() {
            return blockHash;
        }
    
        public Block getBlock() {
            return block;
        }
        
    }
    
}
