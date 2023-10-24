package com.betrybe.museumfinder.service;

import static com.betrybe.museumfinder.util.CoordinateUtil.isCoordinateValid;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MuseumService implements MuseumServiceInterface {

  MuseumFakeDatabase db;

  @Autowired
  public MuseumService(MuseumFakeDatabase db) {
    this.db = db;
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    return null;
  }

  @Override
  public Museum createMuseum(Museum museum) {
    Museum output = null;
    if(!isCoordinateValid(museum.getCoordinate())) {
      throw new InvalidCoordinateException();
    } else {
      output = db.saveMuseum(museum);
    }
    return output;
  }

  @Override
  public Museum getMuseum(Long id) {
    return null;
  }
}
