package com.talabat.talabatlife.features.tLifeWidget.repository;

import com.talabat.talabatlife.features.tLifeWidget.model.TLifeSubscriptionStatusRootResponse;
import com.talabat.talabatlife.ui.tLifeWidget.model.SubscriptionStatusDisplayModel;
import com.talabat.talabatlife.ui.tLifeWidget.model.TLifeWidgetMapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatlife/ui/tLifeWidget/model/SubscriptionStatusDisplayModel;", "it", "Lcom/talabat/talabatlife/features/tLifeWidget/model/TLifeSubscriptionStatusRootResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TLifeWidgetRepositoryImpl$getTLifeUserSubscriptionStatus$1 extends Lambda implements Function1<TLifeSubscriptionStatusRootResponse, SubscriptionStatusDisplayModel> {
    public static final TLifeWidgetRepositoryImpl$getTLifeUserSubscriptionStatus$1 INSTANCE = new TLifeWidgetRepositoryImpl$getTLifeUserSubscriptionStatus$1();

    public TLifeWidgetRepositoryImpl$getTLifeUserSubscriptionStatus$1() {
        super(1);
    }

    @NotNull
    public final SubscriptionStatusDisplayModel invoke(@NotNull TLifeSubscriptionStatusRootResponse tLifeSubscriptionStatusRootResponse) {
        Intrinsics.checkNotNullParameter(tLifeSubscriptionStatusRootResponse, "it");
        return TLifeWidgetMapper.Companion.mapTLifeUserSubscriptionStatusResponse(tLifeSubscriptionStatusRootResponse);
    }
}
