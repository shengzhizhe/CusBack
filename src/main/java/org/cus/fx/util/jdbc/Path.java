package org.cus.fx.util.jdbc;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class Path {

    public String path(){
        String s = System.getProperty("user.dir");
        s = s.split(":")[0];
        return s+":";
    }
}
