package dj;

import com.talabat.darkstores.data.darkstores.model.BannersResponse;
import com.talabat.darkstores.feature.home.HomeFragmentViewModel;
import io.reactivex.functions.Function;

public final /* synthetic */ class x implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeFragmentViewModel f56761b;

    public /* synthetic */ x(HomeFragmentViewModel homeFragmentViewModel) {
        this.f56761b = homeFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return HomeFragmentViewModel.m9962_init_$lambda3(this.f56761b, (BannersResponse) obj);
    }
}
