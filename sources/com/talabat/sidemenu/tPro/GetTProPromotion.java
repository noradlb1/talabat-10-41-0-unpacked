package com.talabat.sidemenu.tPro;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.talabatcommon.feature.promotionWidget.PromotionsWidgetUseCase;
import com.talabat.talabatcommon.feature.promotionWidget.network.PromotionsWidgetService;
import com.talabat.talabatcommon.feature.promotionWidget.repository.PromotionsWidgetRepositoryImpl;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u0004\u0018\u00010\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/talabat/sidemenu/tPro/GetTProPromotion;", "", "subscriptionsFeatureFlagRepo", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "globalDataModel", "Lcom/integration/IntegrationGlobalDataModel$Companion;", "promotionsWidgetUseCase", "Lcom/talabat/talabatcommon/feature/promotionWidget/PromotionsWidgetUseCase;", "customerRepository", "Lcom/talabat/customer/domain/CustomerRepository;", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;Lcom/integration/IntegrationGlobalDataModel$Companion;Lcom/talabat/talabatcommon/feature/promotionWidget/PromotionsWidgetUseCase;Lcom/talabat/customer/domain/CustomerRepository;)V", "getTProBanner", "Lcom/talabat/talabatcommon/views/promotionWidget/model/PromotionsWidgetDisplayModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isTProAllowed", "", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetTProPromotion {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String T_PRO_FREE_TRIAL_TAG = "free-subscription";
    @NotNull
    public static final String T_PRO_MODULE = "tpro";
    @NotNull
    public static final String T_PRO_TAG = "subscription";
    @NotNull
    private final CustomerRepository customerRepository;
    @NotNull
    private final IntegrationGlobalDataModel.Companion globalDataModel;
    @NotNull
    private final PromotionsWidgetUseCase promotionsWidgetUseCase;
    @NotNull
    private final ISubscriptionsFeatureFlagsRepository subscriptionsFeatureFlagRepo;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/sidemenu/tPro/GetTProPromotion$Companion;", "", "()V", "T_PRO_FREE_TRIAL_TAG", "", "T_PRO_MODULE", "T_PRO_TAG", "getInstance", "Lcom/talabat/sidemenu/tPro/GetTProPromotion;", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "featureFlag", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "globalDataModel", "Lcom/integration/IntegrationGlobalDataModel$Companion;", "customerRepository", "Lcom/talabat/customer/domain/CustomerRepository;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GetTProPromotion getInstance(@NotNull Context context, @NotNull CoroutineScope coroutineScope, @NotNull ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository, @NotNull IntegrationGlobalDataModel.Companion companion, @NotNull CustomerRepository customerRepository) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(iSubscriptionsFeatureFlagsRepository, "featureFlag");
            Intrinsics.checkNotNullParameter(companion, "globalDataModel");
            Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
            return new GetTProPromotion(iSubscriptionsFeatureFlagsRepository, companion, new PromotionsWidgetUseCase(new PromotionsWidgetRepositoryImpl(new NetworkHandler(context), new PromotionsWidgetService(new TalabatAPIBuilder())), coroutineScope, Dispatchers.getIO()), customerRepository);
        }
    }

    public GetTProPromotion(@NotNull ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository, @NotNull IntegrationGlobalDataModel.Companion companion, @NotNull PromotionsWidgetUseCase promotionsWidgetUseCase2, @NotNull CustomerRepository customerRepository2) {
        Intrinsics.checkNotNullParameter(iSubscriptionsFeatureFlagsRepository, "subscriptionsFeatureFlagRepo");
        Intrinsics.checkNotNullParameter(companion, "globalDataModel");
        Intrinsics.checkNotNullParameter(promotionsWidgetUseCase2, "promotionsWidgetUseCase");
        Intrinsics.checkNotNullParameter(customerRepository2, "customerRepository");
        this.subscriptionsFeatureFlagRepo = iSubscriptionsFeatureFlagsRepository;
        this.globalDataModel = companion;
        this.promotionsWidgetUseCase = promotionsWidgetUseCase2;
        this.customerRepository = customerRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getTProBanner(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.talabatcommon.views.promotionWidget.model.PromotionsWidgetDisplayModel> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.talabat.sidemenu.tPro.GetTProPromotion$getTProBanner$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.talabat.sidemenu.tPro.GetTProPromotion$getTProBanner$1 r0 = (com.talabat.sidemenu.tPro.GetTProPromotion$getTProBanner$1) r0
            int r1 = r0.f61394j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61394j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.sidemenu.tPro.GetTProPromotion$getTProBanner$1 r0 = new com.talabat.sidemenu.tPro.GetTProPromotion$getTProBanner$1
            r0.<init>(r12, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f61392h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61394j
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00a3
        L_0x002a:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r13)
            com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository r13 = r12.subscriptionsFeatureFlagRepo
            boolean r13 = r13.isTProSideBannerEnabled()
            r2 = 0
            if (r13 != 0) goto L_0x003f
            return r2
        L_0x003f:
            java.lang.String r13 = r12.isTProAllowed()
            if (r13 != 0) goto L_0x0046
            return r2
        L_0x0046:
            com.talabat.configuration.country.Country$Companion r2 = com.talabat.configuration.country.Country.Companion
            com.integration.IntegrationGlobalDataModel$Companion r4 = r12.globalDataModel
            int r4 = r4.selectedCountryCode()
            com.talabat.configuration.country.Country r2 = r2.from(r4)
            com.talabat.configuration.country.Country r4 = com.talabat.configuration.country.Country.UAE
            if (r2 == r4) goto L_0x006e
            java.lang.String r2 = r2.getThreeLetterCode()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r13)
            java.lang.String r13 = "-"
            r4.append(r13)
            r4.append(r2)
            java.lang.String r13 = r4.toString()
        L_0x006e:
            r7 = r13
            com.talabat.talabatcommon.feature.promotionWidget.PromotionsWidgetUseCase r13 = r12.promotionsWidgetUseCase
            com.talabat.talabatcommon.feature.promotionWidget.model.request.PromotionsWidgetRequestModel r2 = new com.talabat.talabatcommon.feature.promotionWidget.model.request.PromotionsWidgetRequestModel
            com.integration.IntegrationGlobalDataModel$Companion r4 = r12.globalDataModel
            int r5 = r4.selectedCountryCode()
            com.integration.IntegrationGlobalDataModel$Companion r4 = r12.globalDataModel
            int r6 = r4.getSelectedAreaId()
            java.lang.String r8 = "tpro"
            com.integration.IntegrationGlobalDataModel$Companion r4 = r12.globalDataModel
            double r9 = r4.selectedLocationLatitude()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            com.integration.IntegrationGlobalDataModel$Companion r4 = r12.globalDataModel
            double r10 = r4.selectedLocationLongitude()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r0.f61394j = r3
            java.lang.Object r13 = r13.run((com.talabat.talabatcommon.feature.promotionWidget.model.request.PromotionsWidgetRequestModel) r2, (kotlin.coroutines.Continuation<? super com.talabat.talabatcore.functional.Either<? extends com.talabat.talabatcore.exception.Failure, com.talabat.talabatcommon.views.promotionWidget.model.PromotionsWidgetDisplayModel>>) r0)
            if (r13 != r1) goto L_0x00a3
            return r1
        L_0x00a3:
            com.talabat.talabatcore.functional.Either r13 = (com.talabat.talabatcore.functional.Either) r13
            com.talabat.sidemenu.tPro.GetTProPromotion$getTProBanner$2 r0 = com.talabat.sidemenu.tPro.GetTProPromotion$getTProBanner$2.INSTANCE
            com.talabat.sidemenu.tPro.GetTProPromotion$getTProBanner$3 r1 = com.talabat.sidemenu.tPro.GetTProPromotion$getTProBanner$3.INSTANCE
            java.lang.Object r13 = r13.either(r0, r1)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.sidemenu.tPro.GetTProPromotion.getTProBanner(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @VisibleForTesting
    @Nullable
    public final String isTProAllowed() {
        boolean isLoggedIn = this.globalDataModel.isLoggedIn();
        boolean isTproSubscriptionEnabled = this.subscriptionsFeatureFlagRepo.isTproSubscriptionEnabled();
        boolean isTPro = this.customerRepository.isTPro();
        if (!isLoggedIn || !isTproSubscriptionEnabled || isTPro) {
            return null;
        }
        return "subscription";
    }
}
