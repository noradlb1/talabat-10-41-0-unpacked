package com.talabat.restaurants.v2.domain.utils;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/talabat/restaurants/v2/domain/utils/GetMoreTileVerticalsIdUseCase;", "", "sharedPreferencesManager", "Llibrary/talabat/SharedPreferencesManager;", "(Llibrary/talabat/SharedPreferencesManager;)V", "getSharedPreferencesManager", "()Llibrary/talabat/SharedPreferencesManager;", "setSharedPreferencesManager", "invoke", "", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetMoreTileVerticalsIdUseCase {
    @NotNull
    private SharedPreferencesManager sharedPreferencesManager;

    public GetMoreTileVerticalsIdUseCase(@NotNull SharedPreferencesManager sharedPreferencesManager2) {
        Intrinsics.checkNotNullParameter(sharedPreferencesManager2, "sharedPreferencesManager");
        this.sharedPreferencesManager = sharedPreferencesManager2;
    }

    @NotNull
    public final SharedPreferencesManager getSharedPreferencesManager() {
        return this.sharedPreferencesManager;
    }

    @NotNull
    public final List<Integer> invoke() {
        if (this.sharedPreferencesManager.getMoreTileVerticalsId() == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        String[] moreTileVerticalsId = this.sharedPreferencesManager.getMoreTileVerticalsId();
        Intrinsics.checkNotNullExpressionValue(moreTileVerticalsId, "sharedPreferencesManager.getMoreTileVerticalsId()");
        ArrayList arrayList = new ArrayList(moreTileVerticalsId.length);
        for (String str : moreTileVerticalsId) {
            Intrinsics.checkNotNullExpressionValue(str, "it");
            arrayList.add(Integer.valueOf(Integer.parseInt(str)));
        }
        return arrayList;
    }

    public final void setSharedPreferencesManager(@NotNull SharedPreferencesManager sharedPreferencesManager2) {
        Intrinsics.checkNotNullParameter(sharedPreferencesManager2, "<set-?>");
        this.sharedPreferencesManager = sharedPreferencesManager2;
    }
}
