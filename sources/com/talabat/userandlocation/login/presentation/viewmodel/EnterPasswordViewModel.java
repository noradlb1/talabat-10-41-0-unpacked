package com.talabat.userandlocation.login.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.ui.lifecycle.SingleLiveEvent;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase;
import com.talabat.userandlocation.login.presentation.displaymodel.EditFieldDisplayModel;
import com.talabat.userandlocation.login.presentation.provider.EnterPasswordStringProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)H\u0002J\u000e\u0010*\u001a\u00020+2\u0006\u0010 \u001a\u00020\u000bJ\u000e\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u000bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000f0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110\u0016¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u0016¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u000e\u0010&\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/talabat/userandlocation/login/presentation/viewmodel/EnterPasswordViewModel;", "Landroidx/lifecycle/ViewModel;", "enterPasswordStringProvider", "Lcom/talabat/userandlocation/login/presentation/provider/EnterPasswordStringProvider;", "verifyLoginPasswordUseCase", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/userandlocation/login/presentation/provider/EnterPasswordStringProvider;Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "_dialogMessage", "Landroidx/lifecycle/MutableLiveData;", "", "_emailText", "_exitScreenEvent", "Lcom/talabat/core/ui/lifecycle/SingleLiveEvent;", "", "_password", "Lcom/talabat/userandlocation/login/presentation/displaymodel/EditFieldDisplayModel;", "_showProgressDialog", "", "_toastMessage", "dialogMessage", "Landroidx/lifecycle/LiveData;", "getDialogMessage", "()Landroidx/lifecycle/LiveData;", "emailText", "getEmailText", "exitScreenEvent", "getExitScreenEvent", "onErrorHandler", "Lkotlin/Function1;", "", "password", "getPassword", "showProgressDialog", "getShowProgressDialog", "toastMessage", "getToastMessage", "userEmail", "handlePasswordVerificationResult", "verifyLoginPasswordResult", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result;", "onLogInClicked", "Lkotlinx/coroutines/Job;", "onViewCreated", "email", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EnterPasswordViewModel extends ViewModel {
    @NotNull
    private final MutableLiveData<String> _dialogMessage;
    @NotNull
    private final MutableLiveData<String> _emailText;
    @NotNull
    private final SingleLiveEvent<Unit> _exitScreenEvent;
    @NotNull
    private final MutableLiveData<EditFieldDisplayModel> _password;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Boolean> _showProgressDialog;
    @NotNull
    private final MutableLiveData<String> _toastMessage;
    @NotNull
    private final LiveData<String> dialogMessage;
    @NotNull
    private final LiveData<String> emailText;
    @NotNull
    private final EnterPasswordStringProvider enterPasswordStringProvider;
    @NotNull
    private final LiveData<Unit> exitScreenEvent;
    /* access modifiers changed from: private */
    @NotNull
    public final IObservabilityManager observabilityManager;
    @NotNull
    private final Function1<Throwable, Unit> onErrorHandler = new EnterPasswordViewModel$onErrorHandler$1(this);
    @NotNull
    private final LiveData<EditFieldDisplayModel> password;
    @NotNull
    private final LiveData<Boolean> showProgressDialog;
    @NotNull
    private final LiveData<String> toastMessage;
    /* access modifiers changed from: private */
    @NotNull
    public String userEmail = "";
    /* access modifiers changed from: private */
    @NotNull
    public final VerifyLoginPasswordUseCase verifyLoginPasswordUseCase;

    public EnterPasswordViewModel(@NotNull EnterPasswordStringProvider enterPasswordStringProvider2, @NotNull VerifyLoginPasswordUseCase verifyLoginPasswordUseCase2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(enterPasswordStringProvider2, "enterPasswordStringProvider");
        Intrinsics.checkNotNullParameter(verifyLoginPasswordUseCase2, "verifyLoginPasswordUseCase");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.enterPasswordStringProvider = enterPasswordStringProvider2;
        this.verifyLoginPasswordUseCase = verifyLoginPasswordUseCase2;
        this.observabilityManager = iObservabilityManager;
        SingleLiveEvent<Unit> singleLiveEvent = new SingleLiveEvent<>();
        this._exitScreenEvent = singleLiveEvent;
        this.exitScreenEvent = singleLiveEvent;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._showProgressDialog = mutableLiveData;
        this.showProgressDialog = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this._emailText = mutableLiveData2;
        this.emailText = mutableLiveData2;
        MutableLiveData<EditFieldDisplayModel> mutableLiveData3 = new MutableLiveData<>();
        this._password = mutableLiveData3;
        this.password = mutableLiveData3;
        MutableLiveData<String> mutableLiveData4 = new MutableLiveData<>();
        this._dialogMessage = mutableLiveData4;
        this.dialogMessage = mutableLiveData4;
        MutableLiveData<String> mutableLiveData5 = new MutableLiveData<>();
        this._toastMessage = mutableLiveData5;
        this.toastMessage = mutableLiveData5;
    }

    /* access modifiers changed from: private */
    public final void handlePasswordVerificationResult(VerifyLoginPasswordUseCase.Result result) {
        boolean z11;
        String str;
        if (Intrinsics.areEqual((Object) result, (Object) VerifyLoginPasswordUseCase.Result.PasswordIsEmpty.INSTANCE)) {
            this._password.postValue(new EditFieldDisplayModel.MarkAsError(this.enterPasswordStringProvider.getPasswordIsRequired()));
        } else if (Intrinsics.areEqual((Object) result, (Object) VerifyLoginPasswordUseCase.Result.PasswordLengthIsInvalid.INSTANCE)) {
            this._password.postValue(new EditFieldDisplayModel.MarkAsError(this.enterPasswordStringProvider.getPasswordLengthIsInvalid()));
        } else if (Intrinsics.areEqual((Object) result, (Object) VerifyLoginPasswordUseCase.Result.Success.INSTANCE)) {
            this._toastMessage.postValue(this.enterPasswordStringProvider.getLoginSuccessToastMessage());
            this._exitScreenEvent.postValue(Unit.INSTANCE);
        } else if (result instanceof VerifyLoginPasswordUseCase.Result.Error) {
            MutableLiveData<String> mutableLiveData = this._dialogMessage;
            VerifyLoginPasswordUseCase.Result.Error error = (VerifyLoginPasswordUseCase.Result.Error) result;
            if (error.getMessage().length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                str = this.enterPasswordStringProvider.getGenericErrorMessage();
            } else {
                str = error.getMessage();
            }
            mutableLiveData.postValue(str);
        } else if (Intrinsics.areEqual((Object) result, (Object) VerifyLoginPasswordUseCase.Result.InvalidCredentials.INSTANCE)) {
            this._dialogMessage.postValue(this.enterPasswordStringProvider.getInvalidCredentialsMessage());
        }
    }

    @NotNull
    public final LiveData<String> getDialogMessage() {
        return this.dialogMessage;
    }

    @NotNull
    public final LiveData<String> getEmailText() {
        return this.emailText;
    }

    @NotNull
    public final LiveData<Unit> getExitScreenEvent() {
        return this.exitScreenEvent;
    }

    @NotNull
    public final LiveData<EditFieldDisplayModel> getPassword() {
        return this.password;
    }

    @NotNull
    public final LiveData<Boolean> getShowProgressDialog() {
        return this.showProgressDialog;
    }

    @NotNull
    public final LiveData<String> getToastMessage() {
        return this.toastMessage;
    }

    @NotNull
    public final Job onLogInClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "password");
        return CoroutinesKt.launchCatching$default(ViewModelKt.getViewModelScope(this), this.onErrorHandler, (CoroutineContext) null, new EnterPasswordViewModel$onLogInClicked$1(this, str, (Continuation<? super EnterPasswordViewModel$onLogInClicked$1>) null), 2, (Object) null);
    }

    public final void onViewCreated(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "email");
        this.userEmail = str;
        this._emailText.postValue(str);
    }
}
