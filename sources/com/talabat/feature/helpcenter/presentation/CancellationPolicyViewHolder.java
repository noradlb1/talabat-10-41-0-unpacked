package com.talabat.feature.helpcenter.presentation;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.feature.helpcenter.R;
import com.talabat.talabatcore.BaseViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import xm.c;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0016\u0010\t\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¨\u0006\f"}, d2 = {"Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyViewHolder;", "Lcom/talabat/talabatcore/BaseViewHolder;", "Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyItemDisplayModel;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "populate", "", "model", "setOnClickListener", "itemClickListener", "Lkotlin/Function0;", "com_talabat_feature_helpcenter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancellationPolicyViewHolder extends BaseViewHolder<CancellationPolicyItemDisplayModel> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CancellationPolicyViewHolder(@NotNull ViewGroup viewGroup) {
        super(viewGroup, R.layout.item_cancellation_policy);
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnClickListener$lambda-1  reason: not valid java name */
    public static final void m10220setOnClickListener$lambda1(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$itemClickListener");
        function0.invoke();
    }

    public final void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "itemClickListener");
        this.itemView.setOnClickListener(new c(function0));
    }

    public void populate(@NotNull CancellationPolicyItemDisplayModel cancellationPolicyItemDisplayModel) {
        Intrinsics.checkNotNullParameter(cancellationPolicyItemDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        View view = this.itemView;
        ((TextView) this.itemView.findViewById(R.id.tvItemCancellationPolicy)).setText(cancellationPolicyItemDisplayModel.getTitle());
        ((TextView) this.itemView.findViewById(R.id.tvItemCancellationPolicyDesc)).setText(cancellationPolicyItemDisplayModel.getDescription());
        ((RequestBuilder) ((RequestBuilder) Glide.with(view).load(cancellationPolicyItemDisplayModel.getIcon()).placeholder(R.drawable.cancellation_policy_icon_holder)).fitCenter()).into((ImageView) this.itemView.findViewById(R.id.ivCancellationPolicyIcon));
    }
}
