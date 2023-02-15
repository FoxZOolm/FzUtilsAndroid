package org.foxz.android.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author foxz
 */
public class StringUtils {

    static Pattern rxw=Pattern.compile("\\w+");
    static public String camelCase(String s) {
        s=s.trim();
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
    static public String camelCases(String s){        
        Matcher m=rxw.matcher(s);
        String res="";
        int last=0;
        while (m.find()){
            if (last>0){
                res+=s.substring(last,m.start());
            }            
            res+=camelCase(m.group());
            last=m.end();
        }
        return res;
    }
}
