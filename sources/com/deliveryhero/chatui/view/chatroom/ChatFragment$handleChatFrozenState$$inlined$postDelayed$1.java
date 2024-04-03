package com.deliveryhero.chatui.view.chatroom;

import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0000H\n¨\u0006\u0001"}, d2 = {"", "androidx/core/view/ViewKt$postDelayed$runnable$1", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class ChatFragment$handleChatFrozenState$$inlined$postDelayed$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f29425b;

    public ChatFragment$handleChatFrozenState$$inlined$postDelayed$1(ChatFragment chatFragment) {
        this.f29425b = chatFragment;
    }

    public final void run() {
        RecyclerView access$getRecyclerView = this.f29425b.getRecyclerView();
        ConcatAdapter access$getAdapter$p = this.f29425b.adapter;
        if (access$getAdapter$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            access$getAdapter$p = null;
        }
        access$getRecyclerView.smoothScrollToPosition(access$getAdapter$p.getItemCount());
    }
}
