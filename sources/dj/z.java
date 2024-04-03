package dj;

import com.talabat.darkstores.data.discovery.model.FeedMultiListData;
import com.talabat.darkstores.feature.home.HomeFragmentViewModel;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class z implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeFragmentViewModel f56763b;

    public /* synthetic */ z(HomeFragmentViewModel homeFragmentViewModel) {
        this.f56763b = homeFragmentViewModel;
    }

    public final void accept(Object obj) {
        HomeFragmentViewModel.m9964_init_$lambda5(this.f56763b, (FeedMultiListData) obj);
    }
}
