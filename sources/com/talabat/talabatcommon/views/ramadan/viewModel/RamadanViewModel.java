package com.talabat.talabatcommon.views.ramadan.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcommon.views.ramadan.RemainingTime;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import java.util.Date;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u0018H&J\u0018\u0010\u0015\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH&R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u00048F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00048F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000e¨\u0006 "}, d2 = {"Lcom/talabat/talabatcommon/views/ramadan/viewModel/RamadanViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "_prayerTimeText", "Landroidx/lifecycle/MutableLiveData;", "", "_remainingTimeTextBeforeFasting", "Lcom/talabat/talabatcommon/views/ramadan/RemainingTime;", "_remainingTimeTextBeforeIftar", "_showClockView", "", "_showRamadanView", "prayerTimeText", "getPrayerTimeText", "()Landroidx/lifecycle/MutableLiveData;", "remainingTimeTextBeforeFasting", "getRemainingTimeTextBeforeFasting", "remainingTimeTextBeforeIftar", "getRemainingTimeTextBeforeIftar", "showClockView", "getShowClockView", "showRamadanView", "getShowRamadanView", "refreshTime", "", "currentTime", "Ljava/util/Date;", "showClock", "countryId", "shownLocation", "Lcom/talabat/talabatcommon/views/ramadan/viewModel/RamadanViewModel$ShownLocation;", "ShownLocation", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class RamadanViewModel extends BaseViewModel {
    @NotNull
    private final MutableLiveData<String> _prayerTimeText = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<RemainingTime> _remainingTimeTextBeforeFasting = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<RemainingTime> _remainingTimeTextBeforeIftar = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Boolean> _showClockView = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Boolean> _showRamadanView = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatcommon/views/ramadan/viewModel/RamadanViewModel$ShownLocation;", "", "(Ljava/lang/String;I)V", "Home", "Other", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum ShownLocation {
        Home,
        Other
    }

    @NotNull
    public final MutableLiveData<String> getPrayerTimeText() {
        return this._prayerTimeText;
    }

    @NotNull
    public final MutableLiveData<RemainingTime> getRemainingTimeTextBeforeFasting() {
        return this._remainingTimeTextBeforeFasting;
    }

    @NotNull
    public final MutableLiveData<RemainingTime> getRemainingTimeTextBeforeIftar() {
        return this._remainingTimeTextBeforeIftar;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowClockView() {
        return this._showClockView;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowRamadanView() {
        return this._showRamadanView;
    }

    public abstract void refreshTime(@NotNull Date date);

    public abstract void showClock();

    public abstract void showRamadanView(@NotNull String str, @NotNull ShownLocation shownLocation);
}
