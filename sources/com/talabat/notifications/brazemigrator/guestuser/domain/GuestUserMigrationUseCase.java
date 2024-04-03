package com.talabat.notifications.brazemigrator.guestuser.domain;

import android.app.Application;
import com.talabat.notifications.brazemigrator.guestuser.data.repository.GuestUserRepository;
import com.talabat.notifications.brazemigrator.guestuser.data.service.GuestUserHashService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ5\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/talabat/notifications/brazemigrator/guestuser/domain/GuestUserMigrationUseCase;", "", "applicationContext", "Landroid/app/Application;", "guestUserMigrator", "Lcom/talabat/notifications/brazemigrator/guestuser/domain/GuestUserMigrator;", "guestUserHashService", "Lcom/talabat/notifications/brazemigrator/guestuser/data/service/GuestUserHashService;", "guestUserRepository", "Lcom/talabat/notifications/brazemigrator/guestuser/data/repository/GuestUserRepository;", "guestUserHashUseCase", "Lcom/talabat/notifications/brazemigrator/guestuser/domain/GuestUserHashUseCase;", "(Landroid/app/Application;Lcom/talabat/notifications/brazemigrator/guestuser/domain/GuestUserMigrator;Lcom/talabat/notifications/brazemigrator/guestuser/data/service/GuestUserHashService;Lcom/talabat/notifications/brazemigrator/guestuser/data/repository/GuestUserRepository;Lcom/talabat/notifications/brazemigrator/guestuser/domain/GuestUserHashUseCase;)V", "migrateGuestUser", "", "guestUserRequestBody", "Lcom/talabat/notifications/brazemigrator/guestuser/model/GuestUserRequestBody;", "success", "Lkotlin/Function0;", "failure", "(Lcom/talabat/notifications/brazemigrator/guestuser/model/GuestUserRequestBody;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_notifications_notifications"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuestUserMigrationUseCase {
    @NotNull
    private Application applicationContext;
    @NotNull
    private final GuestUserHashService guestUserHashService;
    @NotNull
    private final GuestUserHashUseCase guestUserHashUseCase;
    @NotNull
    private GuestUserMigrator guestUserMigrator;
    @NotNull
    private final GuestUserRepository guestUserRepository;

    public GuestUserMigrationUseCase(@NotNull Application application, @NotNull GuestUserMigrator guestUserMigrator2, @NotNull GuestUserHashService guestUserHashService2, @NotNull GuestUserRepository guestUserRepository2, @NotNull GuestUserHashUseCase guestUserHashUseCase2) {
        Intrinsics.checkNotNullParameter(application, "applicationContext");
        Intrinsics.checkNotNullParameter(guestUserMigrator2, "guestUserMigrator");
        Intrinsics.checkNotNullParameter(guestUserHashService2, "guestUserHashService");
        Intrinsics.checkNotNullParameter(guestUserRepository2, "guestUserRepository");
        Intrinsics.checkNotNullParameter(guestUserHashUseCase2, "guestUserHashUseCase");
        this.applicationContext = application;
        this.guestUserMigrator = guestUserMigrator2;
        this.guestUserHashService = guestUserHashService2;
        this.guestUserRepository = guestUserRepository2;
        this.guestUserHashUseCase = guestUserHashUseCase2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: kotlin.jvm.functions.Function0<kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: kotlin.jvm.functions.Function0<kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object migrateGuestUser(@org.jetbrains.annotations.NotNull com.talabat.notifications.brazemigrator.guestuser.model.GuestUserRequestBody r6, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r7, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase$migrateGuestUser$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase$migrateGuestUser$1 r0 = (com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase$migrateGuestUser$1) r0
            int r1 = r0.f61091m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61091m = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase$migrateGuestUser$1 r0 = new com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase$migrateGuestUser$1
            r0.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f61089k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61091m
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x007a
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.f61088j
            r8 = r6
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            java.lang.Object r6 = r0.f61087i
            r7 = r6
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            java.lang.Object r6 = r0.f61086h
            com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase r6 = (com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005b
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r9)
            com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserHashUseCase r9 = r5.guestUserHashUseCase
            r0.f61086h = r5
            r0.f61087i = r7
            r0.f61088j = r8
            r0.f61091m = r4
            java.lang.Object r9 = r9.run((com.talabat.notifications.brazemigrator.guestuser.model.GuestUserRequestBody) r6, (kotlin.coroutines.Continuation<? super com.talabat.talabatcore.functional.Either<? extends com.talabat.talabatcore.exception.Failure, com.talabat.notifications.brazemigrator.guestuser.model.GuestUserResponseBody>>) r0)
            if (r9 != r1) goto L_0x005a
            return r1
        L_0x005a:
            r6 = r5
        L_0x005b:
            com.talabat.talabatcore.functional.Either r9 = (com.talabat.talabatcore.functional.Either) r9
            boolean r2 = r9 instanceof com.talabat.talabatcore.functional.Either.Left
            if (r2 == 0) goto L_0x007d
            kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getMain()
            com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase$migrateGuestUser$2 r7 = new com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase$migrateGuestUser$2
            r9 = 0
            r7.<init>(r8, r9)
            r0.f61086h = r9
            r0.f61087i = r9
            r0.f61088j = r9
            r0.f61091m = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r7, r0)
            if (r6 != r1) goto L_0x007a
            return r1
        L_0x007a:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x007d:
            boolean r8 = r9 instanceof com.talabat.talabatcore.functional.Either.Right
            if (r8 == 0) goto L_0x0095
            com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrator r6 = r6.guestUserMigrator
            com.talabat.talabatcore.functional.Either$Right r9 = (com.talabat.talabatcore.functional.Either.Right) r9
            java.lang.Object r8 = r9.getB()
            com.talabat.notifications.brazemigrator.guestuser.model.GuestUserResponseBody r8 = (com.talabat.notifications.brazemigrator.guestuser.model.GuestUserResponseBody) r8
            java.lang.String r8 = r8.getUserHashValue()
            r6.migrateGuestUser$com_talabat_notifications_notifications(r8)
            r7.invoke()
        L_0x0095:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase.migrateGuestUser(com.talabat.notifications.brazemigrator.guestuser.model.GuestUserRequestBody, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GuestUserMigrationUseCase(android.app.Application r8, com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrator r9, com.talabat.notifications.brazemigrator.guestuser.data.service.GuestUserHashService r10, com.talabat.notifications.brazemigrator.guestuser.data.repository.GuestUserRepository r11, com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserHashUseCase r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 4
            if (r14 == 0) goto L_0x000b
            com.talabat.notifications.brazemigrator.guestuser.data.service.GuestUserHashService r10 = new com.talabat.notifications.brazemigrator.guestuser.data.service.GuestUserHashService
            r14 = 1
            r0 = 0
            r10.<init>(r0, r14, r0)
        L_0x000b:
            r4 = r10
            r10 = r13 & 8
            if (r10 == 0) goto L_0x001a
            com.talabat.notifications.brazemigrator.guestuser.data.repository.GuestUserRepositoryImp r11 = new com.talabat.notifications.brazemigrator.guestuser.data.repository.GuestUserRepositoryImp
            com.talabat.talabatcore.platform.NetworkHandler r10 = new com.talabat.talabatcore.platform.NetworkHandler
            r10.<init>(r8)
            r11.<init>(r10, r4)
        L_0x001a:
            r5 = r11
            r10 = r13 & 16
            if (r10 == 0) goto L_0x002a
            com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserHashUseCase r12 = new com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserHashUseCase
            kotlinx.coroutines.GlobalScope r10 = kotlinx.coroutines.GlobalScope.INSTANCE
            kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getMain()
            r12.<init>(r5, r10, r11)
        L_0x002a:
            r6 = r12
            r1 = r7
            r2 = r8
            r3 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase.<init>(android.app.Application, com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrator, com.talabat.notifications.brazemigrator.guestuser.data.service.GuestUserHashService, com.talabat.notifications.brazemigrator.guestuser.data.repository.GuestUserRepository, com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserHashUseCase, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
