package av;

import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class w implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f44493b;

    public /* synthetic */ w(Function1 function1) {
        this.f44493b = function1;
    }

    public final void accept(Object obj) {
        RxKt.m9372invoke$lambda6(this.f44493b, (Throwable) obj);
    }
}
