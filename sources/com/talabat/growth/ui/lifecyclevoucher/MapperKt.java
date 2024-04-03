package com.talabat.growth.ui.lifecyclevoucher;

import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.GuestWelcomeVoucherDomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toDisplayModel", "Lcom/talabat/growth/ui/lifecyclevoucher/LoginLifecycleVoucherDisplayModel;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/GuestWelcomeVoucherDomainModel;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MapperKt {
    @NotNull
    public static final LoginLifecycleVoucherDisplayModel toDisplayModel(@NotNull GuestWelcomeVoucherDomainModel guestWelcomeVoucherDomainModel) {
        Intrinsics.checkNotNullParameter(guestWelcomeVoucherDomainModel, "<this>");
        return new LoginLifecycleVoucherDisplayModel(guestWelcomeVoucherDomainModel.getTitle(), guestWelcomeVoucherDomainModel.getTag(), guestWelcomeVoucherDomainModel.getTermsAndConditions(), guestWelcomeVoucherDomainModel.getDescription());
    }
}
