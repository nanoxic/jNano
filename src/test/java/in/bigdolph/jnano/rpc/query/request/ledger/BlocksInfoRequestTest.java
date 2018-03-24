package in.bigdolph.jnano.rpc.query.request.ledger;

import in.bigdolph.jnano.model.block.BlockSend;
import in.bigdolph.jnano.rpc.query.QueryBaseTest;
import in.bigdolph.jnano.rpc.query.response.specific.BlocksInfoResponse;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlocksInfoRequestTest extends QueryBaseTest {
    
    @Test
    public void test() {
        BlocksInfoResponse res = query(new BlocksInfoRequest(TEST_BLOCK_SEND, TEST_BLOCK_CHANGE, TEST_BLOCK_RECEIVE));
        assertNotNull(res.getBlocks());
        assertNotNull(res.getBlock(TEST_BLOCK_SEND));
        assertEquals(3, res.getBlocks().size());
        assertTrue(res.getBlock(TEST_BLOCK_SEND).getBlock() instanceof BlockSend);
    }
    
}