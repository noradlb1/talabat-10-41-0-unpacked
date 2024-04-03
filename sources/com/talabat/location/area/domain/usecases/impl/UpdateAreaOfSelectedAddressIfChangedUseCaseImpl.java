package com.talabat.location.area.domain.usecases.impl;

import android.content.Context;
import android.content.SharedPreferences;
import buisnessmodels.Customer;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalConstants;
import com.talabat.location.area.domain.repository.AreaRepository;
import com.talabat.location.area.domain.usecases.UpdateAreaOfSelectedAddressIfChangedUseCase;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0011\u0010\u0019\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/talabat/location/area/domain/usecases/impl/UpdateAreaOfSelectedAddressIfChangedUseCaseImpl;", "Lcom/talabat/location/area/domain/usecases/UpdateAreaOfSelectedAddressIfChangedUseCase;", "context", "Landroid/content/Context;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "areaRepository", "Lcom/talabat/location/area/domain/repository/AreaRepository;", "isExperimentActiveProvider", "Lkotlin/Function0;", "", "customer", "Lbuisnessmodels/Customer;", "updateAddressApi", "Lkotlin/Function1;", "Lcom/talabat/domain/address/Address;", "", "talabatExperiments", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "customerAddressesRepository", "Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;", "(Landroid/content/Context;Lcom/talabat/configuration/discovery/AppVersionProvider;Lcom/talabat/location/area/domain/repository/AreaRepository;Lkotlin/jvm/functions/Function0;Lbuisnessmodels/Customer;Lkotlin/jvm/functions/Function1;Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;)V", "updateAddress", "selectedSelectedAddress", "(Lcom/talabat/domain/address/Address;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAreaOfSelectedAddressIfChanged", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateValuesInSharedPreference", "address", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdateAreaOfSelectedAddressIfChangedUseCaseImpl implements UpdateAreaOfSelectedAddressIfChangedUseCase {
    @NotNull
    private final AppVersionProvider appVersionProvider;
    @NotNull
    private final AreaRepository areaRepository;
    @NotNull
    private final Context context;
    @NotNull
    private final Customer customer;
    @NotNull
    private final CustomerAddressesRepository customerAddressesRepository;
    @NotNull
    private final Function0<Boolean> isExperimentActiveProvider;
    @NotNull
    private final ITalabatExperiment talabatExperiments;
    @NotNull
    private final Function1<Address, Unit> updateAddressApi;

    public UpdateAreaOfSelectedAddressIfChangedUseCaseImpl(@NotNull Context context2, @NotNull AppVersionProvider appVersionProvider2, @NotNull AreaRepository areaRepository2, @NotNull Function0<Boolean> function0, @NotNull Customer customer2, @NotNull Function1<? super Address, Unit> function1, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull CustomerAddressesRepository customerAddressesRepository2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        Intrinsics.checkNotNullParameter(areaRepository2, "areaRepository");
        Intrinsics.checkNotNullParameter(function0, "isExperimentActiveProvider");
        Intrinsics.checkNotNullParameter(customer2, "customer");
        Intrinsics.checkNotNullParameter(function1, "updateAddressApi");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiments");
        Intrinsics.checkNotNullParameter(customerAddressesRepository2, "customerAddressesRepository");
        this.context = context2;
        this.appVersionProvider = appVersionProvider2;
        this.areaRepository = areaRepository2;
        this.isExperimentActiveProvider = function0;
        this.customer = customer2;
        this.updateAddressApi = function1;
        this.talabatExperiments = iTalabatExperiment;
        this.customerAddressesRepository = customerAddressesRepository2;
    }

    /* access modifiers changed from: private */
    public final Object updateAddress(Address address, Continuation<? super Unit> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        if (ITalabatExperiment.DefaultImpls.getBooleanVariant$default(this.talabatExperiments, TalabatExperimentConstants.CAN_USE_NEW_MICRO_SERVICE_FOR_ADDRESS_ACTIONS, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)) {
            this.customerAddressesRepository.updateAddress(address).doOnError(UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$updateAddress$2$1.INSTANCE).subscribe(new UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$updateAddress$2$2(safeContinuation), new UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$updateAddress$2$3(safeContinuation));
        } else {
            this.updateAddressApi.invoke(address);
            Result.Companion companion = Result.Companion;
            safeContinuation.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    private final void updateValuesInSharedPreference(Address address) {
        SharedPreferences.Editor edit = this.context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        Intrinsics.checkNotNullExpressionValue(edit, "context.getSharedPrefere…_PRIVATE\n        ).edit()");
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, address.areaId);
        edit.putString(GlobalConstants.PrefsConstants.AREA_NAME, address.areaName);
        edit.putInt(GlobalConstants.PrefsConstants.CITY_ID, address.cityId);
        edit.apply();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object updateAreaOfSelectedAddressIfChanged(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r1 instanceof com.talabat.location.area.domain.usecases.impl.UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$updateAreaOfSelectedAddressIfChanged$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.talabat.location.area.domain.usecases.impl.UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$updateAreaOfSelectedAddressIfChanged$1 r2 = (com.talabat.location.area.domain.usecases.impl.UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$updateAreaOfSelectedAddressIfChanged$1) r2
            int r3 = r2.f61038l
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f61038l = r3
            goto L_0x001c
        L_0x0017:
            com.talabat.location.area.domain.usecases.impl.UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$updateAreaOfSelectedAddressIfChanged$1 r2 = new com.talabat.location.area.domain.usecases.impl.UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$updateAreaOfSelectedAddressIfChanged$1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f61036j
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.f61038l
            r10 = 2
            r12 = 1
            if (r3 == 0) goto L_0x004d
            if (r3 == r12) goto L_0x0041
            if (r3 != r10) goto L_0x0039
            java.lang.Object r3 = r2.f61035i
            com.talabat.domain.address.Address r3 = (com.talabat.domain.address.Address) r3
            java.lang.Object r2 = r2.f61034h
            com.talabat.location.area.domain.usecases.impl.UpdateAreaOfSelectedAddressIfChangedUseCaseImpl r2 = (com.talabat.location.area.domain.usecases.impl.UpdateAreaOfSelectedAddressIfChangedUseCaseImpl) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00ce
        L_0x0039:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0041:
            java.lang.Object r3 = r2.f61035i
            com.talabat.domain.address.Address r3 = (com.talabat.domain.address.Address) r3
            java.lang.Object r4 = r2.f61034h
            com.talabat.location.area.domain.usecases.impl.UpdateAreaOfSelectedAddressIfChangedUseCaseImpl r4 = (com.talabat.location.area.domain.usecases.impl.UpdateAreaOfSelectedAddressIfChangedUseCaseImpl) r4
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x008f
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.functions.Function0<java.lang.Boolean> r1 = r0.isExperimentActiveProvider
            java.lang.Object r1 = r1.invoke()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            buisnessmodels.Customer r3 = r0.customer
            boolean r3 = r3.isLoggedIn()
            buisnessmodels.Customer r4 = r0.customer
            com.talabat.domain.address.Address r13 = r4.getSelectedCustomerAddress()
            if (r1 == 0) goto L_0x0074
            if (r3 == 0) goto L_0x0074
            buisnessmodels.Customer r1 = r0.customer
            boolean r1 = r1.shouldCheckForAreaSplit
            if (r1 == 0) goto L_0x0074
            r1 = r12
            goto L_0x0075
        L_0x0074:
            r1 = 0
        L_0x0075:
            if (r1 == 0) goto L_0x00d7
            if (r13 == 0) goto L_0x00d7
            com.talabat.location.area.domain.repository.AreaRepository r3 = r0.areaRepository
            double r4 = r13.latitude
            double r6 = r13.longitude
            r2.f61034h = r0
            r2.f61035i = r13
            r2.f61038l = r12
            r8 = r2
            java.lang.Object r1 = r3.getAreaFor(r4, r6, r8)
            if (r1 != r9) goto L_0x008d
            return r9
        L_0x008d:
            r4 = r0
            r3 = r13
        L_0x008f:
            com.talabat.location.area.domain.repository.Area r1 = (com.talabat.location.area.domain.repository.Area) r1
            long r5 = r1.component1()
            java.lang.String r7 = r1.component2()
            long r13 = r1.component3()
            r15 = 0
            int r1 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1))
            if (r1 <= 0) goto L_0x00ac
            int r1 = r3.areaId
            long r11 = (long) r1
            int r1 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x00ac
            r12 = 1
            goto L_0x00ad
        L_0x00ac:
            r12 = 0
        L_0x00ad:
            if (r12 == 0) goto L_0x00d2
            int r1 = (int) r5
            r3.areaId = r1
            r3.areaName = r7
            int r5 = (int) r13
            r3.cityId = r5
            buisnessmodels.Customer r5 = r4.customer
            android.content.Context r6 = r4.context
            java.lang.String r7 = r3.f58343id
            r5.setSelectedCustomerAddress(r6, r7, r1)
            r2.f61034h = r4
            r2.f61035i = r3
            r2.f61038l = r10
            java.lang.Object r1 = r4.updateAddress(r3, r2)
            if (r1 != r9) goto L_0x00cd
            return r9
        L_0x00cd:
            r2 = r4
        L_0x00ce:
            r2.updateValuesInSharedPreference(r3)
            r4 = r2
        L_0x00d2:
            buisnessmodels.Customer r1 = r4.customer
            r2 = 0
            r1.shouldCheckForAreaSplit = r2
        L_0x00d7:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.location.area.domain.usecases.impl.UpdateAreaOfSelectedAddressIfChangedUseCaseImpl.updateAreaOfSelectedAddressIfChanged(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UpdateAreaOfSelectedAddressIfChangedUseCaseImpl(android.content.Context r11, final com.talabat.configuration.discovery.AppVersionProvider r12, com.talabat.location.area.domain.repository.AreaRepository r13, kotlin.jvm.functions.Function0 r14, buisnessmodels.Customer r15, kotlin.jvm.functions.Function1 r16, com.talabat.core.experiment.domain.ITalabatExperiment r17, com.talabat.user.address.domain.repository.CustomerAddressesRepository r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r10 = this;
            r0 = r19 & 32
            if (r0 == 0) goto L_0x000c
            com.talabat.location.area.domain.usecases.impl.UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$1 r0 = new com.talabat.location.area.domain.usecases.impl.UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$1
            r3 = r12
            r0.<init>(r12)
            r7 = r0
            goto L_0x000f
        L_0x000c:
            r3 = r12
            r7 = r16
        L_0x000f:
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r8 = r17
            r9 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.location.area.domain.usecases.impl.UpdateAreaOfSelectedAddressIfChangedUseCaseImpl.<init>(android.content.Context, com.talabat.configuration.discovery.AppVersionProvider, com.talabat.location.area.domain.repository.AreaRepository, kotlin.jvm.functions.Function0, buisnessmodels.Customer, kotlin.jvm.functions.Function1, com.talabat.core.experiment.domain.ITalabatExperiment, com.talabat.user.address.domain.repository.CustomerAddressesRepository, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
