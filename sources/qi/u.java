package qi;

import com.talabat.darkstores.domain.common.BuildSwimlanesSearchResultNavigationActionUseCaseImpl;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function4;

public final /* synthetic */ class u implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function4 f57242b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f57243c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f57244d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f57245e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f57246f;

    public /* synthetic */ u(Function4 function4, String str, String str2, String str3, String str4) {
        this.f57242b = function4;
        this.f57243c = str;
        this.f57244d = str2;
        this.f57245e = str3;
        this.f57246f = str4;
    }

    public final Object call() {
        return BuildSwimlanesSearchResultNavigationActionUseCaseImpl.m9764invoke$lambda1(this.f57242b, this.f57243c, this.f57244d, this.f57245e, this.f57246f);
    }
}
