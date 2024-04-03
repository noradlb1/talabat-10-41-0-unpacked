package av;

import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class s implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f44489b;

    public /* synthetic */ s(Function1 function1) {
        this.f44489b = function1;
    }

    public final void accept(Object obj) {
        RxKt.m9368invoke$lambda2(this.f44489b, (Throwable) obj);
    }
}
