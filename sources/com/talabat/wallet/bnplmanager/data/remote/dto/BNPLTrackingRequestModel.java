package com.talabat.wallet.bnplmanager.data.remote.dto;

import com.talabat.wallet.bnplmanager.data.impl.BNPLManagerRepositoryImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001a\u0010\u0019\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u001a\u0010\u001c\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\u0010R\u001a\u0010(\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010+\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R\u001a\u0010.\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0010R\u001a\u00101\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u000e\"\u0004\b3\u0010\u0010R\u001a\u00104\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000e\"\u0004\b6\u0010\u0010¨\u00067"}, d2 = {"Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLTrackingRequestModel;", "", "countryId", "", "(I)V", "amount", "", "getAmount", "()F", "setAmount", "(F)V", "binNumber", "", "getBinNumber", "()Ljava/lang/String;", "setBinNumber", "(Ljava/lang/String;)V", "bnplVersion", "getBnplVersion", "setBnplVersion", "getCountryId", "()I", "experimentId", "getExperimentId", "setExperimentId", "experimentName", "getExperimentName", "setExperimentName", "expiryDate", "getExpiryDate", "setExpiryDate", "hasUserChangedCard", "", "getHasUserChangedCard", "()Z", "setHasUserChangedCard", "(Z)V", "last4Digits", "getLast4Digits", "setLast4Digits", "optinInterviews", "getOptinInterviews", "setOptinInterviews", "optinNotifications", "getOptinNotifications", "setOptinNotifications", "treatmentGroup", "getTreatmentGroup", "setTreatmentGroup", "variantId", "getVariantId", "setVariantId", "vertical", "getVertical", "setVertical", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLTrackingRequestModel {
    private float amount;
    @NotNull
    private String binNumber = "";
    @NotNull
    private String bnplVersion = BNPLManagerRepositoryImpl.VERSION_NUMBER;
    private final int countryId;
    @NotNull
    private String experimentId = "116111";
    @NotNull
    private String experimentName = "BNPL Interest Validation - FD2";
    @NotNull
    private String expiryDate = "";
    private boolean hasUserChangedCard;
    @NotNull
    private String last4Digits = "";
    private boolean optinInterviews;
    private boolean optinNotifications;
    @NotNull
    private String treatmentGroup = "";
    @NotNull
    private String variantId = "";
    @NotNull
    private String vertical = "";

    public BNPLTrackingRequestModel(int i11) {
        this.countryId = i11;
    }

    public final float getAmount() {
        return this.amount;
    }

    @NotNull
    public final String getBinNumber() {
        return this.binNumber;
    }

    @NotNull
    public final String getBnplVersion() {
        return this.bnplVersion;
    }

    public final int getCountryId() {
        return this.countryId;
    }

    @NotNull
    public final String getExperimentId() {
        return this.experimentId;
    }

    @NotNull
    public final String getExperimentName() {
        return this.experimentName;
    }

    @NotNull
    public final String getExpiryDate() {
        return this.expiryDate;
    }

    public final boolean getHasUserChangedCard() {
        return this.hasUserChangedCard;
    }

    @NotNull
    public final String getLast4Digits() {
        return this.last4Digits;
    }

    public final boolean getOptinInterviews() {
        return this.optinInterviews;
    }

    public final boolean getOptinNotifications() {
        return this.optinNotifications;
    }

    @NotNull
    public final String getTreatmentGroup() {
        return this.treatmentGroup;
    }

    @NotNull
    public final String getVariantId() {
        return this.variantId;
    }

    @NotNull
    public final String getVertical() {
        return this.vertical;
    }

    public final void setAmount(float f11) {
        this.amount = f11;
    }

    public final void setBinNumber(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.binNumber = str;
    }

    public final void setBnplVersion(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bnplVersion = str;
    }

    public final void setExperimentId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.experimentId = str;
    }

    public final void setExperimentName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.experimentName = str;
    }

    public final void setExpiryDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.expiryDate = str;
    }

    public final void setHasUserChangedCard(boolean z11) {
        this.hasUserChangedCard = z11;
    }

    public final void setLast4Digits(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.last4Digits = str;
    }

    public final void setOptinInterviews(boolean z11) {
        this.optinInterviews = z11;
    }

    public final void setOptinNotifications(boolean z11) {
        this.optinNotifications = z11;
    }

    public final void setTreatmentGroup(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.treatmentGroup = str;
    }

    public final void setVariantId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.variantId = str;
    }

    public final void setVertical(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.vertical = str;
    }
}
