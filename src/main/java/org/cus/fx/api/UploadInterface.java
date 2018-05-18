package org.cus.fx.api;

import feign.Body;
import feign.Param;
import feign.RequestLine;
import org.cus.fx.util.ResponseResult;

import java.util.List;

public interface UploadInterface {
    @RequestLine("POST /api/upload/upload")
    @Body("list={list}")
    ResponseResult<List> updateAdderss(@Param("list") List list);
}
