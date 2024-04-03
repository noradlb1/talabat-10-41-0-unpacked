package bt;

import com.android.volley.Response;
import com.talabat.registration.RegistrationInteractor;
import datamodels.RegistrationRM;
import datamodels.Token;

public final /* synthetic */ class a implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RegistrationInteractor f58176b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RegistrationRM f58177c;

    public /* synthetic */ a(RegistrationInteractor registrationInteractor, RegistrationRM registrationRM) {
        this.f58176b = registrationInteractor;
        this.f58177c = registrationRM;
    }

    public final void onResponse(Object obj) {
        this.f58176b.lambda$onTokenReceived$1(this.f58177c, (Token) obj);
    }
}
