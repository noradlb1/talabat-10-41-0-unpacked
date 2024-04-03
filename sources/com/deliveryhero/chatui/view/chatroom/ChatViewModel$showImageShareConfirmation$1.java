package com.deliveryhero.chatui.view.chatroom;

import android.net.Uri;
import com.deliveryhero.chatui.domain.imageselection.UploadImageConfirmationDialog;
import com.deliveryhero.chatui.view.chatroom.navigator.ImageSelectionNavigatorImpl;
import com.deliveryhero.customerchat.eventTracking.data.ImageSource;
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
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModel$showImageShareConfirmation$1", f = "ChatViewModel.kt", i = {}, l = {454}, m = "invokeSuspend", n = {}, s = {})
public final class ChatViewModel$showImageShareConfirmation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29569h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29570i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f29571j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Uri f29572k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ UploadImageConfirmationDialog f29573l;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModel$showImageShareConfirmation$1$1", f = "ChatViewModel.kt", i = {0}, l = {467}, m = "invokeSuspend", n = {"imagePath"}, s = {"L$0"})
    /* renamed from: com.deliveryhero.chatui.view.chatroom.ChatViewModel$showImageShareConfirmation$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public Object f29574h;

        /* renamed from: i  reason: collision with root package name */
        public int f29575i;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(i12, chatViewModel, uri, uploadImageConfirmationDialog, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            String str;
            ImageSource imageSource;
            final String str2;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f29575i;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                switch (i12) {
                    case ImageSelectionNavigatorImpl.OPEN_CAMERA_REQUEST_CODE /*55660*/:
                        str2 = chatViewModel.getImagePathUseCase.getImageFromCamera();
                        break;
                    case ImageSelectionNavigatorImpl.OPEN_GALLERY_REQUEST_CODE /*55661*/:
                        str2 = chatViewModel.getImagePathUseCase.getImageFromGallery(uri);
                        break;
                    default:
                        str2 = null;
                        break;
                }
                CoroutineDispatcher main = chatViewModel.dispatcher.main();
                final UploadImageConfirmationDialog uploadImageConfirmationDialog = uploadImageConfirmationDialog;
                AnonymousClass1 r42 = new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {

                    /* renamed from: h  reason: collision with root package name */
                    public int f29580h;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public ChatViewModel$showImageShareConfirmation$1(ChatViewModel chatViewModel, int i11, Uri uri, UploadImageConfirmationDialog uploadImageConfirmationDialog, Continuation<? super ChatViewModel$showImageShareConfirmation$1> continuation) {
                            super(2, continuation);
                            this.f29570i = chatViewModel;
                            this.f29571j = i11;
                            this.f29572k = uri;
                            this.f29573l = uploadImageConfirmationDialog;
                        }

                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            return new ChatViewModel$showImageShareConfirmation$1(this.f29570i, this.f29571j, this.f29572k, this.f29573l, continuation);
                        }

                        @Nullable
                        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                            return ((ChatViewModel$showImageShareConfirmation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i11 = this.f29569h;
                            if (i11 == 0) {
                                ResultKt.throwOnFailure(obj);
                                CoroutineDispatcher io2 = this.f29570i.dispatcher.io();
                                final int i12 = this.f29571j;
                                final ChatViewModel chatViewModel = this.f29570i;
                                final Uri uri = this.f29572k;
                                final UploadImageConfirmationDialog uploadImageConfirmationDialog = this.f29573l;
                                AnonymousClass1 r32 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
                                this.f29569h = 1;
                                if (BuildersKt.withContext(io2, r32, this) == coroutine_suspended) {
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
