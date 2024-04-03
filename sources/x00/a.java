package x00;

import JsonModels.GeoAddressRequest;
import com.android.volley.Response;
import library.talabat.mvp.addressV2.AddressInteractor;

public final /* synthetic */ class a implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddressInteractor f28217b;

    public /* synthetic */ a(AddressInteractor addressInteractor) {
        this.f28217b = addressInteractor;
    }

    public final void onResponse(Object obj) {
        this.f28217b.lambda$onGeoAddressRecieved$7((GeoAddressRequest) obj);
    }
}
