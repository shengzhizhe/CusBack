package org.cus.fx.api;

import feign.Body;
import feign.Param;
import feign.RequestLine;
import org.cus.fx.util.ResponseResult;

/**
 * @Headers("X-Ping: {token}")
 */
public interface SpglInterface {

    @RequestLine("POST /api/commodity/commodity")
    @Body("json={json}")
    ResponseResult<String> add(@Param("json") String json);

    @RequestLine("POST /api/register/register")
    @Body("json={json}")
    ResponseResult<String> register(@Param("json") String json);

}
