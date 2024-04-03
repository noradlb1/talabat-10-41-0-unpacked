package com.deliveryhero.chatui.view.chatroom;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatFragment$observeUIEvents$1", f = "ChatFragment.kt", i = {}, l = {432}, m = "invokeSuspend", n = {}, s = {})
public final class ChatFragment$observeUIEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29466h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f29467i;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatFragment$observeUIEvents$1$1", f = "ChatFragment.kt", i = {}, l = {433}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.deliveryhero.chatui.view.chatroom.ChatFragment$observeUIEvents$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f29468h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(chatFragment, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f29468h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow<UIEvent> chatUIEvents = chatFragment.getViewModel().getChatUIEvents();
                final ChatFragment chatFragment = chatFragment;
                AnonymousClass1 r12 = new Function2<UIEvent, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {

                    /* renamed from: h  reason: collision with root package name */
                    public int f29470h;

                    /* renamed from: i  reason: collision with root package name */
                    public /* synthetic */ Object f29471i;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        AnonymousClass1 r02 = 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public ChatFragment$observeUIEvents$1(ChatFragment chatFragment, Continuation<? super ChatFragment$observeUIEvents$1> continuation) {
                            super(2, continuation);
                            this.f29467i = chatFragment;
                        }

                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            return new ChatFragment$observeUIEvents$1(this.f29467i, continuation);
                        }

                        @Nullable
                        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                            return ((ChatFragment$observeUIEvents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i11 = this.f29466h;
                            if (i11 == 0) {
                                ResultKt.throwOnFailure(obj);
                                final ChatFragment chatFragment = this.f29467i;
                                Lifecycle.State state = Lifecycle.State.CREATED;
                                AnonymousClass1 r32 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
                                this.f29466h = 1;
                                if (RepeatOnLifecycleKt.repeatOnLifecycle((LifecycleOwner) chatFragment, state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) r32, (Continuation<? super Unit>) this) == coroutine_suspended) {
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
