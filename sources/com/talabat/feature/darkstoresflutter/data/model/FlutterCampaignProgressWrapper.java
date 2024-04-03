package com.talabat.feature.darkstoresflutter.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaignProgressWrapper;", "", "permanent", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaignProgress;", "transient", "(Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaignProgress;Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaignProgress;)V", "getPermanent", "()Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaignProgress;", "getTransient", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterCampaignProgressWrapper {
    @Nullable
    private final FlutterCampaignProgress permanent;
    @Nullable

    /* renamed from: transient  reason: not valid java name */
    private final FlutterCampaignProgress f465transient;

    public FlutterCampaignProgressWrapper() {
        this((FlutterCampaignProgress) null, (FlutterCampaignProgress) null, 3, (DefaultConstructorMarker) null);
    }

    public FlutterCampaignProgressWrapper(@Nullable @Json(name = "permanent") FlutterCampaignProgress flutterCampaignProgress, @Nullable @Json(name = "transient") FlutterCampaignProgress flutterCampaignProgress2) {
        this.permanent = flutterCampaignProgress;
        this.f465transient = flutterCampaignProgress2;
    }

    public static /* synthetic */ FlutterCampaignProgressWrapper copy$default(FlutterCampaignProgressWrapper flutterCampaignProgressWrapper, FlutterCampaignProgress flutterCampaignProgress, FlutterCampaignProgress flutterCampaignProgress2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            flutterCampaignProgress = flutterCampaignProgressWrapper.permanent;
        }
        if ((i11 & 2) != 0) {
            flutterCampaignProgress2 = flutterCampaignProgressWrapper.f465transient;
        }
        return flutterCampaignProgressWrapper.copy(flutterCampaignProgress, flutterCampaignProgress2);
    }

    @Nullable
    public final FlutterCampaignProgress component1() {
        return this.permanent;
    }

    @Nullable
    public final FlutterCampaignProgress component2() {
        return this.f465transient;
    }

    @NotNull
    public final FlutterCampaignProgressWrapper copy(@Nullable @Json(name = "permanent") FlutterCampaignProgress flutterCampaignProgress, @Nullable @Json(name = "transient") FlutterCampaignProgress flutterCampaignProgress2) {
        return new FlutterCampaignProgressWrapper(flutterCampaignProgress, flutterCampaignProgress2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlutterCampaignProgressWrapper)) {
            return false;
        }
        FlutterCampaignProgressWrapper flutterCampaignProgressWrapper = (FlutterCampaignProgressWrapper) obj;
        return Intrinsics.areEqual((Object) this.permanent, (Object) flutterCampaignProgressWrapper.permanent) && Intrinsics.areEqual((Object) this.f465transient, (Object) flutterCampaignProgressWrapper.f465transient);
    }

    @Nullable
    public final FlutterCampaignProgress getPermanent() {
        return this.permanent;
    }

    @Nullable
    public final FlutterCampaignProgress getTransient() {
        return this.f465transient;
    }

    public int hashCode() {
        FlutterCampaignProgress flutterCampaignProgress = this.permanent;
        int i11 = 0;
        int hashCode = (flutterCampaignProgress == null ? 0 : flutterCampaignProgress.hashCode()) * 31;
        FlutterCampaignProgress flutterCampaignProgress2 = this.f465transient;
        if (flutterCampaignProgress2 != null) {
            i11 = flutterCampaignProgress2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        FlutterCampaignProgress flutterCampaignProgress = this.permanent;
        FlutterCampaignProgress flutterCampaignProgress2 = this.f465transient;
        return "FlutterCampaignProgressWrapper(permanent=" + flutterCampaignProgress + ", transient=" + flutterCampaignProgress2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlutterCampaignProgressWrapper(FlutterCampaignProgress flutterCampaignProgress, FlutterCampaignProgress flutterCampaignProgress2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : flutterCampaignProgress, (i11 & 2) != 0 ? null : flutterCampaignProgress2);
    }
}
