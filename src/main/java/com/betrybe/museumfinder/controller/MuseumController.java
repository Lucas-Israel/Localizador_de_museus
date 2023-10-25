package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/museums")
public class MuseumController {

  MuseumServiceInterface service;

  @Autowired
  public MuseumController(MuseumServiceInterface service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Museum> postMuseum(@RequestBody MuseumCreationDto body) {
    Museum muse = new Museum();
    muse.setName(body.name());
    muse.setDescription(body.description());
    muse.setAddress(body.address());
    muse.setCollectionType(body.collectionType());
    muse.setSubject(body.subject());
    muse.setUrl(body.url());
    muse.setCoordinate(body.coordinate());
    Museum output = service.createMuseum(muse);

    return ResponseEntity.status(HttpStatus.CREATED).body(output);
  }

  @GetMapping("/closest")
  public ResponseEntity<MuseumDto> getClosestMuseum(@RequestParam(name = "lat") double lat,
      @RequestParam(name = "lng") double lng,
      @RequestParam(name = "max_dist_km") Double max) {
    Coordinate coord = new Coordinate(lat, lng);
    Museum musee = service.getClosestMuseum(coord, max);
    MuseumDto output = new MuseumDto(
        musee.getId(),
        musee.getName(),
        musee.getDescription(),
        musee.getAddress(),
        musee.getCollectionType(),
        musee.getSubject(),
        musee.getUrl(),
        musee.getCoordinate()
    );

    return ResponseEntity.ok(output);
  }

  @GetMapping("/{id}")
  public ResponseEntity<MuseumDto> getMuseumById(@PathVariable long id) {
    Museum muse = service.getMuseum(id);
    MuseumDto output = new MuseumDto(
        muse.getId(),
        muse.getName(),
        muse.getDescription(),
        muse.getAddress(),
        muse.getCollectionType(),
        muse.getSubject(),
        muse.getUrl(),
        muse.getCoordinate()
    );

    return ResponseEntity.ok(output);
  }
}
