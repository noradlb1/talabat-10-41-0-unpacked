package com.adtechsdk.dh_adtech_sdk_flutter.viewability.entities;

import com.adjust.sdk.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/entities/Creative;", "", "id", "", "mediaURL", "", "sdkVersion", "trackers", "", "Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/entities/TrackerData;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()I", "getMediaURL", "()Ljava/lang/String;", "getSdkVersion", "getTrackers", "()Ljava/util/List;", "Companion", "dh_adtech_sdk_flutter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Creative {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: id  reason: collision with root package name */
    private final int f40034id;
    @Nullable
    private final String mediaURL;
    @NotNull
    private final String sdkVersion;
    @NotNull
    private final List<TrackerData> trackers;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/entities/Creative$Companion;", "", "()V", "fromJson", "Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/entities/Creative;", "jsonString", "", "dh_adtech_sdk_flutter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Creative fromJson(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "jsonString");
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("id");
            String optString = jSONObject.optString("media_url");
            String optString2 = jSONObject.optString("sdk_version");
            Intrinsics.checkNotNullExpressionValue(optString2, "obj.optString(\"sdk_version\")");
            return new Creative(optInt, optString, optString2, TrackerData.Companion.parseJsonArray(jSONObject.optJSONArray("trackers_data")));
        }
    }

    public Creative(int i11, @Nullable String str, @NotNull String str2, @NotNull List<TrackerData> list) {
        Intrinsics.checkNotNullParameter(str2, RemoteConfigConstants.RequestFieldKey.SDK_VERSION);
        Intrinsics.checkNotNullParameter(list, Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH);
        this.f40034id = i11;
        this.mediaURL = str;
        this.sdkVersion = str2;
        this.trackers = list;
    }

    public final int getId() {
        return this.f40034id;
    }

    @Nullable
    public final String getMediaURL() {
        return this.mediaURL;
    }

    @NotNull
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    @NotNull
    public final List<TrackerData> getTrackers() {
        return this.trackers;
    }
}
