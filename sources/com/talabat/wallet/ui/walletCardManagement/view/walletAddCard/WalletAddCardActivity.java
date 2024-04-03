package com.talabat.wallet.ui.walletCardManagement.view.walletAddCard;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.talabatcommon.extentions.ActivityKt;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.WalletAddCardFragment;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.WalletAddCardNavigationInterface;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.WalletAddCardSuccessInterface;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.WalletAddCardThreeDsSuccess;
import com.talabat.talabatcore.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u0013"}, d2 = {"Lcom/talabat/wallet/ui/walletCardManagement/view/walletAddCard/WalletAddCardActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardSuccessInterface;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardNavigationInterface;", "()V", "addFragment", "", "savedInstanceState", "Landroid/os/Bundle;", "containerId", "", "fragment", "Landroidx/fragment/app/Fragment;", "navigateToAddCardSuccess", "navigateToThreeDsScreen", "argument", "onAttachFragment", "onBackPressed", "onCreate", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletAddCardActivity extends AppCompatActivity implements WalletAddCardSuccessInterface, WalletAddCardNavigationInterface, TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

    private final void addFragment(Bundle bundle, int i11, Fragment fragment) {
        if (bundle == null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
            fragment.setArguments(getIntent().getExtras());
            Unit unit = Unit.INSTANCE;
            FragmentTransaction add = beginTransaction.add(i11, fragment);
            Intrinsics.checkNotNullExpressionValue(add, "add(\n                   …  }\n                    )");
            add.commit();
        }
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

    public void navigateToAddCardSuccess() {
    }

    public void navigateToThreeDsScreen(@Nullable Bundle bundle) {
        WalletAddCardThreeDsSuccess walletAddCardThreeDsSuccess = new WalletAddCardThreeDsSuccess();
        walletAddCardThreeDsSuccess.setListener(this);
        walletAddCardThreeDsSuccess.setArguments(bundle);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "supportFragmentManager.beginTransaction()");
        beginTransaction.replace(R.id.fragmentContainer, walletAddCardThreeDsSuccess);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commit();
    }

    public void onAttachFragment(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        super.onAttachFragment(fragment);
        if (fragment instanceof WalletAddCardFragment) {
            WalletAddCardFragment walletAddCardFragment = (WalletAddCardFragment) fragment;
            walletAddCardFragment.setAddCardSuccessListener(this);
            walletAddCardFragment.setAddCardNavigationInterface(this);
        }
    }

    public void onBackPressed() {
        ActivityKt.hideKeyBoard(this);
        finish();
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("WalletAddCardActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "WalletAddCardActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "WalletAddCardActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_layout);
        addFragment(bundle, R.id.fragmentContainer, new WalletAddCardFragment());
        TraceMachine.exitMethod();
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }
}
