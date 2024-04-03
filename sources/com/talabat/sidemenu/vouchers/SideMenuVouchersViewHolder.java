package com.talabat.sidemenu.vouchers;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.ds_tag.DSTag;
import com.talabat.R;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.common.EventType;
import com.talabat.core.observabilityNew.domain.common.GrowthEvents;
import com.talabat.sidemenu.SideMenuHeader;
import com.wang.avi.AVLoadingIndicatorView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.VoucherNotificationStyle;
import library.talabat.mvp.home.VoucherStateDomainModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002J&\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fJ\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u001a\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/sidemenu/vouchers/SideMenuVouchersViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Landroid/view/View;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "hideVoucherStateLoading", "", "populate", "data", "Lcom/talabat/sidemenu/SideMenuHeader;", "userVouchersState", "Llibrary/talabat/mvp/home/VoucherStateDomainModel;", "onItemClicked", "Lkotlin/Function0;", "showVoucherCount", "showVoucherNotificationTag", "showVoucherStateLoading", "itemView", "updateUserVoucherTabState", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SideMenuVouchersViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final IObservabilityManager observabilityManager;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuVouchersViewHolder(@NotNull View view, @NotNull IObservabilityManager iObservabilityManager) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.observabilityManager = iObservabilityManager;
    }

    private final void hideVoucherStateLoading() {
        View view = this.itemView;
        int i11 = R.id.vouchers_state_container;
        ((AVLoadingIndicatorView) ((FrameLayout) view.findViewById(i11)).findViewById(R.id.voucher_state_loading)).setVisibility(4);
        ((TextView) ((FrameLayout) this.itemView.findViewById(i11)).findViewById(R.id.voucher_count)).setVisibility(4);
        ((DSTag) ((FrameLayout) this.itemView.findViewById(i11)).findViewById(R.id.voucher_notification_tag)).setVisibility(4);
    }

    /* access modifiers changed from: private */
    /* renamed from: populate$lambda-0  reason: not valid java name */
    public static final void m10905populate$lambda0(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onItemClicked");
        function0.invoke();
    }

    private final void showVoucherCount(VoucherStateDomainModel voucherStateDomainModel) {
        int totalActiveCount = voucherStateDomainModel.getTotalActiveCount();
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        String name2 = EventType.GrowthEvents.name();
        iObservabilityManager.trackEvent(GrowthEvents.VOUCHER_NOTIFICATION_LABEL_SHOWN.getValue(), name2, (Map<String, String>) MapsKt__MapsKt.mapOf(TuplesKt.to("state", "VOUCHER_COUNT"), TuplesKt.to("voucherCount", String.valueOf(totalActiveCount))));
        if (totalActiveCount != 0) {
            View view = this.itemView;
            int i11 = R.id.vouchers_state_container;
            int i12 = R.id.voucher_count;
            ((TextView) ((FrameLayout) view.findViewById(i11)).findViewById(i12)).setVisibility(0);
            ((TextView) ((FrameLayout) this.itemView.findViewById(i11)).findViewById(i12)).setText(String.valueOf(totalActiveCount));
        }
    }

    private final void showVoucherNotificationTag(VoucherStateDomainModel voucherStateDomainModel) {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        String name2 = EventType.GrowthEvents.name();
        String value = GrowthEvents.VOUCHER_NOTIFICATION_LABEL_SHOWN.getValue();
        String name3 = voucherStateDomainModel.getNotificationStyle().name();
        if (!(!name3.equals(VoucherNotificationStyle.NONE))) {
            name3 = null;
        }
        if (name3 == null) {
            name3 = "VOUCHER_COUNT";
        }
        iObservabilityManager.trackEvent(value, name2, (Map<String, String>) MapsKt__MapsJVMKt.mapOf(TuplesKt.to("state", name3)));
        if (voucherStateDomainModel.getNotificationStyle() == VoucherNotificationStyle.WARNING) {
            View view = this.itemView;
            int i11 = R.id.vouchers_state_container;
            int i12 = R.id.voucher_notification_tag;
            ((DSTag) ((FrameLayout) view.findViewById(i11)).findViewById(i12)).setVisibility(0);
            ((DSTag) ((FrameLayout) this.itemView.findViewById(i11)).findViewById(i12)).setIconColor(ContextCompat.getColor(this.itemView.getContext(), R.color.ds_alert_100));
            ((DSTag) ((FrameLayout) this.itemView.findViewById(i11)).findViewById(i12)).setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.ds_neutral_100));
            ((DSTag) ((FrameLayout) this.itemView.findViewById(i11)).findViewById(i12)).setTitle(voucherStateDomainModel.getNotificationLabel());
            ((DSTag) ((FrameLayout) this.itemView.findViewById(i11)).findViewById(i12)).setIcon(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.ds_alert_filled));
            ((DSTag) ((FrameLayout) this.itemView.findViewById(i11)).findViewById(i12)).setSecondaryColor(ContextCompat.getColor(this.itemView.getContext(), R.color.ds_alert_10));
            return;
        }
        View view2 = this.itemView;
        int i13 = R.id.vouchers_state_container;
        int i14 = R.id.voucher_notification_tag;
        ((DSTag) ((FrameLayout) view2.findViewById(i13)).findViewById(i14)).setVisibility(0);
        ((DSTag) ((FrameLayout) this.itemView.findViewById(i13)).findViewById(i14)).setTitle(voucherStateDomainModel.getNotificationLabel());
        ((DSTag) ((FrameLayout) this.itemView.findViewById(i13)).findViewById(i14)).setIcon((Drawable) null);
        ((DSTag) ((FrameLayout) this.itemView.findViewById(i13)).findViewById(i14)).setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.ds_primary_100));
        ((DSTag) ((FrameLayout) this.itemView.findViewById(i13)).findViewById(i14)).setSecondaryColor(ContextCompat.getColor(this.itemView.getContext(), R.color.ds_primary_10));
    }

    private final void showVoucherStateLoading(View view) {
        int i11 = R.id.vouchers_state_container;
        ((AVLoadingIndicatorView) ((FrameLayout) view.findViewById(i11)).findViewById(R.id.voucher_state_loading)).setVisibility(0);
        ((TextView) ((FrameLayout) view.findViewById(i11)).findViewById(R.id.voucher_count)).setVisibility(4);
        ((DSTag) ((FrameLayout) view.findViewById(i11)).findViewById(R.id.voucher_notification_tag)).setVisibility(4);
    }

    private final void updateUserVoucherTabState(View view, VoucherStateDomainModel voucherStateDomainModel) {
        if (voucherStateDomainModel == null) {
            showVoucherStateLoading(view);
            return;
        }
        hideVoucherStateLoading();
        if (!StringsKt__StringsJVMKt.isBlank(voucherStateDomainModel.getNotificationLabel())) {
            showVoucherNotificationTag(voucherStateDomainModel);
        } else {
            showVoucherCount(voucherStateDomainModel);
        }
    }

    public final void populate(@NotNull SideMenuHeader sideMenuHeader, @Nullable VoucherStateDomainModel voucherStateDomainModel, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(sideMenuHeader, "data");
        Intrinsics.checkNotNullParameter(function0, "onItemClicked");
        ((ImageView) this.itemView.findViewById(R.id.side_menu_header_icon)).setImageResource(sideMenuHeader.getIconDrawableId(true));
        ((TextView) this.itemView.findViewById(R.id.side_menu_header_title)).setText(sideMenuHeader.getTitle());
        this.itemView.setTag(sideMenuHeader.getTitle());
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        updateUserVoucherTabState(view, voucherStateDomainModel);
        this.itemView.setOnClickListener(new a(function0));
    }
}
