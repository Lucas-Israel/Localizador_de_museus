package com.betrybe.museumfinder.dto;

import com.betrybe.museumfinder.model.Coordinate;

/**
 * Usado como resposta da API.
 *
 * @param id do museu.
 * @param name do museu.
 * @param description do museu.
 * @param address do museu.
 * @param collectionType do museu.
 * @param subject do museu.
 * @param url do museu.
 * @param coordinate do museu.
 */
public record MuseumDto(Long id, String name, String description, String address,
                        String collectionType, String subject, String url,
                        Coordinate coordinate) {

}
