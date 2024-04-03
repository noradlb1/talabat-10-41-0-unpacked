package com.talabat.talabatcommon.views.ramadan.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.batoulapps.adhan.Prayer;
import com.talabat.talabatcommon.feature.ramadan.header.GetNextPrayerTimesUseCase;
import com.talabat.talabatcommon.feature.ramadan.header.NextPrayer;
import com.talabat.talabatcommon.views.ramadan.RemainingTime;
import com.talabat.talabatcommon.views.ramadan.viewModel.RamadanViewModel;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/talabatcommon/views/ramadan/viewModel/RamadanViewModelImpl;", "Lcom/talabat/talabatcommon/views/ramadan/viewModel/RamadanViewModel;", "prayerTimesUseCase", "Lcom/talabat/talabatcommon/feature/ramadan/header/GetNextPrayerTimesUseCase;", "(Lcom/talabat/talabatcommon/feature/ramadan/header/GetNextPrayerTimesUseCase;)V", "shownLocation", "Lcom/talabat/talabatcommon/views/ramadan/viewModel/RamadanViewModel$ShownLocation;", "displayTime", "", "nextPrayer", "Lcom/talabat/talabatcommon/feature/ramadan/header/NextPrayer;", "currentTime", "Ljava/util/Date;", "getRemainingTime", "", "refreshTime", "showClock", "showRamadanView", "countryId", "", "isHome", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RamadanViewModelImpl extends RamadanViewModel {
    @NotNull
    private GetNextPrayerTimesUseCase prayerTimesUseCase;
    private RamadanViewModel.ShownLocation shownLocation;

    public RamadanViewModelImpl(@NotNull GetNextPrayerTimesUseCase getNextPrayerTimesUseCase) {
        Intrinsics.checkNotNullParameter(getNextPrayerTimesUseCase, "prayerTimesUseCase");
        this.prayerTimesUseCase = getNextPrayerTimesUseCase;
    }

    private final void displayTime(NextPrayer nextPrayer, Date date) {
        Long l11;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(TimeZone.getDefault().getID()));
        String format = simpleDateFormat.format(nextPrayer.getPrayerTime());
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(nextPrayer.prayerTime)");
        Date prayerTime = nextPrayer.getPrayerTime();
        if (prayerTime != null) {
            l11 = Long.valueOf(getRemainingTime(prayerTime, date));
        } else {
            l11 = null;
        }
        long longValue = l11.longValue();
        getPrayerTimeText().postValue(format);
        if (nextPrayer.getPrayerName() == Prayer.MAGHRIB) {
            MutableLiveData<RemainingTime> remainingTimeTextBeforeIftar = getRemainingTimeTextBeforeIftar();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            remainingTimeTextBeforeIftar.postValue(new RemainingTime(timeUnit.toHours(longValue), timeUnit.toMinutes(longValue) % ((long) 60)));
            return;
        }
        MutableLiveData<RemainingTime> remainingTimeTextBeforeFasting = getRemainingTimeTextBeforeFasting();
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        remainingTimeTextBeforeFasting.postValue(new RemainingTime(timeUnit2.toHours(longValue), timeUnit2.toMinutes(longValue) % ((long) 60)));
    }

    private final long getRemainingTime(Date date, Date date2) {
        long time = date.getTime() - date2.getTime();
        if (time == 0) {
            return 1;
        }
        return time;
    }

    private final boolean isHome(RamadanViewModel.ShownLocation shownLocation2) {
        return shownLocation2 == RamadanViewModel.ShownLocation.Home;
    }

    public void refreshTime(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "currentTime");
        NextPrayer invoke = this.prayerTimesUseCase.invoke(new Date());
        if (invoke != null) {
            displayTime(invoke, date);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showClock() {
        /*
            r2 = this;
            com.talabat.talabatcommon.views.ramadan.viewModel.RamadanViewModel$ShownLocation r0 = r2.shownLocation
            if (r0 == 0) goto L_0x0014
            if (r0 != 0) goto L_0x000c
            java.lang.String r0 = "shownLocation"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
        L_0x000c:
            boolean r0 = r2.isHome(r0)
            if (r0 == 0) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x001f
            java.util.Date r1 = new java.util.Date
            r1.<init>()
            r2.refreshTime(r1)
        L_0x001f:
            androidx.lifecycle.MutableLiveData r1 = r2.getShowClockView()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r1.setValue(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.ramadan.viewModel.RamadanViewModelImpl.showClock():void");
    }

    public void showRamadanView(@NotNull String str, @NotNull RamadanViewModel.ShownLocation shownLocation2) {
        Intrinsics.checkNotNullParameter(str, "countryId");
        Intrinsics.checkNotNullParameter(shownLocation2, "shownLocation");
        this.shownLocation = shownLocation2;
        getShowRamadanView().setValue(Boolean.valueOf(isHome(shownLocation2)));
    }
}
