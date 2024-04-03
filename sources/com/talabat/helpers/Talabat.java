package com.talabat.helpers;

import com.android.volley.VolleyError;

public interface Talabat {
    public static final String HOME_DEEPLINK_QUERY = "from";

    void onDataError();

    void onNetworkError();

    void onServerError(VolleyError volleyError);

    void startLodingPopup();

    void stopLodingPopup();
}
