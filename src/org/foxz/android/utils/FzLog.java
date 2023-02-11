package org.foxz.android.utils;

import static java.util.Objects.isNull;

public class FzLog {

    static public FzLog Fz = new FzLog();
    public int sz = 45;
    public int ind = 0;
    public char last;

    public String repeat(String c, int nb) {
        StringBuilder r = new StringBuilder();
        for (int n = 0; n < nb; n++) {
            r.append(c);
        }
        return r.toString();
    }

    public void rep(StringBuilder r, String c, int nb) {
        for (int n = 0; n < nb; n++) {
            r.append(c);
        }
    }

    public void ctr(StringBuilder r, String l, String c, int sz) {
        l = l.trim();
        if (!"".equals(l)) {
            l = " " + l + " ";
        } else {
            rep(r, c, sz);
        }
        int ctr = (sz - l.length()) / 2;
        int mod = (sz - l.length()) % 2;
        rep(r, c, ctr);
        r.append(l);
        if (!"".equals(c.trim())) {
            rep(r, c, ctr + mod);
        }
    }

    public int val0(String x) {
        int r = 0;
        try {
            r = Integer.valueOf(x);
        } catch (NumberFormatException err) {
            return r;
        }

        return r;
    }

    private void lpd(StringBuilder r, String msg, char p, int nb) {
        msg = msg.trim();
        nb -= msg.length();
        r.append(msg);
        rep(r, String.valueOf(p), nb);
    }

    private void rpd(StringBuilder r, String msg, char p, int nb) {
        msg = msg.trim();
        nb -= msg.length();
        rep(r, String.valueOf(p), nb);
        r.append(msg);
    }

    public void tab(StringBuilder r, String msg, int sz, int nb) {
        String[] tabs = msg.split("\t", -1);
        int tb = sz / (tabs.length + nb);
        int mod = sz % (tabs.length + nb);
        //r.append(String.valueOf(mod));
        char c='.';
        int p=tabs.length;
        for (String s : tabs) {            
            s = s.trim();
            p--;
            if (s.endsWith("|")) {
                s = s.substring(0, s.length()-1);
                //c=s.charAt(s.length());
                //s = s.substring(0, -1);                
                rpd(r, s, c, tb+mod);                
            } else {
                if (p>0){
                    c=s.charAt(s.length()-1);
                    s = s.substring(0, s.length()-1);
                    lpd(r, s, c, tb+mod);
                } else {
                    r.append(s);
                }                                
            }
            mod=0;
        }

    }
    
    public void f(String format, Object... objs){
        p(String.format(format, objs));
    }
    public void p(String msg) {
        char c = msg.charAt(0);
        StringBuilder r = new StringBuilder();
        int csz;
        csz = sz - (ind * 2);
        switch (c) {
            case '+':
                last = '+';
                msg = msg.substring(1);
                rep(r, " ", ind);
                ctr(r, msg, "-", csz);
                ind++;
                break;
            case '*':
                msg = msg.substring(1);
                if (c != last) {
                    rep(r, " ", ind);
                    ctr(r, msg, "-", csz);
                    ind++;
                } else {
                    rep(r, " ", ind - 1);
                    ctr(r, msg, "-", csz + 2);
                }

                last = c;
                break;
            case '#':
                msg = msg.substring(1);
                ind = 0;
                last = '#';
                rep(r, "#", sz);
                r.append("\n");
                ctr(r, msg, "#", sz);
                r.append("\n");
                rep(r, "#", sz);
                r.append("\n");
                break;
            case '-':
                ind--;
                break;
            case '=':
                msg = msg.substring(1);
                csz -= msg.length();
                ind--;
                rep(r, " ", ind);
                rep(r, "=", csz + 2);
                r.append(msg);
                r.append("\n");
                break;
            case ':':
                msg = msg.substring(1).trim();
                c = msg.charAt(0);
                rep(r, " ", ind);
                int y = 0;
                if ((c >= '0') && (c <= '9')) {
                    y = val0(String.valueOf(c));
                    msg = msg.substring(1).trim();
                }
                tab(r, msg, csz, y);
                break;
            default:
                rep(r, " ", ind);
                r.append(msg);
        }
        System.out.println(r.toString());
    }

}
