package com.talabat.talabatcommon.views.vouchers.applyVoucherView;

import android.content.Context;
import androidx.viewpager.widget.ViewPager;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.ApplyVoucherViewHolderDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.views.AddVoucherCodeView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "ctx", "Landroid/content/Context;", "model", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/ApplyVoucherViewHolderDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ApplyVouchersView$showAllMyPossibleVouchers$1 extends Lambda implements Function2<Context, ApplyVoucherViewHolderDisplayModel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ApplyVouchersView f11758g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherViewHolderDisplayModel f11759h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVouchersView$showAllMyPossibleVouchers$1(ApplyVouchersView applyVouchersView, ApplyVoucherViewHolderDisplayModel applyVoucherViewHolderDisplayModel) {
        super(2);
        this.f11758g = applyVouchersView;
        this.f11759h = applyVoucherViewHolderDisplayModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Context) obj, (ApplyVoucherViewHolderDisplayModel) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Context context, @NotNull ApplyVoucherViewHolderDisplayModel applyVoucherViewHolderDisplayModel) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        Intrinsics.checkNotNullParameter(applyVoucherViewHolderDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        ApplyVouchersView applyVouchersView = this.f11758g;
        int i11 = R.id.applyVoucherViewViewPager;
        ((ViewPager) applyVouchersView._$_findCachedViewById(i11)).setVisibility(0);
        ((ViewPager) this.f11758g._$_findCachedViewById(i11)).setAlpha(1.0f);
        ApplyVouchersView applyVouchersView2 = this.f11758g;
        int i12 = R.id.addVoucherCodeView;
        ((AddVoucherCodeView) applyVouchersView2._$_findCachedViewById(i12)).setAlpha(0.0f);
        ((AddVoucherCodeView) this.f11758g._$_findCachedViewById(i12)).setVisibility(8);
        this.f11758g.hideAddVoucherCode();
        Context context2 = this.f11758g.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        ApplyVouchersViewAdaptor applyVouchersViewAdaptor = new ApplyVouchersViewAdaptor(context2, this.f11759h.getMyVouchers());
        applyVouchersViewAdaptor.setItemClickListener(this.f11758g.vouchersViewCallback);
        ((ViewPager) this.f11758g._$_findCachedViewById(i11)).setAdapter(applyVouchersViewAdaptor);
        if (IntegrationGlobalDataModel.Companion.isArabic()) {
            ((ViewPager) this.f11758g._$_findCachedViewById(i11)).setCurrentItem(applyVouchersViewAdaptor.getCount() - 1);
        }
        int i13 = 6;
        if (this.f11759h.getMyVouchers().size() < 6) {
            i13 = this.f11759h.getMyVouchers().size();
        }
        GrowthTracker growthTracker = this.f11758g.getGrowthTracker();
        Iterable<VoucherDisplayModel> take = CollectionsKt___CollectionsKt.take(this.f11759h.getMyVouchers(), i13);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(take, 10));
        for (VoucherDisplayModel id2 : take) {
            arrayList.add(id2.getId());
        }
        growthTracker.vouchersLoadedSuccess(arrayList);
    }
}
