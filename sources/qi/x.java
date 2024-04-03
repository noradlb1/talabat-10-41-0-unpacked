package qi;

import com.talabat.darkstores.domain.common.BuildVoucherDetailsNavigationUseCaseImpl;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class x implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f57252b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f57253c;

    public /* synthetic */ x(Function1 function1, String str) {
        this.f57252b = function1;
        this.f57253c = str;
    }

    public final Object call() {
        return BuildVoucherDetailsNavigationUseCaseImpl.m9767invoke$lambda1(this.f57252b, this.f57253c);
    }
}
