package com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.network.imageDownloader.ImageDownloadHelper;
import com.talabat.core.network.imageDownloader.TransformType;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.exception.LifecycleOwnerNotFoundException;
import com.talabat.talabatcommon.utils.CreditCardHelperInterface;
import com.talabat.talabatcommon.utils.FullScreenLoaderInterface;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcore.viewmodel.CreateCustomViewViewModel;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.walletTransactionDetail.model.PSPRevertStatus;
import com.talabat.wallet.ui.walletTransactionDetail.model.PaymentWalletTransactionDisplayModel;
import com.talabat.wallet.ui.walletTransactionDetail.model.RefundWalletTransactionDisplayModel;
import com.talabat.wallet.ui.walletTransactionDetail.model.RefundWalletTransactionTypeDisplayModel;
import com.talabat.wallet.ui.walletTransactionDetail.model.RestaurantWalletTransactionDisplayModel;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletOrderDetailModelState;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletRefundBottomSheetDisplayModel;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletRefundDisplayModelState;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDetailHeaderDisplayModel;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDetailMapper;
import com.talabat.wallet.ui.walletTransactionDetail.view.refundBottomSheet.WalletTransactionDetailRefundBottomSheet;
import com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.di.DaggerWalletTransactionRefundViewComponent;
import com.talabat.wallet.ui.walletTransactionDetail.viewModel.WalletTransactionDetailPaymentViewModel;
import com.talabat.wallet.ui.walletTransactionDetail.viewModel.WalletTransactionDetailRefundViewModel;
import com.talabat.wallet.ui.walletTransactionDetail.viewModel.WalletTransactionDetailViewModelBuilder;
import datamodels.OrderDetails;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kz.d;
import kz.e;
import kz.f;
import kz.g;
import kz.h;
import kz.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001JB\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB!\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u000e\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020\u0017J\u0010\u0010/\u001a\u00020*2\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020*H\u0014J\u0010\u00103\u001a\u00020*2\u0006\u0010.\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u001fH\u0002J\b\u00106\u001a\u00020*H\u0016J\u0010\u00107\u001a\u00020*2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u000e\u00108\u001a\u00020*2\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u00109\u001a\u00020\u001fH\u0002J\b\u0010:\u001a\u00020%H\u0002J\b\u0010;\u001a\u00020*H\u0002J\b\u0010<\u001a\u00020*H\u0002J\b\u0010=\u001a\u00020*H\u0016J\u0010\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020*H\u0002J\u0012\u0010B\u001a\u00020*2\b\u0010C\u001a\u0004\u0018\u00010DH\u0002J\u0012\u0010E\u001a\u00020*2\b\u0010F\u001a\u0004\u0018\u00010GH\u0002J\u0012\u0010H\u001a\u00020*2\b\u0010C\u001a\u0004\u0018\u00010DH\u0002J\b\u0010I\u001a\u00020%H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\u001b\u0010$\u001a\u00020%8BX\u0002¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b&\u0010'¨\u0006K"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/view/walletTransactionBodyView/WalletTransactionRefundView;", "Landroid/widget/LinearLayout;", "Lcom/talabat/talabatcommon/utils/CreditCardHelperInterface;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/talabat/wallet/ui/walletTransactionDetail/view/refundBottomSheet/WalletTransactionDetailRefundBottomSheet$RefundBottomSheetInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomSheet", "Lcom/talabat/wallet/ui/walletTransactionDetail/view/refundBottomSheet/WalletTransactionDetailRefundBottomSheet;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "displayModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundWalletTransactionTypeDisplayModel;", "fullScreenLoaderListener", "Lcom/talabat/talabatcommon/utils/FullScreenLoaderInterface;", "listener", "Lcom/talabat/wallet/ui/walletTransactionDetail/view/walletTransactionBodyView/WalletTransactionRefundView$WalletRefundOrderDetailInterface;", "mCreateCustomViewViewModel", "Lcom/talabat/talabatcore/viewmodel/CreateCustomViewViewModel;", "paymentViewModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/viewModel/WalletTransactionDetailPaymentViewModel;", "getPaymentViewModel", "()Lcom/talabat/wallet/ui/walletTransactionDetail/viewModel/WalletTransactionDetailPaymentViewModel;", "paymentViewModel$delegate", "Lkotlin/Lazy;", "refundViewModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/viewModel/WalletTransactionDetailRefundViewModel;", "getRefundViewModel", "()Lcom/talabat/wallet/ui/walletTransactionDetail/viewModel/WalletTransactionDetailRefundViewModel;", "refundViewModel$delegate", "addObservers", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "addViewToParent", "model", "displayRefundView", "shouldShowRefundEntryView", "", "onAttachedToWindow", "openBottomSheet", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletRefundBottomSheetDisplayModel;", "paymentViewModelBuilder", "revertRefundFromBottomSheet", "setFullScreenLoaderListener", "setWalletRefundOrderDetailListener", "setupPaymentViewModel", "setupRefundViewModel", "showRefundEntryView", "showRefundFAQView", "showRefundRevertedSuccessfulViews", "showRestaurantIcon", "imageUrl", "", "showRevertSentView", "updateCanRevertRefund", "walletRefundDisplayModelState", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletRefundDisplayModelState;", "updateOrderDetail", "walletOrderDetailModelState", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletOrderDetailModelState;", "updateRevertResult", "viewModelBuilder", "WalletRefundOrderDetailInterface", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionRefundView extends LinearLayout implements CreditCardHelperInterface, LifecycleObserver, WalletTransactionDetailRefundBottomSheet.RefundBottomSheetInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private WalletTransactionDetailRefundBottomSheet bottomSheet;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private RefundWalletTransactionTypeDisplayModel displayModel;
    @Nullable
    private FullScreenLoaderInterface fullScreenLoaderListener;
    @Nullable
    private WalletRefundOrderDetailInterface listener;
    @NotNull
    private CreateCustomViewViewModel mCreateCustomViewViewModel;
    @NotNull
    private final Lazy paymentViewModel$delegate;
    @NotNull
    private final Lazy refundViewModel$delegate;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/view/walletTransactionBodyView/WalletTransactionRefundView$WalletRefundOrderDetailInterface;", "", "navigateToHelpCenter", "", "navigateToOrderDetail", "orderDetail", "Ldatamodels/OrderDetails;", "updateRefundRevertedStatus", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface WalletRefundOrderDetailInterface {
        void navigateToHelpCenter();

        void navigateToOrderDetail(@NotNull OrderDetails orderDetails);

        void updateRefundRevertedStatus();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTransactionRefundView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.displayModel = new RefundWalletTransactionTypeDisplayModel((PaymentWalletTransactionDisplayModel) null, (RestaurantWalletTransactionDisplayModel) null, (RefundWalletTransactionDisplayModel) null, (WalletTransactionDetailHeaderDisplayModel) null, 15, (DefaultConstructorMarker) null);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.refundViewModel$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new WalletTransactionRefundView$refundViewModel$2(this));
        this.paymentViewModel$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new WalletTransactionRefundView$paymentViewModel$2(this));
        DaggerWalletTransactionRefundViewComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationLocalCoreLibApi.class)).inject(this);
        View.inflate(getContext(), R.layout.view_wallet_transaction_detail_refund_view, this);
        FullScreenLoaderInterface fullScreenLoaderInterface = this.fullScreenLoaderListener;
        if (fullScreenLoaderInterface != null) {
            fullScreenLoaderInterface.showLoader();
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.mCreateCustomViewViewModel = new CreateCustomViewViewModel(context2);
        ((LinearLayout) _$_findCachedViewById(R.id.send_refund)).setOnClickListener(new g(this));
        ((ConstraintLayout) _$_findCachedViewById(R.id.restaurant_info_container)).setOnClickListener(new h(this));
        ((TextView) _$_findCachedViewById(R.id.need_help_link)).setOnClickListener(new i(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m6084_init_$lambda0(WalletTransactionRefundView walletTransactionRefundView, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionRefundView, "this$0");
        walletTransactionRefundView.openBottomSheet(WalletTransactionDetailMapper.Companion.mapRefundModelToBottomSheetDisplayModel(walletTransactionRefundView.displayModel));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m6085_init_$lambda1(WalletTransactionRefundView walletTransactionRefundView, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionRefundView, "this$0");
        walletTransactionRefundView.getPaymentViewModel().onLoadOrderDetail(walletTransactionRefundView.displayModel.getHeaderInfo().getOrderId());
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m6086_init_$lambda2(WalletTransactionRefundView walletTransactionRefundView, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionRefundView, "this$0");
        WalletRefundOrderDetailInterface walletRefundOrderDetailInterface = walletTransactionRefundView.listener;
        if (walletRefundOrderDetailInterface != null) {
            walletRefundOrderDetailInterface.navigateToHelpCenter();
        }
    }

    private final void addObservers(LifecycleOwner lifecycleOwner) {
        getRefundViewModel().getWalletCanRevertRefundToBankData().observe(lifecycleOwner, new d(this));
        getRefundViewModel().getWalletRevertRefundToBankData().observe(lifecycleOwner, new e(this));
        getPaymentViewModel().getOrderDetailData().observe(lifecycleOwner, new f(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addObservers$lambda-3  reason: not valid java name */
    public static final void m6087addObservers$lambda3(WalletTransactionRefundView walletTransactionRefundView, WalletRefundDisplayModelState walletRefundDisplayModelState) {
        Intrinsics.checkNotNullParameter(walletTransactionRefundView, "this$0");
        walletTransactionRefundView.updateCanRevertRefund(walletRefundDisplayModelState);
    }

    /* access modifiers changed from: private */
    /* renamed from: addObservers$lambda-4  reason: not valid java name */
    public static final void m6088addObservers$lambda4(WalletTransactionRefundView walletTransactionRefundView, WalletRefundDisplayModelState walletRefundDisplayModelState) {
        Intrinsics.checkNotNullParameter(walletTransactionRefundView, "this$0");
        walletTransactionRefundView.updateRevertResult(walletRefundDisplayModelState);
    }

    /* access modifiers changed from: private */
    /* renamed from: addObservers$lambda-5  reason: not valid java name */
    public static final void m6089addObservers$lambda5(WalletTransactionRefundView walletTransactionRefundView, WalletOrderDetailModelState walletOrderDetailModelState) {
        Intrinsics.checkNotNullParameter(walletTransactionRefundView, "this$0");
        walletTransactionRefundView.updateOrderDetail(walletOrderDetailModelState);
    }

    private final void displayRefundView(boolean z11) {
        FullScreenLoaderInterface fullScreenLoaderInterface = this.fullScreenLoaderListener;
        if (fullScreenLoaderInterface != null) {
            fullScreenLoaderInterface.hideLoader();
        }
        if (z11) {
            showRefundEntryView();
        } else {
            showRefundFAQView();
        }
    }

    private final WalletTransactionDetailPaymentViewModel getPaymentViewModel() {
        return (WalletTransactionDetailPaymentViewModel) this.paymentViewModel$delegate.getValue();
    }

    private final WalletTransactionDetailRefundViewModel getRefundViewModel() {
        return (WalletTransactionDetailRefundViewModel) this.refundViewModel$delegate.getValue();
    }

    private final void openBottomSheet(WalletRefundBottomSheetDisplayModel walletRefundBottomSheetDisplayModel) {
        this.bottomSheet = new WalletTransactionDetailRefundBottomSheet(walletRefundBottomSheetDisplayModel, this);
        Context context = getContext();
        if (context != null) {
            FragmentManager supportFragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
            supportFragmentManager.beginTransaction();
            WalletTransactionDetailRefundBottomSheet walletTransactionDetailRefundBottomSheet = this.bottomSheet;
            if (walletTransactionDetailRefundBottomSheet != null) {
                walletTransactionDetailRefundBottomSheet.show(supportFragmentManager, "");
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    }

    /* access modifiers changed from: private */
    public final WalletTransactionDetailPaymentViewModel paymentViewModelBuilder() {
        return WalletTransactionDetailViewModelBuilder.Companion.getWalletTransactionDetailPaymentViewModel();
    }

    /* access modifiers changed from: private */
    public final WalletTransactionDetailPaymentViewModel setupPaymentViewModel() {
        CreateCustomViewViewModel createCustomViewViewModel = this.mCreateCustomViewViewModel;
        ViewModel viewModel = ViewModelProviders.of(createCustomViewViewModel.getActivity(), (ViewModelProvider.Factory) new WalletTransactionRefundView$setupPaymentViewModel$$inlined$createViewModel$1(this)).get(String.valueOf(R.layout.view_wallet_transaction_detail_refund_view), WalletTransactionDetailPaymentViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(activity, factory).get(key, T::class.java)");
        return (WalletTransactionDetailPaymentViewModel) viewModel;
    }

    /* access modifiers changed from: private */
    public final WalletTransactionDetailRefundViewModel setupRefundViewModel() {
        CreateCustomViewViewModel createCustomViewViewModel = this.mCreateCustomViewViewModel;
        ViewModel viewModel = ViewModelProviders.of(createCustomViewViewModel.getActivity(), (ViewModelProvider.Factory) new WalletTransactionRefundView$setupRefundViewModel$$inlined$createViewModel$1(this)).get(String.valueOf(R.layout.view_wallet_transaction_detail_refund_view), WalletTransactionDetailRefundViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(activity, factory).get(key, T::class.java)");
        return (WalletTransactionDetailRefundViewModel) viewModel;
    }

    private final void showRefundEntryView() {
        FullScreenLoaderInterface fullScreenLoaderInterface = this.fullScreenLoaderListener;
        if (fullScreenLoaderInterface != null) {
            fullScreenLoaderInterface.hideLoader();
        }
        ((TextView) _$_findCachedViewById(R.id.refund_message)).setText(getContext().getString(com.talabat.localization.R.string.bank_revert_message, new Object[]{String.valueOf(this.displayModel.getRefundDisplay().getRevertMinDays()), String.valueOf(this.displayModel.getRefundDisplay().getRevertMaxDays())}));
        ((ConstraintLayout) _$_findCachedViewById(R.id.initialize_revert_container)).setVisibility(0);
        ((ConstraintLayout) _$_findCachedViewById(R.id.revert_sent_container)).setVisibility(8);
    }

    private final void showRefundFAQView() {
        ((ConstraintLayout) _$_findCachedViewById(R.id.initialize_revert_container)).setVisibility(8);
        ((ConstraintLayout) _$_findCachedViewById(R.id.revert_sent_container)).setVisibility(8);
        ((TextView) _$_findCachedViewById(R.id.need_help_link)).setVisibility(0);
    }

    private final void showRestaurantIcon(String str) {
        Context context = getContext();
        if (context != null) {
            ImageDownloadHelper.Companion companion = ImageDownloadHelper.Companion;
            ImageView imageView = (ImageView) _$_findCachedViewById(R.id.restaurant_icon);
            Intrinsics.checkNotNullExpressionValue(imageView, "restaurant_icon");
            ImageDownloadHelper.Companion.downloadImageSpecificTransform$default(companion, context, str, imageView, 0, 0, TransformType.CIRCLE_CROP, 24, (Object) null);
        }
    }

    private final void showRevertSentView() {
        FullScreenLoaderInterface fullScreenLoaderInterface = this.fullScreenLoaderListener;
        if (fullScreenLoaderInterface != null) {
            fullScreenLoaderInterface.hideLoader();
        }
        ((ConstraintLayout) _$_findCachedViewById(R.id.initialize_revert_container)).setVisibility(8);
        ((ConstraintLayout) _$_findCachedViewById(R.id.revert_sent_container)).setVisibility(0);
        PaymentMethod.Companion companion = PaymentMethod.Companion;
        PaymentMethod fromInt = companion.fromInt(this.displayModel.getPaymentDisplay().getPaymentMethod());
        String cardType = this.displayModel.getPaymentDisplay().getCardType();
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.credit_card_icon);
        Intrinsics.checkNotNullExpressionValue(imageView, "credit_card_icon");
        displayPaymentIcon(fromInt, cardType, imageView);
        PaymentMethod fromInt2 = companion.fromInt(this.displayModel.getPaymentDisplay().getPaymentMethod());
        String cardType2 = this.displayModel.getPaymentDisplay().getCardType();
        String takeLast = StringsKt___StringsKt.takeLast(this.displayModel.getPaymentDisplay().getCard4Digits(), 4);
        TextView textView = (TextView) _$_findCachedViewById(R.id.card_name);
        Intrinsics.checkNotNullExpressionValue(textView, "card_name");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        displayPaymentName(fromInt2, cardType2, takeLast, textView, context);
        ((TextView) _$_findCachedViewById(R.id.bank_refund_duration_message)).setText(getContext().getString(com.talabat.localization.R.string.bank_revert_message, new Object[]{String.valueOf(this.displayModel.getRefundDisplay().getRevertMinDays()), String.valueOf(this.displayModel.getRefundDisplay().getRevertMaxDays())}));
    }

    private final void updateCanRevertRefund(WalletRefundDisplayModelState walletRefundDisplayModelState) {
        if (walletRefundDisplayModelState instanceof WalletRefundDisplayModelState.Error) {
            FullScreenLoaderInterface fullScreenLoaderInterface = this.fullScreenLoaderListener;
            if (fullScreenLoaderInterface != null) {
                fullScreenLoaderInterface.showError(((WalletRefundDisplayModelState.Error) walletRefundDisplayModelState).getErrorMsg());
            }
        } else if (walletRefundDisplayModelState instanceof WalletRefundDisplayModelState.SuccessRefundApiCall) {
            displayRefundView(((WalletRefundDisplayModelState.SuccessRefundApiCall) walletRefundDisplayModelState).getData());
        }
    }

    private final void updateOrderDetail(WalletOrderDetailModelState walletOrderDetailModelState) {
        WalletRefundOrderDetailInterface walletRefundOrderDetailInterface;
        if (walletOrderDetailModelState instanceof WalletOrderDetailModelState.Loading) {
            FullScreenLoaderInterface fullScreenLoaderInterface = this.fullScreenLoaderListener;
            if (fullScreenLoaderInterface != null) {
                fullScreenLoaderInterface.showLoader();
            }
        } else if (walletOrderDetailModelState instanceof WalletOrderDetailModelState.Error) {
            FullScreenLoaderInterface fullScreenLoaderInterface2 = this.fullScreenLoaderListener;
            if (fullScreenLoaderInterface2 != null) {
                fullScreenLoaderInterface2.showError(((WalletOrderDetailModelState.Error) walletOrderDetailModelState).getErrorMsg());
            }
        } else if ((walletOrderDetailModelState instanceof WalletOrderDetailModelState.SuccessOrderDetail) && (walletRefundOrderDetailInterface = this.listener) != null) {
            walletRefundOrderDetailInterface.navigateToOrderDetail(((WalletOrderDetailModelState.SuccessOrderDetail) walletOrderDetailModelState).getData());
        }
    }

    private final void updateRevertResult(WalletRefundDisplayModelState walletRefundDisplayModelState) {
        WalletTransactionDetailRefundBottomSheet walletTransactionDetailRefundBottomSheet;
        if (walletRefundDisplayModelState instanceof WalletRefundDisplayModelState.Error) {
            WalletTransactionDetailRefundBottomSheet walletTransactionDetailRefundBottomSheet2 = this.bottomSheet;
            if (walletTransactionDetailRefundBottomSheet2 != null) {
                walletTransactionDetailRefundBottomSheet2.showErrorResult();
            }
        } else if ((walletRefundDisplayModelState instanceof WalletRefundDisplayModelState.SuccessRefundApiCall) && (walletTransactionDetailRefundBottomSheet = this.bottomSheet) != null) {
            walletTransactionDetailRefundBottomSheet.showResult(((WalletRefundDisplayModelState.SuccessRefundApiCall) walletRefundDisplayModelState).getData());
        }
    }

    /* access modifiers changed from: private */
    public final WalletTransactionDetailRefundViewModel viewModelBuilder() {
        return WalletTransactionDetailViewModelBuilder.Companion.getWalletTransactionDetailRefundViewModel(getConfigurationLocalRepository());
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

    public final void addViewToParent(@NotNull RefundWalletTransactionTypeDisplayModel refundWalletTransactionTypeDisplayModel) {
        Intrinsics.checkNotNullParameter(refundWalletTransactionTypeDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        this.displayModel = refundWalletTransactionTypeDisplayModel;
        showRestaurantIcon(refundWalletTransactionTypeDisplayModel.getRestaurantDisplay().getImageUrl());
        ((TextView) _$_findCachedViewById(R.id.restaurant_name)).setText(this.displayModel.getRestaurantDisplay().getName());
        ((TextView) _$_findCachedViewById(R.id.refund_days)).setText(getContext().getString(com.talabat.localization.R.string.refund_expiry_date_string, new Object[]{String.valueOf(this.displayModel.getHeaderInfo().getExpiryDays())}));
        ((TextView) _$_findCachedViewById(R.id.refund_reason)).setText(this.displayModel.getRefundDisplay().getReason());
        if (this.displayModel.getRefundDisplay().getRevertStatus() == PSPRevertStatus.NotInitiated.getValue()) {
            getRefundViewModel().onLoadCanRevertRefundToBank(this.displayModel.getHeaderInfo().getOrderId());
        } else {
            showRevertSentView();
        }
    }

    public void displayPaymentIcon(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentIcon(this, paymentMethod, str, imageView);
    }

    public void displayPaymentName(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull String str2, @NotNull TextView textView, @NotNull Context context) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentName(this, paymentMethod, str, str2, textView, context);
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

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        FragmentActivity scanForActivity = this.mCreateCustomViewViewModel.scanForActivity(getContext());
        if (!(scanForActivity instanceof LifecycleOwner)) {
            scanForActivity = null;
        }
        if (scanForActivity != null) {
            scanForActivity.getLifecycle().addObserver(this);
            addObservers(scanForActivity);
            return;
        }
        throw new LifecycleOwnerNotFoundException();
    }

    public void revertRefundFromBottomSheet() {
        getRefundViewModel().onLoadRevertRefundToBank(this.displayModel.getHeaderInfo().getOrderId());
    }

    public void setCardTypeIcon(@Nullable String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.setCardTypeIcon(this, str, imageView);
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public void setExpiryInformation(@NotNull String str, @NotNull String str2, @NotNull TextView textView, @Nullable Context context) {
        CreditCardHelperInterface.DefaultImpls.setExpiryInformation(this, str, str2, textView, context);
    }

    public final void setFullScreenLoaderListener(@Nullable FullScreenLoaderInterface fullScreenLoaderInterface) {
        this.fullScreenLoaderListener = fullScreenLoaderInterface;
    }

    public final void setWalletRefundOrderDetailListener(@NotNull WalletRefundOrderDetailInterface walletRefundOrderDetailInterface) {
        Intrinsics.checkNotNullParameter(walletRefundOrderDetailInterface, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = walletRefundOrderDetailInterface;
    }

    public void showRefundRevertedSuccessfulViews() {
        showRevertSentView();
        WalletRefundOrderDetailInterface walletRefundOrderDetailInterface = this.listener;
        if (walletRefundOrderDetailInterface != null) {
            walletRefundOrderDetailInterface.updateRefundRevertedStatus();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTransactionRefundView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.displayModel = new RefundWalletTransactionTypeDisplayModel((PaymentWalletTransactionDisplayModel) null, (RestaurantWalletTransactionDisplayModel) null, (RefundWalletTransactionDisplayModel) null, (WalletTransactionDetailHeaderDisplayModel) null, 15, (DefaultConstructorMarker) null);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.refundViewModel$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new WalletTransactionRefundView$refundViewModel$2(this));
        this.paymentViewModel$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new WalletTransactionRefundView$paymentViewModel$2(this));
        DaggerWalletTransactionRefundViewComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationLocalCoreLibApi.class)).inject(this);
        View.inflate(getContext(), R.layout.view_wallet_transaction_detail_refund_view, this);
        FullScreenLoaderInterface fullScreenLoaderInterface = this.fullScreenLoaderListener;
        if (fullScreenLoaderInterface != null) {
            fullScreenLoaderInterface.showLoader();
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.mCreateCustomViewViewModel = new CreateCustomViewViewModel(context2);
        ((LinearLayout) _$_findCachedViewById(R.id.send_refund)).setOnClickListener(new g(this));
        ((ConstraintLayout) _$_findCachedViewById(R.id.restaurant_info_container)).setOnClickListener(new h(this));
        ((TextView) _$_findCachedViewById(R.id.need_help_link)).setOnClickListener(new i(this));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTransactionRefundView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.displayModel = new RefundWalletTransactionTypeDisplayModel((PaymentWalletTransactionDisplayModel) null, (RestaurantWalletTransactionDisplayModel) null, (RefundWalletTransactionDisplayModel) null, (WalletTransactionDetailHeaderDisplayModel) null, 15, (DefaultConstructorMarker) null);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.refundViewModel$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new WalletTransactionRefundView$refundViewModel$2(this));
        this.paymentViewModel$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new WalletTransactionRefundView$paymentViewModel$2(this));
        DaggerWalletTransactionRefundViewComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationLocalCoreLibApi.class)).inject(this);
        View.inflate(getContext(), R.layout.view_wallet_transaction_detail_refund_view, this);
        FullScreenLoaderInterface fullScreenLoaderInterface = this.fullScreenLoaderListener;
        if (fullScreenLoaderInterface != null) {
            fullScreenLoaderInterface.showLoader();
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.mCreateCustomViewViewModel = new CreateCustomViewViewModel(context2);
        ((LinearLayout) _$_findCachedViewById(R.id.send_refund)).setOnClickListener(new g(this));
        ((ConstraintLayout) _$_findCachedViewById(R.id.restaurant_info_container)).setOnClickListener(new h(this));
        ((TextView) _$_findCachedViewById(R.id.need_help_link)).setOnClickListener(new i(this));
    }
}
