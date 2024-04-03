package com.talabat.home.tracking.vouchers;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.feature.bnplcore.domain.model.BnplNavigationOptionLoadedEventKt;
import com.talabat.home.useraccount.tracking.UserAccountTracker;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.VoucherNotificationStyle;
import library.talabat.mvp.home.VoucherStateDomainModel;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J&\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002J.\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u001e\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/home/tracking/vouchers/VouchersNotificationBadgeLoadedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "eventSource", "Lcom/talabat/home/tracking/vouchers/VoucherBadgeEventSource;", "data", "Llibrary/talabat/mvp/home/VoucherStateDomainModel;", "(Lcom/talabat/home/tracking/vouchers/VoucherBadgeEventSource;Llibrary/talabat/mvp/home/VoucherStateDomainModel;)V", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "getAccountAttributes", "notificationType", "notificationValue", "getAttributes", "getHomeAttributes", "getNotificationType", "notificationStyle", "Llibrary/talabat/mvp/home/VoucherNotificationStyle;", "name", "platforms", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VouchersNotificationBadgeLoadedEvent extends TalabatEvent {
    @NotNull
    private final VoucherStateDomainModel data;
    @NotNull
    private final VoucherBadgeEventSource eventSource;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[VoucherBadgeEventSource.values().length];
            iArr[VoucherBadgeEventSource.HOME.ordinal()] = 1;
            iArr[VoucherBadgeEventSource.ACCOUNT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[VoucherNotificationStyle.values().length];
            iArr2[VoucherNotificationStyle.INFO.ordinal()] = 1;
            iArr2[VoucherNotificationStyle.WARNING.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public VouchersNotificationBadgeLoadedEvent(@NotNull VoucherBadgeEventSource voucherBadgeEventSource, @NotNull VoucherStateDomainModel voucherStateDomainModel) {
        Intrinsics.checkNotNullParameter(voucherBadgeEventSource, "eventSource");
        Intrinsics.checkNotNullParameter(voucherStateDomainModel, "data");
        this.eventSource = voucherBadgeEventSource;
        this.data = voucherStateDomainModel;
    }

    private final Map<String, Object> getAccountAttributes(String str, String str2) {
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("screenType", BnplNavigationOptionLoadedEventKt.VALUE_SCREEN_NAME_NAVIGATION), TuplesKt.to("screenName", BnplNavigationOptionLoadedEventKt.VALUE_SCREEN_TYPE_NAVIGATION_MENU), TuplesKt.to(UserAccountTracker.KEY_BADGE_TYPE, str), TuplesKt.to(UserAccountTracker.KEY_BADGE_VALUE, str2));
    }

    private final Map<String, Object> getAttributes(VoucherBadgeEventSource voucherBadgeEventSource, String str, String str2) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[voucherBadgeEventSource.ordinal()];
        if (i11 == 1) {
            return getHomeAttributes(str);
        }
        if (i11 == 2) {
            return getAccountAttributes(str, str2);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Map<String, Object> getHomeAttributes(String str) {
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("screenType", "account page"), TuplesKt.to("screenName", "account page"), TuplesKt.to(UserAccountTracker.KEY_BADGE_TYPE, "Account notification"), TuplesKt.to(UserAccountTracker.KEY_BADGE_VALUE, str));
    }

    private final String getNotificationType(VoucherNotificationStyle voucherNotificationStyle) {
        int i11 = WhenMappings.$EnumSwitchMapping$1[voucherNotificationStyle.ordinal()];
        return (i11 == 1 || i11 != 2) ? "voucher - unused" : "voucher - expiring";
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return getAttributes(this.eventSource, getNotificationType(this.data.getNotificationStyle()), this.data.getNotificationLabel());
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "voucher_notification_badge";
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "badge_loaded";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }
}
