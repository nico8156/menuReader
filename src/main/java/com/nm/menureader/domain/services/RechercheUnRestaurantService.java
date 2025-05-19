package com.nm.menureader.domain.services;

import com.nm.menureader.domain.Position;
import com.nm.menureader.domain.Restaurant;

public class RechercheUnRestaurantService {

    public Restaurant rechercheDepuisGoogle(Position positionDuUSer) {
        return new Restaurant("Le Plateau");
    }
}
