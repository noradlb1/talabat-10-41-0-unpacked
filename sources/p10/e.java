package p10;

import com.android.volley.Response;
import datamodels.Token;
import library.talabat.mvp.login.LoginInteractor;

public final /* synthetic */ class e implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginInteractor f28135b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f28136c;

    public /* synthetic */ e(LoginInteractor loginInteractor, String str) {
        this.f28135b = loginInteractor;
        this.f28136c = str;
    }

    public final void onResponse(Object obj) {
        this.f28135b.lambda$onResultRecieved$4(this.f28136c, (Token) obj);
    }
}
