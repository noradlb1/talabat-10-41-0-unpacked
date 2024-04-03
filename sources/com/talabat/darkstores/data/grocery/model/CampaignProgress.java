package com.talabat.darkstores.data.grocery.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001(BK\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0010JV\u0010!\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000b\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/talabat/darkstores/data/grocery/model/CampaignProgress;", "", "iconImage", "", "message", "progressValue", "", "showForSeconds", "", "state", "Lcom/talabat/darkstores/data/grocery/model/CampaignProgress$State;", "isTPro", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Long;Lcom/talabat/darkstores/data/grocery/model/CampaignProgress$State;Ljava/lang/Boolean;)V", "getIconImage", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMessage", "getProgressValue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getShowForSeconds", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getState", "()Lcom/talabat/darkstores/data/grocery/model/CampaignProgress$State;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Long;Lcom/talabat/darkstores/data/grocery/model/CampaignProgress$State;Ljava/lang/Boolean;)Lcom/talabat/darkstores/data/grocery/model/CampaignProgress;", "equals", "other", "hashCode", "", "toString", "State", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignProgress {
    @Nullable
    private final String iconImage;
    @Nullable
    private final Boolean isTPro;
    @Nullable
    private final String message;
    @Nullable
    private final Float progressValue;
    @Nullable
    private final Long showForSeconds;
    @Nullable
    private final State state;

    @JsonClass(generateAdapter = false)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/data/grocery/model/CampaignProgress$State;", "", "(Ljava/lang/String;I)V", "HIDDEN", "IN_PROGRESS", "SUCCESS", "BELOW_THRESHOLD", "TRANSIENT", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum State {
        HIDDEN,
        IN_PROGRESS,
        SUCCESS,
        BELOW_THRESHOLD,
        TRANSIENT
    }

    public CampaignProgress(@Nullable @Json(name = "icon_image") String str, @Nullable String str2, @Nullable @Json(name = "progress_value") Float f11, @Nullable @Json(name = "show_for_seconds") Long l11, @Nullable @Json(name = "view_state") State state2, @Nullable @Json(name = "is_tpro_campaign") Boolean bool) {
        this.iconImage = str;
        this.message = str2;
        this.progressValue = f11;
        this.showForSeconds = l11;
        this.state = state2;
        this.isTPro = bool;
    }

    public static /* synthetic */ CampaignProgress copy$default(CampaignProgress campaignProgress, String str, String str2, Float f11, Long l11, State state2, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = campaignProgress.iconImage;
        }
        if ((i11 & 2) != 0) {
            str2 = campaignProgress.message;
        }
        String str3 = str2;
        if ((i11 & 4) != 0) {
            f11 = campaignProgress.progressValue;
        }
        Float f12 = f11;
        if ((i11 & 8) != 0) {
            l11 = campaignProgress.showForSeconds;
        }
        Long l12 = l11;
        if ((i11 & 16) != 0) {
            state2 = campaignProgress.state;
        }
        State state3 = state2;
        if ((i11 & 32) != 0) {
            bool = campaignProgress.isTPro;
        }
        return campaignProgress.copy(str, str3, f12, l12, state3, bool);
    }

    @Nullable
    public final String component1() {
        return this.iconImage;
    }

    @Nullable
    public final String component2() {
        return this.message;
    }

    @Nullable
    public final Float component3() {
        return this.progressValue;
    }

    @Nullable
    public final Long component4() {
        return this.showForSeconds;
    }

    @Nullable
    public final State component5() {
        return this.state;
    }

    @Nullable
    public final Boolean component6() {
        return this.isTPro;
    }

    @NotNull
    public final CampaignProgress copy(@Nullable @Json(name = "icon_image") String str, @Nullable String str2, @Nullable @Json(name = "progress_value") Float f11, @Nullable @Json(name = "show_for_seconds") Long l11, @Nullable @Json(name = "view_state") State state2, @Nullable @Json(name = "is_tpro_campaign") Boolean bool) {
        return new CampaignProgress(str, str2, f11, l11, state2, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CampaignProgress)) {
            return false;
        }
        CampaignProgress campaignProgress = (CampaignProgress) obj;
        return Intrinsics.areEqual((Object) this.iconImage, (Object) campaignProgress.iconImage) && Intrinsics.areEqual((Object) this.message, (Object) campaignProgress.message) && Intrinsics.areEqual((Object) this.progressValue, (Object) campaignProgress.progressValue) && Intrinsics.areEqual((Object) this.showForSeconds, (Object) campaignProgress.showForSeconds) && this.state == campaignProgress.state && Intrinsics.areEqual((Object) this.isTPro, (Object) campaignProgress.isTPro);
    }

    @Nullable
    public final String getIconImage() {
        return this.iconImage;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Float getProgressValue() {
        return this.progressValue;
    }

    @Nullable
    public final Long getShowForSeconds() {
        return this.showForSeconds;
    }

    @Nullable
    public final State getState() {
        return this.state;
    }

    public int hashCode() {
        String str = this.iconImage;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f11 = this.progressValue;
        int hashCode3 = (hashCode2 + (f11 == null ? 0 : f11.hashCode())) * 31;
        Long l11 = this.showForSeconds;
        int hashCode4 = (hashCode3 + (l11 == null ? 0 : l11.hashCode())) * 31;
        State state2 = this.state;
        int hashCode5 = (hashCode4 + (state2 == null ? 0 : state2.hashCode())) * 31;
        Boolean bool = this.isTPro;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode5 + i11;
    }

    @Nullable
    public final Boolean isTPro() {
        return this.isTPro;
    }

    @NotNull
    public String toString() {
        String str = this.iconImage;
        String str2 = this.message;
        Float f11 = this.progressValue;
        Long l11 = this.showForSeconds;
        State state2 = this.state;
        Boolean bool = this.isTPro;
        return "CampaignProgress(iconImage=" + str + ", message=" + str2 + ", progressValue=" + f11 + ", showForSeconds=" + l11 + ", state=" + state2 + ", isTPro=" + bool + ")";
    }
}
