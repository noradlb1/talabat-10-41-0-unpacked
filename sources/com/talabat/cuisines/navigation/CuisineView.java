package com.talabat.cuisines.navigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.cuisines.R;
import com.talabat.talabatcommon.views.StartForResultCallbacks;
import com.talabat.talabatcommon.views.counterpill.CounterPillTextView;
import datamodels.Cuisine;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B[\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\n\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u001a\u001a\u00020\u000bJ8\u0010\u001b\u001a\u00020\u000b2-\u0010\u001c\u001a)\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00150\u0014\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u000bH\u0002J\u0016\u0010#\u001a\u0004\u0018\u00010!*\u00020$2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00150\u0014X.¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00150\u0019X.¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/talabat/cuisines/navigation/CuisineView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "isPickup", "", "isCollection", "resetSelection", "Lkotlin/Function0;", "", "hasSelection", "selectedCuisines", "", "(Landroid/content/Context;Landroid/util/AttributeSet;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "()Z", "setPickup", "(Z)V", "startCuisineViewForResult", "Lcom/talabat/cuisines/navigation/StartCuisineViewForResult;", "Lkotlin/Pair;", "Ldatamodels/Cuisine;", "", "startForResultCallbacks", "Lcom/talabat/talabatcommon/views/StartForResultCallbacks;", "clearFilters", "invoke", "callbacks", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "updateBubbleVisibility", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "updateView", "updateViews", "Landroid/view/View;", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CuisineView extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final Function0<Boolean> hasSelection;
    /* access modifiers changed from: private */
    public final boolean isCollection;
    private boolean isPickup;
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<Unit> resetSelection;
    @NotNull
    private final Function0<Integer> selectedCuisines;
    /* access modifiers changed from: private */
    public StartCuisineViewForResult<Pair<Cuisine, String>> startCuisineViewForResult;
    /* access modifiers changed from: private */
    public StartForResultCallbacks<Pair<Cuisine, String>> startForResultCallbacks;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CuisineView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        this(context, attributeSet, false, false, (Function0) null, (Function0) null, (Function0) null, 124, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CuisineView(@NotNull Context context, @NotNull AttributeSet attributeSet, boolean z11) {
        this(context, attributeSet, z11, false, (Function0) null, (Function0) null, (Function0) null, 120, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CuisineView(@NotNull Context context, @NotNull AttributeSet attributeSet, boolean z11, boolean z12) {
        this(context, attributeSet, z11, z12, (Function0) null, (Function0) null, (Function0) null, 112, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CuisineView(@org.jetbrains.annotations.NotNull android.content.Context r12, @org.jetbrains.annotations.NotNull android.util.AttributeSet r13, boolean r14, boolean r15, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r16) {
        /*
            r11 = this;
            java.lang.String r0 = "context"
            r2 = r12
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "attrs"
            r3 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "resetSelection"
            r6 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r7 = 0
            r8 = 0
            r9 = 96
            r10 = 0
            r1 = r11
            r4 = r14
            r5 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.cuisines.navigation.CuisineView.<init>(android.content.Context, android.util.AttributeSet, boolean, boolean, kotlin.jvm.functions.Function0):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CuisineView(@org.jetbrains.annotations.NotNull android.content.Context r12, @org.jetbrains.annotations.NotNull android.util.AttributeSet r13, boolean r14, boolean r15, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r16, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<java.lang.Boolean> r17) {
        /*
            r11 = this;
            java.lang.String r0 = "context"
            r2 = r12
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "attrs"
            r3 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "resetSelection"
            r6 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "hasSelection"
            r7 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r8 = 0
            r9 = 64
            r10 = 0
            r1 = r11
            r4 = r14
            r5 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.cuisines.navigation.CuisineView.<init>(android.content.Context, android.util.AttributeSet, boolean, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CuisineView(@NotNull Context context, @NotNull AttributeSet attributeSet, boolean z11, boolean z12, @NotNull Function0<Unit> function0, @NotNull Function0<Boolean> function02, @NotNull Function0<Integer> function03) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        Intrinsics.checkNotNullParameter(function0, "resetSelection");
        Intrinsics.checkNotNullParameter(function02, "hasSelection");
        Intrinsics.checkNotNullParameter(function03, "selectedCuisines");
        this._$_findViewCache = new LinkedHashMap();
        this.isPickup = z11;
        this.isCollection = z12;
        this.resetSelection = function0;
        this.hasSelection = function02;
        this.selectedCuisines = function03;
        View inflate = View.inflate(context, R.layout.view_cuisines, this);
        if (inflate != null) {
            updateViews(inflate, context);
        }
    }

    /* access modifiers changed from: private */
    public final void updateBubbleVisibility(AppCompatActivity appCompatActivity) {
        appCompatActivity.getLifecycle().addObserver(new CuisineView$updateBubbleVisibility$1(this, appCompatActivity));
    }

    /* access modifiers changed from: private */
    public final void updateView() {
        int i11;
        String str;
        ((LinearLayout) _$_findCachedViewById(R.id.cuisineViewLayout)).setEnabled(true);
        int i12 = R.id.counterPill;
        CounterPillTextView counterPillTextView = (CounterPillTextView) _$_findCachedViewById(i12);
        if (this.hasSelection.invoke().booleanValue()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        counterPillTextView.setVisibility(i11);
        if (ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.COUNTERS_AND_NEW_DESIGN_FILTERS_CUISINES, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)) {
            CounterPillTextView counterPillTextView2 = (CounterPillTextView) _$_findCachedViewById(i12);
            if (this.selectedCuisines.invoke().intValue() > 0) {
                str = String.valueOf(this.selectedCuisines.invoke().intValue());
            } else {
                str = "";
            }
            counterPillTextView2.setText(str);
        }
    }

    private final AppCompatActivity updateViews(View view, Context context) {
        return CuisineViewKt.toActivity(context, new CuisineView$updateViews$1(view, this, context));
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

    public final void clearFilters() {
        this.resetSelection.invoke();
        updateView();
    }

    public final void invoke(@NotNull Function1<? super StartCuisineViewForResult<Pair<Cuisine, String>>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callbacks");
        StartCuisineViewForResult<Pair<Cuisine, String>> startCuisineViewForResult2 = new StartCuisineViewForResult<>();
        function1.invoke(startCuisineViewForResult2);
        this.startCuisineViewForResult = startCuisineViewForResult2;
        StartForResultCallbacks<Pair<Cuisine, String>> startForResultCallbacks2 = new StartForResultCallbacks<>();
        startForResultCallbacks2.getOn().start(new CuisineView$invoke$2$1(this));
        startForResultCallbacks2.getOn().success(new CuisineView$invoke$2$2(this));
        startForResultCallbacks2.getOn().cancelled(new CuisineView$invoke$2$3(this));
        this.startForResultCallbacks = startForResultCallbacks2;
    }

    public final boolean isPickup() {
        return this.isPickup;
    }

    public final void setPickup(boolean z11) {
        this.isPickup = z11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CuisineView(Context context, AttributeSet attributeSet, boolean z11, boolean z12, Function0 function0, Function0 function02, Function0 function03, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? false : z12, (i11 & 16) != 0 ? AnonymousClass1.INSTANCE : function0, (i11 & 32) != 0 ? AnonymousClass2.INSTANCE : function02, (i11 & 64) != 0 ? AnonymousClass3.INSTANCE : function03);
    }
}
