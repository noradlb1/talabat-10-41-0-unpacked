package com.talabat.sidemenu.tPro;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.sidemenu.tPro.SideMenuTProViewPresenter", f = "SideMenuTProViewPresenter.kt", i = {0}, l = {55, 67}, m = "loadTProBanner", n = {"this"}, s = {"L$0"})
public final class SideMenuTProViewPresenter$loadTProBanner$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61406h;

    /* renamed from: i  reason: collision with root package name */
    public Object f61407i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f61408j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SideMenuTProViewPresenter f61409k;

    /* renamed from: l  reason: collision with root package name */
    public int f61410l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuTProViewPresenter$loadTProBanner$1(SideMenuTProViewPresenter sideMenuTProViewPresenter, Continuation<? super SideMenuTProViewPresenter$loadTProBanner$1> continuation) {
        super(continuation);
        this.f61409k = sideMenuTProViewPresenter;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61408j = obj;
        this.f61410l |= Integer.MIN_VALUE;
        return this.f61409k.loadTProBanner(this);
    }
}
