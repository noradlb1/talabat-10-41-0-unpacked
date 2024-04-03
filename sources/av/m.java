package av;

import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class m implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f44483b;

    public /* synthetic */ m(Function1 function1) {
        this.f44483b = function1;
    }

    public final void accept(Object obj) {
        RxKt.m9366invoke$lambda13(this.f44483b, (Throwable) obj);
    }
}
