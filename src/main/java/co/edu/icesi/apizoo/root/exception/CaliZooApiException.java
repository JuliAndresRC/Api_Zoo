package co.edu.icesi.apizoo.root.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class CaliZooApiException extends RuntimeException{

    private HttpStatus httpStatus;
    private CaliZooApiError caliZooApiError;
}
