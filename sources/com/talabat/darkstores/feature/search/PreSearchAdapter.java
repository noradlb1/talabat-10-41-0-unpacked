package com.talabat.darkstores.feature.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.OnProductQuantityChangeTrackingListener;
import com.talabat.darkstores.common.lists.adapters.CartMapProductListAdapter;
import com.talabat.darkstores.common.view.SwimlaneView;
import com.talabat.darkstores.feature.model.PreSearchItem;
import com.talabat.darkstores.feature.search.listener.PreSearchSwimlaneListener;
import com.talabat.darkstores.feature.search.listener.RecentSearchesListener;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.talabatcommon.extension.ViewKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mj.a;
import mj.b;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001d\u001e\u001fB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0016R<\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/talabat/darkstores/feature/search/PreSearchAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/talabat/darkstores/feature/model/PreSearchItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "recentSearchesListener", "Lcom/talabat/darkstores/feature/search/listener/RecentSearchesListener;", "preSearchSwimlaneListener", "Lcom/talabat/darkstores/feature/search/listener/PreSearchSwimlaneListener;", "onProductQuantityChangeTrackingListener", "Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;", "(Lcom/talabat/darkstores/feature/search/listener/RecentSearchesListener;Lcom/talabat/darkstores/feature/search/listener/PreSearchSwimlaneListener;Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;)V", "value", "", "", "", "cartCountMap", "getCartCountMap", "()Ljava/util/Map;", "setCartCountMap", "(Ljava/util/Map;)V", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "RecentSearchViewHolder", "RecentSearchesHeaderViewHolder", "SwimlaneViewHolder", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PreSearchAdapter extends ListAdapter<PreSearchItem, RecyclerView.ViewHolder> {
    @NotNull
    private Map<String, Integer> cartCountMap = MapsKt__MapsKt.emptyMap();
    /* access modifiers changed from: private */
    @NotNull
    public final OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener;
    /* access modifiers changed from: private */
    @NotNull
    public final PreSearchSwimlaneListener preSearchSwimlaneListener;
    /* access modifiers changed from: private */
    @NotNull
    public final RecentSearchesListener recentSearchesListener;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/search/PreSearchAdapter$RecentSearchViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/talabat/darkstores/feature/search/PreSearchAdapter;Landroid/view/View;)V", "bind", "", "item", "Lcom/talabat/darkstores/feature/model/PreSearchItem$RecentSearch;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class RecentSearchViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PreSearchAdapter f56569h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RecentSearchViewHolder(@NotNull PreSearchAdapter preSearchAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.f56569h = preSearchAdapter;
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-0  reason: not valid java name */
        public static final void m10058bind$lambda0(PreSearchAdapter preSearchAdapter, PreSearchItem.RecentSearch recentSearch, View view) {
            Intrinsics.checkNotNullParameter(preSearchAdapter, "this$0");
            Intrinsics.checkNotNullParameter(recentSearch, "$item");
            preSearchAdapter.recentSearchesListener.onRecentSearchClicked(recentSearch.getQuery());
        }

        public final void bind(@NotNull PreSearchItem.RecentSearch recentSearch) {
            Intrinsics.checkNotNullParameter(recentSearch, "item");
            ((TextView) this.itemView.findViewById(R.id.tvQuery)).setText(recentSearch.getQuery());
            this.itemView.setOnClickListener(new a(this.f56569h, recentSearch));
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/feature/search/PreSearchAdapter$RecentSearchesHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/talabat/darkstores/feature/search/PreSearchAdapter;Landroid/view/View;)V", "bind", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class RecentSearchesHeaderViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PreSearchAdapter f56570h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RecentSearchesHeaderViewHolder(@NotNull PreSearchAdapter preSearchAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.f56570h = preSearchAdapter;
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-0  reason: not valid java name */
        public static final void m10059bind$lambda0(View view) {
        }

        public final void bind() {
            ((TextView) this.itemView.findViewById(R.id.tvClearAll)).setOnClickListener(new b());
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/talabat/darkstores/feature/search/PreSearchAdapter$SwimlaneViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "containerView", "Landroid/view/View;", "(Lcom/talabat/darkstores/feature/search/PreSearchAdapter;Landroid/view/View;)V", "adapter", "Lcom/talabat/darkstores/common/lists/adapters/CartMapProductListAdapter;", "getContainerView", "()Landroid/view/View;", "bind", "", "item", "Lcom/talabat/darkstores/feature/model/PreSearchItem$Swimlane;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class SwimlaneViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final CartMapProductListAdapter adapter;
        @NotNull
        private final View containerView;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PreSearchAdapter f56571h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SwimlaneViewHolder(@NotNull PreSearchAdapter preSearchAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "containerView");
            this.f56571h = preSearchAdapter;
            this.containerView = view;
            CartMapProductListAdapter cartMapProductListAdapter = new CartMapProductListAdapter(preSearchAdapter.onProductQuantityChangeTrackingListener, false, 2, (DefaultConstructorMarker) null);
            cartMapProductListAdapter.setOnItemClickListener(new PreSearchAdapter$SwimlaneViewHolder$adapter$1$1(preSearchAdapter.preSearchSwimlaneListener));
            View view2 = this.itemView;
            int i11 = R.id.swimlane;
            ((RecyclerView) ((SwimlaneView) view2.findViewById(i11))._$_findCachedViewById(R.id.recyclerView)).setAdapter(cartMapProductListAdapter);
            this.adapter = cartMapProductListAdapter;
            ((AppCompatImageButton) this.itemView.findViewById(R.id.btnViewAll)).setVisibility(8);
            TextView textView = (TextView) ((SwimlaneView) this.itemView.findViewById(i11))._$_findCachedViewById(R.id.tvTitle);
            textView.setTextAppearance(com.designsystem.marshmallow.R.style.DSTextAppearance_Heading2);
            Intrinsics.checkNotNullExpressionValue(textView, "titleView");
            ViewKt.setMargin$default(textView, (Float) null, Float.valueOf(this.itemView.getResources().getDimension(com.designsystem.marshmallow.R.dimen.ds_xl)), (Float) null, (Float) null, 13, (Object) null);
            String string = this.itemView.getResources().getString(com.talabat.localization.R.string.order_again);
            Intrinsics.checkNotNullExpressionValue(string, "itemView.resources.getSt…ion.R.string.order_again)");
            ((SwimlaneView) this.itemView.findViewById(i11)).setTitle(string);
            cartMapProductListAdapter.setTrackingCategoryId(new TrackingCategoryId.CustomSwimlane(string));
        }

        public final void bind(@NotNull PreSearchItem.Swimlane swimlane) {
            Intrinsics.checkNotNullParameter(swimlane, "item");
            this.adapter.submitList(swimlane.getProducts());
            this.adapter.setCartCountMap(this.f56571h.getCartCountMap());
        }

        @NotNull
        public final View getContainerView() {
            return this.containerView;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreSearchAdapter(@NotNull RecentSearchesListener recentSearchesListener2, @NotNull PreSearchSwimlaneListener preSearchSwimlaneListener2, @NotNull OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener2) {
        super(new PreSearchItemsDiffCallback());
        Intrinsics.checkNotNullParameter(recentSearchesListener2, "recentSearchesListener");
        Intrinsics.checkNotNullParameter(preSearchSwimlaneListener2, "preSearchSwimlaneListener");
        Intrinsics.checkNotNullParameter(onProductQuantityChangeTrackingListener2, "onProductQuantityChangeTrackingListener");
        this.recentSearchesListener = recentSearchesListener2;
        this.preSearchSwimlaneListener = preSearchSwimlaneListener2;
        this.onProductQuantityChangeTrackingListener = onProductQuantityChangeTrackingListener2;
    }

    @NotNull
    public final Map<String, Integer> getCartCountMap() {
        return this.cartCountMap;
    }

    public int getItemViewType(int i11) {
        PreSearchItem preSearchItem = (PreSearchItem) getItem(i11);
        if (preSearchItem instanceof PreSearchItem.RecentSearch) {
            return R.layout.recent_search_item;
        }
        if (preSearchItem instanceof PreSearchItem.RecentSearchesHeader) {
            return R.layout.recent_search_header;
        }
        if (preSearchItem instanceof PreSearchItem.Swimlane) {
            return R.layout.darkstores_item_subcategory_swimlane;
        }
        throw new NoWhenBranchMatchedException();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        SwimlaneViewHolder swimlaneViewHolder;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        PreSearchItem preSearchItem = (PreSearchItem) getItem(i11);
        if (preSearchItem instanceof PreSearchItem.RecentSearch) {
            ((RecentSearchViewHolder) viewHolder).bind((PreSearchItem.RecentSearch) preSearchItem);
        } else if (preSearchItem instanceof PreSearchItem.RecentSearchesHeader) {
            ((RecentSearchesHeaderViewHolder) viewHolder).bind();
        } else if (preSearchItem instanceof PreSearchItem.Swimlane) {
            if (viewHolder instanceof SwimlaneViewHolder) {
                swimlaneViewHolder = (SwimlaneViewHolder) viewHolder;
            } else {
                swimlaneViewHolder = null;
            }
            if (swimlaneViewHolder != null) {
                swimlaneViewHolder.bind((PreSearchItem.Swimlane) preSearchItem);
            }
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
        if (i11 == R.layout.recent_search_item) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new RecentSearchViewHolder(this, inflate);
        } else if (i11 == R.layout.recent_search_header) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new RecentSearchesHeaderViewHolder(this, inflate);
        } else if (i11 == R.layout.darkstores_item_subcategory_swimlane) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new SwimlaneViewHolder(this, inflate);
        } else {
            throw new IllegalArgumentException("Unsupported view type: " + i11);
        }
    }

    public final void setCartCountMap(@NotNull Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "value");
        this.cartCountMap = map;
        notifyDataSetChanged();
    }
}
