package com.talabat.userandlocation.compliance.verification.ui.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.compose.DialogNavigator;
import com.designsystem.ds_input_field.DateInputField;
import com.materialedittext.MaterialEditText;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.helpers.CustomDialog;
import com.talabat.helpers.GlobalConstants;
import com.talabat.talabatcommon.utils.PrivacyPolicyConsentTextBuilder;
import com.talabat.talabatcommon.views.MobileNumberEditText;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatToolBar;
import com.talabat.talabatcommon.views.TalabatToolBarImageButton;
import com.talabat.talabatcommon.views.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.fragments.FragmentInflater;
import com.talabat.talabatcommon.views.fragments.InflatableFragment;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.userandlocation.compliance.R;
import com.talabat.userandlocation.compliance.verification.di.DaggerUserVerificationFragmentComponent;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.ButtonDisplayModel;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.CheckBoxDisplayModel;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.DismissScreenModel;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.EditFieldDisplayModel;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.TitleDisplayModel;
import com.talabat.userandlocation.compliance.verification.presentation.viewmodel.UserVerificationViewModel;
import ex.a;
import ex.b;
import ex.c;
import ex.d;
import ex.e;
import ex.f;
import ex.g;
import ex.h;
import ex.i;
import ex.j;
import ex.k;
import ex.l;
import ex.m;
import ex.n;
import ex.o;
import ex.p;
import ex.q;
import ex.r;
import ex.s;
import ex.t;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0001QB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J@\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020$2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00150\u0013H\u0002J\b\u0010)\u001a\u00020\u0015H\u0002J\b\u0010*\u001a\u00020\u0015H\u0002J\u0012\u0010+\u001a\u00020\u00152\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u00020\u00152\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u0010,\u001a\u0004\u0018\u00010-H\u0001J\b\u00105\u001a\u00020\u0015H\u0002J\b\u00106\u001a\u00020\u0015H\u0002J\u0018\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\u0018\u0010<\u001a\u00020\u00152\u0006\u00108\u001a\u0002092\u0006\u0010=\u001a\u00020>H\u0002J\u0018\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J\f\u0010D\u001a\u00020\u0015*\u00020\u001bH\u0002J\f\u0010E\u001a\u00020\u0015*\u00020\u001bH\u0002J\f\u0010F\u001a\u00020\u0015*\u00020\u001bH\u0002J\f\u0010G\u001a\u00020\u0015*\u00020\u001bH\u0002J\f\u0010H\u001a\u00020\u0015*\u00020\u001bH\u0002J\f\u0010I\u001a\u00020\u0015*\u00020\u001bH\u0002J\f\u0010J\u001a\u00020\u0015*\u00020\u001bH\u0002J\f\u0010K\u001a\u00020\u0015*\u00020\u001bH\u0002J\f\u0010L\u001a\u00020\u0015*\u00020\u001bH\u0002J\f\u0010M\u001a\u00020\u0015*\u00020\u001bH\u0002J\f\u0010N\u001a\u00020O*\u00020PH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001c\u0010\u001d¨\u0006R"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/ui/fragment/UserVerificationFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/talabatcommon/views/fragments/InflatableFragment;", "()V", "dobDatePickerDialog", "Landroid/app/DatePickerDialog;", "progressDialog", "Lcom/talabat/helpers/CustomDialog;", "getProgressDialog", "()Lcom/talabat/helpers/CustomDialog;", "progressDialog$delegate", "Lkotlin/Lazy;", "termsAndConditionsConfigurationRepository", "Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;", "getTermsAndConditionsConfigurationRepository", "()Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;", "setTermsAndConditionsConfigurationRepository", "(Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;)V", "toolBarHandler", "Lkotlin/Function1;", "Landroidx/appcompat/widget/Toolbar;", "", "getToolBarHandler", "()Lkotlin/jvm/functions/Function1;", "setToolBarHandler", "(Lkotlin/jvm/functions/Function1;)V", "viewModel", "Lcom/talabat/userandlocation/compliance/verification/presentation/viewmodel/UserVerificationViewModel;", "getViewModel", "()Lcom/talabat/userandlocation/compliance/verification/presentation/viewmodel/UserVerificationViewModel;", "viewModel$delegate", "createDialog", "Landroidx/appcompat/app/AlertDialog;", "context", "Landroid/content/Context;", "title", "", "message", "positiveButtonText", "onPositiveButtonClick", "Landroid/content/DialogInterface;", "initDatePicker", "observeViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setupPrivacyAndTermsSpan", "setupViews", "showHideEditText", "model", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/EditFieldDisplayModel;", "editText", "Lcom/materialedittext/MaterialEditText;", "showHideMobileNumber", "mobileNumberEditText", "Lcom/talabat/talabatcommon/views/MobileNumberEditText;", "showPrivacyTermsConsent", "it", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/CheckBoxDisplayModel;", "privacyTermsContainer", "Landroid/widget/LinearLayout;", "observeConfirmationButton", "observeDismissScreen", "observeEditFields", "observeLoadingDialog", "observePrivacyTermsConsent", "observePromotionsConsent", "observeScreenTitle", "observeSecondaryTitle", "observeTitle", "observeValidationErrorDialogMessage", "toResult", "Lcom/talabat/userandlocation/compliance/verification/ui/fragment/ComplianceUserVerificationResult;", "Lcom/talabat/userandlocation/compliance/verification/ui/fragment/ComplianceUserVerificationExtras;", "Companion", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserVerificationFragment extends Fragment implements InflatableFragment, TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String EXTRA_KEY = "extras";
    private final /* synthetic */ FragmentInflater $$delegate_0;
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    public Trace _nr_trace;
    private DatePickerDialog dobDatePickerDialog;
    @NotNull
    private final Lazy progressDialog$delegate;
    @Inject
    public TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository;
    @NotNull
    private Function1<? super Toolbar, Unit> toolBarHandler;
    @NotNull
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/ui/fragment/UserVerificationFragment$Companion;", "", "()V", "EXTRA_KEY", "", "newInstance", "Lcom/talabat/userandlocation/compliance/verification/ui/fragment/UserVerificationFragment;", "complianceUserVerificationExtras", "Lcom/talabat/userandlocation/compliance/verification/ui/fragment/ComplianceUserVerificationExtras;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserVerificationFragment newInstance(@Nullable ComplianceUserVerificationExtras complianceUserVerificationExtras) {
            UserVerificationFragment userVerificationFragment = new UserVerificationFragment((DefaultConstructorMarker) null);
            Bundle bundle = new Bundle();
            bundle.putParcelable("extras", complianceUserVerificationExtras);
            userVerificationFragment.setArguments(bundle);
            return userVerificationFragment;
        }
    }

    private UserVerificationFragment() {
        this._$_findViewCache = new LinkedHashMap();
        this.$$delegate_0 = new FragmentInflater(R.layout.user_verification_fragment);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new UserVerificationFragment$viewModel$2(this));
        this.progressDialog$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new UserVerificationFragment$progressDialog$2(this));
        this.toolBarHandler = UserVerificationFragment$toolBarHandler$1.INSTANCE;
    }

    public /* synthetic */ UserVerificationFragment(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final AlertDialog createDialog(Context context, String str, String str2, String str3, Function1<? super DialogInterface, Unit> function1) {
        AlertDialog create = new AlertDialog.Builder(context, com.talabat.talabatcommon.R.style.AlertDialogTheme).setTitle((CharSequence) str).setMessage((CharSequence) str2).setPositiveButton((CharSequence) str3, (DialogInterface.OnClickListener) new o(function1)).create();
        Intrinsics.checkNotNullExpressionValue(create, "Builder(context, com.tal…alog) }\n        .create()");
        return create;
    }

    /* access modifiers changed from: private */
    /* renamed from: createDialog$lambda-3  reason: not valid java name */
    public static final void m5898createDialog$lambda3(Function1 function1, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(function1, "$onPositiveButtonClick");
        Intrinsics.checkNotNullExpressionValue(dialogInterface, DialogNavigator.NAME);
        function1.invoke(dialogInterface);
    }

    private final CustomDialog getProgressDialog() {
        return (CustomDialog) this.progressDialog$delegate.getValue();
    }

    private final UserVerificationViewModel getViewModel() {
        return (UserVerificationViewModel) this.viewModel$delegate.getValue();
    }

    private final void initDatePicker() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateInputField.DefaultDateFormat);
        Calendar instance = Calendar.getInstance();
        this.dobDatePickerDialog = new DatePickerDialog(requireContext(), new e(this, simpleDateFormat), instance.get(1) - 5, instance.get(2), instance.get(5));
        Calendar instance2 = Calendar.getInstance();
        instance2.set(instance.get(1) - 5, instance.get(2), instance.get(5));
        Date time = instance2.getTime();
        Calendar instance3 = Calendar.getInstance();
        instance3.set(instance.get(1) - 100, instance.get(2), instance.get(5));
        Date time2 = instance3.getTime();
        DatePickerDialog datePickerDialog = this.dobDatePickerDialog;
        if (datePickerDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dobDatePickerDialog");
            datePickerDialog = null;
        }
        datePickerDialog.getDatePicker().setMaxDate(time.getTime());
        DatePickerDialog datePickerDialog2 = this.dobDatePickerDialog;
        if (datePickerDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dobDatePickerDialog");
            datePickerDialog2 = null;
        }
        datePickerDialog2.getDatePicker().setMinDate(time2.getTime());
        DatePickerDialog datePickerDialog3 = this.dobDatePickerDialog;
        if (datePickerDialog3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dobDatePickerDialog");
            datePickerDialog3 = null;
        }
        datePickerDialog3.getDatePicker().init(instance.get(1) - 5, instance.get(2), instance.get(5), (DatePicker.OnDateChangedListener) null);
        ((FrameLayout) _$_findCachedViewById(R.id.date_container)).setOnClickListener(new f(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initDatePicker$lambda-27  reason: not valid java name */
    public static final void m5899initDatePicker$lambda27(UserVerificationFragment userVerificationFragment, SimpleDateFormat simpleDateFormat, DatePicker datePicker, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(userVerificationFragment, "this$0");
        Intrinsics.checkNotNullParameter(simpleDateFormat, "$dateFormatter");
        Calendar instance = Calendar.getInstance();
        instance.set(i11, i12, i13);
        int i14 = R.id.edtDateOfBirth;
        ((MaterialEditText) userVerificationFragment._$_findCachedViewById(i14)).setText(simpleDateFormat.format(instance.getTime()));
        try {
            Object systemService = userVerificationFragment.requireContext().getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(((MaterialEditText) userVerificationFragment._$_findCachedViewById(i14)).getWindowToken(), 0);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initDatePicker$lambda-28  reason: not valid java name */
    public static final void m5900initDatePicker$lambda28(UserVerificationFragment userVerificationFragment, View view) {
        Intrinsics.checkNotNullParameter(userVerificationFragment, "this$0");
        DatePickerDialog datePickerDialog = userVerificationFragment.dobDatePickerDialog;
        if (datePickerDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dobDatePickerDialog");
            datePickerDialog = null;
        }
        datePickerDialog.show();
    }

    private final void observeConfirmationButton(UserVerificationViewModel userVerificationViewModel) {
        userVerificationViewModel.getConfirmationButton().observe(getViewLifecycleOwner(), new q(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeConfirmationButton$lambda-13  reason: not valid java name */
    public static final void m5901observeConfirmationButton$lambda13(UserVerificationFragment userVerificationFragment, ButtonDisplayModel buttonDisplayModel) {
        Intrinsics.checkNotNullParameter(userVerificationFragment, "this$0");
        if (buttonDisplayModel instanceof ButtonDisplayModel.Show) {
            ((TalabatFillButton) userVerificationFragment._$_findCachedViewById(R.id.btnCreateAccount)).setText(((ButtonDisplayModel.Show) buttonDisplayModel).getText());
        }
    }

    private final void observeDismissScreen(UserVerificationViewModel userVerificationViewModel) {
        userVerificationViewModel.getDismissScreen().observe(getViewLifecycleOwner(), new m(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeDismissScreen$lambda-18  reason: not valid java name */
    public static final void m5902observeDismissScreen$lambda18(UserVerificationFragment userVerificationFragment, DismissScreenModel dismissScreenModel) {
        Intrinsics.checkNotNullParameter(userVerificationFragment, "this$0");
        if (dismissScreenModel instanceof DismissScreenModel.WithCancelResult) {
            FragmentActivity requireActivity = userVerificationFragment.requireActivity();
            Intent intent = new Intent();
            intent.putExtra("result", userVerificationFragment.toResult(((DismissScreenModel.WithCancelResult) dismissScreenModel).getExtras()));
            Unit unit = Unit.INSTANCE;
            requireActivity.setResult(0, intent);
            requireActivity.finish();
        } else if (dismissScreenModel instanceof DismissScreenModel.WithSuccessResult) {
            FragmentActivity requireActivity2 = userVerificationFragment.requireActivity();
            Intent intent2 = new Intent();
            intent2.putExtra("result", ((DismissScreenModel.WithSuccessResult) dismissScreenModel).getResult());
            Unit unit2 = Unit.INSTANCE;
            requireActivity2.setResult(-1, intent2);
            requireActivity2.finish();
        }
    }

    private final void observeEditFields(UserVerificationViewModel userVerificationViewModel) {
        userVerificationViewModel.getFirstName().observe(getViewLifecycleOwner(), new r(this));
        userVerificationViewModel.getMiddleLastName().observe(getViewLifecycleOwner(), new s(this));
        userVerificationViewModel.getDateOfBirth().observe(getViewLifecycleOwner(), new t(this));
        userVerificationViewModel.getEmail().observe(getViewLifecycleOwner(), new b(this));
        userVerificationViewModel.getMobileNumber().observe(getViewLifecycleOwner(), new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeEditFields$lambda-4  reason: not valid java name */
    public static final void m5903observeEditFields$lambda4(UserVerificationFragment userVerificationFragment, EditFieldDisplayModel editFieldDisplayModel) {
        Intrinsics.checkNotNullParameter(userVerificationFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(editFieldDisplayModel, "it");
        MaterialEditText materialEditText = (MaterialEditText) userVerificationFragment._$_findCachedViewById(R.id.edtFirstName);
        Intrinsics.checkNotNullExpressionValue(materialEditText, "edtFirstName");
        userVerificationFragment.showHideEditText(editFieldDisplayModel, materialEditText);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeEditFields$lambda-5  reason: not valid java name */
    public static final void m5904observeEditFields$lambda5(UserVerificationFragment userVerificationFragment, EditFieldDisplayModel editFieldDisplayModel) {
        Intrinsics.checkNotNullParameter(userVerificationFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(editFieldDisplayModel, "it");
        MaterialEditText materialEditText = (MaterialEditText) userVerificationFragment._$_findCachedViewById(R.id.edtLastName);
        Intrinsics.checkNotNullExpressionValue(materialEditText, "edtLastName");
        userVerificationFragment.showHideEditText(editFieldDisplayModel, materialEditText);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeEditFields$lambda-6  reason: not valid java name */
    public static final void m5905observeEditFields$lambda6(UserVerificationFragment userVerificationFragment, EditFieldDisplayModel editFieldDisplayModel) {
        Intrinsics.checkNotNullParameter(userVerificationFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(editFieldDisplayModel, "it");
        MaterialEditText materialEditText = (MaterialEditText) userVerificationFragment._$_findCachedViewById(R.id.edtDateOfBirth);
        Intrinsics.checkNotNullExpressionValue(materialEditText, "edtDateOfBirth");
        userVerificationFragment.showHideEditText(editFieldDisplayModel, materialEditText);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeEditFields$lambda-7  reason: not valid java name */
    public static final void m5906observeEditFields$lambda7(UserVerificationFragment userVerificationFragment, EditFieldDisplayModel editFieldDisplayModel) {
        Intrinsics.checkNotNullParameter(userVerificationFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(editFieldDisplayModel, "it");
        MaterialEditText materialEditText = (MaterialEditText) userVerificationFragment._$_findCachedViewById(R.id.edtEmail);
        Intrinsics.checkNotNullExpressionValue(materialEditText, "edtEmail");
        userVerificationFragment.showHideEditText(editFieldDisplayModel, materialEditText);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeEditFields$lambda-8  reason: not valid java name */
    public static final void m5907observeEditFields$lambda8(UserVerificationFragment userVerificationFragment, EditFieldDisplayModel editFieldDisplayModel) {
        Intrinsics.checkNotNullParameter(userVerificationFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(editFieldDisplayModel, "it");
        MobileNumberEditText mobileNumberEditText = (MobileNumberEditText) userVerificationFragment._$_findCachedViewById(R.id.edtMobileNumber);
        Intrinsics.checkNotNullExpressionValue(mobileNumberEditText, "edtMobileNumber");
        userVerificationFragment.showHideMobileNumber(editFieldDisplayModel, mobileNumberEditText);
    }

    private final void observeLoadingDialog(UserVerificationViewModel userVerificationViewModel) {
        userVerificationViewModel.getShowLoadingDialog().observe(getViewLifecycleOwner(), new k(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeLoadingDialog$lambda-1  reason: not valid java name */
    public static final void m5908observeLoadingDialog$lambda1(UserVerificationFragment userVerificationFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(userVerificationFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "show");
        boolean booleanValue = bool.booleanValue();
        CustomDialog progressDialog = userVerificationFragment.getProgressDialog();
        if (booleanValue) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    private final void observePrivacyTermsConsent(UserVerificationViewModel userVerificationViewModel) {
        userVerificationViewModel.getPrivacyTermsConsent().observe(getViewLifecycleOwner(), new g(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observePrivacyTermsConsent$lambda-9  reason: not valid java name */
    public static final void m5909observePrivacyTermsConsent$lambda9(UserVerificationFragment userVerificationFragment, CheckBoxDisplayModel checkBoxDisplayModel) {
        Intrinsics.checkNotNullParameter(userVerificationFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(checkBoxDisplayModel, "it");
        LinearLayout linearLayout = (LinearLayout) userVerificationFragment._$_findCachedViewById(R.id.privacyTermsContainer);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "privacyTermsContainer");
        userVerificationFragment.showPrivacyTermsConsent(checkBoxDisplayModel, linearLayout);
    }

    private final void observePromotionsConsent(UserVerificationViewModel userVerificationViewModel) {
        userVerificationViewModel.getPromotionConsent().observe(getViewLifecycleOwner(), new n(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observePromotionsConsent$lambda-10  reason: not valid java name */
    public static final void m5910observePromotionsConsent$lambda10(UserVerificationFragment userVerificationFragment, CheckBoxDisplayModel checkBoxDisplayModel) {
        Intrinsics.checkNotNullParameter(userVerificationFragment, "this$0");
        if (checkBoxDisplayModel instanceof CheckBoxDisplayModel.DontShow) {
            ((LinearLayout) userVerificationFragment._$_findCachedViewById(R.id.promotionNewsletterContainer)).setVisibility(8);
        }
    }

    private final void observeScreenTitle(UserVerificationViewModel userVerificationViewModel) {
        userVerificationViewModel.getScreenTitle().observe(getViewLifecycleOwner(), new p(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeScreenTitle$lambda-19  reason: not valid java name */
    public static final void m5911observeScreenTitle$lambda19(UserVerificationFragment userVerificationFragment, TitleDisplayModel titleDisplayModel) {
        Intrinsics.checkNotNullParameter(userVerificationFragment, "this$0");
        if (Intrinsics.areEqual((Object) titleDisplayModel, (Object) TitleDisplayModel.DontShow.INSTANCE)) {
            ((TalabatToolBarTextView) userVerificationFragment._$_findCachedViewById(R.id.toolbarTitle)).setVisibility(8);
        } else if (titleDisplayModel instanceof TitleDisplayModel.Show) {
            int i11 = R.id.toolbarTitle;
            ((TalabatToolBarTextView) userVerificationFragment._$_findCachedViewById(i11)).setVisibility(0);
            ((TalabatToolBarTextView) userVerificationFragment._$_findCachedViewById(i11)).setText(((TitleDisplayModel.Show) titleDisplayModel).getText());
        }
    }

    private final void observeSecondaryTitle(UserVerificationViewModel userVerificationViewModel) {
        userVerificationViewModel.getSecondaryTitle().observe(getViewLifecycleOwner(), new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeSecondaryTitle$lambda-12  reason: not valid java name */
    public static final void m5912observeSecondaryTitle$lambda12(UserVerificationFragment userVerificationFragment, TitleDisplayModel titleDisplayModel) {
        Intrinsics.checkNotNullParameter(userVerificationFragment, "this$0");
        if (Intrinsics.areEqual((Object) titleDisplayModel, (Object) TitleDisplayModel.DontShow.INSTANCE)) {
            ((TalabatTextView) userVerificationFragment._$_findCachedViewById(R.id.txtSecondaryTitle)).setVisibility(8);
        } else if (titleDisplayModel instanceof TitleDisplayModel.Show) {
            int i11 = R.id.txtSecondaryTitle;
            ((TalabatTextView) userVerificationFragment._$_findCachedViewById(i11)).setText(((TitleDisplayModel.Show) titleDisplayModel).getText());
            ((TalabatTextView) userVerificationFragment._$_findCachedViewById(i11)).setVisibility(0);
        }
    }

    private final void observeTitle(UserVerificationViewModel userVerificationViewModel) {
        userVerificationViewModel.getTitle().observe(getViewLifecycleOwner(), new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeTitle$lambda-11  reason: not valid java name */
    public static final void m5913observeTitle$lambda11(UserVerificationFragment userVerificationFragment, TitleDisplayModel titleDisplayModel) {
        Intrinsics.checkNotNullParameter(userVerificationFragment, "this$0");
        if (Intrinsics.areEqual((Object) titleDisplayModel, (Object) TitleDisplayModel.DontShow.INSTANCE)) {
            ((TalabatTextView) userVerificationFragment._$_findCachedViewById(R.id.txtTitle)).setVisibility(8);
        } else if (titleDisplayModel instanceof TitleDisplayModel.Show) {
            int i11 = R.id.txtTitle;
            ((TalabatTextView) userVerificationFragment._$_findCachedViewById(i11)).setText(((TitleDisplayModel.Show) titleDisplayModel).getText());
            ((TalabatTextView) userVerificationFragment._$_findCachedViewById(i11)).setVisibility(0);
        }
    }

    private final void observeValidationErrorDialogMessage(UserVerificationViewModel userVerificationViewModel) {
        userVerificationViewModel.getValidationErrorDialogMessage().observe(getViewLifecycleOwner(), new l(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeValidationErrorDialogMessage$lambda-2  reason: not valid java name */
    public static final void m5914observeValidationErrorDialogMessage$lambda2(UserVerificationFragment userVerificationFragment, String str) {
        Intrinsics.checkNotNullParameter(userVerificationFragment, "this$0");
        Context requireContext = userVerificationFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Intrinsics.checkNotNullExpressionValue(str, "message");
        u(userVerificationFragment, requireContext, (String) null, str, (String) null, UserVerificationFragment$observeValidationErrorDialogMessage$1$1.INSTANCE, 10, (Object) null).show();
    }

    private final void observeViewModel() {
        UserVerificationViewModel viewModel = getViewModel();
        observePrivacyTermsConsent(viewModel);
        observePromotionsConsent(viewModel);
        observeScreenTitle(viewModel);
        observeTitle(viewModel);
        observeSecondaryTitle(viewModel);
        observeEditFields(viewModel);
        observeConfirmationButton(viewModel);
        observeDismissScreen(viewModel);
        observeValidationErrorDialogMessage(viewModel);
        observeLoadingDialog(viewModel);
    }

    private final void setupPrivacyAndTermsSpan() {
        int i11 = R.id.privacyTermsTextView;
        PrivacyPolicyConsentTextBuilder privacyPolicyConsentTextBuilder = PrivacyPolicyConsentTextBuilder.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ((TalabatTextView) _$_findCachedViewById(i11)).setText(privacyPolicyConsentTextBuilder.createPrivacyPolicyConsentText(requireContext, getTermsAndConditionsConfigurationRepository().config()));
        ((TalabatTextView) _$_findCachedViewById(i11)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final void setupViews() {
        Function1<? super Toolbar, Unit> function1 = this.toolBarHandler;
        TalabatToolBar talabatToolBar = (TalabatToolBar) _$_findCachedViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(talabatToolBar, "toolbar");
        function1.invoke(talabatToolBar);
        ((TalabatFillButton) _$_findCachedViewById(R.id.btnCreateAccount)).setOnClickListener(new h(this));
        initDatePicker();
        setupPrivacyAndTermsSpan();
        ((TalabatToolBarImageButton) _$_findCachedViewById(R.id.back)).setOnClickListener(new i(this));
        ((CheckBox) _$_findCachedViewById(R.id.privacyTermsConsent)).setOnCheckedChangeListener(new j());
    }

    /* access modifiers changed from: private */
    /* renamed from: setupViews$lambda-24  reason: not valid java name */
    public static final void m5915setupViews$lambda24(UserVerificationFragment userVerificationFragment, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        String obj;
        String obj2;
        String obj3;
        String obj4;
        Intrinsics.checkNotNullParameter(userVerificationFragment, "this$0");
        UserVerificationViewModel viewModel = userVerificationFragment.getViewModel();
        Editable text = ((MaterialEditText) userVerificationFragment._$_findCachedViewById(R.id.edtFirstName)).getText();
        if (text == null || (obj4 = text.toString()) == null) {
            str = "";
        } else {
            str = obj4;
        }
        Editable text2 = ((MaterialEditText) userVerificationFragment._$_findCachedViewById(R.id.edtLastName)).getText();
        if (text2 == null || (obj3 = text2.toString()) == null) {
            str2 = "";
        } else {
            str2 = obj3;
        }
        Editable text3 = ((MaterialEditText) userVerificationFragment._$_findCachedViewById(R.id.edtDateOfBirth)).getText();
        if (text3 == null || (obj2 = text3.toString()) == null) {
            str3 = "";
        } else {
            str3 = obj2;
        }
        Editable text4 = ((MaterialEditText) userVerificationFragment._$_findCachedViewById(R.id.edtEmail)).getText();
        if (text4 == null || (obj = text4.toString()) == null) {
            str4 = "";
        } else {
            str4 = obj;
        }
        viewModel.onCreateAccountClicked(new UserVerificationViewModel.Data(str, str2, str3, str4, ((CheckBox) userVerificationFragment._$_findCachedViewById(R.id.privacyTermsConsent)).isChecked(), ((CheckBox) userVerificationFragment._$_findCachedViewById(R.id.promotionNewsletterConsent)).isChecked()));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupViews$lambda-25  reason: not valid java name */
    public static final void m5916setupViews$lambda25(UserVerificationFragment userVerificationFragment, View view) {
        Intrinsics.checkNotNullParameter(userVerificationFragment, "this$0");
        userVerificationFragment.getViewModel().onBackClicked();
    }

    /* access modifiers changed from: private */
    /* renamed from: setupViews$lambda-26  reason: not valid java name */
    public static final void m5917setupViews$lambda26(CompoundButton compoundButton, boolean z11) {
        compoundButton.setError((CharSequence) null);
    }

    private final void showHideEditText(EditFieldDisplayModel editFieldDisplayModel, MaterialEditText materialEditText) {
        if (Intrinsics.areEqual((Object) editFieldDisplayModel, (Object) EditFieldDisplayModel.DontShow.INSTANCE)) {
            materialEditText.setVisibility(8);
        } else if (editFieldDisplayModel instanceof EditFieldDisplayModel.Show) {
            EditFieldDisplayModel.Show show = (EditFieldDisplayModel.Show) editFieldDisplayModel;
            materialEditText.setText(show.getValue());
            materialEditText.setEnabled(show.getEditable());
            materialEditText.setError((CharSequence) null);
        } else if (editFieldDisplayModel instanceof EditFieldDisplayModel.MarkAsError) {
            materialEditText.setErrorColor(ContextCompat.getColor(requireContext(), com.talabat.talabatcommon.R.color.edit_text_error));
            materialEditText.setError(((EditFieldDisplayModel.MarkAsError) editFieldDisplayModel).getMessage());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void showHideMobileNumber(EditFieldDisplayModel editFieldDisplayModel, MobileNumberEditText mobileNumberEditText) {
        if (Intrinsics.areEqual((Object) editFieldDisplayModel, (Object) EditFieldDisplayModel.DontShow.INSTANCE)) {
            mobileNumberEditText.setVisibility(8);
        } else if (editFieldDisplayModel instanceof EditFieldDisplayModel.Show) {
            mobileNumberEditText.setCountryCode(GlobalConstants.IRAQ_COUNTRY_CODE);
            EditFieldDisplayModel.Show show = (EditFieldDisplayModel.Show) editFieldDisplayModel;
            mobileNumberEditText.setText(show.getValue());
            mobileNumberEditText.setEnabled(show.getEditable());
            mobileNumberEditText.setError((CharSequence) null);
            mobileNumberEditText.setVisibility(0);
        } else if (editFieldDisplayModel instanceof EditFieldDisplayModel.MarkAsError) {
            mobileNumberEditText.setErrorColor(ContextCompat.getColor(requireContext(), com.talabat.talabatcommon.R.color.edit_text_error));
            mobileNumberEditText.setError(((EditFieldDisplayModel.MarkAsError) editFieldDisplayModel).getMessage());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void showPrivacyTermsConsent(CheckBoxDisplayModel checkBoxDisplayModel, LinearLayout linearLayout) {
        if (Intrinsics.areEqual((Object) checkBoxDisplayModel, (Object) CheckBoxDisplayModel.DontShow.INSTANCE)) {
            linearLayout.setVisibility(8);
        } else if (checkBoxDisplayModel instanceof CheckBoxDisplayModel.Show) {
            linearLayout.setVisibility(8);
            ((CheckBox) _$_findCachedViewById(R.id.privacyTermsConsent)).setError((CharSequence) null);
        } else if (Intrinsics.areEqual((Object) checkBoxDisplayModel, (Object) CheckBoxDisplayModel.MarkAsError.INSTANCE)) {
            Toast.makeText(requireContext(), com.talabat.localization.R.string.consent_validation_error, 1).show();
        }
    }

    private final ComplianceUserVerificationResult toResult(ComplianceUserVerificationExtras complianceUserVerificationExtras) {
        return new ComplianceUserVerificationResult(complianceUserVerificationExtras.getFirstName(), complianceUserVerificationExtras.getLastName(), complianceUserVerificationExtras.getDateOfBirth(), complianceUserVerificationExtras.getEmail(), false);
    }

    public static /* synthetic */ AlertDialog u(UserVerificationFragment userVerificationFragment, Context context, String str, String str2, String str3, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = context.getString(com.talabat.localization.R.string.we_couldnt_validate_your_details);
            Intrinsics.checkNotNullExpressionValue(str, "context.getString(com.ta…nt_validate_your_details)");
        }
        String str4 = str;
        if ((i11 & 8) != 0) {
            str3 = context.getString(com.talabat.localization.R.string.try_again);
            Intrinsics.checkNotNullExpressionValue(str3, "context.getString(com.ta…ation.R.string.try_again)");
        }
        return userVerificationFragment.createDialog(context, str4, str2, str3, function1);
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

    @NotNull
    public final TermsAndConditionsConfigurationRepository getTermsAndConditionsConfigurationRepository() {
        TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository2 = this.termsAndConditionsConfigurationRepository;
        if (termsAndConditionsConfigurationRepository2 != null) {
            return termsAndConditionsConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("termsAndConditionsConfigurationRepository");
        return null;
    }

    @NotNull
    public final Function1<Toolbar, Unit> getToolBarHandler() {
        return this.toolBarHandler;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        ComplianceUserVerificationExtras complianceUserVerificationExtras;
        super.onActivityCreated(bundle);
        setupViews();
        observeViewModel();
        UserVerificationViewModel viewModel = getViewModel();
        Bundle arguments = getArguments();
        if (arguments != null) {
            complianceUserVerificationExtras = (ComplianceUserVerificationExtras) arguments.getParcelable("extras");
        } else {
            complianceUserVerificationExtras = null;
        }
        if (complianceUserVerificationExtras != null) {
            viewModel.onCreated(complianceUserVerificationExtras);
            return;
        }
        String simpleName = Reflection.getOrCreateKotlinClass(ComplianceUserVerificationExtras.class).getSimpleName();
        throw new Exception("name = extras not found! Please provide an instance of " + simpleName);
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("UserVerificationFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "UserVerificationFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "UserVerificationFragment#onCreate", (ArrayList<String>) null);
        }
        DaggerUserVerificationFragmentComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        TraceMachine.exitMethod();
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "UserVerificationFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "UserVerificationFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View onCreateView = this.$$delegate_0.onCreateView(layoutInflater, viewGroup, bundle);
        TraceMachine.exitMethod();
        return onCreateView;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public final void setTermsAndConditionsConfigurationRepository(@NotNull TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(termsAndConditionsConfigurationRepository2, "<set-?>");
        this.termsAndConditionsConfigurationRepository = termsAndConditionsConfigurationRepository2;
    }

    public final void setToolBarHandler(@NotNull Function1<? super Toolbar, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.toolBarHandler = function1;
    }
}
