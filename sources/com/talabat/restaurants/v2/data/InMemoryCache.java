package com.talabat.restaurants.v2.data;

import com.talabat.restaurants.inlineads.data.InLineAdsResponse;
import kotlin.Metadata;
import library.talabat.com.talabatlib.RestuarntListResponse;
import library.talabat.com.talabatlib.SwimlaneResponse;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/talabat/restaurants/v2/data/InMemoryCache;", "", "()V", "inlineAdsResponse", "Lcom/talabat/restaurants/inlineads/data/InLineAdsResponse;", "getInlineAdsResponse", "()Lcom/talabat/restaurants/inlineads/data/InLineAdsResponse;", "setInlineAdsResponse", "(Lcom/talabat/restaurants/inlineads/data/InLineAdsResponse;)V", "key", "", "getKey", "()I", "setKey", "(I)V", "swimlaneResponse", "Llibrary/talabat/com/talabatlib/SwimlaneResponse;", "getSwimlaneResponse", "()Llibrary/talabat/com/talabatlib/SwimlaneResponse;", "setSwimlaneResponse", "(Llibrary/talabat/com/talabatlib/SwimlaneResponse;)V", "vendorsResponse", "Llibrary/talabat/com/talabatlib/RestuarntListResponse;", "getVendorsResponse", "()Llibrary/talabat/com/talabatlib/RestuarntListResponse;", "setVendorsResponse", "(Llibrary/talabat/com/talabatlib/RestuarntListResponse;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InMemoryCache {
    @Nullable
    private InLineAdsResponse inlineAdsResponse;
    private int key;
    @Nullable
    private SwimlaneResponse swimlaneResponse;
    @Nullable
    private RestuarntListResponse vendorsResponse;

    @Nullable
    public final InLineAdsResponse getInlineAdsResponse() {
        return this.inlineAdsResponse;
    }

    public final int getKey() {
        return this.key;
    }

    @Nullable
    public final SwimlaneResponse getSwimlaneResponse() {
        return this.swimlaneResponse;
    }

    @Nullable
    public final RestuarntListResponse getVendorsResponse() {
        return this.vendorsResponse;
    }

    public final void setInlineAdsResponse(@Nullable InLineAdsResponse inLineAdsResponse) {
        this.inlineAdsResponse = inLineAdsResponse;
    }

    public final void setKey(int i11) {
        this.key = i11;
    }

    public final void setSwimlaneResponse(@Nullable SwimlaneResponse swimlaneResponse2) {
        this.swimlaneResponse = swimlaneResponse2;
    }

    public final void setVendorsResponse(@Nullable RestuarntListResponse restuarntListResponse) {
        this.vendorsResponse = restuarntListResponse;
    }
}
