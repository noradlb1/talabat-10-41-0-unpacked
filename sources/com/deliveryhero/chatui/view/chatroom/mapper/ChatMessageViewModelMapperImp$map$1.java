package com.deliveryhero.chatui.view.chatroom.mapper;

import com.deliveryhero.contract.model.BaseMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapperImp", f = "ChatMessageViemodelMapper.kt", i = {0, 0, 0, 0}, l = {58}, m = "map", n = {"this", "preferredLanguage", "destination$iv$iv", "index$iv$iv"}, s = {"L$0", "L$1", "L$2", "I$0"})
public final class ChatMessageViewModelMapperImp$map$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f29636h;

    /* renamed from: i  reason: collision with root package name */
    public Object f29637i;

    /* renamed from: j  reason: collision with root package name */
    public Object f29638j;

    /* renamed from: k  reason: collision with root package name */
    public Object f29639k;

    /* renamed from: l  reason: collision with root package name */
    public Object f29640l;

    /* renamed from: m  reason: collision with root package name */
    public int f29641m;

    /* renamed from: n  reason: collision with root package name */
    public /* synthetic */ Object f29642n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ ChatMessageViewModelMapperImp f29643o;

    /* renamed from: p  reason: collision with root package name */
    public int f29644p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatMessageViewModelMapperImp$map$1(ChatMessageViewModelMapperImp chatMessageViewModelMapperImp, Continuation<? super ChatMessageViewModelMapperImp$map$1> continuation) {
        super(continuation);
        this.f29643o = chatMessageViewModelMapperImp;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f29642n = obj;
        this.f29644p |= Integer.MIN_VALUE;
        return this.f29643o.map((String) null, (List<? extends BaseMessage>) null, this);
    }
}
