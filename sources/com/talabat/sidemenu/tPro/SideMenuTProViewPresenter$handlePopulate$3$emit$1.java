package com.talabat.sidemenu.tPro;

import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$3", f = "SideMenuTProViewPresenter.kt", i = {}, l = {83}, m = "emit", n = {}, s = {})
public final class SideMenuTProViewPresenter$handlePopulate$3$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f61403h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SideMenuTProViewPresenter$handlePopulate$3<T> f61404i;

    /* renamed from: j  reason: collision with root package name */
    public int f61405j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuTProViewPresenter$handlePopulate$3$emit$1(SideMenuTProViewPresenter$handlePopulate$3<? super T> sideMenuTProViewPresenter$handlePopulate$3, Continuation<? super SideMenuTProViewPresenter$handlePopulate$3$emit$1> continuation) {
        super(continuation);
        this.f61404i = sideMenuTProViewPresenter$handlePopulate$3;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61403h = obj;
        this.f61405j |= Integer.MIN_VALUE;
        return this.f61404i.emit((SubscriptionSavingsInfo) null, (Continuation<? super Unit>) this);
    }
}
