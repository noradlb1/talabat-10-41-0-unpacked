package w9;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.core.TokenProvider;

public final /* synthetic */ class k implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TokenProvider.GetTokenCompletionListener f50793a;

    public /* synthetic */ k(TokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        this.f50793a = getTokenCompletionListener;
    }

    public final void onSuccess(Object obj) {
        this.f50793a.onSuccess(((GetTokenResult) obj).getToken());
    }
}
