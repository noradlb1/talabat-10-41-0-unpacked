package qi;

import com.talabat.darkstores.domain.common.BuildCartNavigationActionUseCaseImpl;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class k implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BuildCartNavigationActionUseCaseImpl f57210b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function0 f57211c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function2 f57212d;

    public /* synthetic */ k(BuildCartNavigationActionUseCaseImpl buildCartNavigationActionUseCaseImpl, Function0 function0, Function2 function2) {
        this.f57210b = buildCartNavigationActionUseCaseImpl;
        this.f57211c = function0;
        this.f57212d = function2;
    }

    public final Object apply(Object obj) {
        return BuildCartNavigationActionUseCaseImpl.m9754invoke$lambda3(this.f57210b, this.f57211c, this.f57212d, (Boolean) obj);
    }
}
