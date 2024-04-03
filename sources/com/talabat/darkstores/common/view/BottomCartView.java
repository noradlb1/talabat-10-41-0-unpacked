package com.talabat.darkstores.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.transition.Slide;
import androidx.transition.TransitionManager;
import ci.a;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.extensions.FloatExtensionsKt;
import com.talabat.darkstores.feature.cart.CartSummary;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001c\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/talabat/darkstores/common/view/BottomCartView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onSeeCartClickListener", "Lkotlin/Function0;", "", "getOnSeeCartClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnSeeCartClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setCart", "cartCount", "summary", "Lcom/talabat/darkstores/feature/cart/CartSummary;", "setData", "products", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "setLoading", "isLoading", "", "setVisibility", "cartNotEmpty", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BottomCartView extends ConstraintLayout {
    private static final long ANIMATION_DURATION = 150;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @Nullable
    private Function0<Unit> onSeeCartClickListener;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/common/view/BottomCartView$Companion;", "", "()V", "ANIMATION_DURATION", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BottomCartView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BottomCartView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BottomCartView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View.inflate(context, R.layout.darkstores_bottom_cart_view, this);
        setVisibility(8);
        setBackgroundResource(R.drawable.bg_cart_has_items);
        setOnClickListener(new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m9639_init_$lambda0(BottomCartView bottomCartView, View view) {
        Intrinsics.checkNotNullParameter(bottomCartView, "this$0");
        Function0<Unit> function0 = bottomCartView.onSeeCartClickListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void setCart(int i11, CartSummary cartSummary) {
        ((TextView) _$_findCachedViewById(R.id.bottom_cart_view_count)).setText(NumberFormat.getInstance().format(Integer.valueOf(i11)));
        float cartSummaryPrice = cartSummary.getCartSummaryPrice();
        ((TextView) _$_findCachedViewById(R.id.bottom_cart_view_total)).setText(getContext().getString(com.talabat.localization.R.string.btm_cart_view_total, new Object[]{FloatExtensionsKt.formatCurrency(cartSummaryPrice)}));
    }

    private final void setVisibility(boolean z11) {
        int i11;
        Slide slide = new Slide(80);
        slide.setDuration(150);
        TransitionManager.beginDelayedTransition(this, slide);
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        setVisibility(i11);
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

    @Nullable
    public final Function0<Unit> getOnSeeCartClickListener() {
        return this.onSeeCartClickListener;
    }

    public final void setData(@NotNull List<Product> list, @NotNull CartSummary cartSummary) {
        Intrinsics.checkNotNullParameter(list, "products");
        Intrinsics.checkNotNullParameter(cartSummary, "summary");
        boolean z11 = !list.isEmpty();
        setVisibility(z11);
        if (z11) {
            int i11 = 0;
            for (Product totalCountWithFreeItems : list) {
                i11 += totalCountWithFreeItems.getTotalCountWithFreeItems();
            }
            setCart(i11, cartSummary);
        }
    }

    public final void setLoading(boolean z11) {
        int i11;
        TextView textView = (TextView) _$_findCachedViewById(R.id.bottom_cart_view_total);
        Intrinsics.checkNotNullExpressionValue(textView, "bottom_cart_view_total");
        int i12 = 0;
        if (!z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        textView.setVisibility(i11);
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.id.bottom_cart_view_progress);
        Intrinsics.checkNotNullExpressionValue(progressBar, "bottom_cart_view_progress");
        if (!z11) {
            i12 = 8;
        }
        progressBar.setVisibility(i12);
    }

    public final void setOnSeeCartClickListener(@Nullable Function0<Unit> function0) {
        this.onSeeCartClickListener = function0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BottomCartView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
