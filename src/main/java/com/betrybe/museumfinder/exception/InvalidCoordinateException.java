package com.betrybe.museumfinder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excessão para quando uma coordenada é inválida.
 */
@ResponseStatus
public class InvalidCoordinateException extends RuntimeException {

  public InvalidCoordinateException() {
    super("Coordenada inválida!");
  }
}
