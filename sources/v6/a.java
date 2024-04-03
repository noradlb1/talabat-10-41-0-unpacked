package v6;

import android.util.Pair;
import androidx.activity.result.ActivityResultCallback;
import com.facebook.CallbackManager;
import com.facebook.internal.DialogPresenter;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class a implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CallbackManager f34738a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f34739b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f34740c;

    public /* synthetic */ a(CallbackManager callbackManager, int i11, Ref.ObjectRef objectRef) {
        this.f34738a = callbackManager;
        this.f34739b = i11;
        this.f34740c = objectRef;
    }

    public final void onActivityResult(Object obj) {
        DialogPresenter.m8946startActivityForResultWithAndroidX$lambda2(this.f34738a, this.f34739b, this.f34740c, (Pair) obj);
    }
}
