package org.cus.fx.api;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.cus.fx.api.model.TokenModel;
import org.cus.fx.util.ResponseResult;

public interface TokenInterface {

    @Headers("Content-Type: application/json;charset=UTF-8")
    @RequestLine("POST /token/token")
    @Body("model={model}")
    ResponseResult<TokenModel> add(@Param("model") TokenModel model);

    @RequestLine("POST /token/updateToken")
    @Body("token={token}")
    ResponseResult<TokenModel> updateToken(@Param("token") String token);

    @RequestLine("GET /token/token/{token}")
    ResponseResult<TokenModel> getByToken(@Param("token") String token);
}
