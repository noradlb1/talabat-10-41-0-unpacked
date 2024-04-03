package qi;

import com.talabat.darkstores.domain.common.BuildCategoryProductsNavigationActionUseCaseImpl;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function3;

public final /* synthetic */ class o implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function3 f57221b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f57222c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f57223d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f57224e;

    public /* synthetic */ o(Function3 function3, String str, String str2, String str3) {
        this.f57221b = function3;
        this.f57222c = str;
        this.f57223d = str2;
        this.f57224e = str3;
    }

    public final Object call() {
        return BuildCategoryProductsNavigationActionUseCaseImpl.m9758invoke$lambda1(this.f57221b, this.f57222c, this.f57223d, this.f57224e);
    }
}
