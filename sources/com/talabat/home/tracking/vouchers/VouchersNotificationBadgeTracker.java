package com.talabat.home.tracking.vouchers;

import com.talabat.core.tracking.domain.TalabatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.VoucherStateDomainModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/home/tracking/vouchers/VouchersNotificationBadgeTracker;", "", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "trackVouchersNotificationBadgeLoaded", "", "eventSource", "Lcom/talabat/home/tracking/vouchers/VoucherBadgeEventSource;", "data", "Llibrary/talabat/mvp/home/VoucherStateDomainModel;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VouchersNotificationBadgeTracker {
    @NotNull
    private final TalabatTracker talabatTracker;

    public VouchersNotificationBadgeTracker(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.talabatTracker = talabatTracker2;
    }

    public final void trackVouchersNotificationBadgeLoaded(@NotNull VoucherBadgeEventSource voucherBadgeEventSource, @Nullable VoucherStateDomainModel voucherStateDomainModel) {
        String notificationLabel;
        Intrinsics.checkNotNullParameter(voucherBadgeEventSource, "eventSource");
        boolean z11 = false;
        if (!(voucherStateDomainModel == null || (notificationLabel = voucherStateDomainModel.getNotificationLabel()) == null || !(!StringsKt__StringsJVMKt.isBlank(notificationLabel)))) {
            z11 = true;
        }
        if (z11) {
            this.talabatTracker.track(new VouchersNotificationBadgeLoadedEvent(voucherBadgeEventSource, voucherStateDomainModel));
        }
    }
}
