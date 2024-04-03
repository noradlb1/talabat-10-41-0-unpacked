package qi;

import com.talabat.darkstores.domain.common.BuildBannerCampaignProductListingNavigationUseCaseImpl;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class f implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f57201b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FlutterConfigurationParams f57202c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f57203d;

    public /* synthetic */ f(Function2 function2, FlutterConfigurationParams flutterConfigurationParams, String str) {
        this.f57201b = function2;
        this.f57202c = flutterConfigurationParams;
        this.f57203d = str;
    }

    public final Object call() {
        return BuildBannerCampaignProductListingNavigationUseCaseImpl.m9749invoke$lambda0(this.f57201b, this.f57202c, this.f57203d);
    }
}
