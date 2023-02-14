package org.foxz.android.utils;

import org.foxz.android.utils.FileUils.ParsedFile;
import static org.foxz.android.utils.FileUils.parseFile;
import static org.foxz.android.utils.FileUils.pathLast;
import static org.foxz.android.utils.FzLog.Fz;

import org.junit.Test;

/**
 *
 * @author foxz
 */
public class FileUilsIT {

    public FileUilsIT() {
    }

    @Test
    public void testPathLast() {
        Fz.p("# PathLast");
        String path="/path1/path2/path3/";
        String res;
        res=pathLast(path,"path3");
        Fz.f(": %s.\t%s", path,res);
        assert (res.equals("/path1/path2/"));
        res=pathLast(path,"path2");
        Fz.f(": %s.\t%s", path,res);        
        assert (res.equals("/path1/"));
        res=pathLast(path,"path1");
        Fz.f(": %s.\t%s", path,res);        
        assert (res.equals("/"));
    }

    @Test
    public void testParseFile() {
        Fz.p("# parseFile ");
        ParsedFile res;
        res = parseFile("testname");
        Fz.f(": \t<%s> %s [%s]", res.path, res.name, res.ext);
        assert (res.toString().equals("testname"));
        res = parseFile("testname.ext");
        Fz.f(": \t<%s> %s [%s]", res.path, res.name, res.ext);
        assert (res.name.equals("testname")
                && res.ext.equals(".ext"));
        res = parseFile("./testname.ext");
        Fz.f(": \t<%s> %s [%s]", res.path, res.name, res.ext);
        assert (res.name.equals("testname")
                && res.ext.equals(".ext")
                && res.path.equals("./"));
        res = parseFile("//path1/path2/testname");
        Fz.f(": \t<%s> %s [%s]", res.path, res.name, res.ext);
        assert (res.name.equals("testname")
                && res.path.equals("//path1/path2/")
                && res.ext.equals(""));
        res = parseFile("//path1/path2/testname.four");
        Fz.f(": \t<%s> %s [%s]", res.path, res.name, res.ext);
        assert (res.name.equals("testname")
                && res.path.equals("//path1/path2/")
                && res.ext.equals(".four"));
    }

}
