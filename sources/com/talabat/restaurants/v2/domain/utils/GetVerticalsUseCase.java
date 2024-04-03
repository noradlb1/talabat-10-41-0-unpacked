package com.talabat.restaurants.v2.domain.utils;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001j\u0002`\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0002\u0010\u0012J\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/restaurants/v2/domain/utils/GetVerticalsUseCase;", "Lkotlin/Function1;", "", "", "Lcom/talabat/restaurants/v2/domain/utils/GetVerticalsUseCaseInterface;", "sharedPreferencesManager", "Llibrary/talabat/SharedPreferencesManager;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Llibrary/talabat/SharedPreferencesManager;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "getSharedPreferencesManager", "()Llibrary/talabat/SharedPreferencesManager;", "setSharedPreferencesManager", "(Llibrary/talabat/SharedPreferencesManager;)V", "covertToIntArray", "stringVerticals", "", "", "([Ljava/lang/String;)Ljava/util/List;", "invoke", "verticalId", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetVerticalsUseCase implements Function1<Integer, List<Integer>> {
    @NotNull
    private SharedPreferencesManager sharedPreferencesManager;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public GetVerticalsUseCase(@NotNull SharedPreferencesManager sharedPreferencesManager2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(sharedPreferencesManager2, "sharedPreferencesManager");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.sharedPreferencesManager = sharedPreferencesManager2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    private final List<Integer> covertToIntArray(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String parseInt : strArr) {
            arrayList.add(Integer.valueOf(Integer.parseInt(parseInt)));
        }
        return arrayList;
    }

    @NotNull
    public final SharedPreferencesManager getSharedPreferencesManager() {
        return this.sharedPreferencesManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final void setSharedPreferencesManager(@NotNull SharedPreferencesManager sharedPreferencesManager2) {
        Intrinsics.checkNotNullParameter(sharedPreferencesManager2, "<set-?>");
        this.sharedPreferencesManager = sharedPreferencesManager2;
    }

    @NotNull
    public List<Integer> invoke(int i11) {
        ArrayList arrayList = new ArrayList();
        if (this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.LAUNCHER_ENABLE_TILES, false)) {
            String[] moreTileVerticalsId = this.sharedPreferencesManager.getMoreTileVerticalsId();
            Intrinsics.checkNotNullExpressionValue(moreTileVerticalsId, "sharedPreferencesManager.moreTileVerticalsId");
            return covertToIntArray(moreTileVerticalsId);
        }
        arrayList.add(Integer.valueOf(i11));
        return arrayList;
    }
}
