package com.talabat.talabatcommon.views.darkstores.lookingGlass.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.ABTestResult;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.model.GDisplayItem;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.model.LookingGlassDisplayModel;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014H&J\b\u0010 \u001a\u00020\u001eH&J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0014H&J\u0018\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$2\u0006\u0010&\u001a\u00020\u0014H&J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020%H&J\b\u0010)\u001a\u00020\u0014H&J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0014H&R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R/\u0010\u0019\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001b0\u001a0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\t¨\u0006+"}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/viewModel/LookingGlassViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "_abTestResults", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/ABTestResult;", "_displayModel", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/LookingGlassDisplayModel;", "get_displayModel", "()Landroidx/lifecycle/MutableLiveData;", "abTestResults", "getAbTestResults", "displayModel", "getDisplayModel", "lookingGlassDisplayModel", "getLookingGlassDisplayModel", "()Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/LookingGlassDisplayModel;", "setLookingGlassDisplayModel", "(Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/LookingGlassDisplayModel;)V", "origin", "", "getOrigin", "()Ljava/lang/String;", "setOrigin", "(Ljava/lang/String;)V", "sendAnalyticEvent", "Lkotlin/Pair;", "", "getSendAnalyticEvent", "getABTestResults", "", "countryId", "getCategoryClickedEvent", "getGlassData", "tag", "getHeadlineProducts", "", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GDisplayItem;", "id", "getItemClickedEvent", "item", "getTempRestaurant", "saveOrigin", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class LookingGlassViewModel extends BaseViewModel {
    @NotNull
    private final MutableLiveData<ABTestResult> _abTestResults = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<LookingGlassDisplayModel> _displayModel = new MutableLiveData<>();
    @Nullable
    private LookingGlassDisplayModel lookingGlassDisplayModel;
    @NotNull
    private String origin = "";
    @NotNull
    private final MutableLiveData<Pair<String, Map<String, String>>> sendAnalyticEvent = new MutableLiveData<>();

    public abstract void getABTestResults(@NotNull String str);

    @NotNull
    public final MutableLiveData<ABTestResult> getAbTestResults() {
        return this._abTestResults;
    }

    public abstract void getCategoryClickedEvent();

    @NotNull
    public final MutableLiveData<LookingGlassDisplayModel> getDisplayModel() {
        return this._displayModel;
    }

    public abstract void getGlassData(@NotNull String str);

    @Nullable
    public abstract List<GDisplayItem> getHeadlineProducts(@NotNull String str);

    public abstract void getItemClickedEvent(@NotNull GDisplayItem gDisplayItem);

    @Nullable
    public final LookingGlassDisplayModel getLookingGlassDisplayModel() {
        return this.lookingGlassDisplayModel;
    }

    @NotNull
    public final String getOrigin() {
        return this.origin;
    }

    @NotNull
    public final MutableLiveData<Pair<String, Map<String, String>>> getSendAnalyticEvent() {
        return this.sendAnalyticEvent;
    }

    @NotNull
    public abstract String getTempRestaurant();

    @NotNull
    public final MutableLiveData<LookingGlassDisplayModel> get_displayModel() {
        return this._displayModel;
    }

    public abstract void saveOrigin(@NotNull String str);

    public final void setLookingGlassDisplayModel(@Nullable LookingGlassDisplayModel lookingGlassDisplayModel2) {
        this.lookingGlassDisplayModel = lookingGlassDisplayModel2;
    }

    public final void setOrigin(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.origin = str;
    }
}
