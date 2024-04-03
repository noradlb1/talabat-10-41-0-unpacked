package com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity;

import com.talabat.mapper.ModelMapping;
import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/entity/BenefitBin;", "", "binNumber", "", "isBenefitBin", "", "savedCardErrorMessage", "newCardErrorMessage", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getBinNumber", "()Ljava/lang/String;", "()Z", "getNewCardErrorMessage", "getSavedCardErrorMessage", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BenefitBin {
    @NotNull
    @ModelMapping({"binNumber"})
    private final String binNumber;
    @ModelMapping({"isBenefitBin"})
    private final boolean isBenefitBin;
    @ModelMapping({"newCardErrorMessage"})
    @Nullable
    private final String newCardErrorMessage;
    @NotNull
    @ModelMapping({"savedCardErrorMessage"})
    private final String savedCardErrorMessage;

    public BenefitBin() {
        this((String) null, false, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public BenefitBin(@NotNull String str, boolean z11, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "binNumber");
        Intrinsics.checkNotNullParameter(str2, "savedCardErrorMessage");
        this.binNumber = str;
        this.isBenefitBin = z11;
        this.savedCardErrorMessage = str2;
        this.newCardErrorMessage = str3;
    }

    public static /* synthetic */ BenefitBin copy$default(BenefitBin benefitBin, String str, boolean z11, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = benefitBin.binNumber;
        }
        if ((i11 & 2) != 0) {
            z11 = benefitBin.isBenefitBin;
        }
        if ((i11 & 4) != 0) {
            str2 = benefitBin.savedCardErrorMessage;
        }
        if ((i11 & 8) != 0) {
            str3 = benefitBin.newCardErrorMessage;
        }
        return benefitBin.copy(str, z11, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.binNumber;
    }

    public final boolean component2() {
        return this.isBenefitBin;
    }

    @NotNull
    public final String component3() {
        return this.savedCardErrorMessage;
    }

    @Nullable
    public final String component4() {
        return this.newCardErrorMessage;
    }

    @NotNull
    public final BenefitBin copy(@NotNull String str, boolean z11, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "binNumber");
        Intrinsics.checkNotNullParameter(str2, "savedCardErrorMessage");
        return new BenefitBin(str, z11, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BenefitBin)) {
            return false;
        }
        BenefitBin benefitBin = (BenefitBin) obj;
        return Intrinsics.areEqual((Object) this.binNumber, (Object) benefitBin.binNumber) && this.isBenefitBin == benefitBin.isBenefitBin && Intrinsics.areEqual((Object) this.savedCardErrorMessage, (Object) benefitBin.savedCardErrorMessage) && Intrinsics.areEqual((Object) this.newCardErrorMessage, (Object) benefitBin.newCardErrorMessage);
    }

    @NotNull
    public final String getBinNumber() {
        return this.binNumber;
    }

    @Nullable
    public final String getNewCardErrorMessage() {
        return this.newCardErrorMessage;
    }

    @NotNull
    public final String getSavedCardErrorMessage() {
        return this.savedCardErrorMessage;
    }

    public int hashCode() {
        int hashCode = this.binNumber.hashCode() * 31;
        boolean z11 = this.isBenefitBin;
        if (z11) {
            z11 = true;
        }
        int hashCode2 = (((hashCode + (z11 ? 1 : 0)) * 31) + this.savedCardErrorMessage.hashCode()) * 31;
        String str = this.newCardErrorMessage;
        return hashCode2 + (str == null ? 0 : str.hashCode());
    }

    public final boolean isBenefitBin() {
        return this.isBenefitBin;
    }

    @NotNull
    public String toString() {
        String str = this.binNumber;
        boolean z11 = this.isBenefitBin;
        String str2 = this.savedCardErrorMessage;
        String str3 = this.newCardErrorMessage;
        return "BenefitBin(binNumber=" + str + ", isBenefitBin=" + z11 + ", savedCardErrorMessage=" + str2 + ", newCardErrorMessage=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BenefitBin(String str, boolean z11, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str, (i11 & 2) != 0 ? false : z11, (i11 & 4) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str2, (i11 & 8) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str3);
    }
}
