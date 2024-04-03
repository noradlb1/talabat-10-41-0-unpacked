package qi;

import com.talabat.darkstores.domain.common.BuildLifestyleSearchResultNavigationActionUseCaseImpl;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class r implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f57232b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f57233c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f57234d;

    public /* synthetic */ r(Function2 function2, String str, String str2) {
        this.f57232b = function2;
        this.f57233c = str;
        this.f57234d = str2;
    }

    public final Object call() {
        return BuildLifestyleSearchResultNavigationActionUseCaseImpl.m9761invoke$lambda1(this.f57232b, this.f57233c, this.f57234d);
    }
}
