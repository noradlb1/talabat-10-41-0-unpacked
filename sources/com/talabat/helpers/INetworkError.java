package com.talabat.helpers;

import com.android.volley.VolleyError;

public interface INetworkError {
    void onAuthError();

    void onDataError();

    void onError();

    void onServerError(VolleyError volleyError);
}
