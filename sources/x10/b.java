package x10;

import JsonModels.Response.AddAddressRM;
import com.android.volley.Response;
import datamodels.QuickOrderUserInfo;
import library.talabat.mvp.quickorder.QuickOrderInteractor;

public final /* synthetic */ class b implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickOrderInteractor f28231b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ QuickOrderUserInfo f28232c;

    public /* synthetic */ b(QuickOrderInteractor quickOrderInteractor, QuickOrderUserInfo quickOrderUserInfo) {
        this.f28231b = quickOrderInteractor;
        this.f28232c = quickOrderUserInfo;
    }

    public final void onResponse(Object obj) {
        this.f28231b.lambda$onAddressValidation$0(this.f28232c, (AddAddressRM) obj);
    }
}
