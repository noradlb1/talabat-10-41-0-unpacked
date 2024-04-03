package qi;

import com.talabat.darkstores.domain.common.BuildVoucherProductListingNavigationUseCaseImpl;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class y implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f57254b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FlutterConfigurationParams f57255c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f57256d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f57257e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f57258f;

    public /* synthetic */ y(Function2 function2, FlutterConfigurationParams flutterConfigurationParams, String str, String str2, String str3) {
        this.f57254b = function2;
        this.f57255c = flutterConfigurationParams;
        this.f57256d = str;
        this.f57257e = str2;
        this.f57258f = str3;
    }

    public final Object call() {
        return BuildVoucherProductListingNavigationUseCaseImpl.m9768invoke$lambda0(this.f57254b, this.f57255c, this.f57256d, this.f57257e, this.f57258f);
    }
}
