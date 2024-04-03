package com.deliveryhero.customerchat.service;

import com.deliveryhero.contract.model.ChatDetails;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "details", "Lcom/deliveryhero/contract/model/ChatDetails;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatService$getChatDetailsByChannel$3$1 extends Lambda implements Function1<ChatDetails, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Continuation<ChatDetails> f30014g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatService$getChatDetailsByChannel$3$1(Continuation<? super ChatDetails> continuation) {
        super(1);
        this.f30014g = continuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ChatDetails) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ChatDetails chatDetails) {
        Intrinsics.checkNotNullParameter(chatDetails, "details");
        this.f30014g.resumeWith(Result.m6329constructorimpl(chatDetails));
    }
}
