package org.cus.fx.api;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.cus.fx.util.ResponseResult;

import java.io.FileInputStream;

public interface UploadInterface {

    @Headers(value = {"Content-Type:multipart/form-data"})
    @RequestLine("POST /api/upload/upload")
    @Body("file={file}")
    ResponseResult<String> uploadFile(@Param("file") FileInputStream file);
}
