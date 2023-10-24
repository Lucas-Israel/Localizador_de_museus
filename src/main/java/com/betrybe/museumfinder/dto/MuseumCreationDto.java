package com.betrybe.museumfinder.dto;

import com.betrybe.museumfinder.model.Coordinate;

/**
 * Usado para requisição de criação de museus.
 *
 * @param name do museu.
 * @param description do museu.
 * @param address do museu.
 * @param collectionType do museu.
 * @param subject do museu.
 * @param url do museu.
 * @param coordinate do museu.
 */
public record MuseumCreationDto(String name, String description, String address, String collectionType, String subject, String url, Coordinate coordinate) {

}
