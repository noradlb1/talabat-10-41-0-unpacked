package com.talabat.talabatcommon.views.darkstores.lookingGlass.viewModel;

import com.google.gson.Gson;
import com.integration.IntegrationGlobalDataModel;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.LookingGlassTracker;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.LookingGlassUseCase;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.exception.LookingGlassFailure;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.request.LookingGlassRequestModel;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.response.GVendorInfo;
import com.talabat.talabatcommon.tracking.UserSettingsTracker;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.ABTestResult;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.model.GDisplayCategory;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.model.GDisplayItem;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.model.LookingGlassDisplayModel;
import com.talabat.talabatcore.logger.LogManager;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u0012H\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0012H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006$"}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/viewModel/LookingGlassViewModelImpl;", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/viewModel/LookingGlassViewModel;", "lookingGlassUseCase", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/LookingGlassUseCase;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "lookingGlassTracker", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/LookingGlassTracker;", "(Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/LookingGlassUseCase;Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/LookingGlassTracker;)V", "getLookingGlassTracker", "()Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/LookingGlassTracker;", "getTalabatExperiment", "()Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "setTalabatExperiment", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "getABTestResults", "", "countryId", "", "getCategoryClickedEvent", "getGlassData", "tag", "getGlassRequestModel", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/request/LookingGlassRequestModel;", "getHeadlineProducts", "", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GDisplayItem;", "headlineId", "getItemClickedEvent", "item", "getTempRestaurant", "handleSuccess", "displayModel", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/LookingGlassDisplayModel;", "saveOrigin", "org", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LookingGlassViewModelImpl extends LookingGlassViewModel {
    @NotNull
    private final LookingGlassTracker lookingGlassTracker;
    @NotNull
    private final LookingGlassUseCase lookingGlassUseCase;
    @NotNull
    private ITalabatExperiment talabatExperiment;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LookingGlassViewModelImpl(LookingGlassUseCase lookingGlassUseCase2, ITalabatExperiment iTalabatExperiment, LookingGlassTracker lookingGlassTracker2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(lookingGlassUseCase2, (i11 & 2) != 0 ? TalabatExperiment.INSTANCE : iTalabatExperiment, (i11 & 4) != 0 ? new LookingGlassTracker((UserSettingsTracker) null, 1, (DefaultConstructorMarker) null) : lookingGlassTracker2);
    }

    private final LookingGlassRequestModel getGlassRequestModel(String str) {
        IntegrationGlobalDataModel.Companion companion = IntegrationGlobalDataModel.Companion;
        return new LookingGlassRequestModel(companion.selectedCountryCode(), companion.getSelectedAreaId(), str, String.valueOf(companion.selectedLocationLatitude()), String.valueOf(companion.selectedLocationLongitude()), 0, 100);
    }

    /* access modifiers changed from: private */
    public final void handleSuccess(LookingGlassDisplayModel lookingGlassDisplayModel) {
        for (GDisplayCategory items : lookingGlassDisplayModel.getCategories()) {
            Collections.shuffle(items.getItems());
        }
        setLookingGlassDisplayModel(lookingGlassDisplayModel);
        get_displayModel().postValue(getLookingGlassDisplayModel());
    }

    public void getABTestResults(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "countryId");
        getAbTestResults().setValue(new ABTestResult(false, false));
    }

    public void getCategoryClickedEvent() {
        getSendAnalyticEvent().postValue(this.lookingGlassTracker.categoryClickedEvent());
    }

    public void getGlassData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        this.lookingGlassUseCase.invoke(getGlassRequestModel(str), new LookingGlassViewModelImpl$getGlassData$1(this));
    }

    @Nullable
    public List<GDisplayItem> getHeadlineProducts(@NotNull String str) {
        GDisplayCategory gDisplayCategory;
        T t11;
        Intrinsics.checkNotNullParameter(str, "headlineId");
        LookingGlassDisplayModel lookingGlassDisplayModel = getLookingGlassDisplayModel();
        if (lookingGlassDisplayModel != null) {
            Iterator<T> it = lookingGlassDisplayModel.getCategories().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t11 = null;
                    break;
                }
                t11 = it.next();
                if (Intrinsics.areEqual((Object) ((GDisplayCategory) t11).getId(), (Object) str)) {
                    break;
                }
            }
            gDisplayCategory = (GDisplayCategory) t11;
        } else {
            gDisplayCategory = null;
        }
        if (gDisplayCategory != null) {
            return gDisplayCategory.getItems();
        }
        return null;
    }

    public void getItemClickedEvent(@NotNull GDisplayItem gDisplayItem) {
        Intrinsics.checkNotNullParameter(gDisplayItem, "item");
        getSendAnalyticEvent().postValue(this.lookingGlassTracker.itemClickedEvent(gDisplayItem));
    }

    @NotNull
    public final LookingGlassTracker getLookingGlassTracker() {
        return this.lookingGlassTracker;
    }

    @NotNull
    public final ITalabatExperiment getTalabatExperiment() {
        return this.talabatExperiment;
    }

    @NotNull
    public String getTempRestaurant() {
        Object obj;
        GVendorInfo vendorInfo;
        try {
            Gson gson = new Gson();
            LookingGlassDisplayModel lookingGlassDisplayModel = getLookingGlassDisplayModel();
            if (lookingGlassDisplayModel == null || (vendorInfo = lookingGlassDisplayModel.getVendorInfo()) == null) {
                obj = null;
            } else {
                obj = vendorInfo.getGRestaurant();
            }
            String json = GsonInstrumentation.toJson(gson, obj);
            Intrinsics.checkNotNullExpressionValue(json, "{\n            Gson().toJ…o?.gRestaurant)\n        }");
            return json;
        } catch (Exception e11) {
            String empty = StringUtils.empty(StringCompanionObject.INSTANCE);
            LogManager.logException(e11);
            handleFailure(new LookingGlassFailure());
            return empty;
        }
    }

    public void saveOrigin(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "org");
        setOrigin(str);
    }

    public final void setTalabatExperiment(@NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "<set-?>");
        this.talabatExperiment = iTalabatExperiment;
    }

    public LookingGlassViewModelImpl(@NotNull LookingGlassUseCase lookingGlassUseCase2, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull LookingGlassTracker lookingGlassTracker2) {
        Intrinsics.checkNotNullParameter(lookingGlassUseCase2, "lookingGlassUseCase");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(lookingGlassTracker2, "lookingGlassTracker");
        this.lookingGlassUseCase = lookingGlassUseCase2;
        this.talabatExperiment = iTalabatExperiment;
        this.lookingGlassTracker = lookingGlassTracker2;
    }
}
