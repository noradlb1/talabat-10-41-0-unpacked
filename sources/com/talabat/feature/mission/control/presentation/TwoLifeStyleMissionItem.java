package com.talabat.feature.mission.control.presentation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.talabat.feature.mission.control.domain.model.LifeStyleMissionControlData;
import com.talabat.feature.mission.control.presentation.databinding.TwoLifeStyleMissionItemBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ[\u0010\u0010\u001a\u00020\f2S\u0010\u0011\u001aO\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012j\u0004\u0018\u0001`\u0018R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/mission/control/presentation/TwoLifeStyleMissionItem;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/feature/mission/control/presentation/databinding/TwoLifeStyleMissionItemBinding;", "setContent", "", "firstLifeStyleMission", "Lcom/talabat/feature/mission/control/domain/model/LifeStyleMissionControlData;", "secondLifeStyleMission", "setMissionClickListener", "missionClickListener", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "code", "position", "Lcom/talabat/feature/mission/control/presentation/listener/MissionClickListener;", "com_talabat_feature_mission-control_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TwoLifeStyleMissionItem extends LinearLayout {
    @NotNull
    private final TwoLifeStyleMissionItemBinding binding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TwoLifeStyleMissionItem(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TwoLifeStyleMissionItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TwoLifeStyleMissionItem(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final void setContent(@NotNull LifeStyleMissionControlData lifeStyleMissionControlData, @NotNull LifeStyleMissionControlData lifeStyleMissionControlData2) {
        Intrinsics.checkNotNullParameter(lifeStyleMissionControlData, "firstLifeStyleMission");
        Intrinsics.checkNotNullParameter(lifeStyleMissionControlData2, "secondLifeStyleMission");
        this.binding.firstLifeStyleMission.setContent(lifeStyleMissionControlData, 0);
        this.binding.secondLifeStyleMission.setContent(lifeStyleMissionControlData2, 1);
    }

    public final void setMissionClickListener(@Nullable Function3<? super String, ? super String, ? super Integer, Unit> function3) {
        this.binding.firstLifeStyleMission.setMissionClickListener(function3);
        this.binding.secondLifeStyleMission.setMissionClickListener(function3);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TwoLifeStyleMissionItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        TwoLifeStyleMissionItemBinding inflate = TwoLifeStyleMissionItemBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this)");
        this.binding = inflate;
    }
}
