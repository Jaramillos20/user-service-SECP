package com.binarybrains.userservice;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.binarybrains.userservice.core.buisness.implementation.UserBs;
import com.binarybrains.userservice.core.buisness.output.UserRepository;
import com.binarybrains.userservice.core.entity.User;
import com.binarybrains.userservice.utils.error.ErrorGlobalMapper;
import com.binarybrains.userservice.utils.error.ErrorInfo;
import com.binarybrains.userservice.utils.error.ErrorType;

@ExtendWith(MockitoExtension.class)
class UserServiceUnitTest {

	@InjectMocks
	private UserBs userBs;

	@Mock
	private UserRepository userRepository;

	@Mock
	private ErrorGlobalMapper errorMapper;
	// Unit tests for getById method
	@Test
	void shouldReturnUsersWhenIdExists() {
		User user = User.builder()
						.id(1)
						.build();
		when(userRepository.findById(1)).thenReturn(Optional.of(user));
		var result = userBs.getById(1);
		assertTrue(result.isRight());
		assertEquals(user.getId(), result.get().getId());
	}

	@Test
	void shouldReturnError404WhenIdNotExists() {
		ErrorInfo err = ErrorInfo.builder()
						.code("RN004")
						.message("Not found")
						.ruta("/user/2")
						.type(ErrorType.REQUEST)
						.build();
		when(errorMapper.getRn004()).thenReturn(err);
		when(userRepository.findById(2)).thenReturn(Optional.empty());
		var result = userBs.getById(2);
		assertTrue(result.isLeft());
		assertEquals("RN004", result.getLeft().getCode());
	}
	// Unit tests for createUser method
	@Test 
	void shouldCreateUserWhenEmailNotExists(){
		User user = User.builder()
						.name("John Smith")
						.email("johnsmail@gmail.com")
						.number("+1234567890")
						.build();
		when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(List.of()));
		when(userRepository.save(user)).thenReturn(Optional.of(user));
		var result = userBs.create(user);
		assertTrue(result.isRight());
	}
	@Test 
	void shoudReturnErrorWhenEmailExists(){
		ErrorInfo err = ErrorInfo.builder()
						.code("RN003")
						.message("Email already exists")
						.ruta("/user/")
						.type(ErrorType.REQUEST)
						.build();
		User user = User.builder()
						.name("John Smith")
						.email("johnsmail@gmail.com")
						.number("+1234567890")
						.build();

		when(errorMapper.getRn003()).thenReturn(err);
		when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(List.of(user)));
		var result = userBs.create(user);
		assertTrue(result.isLeft());
    	assertEquals("RN003", result.getLeft().getCode());
	}
}
