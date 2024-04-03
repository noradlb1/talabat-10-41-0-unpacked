package com.talabat.growth.ui.loyalty;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.growth.features.loyalty.IsRewardsPointsBannerVisible;
import com.talabat.growth.features.loyalty.IsUserRewardsEnabled;
import com.talabat.growth.features.loyalty.network.GetPointsService;
import com.talabat.growth.features.loyalty.sharedpreferences.IsUserRewardsSharedPreferences;
import com.talabat.talabatcore.platform.NetworkHandler;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ%\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011H\u0016¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/growth/ui/loyalty/HomeScreenHeaderRewardsViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "context", "Landroid/content/Context;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Landroid/content/Context;Lcom/talabat/configuration/ConfigurationLocalRepository;Lkotlinx/coroutines/CoroutineScope;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenHeaderRewardsViewModelFactory implements ViewModelProvider.Factory {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final Context context;
    @NotNull
    private final CoroutineDispatchersFactory coroutineDispatchersFactory;
    @NotNull
    private final CoroutineScope coroutineScope;
    @NotNull
    private final ITalabatFeatureFlag featureFlagRepo;

    public HomeScreenHeaderRewardsViewModelFactory(@NotNull Context context2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull CoroutineScope coroutineScope2, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "coroutineDispatchersFactory");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        this.context = context2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.coroutineScope = coroutineScope2;
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        NetworkHandler networkHandler = new NetworkHandler(this.context);
        GetPointsService getPointsService = new GetPointsService(new TalabatAPIBuilder());
        NetworkHandler networkHandler2 = networkHandler;
        GetPointsService getPointsService2 = getPointsService;
        return new HomeScreenHeaderRewardsViewModel(new IsUserRewardsSharedPreferences(this.context), new IsUserRewardsEnabled(networkHandler2, getPointsService2, this.configurationLocalRepository, this.coroutineScope, this.coroutineDispatchersFactory.io()), this.featureFlagRepo, new IsRewardsPointsBannerVisible(networkHandler2, getPointsService2, this.configurationLocalRepository, this.coroutineScope, this.coroutineDispatchersFactory.io()));
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }
}
