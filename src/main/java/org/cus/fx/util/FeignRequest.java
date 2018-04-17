package org.cus.fx.util;

import org.cus.fx.util.jdbc.JDBCUtils;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class FeignRequest {

    public String URL() {
        try {
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(is);
            return properties.getProperty("feign-url");
        } catch (Exception e) {
            return "";
        }
    }
}
