package ue;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.talabat.LoginScreen;
import com.talabat.user.status.domain.repository.IsUserRegisteredRepository;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class y9 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginScreen f57845b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GoogleSignInAccount f57846c;

    public /* synthetic */ y9(LoginScreen loginScreen, GoogleSignInAccount googleSignInAccount) {
        this.f57845b = loginScreen;
        this.f57846c = googleSignInAccount;
    }

    public final void accept(Object obj) {
        this.f57845b.lambda$handleSignInResult$13(this.f57846c, (IsUserRegisteredRepository.Status) obj);
    }
}
