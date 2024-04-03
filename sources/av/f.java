package av;

import com.talabat.talabatcommon.extentions.RxDelegatesKt;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f44476b;

    public /* synthetic */ f(Function1 function1) {
        this.f44476b = function1;
    }

    public final void accept(Object obj) {
        RxDelegatesKt.m9359OnValueChangeListener$lambda2(this.f44476b, (Throwable) obj);
    }
}
