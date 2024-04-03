package com.talabat.darkstores.feature.cart.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.lists.adapters.compact.CompactSwimlaneAdapter;
import com.talabat.darkstores.common.view.OnSwipeOnceTrackingListener;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ)\u0010\u0017\u001a\u00020\u00182!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00180\u001aJ\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u001fJ\u001c\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$J\b\u0010&\u001a\u00020\u0018H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R#\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\u00130\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015¨\u0006'"}, d2 = {"Lcom/talabat/darkstores/feature/cart/views/CompactSwimlaneView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onSwipeOnceTrackingListener", "Lcom/talabat/darkstores/common/view/OnSwipeOnceTrackingListener;", "productList", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "getProductList", "()Landroidx/recyclerview/widget/RecyclerView;", "productList$delegate", "Lkotlin/Lazy;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title$delegate", "setOnSwipeOnceListener", "", "onSwiped", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "lastVisiblePosition", "setTitle", "", "setupAdapterAndProducts", "adapter", "Lcom/talabat/darkstores/common/lists/adapters/compact/CompactSwimlaneAdapter;", "products", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "setupRecyclerView", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CompactSwimlaneView extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @Nullable
    private OnSwipeOnceTrackingListener onSwipeOnceTrackingListener;
    @NotNull
    private final Lazy productList$delegate;
    @NotNull
    private final Lazy title$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CompactSwimlaneView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CompactSwimlaneView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CompactSwimlaneView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.productList$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CompactSwimlaneView$productList$2(this));
        this.title$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CompactSwimlaneView$title$2(this));
        View.inflate(context, R.layout.compact_swimlane_view, this);
        setOrientation(1);
        setupRecyclerView();
    }

    private final RecyclerView getProductList() {
        return (RecyclerView) this.productList$delegate.getValue();
    }

    private final TextView getTitle() {
        return (TextView) this.title$delegate.getValue();
    }

    private final void setupRecyclerView() {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 0);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.divider_swimlanes_items);
        if (drawable != null) {
            dividerItemDecoration.setDrawable(drawable);
        }
        RecyclerView productList = getProductList();
        productList.setHasFixedSize(true);
        productList.addItemDecoration(dividerItemDecoration);
        productList.setLayoutManager(new LinearLayoutManager(productList.getContext(), 0, false));
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public final void setOnSwipeOnceListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onSwiped");
        RecyclerView productList = getProductList();
        OnSwipeOnceTrackingListener onSwipeOnceTrackingListener2 = this.onSwipeOnceTrackingListener;
        if (onSwipeOnceTrackingListener2 != null) {
            Intrinsics.checkNotNullExpressionValue(productList, "");
            productList.removeOnScrollListener(onSwipeOnceTrackingListener2);
        }
        OnSwipeOnceTrackingListener onSwipeOnceTrackingListener3 = new OnSwipeOnceTrackingListener(function1);
        Intrinsics.checkNotNullExpressionValue(productList, "");
        productList.addOnScrollListener(onSwipeOnceTrackingListener3);
        this.onSwipeOnceTrackingListener = onSwipeOnceTrackingListener3;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        getTitle().setText(str);
    }

    public final void setupAdapterAndProducts(@NotNull CompactSwimlaneAdapter compactSwimlaneAdapter, @NotNull List<Product> list) {
        Intrinsics.checkNotNullParameter(compactSwimlaneAdapter, "adapter");
        Intrinsics.checkNotNullParameter(list, "products");
        getProductList().setAdapter(compactSwimlaneAdapter);
        compactSwimlaneAdapter.submitList(list);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CompactSwimlaneView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
