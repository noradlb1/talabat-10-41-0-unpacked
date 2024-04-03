package com.talabat.darkstores.feature.main;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelLazy;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.NavGraph;
import androidx.navigation.fragment.NavHostFragment;
import com.afollestad.materialdialogs.DialogBehavior;
import com.afollestad.materialdialogs.MaterialDialog;
import com.designsystem.ds_toast.DSToastModel;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.darkstores.common.ErrorViewDispatcher;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.common.extensions.ContextExtensionsKt;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$2;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$3;
import com.talabat.darkstores.common.view.BottomCartView;
import com.talabat.darkstores.common.view.ErrorView;
import com.talabat.darkstores.common.view.LoadingFailedView;
import com.talabat.darkstores.data.dynamicPricing.remote.DeliveryDetails;
import com.talabat.darkstores.di.Injector;
import com.talabat.darkstores.feature.Darkstores;
import com.talabat.darkstores.feature.campaigns.CampaignProgressVisualisation;
import com.talabat.darkstores.feature.cart.CartFragmentData;
import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.darkstores.feature.cart.CartSummary;
import com.talabat.darkstores.feature.cart.model.BottomCartViewState;
import com.talabat.darkstores.feature.cart.model.ScreenTrackingInfo;
import com.talabat.darkstores.feature.cart.views.CartProgressView;
import com.talabat.darkstores.feature.main.viewmodel.BottomSheetViewState;
import com.talabat.darkstores.feature.main.viewmodel.DeliveryTierBottomSheetViewState;
import com.talabat.darkstores.feature.main.viewmodel.DeliveryTierBottomSheetViewStateViewModel;
import com.talabat.darkstores.feature.mission.control.MainViewModel;
import com.talabat.darkstores.feature.model.NavigationTarget;
import com.talabat.feature.darkstorescart.data.model.CheckoutParams;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescartlist.domain.model.CartListToast;
import com.talabat.feature.nfvinvendorsearch.presentation.fragment.QCommerceFlutterFragmentArgs;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.VlpRoute;
import com.talabat.helpers.GlobalConstants;
import com.talabat.localization.R;
import com.talabat.wrapper.EventWrapper;
import com.visa.checkout.Profile;
import hj.a;
import hj.b;
import hj.c;
import hj.d;
import hj.e;
import hj.f;
import hj.g;
import hj.h;
import hj.i;
import hj.j;
import hj.k;
import hj.l;
import hj.m;
import hj.n;
import hj.o;
import hj.p;
import hj.q;
import hj.r;
import hj.s;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;

@Instrumented
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 n2\u00020\u0001:\u0002noB\u0005¢\u0006\u0002\u0010\u0002J\b\u00101\u001a\u000202H\u0002J\u0006\u00103\u001a\u000202J\u0014\u00104\u001a\u0002022\f\u00105\u001a\b\u0012\u0004\u0012\u00020206J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u000202H\u0002J\u000f\u0010@\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u0010AJ\b\u0010B\u001a\u000202H\u0002J\b\u0010C\u001a\u000202H\u0002J\b\u0010D\u001a\u000202H\u0002J\b\u0010E\u001a\u000202H\u0002J\b\u0010F\u001a\u000202H\u0002J\b\u0010G\u001a\u000202H\u0002J\b\u0010H\u001a\u000202H\u0002J\b\u0010I\u001a\u000202H\u0002J\b\u0010J\u001a\u000202H\u0002J\b\u0010K\u001a\u000202H\u0002J\b\u0010L\u001a\u000202H\u0002J\b\u0010M\u001a\u000202H\u0002J\b\u0010N\u001a\u000202H\u0002J\n\u0010O\u001a\u0004\u0018\u00010:H\u0002J\u0012\u0010P\u001a\u0002022\b\u0010Q\u001a\u0004\u0018\u00010RH\u0014J\b\u0010S\u001a\u000202H\u0014J\u0010\u0010T\u001a\u0002022\u0006\u0010U\u001a\u00020VH\u0014J\u0012\u0010W\u001a\u0002022\b\u0010Q\u001a\u0004\u0018\u00010RH\u0014J\b\u0010X\u001a\u000202H\u0002J\b\u0010Y\u001a\u000202H\u0002J\b\u0010Z\u001a\u00020$H\u0002J\u0010\u0010[\u001a\u0002022\u0006\u0010\\\u001a\u00020]H\u0002J\u0016\u0010^\u001a\u0002022\f\u0010_\u001a\b\u0012\u0004\u0012\u00020a0`H\u0002J\b\u0010b\u001a\u000202H\u0002J\u001c\u0010c\u001a\u0002022\u0006\u0010d\u001a\u00020e2\f\u00105\u001a\b\u0012\u0004\u0012\u00020206J\u0010\u0010f\u001a\u0002022\u0006\u0010g\u001a\u00020hH\u0002J\u0010\u0010i\u001a\u0002022\u0006\u0010j\u001a\u00020<H\u0002J\f\u0010k\u001a\u00020l*\u00020mH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\b\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8@X\u0002¢\u0006\f\n\u0004\b'\u0010\b\u001a\u0004\b%\u0010&R\u0016\u0010(\u001a\u0004\u0018\u00010)8BX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001b\u0010,\u001a\u00020-8BX\u0002¢\u0006\f\n\u0004\b0\u0010\b\u001a\u0004\b.\u0010/¨\u0006p"}, d2 = {"Lcom/talabat/darkstores/feature/main/DarkstoresMainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "bottomSheetViewStateViewModel", "Lcom/talabat/darkstores/feature/main/viewmodel/DeliveryTierBottomSheetViewStateViewModel;", "getBottomSheetViewStateViewModel", "()Lcom/talabat/darkstores/feature/main/viewmodel/DeliveryTierBottomSheetViewStateViewModel;", "bottomSheetViewStateViewModel$delegate", "Lkotlin/Lazy;", "cartErrorDialog", "Lcom/afollestad/materialdialogs/MaterialDialog;", "cartViewModel", "Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel;", "getCartViewModel", "()Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel;", "cartViewModel$delegate", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "getCoroutineDispatchersFactory", "()Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "coroutineDispatchersFactory$delegate", "dispatcher", "Lcom/talabat/darkstores/common/ErrorViewDispatcher;", "value", "Lcom/talabat/darkstores/common/view/ErrorView;", "errorView", "getErrorView", "()Lcom/talabat/darkstores/common/view/ErrorView;", "setErrorView", "(Lcom/talabat/darkstores/common/view/ErrorView;)V", "mainViewModel", "Lcom/talabat/darkstores/feature/mission/control/MainViewModel;", "getMainViewModel", "()Lcom/talabat/darkstores/feature/mission/control/MainViewModel;", "mainViewModel$delegate", "navController", "Landroidx/navigation/NavController;", "getNavController$com_talabat_NewArchi_darkstores_darkstores", "()Landroidx/navigation/NavController;", "navController$delegate", "navigationTarget", "Lcom/talabat/darkstores/feature/model/NavigationTarget;", "getNavigationTarget", "()Lcom/talabat/darkstores/feature/model/NavigationTarget;", "uiScope", "Lkotlinx/coroutines/CoroutineScope;", "getUiScope", "()Lkotlinx/coroutines/CoroutineScope;", "uiScope$delegate", "checkImmediateNavigation", "", "clearCart", "disposeError", "onRetryClicked", "Lkotlin/Function0;", "getInitialParams", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "config", "Lcom/talabat/darkstores/feature/Darkstores$Config;", "getLocale", "Ljava/util/Locale;", "language", "Lcom/talabat/darkstores/feature/main/DarkstoresMainActivity$Language;", "hideBottomCartView", "hideBottomCartViewError", "()Lkotlin/Unit;", "navigateToHomeScreenIfNoConfig", "observeBottomCartViewState", "observeCartInitErrorLiveData", "observeCartListToastMessage", "observeCartSyncWarning", "observeCheckoutActionLiveData", "observeClearCartPermission", "observeDeliveryTierBottomSheetViewState", "observeDeliveryTierInfo", "observeNavigationActions", "observeNavigationReady", "observeProductErrors", "observeVoucherGenerationLiveData", "obtainConfig", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPostCreate", "retryCartInit", "setupBottomCartView", "setupNavController", "showBottomCartView", "screenTrackingInfo", "Lcom/talabat/darkstores/feature/cart/model/ScreenTrackingInfo;", "showBottomCartViewError", "resultError", "Lcom/talabat/darkstores/common/Result$Error;", "Lcom/talabat/darkstores/feature/cart/CartFragmentData;", "showDarkstoresProductErrorMessage", "showError", "error", "", "showGroceryDeliveryTiers", "deliveryTierBottomSheetViewState", "Lcom/talabat/darkstores/feature/main/viewmodel/DeliveryTierBottomSheetViewState;", "updateResources", "locale", "getToastModel", "Lcom/designsystem/ds_toast/DSToastModel;", "Lcom/talabat/feature/darkstorescartlist/domain/model/CartListToast;", "Companion", "Language", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresMainActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public static final String CONFIG_EXTRA_KEY = "config";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_TOAST_LENGTH = 70;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final Lazy bottomSheetViewStateViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DeliveryTierBottomSheetViewStateViewModel.class), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$2(this), new DarkstoresMainActivity$special$$inlined$viewModel$2(), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$3((Function0) null, this));
    @Nullable
    private MaterialDialog cartErrorDialog;
    @NotNull
    private final Lazy cartViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(CartFragmentViewModel.class), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$2(this), new DarkstoresMainActivity$special$$inlined$viewModel$1(), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$3((Function0) null, this));
    @NotNull
    private final Lazy coroutineDispatchersFactory$delegate;
    /* access modifiers changed from: private */
    @NotNull
    public final ErrorViewDispatcher dispatcher;
    @Nullable
    private ErrorView errorView;
    @NotNull
    private final Lazy mainViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(MainViewModel.class), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$2(this), new DarkstoresMainActivity$special$$inlined$viewModel$3(), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$3((Function0) null, this));
    @NotNull
    private final Lazy navController$delegate;
    @NotNull
    private final Lazy uiScope$delegate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/feature/main/DarkstoresMainActivity$Companion;", "", "()V", "CONFIG_EXTRA_KEY", "", "MAX_TOAST_LENGTH", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/darkstores/feature/main/DarkstoresMainActivity$Language;", "", "(Ljava/lang/String;I)V", "AR", "EN", "CKB", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Language {
        AR,
        EN,
        CKB
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Language.values().length];
            iArr[Language.AR.ordinal()] = 1;
            iArr[Language.EN.ordinal()] = 2;
            iArr[Language.CKB.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DarkstoresMainActivity() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.navController$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new DarkstoresMainActivity$navController$2(this));
        this.coroutineDispatchersFactory$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new DarkstoresMainActivity$coroutineDispatchersFactory$2(this));
        this.uiScope$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new DarkstoresMainActivity$uiScope$2(this));
        this.dispatcher = new ErrorViewDispatcher();
    }

    private final void checkImmediateNavigation() {
        NavigationTarget navigationTarget = getNavigationTarget();
        NavigationTarget.Immediate immediate = navigationTarget instanceof NavigationTarget.Immediate ? (NavigationTarget.Immediate) navigationTarget : null;
        if (immediate != null) {
            getMainViewModel().onImmediateNavigation(immediate);
        }
    }

    private final DeliveryTierBottomSheetViewStateViewModel getBottomSheetViewStateViewModel() {
        return (DeliveryTierBottomSheetViewStateViewModel) this.bottomSheetViewStateViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final CartFragmentViewModel getCartViewModel() {
        return (CartFragmentViewModel) this.cartViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final CoroutineDispatchersFactory getCoroutineDispatchersFactory() {
        return (CoroutineDispatchersFactory) this.coroutineDispatchersFactory$delegate.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        if (r0 == false) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.talabat.darkstores.data.ConfigurationParameters getInitialParams(com.talabat.darkstores.feature.Darkstores.Config r18) {
        /*
            r17 = this;
            double r0 = r18.getLongitude()
            r2 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            r4 = 0
            if (r0 != 0) goto L_0x000e
            r0 = r1
            goto L_0x000f
        L_0x000e:
            r0 = r4
        L_0x000f:
            if (r0 != 0) goto L_0x001f
            double r5 = r18.getLatitude()
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x001b
            r0 = r1
            goto L_0x001c
        L_0x001b:
            r0 = r4
        L_0x001c:
            if (r0 != 0) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r1 = r4
        L_0x0020:
            if (r1 == 0) goto L_0x006a
            java.lang.String r3 = r18.getRestaurantJson()
            java.lang.String r4 = r18.getCountryCode()
            java.lang.String r5 = r18.getLocale()
            com.talabat.darkstores.data.discovery.model.Point r8 = new com.talabat.darkstores.data.discovery.model.Point
            double r0 = r18.getLongitude()
            double r6 = r18.getLatitude()
            r8.<init>(r0, r6)
            java.lang.String r9 = r18.getCustomerId()
            com.talabat.darkstores.data.Environment r10 = r18.getEnvironment()
            java.lang.String r6 = r18.getCurrencyCode()
            java.lang.String r7 = r18.getDjiniGlobalEntityId()
            java.lang.String r11 = r18.getSearchTerm()
            boolean r12 = r18.isFromDeepLink()
            com.talabat.darkstores.feature.Darkstores$DarkstoresTrackingData r13 = r18.getDarkstoresTrackingData()
            int r14 = r18.getDeeplinkType()
            java.lang.String r15 = r18.getEventOrigin()
            java.lang.String r16 = r18.getExperimentKey()
            com.talabat.darkstores.data.ConfigurationParameters r0 = new com.talabat.darkstores.data.ConfigurationParameters
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        L_0x006a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Failed requirement."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.main.DarkstoresMainActivity.getInitialParams(com.talabat.darkstores.feature.Darkstores$Config):com.talabat.darkstores.data.ConfigurationParameters");
    }

    private final Locale getLocale(Language language) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[language.ordinal()];
        if (i11 == 1) {
            return new Locale(ArchiveStreamFactory.AR, Profile.Country.KW);
        }
        if (i11 == 2) {
            return new Locale("en", Profile.Country.GB);
        }
        if (i11 == 3) {
            return new Locale(GlobalConstants.KURDISH_SORANI_LOCAL, "IQ");
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    public final MainViewModel getMainViewModel() {
        return (MainViewModel) this.mainViewModel$delegate.getValue();
    }

    private final NavigationTarget getNavigationTarget() {
        Darkstores.Config obtainConfig = obtainConfig();
        if (obtainConfig != null) {
            return NavigationTarget.Companion.create$com_talabat_NewArchi_darkstores_darkstores(obtainConfig.getDeeplinkType(), obtainConfig.getDeeplinkInfo(), obtainConfig.getDeeplinkUri(), obtainConfig.getScreenTitle(), obtainConfig.getEventOrigin(), obtainConfig.getSearchTerm());
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final DSToastModel getToastModel(CartListToast cartListToast) {
        int i11;
        if (cartListToast instanceof CartListToast.FirstCartControl) {
            i11 = R.string.qcommerce_multi_basket_toast_first_cart;
        } else if (cartListToast instanceof CartListToast.SecondCartControl) {
            i11 = R.string.qcommerce_multi_basket_toast_second_cart;
        } else if (cartListToast instanceof CartListToast.SecondCartVariation1) {
            i11 = R.string.qcommerce_multi_basket_toast_second_cart_variation1;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        String string = getString(i11);
        Intrinsics.checkNotNullExpressionValue(string, "when (this) {\n          …       }.let(::getString)");
        if (string.length() > 70) {
            string = string.substring(0, 69);
            Intrinsics.checkNotNullExpressionValue(string, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        if (!(cartListToast instanceof CartListToast.SecondCartVariation1)) {
            return new DSToastModel(string, Integer.valueOf(com.designsystem.marshmallow.R.drawable.ds_tooltip));
        }
        DSToastModel.Companion companion = DSToastModel.Companion;
        int i12 = com.designsystem.marshmallow.R.drawable.ds_multi_basket;
        String string2 = getString(R.string.f61016ok);
        Integer valueOf = Integer.valueOf(i12);
        DarkstoresMainActivity$getToastModel$1 darkstoresMainActivity$getToastModel$1 = new DarkstoresMainActivity$getToastModel$1(this);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(com.talabat.localization.R.string.ok)");
        return companion.withActionButton(string, valueOf, darkstoresMainActivity$getToastModel$1, string2);
    }

    private final CoroutineScope getUiScope() {
        return (CoroutineScope) this.uiScope$delegate.getValue();
    }

    private final void hideBottomCartView() {
        ((CartProgressView) _$_findCachedViewById(com.talabat.darkstores.R.id.cartProgressView)).hide();
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(com.talabat.darkstores.R.id.bottom_cart_container);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "bottom_cart_container");
        frameLayout.setVisibility(8);
    }

    private final Unit hideBottomCartViewError() {
        MaterialDialog materialDialog = this.cartErrorDialog;
        if (materialDialog == null) {
            return null;
        }
        materialDialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void navigateToHomeScreenIfNoConfig() {
        Intent intent = new Intent("talabat.action.homeScreen");
        intent.addFlags(268468224);
        startActivity(intent);
        finish();
    }

    private final void observeBottomCartViewState() {
        getCartViewModel().getShowBottomCartViewStateLiveData().observe(this, new s(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeBottomCartViewState$lambda-32  reason: not valid java name */
    public static final void m9982observeBottomCartViewState$lambda32(DarkstoresMainActivity darkstoresMainActivity, BottomCartViewState bottomCartViewState) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        if (bottomCartViewState instanceof BottomCartViewState.ShowBottomCartViewState) {
            darkstoresMainActivity.showBottomCartView(((BottomCartViewState.ShowBottomCartViewState) bottomCartViewState).getScreenTrackingInfo());
        } else if (Intrinsics.areEqual((Object) bottomCartViewState, (Object) BottomCartViewState.HideBottomCartViewState.INSTANCE)) {
            darkstoresMainActivity.hideBottomCartView();
        }
    }

    private final void observeCartInitErrorLiveData() {
        getCartViewModel().getCartInitErrorLiveData().observe(this, new i(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeCartInitErrorLiveData$lambda-36  reason: not valid java name */
    public static final void m9983observeCartInitErrorLiveData$lambda36(DarkstoresMainActivity darkstoresMainActivity, EventWrapper eventWrapper) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        Throwable th2 = (Throwable) eventWrapper.getContentIfNotHandled();
        if (th2 != null) {
            darkstoresMainActivity.showError(th2, new DarkstoresMainActivity$observeCartInitErrorLiveData$1$1$1(darkstoresMainActivity));
        }
    }

    private final void observeCartListToastMessage() {
        getCartViewModel().getCartListToastLiveData().observe(this, new p(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeCartListToastMessage$lambda-34  reason: not valid java name */
    public static final void m9984observeCartListToastMessage$lambda34(DarkstoresMainActivity darkstoresMainActivity, EventWrapper eventWrapper) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        CartListToast cartListToast = (CartListToast) eventWrapper.getContentIfNotHandled();
        if (cartListToast != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(darkstoresMainActivity.getUiScope(), (CoroutineContext) null, (CoroutineStart) null, new DarkstoresMainActivity$observeCartListToastMessage$1$1$1(darkstoresMainActivity, cartListToast, (Continuation<? super DarkstoresMainActivity$observeCartListToastMessage$1$1$1>) null), 3, (Object) null);
        }
    }

    private final void observeCartSyncWarning() {
        getCartViewModel().getCartSyncWarning().observe(this, new k(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeCartSyncWarning$lambda-25  reason: not valid java name */
    public static final void m9985observeCartSyncWarning$lambda25(DarkstoresMainActivity darkstoresMainActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        if (bool.booleanValue()) {
            Toast.makeText(darkstoresMainActivity, R.string.cart_product_stock_not_available, 1).show();
        }
    }

    private final void observeCheckoutActionLiveData() {
        getCartViewModel().getCheckoutActionLiveData().observe(this, new q(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeCheckoutActionLiveData$lambda-20  reason: not valid java name */
    public static final void m9986observeCheckoutActionLiveData$lambda20(DarkstoresMainActivity darkstoresMainActivity, EventWrapper eventWrapper) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        CheckoutParams checkoutParams = (CheckoutParams) eventWrapper.getContentIfNotHandled();
        if (checkoutParams != null) {
            darkstoresMainActivity.getCartViewModel().checkout(darkstoresMainActivity, checkoutParams);
        }
    }

    private final void observeClearCartPermission() {
        getCartViewModel().getCartClearPermission().observe(this, new l(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeClearCartPermission$lambda-16  reason: not valid java name */
    public static final void m9987observeClearCartPermission$lambda16(DarkstoresMainActivity darkstoresMainActivity, CartFragmentViewModel.ClearCartPermissionData clearCartPermissionData) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        AlertDialog.Builder title = new AlertDialog.Builder(darkstoresMainActivity, com.talabat.talabatcommon.R.style.AlertDialogTheme).setTitle((CharSequence) darkstoresMainActivity.getString(R.string.clear_cart_alert_title));
        String string = darkstoresMainActivity.getString(R.string.already_has_items_in_cart);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…lready_has_items_in_cart)");
        title.setMessage((CharSequence) StringsKt__StringsJVMKt.replace$default(string, "#", clearCartPermissionData.getCartVendorName(), false, 4, (Object) null)).setPositiveButton(R.string.continue_order, (DialogInterface.OnClickListener) new b(darkstoresMainActivity, clearCartPermissionData)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) new c(darkstoresMainActivity, clearCartPermissionData)).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: observeClearCartPermission$lambda-16$lambda-14  reason: not valid java name */
    public static final void m9988observeClearCartPermission$lambda16$lambda14(DarkstoresMainActivity darkstoresMainActivity, CartFragmentViewModel.ClearCartPermissionData clearCartPermissionData, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        CartFragmentViewModel cartViewModel = darkstoresMainActivity.getCartViewModel();
        Intrinsics.checkNotNullExpressionValue(clearCartPermissionData, "clearCartPermissionData");
        cartViewModel.onClearCartPermissionGranted(clearCartPermissionData);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeClearCartPermission$lambda-16$lambda-15  reason: not valid java name */
    public static final void m9989observeClearCartPermission$lambda16$lambda15(DarkstoresMainActivity darkstoresMainActivity, CartFragmentViewModel.ClearCartPermissionData clearCartPermissionData, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        CartFragmentViewModel cartViewModel = darkstoresMainActivity.getCartViewModel();
        Intrinsics.checkNotNullExpressionValue(clearCartPermissionData, "clearCartPermissionData");
        cartViewModel.onClearCartPermissionDenied(clearCartPermissionData);
    }

    private final void observeDeliveryTierBottomSheetViewState() {
        getBottomSheetViewStateViewModel().getDeliveryTierBottomSheetViewState().observe(this, new r(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeDeliveryTierBottomSheetViewState$lambda-5  reason: not valid java name */
    public static final void m9990observeDeliveryTierBottomSheetViewState$lambda5(DarkstoresMainActivity darkstoresMainActivity, DeliveryTierBottomSheetViewState deliveryTierBottomSheetViewState) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        if (deliveryTierBottomSheetViewState.getBottomSheetViewState() == BottomSheetViewState.SHOW) {
            Intrinsics.checkNotNullExpressionValue(deliveryTierBottomSheetViewState, "deliveryTierBottomSheetViewState");
            darkstoresMainActivity.showGroceryDeliveryTiers(deliveryTierBottomSheetViewState);
        }
    }

    private final void observeDeliveryTierInfo() {
        getCartViewModel().deliveryDetails().observe(this, new j(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeDeliveryTierInfo$lambda-8  reason: not valid java name */
    public static final void m9991observeDeliveryTierInfo$lambda8(DarkstoresMainActivity darkstoresMainActivity, Result result) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        if (result instanceof Result.Success) {
            DeliveryDetails deliveryDetails = (DeliveryDetails) ((Result.Success) result).getData();
            if (darkstoresMainActivity.getCartViewModel().enableBasketBasedDeliveryFee(deliveryDetails.isTPro(), deliveryDetails.getBasketDeliveryFeeTiersInfo()) && deliveryDetails.getBasketDeliveryFeeTiersInfo() != null) {
                ((CartProgressView) darkstoresMainActivity._$_findCachedViewById(com.talabat.darkstores.R.id.cartProgressView)).showDeliveryTierInfoIcon();
            }
        }
    }

    private final void observeNavigationActions() {
        getMainViewModel().getNavigationActions().observe(this, new o(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeNavigationActions$lambda-9  reason: not valid java name */
    public static final void m9992observeNavigationActions$lambda9(DarkstoresMainActivity darkstoresMainActivity, EventWrapper eventWrapper) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        NavDirections navDirections = (NavDirections) eventWrapper.getContentIfNotHandled();
        if (navDirections != null) {
            darkstoresMainActivity.getNavController$com_talabat_NewArchi_darkstores_darkstores().navigate(navDirections);
        }
    }

    private final void observeNavigationReady() {
        getCartViewModel().getNavigationReadyLiveData().observe(this, new m(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeNavigationReady$lambda-12  reason: not valid java name */
    public static final void m9993observeNavigationReady$lambda12(DarkstoresMainActivity darkstoresMainActivity, EventWrapper eventWrapper) {
        NavigationTarget.Deferred deferred;
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        if (((Unit) eventWrapper.getContentIfNotHandled()) != null) {
            NavigationTarget navigationTarget = darkstoresMainActivity.getNavigationTarget();
            if (navigationTarget instanceof NavigationTarget.Deferred) {
                deferred = (NavigationTarget.Deferred) navigationTarget;
            } else {
                deferred = null;
            }
            if (deferred != null) {
                darkstoresMainActivity.getMainViewModel().onDeferredNavigation(deferred);
            }
        }
    }

    private final void observeProductErrors() {
        getMainViewModel().getProductInfoErrors().observe(this, new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeProductErrors$lambda-18  reason: not valid java name */
    public static final void m9994observeProductErrors$lambda18(DarkstoresMainActivity darkstoresMainActivity, EventWrapper eventWrapper) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        if (((Unit) eventWrapper.getContentIfNotHandled()) != null) {
            darkstoresMainActivity.showDarkstoresProductErrorMessage();
        }
    }

    private final void observeVoucherGenerationLiveData() {
        getMainViewModel().getShowToastMessage().observe(this, new n(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeVoucherGenerationLiveData$lambda-4  reason: not valid java name */
    public static final void m9995observeVoucherGenerationLiveData$lambda4(DarkstoresMainActivity darkstoresMainActivity, EventWrapper eventWrapper) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        Job unused = BuildersKt__Builders_commonKt.launch$default(darkstoresMainActivity.getUiScope(), (CoroutineContext) null, (CoroutineStart) null, new DarkstoresMainActivity$observeVoucherGenerationLiveData$1$1(eventWrapper, darkstoresMainActivity, (Continuation<? super DarkstoresMainActivity$observeVoucherGenerationLiveData$1$1>) null), 3, (Object) null);
    }

    private final Darkstores.Config obtainConfig() {
        Intent intent = getIntent();
        if (intent != null) {
            return (Darkstores.Config) intent.getParcelableExtra(CONFIG_EXTRA_KEY);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final void retryCartInit() {
        getCartViewModel().initCart();
        disposeError(new DarkstoresMainActivity$retryCartInit$1(this));
    }

    private final void setupBottomCartView() {
        getNavController$com_talabat_NewArchi_darkstores_darkstores().addOnDestinationChangedListener(new d(this));
        getCartViewModel().getCartFragmentLiveData().observe(this, new e(this));
        getCartViewModel().campaignVisualisation().observe(this, new f(this));
        getCartViewModel().getDuplicateCartLiveData().observe(this, new g(this));
        ((BottomCartView) _$_findCachedViewById(com.talabat.darkstores.R.id.bottom_cart_view)).setOnSeeCartClickListener(new DarkstoresMainActivity$setupBottomCartView$5(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupBottomCartView$lambda-26  reason: not valid java name */
    public static final void m9996setupBottomCartView$lambda26(DarkstoresMainActivity darkstoresMainActivity, NavController navController, NavDestination navDestination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        Intrinsics.checkNotNullParameter(navController, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(navDestination, "destination");
        ContextExtensionsKt.hideKeyboard((Activity) darkstoresMainActivity);
        darkstoresMainActivity.getCartViewModel().handleNavDestinationChange(navDestination, bundle);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupBottomCartView$lambda-28  reason: not valid java name */
    public static final void m9997setupBottomCartView$lambda28(DarkstoresMainActivity darkstoresMainActivity, Result result) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        int i11 = com.talabat.darkstores.R.id.bottom_cart_view;
        ((BottomCartView) darkstoresMainActivity._$_findCachedViewById(i11)).setLoading(result instanceof Result.Loading);
        if (result instanceof Result.Error) {
            darkstoresMainActivity.showBottomCartViewError((Result.Error) result);
        } else {
            darkstoresMainActivity.hideBottomCartViewError();
        }
        if (result instanceof Result.Success) {
            Pair<List<Product>, CartSummary> cartProductsWithSummary = ((CartFragmentData) ((Result.Success) result).getData()).getCartProductsWithSummary();
            ((BottomCartView) darkstoresMainActivity._$_findCachedViewById(i11)).setData(cartProductsWithSummary.component1(), cartProductsWithSummary.component2());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setupBottomCartView$lambda-29  reason: not valid java name */
    public static final void m9998setupBottomCartView$lambda29(DarkstoresMainActivity darkstoresMainActivity, CampaignProgressVisualisation campaignProgressVisualisation) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(campaignProgressVisualisation, "it");
        ((CartProgressView) darkstoresMainActivity._$_findCachedViewById(com.talabat.darkstores.R.id.cartProgressView)).visualise(campaignProgressVisualisation);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupBottomCartView$lambda-31  reason: not valid java name */
    public static final void m9999setupBottomCartView$lambda31(DarkstoresMainActivity darkstoresMainActivity, EventWrapper eventWrapper) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        Boolean bool = (Boolean) eventWrapper.getContentIfNotHandled();
        if (bool != null) {
            bool.booleanValue();
            darkstoresMainActivity.getCartViewModel().resetCartWithNewId();
        }
    }

    /* access modifiers changed from: private */
    public final NavController setupNavController() {
        Bundle bundle;
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(com.talabat.darkstores.R.id.nav_host_fragment);
        if (findFragmentById != null) {
            NavController navController = ((NavHostFragment) findFragmentById).getNavController();
            NavGraph inflate = navController.getNavInflater().inflate(com.talabat.darkstores.R.navigation.nav_graph);
            if (getMainViewModel().isVlpFlutterEnabled()) {
                inflate.setStartDestination(com.talabat.darkstores.R.id.flutterSearchFragment);
                FlutterConfigurationParams flutterConfigurationParams = getMainViewModel().getFlutterConfigurationParams();
                bundle = new QCommerceFlutterFragmentArgs(flutterConfigurationParams, new VlpRoute(flutterConfigurationParams.getVendorCode())).toBundle();
            } else {
                inflate.setStartDestination(com.talabat.darkstores.R.id.homeFragment);
                bundle = null;
            }
            navController.setGraph(inflate, bundle);
            return navController;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
    }

    private final void showBottomCartView(ScreenTrackingInfo screenTrackingInfo) {
        ((CartProgressView) _$_findCachedViewById(com.talabat.darkstores.R.id.cartProgressView)).showIfPossible(screenTrackingInfo);
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(com.talabat.darkstores.R.id.bottom_cart_container);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "bottom_cart_container");
        frameLayout.setVisibility(0);
    }

    private final void showBottomCartViewError(Result.Error<CartFragmentData> error) {
        HttpException httpException;
        int intValue;
        if (this.dispatcher.isErrorViewVisible()) {
            this.dispatcher.addCallback(new DarkstoresMainActivity$showBottomCartViewError$1(getCartViewModel()));
            return;
        }
        Integer num = null;
        MaterialDialog materialDialog = new MaterialDialog(this, (DialogBehavior) null, 2, (DefaultConstructorMarker) null);
        materialDialog.cancelable(!error.isBlocking());
        materialDialog.cancelOnTouchOutside(!error.isBlocking());
        Throwable error2 = error.getError();
        if (error2 instanceof HttpException) {
            httpException = (HttpException) error2;
        } else {
            httpException = null;
        }
        if (httpException != null) {
            num = Integer.valueOf(httpException.code());
        }
        String string = getString(R.string.bottom_cart_view_error);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…g.bottom_cart_view_error)");
        if (num != null && ((intValue = num.intValue()) == 400 || intValue == 404 || intValue == 409)) {
            string = getString(R.string.duplicate_cart_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ing.duplicate_cart_error)");
        }
        MaterialDialog.message$default(materialDialog, (Integer) null, string, (Function1) null, 5, (Object) null);
        if (error.isBlocking()) {
            MaterialDialog.positiveButton$default(materialDialog, Integer.valueOf(R.string.retry), (CharSequence) null, new DarkstoresMainActivity$showBottomCartViewError$2$2(this), 2, (Object) null);
        } else {
            MaterialDialog.positiveButton$default(materialDialog, 17039370, (CharSequence) null, new DarkstoresMainActivity$showBottomCartViewError$2$3(materialDialog), 2, (Object) null);
        }
        materialDialog.show();
        this.cartErrorDialog = materialDialog;
    }

    private final void showDarkstoresProductErrorMessage() {
        Toast.makeText(this, R.string.darkstores_product_not_found_message, 1).show();
    }

    private final void showGroceryDeliveryTiers(DeliveryTierBottomSheetViewState deliveryTierBottomSheetViewState) {
        getCartViewModel().deliveryDetails().observe(this, new h(this, deliveryTierBottomSheetViewState));
    }

    /* access modifiers changed from: private */
    /* renamed from: showGroceryDeliveryTiers$lambda-23  reason: not valid java name */
    public static final void m10000showGroceryDeliveryTiers$lambda23(DarkstoresMainActivity darkstoresMainActivity, DeliveryTierBottomSheetViewState deliveryTierBottomSheetViewState, Result result) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "this$0");
        Intrinsics.checkNotNullParameter(deliveryTierBottomSheetViewState, "$deliveryTierBottomSheetViewState");
        if ((result instanceof Result.Success) && ((DeliveryDetails) ((Result.Success) result).getData()).getBasketDeliveryFeeTiersInfo() != null) {
            darkstoresMainActivity.getCartViewModel().onDeliveryTierBottomSheetClicked(deliveryTierBottomSheetViewState.getScreenTrackingInfo().getEventOriginType(), deliveryTierBottomSheetViewState.getClickOrigin());
            darkstoresMainActivity.getCartViewModel().handleDeliveryFeeNavigation(new DarkstoresMainActivity$showGroceryDeliveryTiers$1$1$1$1(darkstoresMainActivity));
        }
    }

    private final void updateResources(Locale locale) {
        Locale.setDefault(locale);
        getResources().getConfiguration().locale = locale;
        getResources().getConfiguration().setLayoutDirection(locale);
        getResources().updateConfiguration(getResources().getConfiguration(), getResources().getDisplayMetrics());
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

    public final void clearCart() {
        getCartViewModel().clearCart();
    }

    public final void disposeError(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onRetryClicked");
        this.dispatcher.dispose(function0);
    }

    @Nullable
    public final ErrorView getErrorView() {
        return this.errorView;
    }

    @NotNull
    public final NavController getNavController$com_talabat_NewArchi_darkstores_darkstores() {
        return (NavController) this.navController$delegate.getValue();
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("DarkstoresMainActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "DarkstoresMainActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "DarkstoresMainActivity#onCreate", (ArrayList<String>) null);
        }
        Darkstores.Config obtainConfig = obtainConfig();
        if (obtainConfig != null) {
            updateResources(getLocale(obtainConfig.getLanguage()));
            Injector injector = Injector.INSTANCE;
            Application application = getApplication();
            Intrinsics.checkNotNullExpressionValue(application, MimeTypes.BASE_TYPE_APPLICATION);
            injector.createAppComponent(application, getInitialParams(obtainConfig));
        }
        super.onCreate(bundle);
        if (obtainConfig == null) {
            navigateToHomeScreenIfNoConfig();
            TraceMachine.exitMethod();
            return;
        }
        setContentView(com.talabat.darkstores.R.layout.darkstores_activity_main);
        setErrorView((LoadingFailedView) _$_findCachedViewById(com.talabat.darkstores.R.id.loadingFailedView));
        if (bundle == null) {
            if (obtainConfig.getShouldClearCart()) {
                clearCart();
            }
            getCartViewModel().onVendorMenuOpened();
        }
        observeNavigationActions();
        observeCartSyncWarning();
        observeNavigationReady();
        observeClearCartPermission();
        checkImmediateNavigation();
        observeDeliveryTierBottomSheetViewState();
        observeDeliveryTierInfo();
        observeBottomCartViewState();
        observeCartListToastMessage();
        observeCartInitErrorLiveData();
        observeProductErrors();
        observeCheckoutActionLiveData();
        observeVoucherGenerationLiveData();
        TraceMachine.exitMethod();
    }

    public void onDestroy() {
        super.onDestroy();
        Injector injector = Injector.INSTANCE;
        if (injector.getAppComponent() != null) {
            getCartViewModel().clearVendorCache();
            injector.clearAppComponent();
        }
    }

    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        super.onNewIntent(intent);
        setIntent(intent);
        checkImmediateNavigation();
    }

    public void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        setupBottomCartView();
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public final void setErrorView(@Nullable ErrorView errorView2) {
        if (errorView2 == null) {
            errorView2 = (LoadingFailedView) _$_findCachedViewById(com.talabat.darkstores.R.id.loadingFailedView);
        }
        this.errorView = errorView2;
        this.dispatcher.setErrorView(errorView2);
    }

    public final void showError(@NotNull Throwable th2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(th2, "error");
        Intrinsics.checkNotNullParameter(function0, "onRetryClicked");
        this.dispatcher.dispatch(th2, function0);
    }
}
