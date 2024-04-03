package com.talabat.sidemenu.tPro;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.sidemenu.tPro.SideMenuTProViewPresenter", f = "SideMenuTProViewPresenter.kt", i = {}, l = {73, 79}, m = "handlePopulate", n = {}, s = {})
public final class SideMenuTProViewPresenter$handlePopulate$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f61395h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SideMenuTProViewPresenter f61396i;

    /* renamed from: j  reason: collision with root package name */
    public int f61397j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuTProViewPresenter$handlePopulate$1(SideMenuTProViewPresenter sideMenuTProViewPresenter, Continuation<? super SideMenuTProViewPresenter$handlePopulate$1> continuation) {
        super(continuation);
        this.f61396i = sideMenuTProViewPresenter;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61395h = obj;
        this.f61397j |= Integer.MIN_VALUE;
        return this.f61396i.handlePopulate(this);
    }
}
