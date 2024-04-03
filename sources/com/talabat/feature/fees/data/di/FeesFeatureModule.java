package com.talabat.feature.fees.data.di;

import com.talabat.feature.fees.data.local.InMemoryFeesDataSource;
import com.talabat.feature.fees.data.local.LocalFeesDataSource;
import com.talabat.feature.fees.data.repository.DisclaimerRepository;
import com.talabat.feature.fees.data.repository.PricingRepository;
import com.talabat.feature.fees.data.tracking.FeesTracker;
import com.talabat.feature.fees.domain.IFeesTracker;
import com.talabat.feature.fees.domain.repository.IDisclaimerRepository;
import com.talabat.feature.fees.domain.repository.IPricingRepository;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH'¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/fees/data/di/FeesFeatureModule;", "", "disclaimerRepository", "Lcom/talabat/feature/fees/domain/repository/IDisclaimerRepository;", "impl", "Lcom/talabat/feature/fees/data/repository/DisclaimerRepository;", "localFeesDataSource", "Lcom/talabat/feature/fees/data/local/LocalFeesDataSource;", "Lcom/talabat/feature/fees/data/local/InMemoryFeesDataSource;", "pricingRepository", "Lcom/talabat/feature/fees/domain/repository/IPricingRepository;", "Lcom/talabat/feature/fees/data/repository/PricingRepository;", "tracker", "Lcom/talabat/feature/fees/domain/IFeesTracker;", "Lcom/talabat/feature/fees/data/tracking/FeesTracker;", "com_talabat_feature_pricing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {FeesRemoteModule.class, FeesLocalModule.class, UserDataModule.class, FeesDomainModule.class})
public interface FeesFeatureModule {
    @NotNull
    @Binds
    IDisclaimerRepository disclaimerRepository(@NotNull DisclaimerRepository disclaimerRepository);

    @NotNull
    @Binds
    @Reusable
    LocalFeesDataSource localFeesDataSource(@NotNull InMemoryFeesDataSource inMemoryFeesDataSource);

    @NotNull
    @Binds
    IPricingRepository pricingRepository(@NotNull PricingRepository pricingRepository);

    @NotNull
    @Binds
    IFeesTracker tracker(@NotNull FeesTracker feesTracker);
}
