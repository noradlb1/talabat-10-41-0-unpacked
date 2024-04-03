package com.talabat.di.voucher;

import android.content.Context;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.talabatcommon.feature.vouchers.loyalty.network.VouchersService;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepositoryImpl;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import com.talabat.talabatcore.platform.NetworkHandler;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0007"}, d2 = {"Lcom/talabat/di/voucher/VoucherRepositoryModule;", "", "provideVoucherRepository", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;", "voucherRepositoryImpl", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepositoryImpl;", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface VoucherRepositoryModule {
    @NotNull
    public static final Companion Companion = Companion.f58320a;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/talabat/di/voucher/VoucherRepositoryModule$Companion;", "", "()V", "provideGrowthTracker", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/GrowthTracker;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "provideVoucherRepositoryImpl", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepositoryImpl;", "context", "Landroid/content/Context;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f58320a = new Companion();

        private Companion() {
        }

        @NotNull
        @Provides
        public final GrowthTracker provideGrowthTracker(@NotNull TalabatTracker talabatTracker) {
            Intrinsics.checkNotNullParameter(talabatTracker, "talabatTracker");
            return GrowthTracker.INSTANCE.setTalabatTracker(talabatTracker);
        }

        @NotNull
        @Reusable
        @Provides
        public final VoucherRepositoryImpl provideVoucherRepositoryImpl(@NotNull @ApplicationContext Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new VoucherRepositoryImpl(new NetworkHandler(context), new VouchersService(new TalabatAPIBuilder()));
        }
    }

    @NotNull
    @Binds
    @Reusable
    VoucherRepository provideVoucherRepository(@NotNull VoucherRepositoryImpl voucherRepositoryImpl);
}
