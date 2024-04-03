package com.talabat.userandlocation.login.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.compose.ui.text.input.ImeAction;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.designsystem.ds_dialog.DSDialog;
import com.designsystem.ds_dialog.DSDialogPrimaryAction;
import com.designsystem.ds_dialog.DSDialogPrimaryActionType;
import com.designsystem.ds_input_field.DSInputFieldState;
import com.designsystem.ds_input_field.DSPasswordField;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.localization.R;
import com.talabat.userandlocation.login.databinding.FragmentEnterPasswordBinding;
import com.talabat.userandlocation.login.di.factory.EnterPasswordViewModelFactory;
import com.talabat.userandlocation.login.presentation.displaymodel.EditFieldDisplayModel;
import com.talabat.userandlocation.login.presentation.viewmodel.EnterPasswordViewModel;
import ix.e;
import ix.f;
import ix.g;
import ix.h;
import ix.i;
import ix.j;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\rH\u0002J$\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010&\u001a\u00020\rH\u0002J\u0016\u0010'\u001a\u00020\r*\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018¨\u0006,"}, d2 = {"Lcom/talabat/userandlocation/login/ui/fragment/EnterPasswordFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/talabat/userandlocation/login/databinding/FragmentEnterPasswordBinding;", "factory", "Lcom/talabat/userandlocation/login/di/factory/EnterPasswordViewModelFactory;", "getFactory", "()Lcom/talabat/userandlocation/login/di/factory/EnterPasswordViewModelFactory;", "factory$delegate", "Lkotlin/Lazy;", "onBackButtonPressed", "Lkotlin/Function0;", "", "getOnBackButtonPressed", "()Lkotlin/jvm/functions/Function0;", "setOnBackButtonPressed", "(Lkotlin/jvm/functions/Function0;)V", "onLoginSuccess", "getOnLoginSuccess", "setOnLoginSuccess", "viewModel", "Lcom/talabat/userandlocation/login/presentation/viewmodel/EnterPasswordViewModel;", "getViewModel", "()Lcom/talabat/userandlocation/login/presentation/viewmodel/EnterPasswordViewModel;", "viewModel$delegate", "hideKeyboard", "view", "Landroid/view/View;", "observeViewModel", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "setupViews", "setError", "Lcom/designsystem/ds_input_field/DSPasswordField;", "message", "", "Companion", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EnterPasswordFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    private static final String ARGUMENT_EMAIL = "arg_email";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Trace _nr_trace;
    /* access modifiers changed from: private */
    public FragmentEnterPasswordBinding binding;
    @NotNull
    private final Lazy factory$delegate;
    @NotNull
    private Function0<Unit> onBackButtonPressed = EnterPasswordFragment$onBackButtonPressed$1.INSTANCE;
    @NotNull
    private Function0<Unit> onLoginSuccess = EnterPasswordFragment$onLoginSuccess$1.INSTANCE;
    @NotNull
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/userandlocation/login/ui/fragment/EnterPasswordFragment$Companion;", "", "()V", "ARGUMENT_EMAIL", "", "newInstance", "Lcom/talabat/userandlocation/login/ui/fragment/EnterPasswordFragment;", "email", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EnterPasswordFragment newInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "email");
            EnterPasswordFragment enterPasswordFragment = new EnterPasswordFragment();
            Bundle bundle = new Bundle();
            bundle.putString(EnterPasswordFragment.ARGUMENT_EMAIL, str);
            enterPasswordFragment.setArguments(bundle);
            return enterPasswordFragment;
        }
    }

    public EnterPasswordFragment() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.factory$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new EnterPasswordFragment$factory$2(this));
        EnterPasswordFragment$viewModel$2 enterPasswordFragment$viewModel$2 = new EnterPasswordFragment$viewModel$2(this);
        Lazy lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new EnterPasswordFragment$special$$inlined$viewModels$default$2(new EnterPasswordFragment$special$$inlined$viewModels$default$1(this)));
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(EnterPasswordViewModel.class), new EnterPasswordFragment$special$$inlined$viewModels$default$3(lazy), new EnterPasswordFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), enterPasswordFragment$viewModel$2);
    }

    /* access modifiers changed from: private */
    public final EnterPasswordViewModelFactory getFactory() {
        return (EnterPasswordViewModelFactory) this.factory$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EnterPasswordViewModel getViewModel() {
        return (EnterPasswordViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void hideKeyboard(View view) {
        InputMethodManager inputMethodManager;
        Object systemService = requireContext().getSystemService("input_method");
        if (systemService instanceof InputMethodManager) {
            inputMethodManager = (InputMethodManager) systemService;
        } else {
            inputMethodManager = null;
        }
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private final void observeViewModel() {
        getViewModel().getPassword().observe(getViewLifecycleOwner(), new e(this));
        getViewModel().getToastMessage().observe(getViewLifecycleOwner(), new f(this));
        getViewModel().getDialogMessage().observe(getViewLifecycleOwner(), new g(this));
        getViewModel().getEmailText().observe(getViewLifecycleOwner(), new h(this));
        getViewModel().getShowProgressDialog().observe(getViewLifecycleOwner(), new i(this));
        getViewModel().getExitScreenEvent().observe(getViewLifecycleOwner(), new j(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-3  reason: not valid java name */
    public static final void m5928observeViewModel$lambda3(EnterPasswordFragment enterPasswordFragment, EditFieldDisplayModel editFieldDisplayModel) {
        Intrinsics.checkNotNullParameter(enterPasswordFragment, "this$0");
        FragmentEnterPasswordBinding fragmentEnterPasswordBinding = null;
        if (editFieldDisplayModel instanceof EditFieldDisplayModel.MarkAsError) {
            FragmentEnterPasswordBinding fragmentEnterPasswordBinding2 = enterPasswordFragment.binding;
            if (fragmentEnterPasswordBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentEnterPasswordBinding = fragmentEnterPasswordBinding2;
            }
            DSPasswordField dSPasswordField = fragmentEnterPasswordBinding.edtPassword;
            Intrinsics.checkNotNullExpressionValue(dSPasswordField, "binding.edtPassword");
            enterPasswordFragment.setError(dSPasswordField, ((EditFieldDisplayModel.MarkAsError) editFieldDisplayModel).getMessage());
        } else if (editFieldDisplayModel instanceof EditFieldDisplayModel.Show) {
            FragmentEnterPasswordBinding fragmentEnterPasswordBinding3 = enterPasswordFragment.binding;
            if (fragmentEnterPasswordBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentEnterPasswordBinding3 = null;
            }
            DSPasswordField dSPasswordField2 = fragmentEnterPasswordBinding3.edtPassword;
            Intrinsics.checkNotNullExpressionValue(dSPasswordField2, "");
            enterPasswordFragment.setError(dSPasswordField2, (String) null);
            EditFieldDisplayModel.Show show = (EditFieldDisplayModel.Show) editFieldDisplayModel;
            dSPasswordField2.setText(show.getValue());
            dSPasswordField2.setEnabled(show.getEditable());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-4  reason: not valid java name */
    public static final void m5929observeViewModel$lambda4(EnterPasswordFragment enterPasswordFragment, String str) {
        Intrinsics.checkNotNullParameter(enterPasswordFragment, "this$0");
        Toast.makeText(enterPasswordFragment.requireContext(), str, 0).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-6  reason: not valid java name */
    public static final void m5930observeViewModel$lambda6(EnterPasswordFragment enterPasswordFragment, String str) {
        Intrinsics.checkNotNullParameter(enterPasswordFragment, "this$0");
        Context requireContext = enterPasswordFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        DSDialog dSDialog = new DSDialog(requireContext, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        dSDialog.setContent(str);
        String string = enterPasswordFragment.getString(R.string.close_dialog);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…on.R.string.close_dialog)");
        dSDialog.setPrimaryAction(new DSDialogPrimaryAction(string, new EnterPasswordFragment$observeViewModel$3$1$1(dSDialog), (DSDialogPrimaryActionType) null, 4, (DefaultConstructorMarker) null));
        FragmentEnterPasswordBinding fragmentEnterPasswordBinding = enterPasswordFragment.binding;
        if (fragmentEnterPasswordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentEnterPasswordBinding = null;
        }
        ConstraintLayout constraintLayout = fragmentEnterPasswordBinding.parentLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.parentLayout");
        dSDialog.show(constraintLayout);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-7  reason: not valid java name */
    public static final void m5931observeViewModel$lambda7(EnterPasswordFragment enterPasswordFragment, String str) {
        Intrinsics.checkNotNullParameter(enterPasswordFragment, "this$0");
        FragmentEnterPasswordBinding fragmentEnterPasswordBinding = enterPasswordFragment.binding;
        if (fragmentEnterPasswordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentEnterPasswordBinding = null;
        }
        fragmentEnterPasswordBinding.txtEmail.setText(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-8  reason: not valid java name */
    public static final void m5932observeViewModel$lambda8(EnterPasswordFragment enterPasswordFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(enterPasswordFragment, "this$0");
        FragmentEnterPasswordBinding fragmentEnterPasswordBinding = enterPasswordFragment.binding;
        if (fragmentEnterPasswordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentEnterPasswordBinding = null;
        }
        DSPrimaryButton dSPrimaryButton = fragmentEnterPasswordBinding.btnLogIn;
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        dSPrimaryButton.setLoading(bool.booleanValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-9  reason: not valid java name */
    public static final void m5933observeViewModel$lambda9(EnterPasswordFragment enterPasswordFragment, Unit unit) {
        Intrinsics.checkNotNullParameter(enterPasswordFragment, "this$0");
        enterPasswordFragment.onLoginSuccess.invoke();
    }

    /* access modifiers changed from: private */
    public final void setError(DSPasswordField dSPasswordField, String str) {
        DSInputFieldState dSInputFieldState;
        dSPasswordField.setHint(str);
        if (str == null) {
            dSInputFieldState = DSInputFieldState.Normal;
        } else {
            dSInputFieldState = DSInputFieldState.Error;
        }
        dSPasswordField.setState(dSInputFieldState);
    }

    private final void setupViews() {
        FragmentEnterPasswordBinding fragmentEnterPasswordBinding = this.binding;
        FragmentEnterPasswordBinding fragmentEnterPasswordBinding2 = null;
        if (fragmentEnterPasswordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentEnterPasswordBinding = null;
        }
        fragmentEnterPasswordBinding.btnLogIn.setOnTap(new EnterPasswordFragment$setupViews$1(this));
        FragmentEnterPasswordBinding fragmentEnterPasswordBinding3 = this.binding;
        if (fragmentEnterPasswordBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentEnterPasswordBinding3 = null;
        }
        fragmentEnterPasswordBinding3.txtForgotPassword.setOnTap(new EnterPasswordFragment$setupViews$2(this));
        FragmentEnterPasswordBinding fragmentEnterPasswordBinding4 = this.binding;
        if (fragmentEnterPasswordBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentEnterPasswordBinding4 = null;
        }
        fragmentEnterPasswordBinding4.headerView.setCloseButtonCallback(new EnterPasswordFragment$setupViews$3(this));
        FragmentEnterPasswordBinding fragmentEnterPasswordBinding5 = this.binding;
        if (fragmentEnterPasswordBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentEnterPasswordBinding2 = fragmentEnterPasswordBinding5;
        }
        DSPasswordField dSPasswordField = fragmentEnterPasswordBinding2.edtPassword;
        dSPasswordField.m8375setImeActionKlQnJC8(ImeAction.Companion.m5188getDoneeUduSuo());
        dSPasswordField.setOnTextChange(new EnterPasswordFragment$setupViews$4$1(this, dSPasswordField));
        dSPasswordField.setOnKeyboardReturnButtonTap(new EnterPasswordFragment$setupViews$4$2(this));
    }

    @NotNull
    public final Function0<Unit> getOnBackButtonPressed() {
        return this.onBackButtonPressed;
    }

    @NotNull
    public final Function0<Unit> getOnLoginSuccess() {
        return this.onLoginSuccess;
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentEnterPasswordBinding fragmentEnterPasswordBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "EnterPasswordFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "EnterPasswordFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentEnterPasswordBinding inflate = FragmentEnterPasswordBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "it");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentEnterPasswordBinding = inflate;
        }
        ConstraintLayout root = fragmentEnterPasswordBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        TraceMachine.exitMethod();
        return root;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setupViews();
        observeViewModel();
        EnterPasswordViewModel viewModel = getViewModel();
        Bundle arguments = getArguments();
        String str2 = "";
        if (arguments != null) {
            str = arguments.getString(ARGUMENT_EMAIL, str2);
        } else {
            str = null;
        }
        if (str != null) {
            str2 = str;
        }
        viewModel.onViewCreated(str2);
    }

    public final void setOnBackButtonPressed(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onBackButtonPressed = function0;
    }

    public final void setOnLoginSuccess(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onLoginSuccess = function0;
    }
}
