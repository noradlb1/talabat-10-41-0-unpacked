package com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.exception.LifecycleOwnerNotFoundException;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import com.talabat.talabatcommon.utils.FullScreenLoaderInterface;
import com.talabat.talabatcommon.views.TalabatStrokeButton;
import com.talabat.talabatcore.viewmodel.CreateCustomViewViewModel;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.walletTransactionDetail.model.CashBackWalletTransactionModel;
import com.talabat.wallet.ui.walletTransactionDetail.model.PaidWalletTransactionTypeDisplayModel;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletOrderDetailModelState;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDetailHeaderDisplayModel;
import com.talabat.wallet.ui.walletTransactionDetail.viewModel.WalletTransactionDetailPaymentViewModel;
import com.talabat.wallet.ui.walletTransactionDetail.viewModel.WalletTransactionDetailViewModelBuilder;
import datamodels.OrderDetails;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kz.a;
import kz.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\rJ\b\u0010\u001d\u001a\u00020\u001bH\u0014J\u0010\u0010\u001e\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u001f\u001a\u00020\u001b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010 \u001a\u00020\u0015H\u0002J\u0012\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\b\u0010$\u001a\u00020\u0015H\u0002R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/view/walletTransactionBodyView/WalletDetailTransactionPaidView;", "Landroid/widget/LinearLayout;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "displayModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/PaidWalletTransactionTypeDisplayModel;", "fullScreenLoaderListener", "Lcom/talabat/talabatcommon/utils/FullScreenLoaderInterface;", "listener", "Lcom/talabat/wallet/ui/walletTransactionDetail/view/walletTransactionBodyView/WalletDetailTransactionPaidView$WalletPaidDetailOrderDetailInterface;", "mCreateCustomViewViewModel", "Lcom/talabat/talabatcore/viewmodel/CreateCustomViewViewModel;", "viewModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/viewModel/WalletTransactionDetailPaymentViewModel;", "getViewModel", "()Lcom/talabat/wallet/ui/walletTransactionDetail/viewModel/WalletTransactionDetailPaymentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addViewToParent", "", "model", "onAttachedToWindow", "setFullScreenLoaderListener", "setWalletPaidDetailOrderDetailListener", "setupViewModel", "updateOrderDetail", "walletOrderDetailModelState", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletOrderDetailModelState;", "viewModelBuilder", "WalletPaidDetailOrderDetailInterface", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDetailTransactionPaidView extends LinearLayout implements LifecycleObserver {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private PaidWalletTransactionTypeDisplayModel displayModel;
    @Nullable
    private FullScreenLoaderInterface fullScreenLoaderListener;
    @Nullable
    private WalletPaidDetailOrderDetailInterface listener;
    private CreateCustomViewViewModel mCreateCustomViewViewModel;
    @NotNull
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/view/walletTransactionBodyView/WalletDetailTransactionPaidView$WalletPaidDetailOrderDetailInterface;", "", "navigateToOrderDetail", "", "orderDetail", "Ldatamodels/OrderDetails;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface WalletPaidDetailOrderDetailInterface {
        void navigateToOrderDetail(@NotNull OrderDetails orderDetails);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDetailTransactionPaidView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.displayModel = new PaidWalletTransactionTypeDisplayModel((CashBackWalletTransactionModel) null, (WalletTransactionDetailHeaderDisplayModel) null, (Country) null, 7, (DefaultConstructorMarker) null);
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new WalletDetailTransactionPaidView$viewModel$2(this));
        View.inflate(getContext(), R.layout.view_wallet_transaction_detail_payment_view, this);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.mCreateCustomViewViewModel = new CreateCustomViewViewModel(context2);
        ((TalabatStrokeButton) _$_findCachedViewById(R.id.view_order_summary_button)).setOnClickListener(new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m6081_init_$lambda0(WalletDetailTransactionPaidView walletDetailTransactionPaidView, View view) {
        Intrinsics.checkNotNullParameter(walletDetailTransactionPaidView, "this$0");
        walletDetailTransactionPaidView.getViewModel().onLoadOrderDetail(walletDetailTransactionPaidView.displayModel.getHeaderInfo().getOrderId());
    }

    private final WalletTransactionDetailPaymentViewModel getViewModel() {
        return (WalletTransactionDetailPaymentViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachedToWindow$lambda-3  reason: not valid java name */
    public static final void m6082onAttachedToWindow$lambda3(WalletDetailTransactionPaidView walletDetailTransactionPaidView, WalletOrderDetailModelState walletOrderDetailModelState) {
        Intrinsics.checkNotNullParameter(walletDetailTransactionPaidView, "this$0");
        walletDetailTransactionPaidView.updateOrderDetail(walletOrderDetailModelState);
    }

    /* access modifiers changed from: private */
    public final WalletTransactionDetailPaymentViewModel setupViewModel() {
        CreateCustomViewViewModel createCustomViewViewModel = this.mCreateCustomViewViewModel;
        if (createCustomViewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCreateCustomViewViewModel");
            createCustomViewViewModel = null;
        }
        ViewModel viewModel = ViewModelProviders.of(createCustomViewViewModel.getActivity(), (ViewModelProvider.Factory) new WalletDetailTransactionPaidView$setupViewModel$$inlined$createViewModel$1(this)).get(String.valueOf(R.layout.view_wallet_transaction_detail_payment_view), WalletTransactionDetailPaymentViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(activity, factory).get(key, T::class.java)");
        return (WalletTransactionDetailPaymentViewModel) viewModel;
    }

    private final void updateOrderDetail(WalletOrderDetailModelState walletOrderDetailModelState) {
        WalletPaidDetailOrderDetailInterface walletPaidDetailOrderDetailInterface;
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
        } else if ((walletOrderDetailModelState instanceof WalletOrderDetailModelState.SuccessOrderDetail) && (walletPaidDetailOrderDetailInterface = this.listener) != null) {
            walletPaidDetailOrderDetailInterface.navigateToOrderDetail(((WalletOrderDetailModelState.SuccessOrderDetail) walletOrderDetailModelState).getData());
        }
    }

    /* access modifiers changed from: private */
    public final WalletTransactionDetailPaymentViewModel viewModelBuilder() {
        return WalletTransactionDetailViewModelBuilder.Companion.getWalletTransactionDetailPaymentViewModel();
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

    public final void addViewToParent(@NotNull PaidWalletTransactionTypeDisplayModel paidWalletTransactionTypeDisplayModel) {
        boolean z11;
        Intrinsics.checkNotNullParameter(paidWalletTransactionTypeDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        this.displayModel = paidWalletTransactionTypeDisplayModel;
        boolean z12 = true;
        if (paidWalletTransactionTypeDisplayModel.getHeaderInfo().getOrderId().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            ((TalabatStrokeButton) _$_findCachedViewById(R.id.view_order_summary_button)).setVisibility(0);
        }
        if (paidWalletTransactionTypeDisplayModel.getSelectedCountry() == Country.OMAN) {
            ((TextView) _$_findCachedViewById(R.id.tpay_logo)).setText(ViewKt.getString(this, com.talabat.localization.R.string.talabat_pay_oman));
        }
        LocationConfigurationRepository locationConfigurationRepository = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationRemoteCoreLibApi.class)).getLocationConfigurationRepository();
        ((TextView) _$_findCachedViewById(R.id.tpay_amount)).setText(CurrencyFormatter.Companion.formatAmountWithSign(locationConfigurationRepository, this.displayModel.getHeaderInfo().getAmount(), true));
        Context context = getContext();
        if (context != null) {
            if (this.displayModel.getCashBack().getAmount() != 0.0f) {
                z12 = false;
            }
            if (!z12) {
                WalletTransactionDetailCashBackView walletTransactionDetailCashBackView = WalletTransactionDetailCashBackView.INSTANCE;
                View _$_findCachedViewById = _$_findCachedViewById(R.id.paid_cash_back_container);
                Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "paid_cash_back_container");
                TextView textView = (TextView) _$_findCachedViewById(R.id.cashback_amount);
                Intrinsics.checkNotNullExpressionValue(textView, "cashback_amount");
                walletTransactionDetailCashBackView.addCashBackView(locationConfigurationRepository, context, _$_findCachedViewById, textView, this.displayModel.getCashBack().getAmount(), com.talabat.talabatcommon.R.color.talabat_red);
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        CreateCustomViewViewModel createCustomViewViewModel = this.mCreateCustomViewViewModel;
        FragmentActivity fragmentActivity = null;
        if (createCustomViewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCreateCustomViewViewModel");
            createCustomViewViewModel = null;
        }
        FragmentActivity scanForActivity = createCustomViewViewModel.scanForActivity(getContext());
        if (scanForActivity instanceof LifecycleOwner) {
            fragmentActivity = scanForActivity;
        }
        if (fragmentActivity != null) {
            fragmentActivity.getLifecycle().addObserver(this);
            getViewModel().getOrderDetailData().observe(fragmentActivity, new b(this));
            return;
        }
        throw new LifecycleOwnerNotFoundException();
    }

    public final void setFullScreenLoaderListener(@Nullable FullScreenLoaderInterface fullScreenLoaderInterface) {
        this.fullScreenLoaderListener = fullScreenLoaderInterface;
    }

    public final void setWalletPaidDetailOrderDetailListener(@Nullable WalletPaidDetailOrderDetailInterface walletPaidDetailOrderDetailInterface) {
        this.listener = walletPaidDetailOrderDetailInterface;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDetailTransactionPaidView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.displayModel = new PaidWalletTransactionTypeDisplayModel((CashBackWalletTransactionModel) null, (WalletTransactionDetailHeaderDisplayModel) null, (Country) null, 7, (DefaultConstructorMarker) null);
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new WalletDetailTransactionPaidView$viewModel$2(this));
        View.inflate(getContext(), R.layout.view_wallet_transaction_detail_payment_view, this);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.mCreateCustomViewViewModel = new CreateCustomViewViewModel(context2);
        ((TalabatStrokeButton) _$_findCachedViewById(R.id.view_order_summary_button)).setOnClickListener(new a(this));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDetailTransactionPaidView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.displayModel = new PaidWalletTransactionTypeDisplayModel((CashBackWalletTransactionModel) null, (WalletTransactionDetailHeaderDisplayModel) null, (Country) null, 7, (DefaultConstructorMarker) null);
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new WalletDetailTransactionPaidView$viewModel$2(this));
        View.inflate(getContext(), R.layout.view_wallet_transaction_detail_payment_view, this);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.mCreateCustomViewViewModel = new CreateCustomViewViewModel(context2);
        ((TalabatStrokeButton) _$_findCachedViewById(R.id.view_order_summary_button)).setOnClickListener(new a(this));
    }
}
