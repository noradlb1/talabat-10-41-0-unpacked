package com.talabat.talabatcommon.feature.vouchers.loyalty.model.response;

import com.google.gson.annotations.SerializedName;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR \u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u0018\u0010%\u001a\u0004\u0018\u00010&8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/PossibleCustomerVoucher;", "", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "isApplied", "", "()Ljava/lang/Boolean;", "setApplied", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "model", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VoucherResponseModel;", "getModel", "()Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VoucherResponseModel;", "setModel", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VoucherResponseModel;)V", "restrictionDescription", "getRestrictionDescription", "setRestrictionDescription", "subTitle", "getSubTitle", "setSubTitle", "subscriptionRestriction", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/SubscriptionRestriction;", "getSubscriptionRestriction", "()Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/SubscriptionRestriction;", "title", "getTitle", "setTitle", "type", "getType", "setType", "voucherOptionType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;", "getVoucherOptionType", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PossibleCustomerVoucher {
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private String f61642id;
    @SerializedName("isApplied")
    @Nullable
    private Boolean isApplied;
    @SerializedName("model")
    @Nullable
    private VoucherResponseModel model;
    @SerializedName("tag")
    @Nullable
    private String restrictionDescription;
    @SerializedName("subTitle")
    @Nullable
    private String subTitle;
    @SerializedName("subscriptionRestriction")
    @Nullable
    private final SubscriptionRestriction subscriptionRestriction;
    @SerializedName("title")
    @Nullable
    private String title;
    @SerializedName("type")
    @Nullable
    private String type;
    @SerializedName("voucherType")
    @Nullable
    private final VoucherOptionType voucherOptionType;

    @Nullable
    public final String getId() {
        return this.f61642id;
    }

    @Nullable
    public final VoucherResponseModel getModel() {
        return this.model;
    }

    @Nullable
    public final String getRestrictionDescription() {
        return this.restrictionDescription;
    }

    @Nullable
    public final String getSubTitle() {
        return this.subTitle;
    }

    @Nullable
    public final SubscriptionRestriction getSubscriptionRestriction() {
        return this.subscriptionRestriction;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final VoucherOptionType getVoucherOptionType() {
        return this.voucherOptionType;
    }

    @Nullable
    public final Boolean isApplied() {
        return this.isApplied;
    }

    public final void setApplied(@Nullable Boolean bool) {
        this.isApplied = bool;
    }

    public final void setId(@Nullable String str) {
        this.f61642id = str;
    }

    public final void setModel(@Nullable VoucherResponseModel voucherResponseModel) {
        this.model = voucherResponseModel;
    }

    public final void setRestrictionDescription(@Nullable String str) {
        this.restrictionDescription = str;
    }

    public final void setSubTitle(@Nullable String str) {
        this.subTitle = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }
}
