package com.talabat.userandlocation.login.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.designsystem.ds_input_field.DSInputFieldState;
import com.designsystem.ds_input_field.DSTextField;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.authentication.token.data.di.TokenCoreLibDataApi;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.helpers.GlobalConstants;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModelForResult;
import com.talabat.talabatnavigation.userandlocation.UserRegistrationActions;
import com.talabat.userandlocation.login.databinding.FragmentEnterEmailBinding;
import com.talabat.userandlocation.login.di.factory.EnterEmailViewModelFactory;
import com.talabat.userandlocation.login.presentation.displaymodel.EditFieldDisplayModel;
import com.talabat.userandlocation.login.presentation.viewmodel.EnterEmailViewModel;
import com.talabat.userandlocation.login.ui.fragment.di.DaggerEnterEmailFragmentComponent;
import ix.a;
import ix.b;
import ix.c;
import ix.d;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 I2\u00020\u0001:\u0001IB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u00100\u001a\u00020\u00112\b\u00101\u001a\u0004\u0018\u00010\rH\u0002J\b\u00102\u001a\u00020\u0011H\u0002J\"\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\b\u0010\u0010\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020:H\u0016J$\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u001a\u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020<2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010E\u001a\u00020\u0011H\u0002J\u0016\u0010F\u001a\u00020\u0011*\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR5\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00110\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001b\u0010+\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b/\u0010\n\u001a\u0004\b-\u0010.¨\u0006J"}, d2 = {"Lcom/talabat/userandlocation/login/ui/fragment/EnterEmailFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/talabat/userandlocation/login/databinding/FragmentEnterEmailBinding;", "factory", "Lcom/talabat/userandlocation/login/di/factory/EnterEmailViewModelFactory;", "getFactory", "()Lcom/talabat/userandlocation/login/di/factory/EnterEmailViewModelFactory;", "factory$delegate", "Lkotlin/Lazy;", "moveToNextListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "data", "", "getMoveToNextListener", "()Lkotlin/jvm/functions/Function1;", "setMoveToNextListener", "(Lkotlin/jvm/functions/Function1;)V", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "onBackButtonPressed", "Lkotlin/Function0;", "getOnBackButtonPressed", "()Lkotlin/jvm/functions/Function0;", "setOnBackButtonPressed", "(Lkotlin/jvm/functions/Function0;)V", "onSuccessResultFromUserRegistration", "getOnSuccessResultFromUserRegistration", "setOnSuccessResultFromUserRegistration", "tokenRepository", "Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "getTokenRepository", "()Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "setTokenRepository", "(Lcom/talabat/authentication/token/domain/repository/TokenRepository;)V", "viewModel", "Lcom/talabat/userandlocation/login/presentation/viewmodel/EnterEmailViewModel;", "getViewModel", "()Lcom/talabat/userandlocation/login/presentation/viewmodel/EnterEmailViewModel;", "viewModel$delegate", "navigateToRegistrationScreen", "it", "observeViewModel", "onActivityResult", "requestCode", "", "resultCode", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupViews", "setError", "Lcom/designsystem/ds_input_field/DSTextField;", "message", "Companion", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EnterEmailFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int REQUEST_CODE_REGISTRATION = 200;
    public Trace _nr_trace;
    /* access modifiers changed from: private */
    public FragmentEnterEmailBinding binding;
    @NotNull
    private final Lazy factory$delegate;
    @NotNull
    private Function1<? super String, Unit> moveToNextListener = EnterEmailFragment$moveToNextListener$1.INSTANCE;
    @Inject
    public IObservabilityManager observabilityManager;
    @NotNull
    private Function0<Unit> onBackButtonPressed = EnterEmailFragment$onBackButtonPressed$1.INSTANCE;
    @NotNull
    private Function0<Unit> onSuccessResultFromUserRegistration = EnterEmailFragment$onSuccessResultFromUserRegistration$1.INSTANCE;
    @Inject
    public TokenRepository tokenRepository;
    @NotNull
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/login/ui/fragment/EnterEmailFragment$Companion;", "", "()V", "REQUEST_CODE_REGISTRATION", "", "newInstance", "Lcom/talabat/userandlocation/login/ui/fragment/EnterEmailFragment;", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EnterEmailFragment newInstance() {
            return new EnterEmailFragment();
        }
    }

    public EnterEmailFragment() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.factory$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new EnterEmailFragment$factory$2(this));
        EnterEmailFragment$viewModel$2 enterEmailFragment$viewModel$2 = new EnterEmailFragment$viewModel$2(this);
        Lazy lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new EnterEmailFragment$special$$inlined$viewModels$default$2(new EnterEmailFragment$special$$inlined$viewModels$default$1(this)));
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(EnterEmailViewModel.class), new EnterEmailFragment$special$$inlined$viewModels$default$3(lazy), new EnterEmailFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), enterEmailFragment$viewModel$2);
    }

    /* access modifiers changed from: private */
    public final EnterEmailViewModelFactory getFactory() {
        return (EnterEmailViewModelFactory) this.factory$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EnterEmailViewModel getViewModel() {
        return (EnterEmailViewModel) this.viewModel$delegate.getValue();
    }

    private final void navigateToRegistrationScreen(String str) {
        Navigator.Companion companion = Navigator.Companion;
        NavigatorModelForResult createOpenScreenModelForResult = UserRegistrationActions.INSTANCE.createOpenScreenModelForResult(200);
        Bundle bundle = new Bundle();
        bundle.putString(GlobalConstants.ExtraNames.EMAIL_NOT_FOUND_REDIRECT, str);
        bundle.putBoolean("isFromProgressiveLogin", true);
        createOpenScreenModelForResult.setOptions(bundle);
        Unit unit = Unit.INSTANCE;
        companion.navigate((Fragment) this, createOpenScreenModelForResult);
    }

    private final void observeViewModel() {
        getViewModel().getEmailField().observe(getViewLifecycleOwner(), new a(this));
        getViewModel().getMoveToNextScreen().observe(getViewLifecycleOwner(), new b(this));
        getViewModel().getShowProgressDialog().observe(getViewLifecycleOwner(), new c(this));
        getViewModel().getMoveToRegistrationScreen().observe(getViewLifecycleOwner(), new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-3  reason: not valid java name */
    public static final void m5924observeViewModel$lambda3(EnterEmailFragment enterEmailFragment, EditFieldDisplayModel editFieldDisplayModel) {
        Intrinsics.checkNotNullParameter(enterEmailFragment, "this$0");
        FragmentEnterEmailBinding fragmentEnterEmailBinding = null;
        if (editFieldDisplayModel instanceof EditFieldDisplayModel.MarkAsError) {
            FragmentEnterEmailBinding fragmentEnterEmailBinding2 = enterEmailFragment.binding;
            if (fragmentEnterEmailBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentEnterEmailBinding = fragmentEnterEmailBinding2;
            }
            DSTextField dSTextField = fragmentEnterEmailBinding.edtEmail;
            Intrinsics.checkNotNullExpressionValue(dSTextField, "binding.edtEmail");
            enterEmailFragment.setError(dSTextField, ((EditFieldDisplayModel.MarkAsError) editFieldDisplayModel).getMessage());
        } else if (editFieldDisplayModel instanceof EditFieldDisplayModel.Show) {
            FragmentEnterEmailBinding fragmentEnterEmailBinding3 = enterEmailFragment.binding;
            if (fragmentEnterEmailBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentEnterEmailBinding3 = null;
            }
            DSTextField dSTextField2 = fragmentEnterEmailBinding3.edtEmail;
            Intrinsics.checkNotNullExpressionValue(dSTextField2, "");
            enterEmailFragment.setError(dSTextField2, (String) null);
            EditFieldDisplayModel.Show show = (EditFieldDisplayModel.Show) editFieldDisplayModel;
            dSTextField2.setText(show.getValue());
            dSTextField2.setEnabled(show.getEditable());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-4  reason: not valid java name */
    public static final void m5925observeViewModel$lambda4(EnterEmailFragment enterEmailFragment, String str) {
        Intrinsics.checkNotNullParameter(enterEmailFragment, "this$0");
        Function1<? super String, Unit> function1 = enterEmailFragment.moveToNextListener;
        Intrinsics.checkNotNullExpressionValue(str, "it");
        function1.invoke(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-5  reason: not valid java name */
    public static final void m5926observeViewModel$lambda5(EnterEmailFragment enterEmailFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(enterEmailFragment, "this$0");
        FragmentEnterEmailBinding fragmentEnterEmailBinding = enterEmailFragment.binding;
        if (fragmentEnterEmailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentEnterEmailBinding = null;
        }
        DSPrimaryButton dSPrimaryButton = fragmentEnterEmailBinding.btnNext;
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        dSPrimaryButton.setLoading(bool.booleanValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: observeViewModel$lambda-6  reason: not valid java name */
    public static final void m5927observeViewModel$lambda6(EnterEmailFragment enterEmailFragment, String str) {
        Intrinsics.checkNotNullParameter(enterEmailFragment, "this$0");
        enterEmailFragment.navigateToRegistrationScreen(str);
    }

    /* access modifiers changed from: private */
    public final void setError(DSTextField dSTextField, String str) {
        DSInputFieldState dSInputFieldState;
        dSTextField.setHint(str);
        if (str == null) {
            dSInputFieldState = DSInputFieldState.Normal;
        } else {
            dSInputFieldState = DSInputFieldState.Error;
        }
        dSTextField.setState(dSInputFieldState);
    }

    private final void setupViews() {
        FragmentEnterEmailBinding fragmentEnterEmailBinding = this.binding;
        FragmentEnterEmailBinding fragmentEnterEmailBinding2 = null;
        if (fragmentEnterEmailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentEnterEmailBinding = null;
        }
        fragmentEnterEmailBinding.btnNext.setOnTap(new EnterEmailFragment$setupViews$1(this));
        FragmentEnterEmailBinding fragmentEnterEmailBinding3 = this.binding;
        if (fragmentEnterEmailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentEnterEmailBinding3 = null;
        }
        fragmentEnterEmailBinding3.headerView.setCloseButtonCallback(this.onBackButtonPressed);
        FragmentEnterEmailBinding fragmentEnterEmailBinding4 = this.binding;
        if (fragmentEnterEmailBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentEnterEmailBinding2 = fragmentEnterEmailBinding4;
        }
        DSTextField dSTextField = fragmentEnterEmailBinding2.edtEmail;
        dSTextField.m8387setImeActionKlQnJC8(ImeAction.Companion.m5188getDoneeUduSuo());
        dSTextField.m8388setKeyboardTypek_Zsd0Q(KeyboardType.Companion.m5222getEmailPjHm6EE());
        dSTextField.setOnTextChange(new EnterEmailFragment$setupViews$2$1(this, dSTextField));
        dSTextField.setOnKeyboardReturnButtonTap(new EnterEmailFragment$setupViews$2$2(this));
    }

    @NotNull
    public final Function1<String, Unit> getMoveToNextListener() {
        return this.moveToNextListener;
    }

    @NotNull
    public final IObservabilityManager getObservabilityManager() {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        if (iObservabilityManager != null) {
            return iObservabilityManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observabilityManager");
        return null;
    }

    @NotNull
    public final Function0<Unit> getOnBackButtonPressed() {
        return this.onBackButtonPressed;
    }

    @NotNull
    public final Function0<Unit> getOnSuccessResultFromUserRegistration() {
        return this.onSuccessResultFromUserRegistration;
    }

    @NotNull
    public final TokenRepository getTokenRepository() {
        TokenRepository tokenRepository2 = this.tokenRepository;
        if (tokenRepository2 != null) {
            return tokenRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tokenRepository");
        return null;
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 != 200) {
            return;
        }
        if (i12 == -1) {
            this.onSuccessResultFromUserRegistration.invoke();
        } else {
            LogManager.info("User cancelled registration");
        }
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerEnterEmailFragmentComponent.factory().create((ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ObservabilityCoreLibApi.class), (TokenCoreLibDataApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(TokenCoreLibDataApi.class)).inject(this);
        super.onAttach(context);
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentEnterEmailBinding fragmentEnterEmailBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "EnterEmailFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "EnterEmailFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentEnterEmailBinding inflate = FragmentEnterEmailBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "it");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentEnterEmailBinding = inflate;
        }
        ConstraintLayout root = fragmentEnterEmailBinding.getRoot();
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
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setupViews();
        observeViewModel();
    }

    public final void setMoveToNextListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.moveToNextListener = function1;
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    public final void setOnBackButtonPressed(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onBackButtonPressed = function0;
    }

    public final void setOnSuccessResultFromUserRegistration(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onSuccessResultFromUserRegistration = function0;
    }

    public final void setTokenRepository(@NotNull TokenRepository tokenRepository2) {
        Intrinsics.checkNotNullParameter(tokenRepository2, "<set-?>");
        this.tokenRepository = tokenRepository2;
    }
}
