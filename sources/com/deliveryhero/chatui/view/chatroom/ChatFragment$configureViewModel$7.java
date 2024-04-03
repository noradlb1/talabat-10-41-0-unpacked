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
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatFragment$configureViewModel$7", f = "ChatFragment.kt", i = {}, l = {417}, m = "invokeSuspend", n = {}, s = {})
public final class ChatFragment$configureViewModel$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29455h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f29456i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionType;", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatFragment$configureViewModel$7$1", f = "ChatFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.deliveryhero.chatui.view.chatroom.ChatFragment$configureViewModel$7$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ImageSelectionType, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f29457h;

        /* renamed from: i  reason: collision with root package name */
        public /* synthetic */ Object f29458i;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(chatFragment, continuation);
            r02.f29458i = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull ImageSelectionType imageSelectionType, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(imageSelectionType, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f29457h == 0) {
                ResultKt.throwOnFailure(obj);
                ImageSelectionType imageSelectionType = (ImageSelectionType) this.f29458i;
                if (chatFragment.getPermissionModule().isPermissionsGrantRequired(chatFragment, imageSelectionType)) {
                    chatFragment.getPermissionModule().grantPermission(chatFragment, imageSelectionType);
                } else {
                    if (imageSelectionType instanceof ImageSelectionType.CAMERA) {
                        chatFragment.cameraImageUri = ((ImageSelectionType.CAMERA) imageSelectionType).getPhotoUri();
                    }
                    chatFragment.openImageSelector(imageSelectionType);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatFragment$configureViewModel$7(ChatFragment chatFragment, Continuation<? super ChatFragment$configureViewModel$7> continuation) {
        super(2, continuation);
        this.f29456i = chatFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChatFragment$configureViewModel$7(this.f29456i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChatFragment$configureViewModel$7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29455h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<ImageSelectionType> openImageNavigator = this.f29456i.getViewModel().getOpenImageNavigator();
            final ChatFragment chatFragment = this.f29456i;
            AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f29455h = 1;
            if (FlowKt.collectLatest(openImageNavigator, r12, this) == coroutine_suspended) {
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
