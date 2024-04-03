package com.talabat.talabatlife.ui.cuisine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleObserver;
import com.talabat.talabatlife.R;
import com.talabat.talabatlife.domain.entity.Cuisine;
import com.talabat.talabatlife.ui.cuisine.CuisineActivity;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ-\u0010!\u001a\u00020\u00142\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0014\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\b\u0010\"\u001a\u00020\u0014H\u0014J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0014H\u0014R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006'"}, d2 = {"Lcom/talabat/talabatlife/ui/cuisine/TDineCuisineButton;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cuisineList", "", "Lcom/talabat/talabatlife/domain/entity/Cuisine;", "getCuisineList", "()Ljava/util/List;", "setCuisineList", "(Ljava/util/List;)V", "cuisineSelected", "Lkotlin/Function1;", "", "getCuisineSelected", "()Lkotlin/jvm/functions/Function1;", "setCuisineSelected", "(Lkotlin/jvm/functions/Function1;)V", "receiver", "Landroid/content/BroadcastReceiver;", "selectedCuisine", "Lcom/talabat/talabatlife/ui/cuisine/CuisineDisplayModel;", "getSelectedCuisine", "()Lcom/talabat/talabatlife/ui/cuisine/CuisineDisplayModel;", "setSelectedCuisine", "(Lcom/talabat/talabatlife/ui/cuisine/CuisineDisplayModel;)V", "invoke", "onAttachedToWindow", "onClick", "v", "Landroid/view/View;", "onDetachedFromWindow", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TDineCuisineButton extends LinearLayout implements View.OnClickListener, LifecycleObserver {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @Nullable
    private List<Cuisine> cuisineList;
    @Nullable
    private Function1<? super Cuisine, Unit> cuisineSelected;
    @Nullable
    private BroadcastReceiver receiver;
    @Nullable
    private CuisineDisplayModel selectedCuisine;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TDineCuisineButton(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TDineCuisineButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TDineCuisineButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View.inflate(context, R.layout.widget_cuisine_button, this);
        setOnClickListener(this);
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
    public final List<Cuisine> getCuisineList() {
        return this.cuisineList;
    }

    @Nullable
    public final Function1<Cuisine, Unit> getCuisineSelected() {
        return this.cuisineSelected;
    }

    @Nullable
    public final CuisineDisplayModel getSelectedCuisine() {
        return this.selectedCuisine;
    }

    public final void invoke(@NotNull List<Cuisine> list, @NotNull Function1<? super Cuisine, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "cuisineList");
        Intrinsics.checkNotNullParameter(function1, "cuisineSelected");
        this.cuisineSelected = function1;
        if (!list.isEmpty()) {
            this.cuisineList = list;
            ((TextView) _$_findCachedViewById(R.id.selectedCuisineName)).setText(((Cuisine) CollectionsKt___CollectionsKt.first(list)).getName());
            return;
        }
        setVisibility(8);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(CuisineFragmentKt.ACTION_CUISINE_SELECTED);
        this.receiver = new TDineCuisineButton$onAttachedToWindow$1(this);
        getContext().registerReceiver(this.receiver, intentFilter);
    }

    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        if (this.cuisineList != null) {
            CuisineActivity.Companion companion = CuisineActivity.Companion;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            companion.startActivity(context, this.selectedCuisine, new TDineCuisineButton$onClick$1(this));
            return;
        }
        throw new Exception("call TDineCuisineButton().invoke method to be able to open Cuisine List Screen");
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().unregisterReceiver(this.receiver);
    }

    public final void setCuisineList(@Nullable List<Cuisine> list) {
        this.cuisineList = list;
    }

    public final void setCuisineSelected(@Nullable Function1<? super Cuisine, Unit> function1) {
        this.cuisineSelected = function1;
    }

    public final void setSelectedCuisine(@Nullable CuisineDisplayModel cuisineDisplayModel) {
        this.selectedCuisine = cuisineDisplayModel;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TDineCuisineButton(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
