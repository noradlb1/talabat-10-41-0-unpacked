package com.talabat.growth.ui.vouchers.entrypoint;

import android.content.Context;
import androidx.lifecycle.ViewModelProvider;
import com.talabat.growth.ui.loyalty.HomeScreenHeaderRewardsViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenHeaderVouchersView$rewardsViewModel$2 extends Lambda implements Function0<ViewModelProvider.Factory> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f60707g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ HomeScreenHeaderVouchersView f60708h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeScreenHeaderVouchersView$rewardsViewModel$2(Context context, HomeScreenHeaderVouchersView homeScreenHeaderVouchersView) {
        super(0);
        this.f60707g = context;
        this.f60708h = homeScreenHeaderVouchersView;
    }

    @NotNull
    public final ViewModelProvider.Factory invoke() {
        return new HomeScreenHeaderRewardsViewModelFactory(this.f60707g, this.f60708h.getConfigurationLocalRepository(), this.f60708h.coroutineScope, this.f60708h.getCoroutineDispatchersFactory(), this.f60708h.getFeatureFlagRepo());
    }
}
