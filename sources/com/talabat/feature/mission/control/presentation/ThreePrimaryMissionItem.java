package com.talabat.feature.mission.control.presentation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import bn.f;
import com.talabat.feature.mission.control.domain.model.PrimaryMissionControlData;
import com.talabat.feature.mission.control.presentation.databinding.ThreePrimaryMissionItemBinding;
import com.talabat.feature.mission.control.presentation.extensions.MissionControlExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000Rg\u0010\u000b\u001aO\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fj\u0004\u0018\u0001`\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/mission/control/presentation/ThreePrimaryMissionItem;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/feature/mission/control/presentation/databinding/ThreePrimaryMissionItemBinding;", "missionClickListener", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "code", "position", "", "Lcom/talabat/feature/mission/control/presentation/listener/MissionClickListener;", "getMissionClickListener", "()Lkotlin/jvm/functions/Function3;", "setMissionClickListener", "(Lkotlin/jvm/functions/Function3;)V", "setContent", "primaryMission", "Lcom/talabat/feature/mission/control/domain/model/PrimaryMissionControlData;", "com_talabat_feature_mission-control_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ThreePrimaryMissionItem extends LinearLayout {
    @NotNull
    private final ThreePrimaryMissionItemBinding binding;
    @Nullable
    private Function3<? super String, ? super String, ? super Integer, Unit> missionClickListener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ThreePrimaryMissionItem(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ThreePrimaryMissionItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ThreePrimaryMissionItem(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: setContent$lambda-1  reason: not valid java name */
    public static final void m10226setContent$lambda1(ThreePrimaryMissionItem threePrimaryMissionItem, PrimaryMissionControlData primaryMissionControlData, int i11, View view) {
        Intrinsics.checkNotNullParameter(threePrimaryMissionItem, "this$0");
        Intrinsics.checkNotNullParameter(primaryMissionControlData, "$primaryMission");
        Function3<? super String, ? super String, ? super Integer, Unit> function3 = threePrimaryMissionItem.missionClickListener;
        if (function3 != null) {
            function3.invoke(primaryMissionControlData.getCode(), primaryMissionControlData.getName(), Integer.valueOf(i11));
        }
    }

    @Nullable
    public final Function3<String, String, Integer, Unit> getMissionClickListener() {
        return this.missionClickListener;
    }

    public final void setContent(@NotNull PrimaryMissionControlData primaryMissionControlData, int i11) {
        Intrinsics.checkNotNullParameter(primaryMissionControlData, "primaryMission");
        this.binding.title.setText(primaryMissionControlData.getName());
        this.binding.icon.setImageResource(MissionControlExtensionsKt.getIcon(primaryMissionControlData));
        this.binding.containerView.setOnClickListener(new f(this, primaryMissionControlData, i11));
    }

    public final void setMissionClickListener(@Nullable Function3<? super String, ? super String, ? super Integer, Unit> function3) {
        this.missionClickListener = function3;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ThreePrimaryMissionItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        ThreePrimaryMissionItemBinding inflate = ThreePrimaryMissionItemBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this)");
        this.binding = inflate;
    }
}
