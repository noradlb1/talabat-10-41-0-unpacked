package dw;

import com.talabat.talabatcore.adapters.FunctionalAdaptersKt;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f13904b;

    public /* synthetic */ b(Function1 function1) {
        this.f13904b = function1;
    }

    public final void accept(Object obj) {
        FunctionalAdaptersKt.m5825withAdapter$lambda3(this.f13904b, (Throwable) obj);
    }
}
