package b7;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.facebook.login.LoginFragment;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class j implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f29336a;

    public /* synthetic */ j(Function1 function1) {
        this.f29336a = function1;
    }

    public final void onActivityResult(Object obj) {
        LoginFragment.m8996onCreate$lambda1(this.f29336a, (ActivityResult) obj);
    }
}
