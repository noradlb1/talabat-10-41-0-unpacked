package com.adtechsdk.dh_adtech_sdk_flutter.viewability.entities;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/entities/TrackerData;", "", "tag", "", "tagType", "tagParams", "tagVendor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "getTagParams", "getTagType", "getTagVendor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "dh_adtech_sdk_flutter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TrackerData {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final String tag;
    @Nullable
    private final String tagParams;
    @NotNull
    private final String tagType;
    @Nullable
    private final String tagVendor;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/entities/TrackerData$Companion;", "", "()V", "parseJsonArray", "", "Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/entities/TrackerData;", "array", "Lorg/json/JSONArray;", "dh_adtech_sdk_flutter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<TrackerData> parseJsonArray(@Nullable JSONArray jSONArray) {
            if (jSONArray == null) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i11 = 0; i11 < length; i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                String string = jSONObject.getString("tag");
                Intrinsics.checkNotNullExpressionValue(string, "item.getString(\"tag\")");
                String string2 = jSONObject.getString("tag_type");
                Intrinsics.checkNotNullExpressionValue(string2, "item.getString(\"tag_type\")");
                arrayList.add(new TrackerData(string, string2, jSONObject.optString("tag_params"), jSONObject.optString("tag_vendor")));
            }
            return arrayList;
        }
    }

    public TrackerData(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "tagType");
        this.tag = str;
        this.tagType = str2;
        this.tagParams = str3;
        this.tagVendor = str4;
    }

    public static /* synthetic */ TrackerData copy$default(TrackerData trackerData, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = trackerData.tag;
        }
        if ((i11 & 2) != 0) {
            str2 = trackerData.tagType;
        }
        if ((i11 & 4) != 0) {
            str3 = trackerData.tagParams;
        }
        if ((i11 & 8) != 0) {
            str4 = trackerData.tagVendor;
        }
        return trackerData.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.tag;
    }

    @NotNull
    public final String component2() {
        return this.tagType;
    }

    @Nullable
    public final String component3() {
        return this.tagParams;
    }

    @Nullable
    public final String component4() {
        return this.tagVendor;
    }

    @NotNull
    public final TrackerData copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "tagType");
        return new TrackerData(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrackerData)) {
            return false;
        }
        TrackerData trackerData = (TrackerData) obj;
        return Intrinsics.areEqual((Object) this.tag, (Object) trackerData.tag) && Intrinsics.areEqual((Object) this.tagType, (Object) trackerData.tagType) && Intrinsics.areEqual((Object) this.tagParams, (Object) trackerData.tagParams) && Intrinsics.areEqual((Object) this.tagVendor, (Object) trackerData.tagVendor);
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @Nullable
    public final String getTagParams() {
        return this.tagParams;
    }

    @NotNull
    public final String getTagType() {
        return this.tagType;
    }

    @Nullable
    public final String getTagVendor() {
        return this.tagVendor;
    }

    public int hashCode() {
        int hashCode = ((this.tag.hashCode() * 31) + this.tagType.hashCode()) * 31;
        String str = this.tagParams;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.tagVendor;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        return "TrackerData(tag=" + this.tag + ", tagType=" + this.tagType + ", tagParams=" + this.tagParams + ", tagVendor=" + this.tagVendor + ')';
    }
}
