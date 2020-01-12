package com.soska.myapi.user;

import com.soska.myapi.dto.UserDto;
import com.soska.myapi.dto.UserWithDetailsDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        this.base = new URL("http://localhost:" + port + "/users");
    }

    @Test
    public void getUsers(){
        ResponseEntity<UserDto[]> response = template
                .getForEntity(base.toString(), UserDto[].class);
        assertEquals(10, Objects.requireNonNull(response.getBody()).length);
    }

    @Test
    public void getUserByIdWithCorrectId(){
        ResponseEntity<UserWithDetailsDto> response = template
                .getForEntity(base.toString() + "/1", UserWithDetailsDto.class);
        assertEquals("Jan", response.getBody().getFirstName());
        assertEquals("Kowalski", response.getBody().getLastName());
        assertEquals(LocalDate.of(1985,10, 3), response.getBody().getDateOfBirth());
        assertEquals(BigDecimal.valueOf(15200.60), response.getBody().getAccountDto().getAccountBalance());
    }

    @Test
    public void getUserByIdWithInvalidIdShouldNotThrowException(){
        ResponseEntity<UserWithDetailsDto> response = template
                .getForEntity(base.toString() + "/15", UserWithDetailsDto.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertDoesNotThrow(response::getBody);
    }
}