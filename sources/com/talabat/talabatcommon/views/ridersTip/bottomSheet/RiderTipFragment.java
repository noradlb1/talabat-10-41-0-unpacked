package com.talabat.talabatcommon.views.ridersTip.bottomSheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.designsystem.ds_button.DSPrimaryButton;
import com.designsystem.ds_chip.DSSingleSelectionChip;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.enums.OrderStatus;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderBottomSheetState;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderSource;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletDebitRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletPaymentFeature;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentTransactionStatus;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import com.talabat.talabatcommon.views.ridersTip.bottomSheet.di.DaggerRiderTipFragmentComponent;
import com.talabat.talabatcommon.views.ridersTip.model.RidersTipSuggestedAmountDisplayModel;
import com.talabat.talabatcommon.views.ridersTip.model.RidersTipSuggestionsDisplayModel;
import com.talabat.talabatcommon.views.ridersTip.viewModel.RiderTipViewModel;
import com.talabat.talabatcommon.views.ridersTip.viewModel.RiderTipViewModelBuilder;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListFragment;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentWidgetDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModel;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pv.a;
import pv.b;
import pv.c;
import pv.d;
import pv.e;
import pv.f;

@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0003\u0001BK\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000202H\u0002J\b\u00104\u001a\u000202H\u0002J\b\u00105\u001a\u000202H\u0002J\b\u00106\u001a\u000202H\u0002J\u0012\u00107\u001a\u0002022\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u000e\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00020;H\u0016J\b\u0010<\u001a\u000202H\u0002J\u0018\u0010=\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(H\u0002J\u0018\u0010>\u001a\u0012\u0012\u0004\u0012\u00020.0&j\b\u0012\u0004\u0012\u00020.`(H\u0002J\b\u0010?\u001a\u00020\u0016H\u0002J\b\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u000202H\u0002J\b\u0010C\u001a\u000202H\u0016J\b\u0010D\u001a\u000202H\u0016J\u0010\u0010E\u001a\u0002022\u0006\u0010F\u001a\u00020GH\u0016J\u0012\u0010H\u001a\u0002022\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\b\u0010K\u001a\u000202H\u0016J\u001a\u0010L\u001a\u0002022\u0006\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\b\u0010Q\u001a\u000202H\u0002J\u0010\u0010R\u001a\u0002022\u0006\u0010S\u001a\u00020AH\u0002J\u0017\u0010T\u001a\u0002022\b\u0010U\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010VJ\u0017\u0010W\u001a\u0002022\b\u0010X\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010YJ\b\u0010Z\u001a\u000202H\u0002J\b\u0010[\u001a\u000202H\u0002J\u0017\u0010\\\u001a\u0002022\b\u0010U\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010VJ\u0017\u0010]\u001a\u0002022\b\u0010^\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010VJ\b\u0010_\u001a\u000202H\u0002J\b\u0010`\u001a\u000202H\u0002J\b\u0010a\u001a\u000202H\u0002J\u0014\u0010b\u001a\u0002022\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010d\u001a\u000202H\u0002J\u0012\u0010e\u001a\u0002022\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J\u0010\u0010h\u001a\u0002022\u0006\u0010i\u001a\u00020\u000fH\u0002J\u0010\u0010j\u001a\u0002022\u0006\u0010k\u001a\u00020AH\u0002J\u0012\u0010l\u001a\u0002022\b\u00108\u001a\u0004\u0018\u000109H\u0002J\u0012\u0010m\u001a\u0002022\b\u0010n\u001a\u0004\u0018\u00010oH\u0002J\b\u0010p\u001a\u000202H\u0002J\u0010\u0010q\u001a\u0002022\u0006\u0010r\u001a\u00020\u0016H\u0002J\u0016\u0010s\u001a\u0002022\f\u0010t\u001a\b\u0012\u0004\u0012\u00020v0uH\u0002J\u0018\u0010w\u001a\u0002022\u000e\u0010t\u001a\n\u0012\u0004\u0012\u00020v\u0018\u00010uH\u0002J\u0012\u0010x\u001a\u0002022\b\u0010y\u001a\u0004\u0018\u00010zH\u0002J\b\u0010{\u001a\u000202H\u0002J\u0010\u0010|\u001a\u0002022\b\u0010}\u001a\u0004\u0018\u00010JJ\b\u0010~\u001a\u00020\u0002H\u0016R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0004¢\u0006\u0004\n\u0002\u0010$R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R+\u0010%\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(8BX\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R+\u0010-\u001a\u0012\u0012\u0004\u0012\u00020.0&j\b\u0012\u0004\u0012\u00020.`(8BX\u0002¢\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b/\u0010*¨\u0006\u0001"}, d2 = {"Lcom/talabat/talabatcommon/views/ridersTip/bottomSheet/RiderTipFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/talabatcommon/views/ridersTip/viewModel/RiderTipViewModel;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentOptionView$AddCardInterface;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/DefaultCardView$DefaultCardViewBottomScreenInterface;", "riderTipFragmentInterface", "Lcom/talabat/talabatcommon/views/ridersTip/bottomSheet/RiderTipFragment$RiderTipFragmentInterface;", "tipRiderBottomSheetStatus", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderBottomSheetState;", "tipRiderSource", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderSource;", "orderStatus", "Lcom/talabat/talabatcommon/enums/OrderStatus;", "orderId", "", "encryptedOrderId", "screenName", "selectedTipValue", "", "(Lcom/talabat/talabatcommon/views/ridersTip/bottomSheet/RiderTipFragment$RiderTipFragmentInterface;Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderBottomSheetState;Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderSource;Lcom/talabat/talabatcommon/enums/OrderStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;)V", "areTipsSuggestionsReady", "", "featureFlagRepository", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepository", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepository", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "isPaymentCardListReady", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "Ljava/lang/Float;", "tipsChipsList", "Ljava/util/ArrayList;", "Lcom/designsystem/ds_chip/DSSingleSelectionChip;", "Lkotlin/collections/ArrayList;", "getTipsChipsList", "()Ljava/util/ArrayList;", "tipsChipsList$delegate", "Lkotlin/Lazy;", "tipsRadioGroupList", "Landroid/widget/RadioButton;", "getTipsRadioGroupList", "tipsRadioGroupList$delegate", "addOnClickListeners", "", "addWalletPaymentWidget", "callSuggestionApi", "disableRiderBottomSheetCtaButton", "enableRiderBottomSheetCtaButton", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getViewModelClass", "Ljava/lang/Class;", "hideProgressBarWhenUiIsReady", "initTipsChipsList", "initTipsRadioGroupList", "isCtaReady", "layoutId", "", "navigateToAddCard", "observatory", "onAddCardClicked", "onAttach", "context", "Landroid/content/Context;", "onChangeClickedInBottomSheet", "cardListData", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "payRiderTip", "selectChipTip", "selectedIndex", "selectFirstTipIfTheUserHasNotSelectedBefore", "shouldShowTipsOptionsAsChips", "(Ljava/lang/Boolean;)V", "selectTipByValue", "tipValue", "(Ljava/lang/Float;)V", "setUpView", "setupPaymentView", "setupTipOptionsListInitView", "showCtaAndSelectFirstTip", "isCardViewLoaded", "showInfoBottomSheet", "showInfoWithTipAgain", "showInfoWithoutTipAgain", "showPaymentFailureView", "errorMessage", "showPaymentSuccessfulView", "updateCtaButton", "walletPaymentWidgetDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentWidgetDisplayModel;", "updateCtaTextWithNewAmount", "amount", "updateDefaultCard", "selectedPosition", "updateFailureMessage", "updatePaymentSuccessful", "walletPaymentDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentDisplayModel;", "updatePaymentWidgetWithNewSelectedAmount", "updateRiderBottomSheetCtaButton", "shouldEnablePaymentButton", "updateTipChips", "tips", "", "Lcom/talabat/talabatcommon/views/ridersTip/model/RidersTipSuggestedAmountDisplayModel;", "updateTipRadioButtons", "updateTipSuggestions", "ridersTipSuggestionsDisplayModel", "Lcom/talabat/talabatcommon/views/ridersTip/model/RidersTipSuggestionsDisplayModel;", "updateViewModelWithArgumentExtras", "updateWalletCardList", "walletCardListDisplayModel", "viewModelBuilder", "Companion", "RiderTipFragmentInterface", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class RiderTipFragment extends BaseFragment implements AnimationHelper, WalletPaymentOptionView.AddCardInterface, DefaultCardView.DefaultCardViewBottomScreenInterface {
    private static final long BOTTOM_SHEET_DURATION_AFTER_SUCCESS_PAY = 4000;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_ENCRYPTED_ORDER_ID = "encryptedOrderId";
    @NotNull
    public static final String EXTRA_ORDER_ID = "orderId";
    private static final long LOADER_DURATION = 1000;
    @NotNull
    public static final String SCREEN_SOURCE = "screen_type";
    private static final long SHIMMER_DISMISS_DELAY = 500;
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    private boolean areTipsSuggestionsReady;
    @NotNull
    private final String encryptedOrderId;
    @Inject
    public ITalabatFeatureFlag featureFlagRepository;
    private boolean isPaymentCardListReady;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final String orderId;
    @Nullable
    private final OrderStatus orderStatus;
    /* access modifiers changed from: private */
    @NotNull
    public final RiderTipFragmentInterface riderTipFragmentInterface;
    @NotNull
    private final String screenName;
    @Nullable
    private final Float selectedTipValue;
    @NotNull
    private final TipRiderBottomSheetState tipRiderBottomSheetStatus;
    @NotNull
    private TipRiderSource tipRiderSource;
    @NotNull
    private final Lazy tipsChipsList$delegate;
    @NotNull
    private final Lazy tipsRadioGroupList$delegate;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/views/ridersTip/bottomSheet/RiderTipFragment$Companion;", "", "()V", "BOTTOM_SHEET_DURATION_AFTER_SUCCESS_PAY", "", "EXTRA_ENCRYPTED_ORDER_ID", "", "EXTRA_ORDER_ID", "LOADER_DURATION", "SCREEN_SOURCE", "SHIMMER_DISMISS_DELAY", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/views/ridersTip/bottomSheet/RiderTipFragment$RiderTipFragmentInterface;", "", "attachCardList", "", "cardListData", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "viewHeight", "", "closeBottomSheet", "riderTippedSuccessfully", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface RiderTipFragmentInterface {
        void attachCardList(@Nullable WalletCardListDisplayModel walletCardListDisplayModel, int i11);

        void closeBottomSheet();

        void riderTippedSuccessfully();
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[WalletPaymentTransactionStatus.values().length];
            iArr[WalletPaymentTransactionStatus.SUCCESS.ordinal()] = 1;
            iArr[WalletPaymentTransactionStatus.FAIL.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TipRiderBottomSheetState.values().length];
            iArr2[TipRiderBottomSheetState.OPEN_PAYMENT_WIDGET.ordinal()] = 1;
            iArr2[TipRiderBottomSheetState.OPEN_INFO_WITHOUT_TIP_AGAIN.ordinal()] = 2;
            iArr2[TipRiderBottomSheetState.OPEN_INFO_WITH_TIP_AGAIN.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public RiderTipFragment(@NotNull RiderTipFragmentInterface riderTipFragmentInterface2, @NotNull TipRiderBottomSheetState tipRiderBottomSheetState, @NotNull TipRiderSource tipRiderSource2, @Nullable OrderStatus orderStatus2, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Float f11) {
        Intrinsics.checkNotNullParameter(riderTipFragmentInterface2, "riderTipFragmentInterface");
        Intrinsics.checkNotNullParameter(tipRiderBottomSheetState, "tipRiderBottomSheetStatus");
        Intrinsics.checkNotNullParameter(tipRiderSource2, "tipRiderSource");
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "encryptedOrderId");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        this._$_findViewCache = new LinkedHashMap();
        this.riderTipFragmentInterface = riderTipFragmentInterface2;
        this.tipRiderBottomSheetStatus = tipRiderBottomSheetState;
        this.tipRiderSource = tipRiderSource2;
        this.orderStatus = orderStatus2;
        this.orderId = str;
        this.encryptedOrderId = str2;
        this.screenName = str3;
        this.selectedTipValue = f11;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.tipsRadioGroupList$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new RiderTipFragment$tipsRadioGroupList$2(this));
        this.tipsChipsList$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new RiderTipFragment$tipsChipsList$2(this));
    }

    private final void addOnClickListeners() {
        ((LinearLayout) _$_findCachedViewById(R.id.riderBottomSheetCtaButton)).setOnClickListener(new a(this));
        ((DSPrimaryButton) _$_findCachedViewById(R.id.open_tip_rider_payment_widget)).setOnClickListener(new b(this));
        ((ImageView) _$_findCachedViewById(R.id.close_tip_rider)).setOnClickListener(new c(this));
        ((ImageView) _$_findCachedViewById(R.id.close)).setOnClickListener(new d(this));
        ((TextView) _$_findCachedViewById(R.id.dismiss)).setOnClickListener(new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addOnClickListeners$lambda-14  reason: not valid java name */
    public static final void m5771addOnClickListeners$lambda14(RiderTipFragment riderTipFragment, View view) {
        Intrinsics.checkNotNullParameter(riderTipFragment, "this$0");
        riderTipFragment.showProgress();
        ((RiderTipViewModel) riderTipFragment.getViewModel()).onTipRiderClicked(riderTipFragment.orderStatus, ((RiderTipViewModel) riderTipFragment.getViewModel()).getOrderId(), String.valueOf(FloatKt.orZero(((RiderTipViewModel) riderTipFragment.getViewModel()).getAmount(((RiderTipViewModel) riderTipFragment.getViewModel()).getSelectedTipIndex()))), ((WalletPaymentOptionView) riderTipFragment._$_findCachedViewById(R.id.riderBottomSheetTipsWalletPaymentWidget)).getSelectedPaymentMethod().name(), riderTipFragment.tipRiderSource);
        riderTipFragment.payRiderTip();
    }

    /* access modifiers changed from: private */
    /* renamed from: addOnClickListeners$lambda-15  reason: not valid java name */
    public static final void m5772addOnClickListeners$lambda15(RiderTipFragment riderTipFragment, View view) {
        Intrinsics.checkNotNullParameter(riderTipFragment, "this$0");
        riderTipFragment.setupPaymentView();
    }

    /* access modifiers changed from: private */
    /* renamed from: addOnClickListeners$lambda-16  reason: not valid java name */
    public static final void m5773addOnClickListeners$lambda16(RiderTipFragment riderTipFragment, View view) {
        Intrinsics.checkNotNullParameter(riderTipFragment, "this$0");
        riderTipFragment.riderTipFragmentInterface.closeBottomSheet();
    }

    /* access modifiers changed from: private */
    /* renamed from: addOnClickListeners$lambda-17  reason: not valid java name */
    public static final void m5774addOnClickListeners$lambda17(RiderTipFragment riderTipFragment, View view) {
        Intrinsics.checkNotNullParameter(riderTipFragment, "this$0");
        riderTipFragment.riderTipFragmentInterface.closeBottomSheet();
    }

    /* access modifiers changed from: private */
    /* renamed from: addOnClickListeners$lambda-18  reason: not valid java name */
    public static final void m5775addOnClickListeners$lambda18(RiderTipFragment riderTipFragment, View view) {
        Intrinsics.checkNotNullParameter(riderTipFragment, "this$0");
        riderTipFragment.riderTipFragmentInterface.closeBottomSheet();
    }

    private final void addWalletPaymentWidget() {
        WalletCardListDisplayModel walletCardListDisplayModel;
        int i11;
        int i12 = R.id.riderBottomSheetTipsWalletPaymentWidget;
        DefaultCardView defaultCardView = (DefaultCardView) ((WalletPaymentOptionView) _$_findCachedViewById(i12))._$_findCachedViewById(R.id.card_container);
        Intrinsics.checkNotNullExpressionValue(defaultCardView, "riderBottomSheetTipsWall…mentWidget.card_container");
        DefaultCardView.setDefaultCardViewBottomScreenListener$default(defaultCardView, this, true, false, false, 12, (Object) null);
        ((WalletPaymentOptionView) _$_findCachedViewById(i12)).setAddCardListener(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            walletCardListDisplayModel = (WalletCardListDisplayModel) arguments.getParcelable(WalletNavigatorActions.EXTRA_UPDATE_WALLET_CARD_LIST);
        } else {
            walletCardListDisplayModel = null;
        }
        updateWalletCardList(walletCardListDisplayModel);
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            i11 = arguments2.getInt(CardListFragment.SELECTED_POSITION);
        } else {
            i11 = 0;
        }
        updateDefaultCard(i11);
        ((WalletPaymentOptionView) _$_findCachedViewById(i12)).resetObservers();
    }

    private final void callSuggestionApi() {
        Boolean bool;
        Bundle arguments = getArguments();
        if (arguments != null) {
            bool = Boolean.valueOf(arguments.containsKey(CardListFragment.SELECTED_POSITION));
        } else {
            bool = null;
        }
        if (!BooleanKt.orFalse(bool)) {
            RiderTipViewModel.getRiderTipSuggestedAmount$default((RiderTipViewModel) getViewModel(), 0, 1, (Object) null);
        }
    }

    private final void disableRiderBottomSheetCtaButton() {
        int i11 = R.id.riderBottomSheetCtaButton;
        ((LinearLayout) _$_findCachedViewById(i11)).setEnabled(false);
        ((LinearLayout) _$_findCachedViewById(i11)).setAlpha(0.5f);
    }

    private final void enableRiderBottomSheetCtaButton() {
        int i11 = R.id.riderBottomSheetCtaButton;
        ((LinearLayout) _$_findCachedViewById(i11)).setEnabled(true);
        ((LinearLayout) _$_findCachedViewById(i11)).setAlpha(1.0f);
    }

    public static /* synthetic */ void g(RiderTipFragment riderTipFragment, String str, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                str = null;
            }
            riderTipFragment.showPaymentFailureView(str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPaymentFailureView");
    }

    private final ArrayList<DSSingleSelectionChip> getTipsChipsList() {
        return (ArrayList) this.tipsChipsList$delegate.getValue();
    }

    private final ArrayList<RadioButton> getTipsRadioGroupList() {
        return (ArrayList) this.tipsRadioGroupList$delegate.getValue();
    }

    private final void hideProgressBarWhenUiIsReady() {
        if (this.areTipsSuggestionsReady && this.isPaymentCardListReady && isCtaReady()) {
            delay(500, new RiderTipFragment$hideProgressBarWhenUiIsReady$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final ArrayList<DSSingleSelectionChip> initTipsChipsList() {
        ArrayList<DSSingleSelectionChip> arrayList = new ArrayList<>();
        arrayList.add((DSSingleSelectionChip) _$_findCachedViewById(R.id.riderTipChip1));
        arrayList.add((DSSingleSelectionChip) _$_findCachedViewById(R.id.riderTipChip2));
        arrayList.add((DSSingleSelectionChip) _$_findCachedViewById(R.id.riderTipChip3));
        int i11 = 0;
        for (T next : arrayList) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ((DSSingleSelectionChip) next).setOnTap(new RiderTipFragment$initTipsChipsList$1$1(this, i11));
            i11 = i12;
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final ArrayList<RadioButton> initTipsRadioGroupList() {
        ArrayList<RadioButton> arrayList = new ArrayList<>();
        arrayList.add((RadioButton) _$_findCachedViewById(R.id.riderTipRadioButton1));
        arrayList.add((RadioButton) _$_findCachedViewById(R.id.riderTipRadioButton2));
        arrayList.add((RadioButton) _$_findCachedViewById(R.id.riderTipRadioButton3));
        RadioGroup radioGroup = (RadioGroup) _$_findCachedViewById(R.id.riderBottomSheetTipsRadioGroup);
        radioGroup.setOrientation(0);
        radioGroup.setOnCheckedChangeListener(new f(this));
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: initTipsRadioGroupList$lambda-25$lambda-24  reason: not valid java name */
    public static final void m5776initTipsRadioGroupList$lambda25$lambda24(RiderTipFragment riderTipFragment, RadioGroup radioGroup, int i11) {
        RadioButton radioButton;
        Intrinsics.checkNotNullParameter(riderTipFragment, "this$0");
        View findViewById = radioGroup.findViewById(i11);
        if (findViewById instanceof RadioButton) {
            radioButton = (RadioButton) findViewById;
        } else {
            radioButton = null;
        }
        if (radioButton == null) {
            riderTipFragment.getTipsRadioGroupList().get(IntKt.orZero(((RiderTipViewModel) riderTipFragment.getViewModel()).getSelectedTipIndex())).setChecked(true);
        } else {
            radioButton.setEnabled(true);
            ((RiderTipViewModel) riderTipFragment.getViewModel()).setSelectedTipIndex(Integer.valueOf(radioGroup.indexOfChild(radioButton)));
            riderTipFragment.updateCtaTextWithNewAmount(radioButton.getText().toString());
        }
        riderTipFragment.updatePaymentWidgetWithNewSelectedAmount();
    }

    private final boolean isCtaReady() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.riderBottomSheetCtaButton);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "riderBottomSheetCtaButton");
        if (ViewKt.isVisible(linearLayout)) {
            int i11 = R.id.riderBottomSheetCtaButtonTextView;
            TextView textView = (TextView) _$_findCachedViewById(i11);
            Intrinsics.checkNotNullExpressionValue(textView, "riderBottomSheetCtaButtonTextView");
            if (ViewKt.isVisible(textView)) {
                CharSequence text = ((TextView) _$_findCachedViewById(i11)).getText();
                Intrinsics.checkNotNullExpressionValue(text, "riderBottomSheetCtaButtonTextView.text");
                if (!StringsKt__StringsJVMKt.isBlank(text)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void navigateToAddCard() {
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, WalletNavigatorActions.Companion.createNavigationToWalletAddCard());
        }
    }

    private final void payRiderTip() {
        Float amount = ((RiderTipViewModel) getViewModel()).getAmount(((RiderTipViewModel) getViewModel()).getSelectedTipIndex());
        if (amount != null) {
            WalletDebitRequestModel walletDebitRequestModel = new WalletDebitRequestModel(amount.floatValue(), (Integer) null, 0, 0, WalletPaymentFeature.RIDER_TIP.getValue(), (String) null, (String) null, 0, ((RiderTipViewModel) getViewModel()).getEncryptedOrderId(), IntegrationGlobalDataModel.Companion.selectedCountryCode(), (String) null, 1262, (DefaultConstructorMarker) null);
            WalletPaymentOptionView walletPaymentOptionView = (WalletPaymentOptionView) _$_findCachedViewById(R.id.riderBottomSheetTipsWalletPaymentWidget);
            Intrinsics.checkNotNullExpressionValue(walletPaymentOptionView, "riderBottomSheetTipsWalletPaymentWidget");
            WalletPaymentOptionView.payAmountThroughWallet$default(walletPaymentOptionView, getFragmentManager(), walletDebitRequestModel, false, 4, (Object) null);
            ((LinearLayout) _$_findCachedViewById(R.id.riderBottomSheetCtaButton)).setEnabled(false);
        }
    }

    /* access modifiers changed from: private */
    public final void selectChipTip(int i11) {
        String str;
        boolean z11;
        ArrayList<DSSingleSelectionChip> tipsChipsList = getTipsChipsList();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(tipsChipsList, 10));
        int i12 = 0;
        for (T next : tipsChipsList) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            DSSingleSelectionChip dSSingleSelectionChip = (DSSingleSelectionChip) next;
            if (i12 == i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            dSSingleSelectionChip.setChipSelected(z11);
            arrayList.add(Unit.INSTANCE);
            i12 = i13;
        }
        DSSingleSelectionChip dSSingleSelectionChip2 = (DSSingleSelectionChip) CollectionsKt___CollectionsKt.getOrNull(getTipsChipsList(), i11);
        if (dSSingleSelectionChip2 != null) {
            str = dSSingleSelectionChip2.getText();
        } else {
            str = null;
        }
        ((RiderTipViewModel) getViewModel()).setSelectedTipIndex(Integer.valueOf(i11));
        if (str != null) {
            updateCtaTextWithNewAmount(str);
        }
        updatePaymentWidgetWithNewSelectedAmount();
    }

    private final void selectFirstTipIfTheUserHasNotSelectedBefore(Boolean bool) {
        if (((RiderTipViewModel) getViewModel()).getSelectedTipIndex() != null) {
            return;
        }
        if (!Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            RadioButton radioButton = (RadioButton) CollectionsKt___CollectionsKt.getOrNull(getTipsRadioGroupList(), 0);
            if (radioButton != null) {
                radioButton.performClick();
            }
        } else if (((DSSingleSelectionChip) CollectionsKt___CollectionsKt.getOrNull(getTipsChipsList(), 0)) != null) {
            selectChipTip(0);
        }
    }

    private final void selectTipByValue(Float f11) {
        List list;
        int i11;
        List<RidersTipSuggestedAmountDisplayModel> tipsAmountList;
        if (f11 != null) {
            RidersTipSuggestionsDisplayModel value = ((RiderTipViewModel) getViewModel()).getRiderTipSuggestedAmountData().getValue();
            if (value == null || (tipsAmountList = value.getTipsAmountList()) == null) {
                list = null;
            } else {
                Iterable<RidersTipSuggestedAmountDisplayModel> iterable = tipsAmountList;
                list = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                for (RidersTipSuggestedAmountDisplayModel amount : iterable) {
                    list.add(Float.valueOf(amount.getAmount()));
                }
            }
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            if (list.contains(f11)) {
                i11 = list.indexOf(f11);
            } else {
                i11 = 0;
            }
            RadioButton radioButton = (RadioButton) CollectionsKt___CollectionsKt.getOrNull(getTipsRadioGroupList(), i11);
            if (radioButton != null) {
                radioButton.performClick();
            }
        }
    }

    private final void setUpView() {
        int i11 = WhenMappings.$EnumSwitchMapping$1[this.tipRiderBottomSheetStatus.ordinal()];
        if (i11 == 1) {
            ((RiderTipViewModel) getViewModel()).onTipRiderOpen(this.orderStatus, ((RiderTipViewModel) getViewModel()).getOrderId(), this.tipRiderSource);
            setupPaymentView();
        } else if (i11 == 2) {
            showInfoWithoutTipAgain();
        } else if (i11 == 3) {
            showInfoWithTipAgain();
        }
    }

    private final void setupPaymentView() {
        ((ConstraintLayout) _$_findCachedViewById(R.id.container_all)).setVisibility(0);
        _$_findCachedViewById(R.id.tip_rider_info_view).setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void setupTipOptionsListInitView(Boolean bool) {
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            ((RadioGroup) _$_findCachedViewById(R.id.riderBottomSheetTipsRadioGroup)).setVisibility(8);
            ((HorizontalScrollView) _$_findCachedViewById(R.id.riderBottomSheetTipsChipsScrollView)).setVisibility(4);
            return;
        }
        ((RadioGroup) _$_findCachedViewById(R.id.riderBottomSheetTipsRadioGroup)).setVisibility(4);
        ((HorizontalScrollView) _$_findCachedViewById(R.id.riderBottomSheetTipsChipsScrollView)).setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void showCtaAndSelectFirstTip(Boolean bool) {
        Boolean bool2;
        if (bool != null) {
            bool.booleanValue();
            ((LinearLayout) _$_findCachedViewById(R.id.riderBottomSheetCtaButton)).setVisibility(0);
            ((TextView) _$_findCachedViewById(R.id.riderBottomSheetCtaButtonTextView)).setVisibility(0);
            Bundle arguments = getArguments();
            if (arguments != null) {
                bool2 = Boolean.valueOf(arguments.containsKey(CardListFragment.SELECTED_POSITION));
            } else {
                bool2 = null;
            }
            if (!BooleanKt.orFalse(bool2)) {
                selectFirstTipIfTheUserHasNotSelectedBefore(((RiderTipViewModel) getViewModel()).getShouldShowTipsAsChips().getValue());
                updatePaymentWidgetWithNewSelectedAmount();
            }
            this.isPaymentCardListReady = true;
        }
        hideProgressBarWhenUiIsReady();
    }

    private final void showInfoBottomSheet() {
        ((RiderTipViewModel) getViewModel()).onTipRiderOpen(this.orderStatus, ((RiderTipViewModel) getViewModel()).getOrderId(), this.tipRiderSource);
        ((ConstraintLayout) _$_findCachedViewById(R.id.container_all)).setVisibility(4);
        _$_findCachedViewById(R.id.tip_rider_info_view).setVisibility(0);
    }

    private final void showInfoWithTipAgain() {
        showInfoBottomSheet();
        String string = getString(com.talabat.localization.R.string.tip_rider_again);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…R.string.tip_rider_again)");
        ((DSPrimaryButton) _$_findCachedViewById(R.id.open_tip_rider_payment_widget)).setCenterText(string);
    }

    private final void showInfoWithoutTipAgain() {
        showInfoBottomSheet();
        String string = getString(com.talabat.localization.R.string.tip_rider);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ation.R.string.tip_rider)");
        ((DSPrimaryButton) _$_findCachedViewById(R.id.open_tip_rider_payment_widget)).setCenterText(string);
    }

    private final void showPaymentFailureView(String str) {
        String str2;
        FragmentActivity activity = getActivity();
        Status.Companion companion = Status.Companion;
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.errorNotifyLinearLayout);
        if (str == null) {
            str2 = getString(com.talabat.localization.R.string.something_went_wrong);
            Intrinsics.checkNotNullExpressionValue(str2, "getString(com.talabat.lo…ing.something_went_wrong)");
        } else {
            str2 = str;
        }
        Status.Companion.notify$default(companion, activity, linearLayout, str2, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 56, (Object) null);
        RiderTipViewModel riderTipViewModel = (RiderTipViewModel) getViewModel();
        OrderStatus orderStatus2 = this.orderStatus;
        String orderId2 = ((RiderTipViewModel) getViewModel()).getOrderId();
        if (str == null) {
            str = getString(com.talabat.localization.R.string.something_went_wrong);
            Intrinsics.checkNotNullExpressionValue(str, "getString(com.talabat.lo…ing.something_went_wrong)");
        }
        riderTipViewModel.onTipRiderFailure(orderStatus2, orderId2, str, ((WalletPaymentOptionView) _$_findCachedViewById(R.id.riderBottomSheetTipsWalletPaymentWidget)).getSelectedPaymentMethod().name());
        ((LinearLayout) _$_findCachedViewById(R.id.riderBottomSheetCtaButton)).setEnabled(true);
        hideProgress();
    }

    private final void showPaymentSuccessfulView() {
        delay(1000, new RiderTipFragment$showPaymentSuccessfulView$1(this));
        delay(4000, new RiderTipFragment$showPaymentSuccessfulView$2(this));
    }

    /* access modifiers changed from: private */
    public final void updateCtaButton(WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel) {
        if (walletPaymentWidgetDisplayModel != null) {
            updateRiderBottomSheetCtaButton(walletPaymentWidgetDisplayModel.getShouldEnablePaymentButton());
        }
    }

    private final void updateCtaTextWithNewAmount(String str) {
        ((TextView) _$_findCachedViewById(R.id.riderBottomSheetCtaButtonTextView)).setText(getString(com.talabat.localization.R.string.rider_tip_sent_tip, str));
    }

    private final void updateDefaultCard(int i11) {
        ((WalletPaymentOptionView) _$_findCachedViewById(R.id.riderBottomSheetTipsWalletPaymentWidget)).updateClickedPositionData(i11);
    }

    /* access modifiers changed from: private */
    public final void updateFailureMessage(Failure failure) {
        if (failure != null) {
            g(this, (String) null, 1, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void updatePaymentSuccessful(WalletPaymentDisplayModel walletPaymentDisplayModel) {
        if (walletPaymentDisplayModel != null) {
            int i11 = WhenMappings.$EnumSwitchMapping$0[walletPaymentDisplayModel.getWalletTransactionStatus().ordinal()];
            if (i11 == 1) {
                this.riderTipFragmentInterface.riderTippedSuccessfully();
                ((RiderTipViewModel) getViewModel()).onTipRiderCompleted(this.orderStatus, ((RiderTipViewModel) getViewModel()).getOrderId(), String.valueOf(FloatKt.orZero(((RiderTipViewModel) getViewModel()).getAmount(((RiderTipViewModel) getViewModel()).getSelectedTipIndex()))), ((WalletPaymentOptionView) _$_findCachedViewById(R.id.riderBottomSheetTipsWalletPaymentWidget)).getSelectedPaymentMethod().name(), this.tipRiderSource);
                showPaymentSuccessfulView();
            } else if (i11 != 2) {
                LogManager.debug("unsupported transaction status");
                hideProgress();
            } else {
                showPaymentFailureView(walletPaymentDisplayModel.getErrorMessage());
            }
        }
    }

    private final void updatePaymentWidgetWithNewSelectedAmount() {
        Float amount = ((RiderTipViewModel) getViewModel()).getAmount(((RiderTipViewModel) getViewModel()).getSelectedTipIndex());
        if (amount != null) {
            ((WalletPaymentOptionView) _$_findCachedViewById(R.id.riderBottomSheetTipsWalletPaymentWidget)).updateAmount(amount.floatValue());
        }
    }

    private final void updateRiderBottomSheetCtaButton(boolean z11) {
        if (z11) {
            enableRiderBottomSheetCtaButton();
        } else {
            disableRiderBottomSheetCtaButton();
        }
    }

    private final void updateTipChips(List<RidersTipSuggestedAmountDisplayModel> list) {
        int i11 = 0;
        for (Object next : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            getTipsChipsList().get(i11).setText(CurrencyFormatter.Companion.formatAmount(getLocationConfigurationRepository(), ((RidersTipSuggestedAmountDisplayModel) next).getAmount(), true));
            getTipsChipsList().get(i11).setChipSelected(false);
            i11 = i12;
        }
        selectChipTip(IntKt.orZero(((RiderTipViewModel) getViewModel()).getSelectedTipIndex()));
        ((HorizontalScrollView) _$_findCachedViewById(R.id.riderBottomSheetTipsChipsScrollView)).setVisibility(0);
    }

    private final void updateTipRadioButtons(List<RidersTipSuggestedAmountDisplayModel> list) {
        ((RadioGroup) _$_findCachedViewById(R.id.riderBottomSheetTipsRadioGroup)).setVisibility(0);
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                getTipsRadioGroupList().get(i11).setText(CurrencyFormatter.Companion.formatAmountWithoutDecimalsIfPossible(getLocationConfigurationRepository(), list.get(i11).getAmount(), true));
            }
            ((RadioGroup) _$_findCachedViewById(R.id.riderBottomSheetTipsRadioGroup)).clearCheck();
        }
    }

    /* access modifiers changed from: private */
    public final void updateTipSuggestions(RidersTipSuggestionsDisplayModel ridersTipSuggestionsDisplayModel) {
        List<RidersTipSuggestedAmountDisplayModel> list;
        boolean z11 = false;
        if (ridersTipSuggestionsDisplayModel != null && ridersTipSuggestionsDisplayModel.getShouldShowTipsAsChips()) {
            z11 = true;
        }
        Boolean bool = null;
        if (z11) {
            updateTipChips(ridersTipSuggestionsDisplayModel.getTipsAmountList());
        } else {
            if (ridersTipSuggestionsDisplayModel != null) {
                list = ridersTipSuggestionsDisplayModel.getTipsAmountList();
            } else {
                list = null;
            }
            updateTipRadioButtons(list);
            selectTipByValue(this.selectedTipValue);
        }
        this.areTipsSuggestionsReady = true;
        if (!(ridersTipSuggestionsDisplayModel == null || ridersTipSuggestionsDisplayModel.getTipsAmountList() == null)) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                bool = Boolean.valueOf(arguments.containsKey(CardListFragment.SELECTED_POSITION));
            }
            if (!BooleanKt.orFalse(bool)) {
                selectFirstTipIfTheUserHasNotSelectedBefore(((RiderTipViewModel) getViewModel()).getShouldShowTipsAsChips().getValue());
                Float amount = ((RiderTipViewModel) getViewModel()).getAmount(((RiderTipViewModel) getViewModel()).getSelectedTipIndex());
                if (amount != null) {
                    float floatValue = amount.floatValue();
                    WalletPaymentOptionView walletPaymentOptionView = (WalletPaymentOptionView) _$_findCachedViewById(R.id.riderBottomSheetTipsWalletPaymentWidget);
                    Intrinsics.checkNotNullExpressionValue(walletPaymentOptionView, "riderBottomSheetTipsWalletPaymentWidget");
                    WalletPaymentOptionView.addPaymentMethodView$default(walletPaymentOptionView, Float.valueOf(floatValue), false, false, false, 14, (Object) null);
                }
                updateCtaButton(((WalletPaymentOptionViewModel) ((WalletPaymentOptionView) _$_findCachedViewById(R.id.riderBottomSheetTipsWalletPaymentWidget)).getViewModel()).getWalletWidgetConfigData().getValue());
            }
        }
        hideProgressBarWhenUiIsReady();
    }

    private final void updateViewModelWithArgumentExtras() {
        Unit unit;
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("encryptedOrderId", this.encryptedOrderId);
            Intrinsics.checkNotNullExpressionValue(string, "it.getString(\n          …ptedOrderId\n            )");
            ((RiderTipViewModel) getViewModel()).setEncryptedOrderId(string);
            String string2 = arguments.getString("orderId", this.orderId);
            Intrinsics.checkNotNullExpressionValue(string2, "it.getString(\n          …    orderId\n            )");
            ((RiderTipViewModel) getViewModel()).setOrderId(string2);
            String string3 = arguments.getString("screen_type", this.screenName);
            Intrinsics.checkNotNullExpressionValue(string3, "it.getString(\n          … screenName\n            )");
            ((RiderTipViewModel) getViewModel()).setScreenSource(string3);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ((RiderTipViewModel) getViewModel()).onSetTippingData(this.encryptedOrderId, this.orderId, this.screenName);
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

    public void adjustViewHeight(@NotNull View view, int i11, int i12, @NotNull AnimationSpeed animationSpeed) {
        AnimationHelper.DefaultImpls.adjustViewHeight(this, view, i11, i12, animationSpeed);
    }

    public void delay(long j11, @NotNull Function0<Unit> function0) {
        AnimationHelper.DefaultImpls.delay(this, j11, function0);
    }

    public void failureHere(@Nullable Failure failure) {
        String string = getString(com.talabat.localization.R.string.something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ing.something_went_wrong)");
        Status.Companion.notify$default(Status.Companion, getActivity(), (LinearLayout) _$_findCachedViewById(R.id.errorNotifyLinearLayout), string, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 56, (Object) null);
    }

    @NotNull
    public final ITalabatFeatureFlag getFeatureFlagRepository() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.featureFlagRepository;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlagRepository");
        return null;
    }

    @NotNull
    public final LocationConfigurationRepository getLocationConfigurationRepository() {
        LocationConfigurationRepository locationConfigurationRepository2 = this.locationConfigurationRepository;
        if (locationConfigurationRepository2 != null) {
            return locationConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationConfigurationRepository");
        return null;
    }

    @NotNull
    public Class<RiderTipViewModel> getViewModelClass() {
        return RiderTipViewModel.class;
    }

    public int layoutId() {
        return R.layout.bottom_sheet_rider_tip;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((RiderTipViewModel) getViewModel()).getShouldShowTipsAsChips(), new RiderTipFragment$observatory$1(this));
        LifecycleKt.observe(this, ((RiderTipViewModel) getViewModel()).getRiderTipSuggestedAmountData(), new RiderTipFragment$observatory$2(this));
        int i11 = R.id.riderBottomSheetTipsWalletPaymentWidget;
        LifecycleKt.observe(this, ((DefaultCardView) ((WalletPaymentOptionView) _$_findCachedViewById(i11))._$_findCachedViewById(R.id.card_container)).getCardLoadingStatus(), new RiderTipFragment$observatory$3(this));
        LifecycleKt.observe(this, ((WalletPaymentOptionViewModel) ((WalletPaymentOptionView) _$_findCachedViewById(i11)).getViewModel()).getWalletWidgetConfigData(), new RiderTipFragment$observatory$4(this));
        LifecycleKt.observe(this, ((WalletPaymentOptionViewModel) ((WalletPaymentOptionView) _$_findCachedViewById(i11)).getViewModel()).getWalletDebitData(), new RiderTipFragment$observatory$5(this));
        LifecycleKt.observe(this, ((WalletPaymentOptionViewModel) ((WalletPaymentOptionView) _$_findCachedViewById(i11)).getViewModel()).getFailureData(), new RiderTipFragment$observatory$6(this));
    }

    public void onAddCardClicked() {
        navigateToAddCard();
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerRiderTipFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    public void onChangeClickedInBottomSheet(@Nullable WalletCardListDisplayModel walletCardListDisplayModel) {
        this.riderTipFragmentInterface.attachCardList(walletCardListDisplayModel, ((RelativeLayout) _$_findCachedViewById(R.id.bottom_sheet)).getHeight());
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onResume() {
        super.onResume();
        callSuggestionApi();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        updateViewModelWithArgumentExtras();
        ((RiderTipViewModel) getViewModel()).getChipsFeatureFlag();
        int i11 = R.id.riderBottomSheetCtaButton;
        ((LinearLayout) _$_findCachedViewById(i11)).setVisibility(4);
        setUpView();
        addWalletPaymentWidget();
        ((LinearLayout) _$_findCachedViewById(i11)).setEnabled(true);
        addOnClickListeners();
    }

    public final void setFeatureFlagRepository(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepository = iTalabatFeatureFlag;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void updateWalletCardList(@Nullable WalletCardListDisplayModel walletCardListDisplayModel) {
        ((WalletPaymentOptionView) _$_findCachedViewById(R.id.riderBottomSheetTipsWalletPaymentWidget)).updateWalletCardListData(walletCardListDisplayModel);
    }

    @NotNull
    public RiderTipViewModel viewModelBuilder() {
        RiderTipViewModelBuilder.Companion companion = RiderTipViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.getRiderTipSuggestedAmountViewModel(requireContext, getCoroutineScope(), getFeatureFlagRepository());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RiderTipFragment(RiderTipFragmentInterface riderTipFragmentInterface2, TipRiderBottomSheetState tipRiderBottomSheetState, TipRiderSource tipRiderSource2, OrderStatus orderStatus2, String str, String str2, String str3, Float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(riderTipFragmentInterface2, tipRiderBottomSheetState, tipRiderSource2, orderStatus2, str, str2, str3, (i11 & 128) != 0 ? null : f11);
    }
}
