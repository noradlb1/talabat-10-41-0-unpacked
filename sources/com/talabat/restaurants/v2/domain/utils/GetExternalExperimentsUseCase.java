package com.talabat.restaurants.v2.domain.utils;

import com.talabat.core.experiment.data.TalabatExperimentConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/restaurants/v2/domain/utils/GetExternalExperimentsUseCase;", "", "()V", "DEFAULT_DOUBLE_VALUE", "", "DEFAULT_STRING_VALUE", "", "DOUBLE", "NAME_KEY", "STRING", "TYPE_KEY", "VALUE_KEY", "invoke", "boostedRankingValue", "dynamicRankingValue", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetExternalExperimentsUseCase {
    private final double DEFAULT_DOUBLE_VALUE;
    @NotNull
    private final String DEFAULT_STRING_VALUE = "";
    @NotNull
    private final String DOUBLE = "Double";
    @NotNull
    private final String NAME_KEY = "name";
    @NotNull
    private final String STRING = "String";
    @NotNull
    private final String TYPE_KEY = "type";
    @NotNull
    private final String VALUE_KEY = "value";

    @Nullable
    public final String invoke(double d11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "dynamicRankingValue");
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(this.NAME_KEY, (Object) TalabatExperimentConstants.VL_BOOST_RANKING.getValue());
        jSONObject.put(this.TYPE_KEY, (Object) this.DOUBLE);
        jSONObject.put(this.VALUE_KEY, d11);
        if (!Double.valueOf(d11).equals(Double.valueOf(this.DEFAULT_DOUBLE_VALUE))) {
            arrayList.add(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(this.NAME_KEY, (Object) TalabatExperimentConstants.VL_DYNAMIC_RANKING.getValue());
        jSONObject2.put(this.TYPE_KEY, (Object) this.STRING);
        jSONObject2.put(this.VALUE_KEY, (Object) str);
        if (!Intrinsics.areEqual((Object) str, (Object) this.DEFAULT_STRING_VALUE)) {
            arrayList.add(jSONObject2);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }
}
