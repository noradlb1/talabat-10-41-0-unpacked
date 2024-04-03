package com.braze.ui.contentcards;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.braze.ui.contentcards.ContentCardsFragment$contentCardsUpdate$5", f = "ContentCardsFragment.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
public final class ContentCardsFragment$contentCardsUpdate$5 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f44054h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ContentCardsFragment f44055i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContentCardsFragment$contentCardsUpdate$5(ContentCardsFragment contentCardsFragment, Continuation<? super ContentCardsFragment$contentCardsUpdate$5> continuation) {
        super(1, continuation);
        this.f44055i = contentCardsFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new ContentCardsFragment$contentCardsUpdate$5(this.f44055i, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((ContentCardsFragment$contentCardsUpdate$5) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f44054h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ContentCardsFragment contentCardsFragment = this.f44055i;
            this.f44054h = 1;
            if (contentCardsFragment.networkUnavailable(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
