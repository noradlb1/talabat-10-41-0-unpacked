package com.talabat.helpcenter.presentation.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.huawei.location.lite.common.util.PermissionUtil;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.helpcenter.R;
import com.talabat.helpcenter.di.HelpCenterFactory;
import com.talabat.helpcenter.presentation.viewModel.GlobalHelpCenterViewModel;
import com.talabat.helpcenter.presentation.viewModel.GlobalHelpCenterWebEvent;
import com.talabat.helpcenter.presentation.viewState.GlobalHelpCenterViewState;
import com.talabat.helpcenter.presentation.webInterface.GlobalHelpCenterWebAppInterface;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.deeplink.IDeepLinkPresenter;
import yr.a;
import yr.b;

@Instrumented
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0006\u0010\u0011\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\u0012\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J-\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\u000e\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040$2\u0006\u0010%\u001a\u00020&H\u0016¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u001b\u0010)\u001a\u00020\u000f2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010$¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\u000fH\u0002J\u0006\u0010.\u001a\u00020\u000fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u00060"}, d2 = {"Lcom/talabat/helpcenter/presentation/webview/GlobalHelpCenterWebViewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "entryPoint", "", "resultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "viewModel", "Lcom/talabat/helpcenter/presentation/viewModel/GlobalHelpCenterViewModel;", "getViewModel", "()Lcom/talabat/helpcenter/presentation/viewModel/GlobalHelpCenterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addJavascriptInterface", "", "addWebChromeClient", "checkForPermissions", "initializeResultLauncher", "loadUrl", "url", "observeGlobalHelpCenterEvents", "event", "Lcom/talabat/helpcenter/presentation/viewModel/GlobalHelpCenterWebEvent;", "observeGlobalHelpCenterUrlChanges", "viewState", "Lcom/talabat/helpcenter/presentation/viewState/GlobalHelpCenterViewState;", "observeViewModel", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "redirectToRiderChat", "returnDataToWebViewChromeClient", "value", "Landroid/net/Uri;", "([Landroid/net/Uri;)V", "setup", "showImageChooser", "Companion", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalHelpCenterWebViewActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public static final String APP_VERSION_KEY = "app_version";
    @NotNull
    public static final String CASE_ID = "case_id";
    @NotNull
    public static final String CURRENT_ORDER_ID_KEY = "current_order_id";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String ENTRY_POINT_DEEP_LINK = "deep_link";
    @NotNull
    private static final String HELP_CENTER_BRIDGE_ENTRY_KEY_NAME = "hcAndroidBridgeEntry";
    @NotNull
    public static final String HELP_CENTER_CASE_ID = "case_id";
    @NotNull
    public static final String HELP_CENTER_ENTRY_POINT = "help_center_entryPoint";
    @NotNull
    public static final String ORDER_TRACKING = "order_tracking";
    @NotNull
    public static final String RIDER_CHAT_DEEP_LINK = "talabat://?s=rc";
    @NotNull
    private static final String SEND_BRIDGE_MESSAGE_FROM_ANDROID = "window.sendBridgeMessageFromAndroid";
    public static final int UPLOAD_FILE = 1000;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @Nullable
    private String entryPoint;
    private ActivityResultLauncher<Intent> resultLauncher;
    @NotNull
    private final Lazy viewModel$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, GlobalHelpCenterWebViewActivity$viewModel$2.INSTANCE);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/helpcenter/presentation/webview/GlobalHelpCenterWebViewActivity$Companion;", "", "()V", "APP_VERSION_KEY", "", "CASE_ID", "CURRENT_ORDER_ID_KEY", "ENTRY_POINT_DEEP_LINK", "HELP_CENTER_BRIDGE_ENTRY_KEY_NAME", "HELP_CENTER_CASE_ID", "HELP_CENTER_ENTRY_POINT", "ORDER_TRACKING", "RIDER_CHAT_DEEP_LINK", "SEND_BRIDGE_MESSAGE_FROM_ANDROID", "UPLOAD_FILE", "", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void addJavascriptInterface() {
        int i11 = R.id.ghc_web_view;
        ((WebView) _$_findCachedViewById(i11)).addJavascriptInterface(new GlobalHelpCenterWebAppInterface(getViewModel()), HELP_CENTER_BRIDGE_ENTRY_KEY_NAME);
        ((WebView) _$_findCachedViewById(i11)).setWebViewClient(new GlobalHelpCenterWebViewActivity$addJavascriptInterface$1(this));
    }

    private final void addWebChromeClient() {
        ((WebView) _$_findCachedViewById(R.id.ghc_web_view)).setWebChromeClient(new GlobalHelpCenterWebViewActivity$addWebChromeClient$1(this));
    }

    /* access modifiers changed from: private */
    public final GlobalHelpCenterViewModel getViewModel() {
        return (GlobalHelpCenterViewModel) this.viewModel$delegate.getValue();
    }

    private final void initializeResultLauncher() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new b(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…Result(result))\n        }");
        this.resultLauncher = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    /* renamed from: initializeResultLauncher$lambda-0  reason: not valid java name */
    public static final void m10622initializeResultLauncher$lambda0(GlobalHelpCenterWebViewActivity globalHelpCenterWebViewActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(globalHelpCenterWebViewActivity, "this$0");
        GlobalHelpCenterViewModel viewModel = globalHelpCenterWebViewActivity.getViewModel();
        Intrinsics.checkNotNullExpressionValue(activityResult, "result");
        globalHelpCenterWebViewActivity.returnDataToWebViewChromeClient(viewModel.onActivityResult(activityResult));
    }

    private final void loadUrl(String str) {
        LogManager.debug("GHC: loadUrl: " + str);
        ((WebView) _$_findCachedViewById(R.id.ghc_web_view)).loadUrl(str);
        ((ProgressBar) _$_findCachedViewById(R.id.ghc_loading_view)).setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void observeGlobalHelpCenterEvents(GlobalHelpCenterWebEvent globalHelpCenterWebEvent) {
        if (Intrinsics.areEqual((Object) globalHelpCenterWebEvent, (Object) GlobalHelpCenterWebEvent.HelpCenterStarted.INSTANCE)) {
            String bridgeMessage = getViewModel().getBridgeMessage(this);
            ((WebView) _$_findCachedViewById(R.id.ghc_web_view)).evaluateJavascript("window.sendBridgeMessageFromAndroid(" + bridgeMessage + ")", (ValueCallback) null);
        } else if (Intrinsics.areEqual((Object) globalHelpCenterWebEvent, (Object) GlobalHelpCenterWebEvent.HelpCenterClosed.INSTANCE)) {
            String str = this.entryPoint;
            if (str != null && StringsKt__StringsJVMKt.equals$default(str, "deep_link", false, 2, (Object) null)) {
                Navigator.Companion.navigate((Context) this, WalletNavigatorActions.Companion.createNavigationToHomeScreen());
            }
            finish();
        }
    }

    /* access modifiers changed from: private */
    public final void observeGlobalHelpCenterUrlChanges(GlobalHelpCenterViewState globalHelpCenterViewState) {
        if (globalHelpCenterViewState instanceof GlobalHelpCenterViewState.Loading) {
            ((ProgressBar) _$_findCachedViewById(R.id.ghc_loading_view)).setVisibility(0);
        } else if (globalHelpCenterViewState instanceof GlobalHelpCenterViewState.Visible) {
            loadUrl(((GlobalHelpCenterViewState.Visible) globalHelpCenterViewState).getUrl());
        } else if (globalHelpCenterViewState instanceof GlobalHelpCenterViewState.Hidden) {
            finish();
        } else if (globalHelpCenterViewState instanceof GlobalHelpCenterViewState.CheckPermissions) {
            checkForPermissions();
        } else if (globalHelpCenterViewState instanceof GlobalHelpCenterViewState.ReturnDataToClient) {
            returnDataToWebViewChromeClient(((GlobalHelpCenterViewState.ReturnDataToClient) globalHelpCenterViewState).getValue());
        } else if (globalHelpCenterViewState instanceof GlobalHelpCenterViewState.ShowImageChooser) {
            showImageChooser();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void observeViewModel() {
        getViewModel().getGlobalHelpCenterLiveData().observe(this, new a(this));
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new GlobalHelpCenterWebViewActivity$observeViewModel$2(this, (Continuation<? super GlobalHelpCenterWebViewActivity$observeViewModel$2>) null));
    }

    /* access modifiers changed from: private */
    public final void redirectToRiderChat(String str) {
        String query = URI.create(str).getQuery();
        LogManager.debug("GHC: redirectToRiderChat query: " + query);
        IDeepLinkPresenter deepLinkPresenter = HelpCenterFactory.INSTANCE.getDeepLinkPresenter();
        if (deepLinkPresenter != null) {
            deepLinkPresenter.deepLinkRecived(URI.create(str).getQuery());
            deepLinkPresenter.redirectToDeepLink();
        }
    }

    private final void setup() {
        WebSettings settings = ((WebView) _$_findCachedViewById(R.id.ghc_web_view)).getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "ghc_web_view.settings");
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setAllowFileAccess(true);
        addJavascriptInterface();
        addWebChromeClient();
        initializeResultLauncher();
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

    public final void checkForPermissions() {
        boolean z11;
        String[] requiredPermissionArray = getViewModel().getRequiredPermissionArray(this, new String[]{"android.permission.CAMERA", PermissionUtil.READ_EXTERNAL_PERMISSION, PermissionUtil.WRITE_EXTERNAL_PERMISSION});
        if (requiredPermissionArray.length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            ActivityCompat.requestPermissions(this, requiredPermissionArray, 1000);
        } else {
            showImageChooser();
        }
    }

    public void onBackPressed() {
        String bridgeMessageForBackButton = getViewModel().getBridgeMessageForBackButton(this);
        ((WebView) _$_findCachedViewById(R.id.ghc_web_view)).evaluateJavascript("window.sendBridgeMessageFromAndroid(" + bridgeMessageForBackButton + ")", (ValueCallback) null);
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("GlobalHelpCenterWebViewActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "GlobalHelpCenterWebViewActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "GlobalHelpCenterWebViewActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_web_view_global_help_center);
        setup();
        observeViewModel();
        this.entryPoint = getIntent().getStringExtra("help_center_entryPoint");
        String stringExtra = getIntent().getStringExtra("current_order_id");
        String stringExtra2 = getIntent().getStringExtra("app_version");
        String stringExtra3 = getIntent().getStringExtra("case_id");
        GlobalHelpCenterViewModel viewModel = getViewModel();
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        viewModel.onAttach(stringExtra, stringExtra3, stringExtra2);
        TraceMachine.exitMethod();
    }

    public void onRequestPermissionsResult(int i11, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i11, strArr, iArr);
        getViewModel().onRequestPermissionResult(this, i11, strArr, iArr);
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public final void returnDataToWebViewChromeClient(@Nullable Uri[] uriArr) {
        ValueCallback<Uri[]> mFilePathCallback = getViewModel().getMFilePathCallback();
        if (mFilePathCallback != null) {
            mFilePathCallback.onReceiveValue(uriArr);
        }
    }

    public final void showImageChooser() {
        Intent intent = getViewModel().getIntent(this);
        if (intent != null) {
            ActivityResultLauncher<Intent> activityResultLauncher = this.resultLauncher;
            if (activityResultLauncher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resultLauncher");
                activityResultLauncher = null;
            }
            activityResultLauncher.launch(intent);
        }
    }
}
