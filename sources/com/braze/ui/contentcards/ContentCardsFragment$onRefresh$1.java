package com.braze.ui.contentcards;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
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
@DebugMetadata(c = "com.braze.ui.contentcards.ContentCardsFragment$onRefresh$1", f = "ContentCardsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ContentCardsFragment$onRefresh$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f44059h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ContentCardsFragment f44060i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContentCardsFragment$onRefresh$1(ContentCardsFragment contentCardsFragment, Continuation<? super ContentCardsFragment$onRefresh$1> continuation) {
        super(1, continuation);
        this.f44060i = contentCardsFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new ContentCardsFragment$onRefresh$1(this.f44060i, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((ContentCardsFragment$onRefresh$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f44059h == 0) {
            ResultKt.throwOnFailure(obj);
            SwipeRefreshLayout contentCardsSwipeLayout = this.f44060i.getContentCardsSwipeLayout();
            if (contentCardsSwipeLayout != null) {
                contentCardsSwipeLayout.setRefreshing(false);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
