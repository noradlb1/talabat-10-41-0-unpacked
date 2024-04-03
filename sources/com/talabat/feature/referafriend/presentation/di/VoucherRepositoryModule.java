package com.talabat.feature.referafriend.presentation.di;

import android.content.Context;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcommon.feature.vouchers.loyalty.network.VouchersService;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepositoryImpl;
import com.talabat.talabatcore.platform.NetworkHandler;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/referafriend/presentation/di/VoucherRepositoryModule;", "", "()V", "provideVoucherRepository", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepositoryImpl;", "context", "Landroid/content/Context;", "com_talabat_feature_refer-a-friend_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class VoucherRepositoryModule {
    @NotNull
    public static final VoucherRepositoryModule INSTANCE = new VoucherRepositoryModule();

    private VoucherRepositoryModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final VoucherRepositoryImpl provideVoucherRepository(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new VoucherRepositoryImpl(new NetworkHandler(context), new VouchersService(new TalabatAPIBuilder()));
    }
}
