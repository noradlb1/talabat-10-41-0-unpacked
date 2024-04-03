package x00;

import JsonModels.AreaResponseModel;
import com.android.volley.Response;
import library.talabat.mvp.addressV2.AddressInteractor;

public final /* synthetic */ class h implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddressInteractor f28225b;

    public /* synthetic */ h(AddressInteractor addressInteractor) {
        this.f28225b = addressInteractor;
    }

    public final void onResponse(Object obj) {
        this.f28225b.lambda$onAreaRecieved$2((AreaResponseModel) obj);
    }
}
