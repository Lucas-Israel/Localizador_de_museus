package com.betrybe.museumfinder.advice;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Handler de excessões.
 */
@ControllerAdvice
public class GeneralControllerAdvice {

  /**
   * Handler para quando as coordenadas são inválidas.
   *
   * @param exception do tipo InvalidCoordinateException
   * @return status 400 Coordenada inválida!
   */
  @ExceptionHandler(InvalidCoordinateException.class)
  public ResponseEntity<String> handlerInvalidCoordinate(InvalidCoordinateException exception) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(exception.getMessage());
  }

  /**
   * Handler para quando museu não é encontrado.
   *
   * @param exception do tipo MuseumNotFoundException.
   * @return status 404 Museu não encontrado!
   */
  @ExceptionHandler(MuseumNotFoundException.class)
  public ResponseEntity<String> handlerMuseumNotFound(MuseumNotFoundException exception) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exception.getMessage());
  }

  /**
   * Handler generico para qualquer erro que não está previsto.
   *
   * @return status 500 erro itnerno!
   */
  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<String> handlerGenericResponse() {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Erro interno!");
  }
}
