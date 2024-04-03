package com.talabat.talabatcommon.views.wallet.subscription.model;

import com.talabat.talabatcommon.extentions.StringUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001a\u0010'\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R\u001a\u0010-\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014R\u001a\u00100\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u0010\u0014R\u001a\u00103\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0012\"\u0004\b5\u0010\u0014R \u00106\u001a\b\u0012\u0004\u0012\u00020807X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0012\"\u0004\b?\u0010\u0014R\u001a\u0010@\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0012\"\u0004\bB\u0010\u0014¨\u0006C"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionPlanItemDisplayModel;", "", "()V", "activeSubscription", "", "getActiveSubscription", "()Z", "setActiveSubscription", "(Z)V", "amount", "", "getAmount", "()F", "setAmount", "(F)V", "category", "", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "country", "getCountry", "setCountry", "currency", "getCurrency", "setCurrency", "description", "getDescription", "setDescription", "durationDays", "", "getDurationDays", "()I", "setDurationDays", "(I)V", "freeTrialDays", "getFreeTrialDays", "setFreeTrialDays", "freeTrialEligible", "getFreeTrialEligible", "setFreeTrialEligible", "freeTrialTitle", "getFreeTrialTitle", "setFreeTrialTitle", "id", "getId", "setId", "imageUrl", "getImageUrl", "setImageUrl", "onBoardingLink", "getOnBoardingLink", "setOnBoardingLink", "products", "", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionProductDisplayModel;", "getProducts", "()Ljava/util/List;", "setProducts", "(Ljava/util/List;)V", "termsUrl", "getTermsUrl", "setTermsUrl", "title", "getTitle", "setTitle", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPlanItemDisplayModel {
    private boolean activeSubscription;
    private float amount;
    @NotNull
    private String category;
    @NotNull
    private String country;
    @NotNull
    private String currency;
    @NotNull
    private String description;
    private int durationDays;
    private int freeTrialDays;
    private boolean freeTrialEligible;
    @NotNull
    private String freeTrialTitle;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private String f11930id;
    @NotNull
    private String imageUrl;
    @NotNull
    private String onBoardingLink;
    @NotNull
    private List<SubscriptionProductDisplayModel> products = CollectionsKt__CollectionsKt.emptyList();
    @NotNull
    private String termsUrl;
    @NotNull
    private String title;

    public SubscriptionPlanItemDisplayModel() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.f11930id = StringUtils.empty(stringCompanionObject);
        this.title = StringUtils.empty(stringCompanionObject);
        this.description = StringUtils.empty(stringCompanionObject);
        this.currency = StringUtils.empty(stringCompanionObject);
        this.country = StringUtils.empty(stringCompanionObject);
        this.freeTrialTitle = StringUtils.empty(stringCompanionObject);
        this.category = StringUtils.empty(stringCompanionObject);
        this.imageUrl = StringUtils.empty(stringCompanionObject);
        this.termsUrl = StringUtils.empty(stringCompanionObject);
        this.onBoardingLink = StringUtils.empty(stringCompanionObject);
    }

    public final boolean getActiveSubscription() {
        return this.activeSubscription;
    }

    public final float getAmount() {
        return this.amount;
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    public final String getCurrency() {
        return this.currency;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final int getDurationDays() {
        return this.durationDays;
    }

    public final int getFreeTrialDays() {
        return this.freeTrialDays;
    }

    public final boolean getFreeTrialEligible() {
        return this.freeTrialEligible;
    }

    @NotNull
    public final String getFreeTrialTitle() {
        return this.freeTrialTitle;
    }

    @NotNull
    public final String getId() {
        return this.f11930id;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final String getOnBoardingLink() {
        return this.onBoardingLink;
    }

    @NotNull
    public final List<SubscriptionProductDisplayModel> getProducts() {
        return this.products;
    }

    @NotNull
    public final String getTermsUrl() {
        return this.termsUrl;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final void setActiveSubscription(boolean z11) {
        this.activeSubscription = z11;
    }

    public final void setAmount(float f11) {
        this.amount = f11;
    }

    public final void setCategory(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.category = str;
    }

    public final void setCountry(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.country = str;
    }

    public final void setCurrency(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currency = str;
    }

    public final void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final void setDurationDays(int i11) {
        this.durationDays = i11;
    }

    public final void setFreeTrialDays(int i11) {
        this.freeTrialDays = i11;
    }

    public final void setFreeTrialEligible(boolean z11) {
        this.freeTrialEligible = z11;
    }

    public final void setFreeTrialTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.freeTrialTitle = str;
    }

    public final void setId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f11930id = str;
    }

    public final void setImageUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageUrl = str;
    }

    public final void setOnBoardingLink(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.onBoardingLink = str;
    }

    public final void setProducts(@NotNull List<SubscriptionProductDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.products = list;
    }

    public final void setTermsUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.termsUrl = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
