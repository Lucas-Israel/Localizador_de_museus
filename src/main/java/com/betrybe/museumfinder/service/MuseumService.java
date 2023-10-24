package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
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
    return null;
  }

  @Override
  public Museum getMuseum(Long id) {
    return null;
  }
}
