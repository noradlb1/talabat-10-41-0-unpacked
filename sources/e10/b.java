package e10;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import library.talabat.mvp.forgotpassword.ForgotPasswordInteractor;

public final /* synthetic */ class b implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ForgotPasswordInteractor f24320b;

    public /* synthetic */ b(ForgotPasswordInteractor forgotPasswordInteractor) {
        this.f24320b = forgotPasswordInteractor;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.f24320b.lambda$onRequestError$0(volleyError);
    }
}
