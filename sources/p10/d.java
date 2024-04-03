package p10;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import io.reactivex.SingleEmitter;
import library.talabat.mvp.login.LoginInteractor;

public final /* synthetic */ class d implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginInteractor f28133b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f28134c;

    public /* synthetic */ d(LoginInteractor loginInteractor, SingleEmitter singleEmitter) {
        this.f28133b = loginInteractor;
        this.f28134c = singleEmitter;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.f28133b.lambda$faceBookLoginWithResult$1(this.f28134c, volleyError);
    }
}
