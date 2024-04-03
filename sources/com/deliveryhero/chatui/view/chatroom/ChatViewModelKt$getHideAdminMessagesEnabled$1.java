package com.deliveryhero.chatui.view.chatroom;

import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModelKt", f = "ChatViewModel.kt", i = {}, l = {981}, m = "getHideAdminMessagesEnabled", n = {}, s = {})
public final class ChatViewModelKt$getHideAdminMessagesEnabled$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f29625h;

    /* renamed from: i  reason: collision with root package name */
    public int f29626i;

    public ChatViewModelKt$getHideAdminMessagesEnabled$1(Continuation<? super ChatViewModelKt$getHideAdminMessagesEnabled$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f29625h = obj;
        this.f29626i |= Integer.MIN_VALUE;
        return ChatViewModelKt.getHideAdminMessagesEnabled((FeatureFlagProvider) null, this);
    }
}
