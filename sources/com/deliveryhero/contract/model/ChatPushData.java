package com.deliveryhero.contract.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J[\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Lcom/deliveryhero/contract/model/ChatPushData;", "", "channelID", "", "senderName", "orderID", "country", "message", "pushID", "pushAlert", "channelType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannelID", "()Ljava/lang/String;", "getChannelType", "getCountry", "getMessage", "getOrderID", "getPushAlert", "getPushID", "getSenderName", "setSenderName", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatPushData {
    @NotNull
    private final String channelID;
    @NotNull
    private final String channelType;
    @NotNull
    private final String country;
    @NotNull
    private final String message;
    @NotNull
    private final String orderID;
    @Nullable
    private final String pushAlert;
    @NotNull
    private final String pushID;
    @NotNull
    private String senderName;

    public ChatPushData(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @Nullable String str7, @NotNull String str8) {
        Intrinsics.checkNotNullParameter(str, "channelID");
        Intrinsics.checkNotNullParameter(str2, "senderName");
        Intrinsics.checkNotNullParameter(str3, "orderID");
        Intrinsics.checkNotNullParameter(str4, "country");
        Intrinsics.checkNotNullParameter(str5, "message");
        Intrinsics.checkNotNullParameter(str6, "pushID");
        Intrinsics.checkNotNullParameter(str8, "channelType");
        this.channelID = str;
        this.senderName = str2;
        this.orderID = str3;
        this.country = str4;
        this.message = str5;
        this.pushID = str6;
        this.pushAlert = str7;
        this.channelType = str8;
    }

    public static /* synthetic */ ChatPushData copy$default(ChatPushData chatPushData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11, Object obj) {
        ChatPushData chatPushData2 = chatPushData;
        int i12 = i11;
        return chatPushData.copy((i12 & 1) != 0 ? chatPushData2.channelID : str, (i12 & 2) != 0 ? chatPushData2.senderName : str2, (i12 & 4) != 0 ? chatPushData2.orderID : str3, (i12 & 8) != 0 ? chatPushData2.country : str4, (i12 & 16) != 0 ? chatPushData2.message : str5, (i12 & 32) != 0 ? chatPushData2.pushID : str6, (i12 & 64) != 0 ? chatPushData2.pushAlert : str7, (i12 & 128) != 0 ? chatPushData2.channelType : str8);
    }

    @NotNull
    public final String component1() {
        return this.channelID;
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
        return this.message;
    }

    @NotNull
    public final String component6() {
        return this.pushID;
    }

    @Nullable
    public final String component7() {
        return this.pushAlert;
    }

    @NotNull
    public final String component8() {
        return this.channelType;
    }

    @NotNull
    public final ChatPushData copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @Nullable String str7, @NotNull String str8) {
        Intrinsics.checkNotNullParameter(str, "channelID");
        Intrinsics.checkNotNullParameter(str2, "senderName");
        Intrinsics.checkNotNullParameter(str3, "orderID");
        Intrinsics.checkNotNullParameter(str4, "country");
        Intrinsics.checkNotNullParameter(str5, "message");
        String str9 = str6;
        Intrinsics.checkNotNullParameter(str9, "pushID");
        String str10 = str8;
        Intrinsics.checkNotNullParameter(str10, "channelType");
        return new ChatPushData(str, str2, str3, str4, str5, str9, str7, str10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatPushData)) {
            return false;
        }
        ChatPushData chatPushData = (ChatPushData) obj;
        return Intrinsics.areEqual((Object) this.channelID, (Object) chatPushData.channelID) && Intrinsics.areEqual((Object) this.senderName, (Object) chatPushData.senderName) && Intrinsics.areEqual((Object) this.orderID, (Object) chatPushData.orderID) && Intrinsics.areEqual((Object) this.country, (Object) chatPushData.country) && Intrinsics.areEqual((Object) this.message, (Object) chatPushData.message) && Intrinsics.areEqual((Object) this.pushID, (Object) chatPushData.pushID) && Intrinsics.areEqual((Object) this.pushAlert, (Object) chatPushData.pushAlert) && Intrinsics.areEqual((Object) this.channelType, (Object) chatPushData.channelType);
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

    public int hashCode() {
        int hashCode = ((((((((((this.channelID.hashCode() * 31) + this.senderName.hashCode()) * 31) + this.orderID.hashCode()) * 31) + this.country.hashCode()) * 31) + this.message.hashCode()) * 31) + this.pushID.hashCode()) * 31;
        String str = this.pushAlert;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.channelType.hashCode();
    }

    public final void setSenderName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.senderName = str;
    }

    @NotNull
    public String toString() {
        return "ChatPushData(channelID=" + this.channelID + ", senderName=" + this.senderName + ", orderID=" + this.orderID + ", country=" + this.country + ", message=" + this.message + ", pushID=" + this.pushID + ", pushAlert=" + this.pushAlert + ", channelType=" + this.channelType + ')';
    }
}
