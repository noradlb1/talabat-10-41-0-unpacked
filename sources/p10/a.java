package p10;

import com.android.volley.Response;
import datamodels.Token;
import io.reactivex.SingleEmitter;
import library.talabat.mvp.login.LoginInteractor;

public final /* synthetic */ class a implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginInteractor f28130b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f28131c;

    public /* synthetic */ a(LoginInteractor loginInteractor, SingleEmitter singleEmitter) {
        this.f28130b = loginInteractor;
        this.f28131c = singleEmitter;
    }

    public final void onResponse(Object obj) {
        this.f28130b.lambda$faceBookLoginWithResult$0(this.f28131c, (Token) obj);
    }
}
