package com.deliveryhero.chatui.view.chatroom;

import androidx.lifecycle.ViewModelKt;
import com.deliveryhero.chatui.domain.UploadPhotoStatus;
import com.deliveryhero.chatui.view.chatroom.ImageMessage;
import com.deliveryhero.chatui.view.chatroom.UIEvent;
import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.Receipt;
import com.deliveryhero.customerchat.commons.TimeUtilKt;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.ImageMetadata;
import com.deliveryhero.customerchat.eventTracking.tracker.ImageEventsTracker;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "uploadPhotoStatus", "Lcom/deliveryhero/chatui/domain/UploadPhotoStatus;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatViewModel$invokeImageUploadUseCase$2 extends Lambda implements Function1<UploadPhotoStatus, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f29521g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29522h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatMessageViewModel f29523i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f29524j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f29525k;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModel$invokeImageUploadUseCase$2$1", f = "ChatViewModel.kt", i = {}, l = {589}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.deliveryhero.chatui.view.chatroom.ChatViewModel$invokeImageUploadUseCase$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f29526h;

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
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f29526h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                ImageEventsTracker imageEvents$customerchat_basicRelease = chatViewModel.getImageEvents$customerchat_basicRelease();
                EventMetadata eventMetadata$customerchat_basicRelease = chatViewModel.getEventMetadata$customerchat_basicRelease();
                if (eventMetadata$customerchat_basicRelease == null) {
                    return Unit.INSTANCE;
                }
                ImageMetadata access$getImageMetadata$p = chatViewModel.imageMetadata;
                this.f29526h = 1;
                if (imageEvents$customerchat_basicRelease.trackImageUploadedEvent(eventMetadata$customerchat_basicRelease, access$getImageMetadata$p, this) == coroutine_suspended) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatViewModel$invokeImageUploadUseCase$2(long j11, ChatViewModel chatViewModel, ChatMessageViewModel chatMessageViewModel, int i11, boolean z11) {
        super(1);
        this.f29521g = j11;
        this.f29522h = chatViewModel;
        this.f29523i = chatMessageViewModel;
        this.f29524j = i11;
        this.f29525k = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((UploadPhotoStatus) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull UploadPhotoStatus uploadPhotoStatus) {
        String str;
        UploadPhotoStatus uploadPhotoStatus2 = uploadPhotoStatus;
        Intrinsics.checkNotNullParameter(uploadPhotoStatus2, "uploadPhotoStatus");
        if (uploadPhotoStatus2 instanceof UploadPhotoStatus.Success) {
            long convertNanosToMillis = TimeUtilKt.convertNanosToMillis(System.nanoTime() - this.f29521g);
            ImageMetadata access$getImageMetadata$p = this.f29522h.imageMetadata;
            if (access$getImageMetadata$p != null) {
                access$getImageMetadata$p.setImageUploadDuration(String.valueOf(convertNanosToMillis));
            }
            CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this.f29522h);
            final ChatViewModel chatViewModel = this.f29522h;
            Job unused = BuildersKt__Builders_commonKt.launch$default(viewModelScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            ChatViewModel.a(this.f29522h, ((UploadPhotoStatus.Success) uploadPhotoStatus2).getFileMessage(), this.f29523i, (Throwable) null, 4, (Object) null);
        } else if (uploadPhotoStatus2 instanceof UploadPhotoStatus.Loading) {
            this.f29522h.scrollToBottom = true;
            this.f29522h.messages.put(Integer.valueOf(this.f29524j), this.f29523i);
            this.f29522h._messagesLiveData.postValue(CollectionsKt___CollectionsKt.toList(this.f29522h.messages.values()));
        } else if (uploadPhotoStatus2 instanceof UploadPhotoStatus.Error) {
            if (this.f29525k) {
                str = this.f29522h.getImagePathUseCase.getImageFromCamera();
            } else {
                str = this.f29522h.getImagePathUseCase.getSelectedGalleryImagePath();
            }
            UploadPhotoStatus.Error error = (UploadPhotoStatus.Error) uploadPhotoStatus2;
            this.f29522h.updateMessageFailure(error.getFileMessage(), ChatMessageViewModel.copy$default(this.f29523i, 0, (TextMessage) null, (TextMessage) null, new ImageMessage.UploadFailed(0, str, 1, (DefaultConstructorMarker) null), (LocationMessage) null, (String) null, false, (Receipt) null, (BaseMessage) null, (String) null, 1015, (Object) null), error.getError());
            this.f29522h._chatUIEvents.tryEmit(new UIEvent.ErrorMessage(error.getError().getMessage()));
        }
    }
}
