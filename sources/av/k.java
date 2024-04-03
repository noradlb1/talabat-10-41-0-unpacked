package av;

import com.talabat.talabatcommon.extentions.RxDelegatesKt;
import io.reactivex.functions.Action;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class k implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f44481b;

    public /* synthetic */ k(Function0 function0) {
        this.f44481b = function0;
    }

    public final void run() {
        RxDelegatesKt.m9356OnDistinctValueChangeListener$lambda7(this.f44481b);
    }
}
