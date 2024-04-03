package av;

import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import kotlin.jvm.functions.Function1;
import org.reactivestreams.Publisher;

public final /* synthetic */ class u implements FlowableTransformer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f44491a;

    public /* synthetic */ u(Function1 function1) {
        this.f44491a = function1;
    }

    public final Publisher apply(Flowable flowable) {
        return RxKt.m9370invoke$lambda4(this.f44491a, flowable);
    }
}
