package com.talabat.feature.tmart.growth.data.remote.model;

import androidx.core.app.NotificationCompat;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthReminder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u000b\f\r\u000e\u000fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0001\u0004\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminderResponse;", "", "()V", "reminder", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder;", "getReminder", "()Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder;", "trackingInfo", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;", "getTrackingInfo", "()Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;", "Basic", "Plain", "Rich", "Type", "Unknown", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminderResponse$Plain;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminderResponse$Basic;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminderResponse$Rich;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminderResponse$Unknown;", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class TMartGrowthReminderResponse {

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminderResponse$Basic;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminderResponse;", "reminder", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder$Basic;", "trackingInfo", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;", "(Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder$Basic;Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;)V", "getReminder", "()Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder$Basic;", "getTrackingInfo", "()Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Basic extends TMartGrowthReminderResponse {
        @NotNull
        private final TMartGrowthReminder.Basic reminder;
        @Nullable
        private final TMartGrowthTrackingInfoResponse trackingInfo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Basic(@NotNull @Json(name = "data") TMartGrowthReminder.Basic basic, @Nullable @Json(name = "tracking_info") TMartGrowthTrackingInfoResponse tMartGrowthTrackingInfoResponse) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(basic, NotificationCompat.CATEGORY_REMINDER);
            this.reminder = basic;
            this.trackingInfo = tMartGrowthTrackingInfoResponse;
        }

        public static /* synthetic */ Basic copy$default(Basic basic, TMartGrowthReminder.Basic basic2, TMartGrowthTrackingInfoResponse tMartGrowthTrackingInfoResponse, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                basic2 = basic.getReminder();
            }
            if ((i11 & 2) != 0) {
                tMartGrowthTrackingInfoResponse = basic.getTrackingInfo();
            }
            return basic.copy(basic2, tMartGrowthTrackingInfoResponse);
        }

        @NotNull
        public final TMartGrowthReminder.Basic component1() {
            return getReminder();
        }

        @Nullable
        public final TMartGrowthTrackingInfoResponse component2() {
            return getTrackingInfo();
        }

        @NotNull
        public final Basic copy(@NotNull @Json(name = "data") TMartGrowthReminder.Basic basic, @Nullable @Json(name = "tracking_info") TMartGrowthTrackingInfoResponse tMartGrowthTrackingInfoResponse) {
            Intrinsics.checkNotNullParameter(basic, NotificationCompat.CATEGORY_REMINDER);
            return new Basic(basic, tMartGrowthTrackingInfoResponse);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Basic)) {
                return false;
            }
            Basic basic = (Basic) obj;
            return Intrinsics.areEqual((Object) getReminder(), (Object) basic.getReminder()) && Intrinsics.areEqual((Object) getTrackingInfo(), (Object) basic.getTrackingInfo());
        }

        @Nullable
        public TMartGrowthTrackingInfoResponse getTrackingInfo() {
            return this.trackingInfo;
        }

        public int hashCode() {
            return (getReminder().hashCode() * 31) + (getTrackingInfo() == null ? 0 : getTrackingInfo().hashCode());
        }

        @NotNull
        public String toString() {
            TMartGrowthReminder.Basic reminder2 = getReminder();
            TMartGrowthTrackingInfoResponse trackingInfo2 = getTrackingInfo();
            return "Basic(reminder=" + reminder2 + ", trackingInfo=" + trackingInfo2 + ")";
        }

        @NotNull
        public TMartGrowthReminder.Basic getReminder() {
            return this.reminder;
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminderResponse$Plain;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminderResponse;", "reminder", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder$Plain;", "(Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder$Plain;)V", "getReminder", "()Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder$Plain;", "trackingInfo", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;", "getTrackingInfo", "()Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Plain extends TMartGrowthReminderResponse {
        @NotNull
        private final TMartGrowthReminder.Plain reminder;
        @Nullable
        private final TMartGrowthTrackingInfoResponse trackingInfo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Plain(@NotNull @Json(name = "data") TMartGrowthReminder.Plain plain) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(plain, NotificationCompat.CATEGORY_REMINDER);
            this.reminder = plain;
        }

        public static /* synthetic */ Plain copy$default(Plain plain, TMartGrowthReminder.Plain plain2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                plain2 = plain.getReminder();
            }
            return plain.copy(plain2);
        }

        @NotNull
        public final TMartGrowthReminder.Plain component1() {
            return getReminder();
        }

        @NotNull
        public final Plain copy(@NotNull @Json(name = "data") TMartGrowthReminder.Plain plain) {
            Intrinsics.checkNotNullParameter(plain, NotificationCompat.CATEGORY_REMINDER);
            return new Plain(plain);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Plain) && Intrinsics.areEqual((Object) getReminder(), (Object) ((Plain) obj).getReminder());
        }

        @Nullable
        public TMartGrowthTrackingInfoResponse getTrackingInfo() {
            return this.trackingInfo;
        }

        public int hashCode() {
            return getReminder().hashCode();
        }

        @NotNull
        public String toString() {
            TMartGrowthReminder.Plain reminder2 = getReminder();
            return "Plain(reminder=" + reminder2 + ")";
        }

        @NotNull
        public TMartGrowthReminder.Plain getReminder() {
            return this.reminder;
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminderResponse$Rich;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminderResponse;", "reminder", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder$Rich;", "trackingInfo", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;", "(Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder$Rich;Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;)V", "getReminder", "()Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder$Rich;", "getTrackingInfo", "()Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Rich extends TMartGrowthReminderResponse {
        @NotNull
        private final TMartGrowthReminder.Rich reminder;
        @Nullable
        private final TMartGrowthTrackingInfoResponse trackingInfo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Rich(@NotNull @Json(name = "data") TMartGrowthReminder.Rich rich, @Nullable @Json(name = "tracking_info") TMartGrowthTrackingInfoResponse tMartGrowthTrackingInfoResponse) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(rich, NotificationCompat.CATEGORY_REMINDER);
            this.reminder = rich;
            this.trackingInfo = tMartGrowthTrackingInfoResponse;
        }

        public static /* synthetic */ Rich copy$default(Rich rich, TMartGrowthReminder.Rich rich2, TMartGrowthTrackingInfoResponse tMartGrowthTrackingInfoResponse, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                rich2 = rich.getReminder();
            }
            if ((i11 & 2) != 0) {
                tMartGrowthTrackingInfoResponse = rich.getTrackingInfo();
            }
            return rich.copy(rich2, tMartGrowthTrackingInfoResponse);
        }

        @NotNull
        public final TMartGrowthReminder.Rich component1() {
            return getReminder();
        }

        @Nullable
        public final TMartGrowthTrackingInfoResponse component2() {
            return getTrackingInfo();
        }

        @NotNull
        public final Rich copy(@NotNull @Json(name = "data") TMartGrowthReminder.Rich rich, @Nullable @Json(name = "tracking_info") TMartGrowthTrackingInfoResponse tMartGrowthTrackingInfoResponse) {
            Intrinsics.checkNotNullParameter(rich, NotificationCompat.CATEGORY_REMINDER);
            return new Rich(rich, tMartGrowthTrackingInfoResponse);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Rich)) {
                return false;
            }
            Rich rich = (Rich) obj;
            return Intrinsics.areEqual((Object) getReminder(), (Object) rich.getReminder()) && Intrinsics.areEqual((Object) getTrackingInfo(), (Object) rich.getTrackingInfo());
        }

        @Nullable
        public TMartGrowthTrackingInfoResponse getTrackingInfo() {
            return this.trackingInfo;
        }

        public int hashCode() {
            return (getReminder().hashCode() * 31) + (getTrackingInfo() == null ? 0 : getTrackingInfo().hashCode());
        }

        @NotNull
        public String toString() {
            TMartGrowthReminder.Rich reminder2 = getReminder();
            TMartGrowthTrackingInfoResponse trackingInfo2 = getTrackingInfo();
            return "Rich(reminder=" + reminder2 + ", trackingInfo=" + trackingInfo2 + ")";
        }

        @NotNull
        public TMartGrowthReminder.Rich getReminder() {
            return this.reminder;
        }
    }

    @JsonClass(generateAdapter = false)
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminderResponse$Type;", "", "apiName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getApiName", "()Ljava/lang/String;", "MESSAGE_PLAIN", "WIDGET_BASIC", "WIDGET_RICH", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Type {
        MESSAGE_PLAIN("reminder_message_plain"),
        WIDGET_BASIC("reminder_widget_basic"),
        WIDGET_RICH("reminder_widget_rich");
        
        @NotNull
        private final String apiName;

        private Type(String str) {
            this.apiName = str;
        }

        @NotNull
        public final String getApiName() {
            return this.apiName;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminderResponse$Unknown;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminderResponse;", "()V", "reminder", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder;", "getReminder", "()Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminder;", "trackingInfo", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;", "getTrackingInfo", "()Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Unknown extends TMartGrowthReminderResponse {
        @NotNull
        public static final Unknown INSTANCE = new Unknown();
        @NotNull
        private static final TMartGrowthReminder reminder = TMartGrowthReminder.Unknown.INSTANCE;
        @Nullable
        private static final TMartGrowthTrackingInfoResponse trackingInfo = null;

        private Unknown() {
            super((DefaultConstructorMarker) null);
        }

        @NotNull
        public TMartGrowthReminder getReminder() {
            return reminder;
        }

        @Nullable
        public TMartGrowthTrackingInfoResponse getTrackingInfo() {
            return trackingInfo;
        }
    }

    private TMartGrowthReminderResponse() {
    }

    public /* synthetic */ TMartGrowthReminderResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract TMartGrowthReminder getReminder();

    @Nullable
    public abstract TMartGrowthTrackingInfoResponse getTrackingInfo();
}
