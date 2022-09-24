package co.edu.icesi.apizoo.root;

import co.edu.icesi.CaliZooApi.root.exception.CaliZooApiError;
import co.edu.icesi.CaliZooApi.root.exception.CaliZooApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalHandlerException {

    public ResponseEntity<CaliZooApiError> handlerException(CaliZooApiException caliZooApiException){
        return new ResponseEntity<>(caliZooApiException.getCaliZooApiError(), caliZooApiException.getHttpStatus());
    }
}
