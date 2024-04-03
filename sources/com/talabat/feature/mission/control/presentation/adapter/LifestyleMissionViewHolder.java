package com.talabat.feature.mission.control.presentation.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import cn.a;
import com.designsystem.marshmallow.R;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMissionItem;
import com.talabat.feature.mission.control.presentation.databinding.LifeStyleMissionItemV2ViewBinding;
import com.talabat.feature.mission.control.presentation.extensions.ImageViewExtensionsKt;
import com.talabat.feature.mission.control.presentation.extensions.MissionControlExtensionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Js\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2S\u0010\u000e\u001aO\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fj\u0004\u0018\u0001`\u0014J,\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00162\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u001c\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00162\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/mission/control/presentation/adapter/LifestyleMissionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/mission/control/presentation/databinding/LifeStyleMissionItemV2ViewBinding;", "(Lcom/talabat/feature/mission/control/presentation/databinding/LifeStyleMissionItemV2ViewBinding;)V", "horizontalSpacing", "", "margin", "bind", "", "itemsCount", "position", "item", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMissionItem;", "missionClickListener", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "code", "Lcom/talabat/feature/mission/control/presentation/listener/MissionClickListener;", "getWidthAndHeightForImage", "Lkotlin/Pair;", "resources", "Landroid/content/res/Resources;", "width", "getWidthAndHeightForLargeImage", "getWidthAndHeightForMediumImage", "getWidthAndHeightForSmallImage", "com_talabat_feature_mission-control_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifestyleMissionViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final LifeStyleMissionItemV2ViewBinding binding;
    private final int horizontalSpacing;
    private final int margin;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LifestyleMissionViewHolder(@NotNull LifeStyleMissionItemV2ViewBinding lifeStyleMissionItemV2ViewBinding) {
        super(lifeStyleMissionItemV2ViewBinding.getRoot());
        Intrinsics.checkNotNullParameter(lifeStyleMissionItemV2ViewBinding, "binding");
        this.binding = lifeStyleMissionItemV2ViewBinding;
        this.horizontalSpacing = lifeStyleMissionItemV2ViewBinding.getRoot().getContext().getResources().getDimensionPixelOffset(R.dimen.ds_xs);
        this.margin = lifeStyleMissionItemV2ViewBinding.getRoot().getContext().getResources().getDimensionPixelOffset(R.dimen.ds_xl);
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m10228bind$lambda0(Function3 function3, LifestyleMissionItem lifestyleMissionItem, int i11, View view) {
        Intrinsics.checkNotNullParameter(lifestyleMissionItem, "$item");
        if (function3 != null) {
            function3.invoke(lifestyleMissionItem.getId(), lifestyleMissionItem.getName(), Integer.valueOf(i11));
        }
    }

    private final Pair<Integer, Integer> getWidthAndHeightForImage(Resources resources, int i11, int i12) {
        double dimensionPixelOffset = ((double) i12) / ((double) resources.getDimensionPixelOffset(com.talabat.feature.mission.control.presentation.R.dimen.life_style_mission_image_height));
        int i13 = ((resources.getDisplayMetrics().widthPixels - this.margin) - (this.horizontalSpacing * (i11 - 1))) / i11;
        return new Pair<>(Integer.valueOf(i13), Integer.valueOf((int) (((double) i13) / dimensionPixelOffset)));
    }

    private final Pair<Integer, Integer> getWidthAndHeightForLargeImage(int i11) {
        Resources resources = this.binding.getRoot().getContext().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.talabat.feature.mission.control.presentation.R.dimen.life_style_mission_large_image_width);
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return getWidthAndHeightForImage(resources, i11, dimensionPixelOffset);
    }

    private final Pair<Integer, Integer> getWidthAndHeightForMediumImage(int i11) {
        Resources resources = this.binding.getRoot().getContext().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.talabat.feature.mission.control.presentation.R.dimen.life_style_mission_medium_image_width);
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return getWidthAndHeightForImage(resources, i11, dimensionPixelOffset);
    }

    private final Pair<Integer, Integer> getWidthAndHeightForSmallImage() {
        int i11 = (int) (((double) ((this.binding.getRoot().getContext().getResources().getDisplayMetrics().widthPixels - this.margin) - (this.horizontalSpacing * 3))) / 3.5d);
        return new Pair<>(Integer.valueOf(i11), Integer.valueOf(i11));
    }

    public final void bind(int i11, int i12, @NotNull LifestyleMissionItem lifestyleMissionItem, @Nullable Function3<? super String, ? super String, ? super Integer, Unit> function3) {
        Pair<Integer, Integer> pair;
        Intrinsics.checkNotNullParameter(lifestyleMissionItem, "item");
        this.binding.getRoot().setOnClickListener(new a(function3, lifestyleMissionItem, i12));
        if (i11 == 2) {
            pair = getWidthAndHeightForLargeImage(i11);
        } else if (i11 != 3) {
            pair = getWidthAndHeightForSmallImage();
        } else {
            pair = getWidthAndHeightForMediumImage(i11);
        }
        int intValue = pair.component1().intValue();
        int intValue2 = pair.component2().intValue();
        this.binding.getRoot().getLayoutParams().width = intValue;
        this.binding.image.getLayoutParams().height = intValue2;
        LifeStyleMissionItemV2ViewBinding lifeStyleMissionItemV2ViewBinding = this.binding;
        CardView cardView = lifeStyleMissionItemV2ViewBinding.containerView;
        Context context = lifeStyleMissionItemV2ViewBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        cardView.setCardBackgroundColor(MissionControlExtensionsKt.getBackgroundColor(lifestyleMissionItem, context));
        this.binding.title.setText(lifestyleMissionItem.getName());
        AppCompatImageView appCompatImageView = this.binding.image;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.image");
        ImageViewExtensionsKt.loadCenterInsideWithGlide(appCompatImageView, lifestyleMissionItem.getImageUrl());
    }
}
