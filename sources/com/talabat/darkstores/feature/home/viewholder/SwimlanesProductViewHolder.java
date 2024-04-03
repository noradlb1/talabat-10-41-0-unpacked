package com.talabat.darkstores.feature.home.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.OnProductQuantityChangeTrackingListener;
import com.talabat.darkstores.common.lists.adapters.CartMapProductListAdapter;
import com.talabat.darkstores.feature.home.SwimlaneViewHolderData;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.darkstores.model.Swimlane;
import com.talabat.darkstores.model.SwimlaneTracking;
import com.talabat.feature.darkstorescart.data.model.Product;
import gj.b;
import gj.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0017J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/talabat/darkstores/feature/home/viewholder/SwimlanesProductViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "listener", "Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;", "cartMapLiveData", "Landroidx/lifecycle/LiveData;", "", "", "", "(Landroid/view/View;Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;Landroidx/lifecycle/LiveData;)V", "adapter", "Lcom/talabat/darkstores/common/lists/adapters/CartMapProductListAdapter;", "getAdapter", "()Lcom/talabat/darkstores/common/lists/adapters/CartMapProductListAdapter;", "setAdapter", "(Lcom/talabat/darkstores/common/lists/adapters/CartMapProductListAdapter;)V", "cartCountObserver", "Landroidx/lifecycle/Observer;", "getCartMapLiveData", "()Landroidx/lifecycle/LiveData;", "bind", "", "swimlaneItemData", "Lcom/talabat/darkstores/feature/home/SwimlaneViewHolderData;", "clear", "createDividerDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesProductViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private CartMapProductListAdapter adapter;
    @Nullable
    private Observer<Map<String, Integer>> cartCountObserver;
    @NotNull
    private final LiveData<Map<String, Integer>> cartMapLiveData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwimlanesProductViewHolder(@NotNull View view, @NotNull OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, @NotNull LiveData<Map<String, Integer>> liveData) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(onProductQuantityChangeTrackingListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(liveData, "cartMapLiveData");
        this.cartMapLiveData = liveData;
        this.adapter = new CartMapProductListAdapter(onProductQuantityChangeTrackingListener, false, 2, (DefaultConstructorMarker) null);
        int i11 = R.id.recyclerView;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        ((RecyclerView) view.findViewById(i11)).addItemDecoration(createDividerDecoration(context));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        linearLayoutManager.setInitialPrefetchItemCount(4);
        ((RecyclerView) view.findViewById(i11)).setLayoutManager(linearLayoutManager);
        ((RecyclerView) view.findViewById(i11)).setAdapter(this.adapter);
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-3$lambda-1  reason: not valid java name */
    public static final void m9978bind$lambda3$lambda1(Function1 function1, Swimlane swimlane, View view) {
        Intrinsics.checkNotNullParameter(function1, "$onViewAllClickListener");
        Intrinsics.checkNotNullParameter(swimlane, "$swimlane");
        function1.invoke(swimlane);
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-3$lambda-2  reason: not valid java name */
    public static final void m9979bind$lambda3$lambda2(SwimlanesProductViewHolder swimlanesProductViewHolder, Map map) {
        Intrinsics.checkNotNullParameter(swimlanesProductViewHolder, "this$0");
        CartMapProductListAdapter cartMapProductListAdapter = swimlanesProductViewHolder.adapter;
        Intrinsics.checkNotNullExpressionValue(map, "cartContent");
        cartMapProductListAdapter.setCartCountMap(map);
    }

    private final RecyclerView.ItemDecoration createDividerDecoration(Context context) {
        SwimlanesProductViewHolder$createDividerDecoration$itemDecoration$1 swimlanesProductViewHolder$createDividerDecoration$itemDecoration$1 = new SwimlanesProductViewHolder$createDividerDecoration$itemDecoration$1(context);
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.divider_swimlanes_items);
        if (drawable != null) {
            swimlanesProductViewHolder$createDividerDecoration$itemDecoration$1.setDrawable(drawable);
        }
        return swimlanesProductViewHolder$createDividerDecoration$itemDecoration$1;
    }

    public final void bind(@NotNull SwimlaneViewHolderData swimlaneViewHolderData) {
        String str;
        Intrinsics.checkNotNullParameter(swimlaneViewHolderData, "swimlaneItemData");
        View view = this.itemView;
        Swimlane swimlane = swimlaneViewHolderData.getSwimlane();
        Function3<Product, String, ProductClickTrackingAttribute, Unit> onProductClickListener = swimlaneViewHolderData.getOnProductClickListener();
        Function1<Swimlane, Unit> onViewAllClickListener = swimlaneViewHolderData.getOnViewAllClickListener();
        ((TextView) view.findViewById(R.id.tvTitle)).setText(swimlane.getHeadline());
        this.adapter.setTrackingCategoryId(new TrackingCategoryId.CustomSwimlane(swimlane.getHeadline()));
        SwimlaneTracking tracking2 = swimlane.getTracking();
        if (tracking2 != null) {
            str = tracking2.getTrackingId();
        } else {
            str = null;
        }
        this.adapter.setOnItemClickListener(new SwimlanesProductViewHolder$bind$1$1(onProductClickListener, swimlane, new ProductClickTrackingAttribute("storefront:swimlane", str, swimlane.getHeadline(), swimlane.getProducts().size())));
        this.adapter.submitList(swimlane.getProducts());
        ((AppCompatImageButton) view.findViewById(R.id.btnViewAll)).setOnClickListener(new b(onViewAllClickListener, swimlane));
        c cVar = new c(this);
        this.cartMapLiveData.observeForever(cVar);
        this.cartCountObserver = cVar;
    }

    public final void clear() {
        Observer<Map<String, Integer>> observer = this.cartCountObserver;
        if (observer != null) {
            this.cartMapLiveData.removeObserver(observer);
        }
        this.cartCountObserver = null;
    }

    @NotNull
    public final CartMapProductListAdapter getAdapter() {
        return this.adapter;
    }

    @NotNull
    public final LiveData<Map<String, Integer>> getCartMapLiveData() {
        return this.cartMapLiveData;
    }

    public final void setAdapter(@NotNull CartMapProductListAdapter cartMapProductListAdapter) {
        Intrinsics.checkNotNullParameter(cartMapProductListAdapter, "<set-?>");
        this.adapter = cartMapProductListAdapter;
    }
}
