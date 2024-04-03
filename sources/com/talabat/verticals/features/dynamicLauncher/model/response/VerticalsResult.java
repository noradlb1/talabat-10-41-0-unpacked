package com.talabat.verticals.features.dynamicLauncher.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/talabat/verticals/features/dynamicLauncher/model/response/VerticalsResult;", "", "()V", "verticals", "", "Lcom/talabat/verticals/features/dynamicLauncher/model/response/Vertical;", "getVerticals", "()Ljava/util/List;", "setVerticals", "(Ljava/util/List;)V", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalsResult {
    @Nullable
    @SerializedName("verticals")
    @Expose
    private List<Vertical> verticals;

    @Nullable
    public final List<Vertical> getVerticals() {
        return this.verticals;
    }

    public final void setVerticals(@Nullable List<Vertical> list) {
        this.verticals = list;
    }
}
