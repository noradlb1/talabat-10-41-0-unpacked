package com.talabat.notifications.brazemigrator.guestuser.domain;

import com.talabat.observability.ObservabilityManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase$migrateGuestUser$2", f = "GuestUserMigrationUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GuestUserMigrationUseCase$migrateGuestUser$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61092h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f61093i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GuestUserMigrationUseCase$migrateGuestUser$2(Function0<Unit> function0, Continuation<? super GuestUserMigrationUseCase$migrateGuestUser$2> continuation) {
        super(2, continuation);
        this.f61093i = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuestUserMigrationUseCase$migrateGuestUser$2(this.f61093i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuestUserMigrationUseCase$migrateGuestUser$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f61092h == 0) {
            ResultKt.throwOnFailure(obj);
            ObservabilityManager.trackUnExpectedScenario$default("guest_user_hash_api_failure", (Map) null, 2, (Object) null);
            this.f61093i.invoke();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
