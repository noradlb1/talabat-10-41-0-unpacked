package com.talabat.sidemenu;

import JsonModels.Response.WalletCreditBalanceResponse;
import com.newrelic.agent.android.agentdata.HexAttribute;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.bnplcore.domain.BnplObservabilityConstants;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import com.talabat.feature.bnplcore.domain.usecase.SendNavigationOptionLoadedEventUseCase;
import com.talabat.feature.bnplcore.domain.usecase.impl.IsUserBNPLEligibleUseCase;
import com.talabat.helpers.AppUrls;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.wallet.common.interactors.walletBalance.IWalletBalanceCommonInteractor;
import com.talabat.wallet.common.interactors.walletBalance.WalletBalanceCommonInteractor;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import library.talabat.com.talabatlib.CreateApiUrl;
import library.talabat.mvp.IGlobalInteractor;
import library.talabat.mvp.home.VoucherStateDomainModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qu.b;
import qu.c;
import qu.d;
import qu.e;
import qu.f;
import qu.g;
import qu.h;
import qu.i;
import service.ApiHandler;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&Be\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u001cH\u0016J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001cH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/talabat/sidemenu/SideMenuInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "Lcom/talabat/sidemenu/IsideMenuInteractor;", "sideMenuListener", "Lcom/talabat/sidemenu/SideMenuListener;", "voucherRepository", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;", "ioScheduler", "Lio/reactivex/Scheduler;", "mainScheduler", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getOverdueUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "sendNavigationOptionLoadedEventUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/SendNavigationOptionLoadedEventUseCase;", "isUserBNPLEligibleUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/impl/IsUserBNPLEligibleUseCase;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lcom/talabat/sidemenu/SideMenuListener;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/talabat/feature/bnplcore/domain/usecase/SendNavigationOptionLoadedEventUseCase;Lcom/talabat/feature/bnplcore/domain/usecase/impl/IsUserBNPLEligibleUseCase;Lkotlinx/coroutines/CoroutineScope;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "walletBalanceCommonInteractor", "Lcom/talabat/wallet/common/interactors/walletBalance/IWalletBalanceCommonInteractor;", "checkUserEligibleForBNPL", "", "loadBnplOverdues", "loadLastOrderDetails", "loadRafSenderVoucherLabel", "loadTalabatCreditBalance", "loadUserActiveVoucherCount", "trackUnExpectedBnplScenario", "throwable", "", "unregister", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SideMenuInteractor implements IGlobalInteractor, IsideMenuInteractor {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String TRACK_EVENT_REFER_A_FRIEND = "refer_a_friend";
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @Nullable
    private final CoroutineScope coroutineScope;
    @NotNull
    private final CompositeDisposable disposables;
    @Nullable
    private final GetOverdueUseCase getOverdueUseCase;
    @NotNull
    private final Scheduler ioScheduler;
    /* access modifiers changed from: private */
    @Nullable
    public final IsUserBNPLEligibleUseCase isUserBNPLEligibleUseCase;
    @NotNull
    private final Scheduler mainScheduler;
    @Nullable
    private final IObservabilityManager observabilityManager;
    @Nullable
    private final SendNavigationOptionLoadedEventUseCase sendNavigationOptionLoadedEventUseCase;
    /* access modifiers changed from: private */
    @Nullable
    public SideMenuListener sideMenuListener;
    @NotNull
    private final VoucherRepository voucherRepository;
    @Nullable
    private IWalletBalanceCommonInteractor walletBalanceCommonInteractor;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/sidemenu/SideMenuInteractor$Companion;", "", "()V", "TRACK_EVENT_REFER_A_FRIEND", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SideMenuInteractor(@NotNull SideMenuListener sideMenuListener2, @NotNull VoucherRepository voucherRepository2, @NotNull Scheduler scheduler, @NotNull Scheduler scheduler2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @Nullable GetOverdueUseCase getOverdueUseCase2, @Nullable IObservabilityManager iObservabilityManager, @Nullable SendNavigationOptionLoadedEventUseCase sendNavigationOptionLoadedEventUseCase2, @Nullable IsUserBNPLEligibleUseCase isUserBNPLEligibleUseCase2, @Nullable CoroutineScope coroutineScope2) {
        Intrinsics.checkNotNullParameter(sideMenuListener2, "sideMenuListener");
        Intrinsics.checkNotNullParameter(voucherRepository2, "voucherRepository");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        Intrinsics.checkNotNullParameter(scheduler2, "mainScheduler");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.voucherRepository = voucherRepository2;
        this.ioScheduler = scheduler;
        this.mainScheduler = scheduler2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.getOverdueUseCase = getOverdueUseCase2;
        this.observabilityManager = iObservabilityManager;
        this.sendNavigationOptionLoadedEventUseCase = sendNavigationOptionLoadedEventUseCase2;
        this.isUserBNPLEligibleUseCase = isUserBNPLEligibleUseCase2;
        this.coroutineScope = coroutineScope2;
        this.disposables = new CompositeDisposable();
        this.sideMenuListener = sideMenuListener2;
        this.walletBalanceCommonInteractor = new WalletBalanceCommonInteractor();
    }

    /* access modifiers changed from: private */
    /* renamed from: loadBnplOverdues$lambda-6  reason: not valid java name */
    public static final void m10896loadBnplOverdues$lambda6(SideMenuInteractor sideMenuInteractor, GetOverdueUseCase.OverdueResult overdueResult) {
        SideMenuListener sideMenuListener2;
        Intrinsics.checkNotNullParameter(sideMenuInteractor, "this$0");
        if (overdueResult != null && (sideMenuListener2 = sideMenuInteractor.sideMenuListener) != null) {
            sideMenuListener2.onBnplOverdueLoaded(overdueResult);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadRafSenderVoucherLabel$lambda-10  reason: not valid java name */
    public static final void m10897loadRafSenderVoucherLabel$lambda10(SideMenuInteractor sideMenuInteractor, SingleEmitter singleEmitter) {
        Object obj;
        Intrinsics.checkNotNullParameter(sideMenuInteractor, "this$0");
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(sideMenuInteractor.voucherRepository.getReferralSenderCampaignDetails(sideMenuInteractor.configurationLocalRepository.selectedCountry().getCountryId()).getVoucherValueLabel());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6336isSuccessimpl(obj)) {
            singleEmitter.onSuccess((String) obj);
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        if (r12 != null) {
            singleEmitter.onError(r12);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadRafSenderVoucherLabel$lambda-11  reason: not valid java name */
    public static final void m10898loadRafSenderVoucherLabel$lambda11(SideMenuInteractor sideMenuInteractor, String str) {
        Intrinsics.checkNotNullParameter(sideMenuInteractor, "this$0");
        SideMenuListener sideMenuListener2 = sideMenuInteractor.sideMenuListener;
        if (sideMenuListener2 != null) {
            Intrinsics.checkNotNullExpressionValue(str, "it");
            sideMenuListener2.onUserRafSenderVoucherLabelReceived(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadRafSenderVoucherLabel$lambda-12  reason: not valid java name */
    public static final void m10899loadRafSenderVoucherLabel$lambda12(SideMenuInteractor sideMenuInteractor, Throwable th2) {
        Intrinsics.checkNotNullParameter(sideMenuInteractor, "this$0");
        IObservabilityManager iObservabilityManager = sideMenuInteractor.observabilityManager;
        if (iObservabilityManager != null) {
            IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(iObservabilityManager, TRACK_EVENT_REFER_A_FRIEND, (Map) null, 2, (Object) null);
        }
        Intrinsics.checkNotNullExpressionValue(th2, HexAttribute.HEX_ATTR_CAUSE);
        LogManager.logException(th2);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadUserActiveVoucherCount$lambda-2  reason: not valid java name */
    public static final void m10900loadUserActiveVoucherCount$lambda2(SideMenuInteractor sideMenuInteractor, SingleEmitter singleEmitter) {
        Object obj;
        Intrinsics.checkNotNullParameter(sideMenuInteractor, "this$0");
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(sideMenuInteractor.voucherRepository.getVouchersState(sideMenuInteractor.configurationLocalRepository.selectedCountry().getCountryId()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6336isSuccessimpl(obj)) {
            singleEmitter.onSuccess((VoucherStateDomainModel) obj);
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        if (r12 != null) {
            singleEmitter.onError(r12);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadUserActiveVoucherCount$lambda-3  reason: not valid java name */
    public static final void m10901loadUserActiveVoucherCount$lambda3(SideMenuInteractor sideMenuInteractor, VoucherStateDomainModel voucherStateDomainModel) {
        Intrinsics.checkNotNullParameter(sideMenuInteractor, "this$0");
        SideMenuListener sideMenuListener2 = sideMenuInteractor.sideMenuListener;
        if (sideMenuListener2 != null) {
            Intrinsics.checkNotNullExpressionValue(voucherStateDomainModel, "it");
            sideMenuListener2.onUserActiveVouchersCountReceived(voucherStateDomainModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadUserActiveVoucherCount$lambda-4  reason: not valid java name */
    public static final void m10902loadUserActiveVoucherCount$lambda4(SideMenuInteractor sideMenuInteractor, Throwable th2) {
        Intrinsics.checkNotNullParameter(sideMenuInteractor, "this$0");
        Intrinsics.checkNotNullExpressionValue(th2, HexAttribute.HEX_ATTR_CAUSE);
        LogManager.logException(th2);
        SideMenuListener sideMenuListener2 = sideMenuInteractor.sideMenuListener;
        if (sideMenuListener2 != null) {
            sideMenuListener2.onUserActiveVouchersCountFail();
        }
    }

    /* access modifiers changed from: private */
    public final void trackUnExpectedBnplScenario(Throwable th2) {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        if (iObservabilityManager != null) {
            String message = th2.getMessage();
            if (message == null) {
                message = "";
            }
            iObservabilityManager.trackUnExpectedScenario(BnplObservabilityConstants.EXPLANATION_BNPL_OVERDUES_NOTIFICATION_EXCEPTION, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", message)));
        }
    }

    public void checkUserEligibleForBNPL() {
        CoroutineScope coroutineScope2 = this.coroutineScope;
        if (coroutineScope2 != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new SideMenuInteractor$checkUserEligibleForBNPL$1(this, (Continuation<? super SideMenuInteractor$checkUserEligibleForBNPL$1>) null), 3, (Object) null);
        }
    }

    public void loadBnplOverdues() {
        GetOverdueUseCase getOverdueUseCase2 = this.getOverdueUseCase;
        if (getOverdueUseCase2 != null) {
            this.disposables.add(getOverdueUseCase2.invoke().subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new h(this), new i(this)));
        }
    }

    public void loadLastOrderDetails() {
        ApiHandler.Services callApi = ApiHandler.callApi();
        String str = AppUrls.LAST_ORDER_DETAILS;
        int countryId = this.configurationLocalRepository.selectedCountry().getCountryId();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(countryId);
        callApi.getLastOrderIds(CreateApiUrl.createWithParameters(str, new String[]{"{countryid}", sb2.toString()})).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SideMenuInteractor$loadLastOrderDetails$1(this));
    }

    public void loadRafSenderVoucherLabel() {
        this.disposables.add(Single.create(new b(this)).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new c(this), new d(this)));
    }

    public void loadTalabatCreditBalance() {
        Observable<WalletCreditBalanceResponse> observable;
        IWalletBalanceCommonInteractor iWalletBalanceCommonInteractor = this.walletBalanceCommonInteractor;
        if (iWalletBalanceCommonInteractor != null) {
            observable = iWalletBalanceCommonInteractor.getWalletCreditBalance(String.valueOf(this.configurationLocalRepository.selectedCountry().getCountryId()));
        } else {
            observable = null;
        }
        if (observable != null) {
            observable.subscribe((Observer<? super WalletCreditBalanceResponse>) new SideMenuInteractor$loadTalabatCreditBalance$1(this));
        }
    }

    public void loadUserActiveVoucherCount() {
        this.disposables.add(Single.create(new e(this)).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new f(this), new g(this)));
    }

    public void unregister() {
        this.sideMenuListener = null;
        this.disposables.dispose();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SideMenuInteractor(com.talabat.sidemenu.SideMenuListener r16, com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository r17, io.reactivex.Scheduler r18, io.reactivex.Scheduler r19, com.talabat.configuration.ConfigurationLocalRepository r20, com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase r21, com.talabat.core.observabilityNew.domain.IObservabilityManager r22, com.talabat.feature.bnplcore.domain.usecase.SendNavigationOptionLoadedEventUseCase r23, com.talabat.feature.bnplcore.domain.usecase.impl.IsUserBNPLEligibleUseCase r24, kotlinx.coroutines.CoroutineScope r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r15 = this;
            r0 = r26 & 2
            if (r0 == 0) goto L_0x001e
            com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepositoryImpl r0 = new com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepositoryImpl
            com.talabat.talabatcore.platform.NetworkHandler r1 = new com.talabat.talabatcore.platform.NetworkHandler
            android.app.Application r2 = com.talabat.lib.Integration.getAppContext()
            r1.<init>(r2)
            com.talabat.talabatcommon.feature.vouchers.loyalty.network.VouchersService r2 = new com.talabat.talabatcommon.feature.vouchers.loyalty.network.VouchersService
            com.talabat.core.network.network.TalabatAPIBuilder r3 = new com.talabat.core.network.network.TalabatAPIBuilder
            r3.<init>()
            r2.<init>(r3)
            r0.<init>(r1, r2)
            r6 = r0
            goto L_0x0020
        L_0x001e:
            r6 = r17
        L_0x0020:
            r0 = r26 & 4
            if (r0 == 0) goto L_0x002f
            io.reactivex.Scheduler r0 = io.reactivex.schedulers.Schedulers.io()
            java.lang.String r1 = "io()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r7 = r0
            goto L_0x0031
        L_0x002f:
            r7 = r18
        L_0x0031:
            r0 = r26 & 8
            if (r0 == 0) goto L_0x0040
            io.reactivex.Scheduler r0 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            java.lang.String r1 = "mainThread()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r8 = r0
            goto L_0x0042
        L_0x0040:
            r8 = r19
        L_0x0042:
            r4 = r15
            r5 = r16
            r9 = r20
            r10 = r21
            r11 = r22
            r12 = r23
            r13 = r24
            r14 = r25
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.sidemenu.SideMenuInteractor.<init>(com.talabat.sidemenu.SideMenuListener, com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository, io.reactivex.Scheduler, io.reactivex.Scheduler, com.talabat.configuration.ConfigurationLocalRepository, com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase, com.talabat.core.observabilityNew.domain.IObservabilityManager, com.talabat.feature.bnplcore.domain.usecase.SendNavigationOptionLoadedEventUseCase, com.talabat.feature.bnplcore.domain.usecase.impl.IsUserBNPLEligibleUseCase, kotlinx.coroutines.CoroutineScope, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
