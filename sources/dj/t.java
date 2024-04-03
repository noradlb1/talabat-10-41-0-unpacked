package dj;

import com.talabat.darkstores.data.darkstores.model.BannersResponse;
import com.talabat.darkstores.feature.home.HomeFragmentViewModel;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class t implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeFragmentViewModel f56756b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BannersResponse f56757c;

    public /* synthetic */ t(HomeFragmentViewModel homeFragmentViewModel, BannersResponse bannersResponse) {
        this.f56756b = homeFragmentViewModel;
        this.f56757c = bannersResponse;
    }

    public final Object apply(Object obj) {
        return HomeFragmentViewModel.m9968lambda3$lambda2(this.f56756b, this.f56757c, (Vendor) obj);
    }
}
