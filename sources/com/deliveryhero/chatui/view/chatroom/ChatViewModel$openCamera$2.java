package com.deliveryhero.chatui.view.chatroom;

import com.deliveryhero.chatui.domain.imageselection.usecase.GetCameraImageUriStatus;
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
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModel$openCamera$2", f = "ChatViewModel.kt", i = {}, l = {367}, m = "invokeSuspend", n = {}, s = {})
public final class ChatViewModel$openCamera$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29545h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29546i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetCameraImageUriStatus f29547j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatViewModel$openCamera$2(ChatViewModel chatViewModel, GetCameraImageUriStatus getCameraImageUriStatus, Continuation<? super ChatViewModel$openCamera$2> continuation) {
        super(2, continuation);
        this.f29546i = chatViewModel;
        this.f29547j = getCameraImageUriStatus;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChatViewModel$openCamera$2(this.f29546i, this.f29547j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChatViewModel$openCamera$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29545h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableSharedFlow access$get_openImageNavigator$p = this.f29546i._openImageNavigator;
            ImageSelectionType.CAMERA camera = new ImageSelectionType.CAMERA(((GetCameraImageUriStatus.Data) this.f29547j).getUri());
            this.f29545h = 1;
            if (access$get_openImageNavigator$p.emit(camera, this) == coroutine_suspended) {
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
