package com.talabat.growth.ui.loyalty.burn.burnOptions;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemCategoryViewType;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import er.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnOptions/LoyaltyBurnOptionsAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "context", "Landroid/content/Context;", "burnOptions", "", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "viewMode", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryViewType;", "onBurnOptionClickListener", "Lcom/talabat/growth/ui/loyalty/burn/burnOptions/BurnOptionClickListener;", "(Landroid/content/Context;Ljava/util/List;Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryViewType;Lcom/talabat/growth/ui/loyalty/burn/burnOptions/BurnOptionClickListener;)V", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "view", "", "getCount", "getPageWidth", "", "instantiateItem", "isViewFromObject", "", "Landroid/view/View;", "viewObject", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyBurnOptionsAdapter extends PagerAdapter {
    @NotNull
    private List<BurnItemDisplayModel> burnOptions;
    @NotNull
    private final Context context;
    @Nullable
    private BurnOptionClickListener onBurnOptionClickListener;
    @NotNull
    private BurnItemCategoryViewType viewMode;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoyaltyBurnOptionsAdapter(Context context2, List list, BurnItemCategoryViewType burnItemCategoryViewType, BurnOptionClickListener burnOptionClickListener, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, list, (i11 & 4) != 0 ? BurnItemCategoryViewType.SWIM_LANE_HALF_WIDTH_CARDS : burnItemCategoryViewType, (i11 & 8) != 0 ? null : burnOptionClickListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: instantiateItem$lambda-1$lambda-0  reason: not valid java name */
    public static final void m10598instantiateItem$lambda1$lambda0(LoyaltyBurnOptionsAdapter loyaltyBurnOptionsAdapter, int i11, View view) {
        Intrinsics.checkNotNullParameter(loyaltyBurnOptionsAdapter, "this$0");
        BurnOptionClickListener burnOptionClickListener = loyaltyBurnOptionsAdapter.onBurnOptionClickListener;
        if (burnOptionClickListener != null) {
            burnOptionClickListener.onBurnOptionClicked(i11, loyaltyBurnOptionsAdapter.burnOptions.get(i11));
        }
    }

    public void destroyItem(@NotNull ViewGroup viewGroup, int i11, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(viewGroup, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(obj, "view");
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        return this.burnOptions.size();
    }

    public float getPageWidth(int i11) {
        return LoyaltyBurnOptionsCardWidthHelper.INSTANCE.getCardWidth(this.viewMode, this.burnOptions.size());
    }

    @NotNull
    public Object instantiateItem(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, TtmlNode.RUBY_CONTAINER);
        LoyaltyBurnOptionViewHolderLarge loyaltyBurnOptionViewHolderLarge = new LoyaltyBurnOptionViewHolderLarge(this.context);
        loyaltyBurnOptionViewHolderLarge.populate(this.burnOptions.get(i11));
        loyaltyBurnOptionViewHolderLarge.setOnClickListener(new a(this, i11));
        viewGroup.addView(loyaltyBurnOptionViewHolderLarge);
        return loyaltyBurnOptionViewHolderLarge;
    }

    public boolean isViewFromObject(@NotNull View view, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "viewObject");
        return Intrinsics.areEqual((Object) view, obj);
    }

    public LoyaltyBurnOptionsAdapter(@NotNull Context context2, @NotNull List<BurnItemDisplayModel> list, @NotNull BurnItemCategoryViewType burnItemCategoryViewType, @Nullable BurnOptionClickListener burnOptionClickListener) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(list, "burnOptions");
        Intrinsics.checkNotNullParameter(burnItemCategoryViewType, "viewMode");
        this.context = context2;
        this.burnOptions = list;
        this.viewMode = burnItemCategoryViewType;
        this.onBurnOptionClickListener = burnOptionClickListener;
        if (IntegrationGlobalDataModel.Companion.isArabic()) {
            CollectionsKt___CollectionsJvmKt.reverse(this.burnOptions);
        }
    }
}
