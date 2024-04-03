package com.talabat.talabatlife.ui.tLifeWidget.model;

import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatlife.features.tLifeWidget.model.TLifeSubscriptionStatusResponse;
import com.talabat.talabatlife.features.tLifeWidget.model.TLifeSubscriptionStatusRootResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatlife/ui/tLifeWidget/model/TLifeWidgetMapper;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeWidgetMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatlife/ui/tLifeWidget/model/TLifeWidgetMapper$Companion;", "", "()V", "mapTLifeUserSubscriptionStatusResponse", "Lcom/talabat/talabatlife/ui/tLifeWidget/model/SubscriptionStatusDisplayModel;", "statusResponse", "Lcom/talabat/talabatlife/features/tLifeWidget/model/TLifeSubscriptionStatusRootResponse;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SubscriptionStatusDisplayModel mapTLifeUserSubscriptionStatusResponse(@Nullable TLifeSubscriptionStatusRootResponse tLifeSubscriptionStatusRootResponse) {
            Boolean bool;
            TLifeSubscriptionStatusResponse tLifeSubscriptionStatusResponse;
            SubscriptionStatusDisplayModel subscriptionStatusDisplayModel = new SubscriptionStatusDisplayModel();
            if (tLifeSubscriptionStatusRootResponse == null || (tLifeSubscriptionStatusResponse = (TLifeSubscriptionStatusResponse) tLifeSubscriptionStatusRootResponse.getResult()) == null) {
                bool = null;
            } else {
                bool = tLifeSubscriptionStatusResponse.isSubscribed();
            }
            subscriptionStatusDisplayModel.setUserSubscribed(BooleanKt.orFalse(bool));
            return subscriptionStatusDisplayModel;
        }
    }
}
