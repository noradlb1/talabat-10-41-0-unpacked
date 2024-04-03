package e;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCallerKt;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f11590a;

    public /* synthetic */ b(Function1 function1) {
        this.f11590a = function1;
    }

    public final void onActivityResult(Object obj) {
        ActivityResultCallerKt.m6registerForActivityResult$lambda0(this.f11590a, obj);
    }
}
