package qi;

import com.talabat.darkstores.domain.common.BuildLifestyleSearchResultNavigationActionUseCaseImpl;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class q implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f57227b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FlutterConfigurationParams f57228c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f57229d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f57230e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f57231f;

    public /* synthetic */ q(Function2 function2, FlutterConfigurationParams flutterConfigurationParams, String str, String str2, String str3) {
        this.f57227b = function2;
        this.f57228c = flutterConfigurationParams;
        this.f57229d = str;
        this.f57230e = str2;
        this.f57231f = str3;
    }

    public final Object call() {
        return BuildLifestyleSearchResultNavigationActionUseCaseImpl.m9760invoke$lambda0(this.f57227b, this.f57228c, this.f57229d, this.f57230e, this.f57231f);
    }
}
