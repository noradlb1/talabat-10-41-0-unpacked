package av;

import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class o implements SingleTransformer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f44485a;

    public /* synthetic */ o(Function1 function1) {
        this.f44485a = function1;
    }

    public final SingleSource apply(Single single) {
        return RxKt.m9374invoke$lambda8(this.f44485a, single);
    }
}
