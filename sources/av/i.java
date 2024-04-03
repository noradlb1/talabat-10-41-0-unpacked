package av;

import com.talabat.talabatcommon.extentions.RxDelegatesKt;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f44479b;

    public /* synthetic */ i(Function1 function1) {
        this.f44479b = function1;
    }

    public final void accept(Object obj) {
        RxDelegatesKt.m9354OnDistinctValueChangeListener$lambda5(this.f44479b, obj);
    }
}
