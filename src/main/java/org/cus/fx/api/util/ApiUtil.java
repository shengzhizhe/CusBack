package org.cus.fx.api.util;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.cus.fx.api.AccountInterface;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class ApiUtil {

    public AccountInterface getAccountInterface(String url) {
        url = url.trim().equals("") ? "http://39.106.33.113:9002/account" : url;
        return Feign.builder().encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(AccountInterface.class, url);
    }
}
