package qi;

import com.talabat.darkstores.domain.common.BuildBannerCampaignProductListingNavigationUseCaseImpl;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class g implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f57204b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f57205c;

    public /* synthetic */ g(Function1 function1, String str) {
        this.f57204b = function1;
        this.f57205c = str;
    }

    public final Object call() {
        return BuildBannerCampaignProductListingNavigationUseCaseImpl.m9750invoke$lambda1(this.f57204b, this.f57205c);
    }
}
