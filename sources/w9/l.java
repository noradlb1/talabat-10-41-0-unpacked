package w9;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.android.AndroidAuthTokenProvider;
import com.google.firebase.database.core.TokenProvider;

public final /* synthetic */ class l implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TokenProvider.GetTokenCompletionListener f50794a;

    public /* synthetic */ l(TokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        this.f50794a = getTokenCompletionListener;
    }

    public final void onFailure(Exception exc) {
        AndroidAuthTokenProvider.lambda$getToken$2(this.f50794a, exc);
    }
}
