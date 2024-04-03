package com.google.android.libraries.places.internal;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;

final class zzy {
    public static ApiException zza(VolleyError volleyError) {
        int i11;
        String str;
        if (volleyError instanceof NetworkError) {
            i11 = 7;
        } else if (volleyError instanceof TimeoutError) {
            i11 = 15;
        } else if ((volleyError instanceof ServerError) || (volleyError instanceof ParseError)) {
            i11 = 8;
        } else if (volleyError instanceof AuthFailureError) {
            i11 = PlacesStatusCodes.REQUEST_DENIED;
        } else {
            i11 = 13;
        }
        NetworkResponse networkResponse = volleyError.networkResponse;
        if (networkResponse == null) {
            str = "N/A";
        } else {
            str = String.valueOf(networkResponse.statusCode);
        }
        return new ApiException(new Status(i11, String.format("Unexpected server error (HTTP Code: %s. Message: %s.)", new Object[]{str, volleyError})));
    }
}
