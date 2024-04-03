package com.talabat.darkstores.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import ci.m;
import ci.n;
import ci.o;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.darkstores.R;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001cB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0010J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0007H\u0002R$\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemsCounter;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "count", "getCount", "()I", "setCount", "(I)V", "quantityChangeListener", "Lcom/talabat/darkstores/common/view/ItemsCounter$QuantityChangeListener;", "stock", "getStock", "setStock", "compareToStock", "", "onFinishInflate", "setCounterDisplay", "setQuantityChangeListener", "listener", "setStockCount", "stockCount", "QuantityChangeListener", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ItemsCounter extends FrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    private int count;
    @Nullable
    private QuantityChangeListener quantityChangeListener;
    private int stock;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemsCounter$QuantityChangeListener;", "", "onItemAdded", "", "onItemRemoved", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface QuantityChangeListener {
        void onItemAdded();

        void onItemRemoved();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ItemsCounter(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ItemsCounter(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ItemsCounter(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.stock = 10;
        View.inflate(context, R.layout.darkstores_items_counter, this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.designsystem.marshmallow.R.dimen.ds_xxs);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }

    private final void compareToStock() {
        int i11 = this.count;
        int i12 = this.stock;
        if (i11 == i12 && i12 != 0) {
            int i13 = R.id.limit_error;
            ((TextView) _$_findCachedViewById(i13)).setVisibility(0);
            ((TextView) _$_findCachedViewById(i13)).setText(String.format(getContext().getString(com.talabat.localization.R.string.cart_product_stock_limit_error), new Object[]{String.valueOf(this.stock)}));
            ((AppCompatImageButton) _$_findCachedViewById(R.id.btnAdd)).setEnabled(false);
        } else if (i12 == 0) {
            int i14 = R.id.limit_error;
            ((TextView) _$_findCachedViewById(i14)).setVisibility(0);
            ((TextView) _$_findCachedViewById(i14)).setText(getContext().getString(com.talabat.localization.R.string.cart_product_stock_not_available));
            TextView textView = (TextView) _$_findCachedViewById(R.id.btnAddToCart);
            Intrinsics.checkNotNullExpressionValue(textView, "btnAddToCart");
            textView.setVisibility(4);
            ((AppCompatImageButton) _$_findCachedViewById(R.id.btnAdd)).setEnabled(false);
        } else {
            ((TextView) _$_findCachedViewById(R.id.limit_error)).setVisibility(4);
            ((AppCompatImageButton) _$_findCachedViewById(R.id.btnAdd)).setEnabled(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onFinishInflate$lambda-0  reason: not valid java name */
    public static final void m9653onFinishInflate$lambda0(ItemsCounter itemsCounter, View view) {
        Intrinsics.checkNotNullParameter(itemsCounter, "this$0");
        QuantityChangeListener quantityChangeListener2 = itemsCounter.quantityChangeListener;
        if (quantityChangeListener2 != null) {
            quantityChangeListener2.onItemAdded();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onFinishInflate$lambda-1  reason: not valid java name */
    public static final void m9654onFinishInflate$lambda1(ItemsCounter itemsCounter, View view) {
        Intrinsics.checkNotNullParameter(itemsCounter, "this$0");
        QuantityChangeListener quantityChangeListener2 = itemsCounter.quantityChangeListener;
        if (quantityChangeListener2 != null) {
            quantityChangeListener2.onItemRemoved();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onFinishInflate$lambda-2  reason: not valid java name */
    public static final void m9655onFinishInflate$lambda2(ItemsCounter itemsCounter, View view) {
        Intrinsics.checkNotNullParameter(itemsCounter, "this$0");
        QuantityChangeListener quantityChangeListener2 = itemsCounter.quantityChangeListener;
        if (quantityChangeListener2 != null) {
            quantityChangeListener2.onItemAdded();
        }
    }

    private final void setCounterDisplay(int i11) {
        boolean z11;
        int i12;
        int i13 = 0;
        if (i11 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.counterLinearLayout);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "counterLinearLayout");
        if (z11) {
            i12 = 4;
        } else {
            i12 = 0;
        }
        linearLayout.setVisibility(i12);
        TextView textView = (TextView) _$_findCachedViewById(R.id.btnAddToCart);
        Intrinsics.checkNotNullExpressionValue(textView, "btnAddToCart");
        if (true ^ z11) {
            i13 = 4;
        }
        textView.setVisibility(i13);
        compareToStock();
        ((TextView) _$_findCachedViewById(R.id.tvCounter)).setText(NumberFormat.getInstance().format(Integer.valueOf(i11)));
    }

    private final void setStockCount(int i11) {
        setStock(i11);
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

    public final int getCount() {
        return this.count;
    }

    public final int getStock() {
        return this.stock;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        ((AppCompatImageButton) _$_findCachedViewById(R.id.btnAdd)).setOnClickListener(new m(this));
        ((AppCompatImageButton) _$_findCachedViewById(R.id.btnRemove)).setOnClickListener(new n(this));
        ((TextView) _$_findCachedViewById(R.id.btnAddToCart)).setOnClickListener(new o(this));
    }

    public final void setCount(int i11) {
        if (i11 >= 0) {
            setCounterDisplay(i11);
            this.count = i11;
            return;
        }
        throw new IllegalArgumentException("items count must not be negative");
    }

    public final void setQuantityChangeListener(@NotNull QuantityChangeListener quantityChangeListener2) {
        Intrinsics.checkNotNullParameter(quantityChangeListener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.quantityChangeListener = quantityChangeListener2;
    }

    public final void setStock(int i11) {
        this.stock = i11;
        setCounterDisplay(this.count);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemsCounter(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.itemsCounterStyle : i11);
    }
}
