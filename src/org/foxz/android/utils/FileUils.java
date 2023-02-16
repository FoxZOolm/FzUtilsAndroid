
package org.foxz.android.utils;

import java.io.File;

/**
 *
 * @author foxz
 */
public class FileUils {
    static public class ParsedFileName{
        public String path="";
        public String name;
        public String ext="";
        @Override
        public String toString(){
            return path+name+ext;
        }
    }
    static public ParsedFileName parseFileName(String n){
        ParsedFileName res=new ParsedFileName();
        n=dePosix(n);
        int y=n.lastIndexOf(File.separatorChar);        
        if (y>=0) {
            res.path=n.substring(0,y+1);
            n=n.substring(y+1);
        }
        int z=n.lastIndexOf(".");
        if (z>=0) {
            res.ext=n.substring(z,n.length());
        } else {
            z=n.length();
        }
        res.name=n.substring(0,z);
        return res;
    }
    static String dePosix(String n){
        return n.replaceAll("/", String.valueOf(File.separatorChar));
    }
    static String pathLast(String path,String last){
        path=dePosix(path);
        last=dePosix(last);
        if (!last.startsWith(File.separator)){
            last=File.separator+last;
        }
        if (!last.endsWith(File.separator)){
            last+=File.separator;
        }
        if (!path.endsWith(File.separator)){
            path+=File.separator;
        }
        int y=path.lastIndexOf(last);
        if (y>=0) return path.substring(0,y+1);
        return null;
    }
}
