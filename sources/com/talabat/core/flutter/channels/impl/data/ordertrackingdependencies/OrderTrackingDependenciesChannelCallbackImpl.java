package com.talabat.core.flutter.channels.impl.data.ordertrackingdependencies;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.talabat.core.flutter.channels.domain.ordertrackingdependencies.OrderTrackingDependenciesChannelCallback;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.darkstore.DarkStoreScreen;
import com.talabat.core.navigation.domain.screen.riderchat.RiderChatScreen;
import com.talabat.feature.tpro.presentation.payment.TProPaymentBottomSheetFragmentKt;
import com.talabat.riderinfo.presentation.activity.RiderChatDeepLinkActivity;
import com.talabat.talabatcommon.enums.OrderStatus;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderBottomSheetState;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderSource;
import com.talabat.talabatcommon.views.ridersTip.bottomSheet.RiderTipBottomSheetDialogFragment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J&\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016JI\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0002¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/ordertrackingdependencies/OrderTrackingDependenciesChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/ordertrackingdependencies/OrderTrackingDependenciesChannelCallback;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "openProPaymentScreen", "", "deeplink", "", "activity", "Landroid/app/Activity;", "openQCommerceDeeplink", "openRiderChat", "orderId", "openRiderTip", "onSuccess", "Lkotlin/Function0;", "openRiderTipInfo", "showRiderTipBottomSheet", "encryptedOrderId", "tipRiderBottomSheetStatus", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderBottomSheetState;", "selectedTip", "", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderBottomSheetState;Ljava/lang/Float;Lkotlin/jvm/functions/Function0;)V", "Companion", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderTrackingDependenciesChannelCallbackImpl implements OrderTrackingDependenciesChannelCallback {
    @NotNull
    private static final String ACTION_DARK_STORES = "com.talabat.feature.darkstores.deeplink";
    @NotNull
    private static final String ARG_BRANCH_ID = "branchId";
    @NotNull
    private static final String ARG_DEEPLINK_INFO = "deeplinkInfo";
    @NotNull
    private static final String ARG_DEEPLINK_TYPE = "deeplinkType";
    @NotNull
    private static final String ARG_EVENT_ORIGIN = "eventOrigin";
    @NotNull
    private static final String ARG_IS_DARKSTORE = "isDarkStore";
    @NotNull
    private static final String ARG_IS_MIGRATED = "isMigrated";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String DARKSTORE_SCREEN = "ds";
    @NotNull
    private static final String KEY_BRANCH_ID = "bid";
    @NotNull
    private static final String KEY_EXPERIMENT = "experiment";
    @NotNull
    private static final String KEY_INFO = "i";
    @NotNull
    private static final String KEY_SCREEN = "s";
    @NotNull
    private static final String KEY_TYPE = "t";
    @NotNull
    private static final String MIGRATED_VENDOR_SCREEN = "mv";
    @NotNull
    private final Navigator navigator;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/ordertrackingdependencies/OrderTrackingDependenciesChannelCallbackImpl$Companion;", "", "()V", "ACTION_DARK_STORES", "", "ARG_BRANCH_ID", "ARG_DEEPLINK_INFO", "ARG_DEEPLINK_TYPE", "ARG_EVENT_ORIGIN", "ARG_IS_DARKSTORE", "ARG_IS_MIGRATED", "DARKSTORE_SCREEN", "KEY_BRANCH_ID", "KEY_EXPERIMENT", "KEY_INFO", "KEY_SCREEN", "KEY_TYPE", "MIGRATED_VENDOR_SCREEN", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public OrderTrackingDependenciesChannelCallbackImpl(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        this.navigator = navigator2;
    }

    public static /* synthetic */ void a(OrderTrackingDependenciesChannelCallbackImpl orderTrackingDependenciesChannelCallbackImpl, Activity activity, String str, String str2, TipRiderBottomSheetState tipRiderBottomSheetState, Float f11, Function0 function0, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            f11 = null;
        }
        Float f12 = f11;
        if ((i11 & 32) != 0) {
            function0 = OrderTrackingDependenciesChannelCallbackImpl$showRiderTipBottomSheet$1.INSTANCE;
        }
        orderTrackingDependenciesChannelCallbackImpl.showRiderTipBottomSheet(activity, str, str2, tipRiderBottomSheetState, f12, function0);
    }

    private final void showRiderTipBottomSheet(Activity activity, String str, String str2, TipRiderBottomSheetState tipRiderBottomSheetState, Float f11, Function0<Unit> function0) {
        OrderTrackingDependenciesChannelCallbackImpl$showRiderTipBottomSheet$successListener$1 orderTrackingDependenciesChannelCallbackImpl$showRiderTipBottomSheet$successListener$1 = new OrderTrackingDependenciesChannelCallbackImpl$showRiderTipBottomSheet$successListener$1(function0);
        TipRiderSource tipRiderSource = TipRiderSource.ORDER_CONFIRMATION_SCREEN;
        RiderTipBottomSheetDialogFragment riderTipBottomSheetDialogFragment = new RiderTipBottomSheetDialogFragment(orderTrackingDependenciesChannelCallbackImpl$showRiderTipBottomSheet$successListener$1, tipRiderBottomSheetState, tipRiderSource, OrderStatus.PREPARING, str, str2, tipRiderSource.getScreenName(), f11);
        Bundle bundle = new Bundle();
        bundle.putString("encryptedOrderId", str2);
        bundle.putString("orderId", str);
        riderTipBottomSheetDialogFragment.setArguments(bundle);
        FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
        supportFragmentManager.beginTransaction();
        riderTipBottomSheetDialogFragment.show(supportFragmentManager, "");
    }

    public void openProPaymentScreen(@NotNull String str, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(str, "deeplink");
        Intrinsics.checkNotNullParameter(activity, "activity");
        String queryParameter = Uri.parse(str).getQueryParameter("orderId");
        String str2 = "";
        if (queryParameter == null) {
            queryParameter = str2;
        }
        String queryParameter2 = Uri.parse(str).getQueryParameter("deliveryFee");
        if (queryParameter2 != null) {
            str2 = queryParameter2;
        }
        TProPaymentBottomSheetFragmentKt.showPaymentBottomSheetFromOTP((FragmentActivity) activity, queryParameter, str2);
    }

    public void openQCommerceDeeplink(@NotNull String str, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(str, "deeplink");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.navigator.navigateTo(activity, new DarkStoreScreen(new DarkStoreScreen.DarkStoreData(str)), new OrderTrackingDependenciesChannelCallbackImpl$openQCommerceDeeplink$1(str));
    }

    public void openRiderChat(@NotNull String str, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Navigator.DefaultImpls.navigateTo$default(this.navigator, activity, new RiderChatScreen(new RiderChatScreen.RiderChatData(str)), (Function1) null, 4, (Object) null);
    }

    public void openRiderTip(@NotNull String str, @NotNull Activity activity, @NotNull Function0<Unit> function0) {
        Float f11;
        Intrinsics.checkNotNullParameter(str, "deeplink");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        String queryParameter = Uri.parse(str).getQueryParameter(RiderChatDeepLinkActivity.ORDER_ID_KEY);
        if (queryParameter == null) {
            queryParameter = "";
        }
        String str2 = queryParameter;
        String queryParameter2 = Uri.parse(str).getQueryParameter("tip_value");
        if (queryParameter2 != null) {
            f11 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(queryParameter2);
        } else {
            f11 = null;
        }
        Activity activity2 = activity;
        String str3 = str2;
        a(this, activity2, str3, str2, TipRiderBottomSheetState.OPEN_PAYMENT_WIDGET, f11, (Function0) null, 32, (Object) null);
    }

    public void openRiderTipInfo(@NotNull String str, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(str, "deeplink");
        Intrinsics.checkNotNullParameter(activity, "activity");
        String queryParameter = Uri.parse(str).getQueryParameter(RiderChatDeepLinkActivity.ORDER_ID_KEY);
        if (queryParameter == null) {
            queryParameter = "";
        }
        String str2 = queryParameter;
        a(this, activity, str2, str2, TipRiderBottomSheetState.OPEN_INFO_WITHOUT_TIP_AGAIN, (Float) null, (Function0) null, 48, (Object) null);
    }
}
