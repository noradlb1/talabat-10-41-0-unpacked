package library.talabat.mvp;

import com.android.volley.VolleyError;

public interface IGlobalListener {
    void onDataError();

    void onNetworkError();

    void onServerError(VolleyError volleyError);
}
