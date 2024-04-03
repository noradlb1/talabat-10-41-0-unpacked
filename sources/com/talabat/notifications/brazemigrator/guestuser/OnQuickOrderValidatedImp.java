package com.talabat.notifications.brazemigrator.guestuser;

import JsonModels.Response.AddAddressRM;
import android.app.Application;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.notifications.brazemigrator.BrazeUserMigrator;
import com.talabat.notifications.brazemigrator.LoggedInUserMigrator;
import com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase;
import com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrator;
import datamodels.QuickOrderUserInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import library.talabat.mvp.quickorder.OnQuickOrderValidated;
import library.talabat.mvp.quickorder.QuickOrderListener;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/notifications/brazemigrator/guestuser/OnQuickOrderValidatedImp;", "Llibrary/talabat/mvp/quickorder/OnQuickOrderValidated;", "applicationContext", "Landroid/app/Application;", "brazeUserMigrator", "Lcom/talabat/notifications/brazemigrator/BrazeUserMigrator;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroid/app/Application;Lcom/talabat/notifications/brazemigrator/BrazeUserMigrator;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineScope;)V", "onResponse", "", "listener", "Llibrary/talabat/mvp/quickorder/QuickOrderListener;", "quickOrderUserInfo", "Ldatamodels/QuickOrderUserInfo;", "response", "LJsonModels/Response/AddAddressRM;", "com_talabat_notifications_notifications"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OnQuickOrderValidatedImp implements OnQuickOrderValidated {
    /* access modifiers changed from: private */
    @NotNull
    public final Application applicationContext;
    /* access modifiers changed from: private */
    @NotNull
    public final BrazeUserMigrator brazeUserMigrator;
    @NotNull
    private final CoroutineDispatcher mainDispatcher;
    @NotNull
    private final CoroutineScope scope;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OnQuickOrderValidatedImp(@NotNull Application application) {
        this(application, (BrazeUserMigrator) null, (CoroutineDispatcher) null, (CoroutineScope) null, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(application, "applicationContext");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OnQuickOrderValidatedImp(@NotNull Application application, @NotNull BrazeUserMigrator brazeUserMigrator2) {
        this(application, brazeUserMigrator2, (CoroutineDispatcher) null, (CoroutineScope) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(application, "applicationContext");
        Intrinsics.checkNotNullParameter(brazeUserMigrator2, "brazeUserMigrator");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OnQuickOrderValidatedImp(@NotNull Application application, @NotNull BrazeUserMigrator brazeUserMigrator2, @NotNull CoroutineDispatcher coroutineDispatcher) {
        this(application, brazeUserMigrator2, coroutineDispatcher, (CoroutineScope) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(application, "applicationContext");
        Intrinsics.checkNotNullParameter(brazeUserMigrator2, "brazeUserMigrator");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "mainDispatcher");
    }

    @JvmOverloads
    public OnQuickOrderValidatedImp(@NotNull Application application, @NotNull BrazeUserMigrator brazeUserMigrator2, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(application, "applicationContext");
        Intrinsics.checkNotNullParameter(brazeUserMigrator2, "brazeUserMigrator");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.applicationContext = application;
        this.brazeUserMigrator = brazeUserMigrator2;
        this.mainDispatcher = coroutineDispatcher;
        this.scope = coroutineScope;
    }

    public void onResponse(@NotNull QuickOrderListener quickOrderListener, @NotNull QuickOrderUserInfo quickOrderUserInfo, @NotNull AddAddressRM addAddressRM) {
        Intrinsics.checkNotNullParameter(quickOrderListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(quickOrderUserInfo, "quickOrderUserInfo");
        Intrinsics.checkNotNullParameter(addAddressRM, "response");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, this.mainDispatcher, (CoroutineStart) null, new OnQuickOrderValidatedImp$onResponse$1(this, quickOrderUserInfo, quickOrderListener, addAddressRM, (Continuation<? super OnQuickOrderValidatedImp$onResponse$1>) null), 2, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OnQuickOrderValidatedImp(Application application, BrazeUserMigrator brazeUserMigrator2, CoroutineDispatcher coroutineDispatcher, CoroutineScope coroutineScope, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, (i11 & 2) != 0 ? new BrazeUserMigrator(application, (LoggedInUserMigrator) null, (GuestUserMigrator) null, (GuestUserMigrationUseCase) null, 14, (DefaultConstructorMarker) null) : brazeUserMigrator2, (i11 & 4) != 0 ? Dispatchers.getIO() : coroutineDispatcher, (i11 & 8) != 0 ? GlobalScope.INSTANCE : coroutineScope);
    }
}
