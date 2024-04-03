package com.deliveryhero.chatui.view.chatroom.mapper;

import com.deliveryhero.contract.model.BaseMessage;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapperImp", f = "ChatMessageViemodelMapper.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {84}, m = "map", n = {"this", "chatMessage", "textMessage", "translatedText", "user", "imageMessage", "index"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"})
public final class ChatMessageViewModelMapperImp$map$3 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f29645h;

    /* renamed from: i  reason: collision with root package name */
    public Object f29646i;

    /* renamed from: j  reason: collision with root package name */
    public Object f29647j;

    /* renamed from: k  reason: collision with root package name */
    public Object f29648k;

    /* renamed from: l  reason: collision with root package name */
    public Object f29649l;

    /* renamed from: m  reason: collision with root package name */
    public Object f29650m;

    /* renamed from: n  reason: collision with root package name */
    public int f29651n;

    /* renamed from: o  reason: collision with root package name */
    public /* synthetic */ Object f29652o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ ChatMessageViewModelMapperImp f29653p;

    /* renamed from: q  reason: collision with root package name */
    public int f29654q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatMessageViewModelMapperImp$map$3(ChatMessageViewModelMapperImp chatMessageViewModelMapperImp, Continuation<? super ChatMessageViewModelMapperImp$map$3> continuation) {
        super(continuation);
        this.f29653p = chatMessageViewModelMapperImp;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f29652o = obj;
        this.f29654q |= Integer.MIN_VALUE;
        return this.f29653p.map(0, (String) null, (BaseMessage) null, (Throwable) null, this);
    }
}
