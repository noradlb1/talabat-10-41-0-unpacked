package uu;

import androidx.lifecycle.Observer;
import com.talabat.splash.core.extension.LifeCycleKt;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f62956a;

    public /* synthetic */ a(Function1 function1) {
        this.f62956a = function1;
    }

    public final void onChanged(Object obj) {
        LifeCycleKt.m10908observe$lambda0(this.f62956a, obj);
    }
}
