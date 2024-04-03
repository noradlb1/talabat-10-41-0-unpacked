package ew;

import androidx.lifecycle.Observer;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f14008a;

    public /* synthetic */ b(Function1 function1) {
        this.f14008a = function1;
    }

    public final void onChanged(Object obj) {
        LifecycleKt.m5827failure$lambda1(this.f14008a, (Failure) obj);
    }
}
