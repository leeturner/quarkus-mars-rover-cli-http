package com.leeturner

import org.junit.jupiter.api.Test
import io.quarkiverse.wiremock.devservice.ConnectWireMock
import io.quarkus.test.junit.main.QuarkusMainLauncher
import io.quarkus.test.junit.main.QuarkusMainTest
import org.junit.jupiter.api.Assertions.assertTrue

@ConnectWireMock
@QuarkusMainTest
class MarRoverCliCommandTest {

    @Test
    fun `mars rover cli command returns all rovers`(launcher: QuarkusMainLauncher) {
        val result = launcher.launch()
        assertTrue(result.output.contains("Mars Rovers:"))
        assertTrue(result.output.contains("0 - Spirit - Test"))
        assertTrue(result.output.contains("1 - Opportunity - Test"))
        assertTrue(result.output.contains("2 - Curiosity - Test"))
        assertTrue(result.output.contains("3 - Perseverance - Test"))
        assertTrue(result.output.contains("4 - Sojourner - Test"))
    }
    
}