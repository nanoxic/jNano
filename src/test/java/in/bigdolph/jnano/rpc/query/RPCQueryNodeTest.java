package in.bigdolph.jnano.rpc.query;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.bigdolph.jnano.rpc.query.exception.RPCQueryException;
import in.bigdolph.jnano.rpc.query.request.RPCRequest;
import in.bigdolph.jnano.rpc.query.request.node.NodeVersionRequest;
import in.bigdolph.jnano.rpc.query.request.wallet.AccountCreateRequest;
import in.bigdolph.jnano.rpc.query.request.wallet.WalletChangePasswordRequest;
import in.bigdolph.jnano.rpc.query.request.wallet.WalletLockRequest;
import in.bigdolph.jnano.rpc.query.request.wallet.WalletUnlockRequest;
import in.bigdolph.jnano.rpc.query.response.RPCResponse;
import in.bigdolph.jnano.rpc.query.response.NodeVersionResponse;
import in.bigdolph.jnano.tests.NodeTests;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

public class RPCQueryNodeTest {
    
    private TestNode node;
    
    public RPCQueryNodeTest() throws Exception {
        this.node = new TestNode();
    }
    
    
//    @Test //TODO
//    public void ayy() throws Exception {
//        this.node.processRequest(new WalletLockRequest("07E7898B0E4F63558039B6E54D073313263942B7D51A06443EFC54FB88B540C5"));
//        this.node.processRequest(new AccountCreateRequest("07E7898B0E4F63558039B6E54D073313263942B7D51A06443EFC54FB88B540C5"));
//    }
    
    
    @Test
    @Category(NodeTests.class)
    public void testSyncQuery() throws Exception {
        //Test valid query
        NodeVersionResponse res = node.processRequest(new NodeVersionRequest());
        assertNotNull(res);
        System.out.println(res.getNodeVendor());
        
        //Test invalid query
        try {
            RPCResponse invalidRes = node.processRequest(new TestRequest("invalid_command_ayy_lmao"));
            fail("Invalid command was processed");
        } catch (RPCQueryException e) {}
    }
    
    @Test
    @Category(NodeTests.class)
    public void testAsyncQuery() throws Exception {
        //Test valid query
        TestCallback callback = new TestCallback();
        Future<RPCResponse> futureRes = node.processRequestAsync(new TestRequest("version"), 2500, callback);
        assertNotNull(futureRes);
        while(!callback.processed); //Wait for query to respond
        System.out.println("Async query processed");
        assertNull(callback.exception);
        assertNotNull(callback.response);
        
        //Test valid query
        callback = new TestCallback();
        futureRes = node.processRequestAsync(new TestRequest("invalid_command_ayy_lmao"), 2500, callback);
        assertNotNull(futureRes);
        while(!callback.processed); //Wait for query to respond
        System.out.println("Async query processed");
        assertNotNull(callback.exception);
        assertTrue(callback.exception instanceof RPCQueryException);
        assertNull(callback.response);
    }
    
    
    private static class TestCallback implements QueryCallback<RPCResponse> {
        volatile boolean processed = false;
        volatile RPCResponse response;
        volatile Exception exception;
        
        @Override
        public void onResponse(RPCResponse response) {
            this.response = response;
            this.processed = true;
        }
        
        @Override
        public void onFailure(Exception ex) {
            this.exception = ex;
            this.processed = true;
        }
    }
    
    public static class TestRequest extends RPCRequest<RPCResponse> {
        public TestRequest(String cmd) {
            super(cmd, RPCResponse.class);
        }
    }
    
    
    
    @Test
    public void testEmptyArray() throws Exception {
        TestNode node = new TestNode();
        ArrayTestResponse deserialized;
        
        //2 items
        System.out.println("Test 2 items");
        deserialized = node.getGsonInstance().fromJson("{arr:[1,2]}", ArrayTestResponse.class);
        assertNotNull(deserialized);
        assertNotNull(deserialized.array);
        assertEquals(2, deserialized.array.length);
    
        //0 items
        System.out.println("Test empty array");
        deserialized = node.getGsonInstance().fromJson("{arr:[]}", ArrayTestResponse.class);
        assertNotNull(deserialized);
        assertNotNull(deserialized.array);
        assertEquals(0, deserialized.array.length);
    
        //empty string
        System.out.println("Test empty string");
        deserialized = node.getGsonInstance().fromJson("{arr:\"\"}", ArrayTestResponse.class);
        assertNotNull(deserialized);
        assertNotNull(deserialized.array);
        assertEquals(0, deserialized.array.length);
    }
    
    @Test
    public void testEmptyCollection() throws Exception {
        TestNode node = new TestNode();
        CollectionTestResponse deserialized;
        
        //2 items
        System.out.println("Test 2 items");
        deserialized = node.getGsonInstance().fromJson("{col:[1,2]}", CollectionTestResponse.class);
        assertNotNull(deserialized);
        assertNotNull(deserialized.col);
        assertEquals(2, deserialized.col.size());
        
        //0 items
        System.out.println("Test empty collection");
        deserialized = node.getGsonInstance().fromJson("{col:[]}", CollectionTestResponse.class);
        assertNotNull(deserialized);
        assertNotNull(deserialized.col);
        assertEquals(0, deserialized.col.size());
        
        //empty string
        System.out.println("Test empty string");
        deserialized = node.getGsonInstance().fromJson("{col:\"\"}", CollectionTestResponse.class);
        assertNotNull(deserialized);
        assertNotNull(deserialized.col);
        assertEquals(0, deserialized.col.size());
    }
    
    @Test
    public void testEmptyMap() throws Exception {
        TestNode node = new TestNode();
        MapTestResponse deserialized;
        
        //2 items
        System.out.println("Test 2 items");
        deserialized = node.getGsonInstance().fromJson("{map:{1:1,2:2}}", MapTestResponse.class);
        assertNotNull(deserialized);
        assertNotNull(deserialized.map);
        assertEquals(2, deserialized.map.size());
        
        //0 items
        System.out.println("Test empty map");
        deserialized = node.getGsonInstance().fromJson("{map:{}}", MapTestResponse.class);
        assertNotNull(deserialized);
        assertNotNull(deserialized.map);
        assertEquals(0, deserialized.map.size());
        
        //empty string
        System.out.println("Test empty string");
        deserialized = node.getGsonInstance().fromJson("{map:\"\"}", MapTestResponse.class);
        assertNotNull(deserialized);
        assertNotNull(deserialized.map);
        assertEquals(0, deserialized.map.size());
    }
    
    
    
    
    private static class ArrayTestResponse {
        @Expose
        @SerializedName("arr")
        public int[] array;
    }
    
    private static class MapTestResponse {
        @Expose
        @SerializedName("map")
        public Map<Integer, Integer> map;
    }
    
    private static class CollectionTestResponse {
        @Expose
        @SerializedName("col")
        public List<Integer> col;
    }
    
}