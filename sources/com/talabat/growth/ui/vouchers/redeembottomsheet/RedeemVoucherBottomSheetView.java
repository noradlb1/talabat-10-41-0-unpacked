package com.talabat.growth.ui.vouchers.redeembottomsheet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.designsystem.ds_button.DSPrimaryButton;
import com.designsystem.ds_button.DSTertiaryButton;
import com.marshmallow.TalabatAlert;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.growth.R;
import com.talabat.growth.ui.vouchers.redeembottomsheet.di.DaggerRedeemVoucherBottomSheetViewComponent;
import com.talabat.growth.ui.vouchers.redeembottomsheet.model.RedeemVoucherBottomSheetDisplayModel;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.utils.ImageViewExtensionsKt;
import com.talabat.talabatcore.TalabatBaseMvvmBottomSheetDialogFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vr.a;
import vr.b;
import vr.c;
import vr.d;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\rJ\u0012\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020%H\u0016J\b\u0010&\u001a\u00020\tH\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0018\u00105\u001a\u00020\t2\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0004J\u0010\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\u0004H\u0002J\b\u0010;\u001a\u00020\tH\u0002J!\u0010<\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010=\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0002\u0010?J\b\u0010@\u001a\u00020\tH\u0002J\u0010\u0010A\u001a\u00020\t2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010B\u001a\u00020\t2\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010C\u001a\u00020\u0002H\u0016R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/talabat/growth/ui/vouchers/redeembottomsheet/RedeemVoucherBottomSheetView;", "Lcom/talabat/talabatcore/TalabatBaseMvvmBottomSheetDialogFragment;", "Lcom/talabat/growth/ui/vouchers/redeembottomsheet/RedeemVoucherBottomSheetViewModel;", "voucherCode", "", "isCustomerLoggedIn", "", "navigateToLogin", "Lkotlin/Function1;", "", "navigateToVoucherWallet", "Lkotlin/Function0;", "navigateToVoucherDeepLinkDestination", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "isVoucherAlertEnabled", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getViewModelClass", "Ljava/lang/Class;", "observatory", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "showDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "showError", "errorMessage", "showLoading", "showResult", "redeemVoucherBottomSheetDisplayModel", "Lcom/talabat/growth/ui/vouchers/redeembottomsheet/model/RedeemVoucherBottomSheetDisplayModel;", "(Ljava/lang/Boolean;Lcom/talabat/growth/ui/vouchers/redeembottomsheet/model/RedeemVoucherBottomSheetDisplayModel;)V", "updateLoadingState", "updateLoggedInState", "updateNotLoggedInState", "viewModelBuilder", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemVoucherBottomSheetView extends TalabatBaseMvvmBottomSheetDialogFragment<RedeemVoucherBottomSheetViewModel> {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    private final boolean isCustomerLoggedIn;
    private final boolean isVoucherAlertEnabled;
    @NotNull
    private final Function1<String, Unit> navigateToLogin;
    @NotNull
    private final Function1<String, Unit> navigateToVoucherDeepLinkDestination;
    @NotNull
    private final Function0<Unit> navigateToVoucherWallet;
    @Inject
    public IObservabilityManager observabilityManager;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;
    @NotNull
    private final String voucherCode;

    public RedeemVoucherBottomSheetView(@NotNull String str, boolean z11, @NotNull Function1<? super String, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function1<? super String, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, "voucherCode");
        Intrinsics.checkNotNullParameter(function1, "navigateToLogin");
        Intrinsics.checkNotNullParameter(function0, "navigateToVoucherWallet");
        Intrinsics.checkNotNullParameter(function12, "navigateToVoucherDeepLinkDestination");
        this.voucherCode = str;
        this.isCustomerLoggedIn = z11;
        this.navigateToLogin = function1;
        this.navigateToVoucherWallet = function0;
        this.navigateToVoucherDeepLinkDestination = function12;
        this.isVoucherAlertEnabled = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m10616onViewCreated$lambda0(RedeemVoucherBottomSheetView redeemVoucherBottomSheetView, View view) {
        Intrinsics.checkNotNullParameter(redeemVoucherBottomSheetView, "this$0");
        redeemVoucherBottomSheetView.dismiss();
    }

    private final void showError(String str) {
        dismiss();
        Toast.makeText(requireContext(), str, 0).show();
    }

    private final void showLoading() {
        updateLoadingState();
        if (this.isCustomerLoggedIn) {
            _$_findCachedViewById(R.id.loadingLoggedInViewState).setVisibility(0);
        } else {
            _$_findCachedViewById(R.id.loadingNotLoggedInViewState).setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void showResult(Boolean bool, RedeemVoucherBottomSheetDisplayModel redeemVoucherBottomSheetDisplayModel) {
        if (redeemVoucherBottomSheetDisplayModel == null) {
            return;
        }
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            updateLoggedInState(redeemVoucherBottomSheetDisplayModel);
        } else {
            updateNotLoggedInState(redeemVoucherBottomSheetDisplayModel);
        }
    }

    private final void updateLoadingState() {
        ((TextView) _$_findCachedViewById(R.id.titleBottomSheet)).setVisibility(8);
    }

    private final void updateLoggedInState(RedeemVoucherBottomSheetDisplayModel redeemVoucherBottomSheetDisplayModel) {
        View _$_findCachedViewById = _$_findCachedViewById(R.id.loggedInState);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "loggedInState");
        View _$_findCachedViewById2 = _$_findCachedViewById(R.id.loadingLoggedInViewState);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById2, "loadingLoggedInViewState");
        ViewKt.crossFade(_$_findCachedViewById, _$_findCachedViewById2);
        int i11 = 0;
        ((TextView) _$_findCachedViewById(R.id.titleBottomSheet)).setVisibility(0);
        ((TextView) _$_findCachedViewById(R.id.voucherTitleTextView_loggedIn)).setText(redeemVoucherBottomSheetDisplayModel.getTitle());
        ((TextView) _$_findCachedViewById(R.id.voucherDescriptionTextView_loggedIn)).setText(redeemVoucherBottomSheetDisplayModel.getDescription());
        ((TextView) _$_findCachedViewById(R.id.voucherConditionsTextView_loggedIn)).setText(redeemVoucherBottomSheetDisplayModel.getTermsAndConditions());
        ((TextView) _$_findCachedViewById(R.id.voucherValidTilTextView_loggedIn)).setText(redeemVoucherBottomSheetDisplayModel.getValidTilDate());
        TalabatAlert talabatAlert = (TalabatAlert) _$_findCachedViewById(R.id.voucherHintAlert_loggedIn);
        if (!this.isVoucherAlertEnabled) {
            i11 = 8;
        }
        talabatAlert.setVisibility(i11);
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.voucherImageView_loggedIn);
        Intrinsics.checkNotNullExpressionValue(imageView, "voucherImageView_loggedIn");
        ImageViewExtensionsKt.loadImage$default(imageView, redeemVoucherBottomSheetDisplayModel.getImage(), (Function1) null, 2, (Object) null);
        ((DSPrimaryButton) _$_findCachedViewById(R.id.placeAnOrderButton_loggedIn)).setOnClickListener(new c(this, redeemVoucherBottomSheetDisplayModel));
        ((DSTertiaryButton) _$_findCachedViewById(R.id.viewVouchersButton_loggedIn)).setOnClickListener(new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: updateLoggedInState$lambda-3  reason: not valid java name */
    public static final void m10617updateLoggedInState$lambda3(RedeemVoucherBottomSheetView redeemVoucherBottomSheetView, RedeemVoucherBottomSheetDisplayModel redeemVoucherBottomSheetDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(redeemVoucherBottomSheetView, "this$0");
        Intrinsics.checkNotNullParameter(redeemVoucherBottomSheetDisplayModel, "$redeemVoucherBottomSheetDisplayModel");
        redeemVoucherBottomSheetView.dismiss();
        redeemVoucherBottomSheetView.navigateToVoucherDeepLinkDestination.invoke(redeemVoucherBottomSheetDisplayModel.getDeepLink());
    }

    /* access modifiers changed from: private */
    /* renamed from: updateLoggedInState$lambda-4  reason: not valid java name */
    public static final void m10618updateLoggedInState$lambda4(RedeemVoucherBottomSheetView redeemVoucherBottomSheetView, View view) {
        Intrinsics.checkNotNullParameter(redeemVoucherBottomSheetView, "this$0");
        redeemVoucherBottomSheetView.dismiss();
        redeemVoucherBottomSheetView.navigateToVoucherWallet.invoke();
    }

    private final void updateNotLoggedInState(RedeemVoucherBottomSheetDisplayModel redeemVoucherBottomSheetDisplayModel) {
        View _$_findCachedViewById = _$_findCachedViewById(R.id.notLoggedInState);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "notLoggedInState");
        View _$_findCachedViewById2 = _$_findCachedViewById(R.id.loadingNotLoggedInViewState);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById2, "loadingNotLoggedInViewState");
        ViewKt.crossFade(_$_findCachedViewById, _$_findCachedViewById2);
        ((TextView) _$_findCachedViewById(R.id.titleBottomSheet)).setVisibility(8);
        ((TextView) _$_findCachedViewById(R.id.voucherTitleTextView_notLoggedIn)).setText(redeemVoucherBottomSheetDisplayModel.getTitle());
        ((TextView) _$_findCachedViewById(R.id.voucherDescriptionTextView_notLoggedIn)).setText(redeemVoucherBottomSheetDisplayModel.getDescription());
        ((TextView) _$_findCachedViewById(R.id.voucherConditionsTextView_notLoggedIn)).setText(redeemVoucherBottomSheetDisplayModel.getTermsAndConditions());
        ((TextView) _$_findCachedViewById(R.id.voucherTagTextView_notLoggedIn)).setText(redeemVoucherBottomSheetDisplayModel.getTag());
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.voucherImageView_notLoggedIn);
        Intrinsics.checkNotNullExpressionValue(imageView, "voucherImageView_notLoggedIn");
        ImageViewExtensionsKt.loadImage$default(imageView, redeemVoucherBottomSheetDisplayModel.getImage(), (Function1) null, 2, (Object) null);
        ((DSPrimaryButton) _$_findCachedViewById(R.id.signUpButton_notLoggedIn)).setOnClickListener(new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: updateNotLoggedInState$lambda-2  reason: not valid java name */
    public static final void m10619updateNotLoggedInState$lambda2(RedeemVoucherBottomSheetView redeemVoucherBottomSheetView, View view) {
        Intrinsics.checkNotNullParameter(redeemVoucherBottomSheetView, "this$0");
        redeemVoucherBottomSheetView.dismiss();
        redeemVoucherBottomSheetView.navigateToLogin.invoke(redeemVoucherBottomSheetView.voucherCode);
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

    public void failureHere(@Nullable Failure failure) {
        String string = requireContext().getString(com.talabat.localization.R.string.voucher_invalid_or_expired);
        Intrinsics.checkNotNullExpressionValue(string, "requireContext().getStri…ucher_invalid_or_expired)");
        showError(string);
    }

    @NotNull
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        ConfigurationLocalRepository configurationLocalRepository2 = this.configurationLocalRepository;
        if (configurationLocalRepository2 != null) {
            return configurationLocalRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalRepository");
        return null;
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

    @NotNull
    public final ITalabatFeatureFlag getTalabatFeatureFlag() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.talabatFeatureFlag;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatFeatureFlag");
        return null;
    }

    @NotNull
    public Class<RedeemVoucherBottomSheetViewModel> getViewModelClass() {
        return RedeemVoucherBottomSheetViewModel.class;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((RedeemVoucherBottomSheetViewModel) getViewModel()).getSuccessResult(), new RedeemVoucherBottomSheetView$observatory$1(this));
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ApiContainer apiContainer = AndroidComponentsKt.apiContainer((Fragment) this);
        DaggerRedeemVoucherBottomSheetViewComponent.factory().create((ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), (ObservabilityCoreLibApi) apiContainer.getFeature(ObservabilityCoreLibApi.class), (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, com.talabat.talabatcommon.R.style.VoucherBottomSheetDialogTheme);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.view_redeem_voucher_bottom_sheet, viewGroup, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ((ImageView) _$_findCachedViewById(R.id.closeBottomSheet)).setOnClickListener(new b(this));
        showLoading();
        ((RedeemVoucherBottomSheetViewModel) getViewModel()).getVoucherData(this.isCustomerLoggedIn, this.voucherCode);
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public final void showDialog(@NotNull FragmentManager fragmentManager, @Nullable String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        if (!isVisible()) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag).commitNow();
            }
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commit();
        }
    }

    @NotNull
    public RedeemVoucherBottomSheetViewModel viewModelBuilder() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return RedeemVoucherBottomSheetViewModelBuilderKt.getRedeemVoucherBottomSheetViewModel(requireContext, getConfigurationLocalRepository(), getObservabilityManager(), getTalabatFeatureFlag());
    }
}
