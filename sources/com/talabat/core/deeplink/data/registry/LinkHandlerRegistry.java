package com.talabat.core.deeplink.data.registry;

import com.talabat.core.deeplink.data.handler.Handler;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004J\u001d\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/talabat/core/deeplink/data/registry/LinkHandlerRegistry;", "", "Lcom/talabat/core/deeplink/data/handler/Handler;", "handler", "", "a", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "parsedLinkModel", "loadHandler", "(Lcom/talabat/core/deeplink/data/ParsedLinkModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "canHandle", "", "registry", "Ljava/util/List;", "<init>", "()V", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0})
public abstract class LinkHandlerRegistry {
    @NotNull
    private final List<Handler> registry = new ArrayList();

    public final void a(@NotNull Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.registry.add(handler);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object canHandle(@org.jetbrains.annotations.NotNull com.talabat.core.deeplink.data.ParsedLinkModel r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.talabat.core.deeplink.data.registry.LinkHandlerRegistry$canHandle$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.core.deeplink.data.registry.LinkHandlerRegistry$canHandle$1 r0 = (com.talabat.core.deeplink.data.registry.LinkHandlerRegistry$canHandle$1) r0
            int r1 = r0.f55837l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55837l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.core.deeplink.data.registry.LinkHandlerRegistry$canHandle$1 r0 = new com.talabat.core.deeplink.data.registry.LinkHandlerRegistry$canHandle$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f55835j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55837l
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r4) goto L_0x0032
            java.lang.Object r7 = r0.f55834i
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.f55833h
            com.talabat.core.deeplink.data.ParsedLinkModel r2 = (com.talabat.core.deeplink.data.ParsedLinkModel) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0072
        L_0x0032:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.List<com.talabat.core.deeplink.data.handler.Handler> r8 = r6.registry
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            boolean r2 = r8 instanceof java.util.Collection
            if (r2 == 0) goto L_0x004f
            r2 = r8
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x004f
            goto L_0x007e
        L_0x004f:
            java.util.Iterator r8 = r8.iterator()
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x0056:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L_0x007e
            java.lang.Object r2 = r7.next()
            com.talabat.core.deeplink.data.handler.Handler r2 = (com.talabat.core.deeplink.data.handler.Handler) r2
            r0.f55833h = r8
            r0.f55834i = r7
            r0.f55837l = r4
            java.lang.Object r2 = r2.canHandle(r8, r0)
            if (r2 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r5 = r2
            r2 = r8
            r8 = r5
        L_0x0072:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x007c
            r3 = r4
            goto L_0x007e
        L_0x007c:
            r8 = r2
            goto L_0x0056
        L_0x007e:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.deeplink.data.registry.LinkHandlerRegistry.canHandle(com.talabat.core.deeplink.data.ParsedLinkModel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loadHandler(@org.jetbrains.annotations.NotNull com.talabat.core.deeplink.data.ParsedLinkModel r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.core.deeplink.data.handler.Handler> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.talabat.core.deeplink.data.registry.LinkHandlerRegistry$loadHandler$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.core.deeplink.data.registry.LinkHandlerRegistry$loadHandler$1 r0 = (com.talabat.core.deeplink.data.registry.LinkHandlerRegistry$loadHandler$1) r0
            int r1 = r0.f55843m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55843m = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.core.deeplink.data.registry.LinkHandlerRegistry$loadHandler$1 r0 = new com.talabat.core.deeplink.data.registry.LinkHandlerRegistry$loadHandler$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f55841k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55843m
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r7 = r0.f55840j
            java.lang.Object r2 = r0.f55839i
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.f55838h
            com.talabat.core.deeplink.data.ParsedLinkModel r4 = (com.talabat.core.deeplink.data.ParsedLinkModel) r4
            kotlin.ResultKt.throwOnFailure(r8)
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r5
            goto L_0x0067
        L_0x0037:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.List<com.talabat.core.deeplink.data.handler.Handler> r8 = r6.registry
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
            r2 = r8
        L_0x004b:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x0070
            java.lang.Object r8 = r2.next()
            r4 = r8
            com.talabat.core.deeplink.data.handler.Handler r4 = (com.talabat.core.deeplink.data.handler.Handler) r4
            r0.f55838h = r7
            r0.f55839i = r2
            r0.f55840j = r8
            r0.f55843m = r3
            java.lang.Object r4 = r4.canHandle(r7, r0)
            if (r4 != r1) goto L_0x0067
            return r1
        L_0x0067:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x004b
            goto L_0x0071
        L_0x0070:
            r8 = 0
        L_0x0071:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.deeplink.data.registry.LinkHandlerRegistry.loadHandler(com.talabat.core.deeplink.data.ParsedLinkModel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
