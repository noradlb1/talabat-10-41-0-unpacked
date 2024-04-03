package com.talabat.core.deeplink.data.registry;

import com.talabat.core.deeplink.data.ParsedLinkModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.core.deeplink.data.registry.LinkHandlerRegistry", f = "LinkHandlerRegistry.kt", i = {0, 0}, l = {16}, m = "loadHandler", n = {"parsedLinkModel", "element$iv"}, s = {"L$0", "L$2"})
public final class LinkHandlerRegistry$loadHandler$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55838h;

    /* renamed from: i  reason: collision with root package name */
    public Object f55839i;

    /* renamed from: j  reason: collision with root package name */
    public Object f55840j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f55841k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ LinkHandlerRegistry f55842l;

    /* renamed from: m  reason: collision with root package name */
    public int f55843m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LinkHandlerRegistry$loadHandler$1(LinkHandlerRegistry linkHandlerRegistry, Continuation<? super LinkHandlerRegistry$loadHandler$1> continuation) {
        super(continuation);
        this.f55842l = linkHandlerRegistry;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55841k = obj;
        this.f55843m |= Integer.MIN_VALUE;
        return this.f55842l.loadHandler((ParsedLinkModel) null, this);
    }
}
