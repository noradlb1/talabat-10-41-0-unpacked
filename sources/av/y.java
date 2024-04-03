package av;

import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.MaybeTransformer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class y implements MaybeTransformer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f44495a;

    public /* synthetic */ y(Function1 function1) {
        this.f44495a = function1;
    }

    public final MaybeSource apply(Maybe maybe) {
        return RxKt.m9364invoke$lambda11(this.f44495a, maybe);
    }
}
