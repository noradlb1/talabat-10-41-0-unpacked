package com.talabat.feature.ridertips.data.di;

import com.talabat.feature.ridertips.data.RiderTipRepository;
import com.talabat.feature.ridertips.data.convert.IRiderTipResponseToRiderTipMapper;
import com.talabat.feature.ridertips.data.convert.RiderTipResponseToRiderTipMapper;
import com.talabat.feature.ridertips.data.observability.RiderTipObservability;
import com.talabat.feature.ridertips.data.tracking.RiderTipTracker;
import com.talabat.feature.ridertips.domain.IRiderTipObservability;
import com.talabat.feature.ridertips.domain.IRiderTipRepository;
import com.talabat.feature.ridertips.domain.IRiderTipTracker;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH'¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/ridertips/data/di/RiderTipFeatureModule;", "", "riderTipObservability", "Lcom/talabat/feature/ridertips/domain/IRiderTipObservability;", "impl", "Lcom/talabat/feature/ridertips/data/observability/RiderTipObservability;", "riderTipRepository", "Lcom/talabat/feature/ridertips/domain/IRiderTipRepository;", "Lcom/talabat/feature/ridertips/data/RiderTipRepository;", "riderTipResponseToRiderTipMapper", "Lcom/talabat/feature/ridertips/data/convert/IRiderTipResponseToRiderTipMapper;", "Lcom/talabat/feature/ridertips/data/convert/RiderTipResponseToRiderTipMapper;", "tracker", "Lcom/talabat/feature/ridertips/domain/IRiderTipTracker;", "Lcom/talabat/feature/ridertips/data/tracking/RiderTipTracker;", "com_talabat_feature_ridertips_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {RiderTipNetworkModule.class, RiderTipUserDataModule.class})
public interface RiderTipFeatureModule {
    @NotNull
    @Binds
    IRiderTipObservability riderTipObservability(@NotNull RiderTipObservability riderTipObservability);

    @NotNull
    @Binds
    IRiderTipRepository riderTipRepository(@NotNull RiderTipRepository riderTipRepository);

    @NotNull
    @Binds
    IRiderTipResponseToRiderTipMapper riderTipResponseToRiderTipMapper(@NotNull RiderTipResponseToRiderTipMapper riderTipResponseToRiderTipMapper);

    @NotNull
    @Binds
    IRiderTipTracker tracker(@NotNull RiderTipTracker riderTipTracker);
}
