package com.baseflow.geolocator.location;

import com.baseflow.geolocator.errors.ErrorCodes;

public interface LocationServiceListener {
    void onLocationServiceError(ErrorCodes errorCodes);

    void onLocationServiceResult(boolean z11);
}
