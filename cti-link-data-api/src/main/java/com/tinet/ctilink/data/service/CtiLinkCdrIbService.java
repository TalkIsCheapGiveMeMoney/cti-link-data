package com.tinet.ctilink.data.service;

import com.tinet.ctilink.data.request.CdrGetRequest;
import com.tinet.ctilink.data.request.CdrQueryRequest;
import com.tinet.ctilink.data.response.ApiResult;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * @author fengwei //
 * @date 16/6/13 19:28
 */
@Path("v1/cdrIb")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CtiLinkCdrIbService {

    @POST
    @Path("get")
    ApiResult<Map<String, Object>> get(CdrGetRequest request);

    @POST
    @Path("query")
    ApiResult<List<Map<String, Object>>> query(CdrQueryRequest request);
}
