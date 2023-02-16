
package org.foxz.android.utils;

import static org.foxz.android.utils.FzLog.Fz;
import static org.foxz.android.utils.StringUtils.camelCases;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author foxz
 */
public class StringUtilsIT {
    
    public StringUtilsIT() {
    }

    @Test
    public void testSomeMethod() {
        String t=camelCases("test1 test2, test3, test4-test5");
        assert(t.equals("Test1 Test2, Test3, Test4-Test5"));
    }
    
}
