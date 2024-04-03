package com.talabat.talabatcommon.views.vouchers.lifecycle;

import android.content.Context;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.lib.Integration;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GuestWelcomeVoucherUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.network.VouchersService;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepositoryImpl;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"getWelcomeVoucherUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/GuestWelcomeVoucherUseCase;", "context", "Landroid/content/Context;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class WelcomeVoucherUseCaseFactoryKt {
    @NotNull
    public static final GuestWelcomeVoucherUseCase getWelcomeVoucherUseCase(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new GuestWelcomeVoucherUseCase(new VoucherRepositoryImpl(new NetworkHandler(context), new VouchersService(new TalabatAPIBuilder())));
    }

    public static /* synthetic */ GuestWelcomeVoucherUseCase getWelcomeVoucherUseCase$default(Context context, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            context = Integration.getAppContext();
        }
        return getWelcomeVoucherUseCase(context);
    }
}
