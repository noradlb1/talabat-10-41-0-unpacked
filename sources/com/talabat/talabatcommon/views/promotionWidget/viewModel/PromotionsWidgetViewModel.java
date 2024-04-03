package com.talabat.talabatcommon.views.promotionWidget.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcommon.views.promotionWidget.model.PromotionsWidgetDisplayModel;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatcommon/views/promotionWidget/viewModel/PromotionsWidgetViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "_displayModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/talabatcommon/views/promotionWidget/model/PromotionsWidgetDisplayModel;", "get_displayModel", "()Landroidx/lifecycle/MutableLiveData;", "displayModel", "getDisplayModel", "getPromotionData", "", "tag", "", "module", "getRawRestaurant", "info", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class PromotionsWidgetViewModel extends BaseViewModel {
    @NotNull
    private final MutableLiveData<PromotionsWidgetDisplayModel> _displayModel = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<PromotionsWidgetDisplayModel> getDisplayModel() {
        return this._displayModel;
    }

    public abstract void getPromotionData(@NotNull String str, @NotNull String str2);

    @NotNull
    public abstract String getRawRestaurant(@Nullable Object obj);

    @NotNull
    public final MutableLiveData<PromotionsWidgetDisplayModel> get_displayModel() {
        return this._displayModel;
    }
}
