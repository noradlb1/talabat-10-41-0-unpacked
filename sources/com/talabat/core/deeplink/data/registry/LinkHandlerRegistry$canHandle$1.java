package com.talabat.core.deeplink.data.registry;

import com.talabat.core.deeplink.data.ParsedLinkModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.core.deeplink.data.registry.LinkHandlerRegistry", f = "LinkHandlerRegistry.kt", i = {0}, l = {20}, m = "canHandle", n = {"parsedLinkModel"}, s = {"L$0"})
public final class LinkHandlerRegistry$canHandle$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55833h;

    /* renamed from: i  reason: collision with root package name */
    public Object f55834i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f55835j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ LinkHandlerRegistry f55836k;

    /* renamed from: l  reason: collision with root package name */
    public int f55837l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LinkHandlerRegistry$canHandle$1(LinkHandlerRegistry linkHandlerRegistry, Continuation<? super LinkHandlerRegistry$canHandle$1> continuation) {
        super(continuation);
        this.f55836k = linkHandlerRegistry;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55835j = obj;
        this.f55837l |= Integer.MIN_VALUE;
        return this.f55836k.canHandle((ParsedLinkModel) null, this);
    }
}
