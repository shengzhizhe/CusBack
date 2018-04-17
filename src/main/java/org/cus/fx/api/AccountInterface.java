package org.cus.fx.api;

import feign.Body;
import feign.Param;
import feign.RequestLine;
import org.cus.fx.util.ResponseResult;

/**
 * @Headers("X-Ping: {token}")
 */
public interface AccountInterface {

    @RequestLine("POST /api/account/login")
    @Body("json={json}")
    ResponseResult<String> login(@Param("json") String json);

    @RequestLine("POST /api/register/register")
    @Body("json={json}")
    ResponseResult<String> register(@Param("json") String json);

}
