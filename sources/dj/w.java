package dj;

import com.talabat.darkstores.feature.home.HomeFragmentViewModel;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public final /* synthetic */ class w implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeFragmentViewModel f56760b;

    public /* synthetic */ w(HomeFragmentViewModel homeFragmentViewModel) {
        this.f56760b = homeFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return HomeFragmentViewModel.m9959_init_$lambda1(this.f56760b, (Observable) obj);
    }
}
