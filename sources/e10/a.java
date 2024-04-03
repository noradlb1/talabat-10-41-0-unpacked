package e10;

import JsonModels.Response.PasswordResponse;
import com.android.volley.Response;
import library.talabat.mvp.forgotpassword.ForgotPasswordInteractor;

public final /* synthetic */ class a implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ForgotPasswordInteractor f24319b;

    public /* synthetic */ a(ForgotPasswordInteractor forgotPasswordInteractor) {
        this.f24319b = forgotPasswordInteractor;
    }

    public final void onResponse(Object obj) {
        this.f24319b.lambda$onRequestResponse$1((PasswordResponse) obj);
    }
}
