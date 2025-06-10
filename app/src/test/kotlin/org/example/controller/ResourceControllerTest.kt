package org.example.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(ResourceController::class)
class ResourceControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `should return hello message`() {
        mockMvc
            .perform(get("/api/hello"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.message").value("Hello World!"))
    }
}
