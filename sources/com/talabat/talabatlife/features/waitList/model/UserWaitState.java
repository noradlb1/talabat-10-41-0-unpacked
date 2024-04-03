package com.talabat.talabatlife.features.waitList.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/talabat/talabatlife/features/waitList/model/UserWaitState;", "", "()V", "actionText", "", "getActionText", "()Ljava/lang/String;", "setActionText", "(Ljava/lang/String;)V", "descriptionText", "getDescriptionText", "setDescriptionText", "isUserInWaitList", "", "()Ljava/lang/Boolean;", "setUserInWaitList", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "onBoardingSubTitle", "getOnBoardingSubTitle", "setOnBoardingSubTitle", "onBoardingTitle", "getOnBoardingTitle", "setOnBoardingTitle", "title", "getTitle", "setTitle", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserWaitState {
    @SerializedName("actionText")
    @Nullable
    private String actionText;
    @SerializedName(alternate = {"description"}, value = "descriptionText")
    @Nullable
    private String descriptionText;
    @SerializedName("isUserInWaitlist")
    @Nullable
    private Boolean isUserInWaitList;
    @SerializedName("onBoardingSubTitle")
    @Nullable
    private String onBoardingSubTitle;
    @SerializedName("onBoardingTitle")
    @Nullable
    private String onBoardingTitle;
    @SerializedName("title")
    @Nullable
    private String title;

    @Nullable
    public final String getActionText() {
        return this.actionText;
    }

    @Nullable
    public final String getDescriptionText() {
        return this.descriptionText;
    }

    @Nullable
    public final String getOnBoardingSubTitle() {
        return this.onBoardingSubTitle;
    }

    @Nullable
    public final String getOnBoardingTitle() {
        return this.onBoardingTitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Boolean isUserInWaitList() {
        return this.isUserInWaitList;
    }

    public final void setActionText(@Nullable String str) {
        this.actionText = str;
    }

    public final void setDescriptionText(@Nullable String str) {
        this.descriptionText = str;
    }

    public final void setOnBoardingSubTitle(@Nullable String str) {
        this.onBoardingSubTitle = str;
    }

    public final void setOnBoardingTitle(@Nullable String str) {
        this.onBoardingTitle = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setUserInWaitList(@Nullable Boolean bool) {
        this.isUserInWaitList = bool;
    }
}
