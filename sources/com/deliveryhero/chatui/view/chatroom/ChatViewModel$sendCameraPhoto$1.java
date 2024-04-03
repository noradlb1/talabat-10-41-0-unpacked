package com.deliveryhero.chatui.view.chatroom;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModel$sendCameraPhoto$1", f = "ChatViewModel.kt", i = {}, l = {528}, m = "invokeSuspend", n = {}, s = {})
public final class ChatViewModel$sendCameraPhoto$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29554h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29555i;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModel$sendCameraPhoto$1$1", f = "ChatViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.deliveryhero.chatui.view.chatroom.ChatViewModel$sendCameraPhoto$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f29556h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(chatViewModel, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f29556h == 0) {
                ResultKt.throwOnFailure(obj);
                chatViewModel.uploadCameraImage();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatViewModel$sendCameraPhoto$1(ChatViewModel chatViewModel, Continuation<? super ChatViewModel$sendCameraPhoto$1> continuation) {
        super(2, continuation);
        this.f29555i = chatViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChatViewModel$sendCameraPhoto$1(this.f29555i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChatViewModel$sendCameraPhoto$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29554h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io2 = this.f29555i.dispatcher.io();
            final ChatViewModel chatViewModel = this.f29555i;
            AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f29554h = 1;
            if (BuildersKt.withContext(io2, r12, this) == coroutine_suspended) {
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
