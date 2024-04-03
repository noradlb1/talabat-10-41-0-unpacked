package com.talabat.talabatcommon.views.promotionWidget.viewModel;

import com.google.gson.Gson;
import com.integration.IntegrationGlobalDataModel;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.exception.LookingGlassFailure;
import com.talabat.talabatcommon.feature.promotionWidget.PromotionsWidgetUseCase;
import com.talabat.talabatcommon.feature.promotionWidget.model.request.PromotionsWidgetRequestModel;
import com.talabat.talabatcommon.views.promotionWidget.model.PromotionsWidgetDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatcommon/views/promotionWidget/viewModel/PromotionsWidgetViewModelImpl;", "Lcom/talabat/talabatcommon/views/promotionWidget/viewModel/PromotionsWidgetViewModel;", "promotionsWidgetUseCase", "Lcom/talabat/talabatcommon/feature/promotionWidget/PromotionsWidgetUseCase;", "(Lcom/talabat/talabatcommon/feature/promotionWidget/PromotionsWidgetUseCase;)V", "getPromotionData", "", "tag", "", "module", "getPromotionRequestModel", "Lcom/talabat/talabatcommon/feature/promotionWidget/model/request/PromotionsWidgetRequestModel;", "getRawRestaurant", "info", "", "handleSuccess", "promotionsWidgetDisplayModel", "Lcom/talabat/talabatcommon/views/promotionWidget/model/PromotionsWidgetDisplayModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PromotionsWidgetViewModelImpl extends PromotionsWidgetViewModel {
    @NotNull
    private final PromotionsWidgetUseCase promotionsWidgetUseCase;

    public PromotionsWidgetViewModelImpl(@NotNull PromotionsWidgetUseCase promotionsWidgetUseCase2) {
        Intrinsics.checkNotNullParameter(promotionsWidgetUseCase2, "promotionsWidgetUseCase");
        this.promotionsWidgetUseCase = promotionsWidgetUseCase2;
    }

    private final PromotionsWidgetRequestModel getPromotionRequestModel(String str, String str2) {
        IntegrationGlobalDataModel.Companion companion = IntegrationGlobalDataModel.Companion;
        return new PromotionsWidgetRequestModel(companion.selectedCountryCode(), companion.getSelectedAreaId(), str, str2, String.valueOf(companion.selectedLocationLatitude()), String.valueOf(companion.selectedLocationLongitude()));
    }

    /* access modifiers changed from: private */
    public final void handleSuccess(PromotionsWidgetDisplayModel promotionsWidgetDisplayModel) {
        get_displayModel().postValue(promotionsWidgetDisplayModel);
    }

    public void getPromotionData(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "module");
        this.promotionsWidgetUseCase.invoke(getPromotionRequestModel(str, str2), new PromotionsWidgetViewModelImpl$getPromotionData$1(this));
    }

    @NotNull
    public String getRawRestaurant(@Nullable Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            String json = GsonInstrumentation.toJson(new Gson(), obj);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(info)");
            return json;
        } catch (Exception unused) {
            handleFailure(new LookingGlassFailure());
            return "";
        }
    }
}
