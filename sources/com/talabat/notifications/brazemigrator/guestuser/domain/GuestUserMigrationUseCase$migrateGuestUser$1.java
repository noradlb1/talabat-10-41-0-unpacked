package com.talabat.notifications.brazemigrator.guestuser.domain;

import com.talabat.notifications.brazemigrator.guestuser.model.GuestUserRequestBody;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase", f = "GuestUserMigrationUseCase.kt", i = {0, 0, 0}, l = {30, 32}, m = "migrateGuestUser", n = {"this", "success", "failure"}, s = {"L$0", "L$1", "L$2"})
public final class GuestUserMigrationUseCase$migrateGuestUser$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61086h;

    /* renamed from: i  reason: collision with root package name */
    public Object f61087i;

    /* renamed from: j  reason: collision with root package name */
    public Object f61088j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f61089k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ GuestUserMigrationUseCase f61090l;

    /* renamed from: m  reason: collision with root package name */
    public int f61091m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GuestUserMigrationUseCase$migrateGuestUser$1(GuestUserMigrationUseCase guestUserMigrationUseCase, Continuation<? super GuestUserMigrationUseCase$migrateGuestUser$1> continuation) {
        super(continuation);
        this.f61090l = guestUserMigrationUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61089k = obj;
        this.f61091m |= Integer.MIN_VALUE;
        return this.f61090l.migrateGuestUser((GuestUserRequestBody) null, (Function0<Unit>) null, (Function0<Unit>) null, this);
    }
}
