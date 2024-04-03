package com.talabat.growth.ui.vouchers.details;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.marshmallow.TalabatTag;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.core.navigation.domain.screen.voucherdetails.VoucherDetailsScreen;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.growth.R;
import com.talabat.growth.ui.loyalty.views.CouponCodeView;
import com.talabat.growth.ui.util.ExtentionsKt;
import com.talabat.growth.ui.vouchers.details.di.DaggerVoucherDetailsFragmentComponent;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.VoucherDetailDomainModel;
import com.talabat.talabatcommon.utils.DisplayUtils;
import com.talabat.talabatcommon.views.TalabatImageView;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatcore.testframework.ViewModelInjectorKt;
import com.talabat.talabatcore.viewmodel.BaseViewModelFactory;
import com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qr.a;
import qr.b;

@Instrumented
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001c\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\fH\u0002J\b\u0010)\u001a\u00020\fH\u0002J\b\u0010*\u001a\u00020\fH\u0002J\u0010\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020-H\u0002J\u0016\u0010.\u001a\u00020\f*\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0010H\u0002J\u0016\u00101\u001a\u00020\f*\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0010H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/talabat/growth/ui/vouchers/details/VoucherDetailsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "viewModel", "Lcom/talabat/growth/ui/vouchers/details/VoucherDetailsViewModel;", "failureHere", "", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getVoucherId", "", "intent", "Landroid/os/Bundle;", "handleRedirectionToPartnerButton", "partnerUrlText", "partnerUrl", "hideProgress", "loadVoucherDetails", "voucherID", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onViewCreated", "view", "populateUi", "voucherDetailDomainModel", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/VoucherDetailDomainModel;", "setupUI", "showError", "showProgress", "updateLoadingVisibility", "updateStatues", "", "showTag", "Lcom/marshmallow/TalabatTag;", "tag", "updateCouponCodeUi", "Lcom/talabat/growth/ui/loyalty/views/CouponCodeView;", "nfpCouponCode", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherDetailsFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @Inject
    public IObservabilityManager observabilityManager;
    private VoucherDetailsViewModel viewModel;

    private final String getVoucherId(Bundle bundle) {
        String str;
        VoucherDetailsScreen.VoucherDetailsData voucherDetailsData = (VoucherDetailsScreen.VoucherDetailsData) bundle.getParcelable("navigatorData");
        if (voucherDetailsData != null) {
            str = voucherDetailsData.getVoucherID();
        } else {
            str = null;
        }
        String string = bundle.getString(GrowthNavigatorActions.EXTRA_LOYALTY_VOUCHER_ID);
        if (string == null) {
            return str;
        }
        return string;
    }

    private final void handleRedirectionToPartnerButton(String str, String str2) {
        boolean z11;
        boolean z12 = true;
        if (str2 == null || StringsKt__StringsJVMKt.isBlank(str2)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                z12 = false;
            }
            if (!z12) {
                int i11 = R.id.voucherDetailsRedirectionToPartnerButton;
                ((DSPrimaryButton) _$_findCachedViewById(i11)).setTitle(str);
                ((DSPrimaryButton) _$_findCachedViewById(i11)).setVisibility(0);
                ((DSPrimaryButton) _$_findCachedViewById(i11)).setOnClickListener(new a(this, str2));
                return;
            }
        }
        ((TextView) _$_findCachedViewById(R.id.showVoucherCodeHintTextView)).setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleRedirectionToPartnerButton$lambda-13  reason: not valid java name */
    public static final void m10611handleRedirectionToPartnerButton$lambda13(VoucherDetailsFragment voucherDetailsFragment, String str, View view) {
        Object obj;
        boolean z11;
        Intrinsics.checkNotNullParameter(voucherDetailsFragment, "this$0");
        try {
            Result.Companion companion = Result.Companion;
            Context requireContext = voucherDetailsFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            ExtentionsKt.openLinkInBrowser(str, requireContext);
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6332exceptionOrNullimpl(obj) != null) {
            IObservabilityManager observabilityManager2 = voucherDetailsFragment.getObservabilityManager();
            if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!Boolean.valueOf(true ^ z11).booleanValue()) {
                str = null;
            }
            IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(observabilityManager2, "FailToOpenPartnerUrl url:" + str, (Map) null, 2, (Object) null);
            voucherDetailsFragment.showError();
        }
    }

    private final void hideProgress() {
        updateLoadingVisibility(8);
    }

    private final void loadVoucherDetails(String str) {
        if (str != null) {
            showProgress();
            VoucherDetailsViewModel voucherDetailsViewModel = this.viewModel;
            if (voucherDetailsViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                voucherDetailsViewModel = null;
            }
            voucherDetailsViewModel.getVoucherDetails(str);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    public final void populateUi(VoucherDetailDomainModel voucherDetailDomainModel) {
        hideProgress();
        String imageURL = voucherDetailDomainModel.getImageURL();
        TalabatImageView talabatImageView = (TalabatImageView) _$_findCachedViewById(R.id.voucherDetailsImageView);
        Intrinsics.checkNotNullExpressionValue(talabatImageView, "voucherDetailsImageView");
        TalabatImageView.setImageResizeUrl$default(talabatImageView, imageURL, 0, 0, false, 14, (Object) null);
        String thumbnailURL = voucherDetailDomainModel.getThumbnailURL();
        TalabatImageView talabatImageView2 = (TalabatImageView) _$_findCachedViewById(R.id.voucherDetailsIconImageView);
        Intrinsics.checkNotNullExpressionValue(talabatImageView2, "voucherDetailsIconImageView");
        TalabatImageView.setImageResizeUrl$default(talabatImageView2, thumbnailURL, 0, 0, false, 14, (Object) null);
        ((TextView) _$_findCachedViewById(R.id.voucherDetailsTitleTextView)).setText(voucherDetailDomainModel.getTitle());
        String description = voucherDetailDomainModel.getDescription();
        TextView textView = (TextView) _$_findCachedViewById(R.id.voucherDetailsDetailTextView);
        Intrinsics.checkNotNullExpressionValue(textView, "voucherDetailsDetailTextView");
        ExtentionsKt.renderContentAsHtml(textView, description);
        TalabatTag talabatTag = (TalabatTag) _$_findCachedViewById(R.id.voucherDetailsTagView);
        Intrinsics.checkNotNullExpressionValue(talabatTag, "voucherDetailsTagView");
        showTag(talabatTag, voucherDetailDomainModel.getTag());
        CouponCodeView couponCodeView = (CouponCodeView) _$_findCachedViewById(R.id.voucherDetailsCouponCodeView);
        Intrinsics.checkNotNullExpressionValue(couponCodeView, "voucherDetailsCouponCodeView");
        updateCouponCodeUi(couponCodeView, voucherDetailDomainModel.getNfpCouponCode());
        handleRedirectionToPartnerButton(voucherDetailDomainModel.getPartnerUrlText(), voucherDetailDomainModel.getPartnerUrl());
    }

    private final void setupUI() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            DisplayUtils.Companion.transparentStatus(activity);
        }
        ((ImageButton) _$_findCachedViewById(R.id.voucherDetailsBackButton)).setOnClickListener(new b(this));
        VoucherDetailsViewModel voucherDetailsViewModel = this.viewModel;
        VoucherDetailsViewModel voucherDetailsViewModel2 = null;
        if (voucherDetailsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            voucherDetailsViewModel = null;
        }
        LifecycleKt.observe(this, voucherDetailsViewModel.getVoucherDetailsDisplayModelLiveData(), new VoucherDetailsFragment$setupUI$3(this));
        VoucherDetailsViewModel voucherDetailsViewModel3 = this.viewModel;
        if (voucherDetailsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            voucherDetailsViewModel2 = voucherDetailsViewModel3;
        }
        LifecycleKt.observe(this, voucherDetailsViewModel2.getFailureData(), new VoucherDetailsFragment$setupUI$4(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupUI$lambda-5  reason: not valid java name */
    public static final void m10612setupUI$lambda5(VoucherDetailsFragment voucherDetailsFragment, View view) {
        Intrinsics.checkNotNullParameter(voucherDetailsFragment, "this$0");
        FragmentActivity activity = voucherDetailsFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private final void showError() {
        String string = getResources().getString(com.talabat.localization.R.string.sorry_something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…rry_something_went_wrong)");
        Status.Companion.notify$default(Status.Companion, getActivity(), (CardView) _$_findCachedViewById(R.id.voucherDetailsLinearLayout), string, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 56, (Object) null);
    }

    private final void showProgress() {
        updateLoadingVisibility(0);
    }

    private final void showTag(TalabatTag talabatTag, String str) {
        if (str != null) {
            if (!(!StringsKt__StringsJVMKt.isBlank(str))) {
                str = null;
            }
            if (str != null) {
                talabatTag.setTagText(str);
                talabatTag.setVisibility(0);
            }
        }
    }

    private final void updateCouponCodeUi(CouponCodeView couponCodeView, String str) {
        if (str != null) {
            if (!(!StringsKt__StringsJVMKt.isBlank(str))) {
                str = null;
            }
            if (str != null) {
                CouponCodeView.updateUi$default(couponCodeView, (String) null, str, 1, (Object) null);
                couponCodeView.setVisibility(0);
            }
        }
    }

    private final void updateLoadingVisibility(int i11) {
        View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(i11);
        }
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

    public final void failureHere(@Nullable Failure failure) {
        hideProgress();
        showError();
    }

    @NotNull
    public final IObservabilityManager getObservabilityManager() {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        if (iObservabilityManager != null) {
            return iObservabilityManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observabilityManager");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerVoucherDetailsFragmentComponent.factory().create((ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ObservabilityCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "VoucherDetailsFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "VoucherDetailsFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.frag_loyalty_voucher_details, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…etails, container, false)");
        TraceMachine.exitMethod();
        return inflate;
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

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.viewModel = (VoucherDetailsViewModel) ViewModelInjectorKt.injectViewModel((Fragment) this, VoucherDetailsViewModel.class, (ViewModelProvider.Factory) new BaseViewModelFactory(new VoucherDetailsFragment$onViewCreated$1(this)));
        setupUI();
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = getVoucherId(arguments);
        } else {
            str = null;
        }
        loadVoucherDetails(str);
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }
}
