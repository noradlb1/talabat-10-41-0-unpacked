package com.talabat.talabatlife.ui.onBoarding.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.core.network.endpoint.TLifeEndPointProvider;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletPaymentFeature;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.PaymentInfoDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletBottomSheetPaymentMode;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import com.talabat.talabatlife.features.UrlConstantsKt;
import com.talabat.talabatlife.features.subscription.model.request.SubscriptionPaymentRequestModel;
import com.talabat.talabatlife.ui.onBoarding.model.TLifeOnBoardingPlanDisplayModel;
import com.talabat.talabatlife.ui.onBoarding.model.TLifeOnBoardingWaitListDisplayModel;
import com.talabat.talabatlife.ui.subscription.model.SubscriptionPaymentDisplayModel;
import com.talabat.talabatlife.ui.vendorList.model.VendorListDisplayModel;
import java.util.Calendar;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0011J\u0018\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0004J\u0012\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u000205H&J\u0012\u00106\u001a\u0002032\b\b\u0002\u00104\u001a\u000205H&JJ\u00107\u001a\u0002032\b\b\u0002\u00104\u001a\u0002052\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010:\u001a\u0002052\b\b\u0002\u0010;\u001a\u0002052\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010=\u001a\u0002032\b\b\u0002\u00104\u001a\u000205H&J\u0010\u0010>\u001a\u0002032\u0006\u0010?\u001a\u00020.H&J\b\u0010@\u001a\u000203H&J\b\u0010A\u001a\u000203H&J\u0010\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020\u0004H&R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rRI\u0010\u0014\u001a0\u0012,\u0012*\u0012\u0004\u0012\u00020\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0016j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00170\u00150\b8FX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0018\u0010\u000bR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\rR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\rR \u0010#\u001a\b\u0012\u0004\u0012\u00020$0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000b\"\u0004\b&\u0010\rR \u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000b\"\u0004\b)\u0010\r¨\u0006D"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/viewModel/TLifeOnBoardingViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "bannerUrl", "", "getBannerUrl", "()Ljava/lang/String;", "joinWaitListData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/talabatlife/ui/onBoarding/model/TLifeOnBoardingWaitListDisplayModel;", "getJoinWaitListData", "()Landroidx/lifecycle/MutableLiveData;", "setJoinWaitListData", "(Landroidx/lifecycle/MutableLiveData;)V", "logoUrl", "getLogoUrl", "plansData", "Lcom/talabat/talabatlife/ui/onBoarding/model/TLifeOnBoardingPlanDisplayModel;", "getPlansData", "setPlansData", "sendFireBaseEventData", "Lkotlin/Pair;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getSendFireBaseEventData", "sendFireBaseEventData$delegate", "Lkotlin/Lazy;", "subscriptionPaymentData", "Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel;", "getSubscriptionPaymentData", "setSubscriptionPaymentData", "vendorList", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorListDisplayModel;", "getVendorList", "setVendorList", "vendorListFailure", "Lcom/talabat/talabatcore/exception/Failure;", "getVendorListFailure", "setVendorListFailure", "waitListData", "getWaitListData", "setWaitListData", "getPaymentInfoDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;", "planData", "getSubscriptionPaymentRequestModel", "Lcom/talabat/talabatlife/features/subscription/model/request/SubscriptionPaymentRequestModel;", "card", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "planId", "getTLifeOnBoardingPlans", "", "countryCode", "", "getUserWaitListState", "getVendorsList", "lat", "long", "pageNumber", "pageSize", "areaID", "joinWaitList", "payForSubscription", "requestModel", "sendSubscriptionAttemptedEvent", "sendSubscriptionClickedEvent", "sendSubscriptionFailed", "error", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class TLifeOnBoardingViewModel extends BaseViewModel {
    @NotNull
    private final String bannerUrl;
    @NotNull
    private MutableLiveData<TLifeOnBoardingWaitListDisplayModel> joinWaitListData = new MutableLiveData<>();
    @NotNull
    private final String logoUrl;
    @NotNull
    private MutableLiveData<TLifeOnBoardingPlanDisplayModel> plansData = new MutableLiveData<>();
    @NotNull
    private final Lazy sendFireBaseEventData$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, TLifeOnBoardingViewModel$sendFireBaseEventData$2.INSTANCE);
    @NotNull
    private MutableLiveData<SubscriptionPaymentDisplayModel> subscriptionPaymentData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<VendorListDisplayModel> vendorList = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Failure> vendorListFailure = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<TLifeOnBoardingWaitListDisplayModel> waitListData = new MutableLiveData<>();

    public TLifeOnBoardingViewModel() {
        TLifeEndPointProvider tLifeEndPointProvider = TLifeEndPointProvider.INSTANCE;
        String baseUrl = tLifeEndPointProvider.getBaseUrl();
        this.logoUrl = baseUrl + UrlConstantsKt.T_LIFE_LOGO_WHITE_URL;
        String baseUrl2 = tLifeEndPointProvider.getBaseUrl();
        this.bannerUrl = baseUrl2 + UrlConstantsKt.T_LIFE_BANNER;
    }

    public static /* synthetic */ void getTLifeOnBoardingPlans$default(TLifeOnBoardingViewModel tLifeOnBoardingViewModel, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i11 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
            }
            tLifeOnBoardingViewModel.getTLifeOnBoardingPlans(i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTLifeOnBoardingPlans");
    }

    public static /* synthetic */ void getUserWaitListState$default(TLifeOnBoardingViewModel tLifeOnBoardingViewModel, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i11 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
            }
            tLifeOnBoardingViewModel.getUserWaitListState(i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserWaitListState");
    }

    public static /* synthetic */ void getVendorsList$default(TLifeOnBoardingViewModel tLifeOnBoardingViewModel, int i11, String str, String str2, int i12, int i13, String str3, int i14, Object obj) {
        String str4;
        String str5;
        if (obj == null) {
            if ((i14 & 1) != 0) {
                i11 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
            }
            String str6 = null;
            if ((i14 & 2) != 0) {
                str4 = null;
            } else {
                str4 = str;
            }
            if ((i14 & 4) != 0) {
                str5 = null;
            } else {
                str5 = str2;
            }
            if ((i14 & 8) != 0) {
                i12 = 1;
            }
            int i15 = i12;
            if ((i14 & 16) != 0) {
                i13 = 10;
            }
            int i16 = i13;
            if ((i14 & 32) == 0) {
                str6 = str3;
            }
            tLifeOnBoardingViewModel.getVendorsList(i11, str4, str5, i15, i16, str6);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVendorsList");
    }

    public static /* synthetic */ void joinWaitList$default(TLifeOnBoardingViewModel tLifeOnBoardingViewModel, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i11 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
            }
            tLifeOnBoardingViewModel.joinWaitList(i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinWaitList");
    }

    @NotNull
    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    @NotNull
    public final MutableLiveData<TLifeOnBoardingWaitListDisplayModel> getJoinWaitListData() {
        return this.joinWaitListData;
    }

    @NotNull
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    public final PaymentInfoDisplayModel getPaymentInfoDisplayModel(@NotNull TLifeOnBoardingPlanDisplayModel tLifeOnBoardingPlanDisplayModel) {
        Intrinsics.checkNotNullParameter(tLifeOnBoardingPlanDisplayModel, "planData");
        PaymentInfoDisplayModel paymentInfoDisplayModel = new PaymentInfoDisplayModel((String) null, (String) null, (String) null, 0, false, (String) null, (String) null, 0.0f, (WalletBottomSheetPaymentMode) null, (String) null, (String) null, (WalletPaymentFeature) null, (String) null, false, (String) null, 0.0f, (String) null, 131071, (DefaultConstructorMarker) null);
        paymentInfoDisplayModel.setPlanId(tLifeOnBoardingPlanDisplayModel.getPlanId());
        paymentInfoDisplayModel.setPlanTitle(tLifeOnBoardingPlanDisplayModel.getPlanTitle());
        paymentInfoDisplayModel.setFreeTrialTitle(tLifeOnBoardingPlanDisplayModel.getFreeTrialTitle());
        paymentInfoDisplayModel.setFreeTrialDays(tLifeOnBoardingPlanDisplayModel.getFreeTrialDays());
        paymentInfoDisplayModel.setSubscriptionPaymentDate(tLifeOnBoardingPlanDisplayModel.getSubscriptionPaymentDate());
        paymentInfoDisplayModel.setActionText(tLifeOnBoardingPlanDisplayModel.getActionText());
        paymentInfoDisplayModel.setPlanAmount(tLifeOnBoardingPlanDisplayModel.getPlanAmount());
        paymentInfoDisplayModel.setDescription(tLifeOnBoardingPlanDisplayModel.getNextBillingText());
        paymentInfoDisplayModel.setMode(WalletBottomSheetPaymentMode.CARDDETAIL);
        paymentInfoDisplayModel.setShouldIgnoreTopUpVerification(true);
        return paymentInfoDisplayModel;
    }

    @NotNull
    public final MutableLiveData<TLifeOnBoardingPlanDisplayModel> getPlansData() {
        return this.plansData;
    }

    @NotNull
    public final MutableLiveData<Pair<String, HashMap<String, String>>> getSendFireBaseEventData() {
        return (MutableLiveData) this.sendFireBaseEventData$delegate.getValue();
    }

    @NotNull
    public final MutableLiveData<SubscriptionPaymentDisplayModel> getSubscriptionPaymentData() {
        return this.subscriptionPaymentData;
    }

    @NotNull
    public final SubscriptionPaymentRequestModel getSubscriptionPaymentRequestModel(@NotNull WalletCardDisplayModel walletCardDisplayModel, @Nullable String str) {
        Intrinsics.checkNotNullParameter(walletCardDisplayModel, "card");
        SubscriptionPaymentRequestModel subscriptionPaymentRequestModel = new SubscriptionPaymentRequestModel((String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, 127, (DefaultConstructorMarker) null);
        if (str == null) {
            str = "";
        }
        subscriptionPaymentRequestModel.setPlanId(str);
        subscriptionPaymentRequestModel.setCardTokenId(walletCardDisplayModel.getTokenId());
        subscriptionPaymentRequestModel.setCard4Digits((String) StringsKt__StringsKt.split$default((CharSequence) walletCardDisplayModel.getCardNumber(), new String[]{SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE}, false, 0, 6, (Object) null).get(1));
        subscriptionPaymentRequestModel.setCardType(walletCardDisplayModel.getCardType());
        subscriptionPaymentRequestModel.setPaymentMethod(PaymentMethod.CARD.getValue());
        String expiryMonth = walletCardDisplayModel.getExpiryMonth();
        String take = StringsKt___StringsKt.take(String.valueOf(Calendar.getInstance().get(1)), 2);
        String expiryYear = walletCardDisplayModel.getExpiryYear();
        subscriptionPaymentRequestModel.setCardExpiryDate(expiryMonth + "/" + take + expiryYear);
        return subscriptionPaymentRequestModel;
    }

    public abstract void getTLifeOnBoardingPlans(int i11);

    public abstract void getUserWaitListState(int i11);

    @NotNull
    public final MutableLiveData<VendorListDisplayModel> getVendorList() {
        return this.vendorList;
    }

    @NotNull
    public final MutableLiveData<Failure> getVendorListFailure() {
        return this.vendorListFailure;
    }

    public abstract void getVendorsList(int i11, @Nullable String str, @Nullable String str2, int i12, int i13, @Nullable String str3);

    @NotNull
    public final MutableLiveData<TLifeOnBoardingWaitListDisplayModel> getWaitListData() {
        return this.waitListData;
    }

    public abstract void joinWaitList(int i11);

    public abstract void payForSubscription(@NotNull SubscriptionPaymentRequestModel subscriptionPaymentRequestModel);

    public abstract void sendSubscriptionAttemptedEvent();

    public abstract void sendSubscriptionClickedEvent();

    public abstract void sendSubscriptionFailed(@NotNull String str);

    public final void setJoinWaitListData(@NotNull MutableLiveData<TLifeOnBoardingWaitListDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.joinWaitListData = mutableLiveData;
    }

    public final void setPlansData(@NotNull MutableLiveData<TLifeOnBoardingPlanDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.plansData = mutableLiveData;
    }

    public final void setSubscriptionPaymentData(@NotNull MutableLiveData<SubscriptionPaymentDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.subscriptionPaymentData = mutableLiveData;
    }

    public final void setVendorList(@NotNull MutableLiveData<VendorListDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.vendorList = mutableLiveData;
    }

    public final void setVendorListFailure(@NotNull MutableLiveData<Failure> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.vendorListFailure = mutableLiveData;
    }

    public final void setWaitListData(@NotNull MutableLiveData<TLifeOnBoardingWaitListDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.waitListData = mutableLiveData;
    }
}
