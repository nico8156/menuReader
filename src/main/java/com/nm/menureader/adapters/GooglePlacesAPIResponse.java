package com.nm.menureader.adapters;

import java.util.List;

public record GooglePlacesAPIResponse(
        List<Place> results
) {
}
