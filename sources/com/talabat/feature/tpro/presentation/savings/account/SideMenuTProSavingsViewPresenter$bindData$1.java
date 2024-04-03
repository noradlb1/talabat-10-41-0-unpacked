package com.talabat.feature.tpro.presentation.savings.account;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter", f = "SideMenuTProSavingsViewPresenter.kt", i = {0, 0, 0}, l = {121, 123}, m = "bindData", n = {"this", "savingsInfo", "locationConfigurationRepository"}, s = {"L$0", "L$1", "L$2"})
public final class SideMenuTProSavingsViewPresenter$bindData$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59394h;

    /* renamed from: i  reason: collision with root package name */
    public Object f59395i;

    /* renamed from: j  reason: collision with root package name */
    public Object f59396j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f59397k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ SideMenuTProSavingsViewPresenter f59398l;

    /* renamed from: m  reason: collision with root package name */
    public int f59399m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuTProSavingsViewPresenter$bindData$1(SideMenuTProSavingsViewPresenter sideMenuTProSavingsViewPresenter, Continuation<? super SideMenuTProSavingsViewPresenter$bindData$1> continuation) {
        super(continuation);
        this.f59398l = sideMenuTProSavingsViewPresenter;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59397k = obj;
        this.f59399m |= Integer.MIN_VALUE;
        return this.f59398l.bindData((SubscriptionSavingsInfo) null, (LocationConfigurationRepository) null, this);
    }
}
