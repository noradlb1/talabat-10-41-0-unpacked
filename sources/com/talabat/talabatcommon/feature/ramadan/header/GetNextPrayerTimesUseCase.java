package com.talabat.talabatcommon.feature.ramadan.header;

import com.batoulapps.adhan.Prayer;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/feature/ramadan/header/GetNextPrayerTimesUseCase;", "", "prayerTimes", "Lcom/talabat/talabatcommon/feature/ramadan/header/GetPrayersUserCase;", "(Lcom/talabat/talabatcommon/feature/ramadan/header/GetPrayersUserCase;)V", "getTomorrowDate", "Ljava/util/Date;", "date", "invoke", "Lcom/talabat/talabatcommon/feature/ramadan/header/NextPrayer;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetNextPrayerTimesUseCase {
    @NotNull
    private final GetPrayersUserCase prayerTimes;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Prayer.values().length];
            iArr[Prayer.ISHA.ordinal()] = 1;
            iArr[Prayer.NONE.ordinal()] = 2;
            iArr[Prayer.FAJR.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public GetNextPrayerTimesUseCase() {
        this((GetPrayersUserCase) null, 1, (DefaultConstructorMarker) null);
    }

    public GetNextPrayerTimesUseCase(@NotNull GetPrayersUserCase getPrayersUserCase) {
        Intrinsics.checkNotNullParameter(getPrayersUserCase, "prayerTimes");
        this.prayerTimes = getPrayersUserCase;
    }

    private final Date getTomorrowDate(Date date) {
        return new Date(date.getYear(), date.getMonth(), date.getDate() + 1, 0, 0);
    }

    @Nullable
    public final NextPrayer invoke(@NotNull Date date) {
        int i11;
        Intrinsics.checkNotNullParameter(date, "date");
        Prayer nextPrayer = this.prayerTimes.invoke(date).nextPrayer();
        if (nextPrayer == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[nextPrayer.ordinal()];
        }
        if (i11 == 1 || i11 == 2) {
            GetPrayersUserCase getPrayersUserCase = this.prayerTimes;
            Date fajrDate = getPrayersUserCase.getFajrDate(getPrayersUserCase.invoke(getTomorrowDate(date)));
            if (fajrDate != null) {
                return new NextPrayer(fajrDate, Prayer.FAJR);
            }
            return null;
        } else if (i11 != 3) {
            GetPrayersUserCase getPrayersUserCase2 = this.prayerTimes;
            Date maghrabDate = getPrayersUserCase2.getMaghrabDate(getPrayersUserCase2.invoke(date));
            if (maghrabDate != null) {
                return new NextPrayer(maghrabDate, Prayer.MAGHRIB);
            }
            return null;
        } else {
            GetPrayersUserCase getPrayersUserCase3 = this.prayerTimes;
            Date fajrDate2 = getPrayersUserCase3.getFajrDate(getPrayersUserCase3.invoke(date));
            if (fajrDate2 != null) {
                return new NextPrayer(fajrDate2, Prayer.FAJR);
            }
            return null;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetNextPrayerTimesUseCase(GetPrayersUserCase getPrayersUserCase, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new GetPrayersUserCase((UserLocationUseCase) null, (UserCountryRamadanPrayerParameters) null, 3, (DefaultConstructorMarker) null) : getPrayersUserCase);
    }
}
