package com.talabat.splash.domain.usecase;

import com.talabat.splash.core.exception.Failure;
import com.talabat.splash.core.functional.Either;
import com.talabat.splash.domain.model.AppInfoRequestModel;
import com.talabat.splash.domain.model.ScreenInfoWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/splash/core/functional/Either;", "Lcom/talabat/splash/core/exception/Failure;", "Lcom/talabat/splash/domain/model/ScreenInfoWrapper;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.splash.domain.usecase.GetAppInfoUseCase$getAppInfoAndCustomerInfo$2", f = "GetAppInfoUseCase.kt", i = {0, 0, 1, 1, 2, 3}, l = {64, 69, 78, 90, 91}, m = "invokeSuspend", n = {"$this$coroutineScope", "customerInfoAsync", "$this$coroutineScope", "appInfoResponse", "appInfoResponse", "appInfoResponseWrapper"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$0"})
public final class GetAppInfoUseCase$getAppInfoAndCustomerInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends Failure, ? extends ScreenInfoWrapper>>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f61468h;

    /* renamed from: i  reason: collision with root package name */
    public int f61469i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetAppInfoUseCase f61470j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ AppInfoRequestModel f61471k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetAppInfoUseCase$getAppInfoAndCustomerInfo$2(GetAppInfoUseCase getAppInfoUseCase, AppInfoRequestModel appInfoRequestModel, Continuation<? super GetAppInfoUseCase$getAppInfoAndCustomerInfo$2> continuation) {
        super(2, continuation);
        this.f61470j = getAppInfoUseCase;
        this.f61471k = appInfoRequestModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GetAppInfoUseCase$getAppInfoAndCustomerInfo$2 getAppInfoUseCase$getAppInfoAndCustomerInfo$2 = new GetAppInfoUseCase$getAppInfoAndCustomerInfo$2(this.f61470j, this.f61471k, continuation);
        getAppInfoUseCase$getAppInfoAndCustomerInfo$2.L$0 = obj;
        return getAppInfoUseCase$getAppInfoAndCustomerInfo$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Either<? extends Failure, ScreenInfoWrapper>> continuation) {
        return ((GetAppInfoUseCase$getAppInfoAndCustomerInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v47, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: kotlinx.coroutines.CoroutineScope} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v53, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: kotlinx.coroutines.Deferred} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: kotlinx.coroutines.CoroutineScope} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v57, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: kotlinx.coroutines.CoroutineScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0125 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0199 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r19) {
        /*
            r18 = this;
            r1 = r18
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.f61469i
            java.lang.String r3 = "Couldn't fetch CustomerInfo"
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            if (r0 == 0) goto L_0x006e
            if (r0 == r8) goto L_0x005e
            if (r0 == r7) goto L_0x004a
            if (r0 == r6) goto L_0x003b
            if (r0 == r5) goto L_0x002b
            if (r0 != r4) goto L_0x0023
            kotlin.ResultKt.throwOnFailure(r19)
            r0 = r19
            goto L_0x019a
        L_0x0023:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x002b:
            java.lang.Object r0 = r1.f61468h
            library.talabat.mvp.login.domain.repository.CustomerRepository r0 = (library.talabat.mvp.login.domain.repository.CustomerRepository) r0
            java.lang.Object r3 = r1.L$0
            com.talabat.splash.domain.model.AppInfoResponseWrapper r3 = (com.talabat.splash.domain.model.AppInfoResponseWrapper) r3
            kotlin.ResultKt.throwOnFailure(r19)
            r6 = r0
            r0 = r19
            goto L_0x0186
        L_0x003b:
            java.lang.Object r0 = r1.L$0
            r6 = r0
            com.talabat.splash.core.functional.Either r6 = (com.talabat.splash.core.functional.Either) r6
            kotlin.ResultKt.throwOnFailure(r19)     // Catch:{ all -> 0x0047 }
            r0 = r19
            goto L_0x0127
        L_0x0047:
            r0 = move-exception
            goto L_0x0130
        L_0x004a:
            java.lang.Object r0 = r1.f61468h
            r10 = r0
            com.talabat.splash.core.functional.Either r10 = (com.talabat.splash.core.functional.Either) r10
            java.lang.Object r0 = r1.L$0
            r11 = r0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            kotlin.ResultKt.throwOnFailure(r19)     // Catch:{ all -> 0x005b }
            r0 = r19
            goto L_0x00da
        L_0x005b:
            r0 = move-exception
            goto L_0x00e3
        L_0x005e:
            java.lang.Object r0 = r1.f61468h
            r10 = r0
            kotlinx.coroutines.Deferred r10 = (kotlinx.coroutines.Deferred) r10
            java.lang.Object r0 = r1.L$0
            r11 = r0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            kotlin.ResultKt.throwOnFailure(r19)     // Catch:{ all -> 0x00ab }
            r0 = r19
            goto L_0x00a4
        L_0x006e:
            kotlin.ResultKt.throwOnFailure(r19)
            java.lang.Object r0 = r1.L$0
            r11 = r0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            com.talabat.splash.domain.usecase.GetAppInfoUseCase r0 = r1.f61470j
            com.talabat.splash.domain.model.AppInfoRequestModel r12 = r1.f61471k
            r13 = 0
            r14 = 0
            r15 = 1
            r16 = 3
            r17 = 0
            com.talabat.splash.domain.model.AppInfoRequestModel r10 = com.talabat.splash.domain.model.AppInfoRequestModel.copy$default(r12, r13, r14, r15, r16, r17)
            kotlinx.coroutines.Deferred r0 = r0.getAppInfoAsync(r11, r10)
            com.talabat.splash.domain.usecase.GetAppInfoUseCase r10 = r1.f61470j
            com.talabat.splash.domain.model.AppInfoRequestModel r12 = r1.f61471k
            int r12 = r12.getCountryId()
            kotlinx.coroutines.Deferred r10 = r10.getCustomerInfoAsync(r11, r12)
            kotlin.Result$Companion r12 = kotlin.Result.Companion     // Catch:{ all -> 0x00ab }
            r1.L$0 = r11     // Catch:{ all -> 0x00ab }
            r1.f61468h = r10     // Catch:{ all -> 0x00ab }
            r1.f61469i = r8     // Catch:{ all -> 0x00ab }
            java.lang.Object r0 = r0.await(r1)     // Catch:{ all -> 0x00ab }
            if (r0 != r2) goto L_0x00a4
            return r2
        L_0x00a4:
            com.talabat.splash.core.functional.Either r0 = (com.talabat.splash.core.functional.Either) r0     // Catch:{ all -> 0x00ab }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x00ab }
            goto L_0x00b6
        L_0x00ab:
            r0 = move-exception
            kotlin.Result$Companion r12 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x00b6:
            java.lang.Throwable r12 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            if (r12 != 0) goto L_0x00bd
            goto L_0x00c9
        L_0x00bd:
            java.lang.String r0 = "Couldn't get AppInfo"
            com.talabat.talabatcore.logger.LogManager.error(r12, r0)
            com.talabat.splash.core.functional.Either$Left r0 = new com.talabat.splash.core.functional.Either$Left
            com.talabat.splash.core.exception.Failure$UnKnownError r12 = com.talabat.splash.core.exception.Failure.UnKnownError.INSTANCE
            r0.<init>(r12)
        L_0x00c9:
            r12 = r0
            com.talabat.splash.core.functional.Either r12 = (com.talabat.splash.core.functional.Either) r12
            r1.L$0 = r11     // Catch:{ all -> 0x00e1 }
            r1.f61468h = r12     // Catch:{ all -> 0x00e1 }
            r1.f61469i = r7     // Catch:{ all -> 0x00e1 }
            java.lang.Object r0 = r10.await(r1)     // Catch:{ all -> 0x00e1 }
            if (r0 != r2) goto L_0x00d9
            return r2
        L_0x00d9:
            r10 = r12
        L_0x00da:
            datamodels.CustomerInfo r0 = (datamodels.CustomerInfo) r0     // Catch:{ all -> 0x005b }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x005b }
            goto L_0x00ed
        L_0x00e1:
            r0 = move-exception
            r10 = r12
        L_0x00e3:
            kotlin.Result$Companion r12 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x00ed:
            com.talabat.splash.domain.usecase.GetAppInfoUseCase r12 = r1.f61470j
            java.lang.Throwable r13 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            if (r13 != 0) goto L_0x00f6
            goto L_0x00fd
        L_0x00f6:
            com.talabat.talabatcore.logger.LogManager.error(r13, r3)
            r12.trackCustomerInfoReturnedNull(r8, r13)
            r0 = r9
        L_0x00fd:
            datamodels.CustomerInfo r0 = (datamodels.CustomerInfo) r0
            if (r0 != 0) goto L_0x014d
            com.talabat.splash.domain.usecase.GetAppInfoUseCase r8 = r1.f61470j
            library.talabat.mvp.login.domain.repository.CustomerRepository r8 = r8.customerRepository
            boolean r8 = r8.isLoggedIn()
            if (r8 == 0) goto L_0x014d
            com.talabat.splash.domain.usecase.GetAppInfoUseCase r0 = r1.f61470j
            com.talabat.splash.domain.model.AppInfoRequestModel r8 = r1.f61471k
            int r8 = r8.getCountryId()     // Catch:{ all -> 0x012e }
            kotlinx.coroutines.Deferred r0 = r0.getCustomerInfoAsync(r11, r8)     // Catch:{ all -> 0x012e }
            r1.L$0 = r10     // Catch:{ all -> 0x012e }
            r1.f61468h = r9     // Catch:{ all -> 0x012e }
            r1.f61469i = r6     // Catch:{ all -> 0x012e }
            java.lang.Object r0 = r0.await(r1)     // Catch:{ all -> 0x012e }
            if (r0 != r2) goto L_0x0126
            return r2
        L_0x0126:
            r6 = r10
        L_0x0127:
            datamodels.CustomerInfo r0 = (datamodels.CustomerInfo) r0     // Catch:{ all -> 0x0047 }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x0047 }
            goto L_0x013a
        L_0x012e:
            r0 = move-exception
            r6 = r10
        L_0x0130:
            kotlin.Result$Companion r8 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x013a:
            r10 = r6
            com.talabat.splash.domain.usecase.GetAppInfoUseCase r6 = r1.f61470j
            java.lang.Throwable r8 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            if (r8 != 0) goto L_0x0144
            goto L_0x014b
        L_0x0144:
            r6.trackCustomerInfoReturnedNull(r7, r8)
            com.talabat.talabatcore.logger.LogManager.error(r8, r3)
            r0 = r9
        L_0x014b:
            datamodels.CustomerInfo r0 = (datamodels.CustomerInfo) r0
        L_0x014d:
            if (r0 == 0) goto L_0x015e
            com.talabat.splash.domain.usecase.GetAppInfoUseCase r3 = r1.f61470j
            com.talabat.notifications.brazemigrator.BrazeUserMigrator r3 = r3.brazeMigrator
            int r6 = r0.f13850id
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r3.migrateLoggedInUser(r6)
        L_0x015e:
            boolean r3 = r10 instanceof com.talabat.splash.core.functional.Either.Left
            if (r3 == 0) goto L_0x0163
            goto L_0x019d
        L_0x0163:
            boolean r3 = r10 instanceof com.talabat.splash.core.functional.Either.Right
            if (r3 == 0) goto L_0x019e
            com.talabat.splash.core.functional.Either$Right r10 = (com.talabat.splash.core.functional.Either.Right) r10
            java.lang.Object r3 = r10.getB()
            com.talabat.splash.domain.model.AppInfoResponseWrapper r3 = (com.talabat.splash.domain.model.AppInfoResponseWrapper) r3
            com.talabat.splash.domain.usecase.GetAppInfoUseCase r6 = r1.f61470j
            library.talabat.mvp.login.domain.repository.CustomerRepository r6 = r6.customerRepository
            if (r0 != 0) goto L_0x0188
            com.talabat.splash.domain.usecase.GetAppInfoUseCase r0 = r1.f61470j
            r1.L$0 = r3
            r1.f61468h = r6
            r1.f61469i = r5
            java.lang.Object r0 = r0.getCachedCustomerInfo(r1)
            if (r0 != r2) goto L_0x0186
            return r2
        L_0x0186:
            datamodels.CustomerInfo r0 = (datamodels.CustomerInfo) r0
        L_0x0188:
            r6.saveCustomerInfo(r0)
            com.talabat.splash.domain.usecase.GetAppInfoUseCase r0 = r1.f61470j
            r1.L$0 = r9
            r1.f61468h = r9
            r1.f61469i = r4
            java.lang.Object r0 = r0.handleAppInfoResponseAndGetScreenRedirection(r3, r1)
            if (r0 != r2) goto L_0x019a
            return r2
        L_0x019a:
            r10 = r0
            com.talabat.splash.core.functional.Either r10 = (com.talabat.splash.core.functional.Either) r10
        L_0x019d:
            return r10
        L_0x019e:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.splash.domain.usecase.GetAppInfoUseCase$getAppInfoAndCustomerInfo$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
