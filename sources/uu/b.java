package uu;

import androidx.lifecycle.Observer;
import com.talabat.splash.core.exception.Failure;
import com.talabat.splash.core.extension.LifeCycleKt;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f62957a;

    public /* synthetic */ b(Function1 function1) {
        this.f62957a = function1;
    }

    public final void onChanged(Object obj) {
        LifeCycleKt.m10907failure$lambda1(this.f62957a, (Failure) obj);
    }
}
