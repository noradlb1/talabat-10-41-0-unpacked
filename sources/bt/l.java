package bt;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.talabat.observability.common.RegistrationFlows;
import com.talabat.registration.RegistrationInteractor;
import datamodels.RegistrationRM;

public final /* synthetic */ class l implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RegistrationInteractor f58189b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RegistrationRM f58190c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ RegistrationFlows f58191d;

    public /* synthetic */ l(RegistrationInteractor registrationInteractor, RegistrationRM registrationRM, RegistrationFlows registrationFlows) {
        this.f58189b = registrationInteractor;
        this.f58190c = registrationRM;
        this.f58191d = registrationFlows;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.f58189b.lambda$onRequestError$11(this.f58190c, this.f58191d, volleyError);
    }
}
