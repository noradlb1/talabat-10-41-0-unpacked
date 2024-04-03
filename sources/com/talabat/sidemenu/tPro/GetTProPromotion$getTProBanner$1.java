package com.talabat.sidemenu.tPro;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.sidemenu.tPro.GetTProPromotion", f = "GetTProPromotion.kt", i = {}, l = {37}, m = "getTProBanner", n = {}, s = {})
public final class GetTProPromotion$getTProBanner$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f61392h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetTProPromotion f61393i;

    /* renamed from: j  reason: collision with root package name */
    public int f61394j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetTProPromotion$getTProBanner$1(GetTProPromotion getTProPromotion, Continuation<? super GetTProPromotion$getTProBanner$1> continuation) {
        super(continuation);
        this.f61393i = getTProPromotion;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61392h = obj;
        this.f61394j |= Integer.MIN_VALUE;
        return this.f61393i.getTProBanner(this);
    }
}
