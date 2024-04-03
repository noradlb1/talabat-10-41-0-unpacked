package ew;

import androidx.lifecycle.Observer;
import com.talabat.talabatcore.extensions.LifecycleKt;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f14007a;

    public /* synthetic */ a(Function1 function1) {
        this.f14007a = function1;
    }

    public final void onChanged(Object obj) {
        LifecycleKt.m5828observe$lambda0(this.f14007a, obj);
    }
}
