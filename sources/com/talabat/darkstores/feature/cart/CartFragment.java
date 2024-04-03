package com.talabat.darkstores.feature.cart;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.fragment.FragmentKt;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.common.base.BaseFragment;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.darkstores.common.customScrollingViews.CustomVerticalRecyclerView;
import com.talabat.darkstores.common.extensions.ContextExtensionsKt;
import com.talabat.darkstores.common.extensions.FloatExtensionsKt;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$1;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$2;
import com.talabat.darkstores.common.view.CartErrorDialog;
import com.talabat.darkstores.data.DarkstoresConstantsKt;
import com.talabat.darkstores.di.DaggerCartFragmentComponent;
import com.talabat.darkstores.feature.cart.CartFragmentDirections;
import com.talabat.darkstores.feature.cart.model.FeeDescriptionDisplayModel;
import com.talabat.darkstores.feature.cart.model.ScreenTrackingInfo;
import com.talabat.darkstores.feature.cart.views.CartProgressView;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.darkstores.feature.main.viewmodel.BottomSheetViewState;
import com.talabat.darkstores.feature.main.viewmodel.DeliveryTierBottomSheetViewState;
import com.talabat.darkstores.feature.main.viewmodel.DeliveryTierBottomSheetViewStateViewModel;
import com.talabat.darkstores.feature.main.viewmodel.DeliveryTierClickOrigin;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import com.talabat.feature.darkstorescart.data.model.CampaignLabel;
import com.talabat.feature.darkstorescart.data.model.CheckoutParams;
import com.talabat.feature.darkstorescart.data.model.FeeDescription;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.talabatcommon.views.bottomsheet.FeesDescriptionBottomSheetFragment;
import com.talabat.talabatcommon.views.bottomsheet.OnReadMoreInfoClickedCallback;
import com.talabat.wrapper.EventWrapper;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ri.j;
import ri.k;
import ri.l;
import ri.m;
import ri.n;
import ri.o;
import ri.p;
import ri.q;
import ri.r;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 r2\u00020\u00012\u00020\u0002:\u0001rB\u0007¢\u0006\u0004\bp\u0010qJ\u0018\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J&\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\r\u001a\u00020\fH\u0002J(\u0010\u001f\u001a\u00020\u0006*\u00020\u00192\b\b\u0001\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\f\u0010 \u001a\u00020\u0006*\u00020\u0019H\u0002J \u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\fH\u0002J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0002J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u001dH\u0002J\b\u0010(\u001a\u00020\u0006H\u0002J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u001dH\u0002J\u0016\u0010,\u001a\u00020\u00062\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0016\u0010-\u001a\u00020\u00062\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J*\u00102\u001a\u00020\u00062\b\b\u0001\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dH\u0002J\u0012\u00105\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u000103H\u0016J\u0010\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u000206H\u0016J\u001a\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00192\b\u00104\u001a\u0004\u0018\u000103H\u0016J\b\u0010;\u001a\u00020\u0006H\u0014J\b\u0010<\u001a\u00020\u0006H\u0016J\b\u0010=\u001a\u00020\u0006H\u0016J\b\u0010>\u001a\u00020\u0006H\u0016R\u001a\u0010?\u001a\u00020\u001a8\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020\u001d8\u0016XD¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001a\u0010H\u001a\u00020G8\u0016X\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001b\u0010Q\u001a\u00020L8BX\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020R8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\"\u0010V\u001a\u00020U8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010]\u001a\u00020\\8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001b\u0010g\u001a\u00020c8BX\u0002¢\u0006\f\n\u0004\bd\u0010N\u001a\u0004\be\u0010fR\u0018\u0010i\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\"\u0010n\u001a\u0010\u0012\f\u0012\n m*\u0004\u0018\u00010l0l0k8\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010o¨\u0006s"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartFragment;", "Lcom/talabat/darkstores/common/base/BaseFragment;", "Lcom/talabat/talabatcommon/views/bottomsheet/OnReadMoreInfoClickedCallback;", "Lcom/talabat/darkstores/common/Result;", "Lcom/talabat/darkstores/feature/cart/CartFragmentData;", "cartData", "", "setBtnCheckoutStatus", "data", "showData", "Lcom/talabat/darkstores/feature/cart/CartSummary;", "summary", "", "basketDeliveryFreeTierEnabled", "showCartSummary", "isVisible", "isTProCampaignApplied", "setDeliveryFeeLabelVisibility", "tProCampaignApplied", "", "serviceFee", "", "Lcom/talabat/feature/darkstorescart/data/model/FeeDescription;", "feeDescriptions", "setupServiceFeeViews", "Landroid/view/View;", "", "feeImageId", "feeDescription", "", "defaultUrl", "setupFeeInfoButton", "setupBasketDeliveryTierInfoButton", "visible", "setupServiceViewVisibility", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "product", "onProductClicked", "request", "onSpecialRequestChanged", "onPartialFulfillmentClicked", "age", "showAgeRestriction", "result", "checkIfAgeRestricted", "onCheckoutClicked", "imageId", "title", "description", "url", "openInfoBottomSheet", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "Landroid/content/Context;", "context", "onAttach", "view", "onViewCreated", "i0", "onRetryClicked", "onResume", "onReadMoreInfoClicked", "contentViewId", "I", "getContentViewId", "()I", "screenName", "Ljava/lang/String;", "getScreenName", "()Ljava/lang/String;", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "eventOriginType", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "getEventOriginType", "()Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "Lcom/talabat/darkstores/feature/main/viewmodel/DeliveryTierBottomSheetViewStateViewModel;", "bottomSheetViewStateViewModel$delegate", "Lkotlin/Lazy;", "getBottomSheetViewStateViewModel", "()Lcom/talabat/darkstores/feature/main/viewmodel/DeliveryTierBottomSheetViewStateViewModel;", "bottomSheetViewStateViewModel", "Lcom/talabat/darkstores/common/view/CartErrorDialog;", "cartSyncErrorDialog", "Lcom/talabat/darkstores/common/view/CartErrorDialog;", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "subscriptionsFlagsRepo", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "getSubscriptionsFlagsRepo", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "setSubscriptionsFlagsRepo", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;)V", "Lcom/talabat/customer/domain/CustomerRepository;", "customerRepository", "Lcom/talabat/customer/domain/CustomerRepository;", "getCustomerRepository", "()Lcom/talabat/customer/domain/CustomerRepository;", "setCustomerRepository", "(Lcom/talabat/customer/domain/CustomerRepository;)V", "Lcom/talabat/darkstores/feature/cart/CartListAdapter;", "adapter$delegate", "getAdapter", "()Lcom/talabat/darkstores/feature/cart/CartListAdapter;", "adapter", "Lcom/talabat/darkstores/feature/cart/model/FeeDescriptionDisplayModel;", "feeDescriptionsDisplayModel", "Lcom/talabat/darkstores/feature/cart/model/FeeDescriptionDisplayModel;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "startForResult", "Landroidx/activity/result/ActivityResultLauncher;", "<init>", "()V", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public final class CartFragment extends BaseFragment implements OnReadMoreInfoClickedCallback {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String SCREEN_NAME = "DS Cart";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final Lazy adapter$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new CartFragment$adapter$2(this));
    @NotNull
    private final Lazy bottomSheetViewStateViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DeliveryTierBottomSheetViewStateViewModel.class), new ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$1(this), new ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$2((Function0) null, this), new CartFragment$special$$inlined$activityViewModel$1());
    /* access modifiers changed from: private */
    @NotNull
    public CartErrorDialog cartSyncErrorDialog = new CartErrorDialog();
    private final int contentViewId = R.layout.darkstores_fragment_cart;
    @Inject
    public CustomerRepository customerRepository;
    @NotNull
    private final EventOriginType eventOriginType = EventOriginType.Cart;
    @Nullable
    private FeeDescriptionDisplayModel feeDescriptionsDisplayModel;
    @NotNull
    private final String screenName = SCREEN_NAME;
    /* access modifiers changed from: private */
    @NotNull
    public final ActivityResultLauncher<Intent> startForResult;
    @Inject
    public ISubscriptionsFeatureFlagsRepository subscriptionsFlagsRepo;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartFragment$Companion;", "", "()V", "SCREEN_NAME", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CartFragment() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new q(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.startForResult = registerForActivityResult;
    }

    private final void checkIfAgeRestricted(Result<CartFragmentData> result) {
        if ((result instanceof Result.Success) && !getCartFragmentViewModel().checkAgeRestricted((Result.Success) result)) {
            onCheckoutClicked(result);
        }
    }

    private final CartListAdapter getAdapter() {
        return (CartListAdapter) this.adapter$delegate.getValue();
    }

    private final DeliveryTierBottomSheetViewStateViewModel getBottomSheetViewStateViewModel() {
        return (DeliveryTierBottomSheetViewStateViewModel) this.bottomSheetViewStateViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void onCheckoutClicked(Result<CartFragmentData> result) {
        if (result instanceof Result.Success) {
            getCartFragmentViewModel().handleCheckoutNavigation(new CartFragment$onCheckoutClicked$1(this), new CartFragment$onCheckoutClicked$2(this));
        }
    }

    /* access modifiers changed from: private */
    public final void onPartialFulfillmentClicked() {
        FragmentKt.findNavController(this).navigate(CartFragmentDirections.Companion.actionCartFragmentToPartialFulfillment(getCartFragmentViewModel().getPreferences(), ""));
    }

    /* access modifiers changed from: private */
    public final void onProductClicked(Product product) {
        FragmentKt.findNavController(this).navigate(CartFragmentDirections.Companion.actionToProductFragment$default(CartFragmentDirections.Companion, product, false, (String) null, (String) null, (ProductClickTrackingAttribute) null, (String) null, (String) null, (String) null, 254, (Object) null));
    }

    /* access modifiers changed from: private */
    public final void onSpecialRequestChanged(String str) {
        getCartFragmentViewModel().updateSpecialRequest(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m9777onViewCreated$lambda2(CartFragment cartFragment, Result result) {
        int i11;
        Intrinsics.checkNotNullParameter(cartFragment, "this$0");
        ProgressBar progressBar = (ProgressBar) cartFragment._$_findCachedViewById(R.id.progressBar);
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        if (result instanceof Result.Loading) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        progressBar.setVisibility(i11);
        cartFragment.setBtnCheckoutStatus(result);
        ((TextView) cartFragment._$_findCachedViewById(R.id.btnCheckout)).setOnClickListener(new r(cartFragment, result));
        if (result instanceof Result.Success) {
            cartFragment.showData((CartFragmentData) ((Result.Success) result).getData());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2$lambda-1  reason: not valid java name */
    public static final void m9778onViewCreated$lambda2$lambda1(CartFragment cartFragment, Result result, View view) {
        Intrinsics.checkNotNullParameter(cartFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        cartFragment.checkIfAgeRestricted(result);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m9779onViewCreated$lambda3(CartFragment cartFragment, View view) {
        Intrinsics.checkNotNullParameter(cartFragment, "this$0");
        cartFragment._$_findCachedViewById(R.id.age_restriction_alert).setVisibility(4);
    }

    private final void openInfoBottomSheet(@DrawableRes int i11, String str, String str2, String str3) {
        Context context = getContext();
        if (context != null) {
            FragmentManager supportFragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context as AppCompatActi…y).supportFragmentManager");
            DSBottomSheet dSBottomSheet = new DSBottomSheet();
            dSBottomSheet.setBody(FeesDescriptionBottomSheetFragment.Companion.newInstance(i11, str, str2, str3));
            dSBottomSheet.show(supportFragmentManager, FeesDescriptionBottomSheetFragment.TAG);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r2 = r2.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setBtnCheckoutStatus(com.talabat.darkstores.common.Result<com.talabat.darkstores.feature.cart.CartFragmentData> r2) {
        /*
            r1 = this;
            int r0 = com.talabat.darkstores.R.id.btnCheckout
            android.view.View r0 = r1._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r2 == 0) goto L_0x0017
            java.lang.Object r2 = r2.getData()
            com.talabat.darkstores.feature.cart.CartFragmentData r2 = (com.talabat.darkstores.feature.cart.CartFragmentData) r2
            if (r2 == 0) goto L_0x0017
            boolean r2 = r2.getEnableCheckout()
            goto L_0x0018
        L_0x0017:
            r2 = 0
        L_0x0018:
            r0.setEnabled(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.cart.CartFragment.setBtnCheckoutStatus(com.talabat.darkstores.common.Result):void");
    }

    private final void setDeliveryFeeLabelVisibility(boolean z11, boolean z12) {
        if (z11 && z12) {
            ((TextView) _$_findCachedViewById(R.id.tvDeliveryFeeLabel)).setVisibility(4);
            TextView textView = (TextView) _$_findCachedViewById(R.id.tvTProDeliveryFeeLabel);
            Intrinsics.checkNotNullExpressionValue(textView, "tvTProDeliveryFeeLabel");
            textView.setVisibility(0);
            ImageView imageView = (ImageView) _$_findCachedViewById(R.id.imageDeliveryFeeMoreInfo);
            Intrinsics.checkNotNullExpressionValue(imageView, "imageDeliveryFeeMoreInfo");
            imageView.setVisibility(8);
        } else if (z11) {
            ((TextView) _$_findCachedViewById(R.id.tvDeliveryFeeLabel)).setVisibility(0);
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.tvTProDeliveryFeeLabel);
            Intrinsics.checkNotNullExpressionValue(textView2, "tvTProDeliveryFeeLabel");
            textView2.setVisibility(8);
            ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.imageDeliveryFeeMoreInfo);
            Intrinsics.checkNotNullExpressionValue(imageView2, "imageDeliveryFeeMoreInfo");
            imageView2.setVisibility(0);
        } else {
            TextView textView3 = (TextView) _$_findCachedViewById(R.id.tvDeliveryFeeLabel);
            Intrinsics.checkNotNullExpressionValue(textView3, "tvDeliveryFeeLabel");
            textView3.setVisibility(8);
            TextView textView4 = (TextView) _$_findCachedViewById(R.id.tvTProDeliveryFeeLabel);
            Intrinsics.checkNotNullExpressionValue(textView4, "tvTProDeliveryFeeLabel");
            textView4.setVisibility(8);
            ImageView imageView3 = (ImageView) _$_findCachedViewById(R.id.imageDeliveryFeeMoreInfo);
            Intrinsics.checkNotNullExpressionValue(imageView3, "imageDeliveryFeeMoreInfo");
            imageView3.setVisibility(8);
        }
    }

    private final void setupBasketDeliveryTierInfoButton(View view) {
        view.setOnClickListener(new j(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupBasketDeliveryTierInfoButton$lambda-15  reason: not valid java name */
    public static final void m9780setupBasketDeliveryTierInfoButton$lambda15(CartFragment cartFragment, View view) {
        Intrinsics.checkNotNullParameter(cartFragment, "this$0");
        cartFragment.getBottomSheetViewStateViewModel().getDeliveryTierBottomSheetViewState().postValue(new DeliveryTierBottomSheetViewState(BottomSheetViewState.SHOW, DeliveryTierClickOrigin.PAYMENT_INFO, new ScreenTrackingInfo(cartFragment.getEventOriginType(), ScreenTrackingProvider.ScreenName.CART, ScreenTrackingProvider.ScreenType.CART)));
    }

    private final void setupFeeInfoButton(View view, @DrawableRes int i11, FeeDescription feeDescription, String str) {
        view.setOnClickListener(new o(this, feeDescription, i11, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupFeeInfoButton$lambda-14  reason: not valid java name */
    public static final void m9781setupFeeInfoButton$lambda14(CartFragment cartFragment, FeeDescription feeDescription, int i11, String str, View view) {
        Intrinsics.checkNotNullParameter(cartFragment, "this$0");
        Intrinsics.checkNotNullParameter(feeDescription, "$feeDescription");
        cartFragment.getCartFragmentViewModel().trackFeeInfoClicked(feeDescription.getType());
        String name2 = feeDescription.getName();
        if (name2 == null) {
            name2 = "";
        }
        String description = feeDescription.getDescription();
        if (description == null) {
            description = "";
        }
        if (str == null) {
            str = "";
        }
        cartFragment.openInfoBottomSheet(i11, name2, description, str);
    }

    private final void setupServiceFeeViews(float f11, List<FeeDescription> list, boolean z11) {
        String str;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        FeeDescription serviceFeeDescription;
        FeeDescription deliveryFeeDescription;
        FeeDescription genericFeeDescription;
        Iterable iterable = list;
        Iterator it = iterable.iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((FeeDescription) obj).getType(), (Object) "DeliveryFee")) {
                break;
            }
        }
        FeeDescription feeDescription = (FeeDescription) obj;
        Iterator it2 = iterable.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it2.next();
            if (Intrinsics.areEqual((Object) ((FeeDescription) obj2).getType(), (Object) "ServiceFee")) {
                break;
            }
        }
        FeeDescription feeDescription2 = (FeeDescription) obj2;
        Iterator it3 = iterable.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it3.next();
            if (Intrinsics.areEqual((Object) ((FeeDescription) obj3).getType(), (Object) DarkstoresConstantsKt.FEE_DESCRIPTION_TYPE_BANNER)) {
                break;
            }
        }
        FeeDescription feeDescription3 = (FeeDescription) obj3;
        Iterator it4 = iterable.iterator();
        while (true) {
            if (!it4.hasNext()) {
                obj4 = null;
                break;
            }
            obj4 = it4.next();
            if (Intrinsics.areEqual((Object) ((FeeDescription) obj4).getType(), (Object) DarkstoresConstantsKt.FEE_DESCRIPTION_TYPE_GENERIC)) {
                break;
            }
        }
        FeeDescriptionDisplayModel feeDescriptionDisplayModel = new FeeDescriptionDisplayModel(feeDescription, feeDescription2, feeDescription3, (FeeDescription) obj4);
        this.feeDescriptionsDisplayModel = feeDescriptionDisplayModel;
        FeeDescription genericFeeDescription2 = feeDescriptionDisplayModel.getGenericFeeDescription();
        if (genericFeeDescription2 != null) {
            str = genericFeeDescription2.getUrl();
        }
        FeeDescriptionDisplayModel feeDescriptionDisplayModel2 = this.feeDescriptionsDisplayModel;
        if (!(feeDescriptionDisplayModel2 == null || (genericFeeDescription = feeDescriptionDisplayModel2.getGenericFeeDescription()) == null)) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.tvReadMoreAboutFees);
            Intrinsics.checkNotNullExpressionValue(textView, "tvReadMoreAboutFees");
            setupFeeInfoButton(textView, com.talabat.talabatcommon.R.drawable.ic_bottom_sheet_fees, genericFeeDescription, str);
        }
        if (z11) {
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.tvDeliveryFeeLabel);
            Intrinsics.checkNotNullExpressionValue(textView2, "tvDeliveryFeeLabel");
            setupBasketDeliveryTierInfoButton(textView2);
            ImageView imageView = (ImageView) _$_findCachedViewById(R.id.imageDeliveryFeeMoreInfo);
            Intrinsics.checkNotNullExpressionValue(imageView, "imageDeliveryFeeMoreInfo");
            setupBasketDeliveryTierInfoButton(imageView);
        } else {
            FeeDescriptionDisplayModel feeDescriptionDisplayModel3 = this.feeDescriptionsDisplayModel;
            if (!(feeDescriptionDisplayModel3 == null || (deliveryFeeDescription = feeDescriptionDisplayModel3.getDeliveryFeeDescription()) == null)) {
                TextView textView3 = (TextView) _$_findCachedViewById(R.id.tvDeliveryFeeLabel);
                Intrinsics.checkNotNullExpressionValue(textView3, "tvDeliveryFeeLabel");
                int i11 = com.talabat.talabatcommon.R.drawable.ic_bottom_sheet_delivery_fee;
                setupFeeInfoButton(textView3, i11, deliveryFeeDescription, str);
                ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.imageDeliveryFeeMoreInfo);
                Intrinsics.checkNotNullExpressionValue(imageView2, "imageDeliveryFeeMoreInfo");
                setupFeeInfoButton(imageView2, i11, deliveryFeeDescription, str);
            }
        }
        ((TextView) _$_findCachedViewById(R.id.tvServiceFee)).setText(FloatExtensionsKt.formatCurrency(f11));
        FeeDescriptionDisplayModel feeDescriptionDisplayModel4 = this.feeDescriptionsDisplayModel;
        if (feeDescriptionDisplayModel4 != null && (serviceFeeDescription = feeDescriptionDisplayModel4.getServiceFeeDescription()) != null) {
            TextView textView4 = (TextView) _$_findCachedViewById(R.id.tvServiceFeeLabel);
            Intrinsics.checkNotNullExpressionValue(textView4, "tvServiceFeeLabel");
            int i12 = com.talabat.talabatcommon.R.drawable.ic_bottom_sheet_service_fee;
            setupFeeInfoButton(textView4, i12, serviceFeeDescription, str);
            ImageView imageView3 = (ImageView) _$_findCachedViewById(R.id.imageServiceFeeMoreInfo);
            Intrinsics.checkNotNullExpressionValue(imageView3, "imageServiceFeeMoreInfo");
            setupFeeInfoButton(imageView3, i12, serviceFeeDescription, str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b2, code lost:
        if (com.talabat.darkstores.feature.cart.model.FeeDescriptionDisplayModelKt.isValidForDisplay(r1) != false) goto L_0x00b6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setupServiceViewVisibility(boolean r6, float r7, boolean r8) {
        /*
            r5 = this;
            int r0 = com.talabat.darkstores.R.id.imageDeliveryFeeMoreInfo
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.lang.String r1 = "imageDeliveryFeeMoreInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = 0
            r2 = 1
            r3 = 0
            if (r6 == 0) goto L_0x0026
            if (r8 != 0) goto L_0x0026
            com.talabat.darkstores.feature.cart.model.FeeDescriptionDisplayModel r8 = r5.feeDescriptionsDisplayModel
            if (r8 == 0) goto L_0x001d
            com.talabat.feature.darkstorescart.data.model.FeeDescription r8 = r8.getDeliveryFeeDescription()
            goto L_0x001e
        L_0x001d:
            r8 = r1
        L_0x001e:
            boolean r8 = com.talabat.darkstores.feature.cart.model.FeeDescriptionDisplayModelKt.isValidForDisplay(r8)
            if (r8 == 0) goto L_0x0026
            r8 = r2
            goto L_0x0027
        L_0x0026:
            r8 = r3
        L_0x0027:
            r4 = 8
            if (r8 == 0) goto L_0x002d
            r8 = r3
            goto L_0x002e
        L_0x002d:
            r8 = r4
        L_0x002e:
            r0.setVisibility(r8)
            int r8 = com.talabat.darkstores.R.id.tvReadMoreAboutFees
            android.view.View r8 = r5._$_findCachedViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            java.lang.String r0 = "tvReadMoreAboutFees"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            if (r6 == 0) goto L_0x0053
            com.talabat.darkstores.feature.cart.model.FeeDescriptionDisplayModel r0 = r5.feeDescriptionsDisplayModel
            if (r0 == 0) goto L_0x004a
            com.talabat.feature.darkstorescart.data.model.FeeDescription r0 = r0.getGenericFeeDescription()
            goto L_0x004b
        L_0x004a:
            r0 = r1
        L_0x004b:
            boolean r0 = com.talabat.darkstores.feature.cart.model.FeeDescriptionDisplayModelKt.isValidForDisplay(r0)
            if (r0 == 0) goto L_0x0053
            r0 = r2
            goto L_0x0054
        L_0x0053:
            r0 = r3
        L_0x0054:
            if (r0 == 0) goto L_0x0058
            r0 = r3
            goto L_0x0059
        L_0x0058:
            r0 = r4
        L_0x0059:
            r8.setVisibility(r0)
            if (r6 == 0) goto L_0x006a
            r6 = 0
            int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x0065
            r6 = r2
            goto L_0x0066
        L_0x0065:
            r6 = r3
        L_0x0066:
            if (r6 != 0) goto L_0x006a
            r6 = r2
            goto L_0x006b
        L_0x006a:
            r6 = r3
        L_0x006b:
            int r7 = com.talabat.darkstores.R.id.tvServiceFeeLabel
            android.view.View r7 = r5._$_findCachedViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            java.lang.String r8 = "tvServiceFeeLabel"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            if (r6 == 0) goto L_0x007d
            r8 = r3
            goto L_0x007e
        L_0x007d:
            r8 = r4
        L_0x007e:
            r7.setVisibility(r8)
            int r7 = com.talabat.darkstores.R.id.tvServiceFee
            android.view.View r7 = r5._$_findCachedViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            java.lang.String r8 = "tvServiceFee"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            if (r6 == 0) goto L_0x0093
            r8 = r3
            goto L_0x0094
        L_0x0093:
            r8 = r4
        L_0x0094:
            r7.setVisibility(r8)
            int r7 = com.talabat.darkstores.R.id.imageServiceFeeMoreInfo
            android.view.View r7 = r5._$_findCachedViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            java.lang.String r8 = "imageServiceFeeMoreInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            if (r6 == 0) goto L_0x00b5
            com.talabat.darkstores.feature.cart.model.FeeDescriptionDisplayModel r6 = r5.feeDescriptionsDisplayModel
            if (r6 == 0) goto L_0x00ae
            com.talabat.feature.darkstorescart.data.model.FeeDescription r1 = r6.getServiceFeeDescription()
        L_0x00ae:
            boolean r6 = com.talabat.darkstores.feature.cart.model.FeeDescriptionDisplayModelKt.isValidForDisplay(r1)
            if (r6 == 0) goto L_0x00b5
            goto L_0x00b6
        L_0x00b5:
            r2 = r3
        L_0x00b6:
            if (r2 == 0) goto L_0x00b9
            goto L_0x00ba
        L_0x00b9:
            r3 = r4
        L_0x00ba:
            r7.setVisibility(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.cart.CartFragment.setupServiceViewVisibility(boolean, float, boolean):void");
    }

    /* access modifiers changed from: private */
    public final void showAgeRestriction(String str) {
        FragmentKt.findNavController(this).navigate(CartFragmentDirections.Companion.actionCartFragmentToAgeRestriction(str));
    }

    private final void showCartSummary(CartSummary cartSummary, boolean z11) {
        boolean z12;
        ((TextView) _$_findCachedViewById(R.id.tvSubtotal)).setText(FloatExtensionsKt.formatCurrency(cartSummary.getSubtotal()));
        float f11 = 0.0f;
        boolean z13 = false;
        if (cartSummary.getDeliveryAbsoluteDiscount() == 0.0f) {
            z12 = true;
        } else {
            z12 = false;
        }
        String str = null;
        if (!z12) {
            int i11 = R.id.tvDeliveryFeeBeforeDiscount;
            ((TextView) _$_findCachedViewById(i11)).setText(FloatExtensionsKt.formatCurrency(cartSummary.getDeliveryFee()));
            TextView textView = (TextView) _$_findCachedViewById(i11);
            Intrinsics.checkNotNullExpressionValue(textView, "tvDeliveryFeeBeforeDiscount");
            BindingAdaptersKt.setStrike(textView, true);
        } else {
            ((TextView) _$_findCachedViewById(R.id.tvDeliveryFeeBeforeDiscount)).setText((CharSequence) null);
        }
        boolean tProCampaignApplied = tProCampaignApplied(cartSummary);
        int i12 = R.id.tvDeliveryFee;
        TextView textView2 = (TextView) _$_findCachedViewById(i12);
        if (tProCampaignApplied) {
            Float deliveryFeeBeforeDiscount = cartSummary.getDeliveryFeeBeforeDiscount();
            if (deliveryFeeBeforeDiscount != null) {
                str = FloatExtensionsKt.formatCurrency(deliveryFeeBeforeDiscount.floatValue());
            }
            textView2.setText(str);
            textView2.setPaintFlags(((TextView) _$_findCachedViewById(i12)).getPaintFlags() | 16);
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            textView2.setTextColor(ContextExtensionsKt.getColorCompat(requireContext, com.talabat.talabatcommon.R.color.new_brand_blue));
        } else if (Intrinsics.areEqual(cartSummary.getDeliveryFeeBeforeDiscount(), 0.0f)) {
            textView2.setText(getString(com.talabat.localization.R.string.cart_free));
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
            textView2.setTextColor(ContextExtensionsKt.getColorCompat(requireContext2, com.designsystem.marshmallow.R.color.ds_promo_100));
            textView2.setPaintFlags(((TextView) _$_findCachedViewById(i12)).getPaintFlags() & -17);
        } else {
            Float deliveryFeeBeforeDiscount2 = cartSummary.getDeliveryFeeBeforeDiscount();
            if (deliveryFeeBeforeDiscount2 != null) {
                str = FloatExtensionsKt.formatCurrency(deliveryFeeBeforeDiscount2.floatValue());
            }
            textView2.setText(str);
            if (!getCartFragmentViewModel().basketBaseDeliveryFeeIsEnabled() || cartSummary.getDeliveryAbsoluteDiscount() <= 0.0f) {
                Context requireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
                textView2.setTextColor(ContextExtensionsKt.getColorCompat(requireContext3, com.designsystem.marshmallow.R.color.ds_neutral_100));
            } else {
                Context requireContext4 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext4, "requireContext()");
                textView2.setTextColor(ContextExtensionsKt.getColorCompat(requireContext4, com.designsystem.marshmallow.R.color.ds_promo_100));
            }
            textView2.setPaintFlags(((TextView) _$_findCachedViewById(i12)).getPaintFlags() & -17);
        }
        Group group = (Group) _$_findCachedViewById(R.id.groupSummaryDetails);
        Intrinsics.checkNotNullExpressionValue(group, "groupSummaryDetails");
        if (group.getVisibility() == 0) {
            z13 = true;
        }
        setDeliveryFeeLabelVisibility(z13, tProCampaignApplied);
        ((TextView) _$_findCachedViewById(R.id.tvOfferDiscount)).setText(FloatExtensionsKt.formatCurrency(cartSummary.getOfferDiscount()));
        ((TextView) _$_findCachedViewById(R.id.tvTotal)).setText(FloatExtensionsKt.formatCurrency(cartSummary.getTotal()));
        Float serviceFee = cartSummary.getServiceFee();
        if (serviceFee != null) {
            f11 = serviceFee.floatValue();
        }
        setupServiceFeeViews(f11, cartSummary.getFeeDescriptions(), z11);
        ((ImageButton) _$_findCachedViewById(R.id.btnToggleExpand)).setOnClickListener(new p(this, cartSummary, tProCampaignApplied));
    }

    /* access modifiers changed from: private */
    /* renamed from: showCartSummary$lambda-5  reason: not valid java name */
    public static final void m9782showCartSummary$lambda5(CartFragment cartFragment, CartSummary cartSummary, boolean z11, View view) {
        boolean z12;
        int i11;
        boolean z13;
        float f11;
        boolean z14;
        boolean z15;
        Intrinsics.checkNotNullParameter(cartFragment, "this$0");
        Intrinsics.checkNotNullParameter(cartSummary, "$summary");
        int i12 = R.id.groupSummaryDetails;
        Group group = (Group) cartFragment._$_findCachedViewById(i12);
        Intrinsics.checkNotNullExpressionValue(group, "groupSummaryDetails");
        Group group2 = (Group) cartFragment._$_findCachedViewById(i12);
        Intrinsics.checkNotNullExpressionValue(group2, "groupSummaryDetails");
        boolean z16 = true;
        if (group2.getVisibility() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        group.setVisibility(i11);
        Group group3 = (Group) cartFragment._$_findCachedViewById(i12);
        Intrinsics.checkNotNullExpressionValue(group3, "groupSummaryDetails");
        if (group3.getVisibility() == 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        Float serviceFee = cartSummary.getServiceFee();
        float f12 = 0.0f;
        if (serviceFee != null) {
            f11 = serviceFee.floatValue();
        } else {
            f11 = 0.0f;
        }
        cartFragment.setupServiceViewVisibility(z13, f11, z11);
        Group group4 = (Group) cartFragment._$_findCachedViewById(i12);
        Intrinsics.checkNotNullExpressionValue(group4, "groupSummaryDetails");
        if (group4.getVisibility() == 0) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14) {
            cartFragment.getCartFragmentViewModel().trackPaymentSummaryExpanded();
        }
        Group group5 = (Group) cartFragment._$_findCachedViewById(i12);
        Intrinsics.checkNotNullExpressionValue(group5, "groupSummaryDetails");
        if (group5.getVisibility() == 0) {
            z15 = true;
        } else {
            z15 = false;
        }
        cartFragment.setDeliveryFeeLabelVisibility(z15, z11);
        ViewPropertyAnimator animate = ((ImageButton) cartFragment._$_findCachedViewById(R.id.btnToggleExpand)).animate();
        Group group6 = (Group) cartFragment._$_findCachedViewById(i12);
        Intrinsics.checkNotNullExpressionValue(group6, "groupSummaryDetails");
        if (group6.getVisibility() != 0) {
            z16 = false;
        }
        if (z16) {
            f12 = 180.0f;
        }
        animate.rotation(f12).start();
    }

    private final void showData(CartFragmentData cartFragmentData) {
        int i11;
        int i12;
        getCartFragmentViewModel().trackCartOpened();
        getCartFragmentViewModel().onReadyForInteractionTlbDefinition();
        Pair<List<Product>, CartSummary> cartProductsWithSummary = cartFragmentData.getCartProductsWithSummary();
        List component1 = cartProductsWithSummary.component1();
        showCartSummary(cartProductsWithSummary.component2(), cartFragmentData.isBasketDeliveryFreeTierEnabled());
        View _$_findCachedViewById = _$_findCachedViewById(R.id.cartSummaryLayout);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "cartSummaryLayout");
        Collection collection = component1;
        int i13 = 0;
        if (!collection.isEmpty()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        _$_findCachedViewById.setVisibility(i11);
        CustomVerticalRecyclerView customVerticalRecyclerView = (CustomVerticalRecyclerView) _$_findCachedViewById(R.id.cartRecyclerView);
        Intrinsics.checkNotNullExpressionValue(customVerticalRecyclerView, "cartRecyclerView");
        if (!collection.isEmpty()) {
            i12 = 0;
        } else {
            i12 = 8;
        }
        customVerticalRecyclerView.setVisibility(i12);
        TextView textView = (TextView) _$_findCachedViewById(R.id.cartEmptyTextView);
        Intrinsics.checkNotNullExpressionValue(textView, "cartEmptyTextView");
        if (!component1.isEmpty()) {
            i13 = 8;
        }
        textView.setVisibility(i13);
    }

    /* access modifiers changed from: private */
    /* renamed from: startForResult$lambda-17  reason: not valid java name */
    public static final void m9783startForResult$lambda17(CartFragment cartFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(cartFragment, "this$0");
        if (activityResult.getResultCode() == -1) {
            CartFragmentViewModel cartFragmentViewModel = cartFragment.getCartFragmentViewModel();
            FragmentActivity activity = cartFragment.getActivity();
            if (activity != null) {
                CartFragmentViewModel.checkout$default(cartFragmentViewModel, (DarkstoresMainActivity) activity, (CheckoutParams) null, 2, (Object) null);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.darkstores.feature.main.DarkstoresMainActivity");
        }
    }

    private final boolean tProCampaignApplied(CartSummary cartSummary) {
        Object obj;
        boolean z11;
        boolean isTProEnabledForTMart = getSubscriptionsFlagsRepo().isTProEnabledForTMart();
        boolean isTPro = getCustomerRepository().isTPro();
        Iterator it = cartSummary.getAppliedCampaigns().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (StringsKt__StringsKt.contains((CharSequence) ((CampaignLabel) obj).getCampaignName(), (CharSequence) "tpro", true)) {
                break;
            }
        }
        if (obj != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!isTProEnabledForTMart || !z11 || !isTPro) {
            return false;
        }
        return true;
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

    public int getContentViewId() {
        return this.contentViewId;
    }

    @NotNull
    public final CustomerRepository getCustomerRepository() {
        CustomerRepository customerRepository2 = this.customerRepository;
        if (customerRepository2 != null) {
            return customerRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("customerRepository");
        return null;
    }

    @NotNull
    public EventOriginType getEventOriginType() {
        return this.eventOriginType;
    }

    @NotNull
    public String getScreenName() {
        return this.screenName;
    }

    @NotNull
    public final ISubscriptionsFeatureFlagsRepository getSubscriptionsFlagsRepo() {
        ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository = this.subscriptionsFlagsRepo;
        if (iSubscriptionsFeatureFlagsRepository != null) {
            return iSubscriptionsFeatureFlagsRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subscriptionsFlagsRepo");
        return null;
    }

    public void i0() {
        super.i0();
        ((Toolbar) _$_findCachedViewById(R.id.toolbar)).setNavigationIcon(ResourcesCompat.getDrawable(getResources(), com.designsystem.marshmallow.R.drawable.ds_arrow_back, (Resources.Theme) null));
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        DaggerCartFragmentComponent.factory().create((SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(SubscriptionsFeatureApi.class), (CustomerCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(CustomerCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getCartFragmentViewModel().startTraceDefinition();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onReadMoreInfoClicked() {
        getCartFragmentViewModel().trackFeeInfoUrlClicked();
    }

    public void onResume() {
        super.onResume();
        getCartFragmentViewModel().onReadyForInteractionDhDefinition();
        getCartFragmentViewModel().validateCart();
    }

    public void onRetryClicked() {
        getCartFragmentViewModel().onRetry();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ((CustomVerticalRecyclerView) _$_findCachedViewById(R.id.cartRecyclerView)).setAdapter(getAdapter());
        getCartFragmentViewModel().onCartScreenLoaded();
        getCartFragmentViewModel().cartListLiveData().observe(getViewLifecycleOwner(), new k(getAdapter()));
        getCartFragmentViewModel().getCartFragmentLiveData().observe(getViewLifecycleOwner(), new l(this));
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.alert_close);
        if (imageView != null) {
            imageView.setOnClickListener(new m(this));
        }
        MutableLiveData<Boolean> cartSyncWarning = getCartFragmentViewModel().getCartSyncWarning();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        g(cartSyncWarning, viewLifecycleOwner, new CartFragment$onViewCreated$4(this));
        MutableLiveData<EventWrapper<String>> ageLive = getCartFragmentViewModel().getAgeLive();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        g(ageLive, viewLifecycleOwner2, new CartFragment$onViewCreated$5(this));
        MutableLiveData<EventWrapper<Boolean>> eligibilityLive = getCartFragmentViewModel().getEligibilityLive();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        g(eligibilityLive, viewLifecycleOwner3, new CartFragment$onViewCreated$6(this));
        getCartFragmentViewModel().campaignVisualisation().observe(getViewLifecycleOwner(), new n((CartProgressView) _$_findCachedViewById(R.id.cartFragmentProgressView)));
    }

    public final void setCustomerRepository(@NotNull CustomerRepository customerRepository2) {
        Intrinsics.checkNotNullParameter(customerRepository2, "<set-?>");
        this.customerRepository = customerRepository2;
    }

    public final void setSubscriptionsFlagsRepo(@NotNull ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsFeatureFlagsRepository, "<set-?>");
        this.subscriptionsFlagsRepo = iSubscriptionsFeatureFlagsRepository;
    }
}
