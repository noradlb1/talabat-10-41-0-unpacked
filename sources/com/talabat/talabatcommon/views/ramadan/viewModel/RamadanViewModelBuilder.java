package com.talabat.talabatcommon.views.ramadan.viewModel;

import com.talabat.talabatcommon.feature.ramadan.header.GetNextPrayerTimesUseCase;
import com.talabat.talabatcommon.feature.ramadan.header.GetPrayersUserCase;
import com.talabat.talabatcommon.feature.ramadan.header.UserCountryRamadanPrayerParameters;
import com.talabat.talabatcommon.feature.ramadan.header.UserLocationUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatcommon/views/ramadan/viewModel/RamadanViewModelBuilder;", "", "()V", "getMyViewModel", "Lcom/talabat/talabatcommon/views/ramadan/viewModel/RamadanViewModelImpl;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RamadanViewModelBuilder {
    @NotNull
    public static final RamadanViewModelBuilder INSTANCE = new RamadanViewModelBuilder();

    private RamadanViewModelBuilder() {
    }

    @NotNull
    public final RamadanViewModelImpl getMyViewModel() {
        return new RamadanViewModelImpl(new GetNextPrayerTimesUseCase(new GetPrayersUserCase((UserLocationUseCase) null, (UserCountryRamadanPrayerParameters) null, 3, (DefaultConstructorMarker) null)));
    }
}
