package com.tinet.ctilink.data.service;

import javax.ws.rs.*;

/**
 * @author fengwei //
 * @date 16/6/15 13:18
 */
@Path("v1/voice")
public interface CtiLinkRecordService {

    @POST
    @Path("/{recordType}/{recordFile}")
    String getPresignedUrl(@PathParam("recordType") String recordType,
                        @PathParam("recordFile") String recordFile);
}
