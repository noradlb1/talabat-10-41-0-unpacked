package com.talabat.talabatcommon.feature.promotionWidget.model.response;

import com.google.gson.annotations.SerializedName;
import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/talabat/talabatcommon/feature/promotionWidget/model/response/WidgetInfo;", "", "()V", "btnTitle", "", "getBtnTitle", "()Ljava/lang/String;", "setBtnTitle", "(Ljava/lang/String;)V", "campaignId", "getCampaignId", "setCampaignId", "deeplink", "getDeeplink", "setDeeplink", "headline", "getHeadline", "setHeadline", "imgUrl", "getImgUrl", "setImgUrl", "logo", "getLogo", "setLogo", "tagLine", "getTagLine", "setTagLine", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WidgetInfo {
    @SerializedName("button_title")
    @NotNull
    private String btnTitle;
    @SerializedName("campaign_id")
    @NotNull
    private String campaignId;
    @SerializedName("deep_link")
    @NotNull
    private String deeplink;
    @SerializedName("headline")
    @NotNull
    private String headline;
    @SerializedName("image_url")
    @NotNull
    private String imgUrl;
    @SerializedName("logo")
    @NotNull
    private String logo;
    @SerializedName("tag_line")
    @NotNull
    private String tagLine;

    public WidgetInfo() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.btnTitle = StringUtils.empty(stringCompanionObject);
        this.logo = StringUtils.empty(stringCompanionObject);
        this.headline = StringUtils.empty(stringCompanionObject);
        this.tagLine = StringUtils.empty(stringCompanionObject);
        this.imgUrl = StringUtils.empty(stringCompanionObject);
        this.campaignId = StringUtils.empty(stringCompanionObject);
        this.deeplink = StringUtils.empty(stringCompanionObject);
    }

    @NotNull
    public final String getBtnTitle() {
        return this.btnTitle;
    }

    @NotNull
    public final String getCampaignId() {
        return this.campaignId;
    }

    @NotNull
    public final String getDeeplink() {
        return this.deeplink;
    }

    @NotNull
    public final String getHeadline() {
        return this.headline;
    }

    @NotNull
    public final String getImgUrl() {
        return this.imgUrl;
    }

    @NotNull
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    public final String getTagLine() {
        return this.tagLine;
    }

    public final void setBtnTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.btnTitle = str;
    }

    public final void setCampaignId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.campaignId = str;
    }

    public final void setDeeplink(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deeplink = str;
    }

    public final void setHeadline(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.headline = str;
    }

    public final void setImgUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imgUrl = str;
    }

    public final void setLogo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.logo = str;
    }

    public final void setTagLine(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tagLine = str;
    }
}
