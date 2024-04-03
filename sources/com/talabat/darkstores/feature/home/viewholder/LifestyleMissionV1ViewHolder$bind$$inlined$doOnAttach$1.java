package com.talabat.darkstores.feature.home.viewholder;

import android.view.View;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.home.MissionItemData;
import com.talabat.feature.mission.control.presentation.LifeStyleMissionView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"androidx/core/view/ViewKt$doOnAttach$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "view", "Landroid/view/View;", "onViewDetachedFromWindow", "core-ktx_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifestyleMissionV1ViewHolder$bind$$inlined$doOnAttach$1 implements View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f56437b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LifestyleMissionV1ViewHolder f56438c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MissionItemData f56439d;

    public LifestyleMissionV1ViewHolder$bind$$inlined$doOnAttach$1(View view, LifestyleMissionV1ViewHolder lifestyleMissionV1ViewHolder, MissionItemData missionItemData) {
        this.f56437b = view;
        this.f56438c = lifestyleMissionV1ViewHolder;
        this.f56439d = missionItemData;
    }

    public void onViewAttachedToWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f56437b.removeOnAttachStateChangeListener(this);
        ((LifeStyleMissionView) this.f56438c.itemView.findViewById(R.id.lifeStyleMissionV1)).load(this.f56439d.getVendorId(), this.f56439d.getVendorCode(), this.f56439d.isDarkstores(), this.f56439d.getLifeStyleMissionClickListener());
    }

    public void onViewDetachedFromWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }
}
