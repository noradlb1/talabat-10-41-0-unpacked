package com.talabat.feature.mission.control.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.mission.control.domain.model.LifeStyleMissionControl;
import com.talabat.feature.mission.control.domain.model.LifeStyleMissionControlData;
import com.talabat.feature.mission.control.domain.model.MissionControlRequest;
import com.talabat.feature.mission.control.domain.usecases.LifeStyleMissionControlsUseCase;
import com.talabat.feature.mission.control.presentation.tracking.MissionControlClickEvent;
import com.talabat.feature.mission.control.presentation.tracking.MissionControlShowEvent;
import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u000bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/feature/mission/control/presentation/viewmodel/LifeStyleMissionViewModel;", "Landroidx/lifecycle/ViewModel;", "useCase", "Lcom/talabat/feature/mission/control/domain/usecases/LifeStyleMissionControlsUseCase;", "tracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Lcom/talabat/feature/mission/control/domain/usecases/LifeStyleMissionControlsUseCase;Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "isDarkstores", "", "lifeStyleMission", "Landroidx/lifecycle/LiveData;", "Lcom/talabat/feature/mission/control/domain/model/LifeStyleMissionControl;", "getLifeStyleMission", "()Landroidx/lifecycle/LiveData;", "lifeStyleMissionLiveData", "Landroidx/lifecycle/MutableLiveData;", "vendorCode", "", "getLifeStyleMissionControls", "", "vendorId", "onMissionClicked", "name", "position", "", "trackMissionShown", "com_talabat_feature_mission-control_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifeStyleMissionViewModel extends ViewModel {
    private boolean isDarkstores;
    @NotNull
    private final LiveData<LifeStyleMissionControl> lifeStyleMission;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<LifeStyleMissionControl> lifeStyleMissionLiveData;
    @NotNull
    private final TalabatTracker tracker;
    /* access modifiers changed from: private */
    @NotNull
    public final LifeStyleMissionControlsUseCase useCase;
    @Nullable
    private String vendorCode;

    @Inject
    public LifeStyleMissionViewModel(@NotNull LifeStyleMissionControlsUseCase lifeStyleMissionControlsUseCase, @NotNull TalabatTracker talabatTracker) {
        Intrinsics.checkNotNullParameter(lifeStyleMissionControlsUseCase, "useCase");
        Intrinsics.checkNotNullParameter(talabatTracker, "tracker");
        this.useCase = lifeStyleMissionControlsUseCase;
        this.tracker = talabatTracker;
        MutableLiveData<LifeStyleMissionControl> mutableLiveData = new MutableLiveData<>();
        this.lifeStyleMissionLiveData = mutableLiveData;
        this.lifeStyleMission = mutableLiveData;
    }

    /* access modifiers changed from: private */
    public final void trackMissionShown(LifeStyleMissionControl lifeStyleMissionControl) {
        String str = this.vendorCode;
        if (str != null) {
            int i11 = 0;
            for (Object next : lifeStyleMissionControl.getMissions()) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                this.tracker.track(new MissionControlShowEvent(str, this.isDarkstores, "lifestyle", ((LifeStyleMissionControlData) next).getName(), i11));
                i11 = i12;
            }
        }
    }

    @NotNull
    public final LiveData<LifeStyleMissionControl> getLifeStyleMission() {
        return this.lifeStyleMission;
    }

    public final void getLifeStyleMissionControls(@NotNull String str, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.VENDOR_CODE);
        MissionControlRequest missionControlRequest = new MissionControlRequest("", "vlp", str, z11, str2);
        this.vendorCode = str2;
        this.isDarkstores = z11;
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new LifeStyleMissionViewModel$getLifeStyleMissionControls$1(this, missionControlRequest, (Continuation<? super LifeStyleMissionViewModel$getLifeStyleMissionControls$1>) null), 3, (Object) null);
    }

    public final void onMissionClicked(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "name");
        String str2 = this.vendorCode;
        if (str2 != null) {
            this.tracker.track(new MissionControlClickEvent(str2, this.isDarkstores, "lifestyle", str, i11));
        }
    }
}
