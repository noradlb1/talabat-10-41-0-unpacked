package com.deliveryhero.customerchat.service;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.deliveryhero.customerchat.service.ChatService", f = "ChatService.kt", i = {0, 0}, l = {128}, m = "getChatDetailsByChannels", n = {"this", "destination$iv$iv"}, s = {"L$0", "L$1"})
public final class ChatService$getChatDetailsByChannels$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f30016h;

    /* renamed from: i  reason: collision with root package name */
    public Object f30017i;

    /* renamed from: j  reason: collision with root package name */
    public Object f30018j;

    /* renamed from: k  reason: collision with root package name */
    public Object f30019k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f30020l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ChatService f30021m;

    /* renamed from: n  reason: collision with root package name */
    public int f30022n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatService$getChatDetailsByChannels$1(ChatService chatService, Continuation<? super ChatService$getChatDetailsByChannels$1> continuation) {
        super(continuation);
        this.f30021m = chatService;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f30020l = obj;
        this.f30022n |= Integer.MIN_VALUE;
        return this.f30021m.getChatDetailsByChannels((List<String>) null, this);
    }
}
