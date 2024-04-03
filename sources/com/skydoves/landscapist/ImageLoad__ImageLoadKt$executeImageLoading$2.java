package com.skydoves.landscapist;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/skydoves/landscapist/ImageLoadState;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.skydoves.landscapist.ImageLoad__ImageLoadKt$executeImageLoading$2", f = "ImageLoad.kt", i = {}, l = {72, 72}, m = "invokeSuspend", n = {}, s = {})
public final class ImageLoad__ImageLoadKt$executeImageLoading$2 extends SuspendLambda implements Function2<FlowCollector<? super ImageLoadState>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f52959h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super Flow<? extends ImageLoadState>>, Object> f52960i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageLoad__ImageLoadKt$executeImageLoading$2(Function1<? super Continuation<? super Flow<? extends ImageLoadState>>, ? extends Object> function1, Continuation<? super ImageLoad__ImageLoadKt$executeImageLoading$2> continuation) {
        super(2, continuation);
        this.f52960i = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ImageLoad__ImageLoadKt$executeImageLoading$2 imageLoad__ImageLoadKt$executeImageLoading$2 = new ImageLoad__ImageLoadKt$executeImageLoading$2(this.f52960i, continuation);
        imageLoad__ImageLoadKt$executeImageLoading$2.L$0 = obj;
        return imageLoad__ImageLoadKt$executeImageLoading$2;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super ImageLoadState> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((ImageLoad__ImageLoadKt$executeImageLoading$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.f52959h
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0045
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001a:
            java.lang.Object r1 = r4.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0037
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.Object r5 = r4.L$0
            r1 = r5
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.skydoves.landscapist.ImageLoadState>>, java.lang.Object> r5 = r4.f52960i
            r4.L$0 = r1
            r4.f52959h = r3
            java.lang.Object r5 = r5.invoke(r4)
            if (r5 != r0) goto L_0x0037
            return r0
        L_0x0037:
            kotlinx.coroutines.flow.Flow r5 = (kotlinx.coroutines.flow.Flow) r5
            r3 = 0
            r4.L$0 = r3
            r4.f52959h = r2
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.emitAll(r1, r5, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r4)
            if (r5 != r0) goto L_0x0045
            return r0
        L_0x0045:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.skydoves.landscapist.ImageLoad__ImageLoadKt$executeImageLoading$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
