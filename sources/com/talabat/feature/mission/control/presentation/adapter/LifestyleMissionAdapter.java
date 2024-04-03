package com.talabat.feature.mission.control.presentation.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMissionItem;
import com.talabat.feature.mission.control.presentation.databinding.LifeStyleMissionItemV2ViewBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bh\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012S\u0010\u0006\u001aO\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007j\u0004\u0018\u0001`\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R[\u0010\u0006\u001aO\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007j\u0004\u0018\u0001`\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/mission/control/presentation/adapter/LifestyleMissionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/feature/mission/control/presentation/adapter/LifestyleMissionViewHolder;", "lifestyleMissionItem", "", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMissionItem;", "missionClickListener", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "code", "", "position", "", "Lcom/talabat/feature/mission/control/presentation/listener/MissionClickListener;", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_feature_mission-control_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifestyleMissionAdapter extends RecyclerView.Adapter<LifestyleMissionViewHolder> {
    @NotNull
    private final List<LifestyleMissionItem> lifestyleMissionItem;
    @Nullable
    private final Function3<String, String, Integer, Unit> missionClickListener;

    public LifestyleMissionAdapter(@NotNull List<LifestyleMissionItem> list, @Nullable Function3<? super String, ? super String, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(list, "lifestyleMissionItem");
        this.lifestyleMissionItem = list;
        this.missionClickListener = function3;
    }

    public int getItemCount() {
        return this.lifestyleMissionItem.size();
    }

    public void onBindViewHolder(@NotNull LifestyleMissionViewHolder lifestyleMissionViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(lifestyleMissionViewHolder, "holder");
        lifestyleMissionViewHolder.bind(getItemCount(), i11, this.lifestyleMissionItem.get(i11), this.missionClickListener);
    }

    @NotNull
    public LifestyleMissionViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LifeStyleMissionItemV2ViewBinding inflate = LifeStyleMissionItemV2ViewBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               …      false\n            )");
        return new LifestyleMissionViewHolder(inflate);
    }
}
