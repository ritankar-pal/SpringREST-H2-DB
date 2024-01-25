package in.ineuron.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.errorModel.ErrorDetails;
import in.ineuron.exception.StudentRecordNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(StudentRecordNotFoundException.class)
	public ResponseEntity<ErrorDetails> studentNotFoundException(StudentRecordNotFoundException se) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), se.getMessage(), "Record Not Found");
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> allException(Exception se) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), se.getMessage(), "Server Error");
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
