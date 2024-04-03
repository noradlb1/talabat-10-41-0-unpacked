package com.talabat.feature.tpro.presentation.savings.account;

import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter", f = "SideMenuTProSavingsViewPresenter.kt", i = {0}, l = {130, 132}, m = "hideSavingsView", n = {"this"}, s = {"L$0"})
public final class SideMenuTProSavingsViewPresenter$hideSavingsView$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59403h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59404i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SideMenuTProSavingsViewPresenter f59405j;

    /* renamed from: k  reason: collision with root package name */
    public int f59406k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuTProSavingsViewPresenter$hideSavingsView$1(SideMenuTProSavingsViewPresenter sideMenuTProSavingsViewPresenter, Continuation<? super SideMenuTProSavingsViewPresenter$hideSavingsView$1> continuation) {
        super(continuation);
        this.f59405j = sideMenuTProSavingsViewPresenter;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59404i = obj;
        this.f59406k |= Integer.MIN_VALUE;
        return this.f59405j.hideSavingsView((SubscriptionSavingsInfo) null, this);
    }
}
