package com.nm.menureader.adapters;

import com.nm.menureader.domain.Position;
import com.nm.menureader.domain.services.GoogleApiPlacesNearbyService;

import java.util.ArrayList;
import java.util.List;

public class FakeGoogleApiPlacesNearbyService implements GoogleApiPlacesNearbyService {
    public List<Place> restaurantTrouveParGoogle(Position position){
        Place restaurantTrouveParGoogle = new Place(new DisplayName("leBonRestau", "fr"));
        List<Place> restaurantsTrouveParGoogle = new ArrayList<>();
        restaurantsTrouveParGoogle.add(restaurantTrouveParGoogle);

        return restaurantsTrouveParGoogle;
    }

}
