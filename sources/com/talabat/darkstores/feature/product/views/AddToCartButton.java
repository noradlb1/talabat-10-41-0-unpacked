package com.talabat.darkstores.feature.product.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.extensions.ContextExtensionsKt;
import com.talabat.darkstores.feature.product.views.CartButtonEvent;
import com.talabat.darkstores.feature.product.views.CartButtonState;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.lifecycle.AutoDisposable;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u001a\u001a\u00020\bH\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020,H\u0016J\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\"0!00J\u0016\u00101\u001a\u00020,2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u00102\u001a\u00020\bR#\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00130\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\n \f*\u0004\u0018\u00010\u00190\u0019X\u0004¢\u0006\u0002\n\u0000R#\u0010\u001a\u001a\n \f*\u0004\u0018\u00010\u001b0\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\"0!0 X\u0004¢\u0006\u0002\n\u0000R#\u0010#\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b$\u0010\u000eR#\u0010&\u001a\n \f*\u0004\u0018\u00010\u001b0\u001b8BX\u0002¢\u0006\f\n\u0004\b(\u0010\u0010\u001a\u0004\b'\u0010\u001d¨\u00064"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/AddToCartButton;", "Landroidx/cardview/widget/CardView;", "Lcom/talabat/talabatcommon/lifecycle/AutoDisposable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "add", "Landroidx/appcompat/widget/AppCompatImageView;", "kotlin.jvm.PlatformType", "getAdd", "()Landroidx/appcompat/widget/AppCompatImageView;", "add$delegate", "Lkotlin/Lazy;", "configurationSubject", "Lio/reactivex/subjects/PublishSubject;", "Lcom/talabat/darkstores/feature/product/views/CartButtonEvent;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "numberFormatter", "Ljava/text/NumberFormat;", "quantity", "Landroid/widget/TextView;", "getQuantity", "()Landroid/widget/TextView;", "quantity$delegate", "quantityLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "", "remove", "getRemove", "remove$delegate", "stockError", "getStockError", "stockError$delegate", "formatQuantity", "", "handleViewState", "", "state", "Lcom/talabat/darkstores/feature/product/views/CartButtonState;", "onClearedImplementation", "Landroidx/lifecycle/LiveData;", "setupQuantityAndStock", "stock", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddToCartButton extends CardView implements AutoDisposable {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float DISABLED_ALPHA = 0.5f;
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final Lazy add$delegate;
    /* access modifiers changed from: private */
    @NotNull
    public final PublishSubject<CartButtonEvent> configurationSubject;
    @NotNull
    private final CompositeDisposable disposables;
    private final NumberFormat numberFormatter;
    @NotNull
    private final Lazy quantity$delegate;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Pair<Integer, Boolean>> quantityLiveData;
    @NotNull
    private final Lazy remove$delegate;
    @NotNull
    private final Lazy stockError$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/AddToCartButton$Companion;", "", "()V", "DISABLED_ALPHA", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AddToCartButton(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AddToCartButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AddToCartButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.remove$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new AddToCartButton$remove$2(this));
        this.quantity$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new AddToCartButton$quantity$2(this));
        this.add$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new AddToCartButton$add$2(this));
        this.stockError$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new AddToCartButton$stockError$2(this));
        this.numberFormatter = NumberFormat.getInstance();
        PublishSubject<CartButtonEvent> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<CartButtonEvent>()");
        this.configurationSubject = create;
        this.quantityLiveData = new MutableLiveData<>();
        this.disposables = new CompositeDisposable();
        ViewKt.withLayout(this, R.layout.darkstores_button_add_to_cart, new AddToCartButton$special$$inlined$bind$1(this, this));
    }

    private final String formatQuantity(int i11) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(this.numberFormatter.format(Integer.valueOf(i11)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6335isFailureimpl(obj)) {
            obj = null;
        }
        return (String) obj;
    }

    /* access modifiers changed from: private */
    public final AppCompatImageView getAdd() {
        return (AppCompatImageView) this.add$delegate.getValue();
    }

    private final TextView getQuantity() {
        return (TextView) this.quantity$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final AppCompatImageView getRemove() {
        return (AppCompatImageView) this.remove$delegate.getValue();
    }

    private final TextView getStockError() {
        return (TextView) this.stockError$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void handleViewState(CartButtonState cartButtonState) {
        int i11;
        float f11;
        int i12;
        int i13;
        float f12;
        String str;
        Context context = getContext();
        boolean z11 = cartButtonState instanceof CartButtonState.Empty;
        if (z11) {
            i11 = com.designsystem.marshmallow.R.color.ds_primary_100;
        } else {
            i11 = com.talabat.talabatcommon.R.color.white;
        }
        setCardBackgroundColor(ContextCompat.getColor(context, i11));
        if (z11) {
            f11 = 0.0f;
        } else {
            f11 = getResources().getDimension(com.talabat.marshmallow.R.dimen.margin_smaller);
        }
        setCardElevation(f11);
        setEnabled(z11);
        AppCompatImageView remove = getRemove();
        Intrinsics.checkNotNullExpressionValue(remove, ProductAction.ACTION_REMOVE);
        int i14 = 4;
        if (z11) {
            i12 = 4;
        } else {
            i12 = 0;
        }
        remove.setVisibility(i12);
        getRemove().setSelected(!(cartButtonState instanceof CartButtonState.NotEmpty.One));
        AppCompatImageView add = getAdd();
        Intrinsics.checkNotNullExpressionValue(add, ProductAction.ACTION_ADD);
        if (z11) {
            i13 = 4;
        } else {
            i13 = 0;
        }
        add.setVisibility(i13);
        boolean z12 = cartButtonState instanceof CartButtonState.NotEmpty.Full;
        getAdd().setEnabled(!z12);
        AppCompatImageView add2 = getAdd();
        if (z12) {
            f12 = 0.5f;
        } else {
            f12 = 1.0f;
        }
        add2.setAlpha(f12);
        getQuantity().setEnabled(!z11);
        TextView quantity = getQuantity();
        if (Intrinsics.areEqual((Object) cartButtonState, (Object) CartButtonState.Empty.INSTANCE)) {
            str = getResources().getString(com.talabat.localization.R.string.add_to_cart);
        } else if (cartButtonState instanceof CartButtonState.NotEmpty) {
            str = formatQuantity(((CartButtonState.NotEmpty) cartButtonState).getQuantity());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        quantity.setText(str);
        TextView stockError = getStockError();
        Intrinsics.checkNotNullExpressionValue(stockError, "stockError");
        if (!(!z12)) {
            i14 = 0;
        }
        stockError.setVisibility(i14);
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

    @AutoDisposableDsl
    public void autoDispose(@NotNull Function0<? extends Disposable> function0) {
        AutoDisposable.DefaultImpls.autoDispose(this, function0);
    }

    @NotNull
    public CompositeDisposable getDisposables() {
        return this.disposables;
    }

    public void onCleared() {
        AutoDisposable.DefaultImpls.onCleared(this);
    }

    public void onClearedImplementation() {
        setOnClickListener((View.OnClickListener) null);
        getRemove().setOnClickListener((View.OnClickListener) null);
        getAdd().setOnClickListener((View.OnClickListener) null);
    }

    @NotNull
    public final LiveData<Pair<Integer, Boolean>> quantityLiveData() {
        return this.quantityLiveData;
    }

    public final void setupQuantityAndStock(int i11, int i12) {
        boolean z11;
        if (i12 != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        setEnabled(z11);
        if (i12 == 0) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            setCardBackgroundColor(ContextExtensionsKt.getColorCompat(context, com.talabat.talabatcommon.R.color.primary_30));
            return;
        }
        getStockError().setText(getContext().getString(com.talabat.localization.R.string.cart_product_stock_limit_error, new Object[]{String.valueOf(i12)}));
        this.configurationSubject.onNext(new CartButtonEvent.Setup(i11, i12));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddToCartButton(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
