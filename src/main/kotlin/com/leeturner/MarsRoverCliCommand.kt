package com.leeturner

import org.eclipse.microprofile.rest.client.inject.RestClient
import picocli.CommandLine.Command

@Command(name = "rovers", mixinStandardHelpOptions = true)
class MarsRoverCliCommand : Runnable {
    
    @RestClient
    lateinit var marsRoverServiceClient: MarsRoverServiceClient
    
    override fun run() {
        println("Mars Rovers:")
        println()
        marsRoverServiceClient.getMarsRovers().forEach { rover ->  (println("${rover.id} - ${rover.name}")) }
    }

}