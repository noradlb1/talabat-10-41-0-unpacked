package bt;

import JsonModels.Response.CustomerAddressInfoJsonResult;
import com.android.volley.Response;
import com.talabat.registration.RegistrationInteractor;

public final /* synthetic */ class d implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RegistrationInteractor f58180b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f58181c;

    public /* synthetic */ d(RegistrationInteractor registrationInteractor, boolean z11) {
        this.f58180b = registrationInteractor;
        this.f58181c = z11;
    }

    public final void onResponse(Object obj) {
        this.f58180b.lambda$onAddressReceived$10(this.f58181c, (CustomerAddressInfoJsonResult) obj);
    }
}
