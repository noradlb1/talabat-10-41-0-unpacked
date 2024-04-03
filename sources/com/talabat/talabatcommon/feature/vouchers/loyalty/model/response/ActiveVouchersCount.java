package com.talabat.talabatcommon.feature.vouchers.loyalty.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.VoucherNotificationStyle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/ActiveVouchersCount;", "", "totalActiveCount", "", "notificationLabel", "", "notificationStyle", "Llibrary/talabat/mvp/home/VoucherNotificationStyle;", "(ILjava/lang/String;Llibrary/talabat/mvp/home/VoucherNotificationStyle;)V", "getNotificationLabel", "()Ljava/lang/String;", "getNotificationStyle", "()Llibrary/talabat/mvp/home/VoucherNotificationStyle;", "getTotalActiveCount", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActiveVouchersCount {
    @SerializedName("notificationLabel")
    @Nullable
    private final String notificationLabel;
    @SerializedName("notificationStyle")
    @Nullable
    private final VoucherNotificationStyle notificationStyle;
    @SerializedName("totalActiveCount")
    private final int totalActiveCount;

    public ActiveVouchersCount(int i11, @Nullable String str, @Nullable VoucherNotificationStyle voucherNotificationStyle) {
        this.totalActiveCount = i11;
        this.notificationLabel = str;
        this.notificationStyle = voucherNotificationStyle;
    }

    public static /* synthetic */ ActiveVouchersCount copy$default(ActiveVouchersCount activeVouchersCount, int i11, String str, VoucherNotificationStyle voucherNotificationStyle, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = activeVouchersCount.totalActiveCount;
        }
        if ((i12 & 2) != 0) {
            str = activeVouchersCount.notificationLabel;
        }
        if ((i12 & 4) != 0) {
            voucherNotificationStyle = activeVouchersCount.notificationStyle;
        }
        return activeVouchersCount.copy(i11, str, voucherNotificationStyle);
    }

    public final int component1() {
        return this.totalActiveCount;
    }

    @Nullable
    public final String component2() {
        return this.notificationLabel;
    }

    @Nullable
    public final VoucherNotificationStyle component3() {
        return this.notificationStyle;
    }

    @NotNull
    public final ActiveVouchersCount copy(int i11, @Nullable String str, @Nullable VoucherNotificationStyle voucherNotificationStyle) {
        return new ActiveVouchersCount(i11, str, voucherNotificationStyle);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveVouchersCount)) {
            return false;
        }
        ActiveVouchersCount activeVouchersCount = (ActiveVouchersCount) obj;
        return this.totalActiveCount == activeVouchersCount.totalActiveCount && Intrinsics.areEqual((Object) this.notificationLabel, (Object) activeVouchersCount.notificationLabel) && this.notificationStyle == activeVouchersCount.notificationStyle;
    }

    @Nullable
    public final String getNotificationLabel() {
        return this.notificationLabel;
    }

    @Nullable
    public final VoucherNotificationStyle getNotificationStyle() {
        return this.notificationStyle;
    }

    public final int getTotalActiveCount() {
        return this.totalActiveCount;
    }

    public int hashCode() {
        int i11 = this.totalActiveCount * 31;
        String str = this.notificationLabel;
        int i12 = 0;
        int hashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        VoucherNotificationStyle voucherNotificationStyle = this.notificationStyle;
        if (voucherNotificationStyle != null) {
            i12 = voucherNotificationStyle.hashCode();
        }
        return hashCode + i12;
    }

    @NotNull
    public String toString() {
        int i11 = this.totalActiveCount;
        String str = this.notificationLabel;
        VoucherNotificationStyle voucherNotificationStyle = this.notificationStyle;
        return "ActiveVouchersCount(totalActiveCount=" + i11 + ", notificationLabel=" + str + ", notificationStyle=" + voucherNotificationStyle + ")";
    }
}
