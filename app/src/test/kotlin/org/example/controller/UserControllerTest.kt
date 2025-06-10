package org.example.controller

import com.fasterxml.jackson.databind.ObjectMapper
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.example.domain.User
import org.example.domain.UserId
import org.example.service.UserCreateRequest
import org.example.service.UserService
import org.example.service.UserUpdateRequest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class UserControllerTest {
    private lateinit var mockMvc: MockMvc
    private lateinit var userService: UserService
    private lateinit var objectMapper: ObjectMapper

    @BeforeEach
    fun setUp() {
        userService = mockk()
        objectMapper = ObjectMapper()
        mockMvc = MockMvcBuilders.standaloneSetup(UserController(userService)).build()
    }

    @Test
    fun `should create user successfully`() {
        every { userService.create(any()) } returns UserId(1L)

        val createRequest = UserController.UserCreateRequestForm(
            name = "John Doe",
            age = 30
        )

        mockMvc
            .perform(
                post("/api/v1/users")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(createRequest))
            )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id").value(1))

        verify { userService.create(UserCreateRequest(name = "John Doe", age = 30)) }
    }

    @Test
    fun `should get user by id successfully`() {
        val user = User(
            id = UserId(1L),
            name = "John Doe",
            age = 30
        )
        every { userService.findUserById(UserId(1L)) } returns user

        mockMvc
            .perform(get("/api/v1/users/1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("John Doe"))
            .andExpect(jsonPath("$.age").value(30))
    }

    @Test
    fun `should return 404 when user not found`() {
        every { userService.findUserById(UserId(1L)) } returns null

        mockMvc
            .perform(get("/api/v1/users/1"))
            .andExpect(status().isNotFound)
    }

    @Test
    fun `should update user successfully`() {
        justRun { userService.update(any(), any()) }
        
        val updateRequest = UserController.UserUpdateRequestForm(
            name = "Jane Doe",
            age = 25
        )

        mockMvc
            .perform(
                put("/api/v1/users/1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(updateRequest))
            )
            .andExpect(status().isOk)

        verify { userService.update(id = 1L, request = UserUpdateRequest(name = "Jane Doe", age = 25)) }
    }

    @Test
    fun `should delete user successfully`() {
        justRun { userService.delete(any()) }
        
        mockMvc
            .perform(delete("/api/v1/users/1"))
            .andExpect(status().isNoContent)

        verify { userService.delete(UserId(1L)) }
    }
}