package com.talabat.darkstores.feature.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.OnProductQuantityChangeTrackingListener;
import com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker;
import com.talabat.darkstores.data.tracking.impression.TrackingData;
import com.talabat.darkstores.feature.home.HomeRecyclerViewItem;
import com.talabat.darkstores.feature.home.banner.LoopingViewPager;
import com.talabat.darkstores.feature.home.viewholder.BannerViewHolder;
import com.talabat.darkstores.feature.home.viewholder.CategoryGridViewHolder;
import com.talabat.darkstores.feature.home.viewholder.HomeSearchViewHolder;
import com.talabat.darkstores.feature.home.viewholder.LifestyleMissionV1ViewHolder;
import com.talabat.darkstores.feature.home.viewholder.LifestyleMissionV2ViewHolder;
import com.talabat.darkstores.feature.home.viewholder.PrimaryMissionViewHolder;
import com.talabat.darkstores.feature.home.viewholder.ProgressBarViewHolder;
import com.talabat.darkstores.feature.home.viewholder.RewardsMissionViewHolder;
import com.talabat.darkstores.feature.home.viewholder.SwimlanesProductViewHolder;
import com.talabat.darkstores.feature.home.viewholder.TproSubscriptionHeaderViewHolder;
import com.talabat.darkstores.feature.home.viewholder.TproSubscriptionHeaderViewHolderV2;
import com.talabat.darkstores.model.Category;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BÆ\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\u0012:\u0010\u000b\u001a6\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\fj\u0002`\u0013\u0012+\u0010\u0014\u001a'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\u0016¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00120\u0015j\u0002`\u0018\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010!\u001a\u00020\"¢\u0006\u0002\u0010#J\u0018\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0018\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0018\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\nH\u0016J\u0010\u00101\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0003H\u0016R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0%X\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000RB\u0010\u000b\u001a6\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\fj\u0002`\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001bX\u0004¢\u0006\u0002\n\u0000R3\u0010\u0014\u001a'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\u0016¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00120\u0015j\u0002`\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeFragmentRecyclerViewAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onProductQuantityChangeTrackingListener", "Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;", "cartMapLiveData", "Landroidx/lifecycle/LiveData;", "", "", "", "onCategoryClicked", "Lkotlin/Function2;", "Lcom/talabat/darkstores/model/Category;", "Lkotlin/ParameterName;", "name", "item", "position", "", "Lcom/talabat/darkstores/feature/home/OnCategoryClicked;", "onViewAllCategoryClicked", "Lkotlin/Function1;", "", "categoryList", "Lcom/talabat/darkstores/feature/home/viewholder/OnViewAllCategoryClicked;", "categoriesRowsCount", "onSearchClickListener", "Lkotlin/Function0;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "heroBannerImpressionTracker", "Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;", "smallBannerImpressionTracker", "trackingData", "Lcom/talabat/darkstores/data/tracking/impression/TrackingData;", "(Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;Landroidx/lifecycle/LiveData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;ILkotlin/jvm/functions/Function0;Landroidx/lifecycle/LifecycleOwner;Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;Lcom/talabat/darkstores/data/tracking/impression/TrackingData;)V", "bannerPositionMap", "", "bindBanners", "bannerViewHolder", "Lcom/talabat/darkstores/feature/home/viewholder/BannerViewHolder;", "Lcom/talabat/darkstores/feature/home/BannerItemViewHolderData;", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeFragmentRecyclerViewAdapter extends ListAdapter<HomeRecyclerViewItem, RecyclerView.ViewHolder> {
    @NotNull
    private final Map<String, Integer> bannerPositionMap = new LinkedHashMap();
    @NotNull
    private final LiveData<Map<String, Integer>> cartMapLiveData;
    private final int categoriesRowsCount;
    @NotNull
    private final ProductImpressionTracker heroBannerImpressionTracker;
    @NotNull
    private final LifecycleOwner lifecycleOwner;
    @NotNull
    private final Function2<Category, Integer, Unit> onCategoryClicked;
    @NotNull
    private final OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener;
    @NotNull
    private final Function0<Unit> onSearchClickListener;
    @NotNull
    private final Function1<List<Category>, Unit> onViewAllCategoryClicked;
    @NotNull
    private final ProductImpressionTracker smallBannerImpressionTracker;
    @NotNull
    private final TrackingData trackingData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragmentRecyclerViewAdapter(@NotNull OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener2, @NotNull LiveData<Map<String, Integer>> liveData, @NotNull Function2<? super Category, ? super Integer, Unit> function2, @NotNull Function1<? super List<Category>, Unit> function1, int i11, @NotNull Function0<Unit> function0, @NotNull LifecycleOwner lifecycleOwner2, @NotNull ProductImpressionTracker productImpressionTracker, @NotNull ProductImpressionTracker productImpressionTracker2, @NotNull TrackingData trackingData2) {
        super(new HomePageItemDiffUtil());
        Intrinsics.checkNotNullParameter(onProductQuantityChangeTrackingListener2, "onProductQuantityChangeTrackingListener");
        Intrinsics.checkNotNullParameter(liveData, "cartMapLiveData");
        Intrinsics.checkNotNullParameter(function2, "onCategoryClicked");
        Intrinsics.checkNotNullParameter(function1, "onViewAllCategoryClicked");
        Intrinsics.checkNotNullParameter(function0, "onSearchClickListener");
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(productImpressionTracker, "heroBannerImpressionTracker");
        Intrinsics.checkNotNullParameter(productImpressionTracker2, "smallBannerImpressionTracker");
        Intrinsics.checkNotNullParameter(trackingData2, "trackingData");
        this.onProductQuantityChangeTrackingListener = onProductQuantityChangeTrackingListener2;
        this.cartMapLiveData = liveData;
        this.onCategoryClicked = function2;
        this.onViewAllCategoryClicked = function1;
        this.categoriesRowsCount = i11;
        this.onSearchClickListener = function0;
        this.lifecycleOwner = lifecycleOwner2;
        this.heroBannerImpressionTracker = productImpressionTracker;
        this.smallBannerImpressionTracker = productImpressionTracker2;
        this.trackingData = trackingData2;
    }

    private final void bindBanners(BannerViewHolder bannerViewHolder, BannerItemViewHolderData bannerItemViewHolderData) {
        int i11;
        Integer num = this.bannerPositionMap.get(bannerItemViewHolderData.getBannerType());
        if (num != null) {
            i11 = num.intValue();
        } else {
            i11 = 0;
        }
        bannerViewHolder.bind(bannerItemViewHolderData, i11);
    }

    public int getItemViewType(int i11) {
        HomeRecyclerViewItem homeRecyclerViewItem = (HomeRecyclerViewItem) getItem(i11);
        if (homeRecyclerViewItem instanceof HomeRecyclerViewItem.HeroBannerItem) {
            return R.layout.darkstores_item_home_hero_banner;
        }
        if (homeRecyclerViewItem instanceof HomeRecyclerViewItem.SmallBannerItem) {
            return R.layout.darkstores_item_home_banner;
        }
        if (homeRecyclerViewItem instanceof HomeRecyclerViewItem.SwimlaneItem) {
            return R.layout.darkstores_item_home_swimlane;
        }
        if (homeRecyclerViewItem instanceof HomeRecyclerViewItem.CategoryGridItem) {
            return R.layout.darkstores_item_category_grid;
        }
        if (homeRecyclerViewItem instanceof HomeRecyclerViewItem.LifeStyleMissionV1Item) {
            return R.layout.darkstores_item_home_lifestyle_mission_v1;
        }
        if (homeRecyclerViewItem instanceof HomeRecyclerViewItem.LifestyleMissionV2Item) {
            return R.layout.darkstores_item_home_lifestyle_mission_v2;
        }
        if (homeRecyclerViewItem instanceof HomeRecyclerViewItem.PrimaryMissionItem) {
            return R.layout.darkstores_item_home_primary_mission;
        }
        if (homeRecyclerViewItem instanceof HomeRecyclerViewItem.RewardsMissionItem) {
            return R.layout.darkstores_item_home_reward_mission;
        }
        if (homeRecyclerViewItem instanceof HomeRecyclerViewItem.SearchViewItem) {
            return R.layout.darkstores_item_home_search_view;
        }
        if (homeRecyclerViewItem instanceof HomeRecyclerViewItem.TproSubscriptionItem) {
            return R.layout.darkstores_item_home_tpro;
        }
        if (homeRecyclerViewItem instanceof HomeRecyclerViewItem.ProgressViewItem) {
            return R.layout.darkstores_item_home_progress;
        }
        if (homeRecyclerViewItem instanceof HomeRecyclerViewItem.TproSubscriptionItemV2) {
            return R.layout.darkstores_item_home_tpro_v2;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.talabat.darkstores.feature.home.viewholder.RewardsMissionViewHolder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.talabat.darkstores.feature.home.viewholder.PrimaryMissionViewHolder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.talabat.darkstores.feature.home.viewholder.LifestyleMissionV2ViewHolder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.talabat.darkstores.feature.home.viewholder.LifestyleMissionV1ViewHolder} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.ViewHolder r3, int r4) {
        /*
            r2 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.Object r4 = r2.getItem(r4)
            java.lang.String r0 = "getItem(position)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            com.talabat.darkstores.feature.home.HomeRecyclerViewItem r4 = (com.talabat.darkstores.feature.home.HomeRecyclerViewItem) r4
            boolean r0 = r4 instanceof com.talabat.darkstores.feature.home.HomeRecyclerViewItem.HeroBannerItem
            if (r0 == 0) goto L_0x0021
            com.talabat.darkstores.feature.home.viewholder.BannerViewHolder r3 = (com.talabat.darkstores.feature.home.viewholder.BannerViewHolder) r3
            com.talabat.darkstores.feature.home.HomeRecyclerViewItem$HeroBannerItem r4 = (com.talabat.darkstores.feature.home.HomeRecyclerViewItem.HeroBannerItem) r4
            com.talabat.darkstores.feature.home.BannerItemViewHolderData r4 = r4.getItem()
            r2.bindBanners(r3, r4)
            goto L_0x00e7
        L_0x0021:
            boolean r0 = r4 instanceof com.talabat.darkstores.feature.home.HomeRecyclerViewItem.SmallBannerItem
            if (r0 == 0) goto L_0x0032
            com.talabat.darkstores.feature.home.viewholder.BannerViewHolder r3 = (com.talabat.darkstores.feature.home.viewholder.BannerViewHolder) r3
            com.talabat.darkstores.feature.home.HomeRecyclerViewItem$SmallBannerItem r4 = (com.talabat.darkstores.feature.home.HomeRecyclerViewItem.SmallBannerItem) r4
            com.talabat.darkstores.feature.home.BannerItemViewHolderData r4 = r4.getItem()
            r2.bindBanners(r3, r4)
            goto L_0x00e7
        L_0x0032:
            boolean r0 = r4 instanceof com.talabat.darkstores.feature.home.HomeRecyclerViewItem.SwimlaneItem
            if (r0 == 0) goto L_0x0043
            com.talabat.darkstores.feature.home.viewholder.SwimlanesProductViewHolder r3 = (com.talabat.darkstores.feature.home.viewholder.SwimlanesProductViewHolder) r3
            com.talabat.darkstores.feature.home.HomeRecyclerViewItem$SwimlaneItem r4 = (com.talabat.darkstores.feature.home.HomeRecyclerViewItem.SwimlaneItem) r4
            com.talabat.darkstores.feature.home.SwimlaneViewHolderData r4 = r4.getItem()
            r3.bind(r4)
            goto L_0x00e7
        L_0x0043:
            boolean r0 = r4 instanceof com.talabat.darkstores.feature.home.HomeRecyclerViewItem.CategoryGridItem
            if (r0 == 0) goto L_0x0054
            com.talabat.darkstores.feature.home.viewholder.CategoryGridViewHolder r3 = (com.talabat.darkstores.feature.home.viewholder.CategoryGridViewHolder) r3
            com.talabat.darkstores.feature.home.HomeRecyclerViewItem$CategoryGridItem r4 = (com.talabat.darkstores.feature.home.HomeRecyclerViewItem.CategoryGridItem) r4
            com.talabat.darkstores.feature.home.CategoryViewHolderData r4 = r4.getItem()
            r3.bind(r4)
            goto L_0x00e7
        L_0x0054:
            boolean r0 = r4 instanceof com.talabat.darkstores.feature.home.HomeRecyclerViewItem.LifeStyleMissionV1Item
            r1 = 0
            if (r0 == 0) goto L_0x006d
            boolean r0 = r3 instanceof com.talabat.darkstores.feature.home.viewholder.LifestyleMissionV1ViewHolder
            if (r0 == 0) goto L_0x0060
            r1 = r3
            com.talabat.darkstores.feature.home.viewholder.LifestyleMissionV1ViewHolder r1 = (com.talabat.darkstores.feature.home.viewholder.LifestyleMissionV1ViewHolder) r1
        L_0x0060:
            if (r1 == 0) goto L_0x00e7
            com.talabat.darkstores.feature.home.HomeRecyclerViewItem$LifeStyleMissionV1Item r4 = (com.talabat.darkstores.feature.home.HomeRecyclerViewItem.LifeStyleMissionV1Item) r4
            com.talabat.darkstores.feature.home.MissionItemData r3 = r4.getItem()
            r1.bind(r3)
            goto L_0x00e7
        L_0x006d:
            boolean r0 = r4 instanceof com.talabat.darkstores.feature.home.HomeRecyclerViewItem.LifestyleMissionV2Item
            if (r0 == 0) goto L_0x0084
            boolean r0 = r3 instanceof com.talabat.darkstores.feature.home.viewholder.LifestyleMissionV2ViewHolder
            if (r0 == 0) goto L_0x0078
            r1 = r3
            com.talabat.darkstores.feature.home.viewholder.LifestyleMissionV2ViewHolder r1 = (com.talabat.darkstores.feature.home.viewholder.LifestyleMissionV2ViewHolder) r1
        L_0x0078:
            if (r1 == 0) goto L_0x00e7
            com.talabat.darkstores.feature.home.HomeRecyclerViewItem$LifestyleMissionV2Item r4 = (com.talabat.darkstores.feature.home.HomeRecyclerViewItem.LifestyleMissionV2Item) r4
            com.talabat.darkstores.feature.home.LifestyleMissionV2Data r3 = r4.getItem()
            r1.bind(r3)
            goto L_0x00e7
        L_0x0084:
            boolean r0 = r4 instanceof com.talabat.darkstores.feature.home.HomeRecyclerViewItem.PrimaryMissionItem
            if (r0 == 0) goto L_0x009b
            boolean r0 = r3 instanceof com.talabat.darkstores.feature.home.viewholder.PrimaryMissionViewHolder
            if (r0 == 0) goto L_0x008f
            r1 = r3
            com.talabat.darkstores.feature.home.viewholder.PrimaryMissionViewHolder r1 = (com.talabat.darkstores.feature.home.viewholder.PrimaryMissionViewHolder) r1
        L_0x008f:
            if (r1 == 0) goto L_0x00e7
            com.talabat.darkstores.feature.home.HomeRecyclerViewItem$PrimaryMissionItem r4 = (com.talabat.darkstores.feature.home.HomeRecyclerViewItem.PrimaryMissionItem) r4
            com.talabat.darkstores.feature.home.MissionItemData r3 = r4.getItem()
            r1.bind(r3)
            goto L_0x00e7
        L_0x009b:
            boolean r0 = r4 instanceof com.talabat.darkstores.feature.home.HomeRecyclerViewItem.RewardsMissionItem
            if (r0 == 0) goto L_0x00b2
            boolean r0 = r3 instanceof com.talabat.darkstores.feature.home.viewholder.RewardsMissionViewHolder
            if (r0 == 0) goto L_0x00a6
            r1 = r3
            com.talabat.darkstores.feature.home.viewholder.RewardsMissionViewHolder r1 = (com.talabat.darkstores.feature.home.viewholder.RewardsMissionViewHolder) r1
        L_0x00a6:
            if (r1 == 0) goto L_0x00e7
            com.talabat.darkstores.feature.home.HomeRecyclerViewItem$RewardsMissionItem r4 = (com.talabat.darkstores.feature.home.HomeRecyclerViewItem.RewardsMissionItem) r4
            com.talabat.darkstores.feature.home.RewardsMissionItemData r3 = r4.getItem()
            r1.bind(r3)
            goto L_0x00e7
        L_0x00b2:
            boolean r0 = r4 instanceof com.talabat.darkstores.feature.home.HomeRecyclerViewItem.SearchViewItem
            if (r0 == 0) goto L_0x00c2
            com.talabat.darkstores.feature.home.viewholder.HomeSearchViewHolder r3 = (com.talabat.darkstores.feature.home.viewholder.HomeSearchViewHolder) r3
            com.talabat.darkstores.feature.home.HomeRecyclerViewItem$SearchViewItem r4 = (com.talabat.darkstores.feature.home.HomeRecyclerViewItem.SearchViewItem) r4
            com.talabat.darkstores.feature.home.SearchViewHolderData r4 = r4.getItem()
            r3.bind(r4)
            goto L_0x00e7
        L_0x00c2:
            boolean r0 = r4 instanceof com.talabat.darkstores.feature.home.HomeRecyclerViewItem.TproSubscriptionItem
            if (r0 == 0) goto L_0x00d2
            com.talabat.darkstores.feature.home.viewholder.TproSubscriptionHeaderViewHolder r3 = (com.talabat.darkstores.feature.home.viewholder.TproSubscriptionHeaderViewHolder) r3
            com.talabat.darkstores.feature.home.HomeRecyclerViewItem$TproSubscriptionItem r4 = (com.talabat.darkstores.feature.home.HomeRecyclerViewItem.TproSubscriptionItem) r4
            com.talabat.darkstores.feature.home.TproSubscriptionInfoData r4 = r4.getItem()
            r3.bind(r4)
            goto L_0x00e7
        L_0x00d2:
            boolean r0 = r4 instanceof com.talabat.darkstores.feature.home.HomeRecyclerViewItem.TproSubscriptionItemV2
            if (r0 == 0) goto L_0x00e2
            com.talabat.darkstores.feature.home.viewholder.TproSubscriptionHeaderViewHolderV2 r3 = (com.talabat.darkstores.feature.home.viewholder.TproSubscriptionHeaderViewHolderV2) r3
            com.talabat.darkstores.feature.home.HomeRecyclerViewItem$TproSubscriptionItemV2 r4 = (com.talabat.darkstores.feature.home.HomeRecyclerViewItem.TproSubscriptionItemV2) r4
            com.talabat.darkstores.feature.home.TproSubscriptionInfoData r4 = r4.getItem()
            r3.bind(r4)
            goto L_0x00e7
        L_0x00e2:
            com.talabat.darkstores.feature.home.HomeRecyclerViewItem$ProgressViewItem r3 = com.talabat.darkstores.feature.home.HomeRecyclerViewItem.ProgressViewItem.INSTANCE
            kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r3)
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.home.HomeFragmentRecyclerViewAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
        if (i11 == R.layout.darkstores_item_home_swimlane) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new SwimlanesProductViewHolder(inflate, this.onProductQuantityChangeTrackingListener, this.cartMapLiveData);
        } else if (i11 == R.layout.darkstores_item_home_banner) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new BannerViewHolder(inflate, this.lifecycleOwner, this.smallBannerImpressionTracker, this.trackingData);
        } else if (i11 == R.layout.darkstores_item_home_hero_banner) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new BannerViewHolder(inflate, this.lifecycleOwner, this.heroBannerImpressionTracker, this.trackingData);
        } else if (i11 == R.layout.darkstores_item_category_grid) {
            Function2<Category, Integer, Unit> function2 = this.onCategoryClicked;
            int i12 = this.categoriesRowsCount;
            Function1<List<Category>, Unit> function1 = this.onViewAllCategoryClicked;
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new CategoryGridViewHolder(inflate, i12, function2, function1);
        } else if (i11 == R.layout.darkstores_item_home_lifestyle_mission_v1) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new LifestyleMissionV1ViewHolder(inflate);
        } else if (i11 == R.layout.darkstores_item_home_lifestyle_mission_v2) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new LifestyleMissionV2ViewHolder(inflate);
        } else if (i11 == R.layout.darkstores_item_home_primary_mission) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new PrimaryMissionViewHolder(inflate);
        } else if (i11 == R.layout.darkstores_item_home_reward_mission) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new RewardsMissionViewHolder(inflate);
        } else if (i11 == R.layout.darkstores_item_home_search_view) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new HomeSearchViewHolder(inflate, this.onSearchClickListener);
        } else if (i11 == R.layout.darkstores_item_home_tpro) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new TproSubscriptionHeaderViewHolder(inflate);
        } else if (i11 == R.layout.darkstores_item_home_progress) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new ProgressBarViewHolder(inflate);
        } else if (i11 == R.layout.darkstores_item_home_tpro_v2) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new TproSubscriptionHeaderViewHolderV2(inflate);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void onViewRecycled(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof BannerViewHolder) {
            HomeRecyclerViewItem homeRecyclerViewItem = (HomeRecyclerViewItem) getItem(((BannerViewHolder) viewHolder).getBindingAdapterPosition());
            if (homeRecyclerViewItem instanceof HomeRecyclerViewItem.HeroBannerItem) {
                this.bannerPositionMap.put(((HomeRecyclerViewItem.HeroBannerItem) homeRecyclerViewItem).getItem().getBannerType(), Integer.valueOf(((LoopingViewPager) viewHolder.itemView.findViewById(R.id.viewpager)).getCurrentItem()));
            } else if (homeRecyclerViewItem instanceof HomeRecyclerViewItem.SmallBannerItem) {
                this.bannerPositionMap.put(((HomeRecyclerViewItem.SmallBannerItem) homeRecyclerViewItem).getItem().getBannerType(), Integer.valueOf(((LoopingViewPager) viewHolder.itemView.findViewById(R.id.viewpager)).getCurrentItem()));
            }
        }
        super.onViewRecycled(viewHolder);
    }
}
