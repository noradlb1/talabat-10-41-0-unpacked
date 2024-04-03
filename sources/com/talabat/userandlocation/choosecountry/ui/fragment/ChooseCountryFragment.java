package com.talabat.userandlocation.choosecountry.ui.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import ax.a;
import ax.b;
import ax.c;
import ax.d;
import ax.e;
import ax.f;
import ax.g;
import ax.h;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.helpers.CustomDialog;
import com.talabat.helpers.GlobalConstants;
import com.talabat.talabatcommon.views.TalabatToolBar;
import com.talabat.talabatcommon.views.TalabatToolBarImageButton;
import com.talabat.talabatcommon.views.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.fragments.FragmentInflater;
import com.talabat.talabatcommon.views.fragments.InflatableFragment;
import com.talabat.talabatcore.adapters.FunctionalAdaptersKt;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.userandlocation.choosecountry.R;
import com.talabat.userandlocation.choosecountry.presentation.Extras;
import com.talabat.userandlocation.choosecountry.presentation.displaymodel.ClearCartConfirmationDialogDisplayModel;
import com.talabat.userandlocation.choosecountry.presentation.displaymodel.DismissScreenDisplayModel;
import com.talabat.userandlocation.choosecountry.presentation.viewmodel.ChooseCountryViewModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ExperimentalStdlibApi;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\rH\u0002J\u0012\u0010!\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0001J\b\u0010*\u001a\u00020\rH\u0002J\u000e\u0010+\u001a\u00020\u001c*\u0004\u0018\u00010#H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0014\u0010\u0015¨\u0006-"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/ui/fragment/ChooseCountryFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/talabatcommon/views/fragments/InflatableFragment;", "()V", "progressDialog", "Lcom/talabat/helpers/CustomDialog;", "getProgressDialog", "()Lcom/talabat/helpers/CustomDialog;", "progressDialog$delegate", "Lkotlin/Lazy;", "toolbarHandler", "Lkotlin/Function1;", "Landroidx/appcompat/widget/Toolbar;", "", "getToolbarHandler", "()Lkotlin/jvm/functions/Function1;", "setToolbarHandler", "(Lkotlin/jvm/functions/Function1;)V", "viewModel", "Lcom/talabat/userandlocation/choosecountry/presentation/viewmodel/ChooseCountryViewModel;", "getViewModel", "()Lcom/talabat/userandlocation/choosecountry/presentation/viewmodel/ChooseCountryViewModel;", "viewModel$delegate", "finishWithResult", "selectedCountryId", "", "goToHomeScreen", "extras", "Lcom/talabat/userandlocation/choosecountry/presentation/Extras;", "handleClearCart", "dialogDisplayModel", "Lcom/talabat/userandlocation/choosecountry/presentation/displaymodel/ClearCartConfirmationDialogDisplayModel;", "observeViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setupViews", "toExtras", "Companion", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalStdlibApi
public final class ChooseCountryFragment extends Fragment implements InflatableFragment, TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final /* synthetic */ FragmentInflater $$delegate_0 = new FragmentInflater(R.layout.choose_country_fragment);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final Lazy progressDialog$delegate;
    @NotNull
    private Function1<? super Toolbar, Unit> toolbarHandler = ChooseCountryFragment$toolbarHandler$1.INSTANCE;
    @NotNull
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/ui/fragment/ChooseCountryFragment$Companion;", "", "()V", "newInstance", "Lcom/talabat/userandlocation/choosecountry/ui/fragment/ChooseCountryFragment;", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChooseCountryFragment newInstance() {
            return new ChooseCountryFragment();
        }
    }

    public ChooseCountryFragment() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ChooseCountryFragment$viewModel$2(this));
        this.progressDialog$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ChooseCountryFragment$progressDialog$2(this));
    }

    private final void finishWithResult(int i11) {
        Intent intent = new Intent();
        intent.putExtra("country", i11);
        intent.putExtra(GlobalConstants.ExtraNames.REDIRECT_LOCATION_COUNTRY_SELECTION, true);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    private final CustomDialog getProgressDialog() {
        return (CustomDialog) this.progressDialog$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChooseCountryViewModel getViewModel() {
        return (ChooseCountryViewModel) this.viewModel$delegate.getValue();
    }

    private final void goToHomeScreen(Extras extras) {
        Navigator.Companion companion = Navigator.Companion;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        NavigatorModel navigatorModel = new NavigatorModel("talabat.action.homeScreen", (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null);
        navigatorModel.setInit(new ChooseCountryFragment$goToHomeScreen$1$1(extras));
        Unit unit = Unit.INSTANCE;
        companion.navigate((Context) requireActivity, navigatorModel);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void handleClearCart(ClearCartConfirmationDialogDisplayModel clearCartConfirmationDialogDisplayModel) {
        if (clearCartConfirmationDialogDisplayModel instanceof ClearCartConfirmationDialogDisplayModel.Show) {
            ClearCartConfirmationDialogDisplayModel.Show show = (ClearCartConfirmationDialogDisplayModel.Show) clearCartConfirmationDialogDisplayModel;
            new AlertDialog.Builder(requireContext(), com.talabat.talabatcommon.R.style.AlertDialogTheme).setTitle((CharSequence) show.getTitle()).setMessage((CharSequence) show.getMessage()).setPositiveButton((CharSequence) show.getPositiveButtonText(), (DialogInterface.OnClickListener) new f(clearCartConfirmationDialogDisplayModel)).setNegativeButton((CharSequence) show.getNegativeButtonText(), (DialogInterface.OnClickListener) new g(clearCartConfirmationDialogDisplayModel)).show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleClearCart$lambda-7  reason: not valid java name */
    public static final void m5883handleClearCart$lambda7(ClearCartConfirmationDialogDisplayModel clearCartConfirmationDialogDisplayModel, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(clearCartConfirmationDialogDisplayModel, "$dialogDisplayModel");
        ((ClearCartConfirmationDialogDisplayModel.Show) clearCartConfirmationDialogDisplayModel).getPositiveButtonHandler().invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: handleClearCart$lambda-8  reason: not valid java name */
    public static final void m5884handleClearCart$lambda8(ClearCartConfirmationDialogDisplayModel clearCartConfirmationDialogDisplayModel, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(clearCartConfirmationDialogDisplayModel, "$dialogDisplayModel");
        ((ClearCartConfirmationDialogDisplayModel.Show) clearCartConfirmationDialogDisplayModel).getNegativeButtonHandler().invoke();
    }

    private final void observeViewModel() {
        getViewModel().getScreenTitle().observe(getViewLifecycleOwner(), new a(this));
        getViewModel().getDismissScreenDisplayModel().observe(getViewLifecycleOwner(), new b(this));
        getViewModel().getClearCartConfirmationDialogDisplayModel().observe(getViewLifecycleOwner(), new c(this));
        getViewModel().getShowProgressDialog().observe(getViewLifecycleOwner(), new d(this));
        getViewModel().getToastMessage().observe(getViewLifecycleOwner(), new e(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.recyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        FunctionalAdaptersKt.invoke$default(recyclerView, R.layout.item_country_list, getViewModel().getCountries(), getViewLifecycleOwner(), (RecyclerView.LayoutManager) null, (Function2) null, new ChooseCountryFragment$observeViewModel$6(this), 24, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-1  reason: not valid java name */
    public static final void m5885observeViewModel$lambda1(ChooseCountryFragment chooseCountryFragment, String str) {
        Intrinsics.checkNotNullParameter(chooseCountryFragment, "this$0");
        ((TalabatToolBarTextView) chooseCountryFragment._$_findCachedViewById(R.id.title)).setText(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-2  reason: not valid java name */
    public static final void m5886observeViewModel$lambda2(ChooseCountryFragment chooseCountryFragment, DismissScreenDisplayModel dismissScreenDisplayModel) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(chooseCountryFragment, "this$0");
        if (dismissScreenDisplayModel instanceof DismissScreenDisplayModel.ToHomeScreen) {
            chooseCountryFragment.goToHomeScreen(((DismissScreenDisplayModel.ToHomeScreen) dismissScreenDisplayModel).getExtras());
        } else if (dismissScreenDisplayModel instanceof DismissScreenDisplayModel.WithResult) {
            chooseCountryFragment.finishWithResult(((DismissScreenDisplayModel.WithResult) dismissScreenDisplayModel).getSelectedCountryId());
        } else if (Intrinsics.areEqual((Object) dismissScreenDisplayModel, (Object) DismissScreenDisplayModel.NoResult.INSTANCE) && (activity = chooseCountryFragment.getActivity()) != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-3  reason: not valid java name */
    public static final void m5887observeViewModel$lambda3(ChooseCountryFragment chooseCountryFragment, ClearCartConfirmationDialogDisplayModel clearCartConfirmationDialogDisplayModel) {
        Intrinsics.checkNotNullParameter(chooseCountryFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(clearCartConfirmationDialogDisplayModel, "it");
        chooseCountryFragment.handleClearCart(clearCartConfirmationDialogDisplayModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-4  reason: not valid java name */
    public static final void m5888observeViewModel$lambda4(ChooseCountryFragment chooseCountryFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(chooseCountryFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        boolean booleanValue = bool.booleanValue();
        CustomDialog progressDialog = chooseCountryFragment.getProgressDialog();
        if (booleanValue) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-5  reason: not valid java name */
    public static final void m5889observeViewModel$lambda5(ChooseCountryFragment chooseCountryFragment, String str) {
        Intrinsics.checkNotNullParameter(chooseCountryFragment, "this$0");
        Toast.makeText(chooseCountryFragment.requireContext(), str, 0).show();
    }

    private final void setupViews() {
        Function1<? super Toolbar, Unit> function1 = this.toolbarHandler;
        TalabatToolBar talabatToolBar = (TalabatToolBar) _$_findCachedViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(talabatToolBar, "toolbar");
        function1.invoke(talabatToolBar);
        ((TalabatToolBarImageButton) _$_findCachedViewById(R.id.back)).setOnClickListener(new h(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupViews$lambda-0  reason: not valid java name */
    public static final void m5890setupViews$lambda0(ChooseCountryFragment chooseCountryFragment, View view) {
        Intrinsics.checkNotNullParameter(chooseCountryFragment, "this$0");
        chooseCountryFragment.getViewModel().onBackClicked();
    }

    private final Extras toExtras(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (bundle2 == null) {
            return new Extras(false, false, false, false, false, 31, (DefaultConstructorMarker) null);
        }
        return new Extras(bundle2.getBoolean("isInitialSelection", false), bundle2.getBoolean(GlobalConstants.ExtraNames.IS_FROM_LOCATION_WELCOME, false), bundle2.getBoolean(GlobalConstants.ExtraNames.IS_LOAD_MAP_FROM_WELCOME, false), bundle2.getBoolean("is_show_map_search", false), bundle2.getBoolean(GlobalConstants.ExtraNames.SHOULD_FORCE_LOCATION_IN_HOME, false));
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    @NotNull
    public final Function1<Toolbar, Unit> getToolbarHandler() {
        return this.toolbarHandler;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        setupViews();
        observeViewModel();
        getViewModel().onViewCreated(toExtras(getArguments()));
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "ChooseCountryFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "ChooseCountryFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View onCreateView = this.$$delegate_0.onCreateView(layoutInflater, viewGroup, bundle);
        TraceMachine.exitMethod();
        return onCreateView;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public final void setToolbarHandler(@NotNull Function1<? super Toolbar, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.toolbarHandler = function1;
    }
}
