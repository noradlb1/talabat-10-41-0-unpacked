package com.deliveryhero.chatsdk.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jq\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006*"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/model/PushNotificationData;", "", "channelID", "", "senderName", "orderID", "country", "messageID", "pushID", "message", "pushAlert", "title", "channelType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannelID", "()Ljava/lang/String;", "getChannelType", "getCountry", "getMessage", "getMessageID", "getOrderID", "getPushAlert", "getPushID", "getSenderName", "getTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PushNotificationData {
    @NotNull
    private final String channelID;
    @NotNull
    private final String channelType;
    @NotNull
    private final String country;
    @NotNull
    private final String message;
    @NotNull
    private final String messageID;
    @NotNull
    private final String orderID;
    @Nullable
    private final String pushAlert;
    @NotNull
    private final String pushID;
    @NotNull
    private final String senderName;
    @Nullable
    private final String title;

    public PushNotificationData(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @Nullable String str8, @Nullable String str9, @NotNull String str10) {
        Intrinsics.checkNotNullParameter(str, "channelID");
        Intrinsics.checkNotNullParameter(str2, "senderName");
        Intrinsics.checkNotNullParameter(str3, "orderID");
        Intrinsics.checkNotNullParameter(str4, "country");
        Intrinsics.checkNotNullParameter(str5, "messageID");
        Intrinsics.checkNotNullParameter(str6, "pushID");
        Intrinsics.checkNotNullParameter(str7, "message");
        Intrinsics.checkNotNullParameter(str10, "channelType");
        this.channelID = str;
        this.senderName = str2;
        this.orderID = str3;
        this.country = str4;
        this.messageID = str5;
        this.pushID = str6;
        this.message = str7;
        this.pushAlert = str8;
        this.title = str9;
        this.channelType = str10;
    }

    public static /* synthetic */ PushNotificationData copy$default(PushNotificationData pushNotificationData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i11, Object obj) {
        PushNotificationData pushNotificationData2 = pushNotificationData;
        int i12 = i11;
        return pushNotificationData.copy((i12 & 1) != 0 ? pushNotificationData2.channelID : str, (i12 & 2) != 0 ? pushNotificationData2.senderName : str2, (i12 & 4) != 0 ? pushNotificationData2.orderID : str3, (i12 & 8) != 0 ? pushNotificationData2.country : str4, (i12 & 16) != 0 ? pushNotificationData2.messageID : str5, (i12 & 32) != 0 ? pushNotificationData2.pushID : str6, (i12 & 64) != 0 ? pushNotificationData2.message : str7, (i12 & 128) != 0 ? pushNotificationData2.pushAlert : str8, (i12 & 256) != 0 ? pushNotificationData2.title : str9, (i12 & 512) != 0 ? pushNotificationData2.channelType : str10);
    }

    @NotNull
    public final String component1() {
        return this.channelID;
    }

    @NotNull
    public final String component10() {
        return this.channelType;
    }

    @NotNull
    public final String component2() {
        return this.senderName;
    }

    @NotNull
    public final String component3() {
        return this.orderID;
    }

    @NotNull
    public final String component4() {
        return this.country;
    }

    @NotNull
    public final String component5() {
        return this.messageID;
    }

    @NotNull
    public final String component6() {
        return this.pushID;
    }

    @NotNull
    public final String component7() {
        return this.message;
    }

    @Nullable
    public final String component8() {
        return this.pushAlert;
    }

    @Nullable
    public final String component9() {
        return this.title;
    }

    @NotNull
    public final PushNotificationData copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @Nullable String str8, @Nullable String str9, @NotNull String str10) {
        Intrinsics.checkNotNullParameter(str, "channelID");
        Intrinsics.checkNotNullParameter(str2, "senderName");
        Intrinsics.checkNotNullParameter(str3, "orderID");
        String str11 = str4;
        Intrinsics.checkNotNullParameter(str11, "country");
        String str12 = str5;
        Intrinsics.checkNotNullParameter(str12, "messageID");
        String str13 = str6;
        Intrinsics.checkNotNullParameter(str13, "pushID");
        String str14 = str7;
        Intrinsics.checkNotNullParameter(str14, "message");
        String str15 = str10;
        Intrinsics.checkNotNullParameter(str15, "channelType");
        return new PushNotificationData(str, str2, str3, str11, str12, str13, str14, str8, str9, str15);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PushNotificationData)) {
            return false;
        }
        PushNotificationData pushNotificationData = (PushNotificationData) obj;
        return Intrinsics.areEqual((Object) this.channelID, (Object) pushNotificationData.channelID) && Intrinsics.areEqual((Object) this.senderName, (Object) pushNotificationData.senderName) && Intrinsics.areEqual((Object) this.orderID, (Object) pushNotificationData.orderID) && Intrinsics.areEqual((Object) this.country, (Object) pushNotificationData.country) && Intrinsics.areEqual((Object) this.messageID, (Object) pushNotificationData.messageID) && Intrinsics.areEqual((Object) this.pushID, (Object) pushNotificationData.pushID) && Intrinsics.areEqual((Object) this.message, (Object) pushNotificationData.message) && Intrinsics.areEqual((Object) this.pushAlert, (Object) pushNotificationData.pushAlert) && Intrinsics.areEqual((Object) this.title, (Object) pushNotificationData.title) && Intrinsics.areEqual((Object) this.channelType, (Object) pushNotificationData.channelType);
    }

    @NotNull
    public final String getChannelID() {
        return this.channelID;
    }

    @NotNull
    public final String getChannelType() {
        return this.channelType;
    }

    @NotNull
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final String getMessageID() {
        return this.messageID;
    }

    @NotNull
    public final String getOrderID() {
        return this.orderID;
    }

    @Nullable
    public final String getPushAlert() {
        return this.pushAlert;
    }

    @NotNull
    public final String getPushID() {
        return this.pushID;
    }

    @NotNull
    public final String getSenderName() {
        return this.senderName;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.channelID.hashCode() * 31) + this.senderName.hashCode()) * 31) + this.orderID.hashCode()) * 31) + this.country.hashCode()) * 31) + this.messageID.hashCode()) * 31) + this.pushID.hashCode()) * 31) + this.message.hashCode()) * 31;
        String str = this.pushAlert;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return ((hashCode2 + i11) * 31) + this.channelType.hashCode();
    }

    @NotNull
    public String toString() {
        return "PushNotificationData(channelID=" + this.channelID + ", senderName=" + this.senderName + ", orderID=" + this.orderID + ", country=" + this.country + ", messageID=" + this.messageID + ", pushID=" + this.pushID + ", message=" + this.message + ", pushAlert=" + this.pushAlert + ", title=" + this.title + ", channelType=" + this.channelType + ')';
    }
}
