package com.deliveryhero.chatui.view.chatroom;

import com.deliveryhero.chatui.view.chatroom.navigator.ImageSelectionType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModel$openGallery$2", f = "ChatViewModel.kt", i = {}, l = {383}, m = "invokeSuspend", n = {}, s = {})
public final class ChatViewModel$openGallery$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29550h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29551i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatViewModel$openGallery$2(ChatViewModel chatViewModel, Continuation<? super ChatViewModel$openGallery$2> continuation) {
        super(2, continuation);
        this.f29551i = chatViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChatViewModel$openGallery$2(this.f29551i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChatViewModel$openGallery$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29550h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableSharedFlow access$get_openImageNavigator$p = this.f29551i._openImageNavigator;
            ImageSelectionType.GALLERY gallery = ImageSelectionType.GALLERY.INSTANCE;
            this.f29550h = 1;
            if (access$get_openImageNavigator$p.emit(gallery, this) == coroutine_suspended) {
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
