package com.deliveryhero.perseus.data.remote.api.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/deliveryhero/perseus/data/remote/api/model/HitsRequest;", "", "hits", "", "Lcom/deliveryhero/perseus/data/remote/api/model/HitDetails;", "(Ljava/util/List;)V", "getHits", "()Ljava/util/List;", "setHits", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public final class HitsRequest {
    @SerializedName("hits")
    @NotNull
    private List<HitDetails> hits;

    public HitsRequest(@NotNull List<HitDetails> list) {
        Intrinsics.checkNotNullParameter(list, "hits");
        this.hits = list;
    }

    @NotNull
    public final List<HitDetails> getHits() {
        return this.hits;
    }

    public final void setHits(@NotNull List<HitDetails> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.hits = list;
    }
}
