package e;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCallerKt;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f11589a;

    public /* synthetic */ a(Function1 function1) {
        this.f11589a = function1;
    }

    public final void onActivityResult(Object obj) {
        ActivityResultCallerKt.m7registerForActivityResult$lambda1(this.f11589a, obj);
    }
}
