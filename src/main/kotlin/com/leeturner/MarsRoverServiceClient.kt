package com.leeturner

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path

@RegisterRestClient(configKey="mars-rover-api")
interface MarsRoverServiceClient {

    @GET
    @Path("/rovers")
    fun getMarsRovers(): List<MarsRover>

}

data class MarsRover(val id: Int, val name: String)
