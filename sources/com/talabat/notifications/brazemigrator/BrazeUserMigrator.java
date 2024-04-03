package com.talabat.notifications.brazemigrator;

import android.app.Application;
import com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase;
import com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrator;
import com.talabat.notifications.brazemigrator.guestuser.model.GuestUserRequestBody;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ5\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/talabat/notifications/brazemigrator/BrazeUserMigrator;", "", "applicationContext", "Landroid/app/Application;", "logInUserMigrator", "Lcom/talabat/notifications/brazemigrator/LoggedInUserMigrator;", "guestUserMigrator", "Lcom/talabat/notifications/brazemigrator/guestuser/domain/GuestUserMigrator;", "guestUserMigrationUseCase", "Lcom/talabat/notifications/brazemigrator/guestuser/domain/GuestUserMigrationUseCase;", "(Landroid/app/Application;Lcom/talabat/notifications/brazemigrator/LoggedInUserMigrator;Lcom/talabat/notifications/brazemigrator/guestuser/domain/GuestUserMigrator;Lcom/talabat/notifications/brazemigrator/guestuser/domain/GuestUserMigrationUseCase;)V", "migrateGuestUser", "", "guestUserRequestBody", "Lcom/talabat/notifications/brazemigrator/guestuser/model/GuestUserRequestBody;", "success", "Lkotlin/Function0;", "failure", "(Lcom/talabat/notifications/brazemigrator/guestuser/model/GuestUserRequestBody;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migrateLoggedInUser", "customerId", "", "com_talabat_notifications_notifications"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrazeUserMigrator {
    @NotNull
    private final Application applicationContext;
    @NotNull
    private final GuestUserMigrationUseCase guestUserMigrationUseCase;
    @NotNull
    private final GuestUserMigrator guestUserMigrator;
    @NotNull
    private final LoggedInUserMigrator logInUserMigrator;

    public BrazeUserMigrator(@NotNull Application application, @NotNull LoggedInUserMigrator loggedInUserMigrator, @NotNull GuestUserMigrator guestUserMigrator2, @NotNull GuestUserMigrationUseCase guestUserMigrationUseCase2) {
        Intrinsics.checkNotNullParameter(application, "applicationContext");
        Intrinsics.checkNotNullParameter(loggedInUserMigrator, "logInUserMigrator");
        Intrinsics.checkNotNullParameter(guestUserMigrator2, "guestUserMigrator");
        Intrinsics.checkNotNullParameter(guestUserMigrationUseCase2, "guestUserMigrationUseCase");
        this.applicationContext = application;
        this.logInUserMigrator = loggedInUserMigrator;
        this.guestUserMigrator = guestUserMigrator2;
        this.guestUserMigrationUseCase = guestUserMigrationUseCase2;
    }

    @Nullable
    public final Object migrateGuestUser(@NotNull GuestUserRequestBody guestUserRequestBody, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull Continuation<? super Unit> continuation) {
        Object migrateGuestUser = this.guestUserMigrationUseCase.migrateGuestUser(guestUserRequestBody, function0, function02, continuation);
        return migrateGuestUser == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? migrateGuestUser : Unit.INSTANCE;
    }

    public final void migrateLoggedInUser(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "customerId");
        this.logInUserMigrator.migrateLoggedInUser$com_talabat_notifications_notifications(str);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BrazeUserMigrator(android.app.Application r13, com.talabat.notifications.brazemigrator.LoggedInUserMigrator r14, com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrator r15, com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r12 = this;
            r8 = r13
            r0 = r17 & 2
            java.lang.String r1 = "applicationContext\n     …PRIVATE\n                )"
            r2 = 0
            java.lang.String r3 = "talabat"
            if (r0 == 0) goto L_0x0023
            com.talabat.notifications.brazemigrator.LoggedInUserMigrator r0 = new com.talabat.notifications.brazemigrator.LoggedInUserMigrator
            android.content.SharedPreferences r4 = r13.getSharedPreferences(r3, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            com.talabat.notifications.brazewrapper.BrazeSdkWrapperImp r5 = new com.talabat.notifications.brazewrapper.BrazeSdkWrapperImp
            com.braze.Braze$Companion r6 = com.braze.Braze.Companion
            com.braze.Braze r6 = r6.getInstance(r13)
            r5.<init>(r6)
            r0.<init>(r4, r5)
            r9 = r0
            goto L_0x0024
        L_0x0023:
            r9 = r14
        L_0x0024:
            r0 = r17 & 4
            if (r0 == 0) goto L_0x0041
            com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrator r0 = new com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrator
            android.content.SharedPreferences r2 = r13.getSharedPreferences(r3, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            com.talabat.notifications.brazewrapper.BrazeSdkWrapperImp r1 = new com.talabat.notifications.brazewrapper.BrazeSdkWrapperImp
            com.braze.Braze$Companion r3 = com.braze.Braze.Companion
            com.braze.Braze r3 = r3.getInstance(r13)
            r1.<init>(r3)
            r0.<init>(r2, r1)
            r10 = r0
            goto L_0x0042
        L_0x0041:
            r10 = r15
        L_0x0042:
            r0 = r17 & 8
            if (r0 == 0) goto L_0x0056
            com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase r11 = new com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 28
            r7 = 0
            r0 = r11
            r1 = r13
            r2 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = r12
            goto L_0x0059
        L_0x0056:
            r0 = r12
            r11 = r16
        L_0x0059:
            r12.<init>(r13, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.notifications.brazemigrator.BrazeUserMigrator.<init>(android.app.Application, com.talabat.notifications.brazemigrator.LoggedInUserMigrator, com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrator, com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
