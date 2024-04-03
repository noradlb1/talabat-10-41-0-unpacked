package com.talabat.feature.cancellationpolicy.di;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.cancellationpolicy.HelpCenterEventTracker;
import com.talabat.feature.cancellationpolicy.domain.ICancellationPolicyFlag;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterEventTracker;
import com.talabat.feature.cancellationpolicy.domain.repo.ICancellationPolicyRepository;
import com.talabat.feature.cancellationpolicy.mapper.CancellationPolicyMapper;
import com.talabat.feature.cancellationpolicy.mapper.ICancellationPolicyMapper;
import com.talabat.feature.cancellationpolicy.remote.CancellationPolicyService;
import com.talabat.feature.cancellationpolicy.repo.CancellationPolicyFlag;
import com.talabat.feature.cancellationpolicy.repo.CancellationPolicyRepository;
import com.talabat.feature.cancellationpolicy.repo.HelpCenterDeeplinkBuilder;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J4\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0010H\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/di/HelpCenterFeatureModule;", "", "()V", "cancellationPolicyMapper", "Lcom/talabat/feature/cancellationpolicy/mapper/ICancellationPolicyMapper;", "provideCancellationPolicyFeatureFlag", "Lcom/talabat/feature/cancellationpolicy/domain/ICancellationPolicyFlag;", "iTalabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "provideGetPastOrderRepository", "Lcom/talabat/feature/cancellationpolicy/domain/repo/ICancellationPolicyRepository;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "cancellationPolicyService", "Lcom/talabat/feature/cancellationpolicy/remote/CancellationPolicyService;", "countryId", "", "verticalType", "provideHelpCenterDeeplinkNavigator", "Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;", "provideHelpCenterEventTracker", "Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterEventTracker;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "com_talabat_feature_helpcenter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {HelpCenterUserDataModule.class, HelpCenterNetworkModule.class})
public final class HelpCenterFeatureModule {
    @NotNull
    public static final HelpCenterFeatureModule INSTANCE = new HelpCenterFeatureModule();

    private HelpCenterFeatureModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final ICancellationPolicyMapper cancellationPolicyMapper() {
        return new CancellationPolicyMapper();
    }

    @NotNull
    @Reusable
    @Provides
    public final ICancellationPolicyFlag provideCancellationPolicyFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "iTalabatFeatureFlag");
        return new CancellationPolicyFlag(iTalabatFeatureFlag);
    }

    @NotNull
    @Reusable
    @Provides
    public final ICancellationPolicyRepository provideGetPastOrderRepository(@NotNull CoroutineDispatchersFactory coroutineDispatchersFactory, @NotNull CancellationPolicyService cancellationPolicyService, @NotNull ICancellationPolicyMapper iCancellationPolicyMapper, @Named("countryId") int i11, @Named("verticalType") int i12) {
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "coroutineDispatchersFactory");
        Intrinsics.checkNotNullParameter(cancellationPolicyService, "cancellationPolicyService");
        Intrinsics.checkNotNullParameter(iCancellationPolicyMapper, "cancellationPolicyMapper");
        return new CancellationPolicyRepository(cancellationPolicyService, iCancellationPolicyMapper, coroutineDispatchersFactory.io(), String.valueOf(i11), String.valueOf(i12));
    }

    @NotNull
    @Reusable
    @Provides
    public final IHelpCenterDeeplinkBuilder provideHelpCenterDeeplinkNavigator() {
        return new HelpCenterDeeplinkBuilder();
    }

    @NotNull
    @Reusable
    @Provides
    public final IHelpCenterEventTracker provideHelpCenterEventTracker(@NotNull TalabatTracker talabatTracker) {
        Intrinsics.checkNotNullParameter(talabatTracker, "talabatTracker");
        return new HelpCenterEventTracker(talabatTracker);
    }
}
