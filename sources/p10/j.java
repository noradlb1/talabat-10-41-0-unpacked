package p10;

import JsonModels.Response.CustomerAddressInfoJsonResult;
import com.android.volley.Response;
import library.talabat.mvp.login.LoginInteractor;

public final /* synthetic */ class j implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginInteractor f28142b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f28143c;

    public /* synthetic */ j(LoginInteractor loginInteractor, boolean z11) {
        this.f28142b = loginInteractor;
        this.f28143c = z11;
    }

    public final void onResponse(Object obj) {
        this.f28142b.lambda$onAddressReceived$9(this.f28143c, (CustomerAddressInfoJsonResult) obj);
    }
}
