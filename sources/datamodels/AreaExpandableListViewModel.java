package datamodels;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R.\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ldatamodels/AreaExpandableListViewModel;", "", "()V", "areas", "Ljava/util/ArrayList;", "Ldatamodels/Area;", "Lkotlin/collections/ArrayList;", "getAreas", "()Ljava/util/ArrayList;", "setAreas", "(Ljava/util/ArrayList;)V", "cityName", "", "getCityName", "()Ljava/lang/String;", "setCityName", "(Ljava/lang/String;)V", "isArrowShow", "", "()Z", "setArrowShow", "(Z)V", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AreaExpandableListViewModel {
    @Nullable
    private ArrayList<Area> areas;
    @Nullable
    private String cityName;
    private boolean isArrowShow;

    @Nullable
    public final ArrayList<Area> getAreas() {
        return this.areas;
    }

    @Nullable
    public final String getCityName() {
        return this.cityName;
    }

    public final boolean isArrowShow() {
        return this.isArrowShow;
    }

    public final void setAreas(@Nullable ArrayList<Area> arrayList) {
        this.areas = arrayList;
    }

    public final void setArrowShow(boolean z11) {
        this.isArrowShow = z11;
    }

    public final void setCityName(@Nullable String str) {
        this.cityName = str;
    }
}
