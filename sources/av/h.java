package av;

import com.talabat.talabatcommon.extentions.OnValueChangeListener;
import com.talabat.talabatcommon.extentions.RxDelegatesKt;
import io.reactivex.functions.Function;

public final /* synthetic */ class h implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnValueChangeListener f44478b;

    public /* synthetic */ h(OnValueChangeListener onValueChangeListener) {
        this.f44478b = onValueChangeListener;
    }

    public final Object apply(Object obj) {
        return RxDelegatesKt.m9353OnDistinctValueChangeListener$lambda4(this.f44478b, (Long) obj);
    }
}
