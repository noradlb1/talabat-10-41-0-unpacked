package com.deliveryhero.chatui.view.chatroom;

import android.content.Context;
import com.deliveryhero.chatui.view.chatroom.adapter.AttachmentDialogAdapter;
import com.deliveryhero.chatui.view.chatroom.customview.AttachmentDialog;
import com.deliveryhero.chatui.view.chatroom.dataholder.AttachmentDataHolder;
import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import com.deliveryhero.customerchat.fwf.UserFeatureFlags;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatFragment$showAddAttachmentDialog$2", f = "ChatFragment.kt", i = {}, l = {303}, m = "invokeSuspend", n = {}, s = {})
public final class ChatFragment$showAddAttachmentDialog$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29485h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f29486i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AttachmentDataHolder f29487j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ AttachmentDialog f29488k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatFragment$showAddAttachmentDialog$2(ChatFragment chatFragment, AttachmentDataHolder attachmentDataHolder, AttachmentDialog attachmentDialog, Continuation<? super ChatFragment$showAddAttachmentDialog$2> continuation) {
        super(2, continuation);
        this.f29486i = chatFragment;
        this.f29487j = attachmentDataHolder;
        this.f29488k = attachmentDialog;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChatFragment$showAddAttachmentDialog$2(this.f29486i, this.f29487j, this.f29488k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChatFragment$showAddAttachmentDialog$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29485h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FeatureFlagProvider access$getFeatureFlagProvider = this.f29486i.getFeatureFlagProvider();
            this.f29485h = 1;
            obj = access$getFeatureFlagProvider.getUserFeatureFlags(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        UserFeatureFlags userFeatureFlags = (UserFeatureFlags) obj;
        if (userFeatureFlags == null) {
            userFeatureFlags = new UserFeatureFlags(false, false, false, false, false, false, false, false, 255, (DefaultConstructorMarker) null);
        }
        AttachmentDataHolder attachmentDataHolder = this.f29487j;
        Context requireContext = this.f29486i.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this.f29488k.bind(new AttachmentDialogAdapter(attachmentDataHolder.getAttachmentOptionList(requireContext, userFeatureFlags.isPhotoSharingEnabled(), userFeatureFlags.isLocationSharingEnabled()), new ChatFragment$showAddAttachmentDialog$2$attachmentDialogAdapter$1(this.f29486i, this.f29488k)));
        return Unit.INSTANCE;
    }
}
