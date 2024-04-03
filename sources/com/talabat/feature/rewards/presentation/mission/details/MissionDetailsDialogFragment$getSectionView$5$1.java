package com.talabat.feature.rewards.presentation.mission.details;

import com.talabat.feature.rewards.domain.model.MissionButtonType;
import com.talabat.feature.rewards.presentation.mission.details.MissionDetailsDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MissionDetailsDialogFragment$getSectionView$5$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MissionDetailsDialogFragment f58771g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MissionDetailsDialogFragment.Section f58772h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MissionDetailsDialogFragment$getSectionView$5$1(MissionDetailsDialogFragment missionDetailsDialogFragment, MissionDetailsDialogFragment.Section section) {
        super(0);
        this.f58771g = missionDetailsDialogFragment;
        this.f58772h = section;
    }

    public final void invoke() {
        this.f58771g.trackButtonClicked(MissionButtonType.SECONDARY);
        this.f58771g.handleButtonClick(((MissionDetailsDialogFragment.Section.ButtonBasic) this.f58772h).getDeeplink());
    }
}
