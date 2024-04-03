package com.talabat.talabatlife.ui.tLifeWidget;

import android.content.Context;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TLifeView$subscriptionStatusRepository$2 extends Lambda implements Function0<ISubscriptionStatusRepository> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TLifeView f12084g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TLifeView$subscriptionStatusRepository$2(TLifeView tLifeView) {
        super(0);
        this.f12084g = tLifeView;
    }

    @NotNull
    public final ISubscriptionStatusRepository invoke() {
        Context context = this.f12084g.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return ((SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer(context).getFeature(SubscriptionsFeatureApi.class)).getSubscriptionStatusRepository();
    }
}
