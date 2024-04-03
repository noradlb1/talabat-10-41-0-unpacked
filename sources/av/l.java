package av;

import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class l implements ObservableTransformer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f44482a;

    public /* synthetic */ l(Function1 function1) {
        this.f44482a = function1;
    }

    public final ObservableSource apply(Observable observable) {
        return RxKt.m9361invoke$lambda0(this.f44482a, observable);
    }
}
