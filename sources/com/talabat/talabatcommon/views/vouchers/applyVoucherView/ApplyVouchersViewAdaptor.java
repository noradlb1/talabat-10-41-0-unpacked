package com.talabat.talabatcommon.views.vouchers.applyVoucherView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTrackerConstants;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.views.ApplyVoucherPageView;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.views.ApplyVouchersViewPagerItemCallback;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/ApplyVouchersViewAdaptor;", "Landroidx/viewpager/widget/PagerAdapter;", "context", "Landroid/content/Context;", "vouchers", "", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;", "(Landroid/content/Context;Ljava/util/List;)V", "itemClickListener", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/views/ApplyVouchersViewPagerItemCallback;", "getItemClickListener", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/views/ApplyVouchersViewPagerItemCallback;", "setItemClickListener", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/views/ApplyVouchersViewPagerItemCallback;)V", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "view", "", "getCount", "getPageWidth", "", "instantiateItem", "isViewFromObject", "", "Landroid/view/View;", "viewObject", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApplyVouchersViewAdaptor extends PagerAdapter {
    @NotNull
    private final Context context;
    @Nullable
    private ApplyVouchersViewPagerItemCallback itemClickListener;
    @NotNull
    private List<VoucherDisplayModel> vouchers;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ApplyVouchersViewAdaptor(Context context2, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i11 & 2) != 0 ? new ArrayList() : list);
    }

    public void destroyItem(@NotNull ViewGroup viewGroup, int i11, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(viewGroup, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(obj, "view");
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        return this.vouchers.size();
    }

    @Nullable
    public final ApplyVouchersViewPagerItemCallback getItemClickListener() {
        return this.itemClickListener;
    }

    public float getPageWidth(int i11) {
        return getCount() > 1 ? 0.88f : 1.0f;
    }

    @NotNull
    public Object instantiateItem(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, TtmlNode.RUBY_CONTAINER);
        ApplyVoucherPageView applyVoucherPageView = new ApplyVoucherPageView(this.context);
        applyVoucherPageView.populate(this.vouchers.get(i11));
        applyVoucherPageView.setCallback(this.itemClickListener);
        viewGroup.addView(applyVoucherPageView);
        return applyVoucherPageView;
    }

    public boolean isViewFromObject(@NotNull View view, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "viewObject");
        return Intrinsics.areEqual((Object) view, obj);
    }

    public final void setItemClickListener(@Nullable ApplyVouchersViewPagerItemCallback applyVouchersViewPagerItemCallback) {
        this.itemClickListener = applyVouchersViewPagerItemCallback;
    }

    public ApplyVouchersViewAdaptor(@NotNull Context context2, @NotNull List<VoucherDisplayModel> list) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(list, GrowthTrackerConstants.VOUCHERS_FEATURE_NAME);
        this.context = context2;
        this.vouchers = list;
        if (IntegrationGlobalDataModel.Companion.isArabic()) {
            CollectionsKt___CollectionsJvmKt.reverse(this.vouchers);
        }
    }
}
