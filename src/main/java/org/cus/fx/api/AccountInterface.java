package org.cus.fx.api;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.cus.fx.account.model.AccountModel;
import org.cus.fx.util.ResponseResult;

public interface AccountInterface {

    @RequestLine("GET /account/acc?account={account}")
    @Headers("X-Ping: {token}")
    ResponseResult<AccountModel> getAccount(@Param("token") String token,@Param("account") String account);

    @RequestLine("GET /account/id?id={id}")
    ResponseResult<AccountModel> getById(@Param("id") String id);

    @Headers("Content-Type: application/json;charset=UTF-8")
    @RequestLine("POST /account/account")
    @Body("model={model}")
    ResponseResult<AccountModel> register(@Param("model") AccountModel model);

    @Headers({"Content-Type: application/json;charset=UTF-8","Accept: application/json;charset=UTF-8"})
    @RequestLine("POST /login/login")
    @Body("model={model}")
    ResponseResult<AccountModel> login(@Param("model") AccountModel model);
}
