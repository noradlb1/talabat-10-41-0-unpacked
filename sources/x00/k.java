package x00;

import JsonModels.AreaPreoloadResponse;
import com.android.volley.Response;
import library.talabat.mvp.addressV2.AddressInteractor;

public final /* synthetic */ class k implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddressInteractor f28228b;

    public /* synthetic */ k(AddressInteractor addressInteractor) {
        this.f28228b = addressInteractor;
    }

    public final void onResponse(Object obj) {
        this.f28228b.lambda$onPreloadAreaRecieved$3((AreaPreoloadResponse) obj);
    }
}
