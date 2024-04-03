package com.talabat.talabatcommon.helpers;

import com.talabat.talabatcommon.constants.OrderStatusConstants;
import com.talabat.talabatcommon.utils.DateConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\u0018\u0000 (2\u00020\u0001:\u0001(BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0002J\b\u0010\u0019\u001a\u00020\u0003H\u0002J\b\u0010\u001a\u001a\u00020\u0003H\u0002J\b\u0010\u001b\u001a\u00020\u0003H\u0002J\b\u0010\u001c\u001a\u00020\u0003H\u0002J\b\u0010\u001d\u001a\u00020\u0003H\u0002J\u0006\u0010\u001e\u001a\u00020\u0003J\b\u0010\u001f\u001a\u00020\u0003H\u0002J\u0006\u0010 \u001a\u00020\u0003J\b\u0010!\u001a\u00020\u0003H\u0002J\b\u0010\"\u001a\u00020\u0003H\u0002J\b\u0010#\u001a\u00020\u0003H\u0002J&\u0010$\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/talabat/talabatcommon/helpers/OrderTrackingApplicabilityHelper;", "", "isTracking", "", "isOrderStatus", "newOrderStatus", "", "isPreOrder", "orderReceivedTime", "", "preOrderDeliveryTime", "serverTime", "(ZZIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDefaultDateTimeFormat", "Ljava/text/SimpleDateFormat;", "getOrderReceivedTime", "", "getPreOrderDeliveryTime", "getPreOrderThreshold", "getServerDateTimeFormat", "getServerTime", "getThreshold", "getTimeElapsedSinceOrderReceived", "getTimeElapsedSincePreOrderDeliveryTime", "isNewOrderStatus", "isNewOrderStatusEqualToOldOrderStatus", "isNewOrderStatusNotEqualToOldOrderStatus", "isNotPreOrder", "isOneOfNewOrderStatus", "isOrderStatusNotDelivered", "isOrderTrackingApplicable", "isPreOrderDeliveryTimeExists", "isTimeElapsedSinceOrderReceivedTimeLessThanThreshold", "isTimeElapsedSincePreOrderDeliveryTimeLessThanThreshold", "shouldShowOrderTrackingBasedOnTimeElapsedSinceOrderReceived", "shouldShowOrderTrackingBasedOnTimeElapsedSincePreOrderDeliveryTime", "tryParse", "str", "format", "defaultValue", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderTrackingApplicabilityHelper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int THRESHOLD_TO_ENABLE_ORDER_TRACKING_IN_HOURS = 2;
    private static final int THRESHOLD_TO_ENABLE_PRE_ORDER_TRACKING_IN_HOURS = 1;
    private final boolean isOrderStatus;
    private final boolean isPreOrder;
    private final boolean isTracking;
    private final int newOrderStatus;
    @Nullable
    private final String orderReceivedTime;
    @Nullable
    private final String preOrderDeliveryTime;
    @Nullable
    private final String serverTime;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatcommon/helpers/OrderTrackingApplicabilityHelper$Companion;", "", "()V", "THRESHOLD_TO_ENABLE_ORDER_TRACKING_IN_HOURS", "", "THRESHOLD_TO_ENABLE_PRE_ORDER_TRACKING_IN_HOURS", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public OrderTrackingApplicabilityHelper() {
        this(false, false, 0, false, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public OrderTrackingApplicabilityHelper(boolean z11, boolean z12, int i11, boolean z13, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.isTracking = z11;
        this.isOrderStatus = z12;
        this.newOrderStatus = i11;
        this.isPreOrder = z13;
        this.orderReceivedTime = str;
        this.preOrderDeliveryTime = str2;
        this.serverTime = str3;
    }

    public static /* synthetic */ long a(OrderTrackingApplicabilityHelper orderTrackingApplicabilityHelper, String str, SimpleDateFormat simpleDateFormat, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            simpleDateFormat = orderTrackingApplicabilityHelper.getDefaultDateTimeFormat();
        }
        if ((i11 & 4) != 0) {
            j11 = 0;
        }
        return orderTrackingApplicabilityHelper.tryParse(str, simpleDateFormat, j11);
    }

    private final SimpleDateFormat getDefaultDateTimeFormat() {
        return new SimpleDateFormat(DateConstants.DEFAULT_UTC_FORMAT, Locale.US);
    }

    private final long getOrderReceivedTime() {
        return a(this, this.orderReceivedTime, (SimpleDateFormat) null, 0, 6, (Object) null);
    }

    private final long getPreOrderDeliveryTime() {
        return a(this, this.preOrderDeliveryTime, (SimpleDateFormat) null, 0, 6, (Object) null);
    }

    private final long getPreOrderThreshold() {
        return TimeUnit.HOURS.toMillis(1) * 1;
    }

    private final SimpleDateFormat getServerDateTimeFormat() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSZZZ", Locale.US);
    }

    private final long getServerTime() {
        return a(this, this.serverTime, getServerDateTimeFormat(), 0, 4, (Object) null);
    }

    private final long getThreshold() {
        return ((long) 2) * TimeUnit.HOURS.toMillis(1);
    }

    private final long getTimeElapsedSinceOrderReceived() {
        return getServerTime() - getOrderReceivedTime();
    }

    private final long getTimeElapsedSincePreOrderDeliveryTime() {
        return getServerTime() - getPreOrderDeliveryTime();
    }

    private final boolean isNewOrderStatus() {
        return isNewOrderStatusNotEqualToOldOrderStatus() || isOneOfNewOrderStatus();
    }

    private final boolean isNewOrderStatusEqualToOldOrderStatus() {
        return this.newOrderStatus == -5;
    }

    private final boolean isNewOrderStatusNotEqualToOldOrderStatus() {
        return this.newOrderStatus != -5;
    }

    private final boolean isNotPreOrder() {
        return !this.isPreOrder;
    }

    private final boolean isOneOfNewOrderStatus() {
        return OrderStatusConstants.INSTANCE.isNewStatusOrNot(this.newOrderStatus);
    }

    private final boolean isOrderStatusNotDelivered() {
        return this.newOrderStatus != 4;
    }

    private final boolean isPreOrderDeliveryTimeExists() {
        String str = this.preOrderDeliveryTime;
        return !(str == null || str.length() == 0);
    }

    private final boolean isTimeElapsedSincePreOrderDeliveryTimeLessThanThreshold() {
        return getTimeElapsedSincePreOrderDeliveryTime() <= getPreOrderThreshold();
    }

    private final boolean shouldShowOrderTrackingBasedOnTimeElapsedSinceOrderReceived() {
        boolean z11;
        boolean z12;
        String str = this.serverTime;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return false;
        }
        String str2 = this.orderReceivedTime;
        if (str2 == null || str2.length() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12 || !isTimeElapsedSinceOrderReceivedTimeLessThanThreshold()) {
            return false;
        }
        return true;
    }

    private final boolean shouldShowOrderTrackingBasedOnTimeElapsedSincePreOrderDeliveryTime() {
        boolean z11;
        boolean z12;
        String str = this.serverTime;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return false;
        }
        String str2 = this.preOrderDeliveryTime;
        if (str2 == null || str2.length() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12 || !isTimeElapsedSincePreOrderDeliveryTimeLessThanThreshold()) {
            return false;
        }
        return true;
    }

    private final long tryParse(String str, SimpleDateFormat simpleDateFormat, long j11) {
        try {
            return simpleDateFormat.parse(str).getTime();
        } catch (ParseException unused) {
            return j11;
        }
    }

    public final boolean isOrderTrackingApplicable() {
        if (this.isPreOrder && isPreOrderDeliveryTimeExists()) {
            return shouldShowOrderTrackingBasedOnTimeElapsedSincePreOrderDeliveryTime();
        }
        if (!this.isPreOrder || !this.isTracking || !this.isOrderStatus) {
            if (!isNotPreOrder() || !this.isTracking || !this.isOrderStatus) {
                if ((!isNotPreOrder() || ((!this.isTracking && !shouldShowOrderTrackingBasedOnTimeElapsedSinceOrderReceived()) || !this.isOrderStatus)) && (!isNotPreOrder() || !shouldShowOrderTrackingBasedOnTimeElapsedSinceOrderReceived() || !isNewOrderStatusEqualToOldOrderStatus())) {
                    return false;
                }
            } else if (isNewOrderStatus()) {
                return isOrderStatusNotDelivered();
            }
        } else if (isNewOrderStatus()) {
            return isOrderStatusNotDelivered();
        }
        return true;
    }

    public final boolean isTimeElapsedSinceOrderReceivedTimeLessThanThreshold() {
        return getTimeElapsedSinceOrderReceived() <= getThreshold();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderTrackingApplicabilityHelper(boolean r6, boolean r7, int r8, boolean r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            r0 = 0
            if (r14 == 0) goto L_0x0007
            r14 = r0
            goto L_0x0008
        L_0x0007:
            r14 = r6
        L_0x0008:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r13 & 8
            if (r6 == 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r0 = r9
        L_0x001c:
            r6 = r13 & 16
            r7 = 0
            if (r6 == 0) goto L_0x0023
            r3 = r7
            goto L_0x0024
        L_0x0023:
            r3 = r10
        L_0x0024:
            r6 = r13 & 32
            if (r6 == 0) goto L_0x002a
            r4 = r7
            goto L_0x002b
        L_0x002a:
            r4 = r11
        L_0x002b:
            r6 = r13 & 64
            if (r6 == 0) goto L_0x0031
            r13 = r7
            goto L_0x0032
        L_0x0031:
            r13 = r12
        L_0x0032:
            r6 = r5
            r7 = r14
            r8 = r1
            r9 = r2
            r10 = r0
            r11 = r3
            r12 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.helpers.OrderTrackingApplicabilityHelper.<init>(boolean, boolean, int, boolean, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
