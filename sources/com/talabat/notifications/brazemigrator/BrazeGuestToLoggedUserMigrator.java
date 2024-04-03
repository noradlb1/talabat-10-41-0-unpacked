package com.talabat.notifications.brazemigrator;

import android.app.Application;
import com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase;
import com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/talabat/notifications/brazemigrator/BrazeGuestToLoggedUserMigrator;", "", "applicationContext", "Landroid/app/Application;", "migrator", "Lcom/talabat/notifications/brazemigrator/BrazeUserMigrator;", "(Landroid/app/Application;Lcom/talabat/notifications/brazemigrator/BrazeUserMigrator;)V", "getMigrator$com_talabat_notifications_notifications", "()Lcom/talabat/notifications/brazemigrator/BrazeUserMigrator;", "migrateGuestToLoggedInUser", "", "customerId", "", "com_talabat_notifications_notifications"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrazeGuestToLoggedUserMigrator {
    @NotNull
    private final Application applicationContext;
    @NotNull
    private final BrazeUserMigrator migrator;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BrazeGuestToLoggedUserMigrator(@NotNull Application application) {
        this(application, (BrazeUserMigrator) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(application, "applicationContext");
    }

    @JvmOverloads
    public BrazeGuestToLoggedUserMigrator(@NotNull Application application, @NotNull BrazeUserMigrator brazeUserMigrator) {
        Intrinsics.checkNotNullParameter(application, "applicationContext");
        Intrinsics.checkNotNullParameter(brazeUserMigrator, "migrator");
        this.applicationContext = application;
        this.migrator = brazeUserMigrator;
    }

    @NotNull
    public final BrazeUserMigrator getMigrator$com_talabat_notifications_notifications() {
        return this.migrator;
    }

    public final void migrateGuestToLoggedInUser(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "customerId");
        this.migrator.migrateLoggedInUser(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BrazeGuestToLoggedUserMigrator(Application application, BrazeUserMigrator brazeUserMigrator, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, (i11 & 2) != 0 ? new BrazeUserMigrator(application, (LoggedInUserMigrator) null, (GuestUserMigrator) null, (GuestUserMigrationUseCase) null, 14, (DefaultConstructorMarker) null) : brazeUserMigrator);
    }
}
