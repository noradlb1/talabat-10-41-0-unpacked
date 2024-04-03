package av;

import com.talabat.talabatcommon.extentions.OnValueChangeListener;
import com.talabat.talabatcommon.extentions.RxDelegatesKt;
import io.reactivex.functions.Function;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnValueChangeListener f44474b;

    public /* synthetic */ d(OnValueChangeListener onValueChangeListener) {
        this.f44474b = onValueChangeListener;
    }

    public final Object apply(Object obj) {
        return RxDelegatesKt.m9357OnValueChangeListener$lambda0(this.f44474b, (Long) obj);
    }
}
