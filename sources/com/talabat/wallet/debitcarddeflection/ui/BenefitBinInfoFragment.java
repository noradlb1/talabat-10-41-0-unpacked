package com.talabat.wallet.debitcarddeflection.ui;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import com.designsystem.ds_button.DSPrimaryButton;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.talabatcommon.utils.DateUtils;
import com.talabat.wallet.R;
import com.talabat.wallet.debitcarddeflection.ui.di.DaggerBenefitBinInfoFragmentComponent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.a;
import rx.b;

@Instrumented
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\u000eH\u0002R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/talabat/wallet/debitcarddeflection/ui/BenefitBinInfoFragment;", "Landroidx/fragment/app/Fragment;", "expiryDate", "", "debitCardBinInfoFragmentInterface", "Lcom/talabat/wallet/debitcarddeflection/ui/BenefitBinInfoFragment$DebitCardBinInfoFragmentInterface;", "(Ljava/lang/String;Lcom/talabat/wallet/debitcarddeflection/ui/BenefitBinInfoFragment$DebitCardBinInfoFragmentInterface;)V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "cancelButtonClickListener", "", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "proceedToBenefitOnClickListener", "showBenefitItemList", "showQPayItemList", "DebitCardBinInfoFragmentInterface", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BenefitBinInfoFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final DebitCardBinInfoFragmentInterface debitCardBinInfoFragmentInterface;
    @NotNull
    private final String expiryDate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/debitcarddeflection/ui/BenefitBinInfoFragment$DebitCardBinInfoFragmentInterface;", "", "closeBottomSheet", "", "placeOrderWithBenefit", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface DebitCardBinInfoFragmentInterface {
        void closeBottomSheet();

        void placeOrderWithBenefit();
    }

    public BenefitBinInfoFragment(@NotNull String str, @NotNull DebitCardBinInfoFragmentInterface debitCardBinInfoFragmentInterface2) {
        Intrinsics.checkNotNullParameter(str, "expiryDate");
        Intrinsics.checkNotNullParameter(debitCardBinInfoFragmentInterface2, "debitCardBinInfoFragmentInterface");
        this.expiryDate = str;
        this.debitCardBinInfoFragmentInterface = debitCardBinInfoFragmentInterface2;
    }

    private final void cancelButtonClickListener() {
        ((ImageView) _$_findCachedViewById(R.id.close)).setOnClickListener(new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: cancelButtonClickListener$lambda-0  reason: not valid java name */
    public static final void m5952cancelButtonClickListener$lambda0(BenefitBinInfoFragment benefitBinInfoFragment, View view) {
        Intrinsics.checkNotNullParameter(benefitBinInfoFragment, "this$0");
        benefitBinInfoFragment.debitCardBinInfoFragmentInterface.closeBottomSheet();
    }

    private final void proceedToBenefitOnClickListener() {
        ((DSPrimaryButton) _$_findCachedViewById(R.id.proceed_with_place_order)).setOnClickListener(new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: proceedToBenefitOnClickListener$lambda-1  reason: not valid java name */
    public static final void m5953proceedToBenefitOnClickListener$lambda1(BenefitBinInfoFragment benefitBinInfoFragment, View view) {
        Intrinsics.checkNotNullParameter(benefitBinInfoFragment, "this$0");
        benefitBinInfoFragment.debitCardBinInfoFragmentInterface.placeOrderWithBenefit();
    }

    private final void showBenefitItemList() {
        CharSequence text = getText(com.talabat.localization.R.string.benefit_bin_info2);
        Intrinsics.checkNotNullExpressionValue(text, "getText(com.talabat.loca…string.benefit_bin_info2)");
        CharSequence text2 = getText(com.talabat.localization.R.string.benefit_deflection_expiry_date);
        Intrinsics.checkNotNullExpressionValue(text2, "getText(com.talabat.loca…t_deflection_expiry_date)");
        String localizedFormattedDateString = DateUtils.Companion.getLocalizedFormattedDateString(this.expiryDate, DebitCardBinInfoFragmentKt.EXPIRY_DATE_FORMAT);
        ((TextView) _$_findCachedViewById(R.id.benefit_bin_info_content2)).setText(HtmlCompat.fromHtml("<b>" + text2 + "  " + localizedFormattedDateString + "</b> " + text, 0));
    }

    private final void showQPayItemList() {
        CharSequence text = getText(com.talabat.localization.R.string.qpay_bin_info2);
        Intrinsics.checkNotNullExpressionValue(text, "getText(com.talabat.loca….R.string.qpay_bin_info2)");
        CharSequence text2 = getText(com.talabat.localization.R.string.benefit_deflection_expiry_date);
        Intrinsics.checkNotNullExpressionValue(text2, "getText(com.talabat.loca…t_deflection_expiry_date)");
        String localizedFormattedDateString = DateUtils.Companion.getLocalizedFormattedDateString(this.expiryDate, DebitCardBinInfoFragmentKt.EXPIRY_DATE_FORMAT);
        ((TextView) _$_findCachedViewById(R.id.benefit_bin_info_content2)).setText(HtmlCompat.fromHtml("<b>" + text2 + "  " + localizedFormattedDateString + "</b> " + text, 0));
        ((TextView) _$_findCachedViewById(R.id.benefit_bin_info_content1)).setText(getText(com.talabat.localization.R.string.qpay_bin_info1));
        ((TextView) _$_findCachedViewById(R.id.benefit_info_header)).setText(getText(com.talabat.localization.R.string.important_update_about_qpay_cards));
        String string = getString(com.talabat.localization.R.string.pay_with_qpay);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…n.R.string.pay_with_qpay)");
        ((DSPrimaryButton) _$_findCachedViewById(R.id.proceed_with_place_order)).setCenterText(string);
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
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        ConfigurationLocalRepository configurationLocalRepository2 = this.configurationLocalRepository;
        if (configurationLocalRepository2 != null) {
            return configurationLocalRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalRepository");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Application application = requireActivity().getApplication();
        if (application != null) {
            DaggerBenefitBinInfoFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) ((ApiContainer) application).getFeature(ConfigurationLocalCoreLibApi.class)).inject(this);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "BenefitBinInfoFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "BenefitBinInfoFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_benefit_bin_info, viewGroup, false);
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
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        cancelButtonClickListener();
        proceedToBenefitOnClickListener();
        if (getConfigurationLocalRepository().selectedCountry() == Country.QATAR) {
            showQPayItemList();
        } else {
            showBenefitItemList();
        }
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }
}
