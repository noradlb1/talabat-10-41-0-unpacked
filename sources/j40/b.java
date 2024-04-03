package j40;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import tracking.perseus.TalabatPerseus;

public final /* synthetic */ class b implements Response.ErrorListener {
    public final void onErrorResponse(VolleyError volleyError) {
        TalabatPerseus.Companion.m10953dispatchPerseusEvent$lambda2(volleyError);
    }
}
