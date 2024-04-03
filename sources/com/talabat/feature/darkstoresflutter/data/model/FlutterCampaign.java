package com.talabat.feature.darkstoresflutter.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaign;", "", "campaignId", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getCampaignId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterCampaign {
    @NotNull
    private final String campaignId;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58498name;

    public FlutterCampaign(@NotNull @Json(name = "campaignId") String str, @NotNull @Json(name = "name") String str2) {
        Intrinsics.checkNotNullParameter(str, "campaignId");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.campaignId = str;
        this.f58498name = str2;
    }

    public static /* synthetic */ FlutterCampaign copy$default(FlutterCampaign flutterCampaign, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = flutterCampaign.campaignId;
        }
        if ((i11 & 2) != 0) {
            str2 = flutterCampaign.f58498name;
        }
        return flutterCampaign.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.campaignId;
    }

    @NotNull
    public final String component2() {
        return this.f58498name;
    }

    @NotNull
    public final FlutterCampaign copy(@NotNull @Json(name = "campaignId") String str, @NotNull @Json(name = "name") String str2) {
        Intrinsics.checkNotNullParameter(str, "campaignId");
        Intrinsics.checkNotNullParameter(str2, "name");
        return new FlutterCampaign(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlutterCampaign)) {
            return false;
        }
        FlutterCampaign flutterCampaign = (FlutterCampaign) obj;
        return Intrinsics.areEqual((Object) this.campaignId, (Object) flutterCampaign.campaignId) && Intrinsics.areEqual((Object) this.f58498name, (Object) flutterCampaign.f58498name);
    }

    @NotNull
    public final String getCampaignId() {
        return this.campaignId;
    }

    @NotNull
    public final String getName() {
        return this.f58498name;
    }

    public int hashCode() {
        return (this.campaignId.hashCode() * 31) + this.f58498name.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.campaignId;
        String str2 = this.f58498name;
        return "FlutterCampaign(campaignId=" + str + ", name=" + str2 + ")";
    }
}
