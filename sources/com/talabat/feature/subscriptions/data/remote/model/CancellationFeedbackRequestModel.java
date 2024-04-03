package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import com.talabat.talabatlife.features.UrlConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/CancellationFeedbackRequestModel;", "", "reasonId", "", "membershipId", "otherReason", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMembershipId", "()Ljava/lang/String;", "getOtherReason", "getReasonId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancellationFeedbackRequestModel {
    @NotNull
    private final String membershipId;
    @NotNull
    private final String otherReason;
    @NotNull
    private final String reasonId;

    public CancellationFeedbackRequestModel() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public CancellationFeedbackRequestModel(@NotNull @Json(name = "reasonId") String str, @NotNull @Json(name = "membershipId") String str2, @NotNull @Json(name = "otherReason") String str3) {
        Intrinsics.checkNotNullParameter(str, "reasonId");
        Intrinsics.checkNotNullParameter(str2, UrlConstantsKt.PATH_MEMBERSHIP_ID);
        Intrinsics.checkNotNullParameter(str3, "otherReason");
        this.reasonId = str;
        this.membershipId = str2;
        this.otherReason = str3;
    }

    public static /* synthetic */ CancellationFeedbackRequestModel copy$default(CancellationFeedbackRequestModel cancellationFeedbackRequestModel, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cancellationFeedbackRequestModel.reasonId;
        }
        if ((i11 & 2) != 0) {
            str2 = cancellationFeedbackRequestModel.membershipId;
        }
        if ((i11 & 4) != 0) {
            str3 = cancellationFeedbackRequestModel.otherReason;
        }
        return cancellationFeedbackRequestModel.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.reasonId;
    }

    @NotNull
    public final String component2() {
        return this.membershipId;
    }

    @NotNull
    public final String component3() {
        return this.otherReason;
    }

    @NotNull
    public final CancellationFeedbackRequestModel copy(@NotNull @Json(name = "reasonId") String str, @NotNull @Json(name = "membershipId") String str2, @NotNull @Json(name = "otherReason") String str3) {
        Intrinsics.checkNotNullParameter(str, "reasonId");
        Intrinsics.checkNotNullParameter(str2, UrlConstantsKt.PATH_MEMBERSHIP_ID);
        Intrinsics.checkNotNullParameter(str3, "otherReason");
        return new CancellationFeedbackRequestModel(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CancellationFeedbackRequestModel)) {
            return false;
        }
        CancellationFeedbackRequestModel cancellationFeedbackRequestModel = (CancellationFeedbackRequestModel) obj;
        return Intrinsics.areEqual((Object) this.reasonId, (Object) cancellationFeedbackRequestModel.reasonId) && Intrinsics.areEqual((Object) this.membershipId, (Object) cancellationFeedbackRequestModel.membershipId) && Intrinsics.areEqual((Object) this.otherReason, (Object) cancellationFeedbackRequestModel.otherReason);
    }

    @NotNull
    public final String getMembershipId() {
        return this.membershipId;
    }

    @NotNull
    public final String getOtherReason() {
        return this.otherReason;
    }

    @NotNull
    public final String getReasonId() {
        return this.reasonId;
    }

    public int hashCode() {
        return (((this.reasonId.hashCode() * 31) + this.membershipId.hashCode()) * 31) + this.otherReason.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.reasonId;
        String str2 = this.membershipId;
        String str3 = this.otherReason;
        return "CancellationFeedbackRequestModel(reasonId=" + str + ", membershipId=" + str2 + ", otherReason=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CancellationFeedbackRequestModel(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3);
    }
}
