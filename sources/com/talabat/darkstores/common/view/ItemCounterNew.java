package com.talabat.darkstores.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import ci.f;
import ci.g;
import ci.h;
import ci.i;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.extensions.ContextExtensionsKt;
import com.talabat.darkstores.common.view.ItemCounterState;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 /2\u00020\u0001:\u0001/B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\u000e\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0013J*\u0010+\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020\u00132\b\b\u0002\u0010.\u001a\u00020\u0007R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u00190\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R#\u0010\u001b\u001a\n \u000b*\u0004\u0018\u00010\u001c0\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b\u001d\u0010\u001eR#\u0010 \u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b!\u0010\rR\u000e\u0010#\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemCounterNew;", "Landroidx/cardview/widget/CardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "add", "Landroidx/appcompat/widget/AppCompatImageView;", "kotlin.jvm.PlatformType", "getAdd", "()Landroidx/appcompat/widget/AppCompatImageView;", "add$delegate", "Lkotlin/Lazy;", "controller", "Lcom/talabat/darkstores/common/view/ItemCounterNewController;", "isProductTile", "", "productQuantityState", "Lio/reactivex/Observable;", "getProductQuantityState", "()Lio/reactivex/Observable;", "productStateForTrackingEvents", "Lkotlin/Pair;", "getProductStateForTrackingEvents", "quantity", "Landroid/widget/TextView;", "getQuantity", "()Landroid/widget/TextView;", "quantity$delegate", "remove", "getRemove", "remove$delegate", "shouldCollapse", "handleViewState", "", "state", "Lcom/talabat/darkstores/common/view/ItemCounterState;", "setLayoutParams", "setOverlayVisibility", "isVisible", "setup", "stock", "productTile", "freeCount", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ItemCounterNew extends CardView {
    private static final long ANIMATION_DURATION = 300;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float DISABLED_ALPHA = 0.5f;
    private static final float ENABLED_ALPHA = 1.0f;
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final Lazy add$delegate;
    @NotNull
    private final ItemCounterNewController controller;
    private boolean isProductTile;
    @NotNull
    private final Observable<Integer> productQuantityState;
    @NotNull
    private final Observable<Pair<Integer, Boolean>> productStateForTrackingEvents;
    @NotNull
    private final Lazy quantity$delegate;
    @NotNull
    private final Lazy remove$delegate;
    private boolean shouldCollapse;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/common/view/ItemCounterNew$Companion;", "", "()V", "ANIMATION_DURATION", "", "DISABLED_ALPHA", "", "ENABLED_ALPHA", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ItemCounterNew(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ItemCounterNew(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ItemCounterNew(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.add$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ItemCounterNew$add$2(this));
        this.remove$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ItemCounterNew$remove$2(this));
        this.quantity$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ItemCounterNew$quantity$2(this));
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        ItemCounterNewController itemCounterNewController = new ItemCounterNewController(mainThread);
        this.controller = itemCounterNewController;
        this.shouldCollapse = true;
        View.inflate(context, R.layout.darkstores_item_counter_new, this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ItemCounterNew);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…styleable.ItemCounterNew)");
            this.shouldCollapse = obtainStyledAttributes.getBoolean(R.styleable.ItemCounterNew_should_collapse, true);
            obtainStyledAttributes.recycle();
        }
        setRadius(getResources().getDimension(com.talabat.marshmallow.R.dimen.card_view_radius_base));
        setCardElevation(getResources().getDimension(com.talabat.marshmallow.R.dimen.margin_tiny));
        setOnClickListener(new f(this));
        getAdd().setOnClickListener(new g(this));
        getRemove().setOnClickListener(new h(this));
        itemCounterNewController.getViewState().subscribe(new i(this));
        Observable<Integer> share = itemCounterNewController.getProductQuantityState().share();
        Intrinsics.checkNotNullExpressionValue(share, "controller.productQuantityState.share()");
        this.productQuantityState = share;
        Observable<Pair<Integer, Boolean>> share2 = itemCounterNewController.getProductStateForTrackingEvents().share();
        Intrinsics.checkNotNullExpressionValue(share2, "controller.productStateForTrackingEvents.share()");
        this.productStateForTrackingEvents = share2;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m9644_init_$lambda1(ItemCounterNew itemCounterNew, View view) {
        Intrinsics.checkNotNullParameter(itemCounterNew, "this$0");
        itemCounterNew.controller.open();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m9645_init_$lambda2(ItemCounterNew itemCounterNew, View view) {
        Intrinsics.checkNotNullParameter(itemCounterNew, "this$0");
        itemCounterNew.controller.add();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final void m9646_init_$lambda3(ItemCounterNew itemCounterNew, View view) {
        Intrinsics.checkNotNullParameter(itemCounterNew, "this$0");
        itemCounterNew.controller.remove();
    }

    private final AppCompatImageView getAdd() {
        return (AppCompatImageView) this.add$delegate.getValue();
    }

    private final TextView getQuantity() {
        return (TextView) this.quantity$delegate.getValue();
    }

    private final AppCompatImageView getRemove() {
        return (AppCompatImageView) this.remove$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void handleViewState(ItemCounterState itemCounterState) {
        int i11;
        boolean z11;
        boolean z12;
        int i12;
        int i13;
        float f11;
        int i14;
        int i15;
        int i16 = 0;
        if (itemCounterState instanceof ItemCounterState.Invisible) {
            i11 = 4;
        } else {
            i11 = 0;
        }
        setVisibility(i11);
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(ANIMATION_DURATION);
        TransitionManager.beginDelayedTransition(this, changeBounds);
        if (this.isProductTile) {
            setLayoutParams(itemCounterState);
        }
        setEnabled(itemCounterState instanceof ItemCounterState.Collapsed);
        AppCompatImageView remove = getRemove();
        boolean z13 = true;
        if ((itemCounterState instanceof ItemCounterState.Expanded.More) || ((itemCounterState instanceof ItemCounterState.Expanded.One) && itemCounterState.getFreeCount() > 0)) {
            z11 = true;
        } else {
            z11 = false;
        }
        remove.setSelected(z11);
        AppCompatImageView remove2 = getRemove();
        Intrinsics.checkNotNullExpressionValue(remove2, ProductAction.ACTION_REMOVE);
        if ((itemCounterState instanceof ItemCounterState.Expanded) || ((itemCounterState instanceof ItemCounterState.Empty) && itemCounterState.getFreeCount() > 0)) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            i12 = 0;
        } else {
            i12 = 8;
        }
        remove2.setVisibility(i12);
        getAdd().setEnabled(itemCounterState.getCanAdd());
        AppCompatImageView add = getAdd();
        Intrinsics.checkNotNullExpressionValue(add, ProductAction.ACTION_ADD);
        boolean z14 = itemCounterState instanceof ItemCounterState.Collapsed;
        if (!z14) {
            i13 = 0;
        } else {
            i13 = 8;
        }
        add.setVisibility(i13);
        AppCompatImageView add2 = getAdd();
        if (itemCounterState.getCanAdd()) {
            f11 = 1.0f;
        } else {
            f11 = 0.5f;
        }
        add2.setAlpha(f11);
        if (itemCounterState instanceof ItemCounterState.Empty) {
            TextView quantity = getQuantity();
            Intrinsics.checkNotNullExpressionValue(quantity, FirebaseAnalytics.Param.QUANTITY);
            if (itemCounterState.getFreeCount() <= 0) {
                z13 = false;
            }
            if (!z13) {
                i16 = 8;
            }
            quantity.setVisibility(i16);
        } else {
            TextView quantity2 = getQuantity();
            Intrinsics.checkNotNullExpressionValue(quantity2, FirebaseAnalytics.Param.QUANTITY);
            quantity2.setVisibility(0);
        }
        TextView quantity3 = getQuantity();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (z14) {
            i14 = com.talabat.talabatcommon.R.color.white;
        } else {
            i14 = com.talabat.talabatcommon.R.color.black;
        }
        quantity3.setTextColor(ContextExtensionsKt.getColorCompat(context, i14));
        getQuantity().setText(String.valueOf(itemCounterState.getQuantity() + itemCounterState.getFreeCount()));
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        if (z14) {
            i15 = com.designsystem.marshmallow.R.color.ds_primary_100;
        } else {
            i15 = com.talabat.talabatcommon.R.color.white;
        }
        setCardBackgroundColor(ContextExtensionsKt.getColorCompat(context2, i15));
    }

    private final void setLayoutParams(ItemCounterState itemCounterState) {
        ConstraintLayout constraintLayout;
        ViewParent parent = getParent();
        if (parent instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) parent;
        } else {
            constraintLayout = null;
        }
        if (constraintLayout != null) {
            ConstraintSet constraintSet = new ConstraintSet();
            int id2 = getId();
            int i11 = R.id.product_tile_image_container;
            constraintSet.clone(constraintLayout);
            if (itemCounterState instanceof ItemCounterState.Expanded) {
                constraintSet.connect(id2, 6, i11, 6, (int) getResources().getDimension(com.talabat.marshmallow.R.dimen.margin_small));
            } else {
                constraintSet.clear(id2, 6);
            }
            constraintSet.connect(id2, 7, i11, 7);
            constraintSet.connect(id2, 4, i11, 4);
            constraintSet.applyTo(constraintLayout);
        }
    }

    public static /* synthetic */ void setup$default(ItemCounterNew itemCounterNew, int i11, int i12, boolean z11, int i13, int i14, Object obj) {
        if ((i14 & 4) != 0) {
            z11 = false;
        }
        if ((i14 & 8) != 0) {
            i13 = 0;
        }
        itemCounterNew.setup(i11, i12, z11, i13);
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

    @NotNull
    public final Observable<Integer> getProductQuantityState() {
        return this.productQuantityState;
    }

    @NotNull
    public final Observable<Pair<Integer, Boolean>> getProductStateForTrackingEvents() {
        return this.productStateForTrackingEvents;
    }

    public final void setOverlayVisibility(boolean z11) {
        int i11;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.overlayView);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "overlayView");
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        _$_findCachedViewById.setVisibility(i11);
    }

    public final void setup(int i11, int i12, boolean z11, int i13) {
        this.isProductTile = z11;
        this.controller.setup(i11, i12, this.shouldCollapse, i13);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemCounterNew(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
