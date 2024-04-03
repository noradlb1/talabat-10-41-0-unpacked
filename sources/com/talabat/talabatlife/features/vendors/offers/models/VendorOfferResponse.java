package com.talabat.talabatlife.features.vendors.offers.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00178\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR \u0010 \u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000f¨\u0006$"}, d2 = {"Lcom/talabat/talabatlife/features/vendors/offers/models/VendorOfferResponse;", "", "()V", "id", "", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "info", "", "getInfo", "()Ljava/lang/String;", "setInfo", "(Ljava/lang/String;)V", "isEnabled", "", "()Ljava/lang/Boolean;", "setEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "limits", "", "Lcom/talabat/talabatlife/features/vendors/offers/models/VendorOfferResponse$OfferLimitResponse;", "getLimits", "()Ljava/util/List;", "setLimits", "(Ljava/util/List;)V", "subtitle", "getSubtitle", "setSubtitle", "title", "getTitle", "setTitle", "OfferLimitResponse", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorOfferResponse {
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private Integer f12055id;
    @SerializedName("info")
    @Nullable
    private String info;
    @SerializedName("isEnabled")
    @Nullable
    private Boolean isEnabled;
    @SerializedName("limits")
    @Nullable
    private List<OfferLimitResponse> limits;
    @SerializedName("subtitle")
    @Nullable
    private String subtitle;
    @SerializedName("title")
    @Nullable
    private String title;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatlife/features/vendors/offers/models/VendorOfferResponse$OfferLimitResponse;", "", "()V", "isReached", "", "()Ljava/lang/Boolean;", "setReached", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OfferLimitResponse {
        @SerializedName("isReached")
        @Nullable
        private Boolean isReached;
        @SerializedName("type")
        @Nullable
        private String type;

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final Boolean isReached() {
            return this.isReached;
        }

        public final void setReached(@Nullable Boolean bool) {
            this.isReached = bool;
        }

        public final void setType(@Nullable String str) {
            this.type = str;
        }
    }

    @Nullable
    public final Integer getId() {
        return this.f12055id;
    }

    @Nullable
    public final String getInfo() {
        return this.info;
    }

    @Nullable
    public final List<OfferLimitResponse> getLimits() {
        return this.limits;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Boolean isEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.isEnabled = bool;
    }

    public final void setId(@Nullable Integer num) {
        this.f12055id = num;
    }

    public final void setInfo(@Nullable String str) {
        this.info = str;
    }

    public final void setLimits(@Nullable List<OfferLimitResponse> list) {
        this.limits = list;
    }

    public final void setSubtitle(@Nullable String str) {
        this.subtitle = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }
}
