package com.talabat.darkstores.feature.product.views;

import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import lj.g;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CampaignProgressView$1$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CampaignProgressViewModel f56556g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CampaignProgressView f56557h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CampaignProgressView$1$1(CampaignProgressViewModel campaignProgressViewModel, CampaignProgressView campaignProgressView) {
        super(0);
        this.f56556g = campaignProgressViewModel;
        this.f56557h = campaignProgressView;
    }

    @Nullable
    public final Disposable invoke() {
        return this.f56556g.getStateObservable$com_talabat_NewArchi_darkstores_darkstores().subscribe(new g(this.f56557h));
    }
}
