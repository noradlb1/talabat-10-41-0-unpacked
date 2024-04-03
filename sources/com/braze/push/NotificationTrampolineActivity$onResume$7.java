package com.braze.push;

import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.braze.push.NotificationTrampolineActivity$onResume$7", f = "NotificationTrampolineActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class NotificationTrampolineActivity$onResume$7 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f43869h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ NotificationTrampolineActivity f43870i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationTrampolineActivity$onResume$7(NotificationTrampolineActivity notificationTrampolineActivity, Continuation<? super NotificationTrampolineActivity$onResume$7> continuation) {
        super(1, continuation);
        this.f43870i = notificationTrampolineActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new NotificationTrampolineActivity$onResume$7(this.f43870i, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((NotificationTrampolineActivity$onResume$7) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f43869h == 0) {
            ResultKt.throwOnFailure(obj);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f43870i, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) AnonymousClass1.INSTANCE, 6, (Object) null);
            this.f43870i.finish();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
