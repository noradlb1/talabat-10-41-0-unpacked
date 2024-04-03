package com.deliveryhero.perseus.data.remote.api.model;

import android.annotation.SuppressLint;
import androidx.annotation.Keep;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001f\b\u0001\u0018\u00002\u00020\u0001B\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\n\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0015¨\u0006'"}, d2 = {"Lcom/deliveryhero/perseus/data/remote/api/model/BackLogInfoRequest;", "", "timestamp", "", "brand", "backlogSize", "", "oldestMessageAge", "", "numberOfDeletedMessages", "batchDelay", "batchSize", "appVersionName", "platform", "country", "globalEntityId", "sdkVersion", "sessionId", "clientId", "(Ljava/lang/String;Ljava/lang/String;IJLjava/lang/Integer;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppVersionName", "()Ljava/lang/String;", "getBacklogSize", "()I", "getBatchDelay", "()J", "getBatchSize", "getBrand", "getClientId", "getCountry", "getGlobalEntityId", "getNumberOfDeletedMessages", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOldestMessageAge", "getPlatform", "getSdkVersion", "getSessionId", "getTimestamp", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"LongParameterList"})
@Keep
public final class BackLogInfoRequest {
    @SerializedName("appVersionCode")
    @NotNull
    private final String appVersionName;
    @SerializedName("amountOfMessagesInQueue")
    private final int backlogSize;
    @SerializedName("batchSizeDelay")
    private final long batchDelay;
    @SerializedName("batchSize")
    private final int batchSize;
    @SerializedName("brand")
    @NotNull
    private final String brand;
    @SerializedName("clientId")
    @Nullable
    private final String clientId;
    @SerializedName("country")
    @Nullable
    private final String country;
    @SerializedName("globalEntityId")
    @Nullable
    private final String globalEntityId;
    @SerializedName("numberOfDeletedMessages")
    @Nullable
    private final Integer numberOfDeletedMessages;
    @SerializedName("ageOfOldestMessageInQueue")
    private final long oldestMessageAge;
    @SerializedName("platform")
    @NotNull
    private final String platform;
    @SerializedName("sdkVersion")
    @NotNull
    private final String sdkVersion;
    @SerializedName("sessionId")
    @Nullable
    private final String sessionId;
    @SerializedName("timestamp")
    @NotNull
    private final String timestamp;

    public BackLogInfoRequest(@NotNull String str, @NotNull String str2, int i11, long j11, @Nullable Integer num, long j12, int i12, @NotNull String str3, @NotNull String str4, @Nullable String str5, @Nullable String str6, @NotNull String str7, @Nullable String str8, @Nullable String str9) {
        String str10 = str3;
        String str11 = str4;
        String str12 = str7;
        Intrinsics.checkNotNullParameter(str, "timestamp");
        Intrinsics.checkNotNullParameter(str2, ScreenNames.SCREEN_TYPE_BRAND);
        Intrinsics.checkNotNullParameter(str10, "appVersionName");
        Intrinsics.checkNotNullParameter(str11, "platform");
        Intrinsics.checkNotNullParameter(str12, RemoteConfigConstants.RequestFieldKey.SDK_VERSION);
        this.timestamp = str;
        this.brand = str2;
        this.backlogSize = i11;
        this.oldestMessageAge = j11;
        this.numberOfDeletedMessages = num;
        this.batchDelay = j12;
        this.batchSize = i12;
        this.appVersionName = str10;
        this.platform = str11;
        this.country = str5;
        this.globalEntityId = str6;
        this.sdkVersion = str12;
        this.sessionId = str8;
        this.clientId = str9;
    }

    @NotNull
    public final String getAppVersionName() {
        return this.appVersionName;
    }

    public final int getBacklogSize() {
        return this.backlogSize;
    }

    public final long getBatchDelay() {
        return this.batchDelay;
    }

    public final int getBatchSize() {
        return this.batchSize;
    }

    @NotNull
    public final String getBrand() {
        return this.brand;
    }

    @Nullable
    public final String getClientId() {
        return this.clientId;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final String getGlobalEntityId() {
        return this.globalEntityId;
    }

    @Nullable
    public final Integer getNumberOfDeletedMessages() {
        return this.numberOfDeletedMessages;
    }

    public final long getOldestMessageAge() {
        return this.oldestMessageAge;
    }

    @NotNull
    public final String getPlatform() {
        return this.platform;
    }

    @NotNull
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    @Nullable
    public final String getSessionId() {
        return this.sessionId;
    }

    @NotNull
    public final String getTimestamp() {
        return this.timestamp;
    }
}
