package qi;

import com.talabat.darkstores.domain.common.BuildCategoryProductsNavigationActionUseCaseImpl;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class n implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f57216b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FlutterConfigurationParams f57217c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f57218d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f57219e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f57220f;

    public /* synthetic */ n(Function2 function2, FlutterConfigurationParams flutterConfigurationParams, String str, String str2, String str3) {
        this.f57216b = function2;
        this.f57217c = flutterConfigurationParams;
        this.f57218d = str;
        this.f57219e = str2;
        this.f57220f = str3;
    }

    public final Object call() {
        return BuildCategoryProductsNavigationActionUseCaseImpl.m9757invoke$lambda0(this.f57216b, this.f57217c, this.f57218d, this.f57219e, this.f57220f);
    }
}
