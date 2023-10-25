package com.betrybe.museumfinder.service;

import static com.betrybe.museumfinder.util.CoordinateUtil.isCoordinateValid;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import java.util.Optional;
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
    if (!isCoordinateValid(coordinate)) {
      throw new InvalidCoordinateException();
    }

    Optional<Museum> output = db.getClosestMuseum(coordinate, maxDistance);

    if (output.isEmpty()) {
      throw new MuseumNotFoundException();
    }

    return output.get();
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
    Optional<Museum> muse = db.getMuseum(id);
    if(muse.isEmpty()) {
      throw new MuseumNotFoundException();
    } else {
      return muse.get();
    }
  }
}
