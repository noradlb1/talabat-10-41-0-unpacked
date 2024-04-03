package av;

import com.talabat.talabatcommon.extentions.RxDelegatesKt;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class j implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f44480b;

    public /* synthetic */ j(Function1 function1) {
        this.f44480b = function1;
    }

    public final void accept(Object obj) {
        RxDelegatesKt.m9355OnDistinctValueChangeListener$lambda6(this.f44480b, (Throwable) obj);
    }
}
