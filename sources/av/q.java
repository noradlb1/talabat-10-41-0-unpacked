package av;

import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class q implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f44487b;

    public /* synthetic */ q(Function1 function1) {
        this.f44487b = function1;
    }

    public final void accept(Object obj) {
        RxKt.m9363invoke$lambda10(this.f44487b, (Throwable) obj);
    }
}
