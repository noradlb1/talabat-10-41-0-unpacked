package com.designsystem.ds_bottom_sheet_v2;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.designsystem.ds_bottom_sheet_v2.BottomSheet$launchDismissTimer$1", f = "BottomSheet.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
public final class BottomSheet$launchDismissTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f30594h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ BottomSheet f30595i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheet$launchDismissTimer$1(BottomSheet bottomSheet, Continuation<? super BottomSheet$launchDismissTimer$1> continuation) {
        super(2, continuation);
        this.f30595i = bottomSheet;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BottomSheet$launchDismissTimer$1(this.f30595i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BottomSheet$launchDismissTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f30594h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            long dismissAfter = this.f30595i.getDismissAfter();
            this.f30594h = 1;
            if (DelayKt.delay(dismissAfter, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f30595i.dismiss();
        return Unit.INSTANCE;
    }
}
