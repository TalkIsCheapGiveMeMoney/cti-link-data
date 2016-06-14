package com.tinet.ctilink.data.service;

import com.tinet.ctilink.data.request.InvestigationGetRequest;
import com.tinet.ctilink.data.request.InvestigationQueryRequest;
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
 * @date 16/6/14 13:55
 */
@Path("v1/investigation")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CtiLinkInvestigationService {

    @POST
    @Path("get")
    ApiResult<Map<String, Object>> get(InvestigationGetRequest request);

    @POST
    @Path("query")
    ApiResult<List<Map<String, Object>>> query(InvestigationQueryRequest request);

}
