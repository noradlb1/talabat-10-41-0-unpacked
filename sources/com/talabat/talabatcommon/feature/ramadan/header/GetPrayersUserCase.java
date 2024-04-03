package com.talabat.talabatcommon.feature.ramadan.header;

import buisnessmodels.Customer;
import com.batoulapps.adhan.CalculationParameters;
import com.batoulapps.adhan.Coordinates;
import com.batoulapps.adhan.PrayerTimes;
import com.batoulapps.adhan.data.DateComponents;
import com.google.android.gms.maps.model.LatLng;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0011\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0014H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/talabat/talabatcommon/feature/ramadan/header/GetPrayersUserCase;", "", "userLocationUseCase", "Lcom/talabat/talabatcommon/feature/ramadan/header/UserLocationUseCase;", "userCountryRamadanPrayerParameters", "Lcom/talabat/talabatcommon/feature/ramadan/header/UserCountryRamadanPrayerParameters;", "(Lcom/talabat/talabatcommon/feature/ramadan/header/UserLocationUseCase;Lcom/talabat/talabatcommon/feature/ramadan/header/UserCountryRamadanPrayerParameters;)V", "getUserCountryRamadanPrayerParameters", "()Lcom/talabat/talabatcommon/feature/ramadan/header/UserCountryRamadanPrayerParameters;", "setUserCountryRamadanPrayerParameters", "(Lcom/talabat/talabatcommon/feature/ramadan/header/UserCountryRamadanPrayerParameters;)V", "getUserLocationUseCase", "()Lcom/talabat/talabatcommon/feature/ramadan/header/UserLocationUseCase;", "setUserLocationUseCase", "(Lcom/talabat/talabatcommon/feature/ramadan/header/UserLocationUseCase;)V", "getCoordinates", "Lcom/batoulapps/adhan/Coordinates;", "getCountryParams", "Lcom/batoulapps/adhan/CalculationParameters;", "getFajrDate", "Ljava/util/Date;", "prayerTimes", "Lcom/batoulapps/adhan/PrayerTimes;", "getMaghrabDate", "invoke", "currentDate", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetPrayersUserCase {
    @NotNull
    private UserCountryRamadanPrayerParameters userCountryRamadanPrayerParameters;
    @NotNull
    private UserLocationUseCase userLocationUseCase;

    public GetPrayersUserCase() {
        this((UserLocationUseCase) null, (UserCountryRamadanPrayerParameters) null, 3, (DefaultConstructorMarker) null);
    }

    public GetPrayersUserCase(@NotNull UserLocationUseCase userLocationUseCase2, @NotNull UserCountryRamadanPrayerParameters userCountryRamadanPrayerParameters2) {
        Intrinsics.checkNotNullParameter(userLocationUseCase2, "userLocationUseCase");
        Intrinsics.checkNotNullParameter(userCountryRamadanPrayerParameters2, "userCountryRamadanPrayerParameters");
        this.userLocationUseCase = userLocationUseCase2;
        this.userCountryRamadanPrayerParameters = userCountryRamadanPrayerParameters2;
    }

    private final Coordinates getCoordinates() {
        UserLocation invoke = this.userLocationUseCase.invoke();
        return new Coordinates(invoke.getLat(), invoke.getLng());
    }

    private final CalculationParameters getCountryParams() {
        return this.userCountryRamadanPrayerParameters.invoke();
    }

    @Nullable
    public final Date getFajrDate(@NotNull PrayerTimes prayerTimes) {
        Intrinsics.checkNotNullParameter(prayerTimes, "prayerTimes");
        return prayerTimes.fajr;
    }

    @Nullable
    public final Date getMaghrabDate(@NotNull PrayerTimes prayerTimes) {
        Intrinsics.checkNotNullParameter(prayerTimes, "prayerTimes");
        return prayerTimes.maghrib;
    }

    @NotNull
    public final UserCountryRamadanPrayerParameters getUserCountryRamadanPrayerParameters() {
        return this.userCountryRamadanPrayerParameters;
    }

    @NotNull
    public final UserLocationUseCase getUserLocationUseCase() {
        return this.userLocationUseCase;
    }

    @NotNull
    public final PrayerTimes invoke(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "currentDate");
        return new PrayerTimes(getCoordinates(), DateComponents.from(date), getCountryParams());
    }

    public final void setUserCountryRamadanPrayerParameters(@NotNull UserCountryRamadanPrayerParameters userCountryRamadanPrayerParameters2) {
        Intrinsics.checkNotNullParameter(userCountryRamadanPrayerParameters2, "<set-?>");
        this.userCountryRamadanPrayerParameters = userCountryRamadanPrayerParameters2;
    }

    public final void setUserLocationUseCase(@NotNull UserLocationUseCase userLocationUseCase2) {
        Intrinsics.checkNotNullParameter(userLocationUseCase2, "<set-?>");
        this.userLocationUseCase = userLocationUseCase2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetPrayersUserCase(UserLocationUseCase userLocationUseCase2, UserCountryRamadanPrayerParameters userCountryRamadanPrayerParameters2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new UserLocationUseCase((Customer) null, (LatLng) null, 3, (DefaultConstructorMarker) null) : userLocationUseCase2, (i11 & 2) != 0 ? new UserCountryRamadanPrayerParameters(0, 1, (DefaultConstructorMarker) null) : userCountryRamadanPrayerParameters2);
    }
}
