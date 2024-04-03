package rj;

import JsonModels.Response.CustomerAddressInfoJsonResult;
import com.android.volley.Response;
import io.reactivex.SingleEmitter;

public final /* synthetic */ class d implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f57375b;

    public /* synthetic */ d(SingleEmitter singleEmitter) {
        this.f57375b = singleEmitter;
    }

    public final void onResponse(Object obj) {
        this.f57375b.onSuccess((CustomerAddressInfoJsonResult) obj);
    }
}
