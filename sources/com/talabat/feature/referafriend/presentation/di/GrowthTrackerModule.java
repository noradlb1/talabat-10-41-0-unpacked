package com.talabat.feature.referafriend.presentation.di;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/referafriend/presentation/di/GrowthTrackerModule;", "", "()V", "provideGrowthTracker", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/GrowthTracker;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "com_talabat_feature_refer-a-friend_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class GrowthTrackerModule {
    @NotNull
    public static final GrowthTrackerModule INSTANCE = new GrowthTrackerModule();

    private GrowthTrackerModule() {
    }

    @NotNull
    @Provides
    public final GrowthTracker provideGrowthTracker(@NotNull TalabatTracker talabatTracker) {
        Intrinsics.checkNotNullParameter(talabatTracker, "talabatTracker");
        return GrowthTracker.INSTANCE.setTalabatTracker(talabatTracker);
    }
}
