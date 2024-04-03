package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.enums.OrderStatus;
import com.talabat.talabatcommon.exception.LifecycleOwnerNotFoundException;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.di.factory.DaggerOrderConfirmationRiderTipViewComponent;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.di.factory.OrderConfirmationRiderTipViewModelFactory;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderBottomSheetState;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderSource;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.displaymodel.OrderConfirmationRiderTipDisplayModel;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.viewmodel.OrderConfirmationRiderTipViewModel;
import com.talabat.talabatcommon.views.ridersTip.bottomSheet.RiderTipBottomSheetDialogFragment;
import com.talabat.talabatcommon.views.ridersTip.bottomSheet.RiderTipStatusListener;
import com.talabat.talabatcore.viewmodel.CreateCustomViewViewModel;
import cv.a;
import cv.b;
import cv.c;
import cv.d;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020!H\u0014J\b\u0010'\u001a\u00020!H\u0016J\u001a\u0010(\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010*J\b\u0010,\u001a\u00020\u001bH\u0002J\u0010\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020!H\u0002J\u0010\u00101\u001a\u00020!2\b\u00102\u001a\u0004\u0018\u000103J\b\u00104\u001a\u00020!H\u0002J\u0010\u00105\u001a\u00020!2\b\u00102\u001a\u0004\u0018\u000103J\u0012\u00106\u001a\u00020!2\b\u00107\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u00108\u001a\u00020\u001bH\u0002R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d¨\u00069"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/view/OrderConfirmationRiderTipView;", "Landroid/widget/LinearLayout;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/talabat/talabatcommon/views/ridersTip/bottomSheet/RiderTipStatusListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepo", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepo", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "mCreateCustomViewViewModel", "Lcom/talabat/talabatcore/viewmodel/CreateCustomViewViewModel;", "riderTipStatusDataObserver", "Landroidx/lifecycle/Observer;", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/presentation/displaymodel/OrderConfirmationRiderTipDisplayModel;", "viewModel", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/presentation/viewmodel/OrderConfirmationRiderTipViewModel;", "getViewModel", "()Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/presentation/viewmodel/OrderConfirmationRiderTipViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addObservers", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "hideRiderTipView", "initDagger", "onAttachedToWindow", "riderTippedSuccessfully", "setOrderDetail", "encryptedOrderId", "", "orderId", "setupOrderConfirmationRiderTipViewModel", "showRiderTipBottomSheet", "tipRiderState", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderBottomSheetState;", "showRiderTipChildView", "showRiderTipStatusView", "orderStatus", "Lcom/talabat/talabatcommon/enums/OrderStatus;", "showTipRiderGivenView", "updateOrderStatus", "updateRiderTipStatusData", "orderConfirmationRiderTipDisplayModel", "viewModelBuilder", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderConfirmationRiderTipView extends LinearLayout implements LifecycleObserver, RiderTipStatusListener {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public ITalabatFeatureFlag featureFlagRepo;
    private Lifecycle lifecycle;
    @NotNull
    private CreateCustomViewViewModel mCreateCustomViewViewModel;
    @NotNull
    private final Observer<OrderConfirmationRiderTipDisplayModel> riderTipStatusDataObserver;
    @NotNull
    private final Lazy viewModel$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderConfirmationRiderTipView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new OrderConfirmationRiderTipView$viewModel$2(this));
        initDagger();
        View.inflate(getContext(), R.layout.view_order_confirmation_rider_tip, this);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.mCreateCustomViewViewModel = new CreateCustomViewViewModel(context2);
        ((TextView) _$_findCachedViewById(R.id.tip_rider_text_view)).setOnClickListener(new a(this));
        ((ImageView) _$_findCachedViewById(R.id.tip_rider_info_icon)).setOnClickListener(new b(this));
        ((ImageView) _$_findCachedViewById(R.id.tip_rider_thank_you_info_icon)).setOnClickListener(new c(this));
        this.riderTipStatusDataObserver = new d(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m10926_init_$lambda0(OrderConfirmationRiderTipView orderConfirmationRiderTipView, View view) {
        Intrinsics.checkNotNullParameter(orderConfirmationRiderTipView, "this$0");
        orderConfirmationRiderTipView.getViewModel().setSource(TipRiderSource.ORDER_CONFIRMATION_SCREEN);
        orderConfirmationRiderTipView.showRiderTipBottomSheet(TipRiderBottomSheetState.OPEN_PAYMENT_WIDGET);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m10927_init_$lambda1(OrderConfirmationRiderTipView orderConfirmationRiderTipView, View view) {
        Intrinsics.checkNotNullParameter(orderConfirmationRiderTipView, "this$0");
        orderConfirmationRiderTipView.getViewModel().setSource(TipRiderSource.INFO_BOTTOM_SHEET);
        orderConfirmationRiderTipView.showRiderTipBottomSheet(TipRiderBottomSheetState.OPEN_INFO_WITHOUT_TIP_AGAIN);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m10928_init_$lambda2(OrderConfirmationRiderTipView orderConfirmationRiderTipView, View view) {
        Intrinsics.checkNotNullParameter(orderConfirmationRiderTipView, "this$0");
        orderConfirmationRiderTipView.getViewModel().setSource(TipRiderSource.INFO_BOTTOM_SHEET);
        orderConfirmationRiderTipView.showRiderTipBottomSheet(TipRiderBottomSheetState.OPEN_INFO_WITH_TIP_AGAIN);
    }

    private final void addObservers(LifecycleOwner lifecycleOwner) {
        getViewModel().getRiderTipStatusDisplayModel().observe(lifecycleOwner, this.riderTipStatusDataObserver);
    }

    private final OrderConfirmationRiderTipViewModel getViewModel() {
        return (OrderConfirmationRiderTipViewModel) this.viewModel$delegate.getValue();
    }

    private final void hideRiderTipView() {
        ((ConstraintLayout) _$_findCachedViewById(R.id.rider_tip_card)).setVisibility(8);
    }

    private final void initDagger() {
        DaggerOrderConfirmationRiderTipViewComponent.factory().create((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: riderTipStatusDataObserver$lambda-4  reason: not valid java name */
    public static final void m10929riderTipStatusDataObserver$lambda4(OrderConfirmationRiderTipView orderConfirmationRiderTipView, OrderConfirmationRiderTipDisplayModel orderConfirmationRiderTipDisplayModel) {
        Intrinsics.checkNotNullParameter(orderConfirmationRiderTipView, "this$0");
        orderConfirmationRiderTipView.updateRiderTipStatusData(orderConfirmationRiderTipDisplayModel);
    }

    /* access modifiers changed from: private */
    public final OrderConfirmationRiderTipViewModel setupOrderConfirmationRiderTipViewModel() {
        CreateCustomViewViewModel createCustomViewViewModel = this.mCreateCustomViewViewModel;
        ViewModel viewModel = ViewModelProviders.of(createCustomViewViewModel.getActivity(), (ViewModelProvider.Factory) new OrderConfirmationRiderTipView$setupOrderConfirmationRiderTipViewModel$$inlined$createViewModel$1(this)).get(String.valueOf(R.layout.view_order_confirmation_rider_tip), OrderConfirmationRiderTipViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(activity, factory).get(key, T::class.java)");
        return (OrderConfirmationRiderTipViewModel) viewModel;
    }

    private final void showRiderTipBottomSheet(TipRiderBottomSheetState tipRiderBottomSheetState) {
        RiderTipBottomSheetDialogFragment riderTipBottomSheetDialogFragment = new RiderTipBottomSheetDialogFragment(this, tipRiderBottomSheetState, getViewModel().getSource(), getViewModel().getOrderStatus(), getViewModel().getOrderId(), getViewModel().getEncryptedOrderId(), getViewModel().getSource().getScreenName(), (Float) null, 128, (DefaultConstructorMarker) null);
        Bundle bundle = new Bundle();
        bundle.putString("encryptedOrderId", getViewModel().getEncryptedOrderId());
        bundle.putString("orderId", getViewModel().getOrderId());
        riderTipBottomSheetDialogFragment.setArguments(bundle);
        Context context = getContext();
        if (context != null) {
            FragmentManager supportFragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
            supportFragmentManager.beginTransaction();
            riderTipBottomSheetDialogFragment.show(supportFragmentManager, "");
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    }

    private final void showRiderTipChildView() {
        ((ConstraintLayout) _$_findCachedViewById(R.id.rider_tip_card)).setVisibility(0);
        ((ConstraintLayout) _$_findCachedViewById(R.id.tip_rider_given)).setVisibility(8);
    }

    private final void showTipRiderGivenView() {
        ((ConstraintLayout) _$_findCachedViewById(R.id.rider_info_child_view)).setVisibility(8);
        ((ConstraintLayout) _$_findCachedViewById(R.id.tip_rider_given)).setVisibility(0);
    }

    private final void updateRiderTipStatusData(OrderConfirmationRiderTipDisplayModel orderConfirmationRiderTipDisplayModel) {
        if (Intrinsics.areEqual((Object) orderConfirmationRiderTipDisplayModel, (Object) OrderConfirmationRiderTipDisplayModel.ShowOrderConfirmationRiderTip.INSTANCE)) {
            showRiderTipChildView();
        } else if (Intrinsics.areEqual((Object) orderConfirmationRiderTipDisplayModel, (Object) OrderConfirmationRiderTipDisplayModel.HideOrderConfirmationRiderTip.INSTANCE)) {
            hideRiderTipView();
        } else if (Intrinsics.areEqual((Object) orderConfirmationRiderTipDisplayModel, (Object) OrderConfirmationRiderTipDisplayModel.ShowRiderTipGiven.INSTANCE)) {
            showTipRiderGivenView();
        }
    }

    /* access modifiers changed from: private */
    public final OrderConfirmationRiderTipViewModel viewModelBuilder() {
        return OrderConfirmationRiderTipViewModelFactory.INSTANCE.getOrderConfirmationRiderTipViewModel(getFeatureFlagRepo());
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

    @NotNull
    public final ITalabatFeatureFlag getFeatureFlagRepo() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.featureFlagRepo;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlagRepo");
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
            Lifecycle lifecycle2 = scanForActivity.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle2, "lifecycleOwner.lifecycle");
            this.lifecycle = lifecycle2;
            addObservers(scanForActivity);
            Lifecycle lifecycle3 = scanForActivity.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle3, "lifecycleOwner.lifecycle");
            this.lifecycle = lifecycle3;
            return;
        }
        throw new LifecycleOwnerNotFoundException();
    }

    public void riderTippedSuccessfully() {
        getViewModel().onRiderTipGiven();
    }

    public final void setFeatureFlagRepo(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    public final void setOrderDetail(@Nullable String str, @Nullable String str2) {
        getViewModel().setOrderDetails(str, str2);
    }

    public final void showRiderTipStatusView(@Nullable OrderStatus orderStatus) {
        getViewModel().onShowRiderTip(orderStatus);
    }

    public final void updateOrderStatus(@Nullable OrderStatus orderStatus) {
        getViewModel().onUpdateOrderStatus(orderStatus);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderConfirmationRiderTipView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new OrderConfirmationRiderTipView$viewModel$2(this));
        initDagger();
        View.inflate(getContext(), R.layout.view_order_confirmation_rider_tip, this);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.mCreateCustomViewViewModel = new CreateCustomViewViewModel(context2);
        ((TextView) _$_findCachedViewById(R.id.tip_rider_text_view)).setOnClickListener(new a(this));
        ((ImageView) _$_findCachedViewById(R.id.tip_rider_info_icon)).setOnClickListener(new b(this));
        ((ImageView) _$_findCachedViewById(R.id.tip_rider_thank_you_info_icon)).setOnClickListener(new c(this));
        this.riderTipStatusDataObserver = new d(this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderConfirmationRiderTipView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new OrderConfirmationRiderTipView$viewModel$2(this));
        initDagger();
        View.inflate(getContext(), R.layout.view_order_confirmation_rider_tip, this);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.mCreateCustomViewViewModel = new CreateCustomViewViewModel(context2);
        ((TextView) _$_findCachedViewById(R.id.tip_rider_text_view)).setOnClickListener(new a(this));
        ((ImageView) _$_findCachedViewById(R.id.tip_rider_info_icon)).setOnClickListener(new b(this));
        ((ImageView) _$_findCachedViewById(R.id.tip_rider_thank_you_info_icon)).setOnClickListener(new c(this));
        this.riderTipStatusDataObserver = new d(this);
    }
}
