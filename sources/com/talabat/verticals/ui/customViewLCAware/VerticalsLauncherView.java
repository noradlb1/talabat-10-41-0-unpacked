package com.talabat.verticals.ui.customViewLCAware;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.localization.R;
import com.talabat.talabatcommon.views.ShimmerLayout;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.verticals.helper.customMvvmView.MvvmLinearLayout;
import com.talabat.verticals.ui.customViewLCAware.adapter.VerticalsLauncherAdapter;
import com.talabat.verticals.ui.customViewLCAware.model.Vertical;
import com.talabat.verticals.ui.customViewLCAware.model.VerticalsDisplayModel;
import com.talabat.verticals.ui.customViewLCAware.model.VerticalsViewState;
import com.talabat.verticals.ui.customViewLCAware.viewModel.VerticalsLauncherViewModel;
import com.talabat.verticals.ui.customViewLCAware.viewModel.VerticalsLauncherViewModelBuilder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nx.a;
import nx.b;
import nx.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00016B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010%\u001a\u00020\u0016H\u0002J\u0006\u0010&\u001a\u00020\u0016J\u0006\u0010'\u001a\u00020\u0016J\u000e\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0010J \u0010*\u001a\u00020\u00162\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.H\u0002J \u0010/\u001a\u00020\u00162\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.H\u0002J \u00100\u001a\u00020\u00162\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.H\u0002J\b\u00101\u001a\u00020\u0016H\u0002J\u0010\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u00067"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/VerticalsLauncherView;", "Lcom/talabat/verticals/helper/customMvvmView/MvvmLinearLayout;", "Lcom/talabat/verticals/ui/customViewLCAware/viewModel/VerticalsLauncherViewModel;", "Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsLauncherAdapter$MainVerticalsClickListener;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mAdapter", "Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsLauncherAdapter;", "getMAdapter", "()Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsLauncherAdapter;", "setMAdapter", "(Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsLauncherAdapter;)V", "mListener", "Lcom/talabat/verticals/ui/customViewLCAware/VerticalsLauncherView$Listener;", "getMListener", "()Lcom/talabat/verticals/ui/customViewLCAware/VerticalsLauncherView$Listener;", "setMListener", "(Lcom/talabat/verticals/ui/customViewLCAware/VerticalsLauncherView$Listener;)V", "failureHere", "", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getLayoutId", "", "getViewModelClass", "Ljava/lang/Class;", "observatory", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onItemClicked", "deepLink", "", "onLifecycleOwnerAttached", "onViewInitiated", "prepareFoodButton", "retrieveAvailableVerticals", "safetyFailure", "setListener", "listener", "setupForMore", "result", "Ljava/util/ArrayList;", "Lcom/talabat/verticals/ui/customViewLCAware/model/Vertical;", "Lkotlin/collections/ArrayList;", "setupForThreeVerticals", "setupForTwoVerticals", "setupView", "showShimmer", "show", "", "viewModelBuilder", "Listener", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalsLauncherView extends MvvmLinearLayout<VerticalsLauncherViewModel> implements VerticalsLauncherAdapter.MainVerticalsClickListener {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public VerticalsLauncherAdapter mAdapter;
    public Listener mListener;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J \u0010\u0007\u001a\u00020\u00032\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/VerticalsLauncherView$Listener;", "", "onFindRestaurantsClicked", "", "onVerticalClicked", "deepLink", "", "onVerticalsLoaded", "verticals", "Ljava/util/ArrayList;", "Lcom/talabat/verticals/ui/customViewLCAware/model/Vertical;", "Lkotlin/collections/ArrayList;", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Listener {
        void onFindRestaurantsClicked();

        void onVerticalClicked(@Nullable String str);

        void onVerticalsLoaded(@NotNull ArrayList<Vertical> arrayList);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VerticalsLauncherViewModel.LauncherType.values().length];
            iArr[VerticalsLauncherViewModel.LauncherType.BUTTON.ordinal()] = 1;
            iArr[VerticalsLauncherViewModel.LauncherType.TWO_VERTICALS.ordinal()] = 2;
            iArr[VerticalsLauncherViewModel.LauncherType.THREE_VERTICALS.ordinal()] = 3;
            iArr[VerticalsLauncherViewModel.LauncherType.MORE.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerticalsLauncherView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
    }

    /* access modifiers changed from: private */
    /* renamed from: observatory$lambda-5  reason: not valid java name */
    public static final void m5937observatory$lambda5(VerticalsLauncherView verticalsLauncherView, VerticalsViewState verticalsViewState) {
        ArrayList<Vertical> verticals;
        VerticalsDisplayModel verticalsDisplayModel;
        Intrinsics.checkNotNullParameter(verticalsLauncherView, "this$0");
        int i11 = WhenMappings.$EnumSwitchMapping$0[verticalsViewState.getLauncherType().ordinal()];
        if (i11 == 1) {
            verticalsLauncherView.prepareFoodButton();
        } else if (i11 == 2) {
            VerticalsDisplayModel verticalsDisplayModel2 = verticalsViewState.getVerticalsDisplayModel();
            if (verticalsDisplayModel2 != null) {
                verticalsLauncherView.setupForTwoVerticals(verticalsDisplayModel2.getVerticals());
            }
        } else if (i11 == 3) {
            VerticalsDisplayModel verticalsDisplayModel3 = verticalsViewState.getVerticalsDisplayModel();
            if (verticalsDisplayModel3 != null) {
                verticalsLauncherView.setupForThreeVerticals(verticalsDisplayModel3.getVerticals());
            }
        } else if (i11 == 4 && (verticalsDisplayModel = verticalsViewState.getVerticalsDisplayModel()) != null) {
            verticalsLauncherView.setupForMore(verticalsDisplayModel.getVerticals());
        }
        VerticalsDisplayModel verticalsDisplayModel4 = verticalsViewState.getVerticalsDisplayModel();
        if (verticalsDisplayModel4 != null && (verticals = verticalsDisplayModel4.getVerticals()) != null && verticalsLauncherView.mListener != null) {
            verticalsLauncherView.getMListener().onVerticalsLoaded(verticals);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observatory$lambda-6  reason: not valid java name */
    public static final void m5938observatory$lambda6(VerticalsLauncherView verticalsLauncherView, Boolean bool) {
        Intrinsics.checkNotNullParameter(verticalsLauncherView, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        verticalsLauncherView.showShimmer(bool.booleanValue());
    }

    private final void prepareFoodButton() {
        String string = getResources().getString(R.string.dashboard_welcome_string);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…dashboard_welcome_string)");
        ((AppCompatTextView) _$_findCachedViewById(com.talabat.verticals.R.id.introduction_text)).setText(StringsKt__StringsJVMKt.replace$default(string, "#", ((VerticalsLauncherViewModel) getViewModel()).getCountryName(), false, 4, (Object) null));
        ((RecyclerView) _$_findCachedViewById(com.talabat.verticals.R.id.verticals_list)).setVisibility(8);
        ((AppCompatTextView) _$_findCachedViewById(com.talabat.verticals.R.id.btn_only_food)).setVisibility(0);
    }

    private final void setupForMore(ArrayList<Vertical> arrayList) {
        if (this.mAdapter == null) {
            safetyFailure();
            return;
        }
        int i11 = com.talabat.verticals.R.id.verticals_list;
        ((RecyclerView) _$_findCachedViewById(i11)).setVisibility(0);
        ((AppCompatTextView) _$_findCachedViewById(com.talabat.verticals.R.id.btn_only_food)).setVisibility(8);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 6);
        gridLayoutManager.setSpanSizeLookup(new VerticalsLauncherView$setupForMore$2());
        ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(gridLayoutManager);
        getMAdapter().setData(arrayList);
    }

    private final void setupForThreeVerticals(ArrayList<Vertical> arrayList) {
        if (this.mAdapter == null) {
            safetyFailure();
        } else if (getMAdapter() != null) {
            int i11 = com.talabat.verticals.R.id.verticals_list;
            ((RecyclerView) _$_findCachedViewById(i11)).setVisibility(0);
            ((AppCompatTextView) _$_findCachedViewById(com.talabat.verticals.R.id.btn_only_food)).setVisibility(8);
            ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(new GridLayoutManager(getContext(), 3));
            getMAdapter().setData(arrayList);
            ((ConstraintLayout) _$_findCachedViewById(com.talabat.verticals.R.id.inner_container)).setMaxHeight((int) getResources().getDimension(com.talabat.verticals.R.dimen.vertical_item_three_max_height));
        }
    }

    private final void setupForTwoVerticals(ArrayList<Vertical> arrayList) {
        if (this.mAdapter == null) {
            safetyFailure();
        } else if (getMAdapter() != null) {
            int i11 = com.talabat.verticals.R.id.verticals_list;
            ((RecyclerView) _$_findCachedViewById(i11)).setVisibility(0);
            ((AppCompatTextView) _$_findCachedViewById(com.talabat.verticals.R.id.btn_only_food)).setVisibility(8);
            ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(new GridLayoutManager(getContext(), 2));
            getMAdapter().setData(arrayList);
            ((ConstraintLayout) _$_findCachedViewById(com.talabat.verticals.R.id.inner_container)).setMaxHeight((int) getResources().getDimension(com.talabat.verticals.R.dimen.vertical_item_two_max_height));
        }
    }

    private final void setupView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        int i11 = com.talabat.verticals.R.id.verticals_list;
        ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(gridLayoutManager);
        setMAdapter(new VerticalsLauncherAdapter());
        ((RecyclerView) _$_findCachedViewById(i11)).setAdapter(getMAdapter());
        getMAdapter().setListerner(this);
        ((AppCompatTextView) _$_findCachedViewById(com.talabat.verticals.R.id.btn_only_food)).setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupView$lambda-0  reason: not valid java name */
    public static final void m5939setupView$lambda0(VerticalsLauncherView verticalsLauncherView, View view) {
        Intrinsics.checkNotNullParameter(verticalsLauncherView, "this$0");
        verticalsLauncherView.getMListener().onFindRestaurantsClicked();
    }

    private final void showShimmer(boolean z11) {
        if (z11) {
            int i11 = com.talabat.verticals.R.id.dynamic_verticals_shimmer;
            ((ShimmerLayout) _$_findCachedViewById(i11)).setVisibility(0);
            ((ShimmerLayout) _$_findCachedViewById(i11)).startShimmerAnimation();
            return;
        }
        int i12 = com.talabat.verticals.R.id.dynamic_verticals_shimmer;
        ((ShimmerLayout) _$_findCachedViewById(i12)).stopShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(i12)).setVisibility(8);
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

    public void failureHere(@Nullable Failure failure) {
        ((VerticalsLauncherViewModel) getViewModel()).getShimmerSLD().postValue(Boolean.FALSE);
        prepareFoodButton();
    }

    public int getLayoutId() {
        return com.talabat.verticals.R.layout.layout_dynamic_launcher;
    }

    @NotNull
    public final VerticalsLauncherAdapter getMAdapter() {
        VerticalsLauncherAdapter verticalsLauncherAdapter = this.mAdapter;
        if (verticalsLauncherAdapter != null) {
            return verticalsLauncherAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        return null;
    }

    @NotNull
    public final Listener getMListener() {
        Listener listener = this.mListener;
        if (listener != null) {
            return listener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mListener");
        return null;
    }

    @NotNull
    public Class<VerticalsLauncherViewModel> getViewModelClass() {
        return VerticalsLauncherViewModel.class;
    }

    public void observatory(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        ((VerticalsLauncherViewModel) getViewModel()).getSuccess().observe(lifecycleOwner, new a(this));
        ((VerticalsLauncherViewModel) getViewModel()).getShimmerSLD().observe(lifecycleOwner, new b(this));
        LifecycleKt.failure(lifecycleOwner, ((VerticalsLauncherViewModel) getViewModel()).getFailureData(), new VerticalsLauncherView$observatory$3(this));
    }

    public void onItemClicked(@Nullable String str) {
        getMListener().onVerticalClicked(str);
    }

    public void onLifecycleOwnerAttached(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        observatory(lifecycleOwner);
        setupView();
        retrieveAvailableVerticals();
    }

    public void onViewInitiated(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        observatory(lifecycleOwner);
        setupView();
    }

    public final void retrieveAvailableVerticals() {
        if (this.mAdapter == null) {
            setupView();
        }
        ((VerticalsLauncherViewModel) getViewModel()).getVerticalsForLocation();
    }

    public final void safetyFailure() {
        ((VerticalsLauncherViewModel) getViewModel()).getShimmerSLD().postValue(Boolean.FALSE);
        prepareFoodButton();
    }

    public final void setListener(@NotNull Listener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        setMListener(listener);
    }

    public final void setMAdapter(@NotNull VerticalsLauncherAdapter verticalsLauncherAdapter) {
        Intrinsics.checkNotNullParameter(verticalsLauncherAdapter, "<set-?>");
        this.mAdapter = verticalsLauncherAdapter;
    }

    public final void setMListener(@NotNull Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "<set-?>");
        this.mListener = listener;
    }

    @NotNull
    public VerticalsLauncherViewModel viewModelBuilder() {
        VerticalsLauncherViewModelBuilder.Companion companion = VerticalsLauncherViewModelBuilder.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return companion.getMyViewModel(context, getCoroutineScope());
    }
}
