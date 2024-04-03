package com.talabat.talabatlife.ui.onBoarding;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.talabat.talabatlife.ui.vendorList.model.VendorDisplayModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R0\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/TLifeOnBoardingPageAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "value", "", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;", "restaurants", "getRestaurants", "()Ljava/util/List;", "setRestaurants", "(Ljava/util/List;)V", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "view", "", "getCount", "getPageWidth", "", "instantiateItem", "isViewFromObject", "", "Landroid/view/View;", "viewObject", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeOnBoardingPageAdapter extends PagerAdapter {
    @NotNull
    private final Context context;
    @NotNull
    private List<VendorDisplayModel> restaurants = new ArrayList();

    public TLifeOnBoardingPageAdapter(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public void destroyItem(@NotNull ViewGroup viewGroup, int i11, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(viewGroup, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(obj, "view");
        viewGroup.removeView((View) obj);
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public int getCount() {
        return this.restaurants.size();
    }

    public float getPageWidth(int i11) {
        return 0.224f;
    }

    @NotNull
    public final List<VendorDisplayModel> getRestaurants() {
        return this.restaurants;
    }

    @NotNull
    public Object instantiateItem(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, TtmlNode.RUBY_CONTAINER);
        TLifeOnBoardingRestaurantView tLifeOnBoardingRestaurantView = new TLifeOnBoardingRestaurantView(this.context);
        tLifeOnBoardingRestaurantView.populate(this.restaurants.get(i11));
        viewGroup.addView(tLifeOnBoardingRestaurantView);
        return tLifeOnBoardingRestaurantView;
    }

    public boolean isViewFromObject(@NotNull View view, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "viewObject");
        return Intrinsics.areEqual((Object) view, obj);
    }

    public final void setRestaurants(@NotNull List<VendorDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.restaurants = list;
        notifyDataSetChanged();
    }
}
