package com.betrybe.museumfinder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class MuseumNotFoundException extends RuntimeException {

  public MuseumNotFoundException() {
    super("Museu não encontrado!");
  }
}
