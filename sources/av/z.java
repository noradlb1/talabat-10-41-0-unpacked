package av;

import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class z implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f44496b;

    public /* synthetic */ z(Function1 function1) {
        this.f44496b = function1;
    }

    public final void accept(Object obj) {
        RxKt.m9365invoke$lambda12(this.f44496b, obj);
    }
}
