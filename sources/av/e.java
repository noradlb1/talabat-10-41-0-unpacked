package av;

import com.talabat.talabatcommon.extentions.RxDelegatesKt;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f44475b;

    public /* synthetic */ e(Function1 function1) {
        this.f44475b = function1;
    }

    public final void accept(Object obj) {
        RxDelegatesKt.m9358OnValueChangeListener$lambda1(this.f44475b, obj);
    }
}
