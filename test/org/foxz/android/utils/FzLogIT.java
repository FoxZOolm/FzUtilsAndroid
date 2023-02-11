package org.foxz.android.utils;

import static org.foxz.android.utils.FzLog.Fz;
import org.junit.Test;

/**
 *
 * @author foxz
 */
public class FzLogIT {

    public FzLogIT() {
    }

    @Test
    public void testSomeMethod() {
        Fz.p("# FZ.Log");
        Fz.p("+ grand");
        Fz.p("* add select");
        Fz.p("element11");
        Fz.p("= Ok");
        Fz.p("* tab");
        Fz.p(": Name.\t: lolo");
        Fz.p(": total.\t1000|");
        Fz.p(": total.\t10000|");
        Fz.p(":1 total.\t1000|");
        Fz.p(":1 total.\t10000|");
        Fz.p(":2 total.\t1000|");
        Fz.p(":2 total.\t10000|");
        Fz.p("* tabs");
        Fz.p(": name.\tlolo.\t1000|");
        Fz.p(": name.\tlolos.\t10000|");
        Fz.p(": total.\t10000|\t10000|");
        Fz.p(": total.\t1000|\t100000|");
    }
}
