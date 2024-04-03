package com.talabat.userandlocation.compliance.status.domain.usecase.business.impl;

import com.designsystem.ds_input_field.DateInputField;
import com.talabat.application.device.id.domain.DeviceIdProvider;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository;
import com.talabat.userandlocation.compliance.status.domain.usecase.business.CheckUserIsAllowedToOrderUseCase;
import datamodels.CustomerInfo;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ9\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J1\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ1\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/impl/CheckUserIsAllowedToOrderUseCaseImpl;", "Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase;", "userStatusRepository", "Lcom/talabat/userandlocation/compliance/status/domain/repository/UserStatusRepository;", "customerRepository", "Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "customerInfoProvider", "Lkotlin/Function0;", "Ldatamodels/CustomerInfo;", "deviceIdProvider", "Lcom/talabat/application/device/id/domain/DeviceIdProvider;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/userandlocation/compliance/status/domain/repository/UserStatusRepository;Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;Lcom/talabat/configuration/ConfigurationLocalRepository;Lkotlin/jvm/functions/Function0;Lcom/talabat/application/device/id/domain/DeviceIdProvider;Lkotlinx/coroutines/CoroutineDispatcher;)V", "checkStatusOfUser", "Lcom/talabat/userandlocation/compliance/status/domain/repository/UserStatusRepository$Status;", "durationStatusIsAllowedToCheck", "", "firstName", "", "lastName", "dateOfBirth", "isAfterUpdatingUserInfo", "", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formatToServerTime", "getStatusOfUser", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUserAllowedToOrder", "Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase$Result;", "setStatusIsNotAllowedToBeCheckedAgain", "", "statusOfUser", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckUserIsAllowedToOrderUseCaseImpl implements CheckUserIsAllowedToOrderUseCase {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<CustomerInfo> customerInfoProvider;
    @NotNull
    private final CustomerRepository customerRepository;
    @NotNull
    private final DeviceIdProvider deviceIdProvider;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    @NotNull
    private final UserStatusRepository userStatusRepository;

    public CheckUserIsAllowedToOrderUseCaseImpl(@NotNull UserStatusRepository userStatusRepository2, @NotNull CustomerRepository customerRepository2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull Function0<? extends CustomerInfo> function0, @NotNull DeviceIdProvider deviceIdProvider2, @NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(userStatusRepository2, "userStatusRepository");
        Intrinsics.checkNotNullParameter(customerRepository2, "customerRepository");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(function0, "customerInfoProvider");
        Intrinsics.checkNotNullParameter(deviceIdProvider2, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.userStatusRepository = userStatusRepository2;
        this.customerRepository = customerRepository2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.customerInfoProvider = function0;
        this.deviceIdProvider = deviceIdProvider2;
        this.dispatcher = coroutineDispatcher;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object checkStatusOfUser(long r8, java.lang.String r10, java.lang.String r11, java.lang.String r12, boolean r13, kotlin.coroutines.Continuation<? super com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository.Status> r14) {
        /*
            r7 = this;
            boolean r0 = r14 instanceof com.talabat.userandlocation.compliance.status.domain.usecase.business.impl.CheckUserIsAllowedToOrderUseCaseImpl$checkStatusOfUser$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.talabat.userandlocation.compliance.status.domain.usecase.business.impl.CheckUserIsAllowedToOrderUseCaseImpl$checkStatusOfUser$1 r0 = (com.talabat.userandlocation.compliance.status.domain.usecase.business.impl.CheckUserIsAllowedToOrderUseCaseImpl$checkStatusOfUser$1) r0
            int r1 = r0.f12282j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12282j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.compliance.status.domain.usecase.business.impl.CheckUserIsAllowedToOrderUseCaseImpl$checkStatusOfUser$1 r0 = new com.talabat.userandlocation.compliance.status.domain.usecase.business.impl.CheckUserIsAllowedToOrderUseCaseImpl$checkStatusOfUser$1
            r0.<init>(r7, r14)
        L_0x0018:
            r6 = r0
            java.lang.Object r14 = r6.f12280h
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f12282j
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x005c }
            goto L_0x0052
        L_0x002a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.Result$Companion r14 = kotlin.Result.Companion     // Catch:{ all -> 0x005c }
            com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository r14 = r7.userStatusRepository     // Catch:{ all -> 0x005c }
            boolean r8 = r14.isAllowedToCheckStatusOfUser(r8)     // Catch:{ all -> 0x005c }
            if (r8 == 0) goto L_0x0055
            if (r13 == 0) goto L_0x0043
            r5 = r2
            goto L_0x0045
        L_0x0043:
            r8 = 0
            r5 = r8
        L_0x0045:
            r6.f12282j = r2     // Catch:{ all -> 0x005c }
            r1 = r7
            r2 = r10
            r3 = r11
            r4 = r12
            java.lang.Object r14 = r1.getStatusOfUser(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x005c }
            if (r14 != r0) goto L_0x0052
            return r0
        L_0x0052:
            com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository$Status r14 = (com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository.Status) r14     // Catch:{ all -> 0x005c }
            goto L_0x0057
        L_0x0055:
            com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository$Status r14 = com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository.Status.PASS     // Catch:{ all -> 0x005c }
        L_0x0057:
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r14)     // Catch:{ all -> 0x005c }
            goto L_0x0067
        L_0x005c:
            r8 = move-exception
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)
        L_0x0067:
            java.lang.Throwable r9 = kotlin.Result.m6332exceptionOrNullimpl(r8)
            if (r9 != 0) goto L_0x006e
            goto L_0x0073
        L_0x006e:
            com.talabat.talabatcore.logger.LogManager.logException(r9)
            com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository$Status r8 = com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository.Status.ERROR
        L_0x0073:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.compliance.status.domain.usecase.business.impl.CheckUserIsAllowedToOrderUseCaseImpl.checkStatusOfUser(long, java.lang.String, java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String formatToServerTime(String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(new SimpleDateFormat(DateInputField.DefaultDateFormat, Locale.getDefault()).parse(str)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        if (r02 != null) {
            LogManager.logException(r02);
            obj = "";
        }
        return (String) obj;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getStatusOfUser(java.lang.String r14, java.lang.String r15, java.lang.String r16, boolean r17, kotlin.coroutines.Continuation<? super com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository.Status> r18) {
        /*
            r13 = this;
            r0 = r13
            r1 = r18
            boolean r2 = r1 instanceof com.talabat.userandlocation.compliance.status.domain.usecase.business.impl.CheckUserIsAllowedToOrderUseCaseImpl$getStatusOfUser$1
            if (r2 == 0) goto L_0x0016
            r2 = r1
            com.talabat.userandlocation.compliance.status.domain.usecase.business.impl.CheckUserIsAllowedToOrderUseCaseImpl$getStatusOfUser$1 r2 = (com.talabat.userandlocation.compliance.status.domain.usecase.business.impl.CheckUserIsAllowedToOrderUseCaseImpl$getStatusOfUser$1) r2
            int r3 = r2.f12285j
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0016
            int r3 = r3 - r4
            r2.f12285j = r3
            goto L_0x001b
        L_0x0016:
            com.talabat.userandlocation.compliance.status.domain.usecase.business.impl.CheckUserIsAllowedToOrderUseCaseImpl$getStatusOfUser$1 r2 = new com.talabat.userandlocation.compliance.status.domain.usecase.business.impl.CheckUserIsAllowedToOrderUseCaseImpl$getStatusOfUser$1
            r2.<init>(r13, r1)
        L_0x001b:
            r12 = r2
            java.lang.Object r1 = r12.f12283h
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r12.f12285j
            r4 = 1
            if (r3 == 0) goto L_0x0035
            if (r3 != r4) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0079
        L_0x002d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r1)
            library.talabat.mvp.login.domain.repository.CustomerRepository r1 = r0.customerRepository
            boolean r1 = r1.isLoggedIn()
            if (r1 != 0) goto L_0x0043
            com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository$Status r1 = com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository.Status.FAIL
            goto L_0x007b
        L_0x0043:
            com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository r3 = r0.userStatusRepository
            com.talabat.configuration.ConfigurationLocalRepository r1 = r0.configurationLocalRepository
            com.talabat.configuration.country.Country r1 = r1.selectedCountry()
            int r1 = r1.getCountryId()
            kotlin.jvm.functions.Function0<datamodels.CustomerInfo> r5 = r0.customerInfoProvider
            java.lang.Object r5 = r5.invoke()
            datamodels.CustomerInfo r5 = (datamodels.CustomerInfo) r5
            if (r5 == 0) goto L_0x005c
            int r5 = r5.f13850id
            goto L_0x005d
        L_0x005c:
            r5 = -1
        L_0x005d:
            r6 = r16
            java.lang.String r8 = r13.formatToServerTime(r6)
            com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository$Type r9 = com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository.Type.CHECKOUT_PLACEMENT
            com.talabat.application.device.id.domain.DeviceIdProvider r6 = r0.deviceIdProvider
            java.lang.String r11 = r6.getId()
            r12.f12285j = r4
            r4 = r1
            r6 = r14
            r7 = r15
            r10 = r17
            java.lang.Object r1 = r3.getStatusOfUser(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            if (r1 != r2) goto L_0x0079
            return r2
        L_0x0079:
            com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository$Status r1 = (com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository.Status) r1
        L_0x007b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.compliance.status.domain.usecase.business.impl.CheckUserIsAllowedToOrderUseCaseImpl.getStatusOfUser(java.lang.String, java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void setStatusIsNotAllowedToBeCheckedAgain(UserStatusRepository.Status status, long j11) {
        if (status == UserStatusRepository.Status.PASS) {
            this.userStatusRepository.setStatusIsNotAllowedToCheckFor(j11);
        }
    }

    @Nullable
    public Object isUserAllowedToOrder(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z11, @NotNull Continuation<? super CheckUserIsAllowedToOrderUseCase.Result> continuation) {
        return BuildersKt.withContext(this.dispatcher, new CheckUserIsAllowedToOrderUseCaseImpl$isUserAllowedToOrder$2(this, str, str2, str3, z11, (Continuation<? super CheckUserIsAllowedToOrderUseCaseImpl$isUserAllowedToOrder$2>) null), continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckUserIsAllowedToOrderUseCaseImpl(UserStatusRepository userStatusRepository2, CustomerRepository customerRepository2, ConfigurationLocalRepository configurationLocalRepository2, Function0 function0, DeviceIdProvider deviceIdProvider2, CoroutineDispatcher coroutineDispatcher, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(userStatusRepository2, customerRepository2, configurationLocalRepository2, (i11 & 8) != 0 ? AnonymousClass1.INSTANCE : function0, deviceIdProvider2, (i11 & 32) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}
