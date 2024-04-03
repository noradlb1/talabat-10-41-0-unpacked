package dj;

import com.talabat.darkstores.feature.home.HomeFragmentViewModel;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public final /* synthetic */ class a0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeFragmentViewModel f56728b;

    public /* synthetic */ a0(HomeFragmentViewModel homeFragmentViewModel) {
        this.f56728b = homeFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return HomeFragmentViewModel.m9965_init_$lambda9(this.f56728b, (Observable) obj);
    }
}
