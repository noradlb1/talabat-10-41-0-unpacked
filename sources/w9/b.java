package w9;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.core.TokenProvider;

public final /* synthetic */ class b implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TokenProvider.GetTokenCompletionListener f50778a;

    public /* synthetic */ b(TokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        this.f50778a = getTokenCompletionListener;
    }

    public final void onFailure(Exception exc) {
        this.f50778a.onError(exc.getMessage());
    }
}
