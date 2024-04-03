package com.talabat.feature.mission.control.presentation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.talabat.feature.mission.control.domain.model.PrimaryMissionControlData;
import com.talabat.feature.mission.control.presentation.databinding.TwoPrimaryMissionViewBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J[\u0010\u0013\u001a\u00020\f2S\u0010\u0014\u001aO\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\f\u0018\u00010\u0015j\u0004\u0018\u0001`\u001bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/mission/control/presentation/TwoPrimaryMissionView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/feature/mission/control/presentation/databinding/TwoPrimaryMissionViewBinding;", "setContent", "", "firstPrimaryMission", "Lcom/talabat/feature/mission/control/domain/model/PrimaryMissionControlData;", "secondPrimaryMission", "isPrimaryMissionTwoTiles", "", "isNewIcon", "setMissionClickListener", "missionClickListener", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "code", "position", "Lcom/talabat/feature/mission/control/presentation/listener/MissionClickListener;", "com_talabat_feature_mission-control_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TwoPrimaryMissionView extends LinearLayout {
    @NotNull
    private final TwoPrimaryMissionViewBinding binding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TwoPrimaryMissionView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TwoPrimaryMissionView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TwoPrimaryMissionView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final void setContent(@NotNull PrimaryMissionControlData primaryMissionControlData, @NotNull PrimaryMissionControlData primaryMissionControlData2, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(primaryMissionControlData, "firstPrimaryMission");
        Intrinsics.checkNotNullParameter(primaryMissionControlData2, "secondPrimaryMission");
        this.binding.firstPrimaryMission.setContent(primaryMissionControlData, 0, z11, z12);
        this.binding.secondPrimaryMission.setContent(primaryMissionControlData2, 1, z11, z12);
    }

    public final void setMissionClickListener(@Nullable Function3<? super String, ? super String, ? super Integer, Unit> function3) {
        this.binding.firstPrimaryMission.setMissionClickListener(function3);
        this.binding.secondPrimaryMission.setMissionClickListener(function3);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TwoPrimaryMissionView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        TwoPrimaryMissionViewBinding inflate = TwoPrimaryMissionViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this)");
        this.binding = inflate;
    }
}
