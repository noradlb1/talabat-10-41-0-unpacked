package dw;

import com.talabat.talabatcore.adapters.FunctionalAdaptersKt;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f13903b;

    public /* synthetic */ a(Function1 function1) {
        this.f13903b = function1;
    }

    public final void accept(Object obj) {
        FunctionalAdaptersKt.m5823disposable$lambda5(this.f13903b, (Throwable) obj);
    }
}
