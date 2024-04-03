package com.talabat.talabatlife.ui.redeemAndPay;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.integration.IntegrationGlobalDataModel;
import com.integration.tLife.IntegrationAppTrackerTLife;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.Country;
import com.talabat.configuration.location.LocationExtensionsKt;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.extentions.SafeLetKt;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletDebitRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletPaymentFeature;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletVerifyQRCodeRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentTransactionStatus;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListBottomSheet;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentWidgetDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletVerifyQRCodeDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModel;
import com.talabat.talabatcore.BaseFragmentVB;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatlife.databinding.FragRedeemAndPayBinding;
import com.talabat.talabatlife.features.offers.model.redeem.RedeemOfferRequestModel;
import com.talabat.talabatlife.features.offers.model.transactionDetails.request.OfferTransactionDetailsRequestModel;
import com.talabat.talabatlife.ui.redeemAndPay.model.RedeemAndPayDisplayModel;
import com.talabat.talabatlife.ui.redeemAndPay.model.RedeemOfferDisplayModel;
import com.talabat.talabatlife.ui.redeemAndPay.viewModel.RedeemAndPayViewModel;
import com.talabat.talabatlife.ui.redeemAndPay.viewModel.RedeemAndPayViewModelBuilder;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferListDisplayModel;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import iw.b;
import iw.c;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0011H\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J\b\u0010)\u001a\u00020\u001fH\u0002J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020+H\u0016J\b\u0010,\u001a\u00020\u0011H\u0016J\b\u0010-\u001a\u00020\u0011H\u0002J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\tH\u0016J\u0010\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\tH\u0002J\b\u00103\u001a\u00020\u0011H\u0002J\b\u00104\u001a\u00020\u0011H\u0002J\b\u00105\u001a\u00020\u0011H\u0002J\b\u00106\u001a\u00020\u0011H\u0016J\b\u00107\u001a\u00020\u0011H\u0016J\u0012\u00108\u001a\u00020\u00112\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020\u0011H\u0016J\u001a\u0010<\u001a\u00020\u00112\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010A\u001a\u00020\u0011H\u0002J\u0010\u0010B\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u001fH\u0002J\b\u0010D\u001a\u00020\u0011H\u0002J\u0010\u0010E\u001a\u00020\u00112\u0006\u0010F\u001a\u00020/H\u0002J\u0012\u0010G\u001a\u00020\u00112\b\u0010H\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010I\u001a\u00020\u0011H\u0016J\u0010\u0010J\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u001fH\u0002J\u0012\u0010K\u001a\u00020\u00112\b\u0010L\u001a\u0004\u0018\u00010MH\u0002J\u0012\u0010N\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010O\u001a\u00020\u00112\b\u0010P\u001a\u0004\u0018\u00010'H\u0002J\u0012\u0010Q\u001a\u00020\u00112\b\u0010R\u001a\u0004\u0018\u00010SH\u0002J\u0010\u0010T\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\tH\u0016J\u0012\u0010V\u001a\u00020\u00112\b\u0010W\u001a\u0004\u0018\u00010XH\u0002J\u0012\u0010Y\u001a\u00020\u00112\b\u0010Z\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010[\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020:H\u0016J\u0012\u0010]\u001a\u00020\u00112\b\u0010^\u001a\u0004\u0018\u00010_H\u0002J\b\u0010`\u001a\u00020\u0002H\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u000e\u0010\u000f¨\u0006a"}, d2 = {"Lcom/talabat/talabatlife/ui/redeemAndPay/RedeemAndPayFragment;", "Lcom/talabat/talabatcore/BaseFragmentVB;", "Lcom/talabat/talabatlife/ui/redeemAndPay/viewModel/RedeemAndPayViewModel;", "Lcom/talabat/talabatlife/databinding/FragRedeemAndPayBinding;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/DefaultCardView$DefaultCardViewFullScreenInterface;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListBottomSheet$CardListBottomSheetInterface;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentOptionView$AddCardInterface;", "()V", "apiLoadingCount", "", "redeemAndPayDisplayModel", "Lcom/talabat/talabatlife/ui/redeemAndPay/model/RedeemAndPayDisplayModel;", "value", "selectedOfferId", "setSelectedOfferId", "(I)V", "addWalletPaymentWidgetObservers", "", "continueToMakePayment", "defaultMode", "disableRedeemAndPayButton", "enableRedeemAndPayButton", "extractIntentData", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "fireOnTLifeCheckoutLoadedEvent", "fireOnTLifeTransactionClicked", "fireOnTransactionSuccessEvent", "fireOnTransactionSuccessFailed", "formatAmount", "", "amount", "", "freeCoffeeMode", "getOfferID", "getOfferListAdaptor", "Lcom/talabat/talabatlife/ui/redeemAndPay/PaymentOfferListAdaptor;", "it", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferListDisplayModel;", "getOfferName", "getOffersSize", "getViewModelClass", "Ljava/lang/Class;", "hideProgress", "initiateRedeemOffer", "isFreeCoffeeModeEnabled", "", "layoutId", "loadTransactionDetails", "offerId", "loadVendorOffers", "navigateToAddCard", "navigateToPaymentConfirmation", "observatory", "onAddCardClicked", "onChangeClicked", "cardListData", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "populateUi", "redeemOffer", "walletTransactionId", "setup", "shouldEnableRedeemAndPayButton", "isPaymentReady", "showErrorMessage", "message", "showProgress", "showQRCodeVerificationErrorMessage", "updateButton", "walletPaymentWidgetDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentWidgetDisplayModel;", "updateFailureMessage", "updateOffers", "offerListDisplayModel", "updatePaymentStatus", "walletPaymentDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentDisplayModel;", "updatePositionClicked", "position", "updateRedeemOfferDetails", "offerRedeemed", "Lcom/talabat/talabatlife/ui/redeemAndPay/model/RedeemOfferDisplayModel;", "updateTransactionDetails", "transactionDetails", "updateWalletCardList", "walletCardListDisplayModel", "updateWalletQRCodeStatus", "walletVerifyQRCodeDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletVerifyQRCodeDisplayModel;", "viewModelBuilder", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemAndPayFragment extends BaseFragmentVB implements DefaultCardView.DefaultCardViewFullScreenInterface, CardListBottomSheet.CardListBottomSheetInterface, WalletPaymentOptionView.AddCardInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private int apiLoadingCount;
    /* access modifiers changed from: private */
    @NotNull
    public RedeemAndPayDisplayModel redeemAndPayDisplayModel;
    private int selectedOfferId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WalletPaymentTransactionStatus.values().length];
            iArr[WalletPaymentTransactionStatus.SUCCESS.ordinal()] = 1;
            iArr[WalletPaymentTransactionStatus.FAIL.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RedeemAndPayFragment() {
        super(AnonymousClass1.INSTANCE);
        this.redeemAndPayDisplayModel = new RedeemAndPayDisplayModel();
        this.selectedOfferId = -1;
    }

    private final void addWalletPaymentWidgetObservers() {
        LifecycleKt.observe(this, ((WalletPaymentOptionViewModel) ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.getViewModel()).getWalletWidgetConfigData(), new RedeemAndPayFragment$addWalletPaymentWidgetObservers$1(this));
        LifecycleKt.observe(this, ((WalletPaymentOptionViewModel) ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.getViewModel()).getWalletDebitData(), new RedeemAndPayFragment$addWalletPaymentWidgetObservers$2(this));
        LifecycleKt.observe(this, ((WalletPaymentOptionViewModel) ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.getViewModel()).getWalletVerifyQRCodeData(), new RedeemAndPayFragment$addWalletPaymentWidgetObservers$3(this));
        LifecycleKt.observe(this, ((WalletPaymentOptionViewModel) ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.getViewModel()).getFailureData(), new RedeemAndPayFragment$addWalletPaymentWidgetObservers$4(this));
    }

    private final void continueToMakePayment() {
        showProgress();
        disableRedeemAndPayButton();
        WalletDebitRequestModel walletDebitRequestModel = new WalletDebitRequestModel(FloatKt.orZero(this.redeemAndPayDisplayModel.getTotal()), (Integer) null, 0, 0, WalletPaymentFeature.TLIFE_REDEMPTION.getValue(), (String) null, this.redeemAndPayDisplayModel.getVendorId(), 0, (String) null, IntegrationGlobalDataModel.Companion.selectedCountryCode(), (String) null, 1454, (DefaultConstructorMarker) null);
        WalletPaymentOptionView walletPaymentOptionView = ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption;
        Intrinsics.checkNotNullExpressionValue(walletPaymentOptionView, "binding.payment.redeemAndPayPaymentOption");
        WalletPaymentOptionView.payAmountThroughWallet$default(walletPaymentOptionView, getFragmentManager(), walletDebitRequestModel, false, 4, (Object) null);
    }

    private final void defaultMode() {
        ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.setVisibility(0);
        ((FragRedeemAndPayBinding) getBinding()).payment.titlePayWith.setVisibility(0);
        ((FragRedeemAndPayBinding) getBinding()).paymentSummarySpacer.setVisibility(8);
        ((FragRedeemAndPayBinding) getBinding()).redeemAndPayButtonLabel.setText(getString(R.string.redeemAndPay));
    }

    private final void disableRedeemAndPayButton() {
        ((FragRedeemAndPayBinding) getBinding()).redeemAndPayRedeemButton.setEnabled(false);
        ((FragRedeemAndPayBinding) getBinding()).redeemAndPayRedeemButton.setAlpha(0.5f);
    }

    private final void enableRedeemAndPayButton() {
        hideProgress();
        ((FragRedeemAndPayBinding) getBinding()).redeemAndPayRedeemButton.setEnabled(true);
        ((FragRedeemAndPayBinding) getBinding()).redeemAndPayRedeemButton.setAlpha(1.0f);
    }

    private final RedeemAndPayDisplayModel extractIntentData() {
        RedeemAndPayDisplayModel redeemAndPayDisplayModel2 = new RedeemAndPayDisplayModel();
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(TLifeNavigationActions.EXTRA_REDEEM_AND_PAY_MERCHANT_NAME);
            String str = "";
            if (string == null) {
                string = str;
            }
            redeemAndPayDisplayModel2.setMerchantName(string);
            redeemAndPayDisplayModel2.setAmount(FloatKt.orZero(Float.valueOf(arguments.getFloat("amount"))));
            redeemAndPayDisplayModel2.setDiscount(FloatKt.orZero(Float.valueOf(arguments.getFloat("discount"))));
            redeemAndPayDisplayModel2.setBrandId(IntKt.orZero(Integer.valueOf(arguments.getInt("brandId"))));
            String string2 = arguments.getString("vendorId");
            if (string2 == null) {
                string2 = str;
            }
            redeemAndPayDisplayModel2.setVendorId(string2);
            redeemAndPayDisplayModel2.setSelectedOfferIndex(arguments.getInt(TLifeNavigationActions.EXTRA_REDEEM_AND_PAY_OFFER_SELECTION, -1));
            String string3 = arguments.getString("merchantTransactionId");
            if (string3 != null) {
                str = string3;
            }
            redeemAndPayDisplayModel2.setMerchantTransactionId(str);
            redeemAndPayDisplayModel2.setFree(arguments.getBoolean(TLifeNavigationActions.EXTRA_IS_FREE_COFFEE_MODE));
        }
        return redeemAndPayDisplayModel2;
    }

    private final void fireOnTLifeCheckoutLoadedEvent() {
        SafeLetKt.safeLet(this.redeemAndPayDisplayModel.getVendorOffersData(), Float.valueOf(this.redeemAndPayDisplayModel.getDiscount()), new RedeemAndPayFragment$fireOnTLifeCheckoutLoadedEvent$1(this));
    }

    private final void fireOnTLifeTransactionClicked() {
        if (getContext() != null) {
            IntegrationAppTrackerTLife.Companion.onTLifeTransactionClicked(this.redeemAndPayDisplayModel.getMerchantName(), String.valueOf(this.redeemAndPayDisplayModel.getBrandId()), getOffersSize(), getOfferID(), ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.getSelectedPaymentMethod().toString(), String.valueOf(this.redeemAndPayDisplayModel.getAmount()), getOfferName(), String.valueOf(this.redeemAndPayDisplayModel.getDiscount()), getOfferID());
        }
    }

    private final void fireOnTransactionSuccessEvent() {
        if (getContext() != null) {
            IntegrationAppTrackerTLife.Companion.onTLifeTransactionSuccess(this.redeemAndPayDisplayModel.getMerchantName(), String.valueOf(this.redeemAndPayDisplayModel.getBrandId()), getOffersSize(), getOfferID(), ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.getSelectedPaymentMethod().toString(), String.valueOf(this.redeemAndPayDisplayModel.getAmount()), getOfferName(), String.valueOf(this.redeemAndPayDisplayModel.getDiscount()), getOfferID(), String.valueOf(this.redeemAndPayDisplayModel.getAmount()));
        }
    }

    private final void fireOnTransactionSuccessFailed() {
        if (getContext() != null) {
            IntegrationAppTrackerTLife.Companion.onTLifeTransactionFailed(this.redeemAndPayDisplayModel.getMerchantName(), String.valueOf(this.redeemAndPayDisplayModel.getBrandId()), getOffersSize(), getOfferID(), ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.getSelectedPaymentMethod().toString(), String.valueOf(this.redeemAndPayDisplayModel.getAmount()), getOfferName(), String.valueOf(this.redeemAndPayDisplayModel.getDiscount()), getOfferID());
        }
    }

    private final String formatAmount(float f11) {
        Country selectedCountry = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class)).getLocationConfigurationRepository().selectedCountry();
        Intrinsics.checkNotNull(selectedCountry);
        return CurrencyFormatter.Companion.getFormattedCurrency((double) f11, true, selectedCountry.getCurrencyCode(), selectedCountry.getNumberOfDecimalPlaces(), LocationExtensionsKt.decimalPattern(selectedCountry));
    }

    private final void freeCoffeeMode() {
        ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.setVisibility(8);
        ((FragRedeemAndPayBinding) getBinding()).payment.titlePayWith.setVisibility(8);
        ((FragRedeemAndPayBinding) getBinding()).paymentSummarySpacer.setVisibility(0);
        ((FragRedeemAndPayBinding) getBinding()).redeemAndPayButtonLabel.setText(getString(R.string.redeem));
    }

    /* access modifiers changed from: private */
    public final String getOfferID() {
        VendorOfferListDisplayModel vendorOffersData;
        List<VendorOfferDisplayModel> offerList;
        Object obj;
        String num;
        boolean z11;
        if (this.selectedOfferId == -1 || (vendorOffersData = this.redeemAndPayDisplayModel.getVendorOffersData()) == null || (offerList = vendorOffersData.getOfferList()) == null) {
            return "N/A";
        }
        Iterator it = offerList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((VendorOfferDisplayModel) obj).getId() == this.selectedOfferId) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        VendorOfferDisplayModel vendorOfferDisplayModel = (VendorOfferDisplayModel) obj;
        if (vendorOfferDisplayModel == null || (num = Integer.valueOf(vendorOfferDisplayModel.getId()).toString()) == null) {
            return "N/A";
        }
        return num;
    }

    private final PaymentOfferListAdaptor getOfferListAdaptor(VendorOfferListDisplayModel vendorOfferListDisplayModel) {
        if (this.redeemAndPayDisplayModel.getSelectedOfferIndex() != -1 && vendorOfferListDisplayModel.getOfferList().size() > 0 && this.redeemAndPayDisplayModel.getSelectedOfferIndex() < vendorOfferListDisplayModel.getOfferList().size()) {
            vendorOfferListDisplayModel.getOfferList().get(this.redeemAndPayDisplayModel.getSelectedOfferIndex()).setSelected(true);
        }
        PaymentOfferListAdaptor paymentOfferListAdaptor = new PaymentOfferListAdaptor(vendorOfferListDisplayModel.getOfferList());
        paymentOfferListAdaptor.setVendorClickListener(new RedeemAndPayFragment$getOfferListAdaptor$1$1(this));
        return paymentOfferListAdaptor;
    }

    /* access modifiers changed from: private */
    public final String getOfferName() {
        VendorOfferListDisplayModel vendorOffersData;
        List<VendorOfferDisplayModel> offerList;
        Object obj;
        String title;
        boolean z11;
        if (this.selectedOfferId == -1 || (vendorOffersData = this.redeemAndPayDisplayModel.getVendorOffersData()) == null || (offerList = vendorOffersData.getOfferList()) == null) {
            return "N/A";
        }
        Iterator it = offerList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((VendorOfferDisplayModel) obj).getId() == this.selectedOfferId) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        VendorOfferDisplayModel vendorOfferDisplayModel = (VendorOfferDisplayModel) obj;
        if (vendorOfferDisplayModel == null || (title = vendorOfferDisplayModel.getTitle()) == null) {
            return "N/A";
        }
        return title;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = java.lang.Integer.valueOf((r0 = r0.getOfferList()).size()).toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getOffersSize() {
        /*
            r1 = this;
            com.talabat.talabatlife.ui.redeemAndPay.model.RedeemAndPayDisplayModel r0 = r1.redeemAndPayDisplayModel
            com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferListDisplayModel r0 = r0.getVendorOffersData()
            if (r0 == 0) goto L_0x001c
            java.util.List r0 = r0.getOfferList()
            if (r0 == 0) goto L_0x001c
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x001e
        L_0x001c:
            java.lang.String r0 = "N/A"
        L_0x001e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatlife.ui.redeemAndPay.RedeemAndPayFragment.getOffersSize():java.lang.String");
    }

    private final void initiateRedeemOffer() {
        ((WalletPaymentOptionViewModel) ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.getViewModel()).verifyQRCode(new WalletVerifyQRCodeRequestModel(this.redeemAndPayDisplayModel.getMerchantTransactionId(), 0, 2, (DefaultConstructorMarker) null));
    }

    private final boolean isFreeCoffeeModeEnabled() {
        return this.redeemAndPayDisplayModel.isFree() && Intrinsics.areEqual(this.redeemAndPayDisplayModel.getTotal(), 0.0f);
    }

    /* access modifiers changed from: private */
    public final void loadTransactionDetails(int i11) {
        showProgress();
        ((RedeemAndPayViewModel) getViewModel()).getOfferTransactionDetail(new OfferTransactionDetailsRequestModel(i11, this.redeemAndPayDisplayModel.getMerchantTransactionId()));
    }

    private final void loadVendorOffers() {
        showProgress();
        RedeemAndPayViewModel.getVendorOffers$default((RedeemAndPayViewModel) getViewModel(), this.redeemAndPayDisplayModel.getBrandId(), 0, 2, (Object) null);
    }

    private final void navigateToAddCard() {
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, TLifeNavigationActions.Companion.createNavigationToWalletAddCard("talabat.action.talabat.life.vendor.payment"));
        }
    }

    private final void navigateToPaymentConfirmation() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (isFreeCoffeeModeEnabled()) {
                TLifeNavigationActions.Companion.navigateToFreeCoffeeSuccess(Navigator.Companion, activity);
            } else {
                Navigator.Companion.navigate((Context) activity, new NavigatorModel(TLifeNavigationActions.OPEN_TALABAT_LIFE_VENDOR_PAYMENT_CONFIRMATION, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
            }
            activity.finish();
        }
    }

    private final void populateUi() {
        ((FragRedeemAndPayBinding) getBinding()).vendorOffers.redeemAndPayBrandTitleTextView.setText(this.redeemAndPayDisplayModel.getMerchantName());
        ((FragRedeemAndPayBinding) getBinding()).vendorOffers.redeemAndPayAmountTextView.setText(formatAmount(this.redeemAndPayDisplayModel.getAmount()));
        loadVendorOffers();
        if (isFreeCoffeeModeEnabled()) {
            freeCoffeeMode();
            return;
        }
        try {
            WalletPaymentOptionView walletPaymentOptionView = ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption;
            Intrinsics.checkNotNullExpressionValue(walletPaymentOptionView, "binding.payment.redeemAndPayPaymentOption");
            WalletPaymentOptionView.addPaymentMethodView$default(walletPaymentOptionView, Float.valueOf(this.redeemAndPayDisplayModel.getAmount()), false, false, true, 6, (Object) null);
            ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.setDefaultCardViewFullScreenListener(this, true, false);
            ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.setAddCardListener(this);
            ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.resetObservers();
        } catch (Exception unused) {
        }
    }

    private final void redeemOffer(String str) {
        ((RedeemAndPayViewModel) getViewModel()).redeemOffer(this.selectedOfferId, new RedeemOfferRequestModel(str, this.redeemAndPayDisplayModel.getMerchantTransactionId(), Integer.valueOf(IntegrationGlobalDataModel.Companion.selectedCountryCode())));
    }

    /* access modifiers changed from: private */
    public final void setSelectedOfferId(int i11) {
        if (i11 != -1 && (((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.getPaymentButtonStatus() || this.redeemAndPayDisplayModel.isFree())) {
            enableRedeemAndPayButton();
        }
        this.selectedOfferId = i11;
    }

    private final void setup() {
        ((FragRedeemAndPayBinding) getBinding()).backButton.setOnClickListener(new b(this));
        disableRedeemAndPayButton();
        ((FragRedeemAndPayBinding) getBinding()).redeemAndPayRedeemButton.setOnClickListener(new c(this));
        Context context = getContext();
        if (context != null) {
            ((FragRedeemAndPayBinding) getBinding()).vendorOffers.redeemAndPayOffersRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setup$lambda-6  reason: not valid java name */
    public static final void m5839setup$lambda6(RedeemAndPayFragment redeemAndPayFragment, View view) {
        Intrinsics.checkNotNullParameter(redeemAndPayFragment, "this$0");
        FragmentActivity activity = redeemAndPayFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setup$lambda-7  reason: not valid java name */
    public static final void m5840setup$lambda7(RedeemAndPayFragment redeemAndPayFragment, View view) {
        Intrinsics.checkNotNullParameter(redeemAndPayFragment, "this$0");
        redeemAndPayFragment.disableRedeemAndPayButton();
        redeemAndPayFragment.initiateRedeemOffer();
        redeemAndPayFragment.fireOnTLifeTransactionClicked();
    }

    private final void shouldEnableRedeemAndPayButton(boolean z11) {
        if (!z11 || this.selectedOfferId == -1) {
            disableRedeemAndPayButton();
        } else {
            enableRedeemAndPayButton();
        }
    }

    private final void showErrorMessage(String str) {
        hideProgress();
        ((FragRedeemAndPayBinding) getBinding()).paymentProgressAnimation.setVisibility(4);
        Status.Companion companion = Status.Companion;
        FragmentActivity activity = getActivity();
        LinearLayout linearLayout = ((FragRedeemAndPayBinding) getBinding()).errorNotifyLinearLayout;
        if (str == null) {
            str = getString(R.string.failure_server_error);
            Intrinsics.checkNotNullExpressionValue(str, "getString(com.talabat.lo…ing.failure_server_error)");
        }
        Status.Companion.notify$default(companion, activity, linearLayout, str, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 56, (Object) null);
        enableRedeemAndPayButton();
    }

    private final void showQRCodeVerificationErrorMessage(String str) {
        showErrorMessage(str);
    }

    /* access modifiers changed from: private */
    public final void updateButton(WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel) {
        if (walletPaymentWidgetDisplayModel != null) {
            shouldEnableRedeemAndPayButton(walletPaymentWidgetDisplayModel.getShouldEnablePaymentButton());
        }
    }

    /* access modifiers changed from: private */
    public final void updateFailureMessage(Failure failure) {
        if (failure != null) {
            hideProgress();
            showErrorMessage((String) null);
        }
    }

    /* access modifiers changed from: private */
    public final void updateOffers(VendorOfferListDisplayModel vendorOfferListDisplayModel) {
        this.redeemAndPayDisplayModel.setVendorOffersData(vendorOfferListDisplayModel);
        hideProgress();
        if (vendorOfferListDisplayModel != null) {
            ((FragRedeemAndPayBinding) getBinding()).vendorOffers.redeemAndPayOffersRecyclerView.setAdapter(getOfferListAdaptor(vendorOfferListDisplayModel));
        }
        fireOnTLifeCheckoutLoadedEvent();
    }

    /* access modifiers changed from: private */
    public final void updatePaymentStatus(WalletPaymentDisplayModel walletPaymentDisplayModel) {
        if (walletPaymentDisplayModel != null) {
            int i11 = WhenMappings.$EnumSwitchMapping$0[walletPaymentDisplayModel.getWalletTransactionStatus().ordinal()];
            if (i11 == 1) {
                String walletTransactionId = ((WalletPaymentOptionViewModel) ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.getViewModel()).getWalletTransactionId();
                if (walletTransactionId == null) {
                    walletTransactionId = walletPaymentDisplayModel.getWalletTransactionId();
                }
                redeemOffer(walletTransactionId);
            } else if (i11 != 2) {
                LogManager.debug("unsupported transaction status");
            } else {
                String walletTransactionId2 = ((WalletPaymentOptionViewModel) ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.getViewModel()).getWalletTransactionId();
                if (walletTransactionId2 == null) {
                    walletTransactionId2 = walletPaymentDisplayModel.getWalletTransactionId();
                }
                redeemOffer(walletTransactionId2);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateRedeemOfferDetails(RedeemOfferDisplayModel redeemOfferDisplayModel) {
        ((FragRedeemAndPayBinding) getBinding()).paymentProgressAnimation.setVisibility(4);
        if (redeemOfferDisplayModel == null) {
            return;
        }
        if (redeemOfferDisplayModel.getResult()) {
            navigateToPaymentConfirmation();
            fireOnTransactionSuccessEvent();
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Status.Companion.notify$default(Status.Companion, activity, (ViewGroup) null, redeemOfferDisplayModel.getErrors()[0], (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 58, (Object) null);
        }
        fireOnTransactionSuccessFailed();
    }

    /* access modifiers changed from: private */
    public final void updateTransactionDetails(RedeemAndPayDisplayModel redeemAndPayDisplayModel2) {
        hideProgress();
        if (redeemAndPayDisplayModel2 != null) {
            this.redeemAndPayDisplayModel.setDiscount(redeemAndPayDisplayModel2.getDiscount());
            this.redeemAndPayDisplayModel.setTotal(redeemAndPayDisplayModel2.getTotal());
            this.redeemAndPayDisplayModel.setSubTotal(redeemAndPayDisplayModel2.getSubTotal());
            ((FragRedeemAndPayBinding) getBinding()).paymentSummary.redeemAndPayDiscountTextView.setText(formatAmount(redeemAndPayDisplayModel2.getDiscount()));
            ((FragRedeemAndPayBinding) getBinding()).paymentSummary.redeemAndPayTotalAmountTextView.setText(formatAmount(FloatKt.orZero(redeemAndPayDisplayModel2.getTotal())));
            ((FragRedeemAndPayBinding) getBinding()).paymentSummary.redeemAndPaySubTotalTextView.setText(formatAmount(redeemAndPayDisplayModel2.getSubTotal()));
            ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.updateAmount(FloatKt.orZero(redeemAndPayDisplayModel2.getTotal()));
            if (isFreeCoffeeModeEnabled()) {
                freeCoffeeMode();
            } else {
                defaultMode();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateWalletQRCodeStatus(WalletVerifyQRCodeDisplayModel walletVerifyQRCodeDisplayModel) {
        if (walletVerifyQRCodeDisplayModel == null) {
            return;
        }
        if (!walletVerifyQRCodeDisplayModel.getStatus()) {
            showQRCodeVerificationErrorMessage(walletVerifyQRCodeDisplayModel.getMessage());
        } else if (isFreeCoffeeModeEnabled()) {
            showProgress();
            redeemOffer("00000000-0000-0000-0000-000000000000");
        } else {
            continueToMakePayment();
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

    public void failureHere(@Nullable Failure failure) {
        hideProgress();
        ((FragRedeemAndPayBinding) getBinding()).paymentProgressAnimation.setVisibility(4);
        Status.Companion companion = Status.Companion;
        FragmentActivity activity = getActivity();
        LinearLayout linearLayout = ((FragRedeemAndPayBinding) getBinding()).errorNotifyLinearLayout;
        String string = getString(R.string.failure_server_error);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ing.failure_server_error)");
        Status.Companion.notify$default(companion, activity, linearLayout, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 56, (Object) null);
    }

    @NotNull
    public Class<RedeemAndPayViewModel> getViewModelClass() {
        return RedeemAndPayViewModel.class;
    }

    public void hideProgress() {
        int i11 = this.apiLoadingCount - 1;
        this.apiLoadingCount = i11;
        if (i11 < 0) {
            this.apiLoadingCount = 0;
        }
        if (this.apiLoadingCount == 0) {
            ((FragRedeemAndPayBinding) getBinding()).progressAnimation.setVisibility(4);
        }
    }

    public int layoutId() {
        return com.talabat.talabatlife.R.layout.frag_redeem_and_pay;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((RedeemAndPayViewModel) getViewModel()).getVendorOffersData(), new RedeemAndPayFragment$observatory$1(this));
        LifecycleKt.observe(this, ((RedeemAndPayViewModel) getViewModel()).getOffersTransactionData(), new RedeemAndPayFragment$observatory$2(this));
        LifecycleKt.observe(this, ((RedeemAndPayViewModel) getViewModel()).getRedeemOfferData(), new RedeemAndPayFragment$observatory$3(this));
        addWalletPaymentWidgetObservers();
    }

    public void onAddCardClicked() {
        navigateToAddCard();
    }

    public void onChangeClicked(@Nullable WalletCardListDisplayModel walletCardListDisplayModel) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            DefaultCardView.Companion.showCardListBottomSheet(fragmentManager, walletCardListDisplayModel, this, DefaultCardView.REDEEM_AND_PAY_SOURCE);
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onResume() {
        super.onResume();
        if (this.redeemAndPayDisplayModel.getTotal() != null) {
            WalletPaymentOptionView walletPaymentOptionView = ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption;
            Intrinsics.checkNotNullExpressionValue(walletPaymentOptionView, "binding.payment.redeemAndPayPaymentOption");
            WalletPaymentOptionView.addPaymentMethodView$default(walletPaymentOptionView, this.redeemAndPayDisplayModel.getTotal(), false, false, true, 6, (Object) null);
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.redeemAndPayDisplayModel = extractIntentData();
        setup();
        populateUi();
    }

    public void showProgress() {
        ((FragRedeemAndPayBinding) getBinding()).progressAnimation.setVisibility(0);
        this.apiLoadingCount++;
    }

    public void updatePositionClicked(int i11) {
        ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.updateClickedPositionData(i11);
    }

    public void updateWalletCardList(@NotNull WalletCardListDisplayModel walletCardListDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardListDisplayModel, "walletCardListDisplayModel");
        ((FragRedeemAndPayBinding) getBinding()).payment.redeemAndPayPaymentOption.updateWalletCardListData(walletCardListDisplayModel);
    }

    @NotNull
    public RedeemAndPayViewModel viewModelBuilder() {
        RedeemAndPayViewModelBuilder.Companion companion = RedeemAndPayViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.getRedeemAndPayViewModel(requireContext, getCoroutineScope());
    }
}
