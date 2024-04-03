package library.talabat.mvp.login.impl;

import com.talabat.talabatcore.logger.LogManager;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.extensions.DisposableKt;
import library.talabat.mvp.login.LoginPresenter2;
import library.talabat.mvp.login.LoginView;
import library.talabat.mvp.login.domain.usecases.LoginUseCases;
import library.talabat.mvp.login.domain.usecases.SelectSavedAddressIfCanDeliverToVendorUseCase;
import library.talabat.mvp.login.experiments.LoginExperimentProvider;
import org.jetbrains.annotations.NotNull;
import s10.a;
import s10.b;
import s10.c;
import s10.d;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Llibrary/talabat/mvp/login/impl/LoginPresenter2Impl;", "Llibrary/talabat/mvp/login/LoginPresenter2;", "loginExperimentProvider", "Llibrary/talabat/mvp/login/experiments/LoginExperimentProvider;", "loginView", "Llibrary/talabat/mvp/login/LoginView;", "loginUseCases", "Llibrary/talabat/mvp/login/domain/usecases/LoginUseCases;", "ioScheduler", "Lio/reactivex/Scheduler;", "mainScheduler", "(Llibrary/talabat/mvp/login/experiments/LoginExperimentProvider;Llibrary/talabat/mvp/login/LoginView;Llibrary/talabat/mvp/login/domain/usecases/LoginUseCases;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "onDestroy", "", "onLoggedInFromCartScreen", "onRedirectToHomeScreen", "onSnapToExistingAddressSuccess", "result", "Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase$Result;", "selectSavedAddressIfPossible", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoginPresenter2Impl implements LoginPresenter2 {
    @NotNull
    private final CompositeDisposable compositeDisposable;
    @NotNull
    private final Scheduler ioScheduler;
    @NotNull
    private final LoginExperimentProvider loginExperimentProvider;
    @NotNull
    private final LoginUseCases loginUseCases;
    @NotNull
    private final LoginView loginView;
    @NotNull
    private final Scheduler mainScheduler;

    public LoginPresenter2Impl(@NotNull LoginExperimentProvider loginExperimentProvider2, @NotNull LoginView loginView2, @NotNull LoginUseCases loginUseCases2, @NotNull Scheduler scheduler, @NotNull Scheduler scheduler2) {
        Intrinsics.checkNotNullParameter(loginExperimentProvider2, "loginExperimentProvider");
        Intrinsics.checkNotNullParameter(loginView2, "loginView");
        Intrinsics.checkNotNullParameter(loginUseCases2, "loginUseCases");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        Intrinsics.checkNotNullParameter(scheduler2, "mainScheduler");
        this.loginExperimentProvider = loginExperimentProvider2;
        this.loginView = loginView2;
        this.loginUseCases = loginUseCases2;
        this.ioScheduler = scheduler;
        this.mainScheduler = scheduler2;
        this.compositeDisposable = new CompositeDisposable();
    }

    /* access modifiers changed from: private */
    public final void onSnapToExistingAddressSuccess(SelectSavedAddressIfCanDeliverToVendorUseCase.Result result) {
        boolean z11;
        this.loginView.stopLodingPopup();
        if (Intrinsics.areEqual((Object) result, (Object) SelectSavedAddressIfCanDeliverToVendorUseCase.Result.Successful.INSTANCE)) {
            z11 = true;
        } else {
            z11 = result instanceof SelectSavedAddressIfCanDeliverToVendorUseCase.Result.Failed;
        }
        if (z11) {
            this.loginView.finishWithResultOK();
        } else if (Intrinsics.areEqual((Object) result, (Object) SelectSavedAddressIfCanDeliverToVendorUseCase.Result.ShouldSelectAddressManually.INSTANCE)) {
            this.loginView.finishWithResultGoToAddressList();
        }
    }

    private final void selectSavedAddressIfPossible() {
        CompositeDisposable compositeDisposable2 = this.compositeDisposable;
        Disposable subscribe = this.loginUseCases.selectSavedAddressIfCanDeliverToVendor().subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).doOnSubscribe(new a(this)).doOnError(new b(this)).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "loginUseCases\n          …hResultOK()\n            }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe);
    }

    /* access modifiers changed from: private */
    /* renamed from: selectSavedAddressIfPossible$lambda-0  reason: not valid java name */
    public static final void m7907selectSavedAddressIfPossible$lambda0(LoginPresenter2Impl loginPresenter2Impl, Disposable disposable) {
        Intrinsics.checkNotNullParameter(loginPresenter2Impl, "this$0");
        loginPresenter2Impl.loginView.startLodingPopup();
    }

    /* access modifiers changed from: private */
    /* renamed from: selectSavedAddressIfPossible$lambda-1  reason: not valid java name */
    public static final void m7908selectSavedAddressIfPossible$lambda1(LoginPresenter2Impl loginPresenter2Impl, Throwable th2) {
        Intrinsics.checkNotNullParameter(loginPresenter2Impl, "this$0");
        loginPresenter2Impl.loginView.stopLodingPopup();
    }

    /* access modifiers changed from: private */
    /* renamed from: selectSavedAddressIfPossible$lambda-2  reason: not valid java name */
    public static final void m7909selectSavedAddressIfPossible$lambda2(LoginPresenter2Impl loginPresenter2Impl, Throwable th2) {
        Intrinsics.checkNotNullParameter(loginPresenter2Impl, "this$0");
        LogManager.error$default(th2, (String) null, 2, (Object) null);
        loginPresenter2Impl.loginView.finishWithResultOK();
    }

    public void onDestroy() {
        this.compositeDisposable.dispose();
    }

    public void onLoggedInFromCartScreen() {
        selectSavedAddressIfPossible();
    }

    public void onRedirectToHomeScreen() {
        if (this.loginExperimentProvider.getCanEnableSelectAddressOnHome()) {
            this.loginUseCases.enableShowLocationSelectionInHomeScreen();
        }
        this.loginView.finishAndGoToHomeScreen();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LoginPresenter2Impl(library.talabat.mvp.login.experiments.LoginExperimentProvider r7, library.talabat.mvp.login.LoginView r8, library.talabat.mvp.login.domain.usecases.LoginUseCases r9, io.reactivex.Scheduler r10, io.reactivex.Scheduler r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 8
            if (r13 == 0) goto L_0x000d
            io.reactivex.Scheduler r10 = io.reactivex.schedulers.Schedulers.io()
            java.lang.String r13 = "io()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r13)
        L_0x000d:
            r4 = r10
            r10 = r12 & 16
            if (r10 == 0) goto L_0x001b
            io.reactivex.Scheduler r11 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            java.lang.String r10 = "mainThread()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r10)
        L_0x001b:
            r5 = r11
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.login.impl.LoginPresenter2Impl.<init>(library.talabat.mvp.login.experiments.LoginExperimentProvider, library.talabat.mvp.login.LoginView, library.talabat.mvp.login.domain.usecases.LoginUseCases, io.reactivex.Scheduler, io.reactivex.Scheduler, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
