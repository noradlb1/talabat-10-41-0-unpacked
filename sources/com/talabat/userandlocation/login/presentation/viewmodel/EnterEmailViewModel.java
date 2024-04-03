package com.talabat.userandlocation.login.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.ui.lifecycle.SingleLiveEvent;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginEmailUseCase;
import com.talabat.userandlocation.login.presentation.displaymodel.EditFieldDisplayModel;
import com.talabat.userandlocation.login.presentation.provider.EnterEmailStringProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001&B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000eJ\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u000eH\u0002J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000eH\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/talabat/userandlocation/login/presentation/viewmodel/EnterEmailViewModel;", "Landroidx/lifecycle/ViewModel;", "enterEmailStringProvider", "Lcom/talabat/userandlocation/login/presentation/provider/EnterEmailStringProvider;", "verifyLoginEmailUseCase", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/userandlocation/login/presentation/provider/EnterEmailStringProvider;Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "_emailField", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/userandlocation/login/presentation/displaymodel/EditFieldDisplayModel;", "_moveToNextScreen", "Lcom/talabat/core/ui/lifecycle/SingleLiveEvent;", "", "_moveToRegistrationScreen", "_showProgressDialog", "", "emailField", "Landroidx/lifecycle/LiveData;", "getEmailField", "()Landroidx/lifecycle/LiveData;", "moveToNextScreen", "getMoveToNextScreen", "moveToRegistrationScreen", "getMoveToRegistrationScreen", "onErrorHandler", "Lkotlin/Function1;", "", "", "showProgressDialog", "getShowProgressDialog", "onNextButtonClicked", "Lkotlinx/coroutines/Job;", "email", "showEmailFieldError", "message", "showEmailFieldValue", "UnhandledViewModelError", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EnterEmailViewModel extends ViewModel {
    @NotNull
    private final MutableLiveData<EditFieldDisplayModel> _emailField;
    /* access modifiers changed from: private */
    @NotNull
    public final SingleLiveEvent<String> _moveToNextScreen;
    /* access modifiers changed from: private */
    @NotNull
    public final SingleLiveEvent<String> _moveToRegistrationScreen;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Boolean> _showProgressDialog;
    @NotNull
    private final LiveData<EditFieldDisplayModel> emailField;
    /* access modifiers changed from: private */
    @NotNull
    public final EnterEmailStringProvider enterEmailStringProvider;
    @NotNull
    private final LiveData<String> moveToNextScreen;
    @NotNull
    private final LiveData<String> moveToRegistrationScreen;
    /* access modifiers changed from: private */
    @NotNull
    public final IObservabilityManager observabilityManager;
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<Throwable, Unit> onErrorHandler = new EnterEmailViewModel$onErrorHandler$1(this);
    @NotNull
    private final LiveData<Boolean> showProgressDialog;
    /* access modifiers changed from: private */
    @NotNull
    public final VerifyLoginEmailUseCase verifyLoginEmailUseCase;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/userandlocation/login/presentation/viewmodel/EnterEmailViewModel$UnhandledViewModelError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UnhandledViewModelError extends Exception {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UnhandledViewModelError(@NotNull String str) {
            super(str);
            Intrinsics.checkNotNullParameter(str, "message");
        }
    }

    public EnterEmailViewModel(@NotNull EnterEmailStringProvider enterEmailStringProvider2, @NotNull VerifyLoginEmailUseCase verifyLoginEmailUseCase2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(enterEmailStringProvider2, "enterEmailStringProvider");
        Intrinsics.checkNotNullParameter(verifyLoginEmailUseCase2, "verifyLoginEmailUseCase");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.enterEmailStringProvider = enterEmailStringProvider2;
        this.verifyLoginEmailUseCase = verifyLoginEmailUseCase2;
        this.observabilityManager = iObservabilityManager;
        MutableLiveData<EditFieldDisplayModel> mutableLiveData = new MutableLiveData<>();
        this._emailField = mutableLiveData;
        this.emailField = mutableLiveData;
        SingleLiveEvent<String> singleLiveEvent = new SingleLiveEvent<>();
        this._moveToNextScreen = singleLiveEvent;
        this.moveToNextScreen = singleLiveEvent;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._showProgressDialog = mutableLiveData2;
        this.showProgressDialog = mutableLiveData2;
        SingleLiveEvent<String> singleLiveEvent2 = new SingleLiveEvent<>();
        this._moveToRegistrationScreen = singleLiveEvent2;
        this.moveToRegistrationScreen = singleLiveEvent2;
    }

    /* access modifiers changed from: private */
    public final void showEmailFieldError(String str) {
        this._emailField.postValue(new EditFieldDisplayModel.MarkAsError(str));
    }

    /* access modifiers changed from: private */
    public final void showEmailFieldValue(String str) {
        this._emailField.postValue(new EditFieldDisplayModel.Show(str, true));
    }

    @NotNull
    public final LiveData<EditFieldDisplayModel> getEmailField() {
        return this.emailField;
    }

    @NotNull
    public final LiveData<String> getMoveToNextScreen() {
        return this.moveToNextScreen;
    }

    @NotNull
    public final LiveData<String> getMoveToRegistrationScreen() {
        return this.moveToRegistrationScreen;
    }

    @NotNull
    public final LiveData<Boolean> getShowProgressDialog() {
        return this.showProgressDialog;
    }

    @NotNull
    public final Job onNextButtonClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "email");
        return CoroutinesKt.launchCatching$default(ViewModelKt.getViewModelScope(this), this.onErrorHandler, (CoroutineContext) null, new EnterEmailViewModel$onNextButtonClicked$1(this, str, (Continuation<? super EnterEmailViewModel$onNextButtonClicked$1>) null), 2, (Object) null);
    }
}
