package in.bigdolph.jnano.rpc.query.request.compute;

import in.bigdolph.jnano.rpc.query.QueryBaseTest;
import in.bigdolph.jnano.rpc.query.response.UnitConversionResponse;
import in.bigdolph.jnano.tests.NodeTests;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class UnitConversionRequestTest extends QueryBaseTest {
    
    @Test
    @Category(NodeTests.class)
    public void test() {
        //1 MRAI to RAW
        UnitConversionResponse res = query(new UnitConversionRequest(UnitConversionRequest.Conversion.MRAI_TO_RAW, BigInteger.ONE));
        assertEquals("1000000000000000000000000000000", res.getConvertedAmount().toString());
    
        //1000000000000000000000000000000 RAW to MRAI
        res = query(new UnitConversionRequest(UnitConversionRequest.Conversion.MRAI_FROM_RAW, new BigInteger("1000000000000000000000000000000")));
        assertEquals("1", res.getConvertedAmount().toString());
    }
    
}