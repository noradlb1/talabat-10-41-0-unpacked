package av;

import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class p implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f44486b;

    public /* synthetic */ p(Function1 function1) {
        this.f44486b = function1;
    }

    public final void accept(Object obj) {
        RxKt.m9375invoke$lambda9(this.f44486b, obj);
    }
}
