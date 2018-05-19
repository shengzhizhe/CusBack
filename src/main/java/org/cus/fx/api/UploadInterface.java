package org.cus.fx.api;

import feign.Body;
import feign.Param;
import feign.RequestLine;
import org.cus.fx.util.ResponseResult;

/**
 * @Headers("X-Ping: {token}")
 */
public interface UploadInterface {

    @RequestLine("POST /api/upload/upload")
    @Body("token={token}&file={file}")
    ResponseResult<String> upload(@Param("token") String token, @Param("file") byte[] file);

}
