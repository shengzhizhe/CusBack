package org.cus.fx.util.feign;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.cus.fx.api.AccountInterface;

/**
 * @author ld
 * @name feign 链接工具
 * @table
 * @remarks
 */
public class FeignUtil {

    public Object getInterface(String url) {
        url = (url==null || url.trim().equals("")) ? "http://39.106.33.113:9002" : url;
        return Feign.builder().encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(AccountInterface.class, url);
    }
}
