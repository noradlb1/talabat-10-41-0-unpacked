package com.talabat.feature.tpro.presentation.savings.account;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlan;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
import com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 22\u00020\u0001:\u00012BX\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J!\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010'\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fJ\u001f\u0010(\u001a\u00020\u00122\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00120*H@ø\u0001\u0000¢\u0006\u0002\u0010+J\u000e\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u001bJ\u000e\u0010.\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fJ\u0013\u0010/\u001a\u0004\u0018\u00010\u0012H@ø\u0001\u0000¢\u0006\u0002\u00100J\b\u00101\u001a\u00020\u0012H\u0002R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R)\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"Lcom/talabat/feature/tpro/presentation/savings/account/SideMenuTProSavingsViewPresenter;", "", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "getSavingsInfoUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;", "updateAutoRenewalUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/UpdateAutoRenewalUseCase;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "countryId", "", "onUpdateRenewalResult", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "subscriptionTracker", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "(Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;Lcom/talabat/feature/subscriptions/domain/usecase/UpdateAutoRenewalUseCase;Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;ILkotlin/jvm/functions/Function1;Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;)V", "cachedSavingsInfo", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "holder", "Lcom/talabat/feature/tpro/presentation/savings/account/SideMenuTProSavingsViewHolder;", "bindData", "savingsInfo", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "(Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hideSavingsView", "(Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onRenewalUpdate", "isSuccess", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refresh", "renewSubscription", "runOnUI", "action", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setView", "viewHolder", "startLoading", "startShimmer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackReactivateSuccess", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SideMenuTProSavingsViewPresenter {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String screenNameReactivate = "Navigation Screen";
    @NotNull
    private static final String screenTypeReactivate = "bottom_navigation_menu";
    /* access modifiers changed from: private */
    @Nullable
    public SubscriptionSavingsInfo cachedSavingsInfo;
    /* access modifiers changed from: private */
    @NotNull
    public final CoroutineDispatchersFactory coroutineDispatchersFactory;
    @NotNull
    private final CoroutineScope coroutineScope = new CoroutineScope(this) {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SideMenuTProSavingsViewPresenter f59393b;
        @NotNull
        private final CompletableJob job = JobKt.Job$default((Job) null, 1, (Object) null);

        {
            this.f59393b = r2;
        }

        @NotNull
        public CoroutineContext getCoroutineContext() {
            return this.job.plus(this.f59393b.coroutineDispatchersFactory.io());
        }
    };
    /* access modifiers changed from: private */
    public final int countryId;
    /* access modifiers changed from: private */
    @NotNull
    public final GetSavingsInfoUseCase getSavingsInfoUseCase;
    @Nullable
    private SideMenuTProSavingsViewHolder holder;
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<Boolean, Unit> onUpdateRenewalResult;
    @NotNull
    private final ISubscriptionStatusRepository subscriptionStatusRepository;
    @NotNull
    private final ISubscriptionsTracker subscriptionTracker;
    /* access modifiers changed from: private */
    @NotNull
    public final UpdateAutoRenewalUseCase updateAutoRenewalUseCase;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/tpro/presentation/savings/account/SideMenuTProSavingsViewPresenter$Companion;", "", "()V", "screenNameReactivate", "", "screenTypeReactivate", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SideMenuTProSavingsViewPresenter(@NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2, @NotNull GetSavingsInfoUseCase getSavingsInfoUseCase2, @NotNull UpdateAutoRenewalUseCase updateAutoRenewalUseCase2, @NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository, int i11, @NotNull Function1<? super Boolean, Unit> function1, @NotNull ISubscriptionsTracker iSubscriptionsTracker) {
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "coroutineDispatchersFactory");
        Intrinsics.checkNotNullParameter(getSavingsInfoUseCase2, "getSavingsInfoUseCase");
        Intrinsics.checkNotNullParameter(updateAutoRenewalUseCase2, "updateAutoRenewalUseCase");
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "subscriptionStatusRepository");
        Intrinsics.checkNotNullParameter(function1, "onUpdateRenewalResult");
        Intrinsics.checkNotNullParameter(iSubscriptionsTracker, "subscriptionTracker");
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
        this.getSavingsInfoUseCase = getSavingsInfoUseCase2;
        this.updateAutoRenewalUseCase = updateAutoRenewalUseCase2;
        this.subscriptionStatusRepository = iSubscriptionStatusRepository;
        this.countryId = i11;
        this.onUpdateRenewalResult = function1;
        this.subscriptionTracker = iSubscriptionsTracker;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: com.talabat.configuration.location.LocationConfigurationRepository} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object bindData(com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo r6, com.talabat.configuration.location.LocationConfigurationRepository r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$bindData$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$bindData$1 r0 = (com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$bindData$1) r0
            int r1 = r0.f59399m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59399m = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$bindData$1 r0 = new com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$bindData$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f59397k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59399m
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0077
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.f59396j
            r7 = r6
            com.talabat.configuration.location.LocationConfigurationRepository r7 = (com.talabat.configuration.location.LocationConfigurationRepository) r7
            java.lang.Object r6 = r0.f59395i
            com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo r6 = (com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo) r6
            java.lang.Object r2 = r0.f59394h
            com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter r2 = (com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005e
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r8)
            com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository r8 = r5.subscriptionStatusRepository
            kotlinx.coroutines.flow.MutableStateFlow r8 = r8.getSubscriptionSavings()
            r0.f59394h = r5
            r0.f59395i = r6
            r0.f59396j = r7
            r0.f59399m = r4
            java.lang.Object r8 = r8.emit(r6, r0)
            if (r8 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r2 = r5
        L_0x005e:
            com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewHolder r8 = r2.holder
            if (r8 == 0) goto L_0x0077
            com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$bindData$2$1 r4 = new com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$bindData$2$1
            r4.<init>(r8, r6, r7)
            r6 = 0
            r0.f59394h = r6
            r0.f59395i = r6
            r0.f59396j = r6
            r0.f59399m = r3
            java.lang.Object r6 = r2.runOnUI(r4, r0)
            if (r6 != r1) goto L_0x0077
            return r1
        L_0x0077:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter.bindData(com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo, com.talabat.configuration.location.LocationConfigurationRepository, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object hideSavingsView(com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$hideSavingsView$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$hideSavingsView$1 r0 = (com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$hideSavingsView$1) r0
            int r1 = r0.f59406k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59406k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$hideSavingsView$1 r0 = new com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$hideSavingsView$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f59404i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59406k
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0066
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.f59403h
            com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter r6 = (com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0051
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r7)
            com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository r7 = r5.subscriptionStatusRepository
            kotlinx.coroutines.flow.MutableStateFlow r7 = r7.getSubscriptionSavings()
            r0.f59403h = r5
            r0.f59406k = r4
            java.lang.Object r6 = r7.emit(r6, r0)
            if (r6 != r1) goto L_0x0050
            return r1
        L_0x0050:
            r6 = r5
        L_0x0051:
            com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewHolder r7 = r6.holder
            if (r7 == 0) goto L_0x0066
            com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$hideSavingsView$2$1 r2 = new com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$hideSavingsView$2$1
            r2.<init>(r7)
            r7 = 0
            r0.f59403h = r7
            r0.f59406k = r3
            java.lang.Object r6 = r6.runOnUI(r2, r0)
            if (r6 != r1) goto L_0x0066
            return r1
        L_0x0066:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter.hideSavingsView(com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object onRenewalUpdate(boolean z11, Continuation<? super Unit> continuation) {
        Object runOnUI = runOnUI(new SideMenuTProSavingsViewPresenter$onRenewalUpdate$2(z11, this), continuation);
        return runOnUI == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? runOnUI : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object runOnUI(Function0<Unit> function0, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.coroutineDispatchersFactory.main(), new SideMenuTProSavingsViewPresenter$runOnUI$2(function0, (Continuation<? super SideMenuTProSavingsViewPresenter$runOnUI$2>) null), continuation);
        return withContext == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object startShimmer(Continuation<? super Unit> continuation) {
        SideMenuTProSavingsViewHolder sideMenuTProSavingsViewHolder = this.holder;
        if (sideMenuTProSavingsViewHolder == null) {
            return null;
        }
        Object runOnUI = runOnUI(new SideMenuTProSavingsViewPresenter$startShimmer$2$1(sideMenuTProSavingsViewHolder), continuation);
        if (runOnUI == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return runOnUI;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void trackReactivateSuccess() {
        String str;
        SubscriptionPlan plan;
        ISubscriptionsTracker iSubscriptionsTracker = this.subscriptionTracker;
        Subscription tProSubscriptionInfo = this.subscriptionStatusRepository.getTProSubscriptionInfo();
        if (tProSubscriptionInfo == null || (plan = tProSubscriptionInfo.getPlan()) == null || (str = plan.getPlanId()) == null) {
            str = "";
        }
        iSubscriptionsTracker.tProSubscriptionReactivateSuccess("bottom_navigation_menu", "Navigation Screen", str);
    }

    public final void refresh(@NotNull LocationConfigurationRepository locationConfigurationRepository) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SideMenuTProSavingsViewPresenter$refresh$1(this, locationConfigurationRepository, (Continuation<? super SideMenuTProSavingsViewPresenter$refresh$1>) null), 3, (Object) null);
    }

    public final void renewSubscription(@NotNull LocationConfigurationRepository locationConfigurationRepository) {
        String str;
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
        Subscription tProSubscriptionInfo = this.subscriptionStatusRepository.getTProSubscriptionInfo();
        if (tProSubscriptionInfo != null) {
            str = tProSubscriptionInfo.getMembershipId();
        } else {
            str = null;
        }
        if (str != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SideMenuTProSavingsViewPresenter$renewSubscription$1$1(this, new UpdateAutoRenewalUseCase.Params(str, true, false), locationConfigurationRepository, (Continuation<? super SideMenuTProSavingsViewPresenter$renewSubscription$1$1>) null), 3, (Object) null);
        }
    }

    public final void setView(@NotNull SideMenuTProSavingsViewHolder sideMenuTProSavingsViewHolder) {
        Intrinsics.checkNotNullParameter(sideMenuTProSavingsViewHolder, "viewHolder");
        this.holder = sideMenuTProSavingsViewHolder;
    }

    public final void startLoading(@NotNull LocationConfigurationRepository locationConfigurationRepository) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SideMenuTProSavingsViewPresenter$startLoading$1(this, locationConfigurationRepository, (Continuation<? super SideMenuTProSavingsViewPresenter$startLoading$1>) null), 3, (Object) null);
    }
}
