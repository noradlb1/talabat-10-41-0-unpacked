package com.talabat.talabatcommon.views.promotionWidget.viewModel;

import android.content.Context;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcommon.feature.promotionWidget.PromotionsWidgetUseCase;
import com.talabat.talabatcommon.feature.promotionWidget.network.PromotionsWidgetService;
import com.talabat.talabatcommon.feature.promotionWidget.repository.PromotionsWidgetRepositoryImpl;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/views/promotionWidget/viewModel/PromotionsWidgetViewModelBuilder;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PromotionsWidgetViewModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/promotionWidget/viewModel/PromotionsWidgetViewModelBuilder$Companion;", "", "()V", "getMyViewModel", "Lcom/talabat/talabatcommon/views/promotionWidget/viewModel/PromotionsWidgetViewModelImpl;", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PromotionsWidgetViewModelImpl getMyViewModel(@NotNull Context context, @NotNull CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            return new PromotionsWidgetViewModelImpl(new PromotionsWidgetUseCase(new PromotionsWidgetRepositoryImpl(new NetworkHandler(context), new PromotionsWidgetService(new TalabatAPIBuilder())), coroutineScope, Dispatchers.getMain()));
        }
    }
}
