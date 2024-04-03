package com.talabat.talabatcommon.feature.ramadan.header;

import com.batoulapps.adhan.CalculationMethod;
import com.batoulapps.adhan.CalculationParameters;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcore.model.TalabatCountry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\tH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/feature/ramadan/header/UserCountryRamadanPrayerParameters;", "", "selectedCountryId", "", "(I)V", "getSelectedCountryId", "()I", "setSelectedCountryId", "invoke", "Lcom/batoulapps/adhan/CalculationParameters;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserCountryRamadanPrayerParameters {
    private int selectedCountryId;

    public UserCountryRamadanPrayerParameters() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public UserCountryRamadanPrayerParameters(int i11) {
        this.selectedCountryId = i11;
    }

    public final int getSelectedCountryId() {
        return this.selectedCountryId;
    }

    @NotNull
    public final CalculationParameters invoke() {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        int i11 = this.selectedCountryId;
        boolean z17 = false;
        if (i11 == TalabatCountry.UAE.getCountryId() || i11 == TalabatCountry.KUWAIT.getCountryId()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 && i11 != TalabatCountry.KSA.getCountryId()) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!z12 && i11 != TalabatCountry.BAHRAIN.getCountryId()) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (!z13 && i11 != TalabatCountry.OMAN.getCountryId()) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (!z14 && i11 != TalabatCountry.QATAR.getCountryId()) {
            z15 = false;
        } else {
            z15 = true;
        }
        if (!z15 && i11 != TalabatCountry.JORDAN.getCountryId()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            CalculationParameters parameters = CalculationMethod.UMM_AL_QURA.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "UMM_AL_QURA.parameters");
            return parameters;
        } else if (i11 == TalabatCountry.EGYPT.getCountryId()) {
            CalculationParameters parameters2 = CalculationMethod.EGYPTIAN.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters2, "EGYPTIAN.parameters");
            return parameters2;
        } else {
            if (i11 == TalabatCountry.LEBANON.getCountryId() || i11 == TalabatCountry.IRAQ.getCountryId()) {
                z17 = true;
            }
            if (z17) {
                CalculationParameters parameters3 = CalculationMethod.MUSLIM_WORLD_LEAGUE.getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters3, "MUSLIM_WORLD_LEAGUE.parameters");
                return parameters3;
            }
            CalculationParameters parameters4 = CalculationMethod.UMM_AL_QURA.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters4, "UMM_AL_QURA.parameters");
            return parameters4;
        }
    }

    public final void setSelectedCountryId(int i11) {
        this.selectedCountryId = i11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserCountryRamadanPrayerParameters(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? GlobalDataModel.SelectedCountryId : i11);
    }
}
