package com.betrybe.museumfinder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class InvalidCoordinateException extends RuntimeException {

  public InvalidCoordinateException() {
    super("Coordenada inválida!");
  }
}
