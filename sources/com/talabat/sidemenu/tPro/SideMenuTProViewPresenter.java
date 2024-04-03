package com.talabat.sidemenu.tPro;

import android.content.Context;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.talabatcommon.feature.promotionWidget.model.response.WidgetInfo;
import com.talabat.talabatcommon.views.promotionWidget.model.PromotionsWidgetDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000*\u0001\u0011\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ\b\u0010\u001c\u001a\u00020\u0014H\u0002J\u0011\u0010\u001d\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0011\u0010\u001f\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0006\u0010 \u001a\u00020\u000eJ\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\"\u001a\u00020#R\u0010\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/talabat/sidemenu/tPro/SideMenuTProViewPresenter;", "", "context", "Landroid/content/Context;", "mainDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "subscriptionsFeatureFlag", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "customerRepository", "Lcom/talabat/customer/domain/CustomerRepository;", "subscriptionsRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "itemChanged", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlinx/coroutines/MainCoroutineDispatcher;Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;Lcom/talabat/customer/domain/CustomerRepository;Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;Lkotlin/jvm/functions/Function0;)V", "coroutineScope", "com/talabat/sidemenu/tPro/SideMenuTProViewPresenter$coroutineScope$1", "Lcom/talabat/sidemenu/tPro/SideMenuTProViewPresenter$coroutineScope$1;", "enabled", "", "getTProPromotion", "Lcom/talabat/sidemenu/tPro/GetTProPromotion;", "isNewBrand", "model", "Lcom/talabat/talabatcommon/views/promotionWidget/model/PromotionsWidgetDisplayModel;", "viewHolder", "Lcom/talabat/sidemenu/tPro/SideMenuTProViewHolder;", "canDisplaySavingsExpiredState", "handlePopulate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadTProBanner", "populate", "setView", "startLoading", "Lkotlinx/coroutines/Job;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SideMenuTProViewPresenter {
    @NotNull
    private SideMenuTProViewPresenter$coroutineScope$1 coroutineScope;
    /* access modifiers changed from: private */
    public boolean enabled = true;
    @NotNull
    private final GetTProPromotion getTProPromotion;
    private boolean isNewBrand;
    @NotNull
    private final Function0<Unit> itemChanged;
    /* access modifiers changed from: private */
    @NotNull
    public final MainCoroutineDispatcher mainDispatcher;
    @Nullable
    private PromotionsWidgetDisplayModel model;
    @NotNull
    private final ISubscriptionsFeatureFlagsRepository subscriptionsFeatureFlag;
    @NotNull
    private final ISubscriptionStatusRepository subscriptionsRepository;
    @Nullable
    private SideMenuTProViewHolder viewHolder;

    public SideMenuTProViewPresenter(@NotNull Context context, @NotNull MainCoroutineDispatcher mainCoroutineDispatcher, @NotNull ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository, @NotNull CustomerRepository customerRepository, @NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mainCoroutineDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(iSubscriptionsFeatureFlagsRepository, "subscriptionsFeatureFlag");
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "subscriptionsRepository");
        Intrinsics.checkNotNullParameter(function0, "itemChanged");
        this.mainDispatcher = mainCoroutineDispatcher;
        this.subscriptionsFeatureFlag = iSubscriptionsFeatureFlagsRepository;
        this.subscriptionsRepository = iSubscriptionStatusRepository;
        this.itemChanged = function0;
        SideMenuTProViewPresenter$coroutineScope$1 sideMenuTProViewPresenter$coroutineScope$1 = new SideMenuTProViewPresenter$coroutineScope$1();
        this.coroutineScope = sideMenuTProViewPresenter$coroutineScope$1;
        this.getTProPromotion = GetTProPromotion.Companion.getInstance(context, sideMenuTProViewPresenter$coroutineScope$1, iSubscriptionsFeatureFlagsRepository, IntegrationGlobalDataModel.Companion, customerRepository);
    }

    private final boolean canDisplaySavingsExpiredState() {
        if (!this.subscriptionsRepository.isTProExpiredPeriod() || !this.subscriptionsFeatureFlag.isROIbannerExpiredModeEnabled()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handlePopulate(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$1 r0 = (com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$1) r0
            int r1 = r0.f61397j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61397j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$1 r0 = new com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f61395h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61397j
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 == r4) goto L_0x0034
            if (r2 == r3) goto L_0x0030
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0030:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0069
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0052
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.canDisplaySavingsExpiredState()
            if (r6 != 0) goto L_0x0055
            kotlinx.coroutines.MainCoroutineDispatcher r6 = r5.mainDispatcher
            com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$2 r2 = new com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$2
            r3 = 0
            r2.<init>(r5, r3)
            r0.f61397j = r4
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0)
            if (r6 != r1) goto L_0x0052
            return r1
        L_0x0052:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0055:
            com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository r6 = r5.subscriptionsRepository
            kotlinx.coroutines.flow.MutableStateFlow r6 = r6.getSubscriptionSavings()
            com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$3 r2 = new com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$3
            r2.<init>(r5)
            r0.f61397j = r3
            java.lang.Object r6 = r6.collect(r2, r0)
            if (r6 != r1) goto L_0x0069
            return r1
        L_0x0069:
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.sidemenu.tPro.SideMenuTProViewPresenter.handlePopulate(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0063 A[Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068 A[Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006b A[Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006c A[Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @androidx.annotation.VisibleForTesting
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loadTProBanner(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$loadTProBanner$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$loadTProBanner$1 r0 = (com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$loadTProBanner$1) r0
            int r1 = r0.f61410l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61410l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$loadTProBanner$1 r0 = new com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$loadTProBanner$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f61408j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61410l
            r3 = 2
            r4 = 0
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0045
            if (r2 == r5) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00a6
        L_0x002f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0037:
            java.lang.Object r2 = r0.f61407i
            com.talabat.sidemenu.tPro.SideMenuTProViewPresenter r2 = (com.talabat.sidemenu.tPro.SideMenuTProViewPresenter) r2
            java.lang.Object r7 = r0.f61406h
            com.talabat.sidemenu.tPro.SideMenuTProViewPresenter r7 = (com.talabat.sidemenu.tPro.SideMenuTProViewPresenter) r7
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0043 }
            goto L_0x005b
        L_0x0043:
            r9 = move-exception
            goto L_0x0084
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.Result$Companion r9 = kotlin.Result.Companion     // Catch:{ all -> 0x0082 }
            com.talabat.sidemenu.tPro.GetTProPromotion r9 = r8.getTProPromotion     // Catch:{ all -> 0x0082 }
            r0.f61406h = r8     // Catch:{ all -> 0x0082 }
            r0.f61407i = r8     // Catch:{ all -> 0x0082 }
            r0.f61410l = r5     // Catch:{ all -> 0x0082 }
            java.lang.Object r9 = r9.getTProBanner(r0)     // Catch:{ all -> 0x0082 }
            if (r9 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r2 = r8
            r7 = r2
        L_0x005b:
            com.talabat.talabatcommon.views.promotionWidget.model.PromotionsWidgetDisplayModel r9 = (com.talabat.talabatcommon.views.promotionWidget.model.PromotionsWidgetDisplayModel) r9     // Catch:{ all -> 0x0043 }
            r2.model = r9     // Catch:{ all -> 0x0043 }
            com.talabat.talabatcommon.views.promotionWidget.model.PromotionsWidgetDisplayModel r9 = r7.model     // Catch:{ all -> 0x0043 }
            if (r9 == 0) goto L_0x0068
            com.talabat.talabatcommon.feature.promotionWidget.model.response.WidgetInfo r9 = r9.getWidgetInfo()     // Catch:{ all -> 0x0043 }
            goto L_0x0069
        L_0x0068:
            r9 = r4
        L_0x0069:
            if (r9 == 0) goto L_0x006c
            goto L_0x006d
        L_0x006c:
            r5 = r6
        L_0x006d:
            r7.enabled = r5     // Catch:{ all -> 0x0043 }
            com.talabat.core.experiment.data.TalabatExperiment r9 = com.talabat.core.experiment.data.TalabatExperiment.INSTANCE     // Catch:{ all -> 0x0043 }
            com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants r2 = com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants.BRAND_UPDATES     // Catch:{ all -> 0x0043 }
            com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy r5 = com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy.APPTIMIZE     // Catch:{ all -> 0x0043 }
            boolean r9 = r9.getBooleanVariant(r2, r6, r5)     // Catch:{ all -> 0x0043 }
            r7.isNewBrand = r9     // Catch:{ all -> 0x0043 }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0043 }
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r9)     // Catch:{ all -> 0x0043 }
            goto L_0x008e
        L_0x0082:
            r9 = move-exception
            r7 = r8
        L_0x0084:
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r9)
        L_0x008e:
            java.lang.Throwable r9 = kotlin.Result.m6332exceptionOrNullimpl(r9)
            if (r9 != 0) goto L_0x0095
            goto L_0x0099
        L_0x0095:
            r7.enabled = r6
            r7.isNewBrand = r6
        L_0x0099:
            r0.f61406h = r4
            r0.f61407i = r4
            r0.f61410l = r3
            java.lang.Object r9 = r7.handlePopulate(r0)
            if (r9 != r1) goto L_0x00a6
            return r1
        L_0x00a6:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.sidemenu.tPro.SideMenuTProViewPresenter.loadTProBanner(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void populate() {
        WidgetInfo widgetInfo;
        SideMenuTProViewHolder sideMenuTProViewHolder = this.viewHolder;
        if (sideMenuTProViewHolder != null) {
            PromotionsWidgetDisplayModel promotionsWidgetDisplayModel = this.model;
            if (promotionsWidgetDisplayModel != null) {
                widgetInfo = promotionsWidgetDisplayModel.getWidgetInfo();
            } else {
                widgetInfo = null;
            }
            sideMenuTProViewHolder.setModel(widgetInfo);
            sideMenuTProViewHolder.setEnabled(this.enabled);
            sideMenuTProViewHolder.setNewBrand(this.isNewBrand);
            sideMenuTProViewHolder.populate();
        }
        this.itemChanged.invoke();
    }

    public final void setView(@NotNull SideMenuTProViewHolder sideMenuTProViewHolder) {
        Intrinsics.checkNotNullParameter(sideMenuTProViewHolder, "viewHolder");
        this.viewHolder = sideMenuTProViewHolder;
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SideMenuTProViewPresenter$setView$1(this, (Continuation<? super SideMenuTProViewPresenter$setView$1>) null), 3, (Object) null);
    }

    @NotNull
    public final Job startLoading() {
        return BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SideMenuTProViewPresenter$startLoading$1(this, (Continuation<? super SideMenuTProViewPresenter$startLoading$1>) null), 3, (Object) null);
    }
}
