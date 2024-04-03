package com.talabat.homescreen.widget;

import android.content.Context;
import androidx.lifecycle.ViewModelProvider;
import com.talabat.growth.ui.loyalty.HomeScreenHeaderRewardsViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenHeaderRewardsView$viewModel$2 extends Lambda implements Function0<ViewModelProvider.Factory> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f60978g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ HomeScreenHeaderRewardsView f60979h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeScreenHeaderRewardsView$viewModel$2(Context context, HomeScreenHeaderRewardsView homeScreenHeaderRewardsView) {
        super(0);
        this.f60978g = context;
        this.f60979h = homeScreenHeaderRewardsView;
    }

    @NotNull
    public final ViewModelProvider.Factory invoke() {
        return new HomeScreenHeaderRewardsViewModelFactory(this.f60978g, this.f60979h.getConfigurationLocalRepository(), this.f60979h.coroutineScope, this.f60979h.getCoroutineDispatchersFactory(), this.f60979h.getFeatureFlagRepo());
    }
}
