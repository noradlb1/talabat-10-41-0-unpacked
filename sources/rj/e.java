package rj;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import io.reactivex.SingleEmitter;

public final /* synthetic */ class e implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f57376b;

    public /* synthetic */ e(SingleEmitter singleEmitter) {
        this.f57376b = singleEmitter;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.f57376b.onError(volleyError);
    }
}
