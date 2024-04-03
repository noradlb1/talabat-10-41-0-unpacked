package com.talabat.userandlocation.compliance.status.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.helpers.CustomDialog;
import com.talabat.localization.R;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModelForResult;
import com.talabat.talabatnavigation.userandlocation.ComplianceVerificationActions;
import com.talabat.userandlocation.compliance.blocked.ui.fragment.CannotProceedDialogFragment;
import com.talabat.userandlocation.compliance.status.presentation.displaymodel.DismissScreenModel;
import com.talabat.userandlocation.compliance.status.presentation.displaymodel.UserVerificationDisplayModel;
import com.talabat.userandlocation.compliance.status.presentation.viewmodel.CheckUserAllowedToOrderViewModel;
import com.talabat.userandlocation.compliance.verification.ui.fragment.ComplianceUserVerificationResult;
import cx.a;
import cx.b;
import cx.c;
import cx.d;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\"\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u000e\u0010\u001d\u001a\u00020\u001e*\u0004\u0018\u00010\u001cH\u0002J\u000e\u0010\u001f\u001a\u00020 *\u0004\u0018\u00010!H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006#"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/ui/activity/CheckUserAllowedToOrderActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "progressDialog", "Lcom/talabat/helpers/CustomDialog;", "getProgressDialog", "()Lcom/talabat/helpers/CustomDialog;", "progressDialog$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/talabat/userandlocation/compliance/status/presentation/viewmodel/CheckUserAllowedToOrderViewModel;", "getViewModel", "()Lcom/talabat/userandlocation/compliance/status/presentation/viewmodel/CheckUserAllowedToOrderViewModel;", "viewModel$delegate", "handleUserInfoVerificationResult", "", "data", "Landroid/content/Intent;", "navigateToUserInfoVerificationScreen", "userVerificationDisplayModel", "Lcom/talabat/userandlocation/compliance/status/presentation/displaymodel/UserVerificationDisplayModel;", "observeViewModel", "onActivityResult", "requestCode", "", "resultCode", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "toParameters", "Lcom/talabat/userandlocation/compliance/status/presentation/viewmodel/CheckUserAllowedToOrderViewModel$Parameters;", "toViewModelResult", "Lcom/talabat/userandlocation/compliance/status/presentation/viewmodel/CheckUserAllowedToOrderViewModel$UserInfoVerificationResult;", "Lcom/talabat/userandlocation/compliance/verification/ui/fragment/ComplianceUserVerificationResult;", "Companion", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckUserAllowedToOrderActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_DATE_OF_BIRTH = "dateOfBirth";
    @NotNull
    public static final String EXTRA_FIRST_NAME = "firstName";
    @NotNull
    public static final String EXTRA_LAST_NAME = "lastName";
    private static final int REQUEST_CODE_VERIFY_USER_INFO = 1;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final Lazy progressDialog$delegate;
    @NotNull
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/ui/activity/CheckUserAllowedToOrderActivity$Companion;", "", "()V", "EXTRA_DATE_OF_BIRTH", "", "EXTRA_FIRST_NAME", "EXTRA_LAST_NAME", "REQUEST_CODE_VERIFY_USER_INFO", "", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CheckUserAllowedToOrderActivity() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CheckUserAllowedToOrderActivity$viewModel$2(this));
        this.progressDialog$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CheckUserAllowedToOrderActivity$progressDialog$2(this));
    }

    private final CustomDialog getProgressDialog() {
        return (CustomDialog) this.progressDialog$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final CheckUserAllowedToOrderViewModel getViewModel() {
        return (CheckUserAllowedToOrderViewModel) this.viewModel$delegate.getValue();
    }

    private final void handleUserInfoVerificationResult(Intent intent) {
        if (intent != null) {
            getViewModel().onUserInfoVerificationResult(toViewModelResult((ComplianceUserVerificationResult) intent.getParcelableExtra("result")));
        }
    }

    private final void navigateToUserInfoVerificationScreen(UserVerificationDisplayModel userVerificationDisplayModel) {
        NavigatorModelForResult createOpenScreenModelForResult = ComplianceVerificationActions.INSTANCE.createOpenScreenModelForResult(1);
        createOpenScreenModelForResult.setInit(new CheckUserAllowedToOrderActivity$navigateToUserInfoVerificationScreen$1(userVerificationDisplayModel));
        Navigator.Companion.navigate((Activity) this, createOpenScreenModelForResult);
    }

    private final void observeViewModel() {
        getViewModel().getShowProgressDialog().observe(this, new a(this));
        getViewModel().getRequestUserInfoVerification().observe(this, new b(this));
        getViewModel().getShowBlockedUserPopup().observe(this, new c(this));
        getViewModel().getDismissScreen().observe(this, new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-0  reason: not valid java name */
    public static final void m5894observeViewModel$lambda0(CheckUserAllowedToOrderActivity checkUserAllowedToOrderActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(checkUserAllowedToOrderActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        boolean booleanValue = bool.booleanValue();
        CustomDialog progressDialog = checkUserAllowedToOrderActivity.getProgressDialog();
        if (booleanValue) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-1  reason: not valid java name */
    public static final void m5895observeViewModel$lambda1(CheckUserAllowedToOrderActivity checkUserAllowedToOrderActivity, UserVerificationDisplayModel userVerificationDisplayModel) {
        Intrinsics.checkNotNullParameter(checkUserAllowedToOrderActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(userVerificationDisplayModel, "it");
        checkUserAllowedToOrderActivity.navigateToUserInfoVerificationScreen(userVerificationDisplayModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-2  reason: not valid java name */
    public static final void m5896observeViewModel$lambda2(CheckUserAllowedToOrderActivity checkUserAllowedToOrderActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(checkUserAllowedToOrderActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "show");
        if (bool.booleanValue()) {
            String string = checkUserAllowedToOrderActivity.getString(R.string.compliance_cannot_place_order_message);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…nnot_place_order_message)");
            CannotProceedDialogFragment newInstance = CannotProceedDialogFragment.Companion.newInstance(string);
            newInstance.setOnDismiss(new CheckUserAllowedToOrderActivity$observeViewModel$3$1(checkUserAllowedToOrderActivity));
            newInstance.show(checkUserAllowedToOrderActivity.getSupportFragmentManager(), CannotProceedDialogFragment.class.getName());
            checkUserAllowedToOrderActivity.getViewModel().onBlockedUserPopupShown(string);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-3  reason: not valid java name */
    public static final void m5897observeViewModel$lambda3(CheckUserAllowedToOrderActivity checkUserAllowedToOrderActivity, DismissScreenModel dismissScreenModel) {
        Intrinsics.checkNotNullParameter(checkUserAllowedToOrderActivity, "this$0");
        if (Intrinsics.areEqual((Object) dismissScreenModel, (Object) DismissScreenModel.WithCancelResult.INSTANCE)) {
            checkUserAllowedToOrderActivity.setResult(0);
        } else if (Intrinsics.areEqual((Object) dismissScreenModel, (Object) DismissScreenModel.WithSuccessResult.INSTANCE)) {
            checkUserAllowedToOrderActivity.setResult(-1);
        }
        checkUserAllowedToOrderActivity.finish();
    }

    private final CheckUserAllowedToOrderViewModel.Parameters toParameters(Bundle bundle) {
        if (bundle == null) {
            return new CheckUserAllowedToOrderViewModel.Parameters((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }
        String string = bundle.getString("firstName", "");
        Intrinsics.checkNotNullExpressionValue(string, "getString(EXTRA_FIRST_NAME, \"\")");
        String string2 = bundle.getString("lastName", "");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(EXTRA_LAST_NAME, \"\")");
        String string3 = bundle.getString("dateOfBirth", "");
        Intrinsics.checkNotNullExpressionValue(string3, "getString(EXTRA_DATE_OF_BIRTH, \"\")");
        return new CheckUserAllowedToOrderViewModel.Parameters(string, string2, string3);
    }

    private final CheckUserAllowedToOrderViewModel.UserInfoVerificationResult toViewModelResult(ComplianceUserVerificationResult complianceUserVerificationResult) {
        String str = "";
        if (complianceUserVerificationResult == null) {
            return new CheckUserAllowedToOrderViewModel.UserInfoVerificationResult(str, str, str, str);
        }
        String firstName = complianceUserVerificationResult.getFirstName();
        if (firstName == null) {
            firstName = str;
        }
        String lastName = complianceUserVerificationResult.getLastName();
        if (lastName == null) {
            lastName = str;
        }
        String dateOfBirth = complianceUserVerificationResult.getDateOfBirth();
        if (dateOfBirth == null) {
            dateOfBirth = str;
        }
        String email = complianceUserVerificationResult.getEmail();
        if (email != null) {
            str = email;
        }
        return new CheckUserAllowedToOrderViewModel.UserInfoVerificationResult(firstName, lastName, dateOfBirth, str);
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

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 != 1) {
            return;
        }
        if (i12 == -1) {
            handleUserInfoVerificationResult(intent);
        } else if (i12 == 0) {
            getViewModel().onUserInfoVerificationCancelled();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("CheckUserAllowedToOrderActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "CheckUserAllowedToOrderActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CheckUserAllowedToOrderActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(com.talabat.userandlocation.compliance.R.layout.layout_check_user_allowed_to_order_activity);
        getViewModel().onCreate(toParameters(getIntent().getExtras()));
        observeViewModel();
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
