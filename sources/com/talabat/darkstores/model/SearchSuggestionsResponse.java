package com.talabat.darkstores.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.darkstores.feature.tracking.SearchResultScreenType;
import com.talabat.darkstores.model.SearchResponse;
import com.visa.checkout.PurchaseInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\r\u0012\t\u0012\u00070\t¢\u0006\u0002\b\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/talabat/darkstores/model/SearchSuggestionsResponse;", "Lcom/talabat/darkstores/model/SearchResponse;", "requestId", "", "suggestions", "Lcom/talabat/darkstores/model/SuggestionsList;", "(Ljava/lang/String;Lcom/talabat/darkstores/model/SuggestionsList;)V", "productSuggestions", "", "Lcom/talabat/darkstores/model/ProductSuggestion;", "Lkotlin/internal/NoInfer;", "getProductSuggestions", "()Ljava/util/List;", "getRequestId", "()Ljava/lang/String;", "getSuggestions", "()Lcom/talabat/darkstores/model/SuggestionsList;", "trackingData", "Lcom/talabat/darkstores/model/SearchResponse$TrackingData;", "getTrackingData", "()Lcom/talabat/darkstores/model/SearchResponse$TrackingData;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchSuggestionsResponse implements SearchResponse {
    @NotNull
    private final List<ProductSuggestion> productSuggestions;
    @NotNull
    private final String requestId;
    @NotNull
    private final SuggestionsList suggestions;
    @NotNull
    private final SearchResponse.TrackingData trackingData;

    public SearchSuggestionsResponse(@NotNull @Json(name = "request_id") String str, @NotNull @Json(name = "suggestions") SuggestionsList suggestionsList) {
        Intrinsics.checkNotNullParameter(str, PurchaseInfo.REQUEST_ID);
        Intrinsics.checkNotNullParameter(suggestionsList, "suggestions");
        this.requestId = str;
        this.suggestions = suggestionsList;
        ArrayList<ProductSuggestion> arrayList = new ArrayList<>();
        for (Object next : suggestionsList.getItems()) {
            if (next instanceof ProductSuggestion) {
                arrayList.add(next);
            }
        }
        this.productSuggestions = arrayList;
        boolean isEmpty = this.suggestions.getItems().isEmpty();
        SearchResultScreenType searchResultScreenType = SearchResultScreenType.INSTANT;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        for (ProductSuggestion product : arrayList) {
            String sku = product.getProduct().getSku();
            sku = !(StringsKt__StringsJVMKt.isBlank(sku) ^ true) ? null : sku;
            if (sku != null) {
                arrayList2.add(sku);
            }
        }
        this.trackingData = new SearchResponse.TrackingData(isEmpty, searchResultScreenType, size, arrayList2);
    }

    public static /* synthetic */ SearchSuggestionsResponse copy$default(SearchSuggestionsResponse searchSuggestionsResponse, String str, SuggestionsList suggestionsList, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = searchSuggestionsResponse.requestId;
        }
        if ((i11 & 2) != 0) {
            suggestionsList = searchSuggestionsResponse.suggestions;
        }
        return searchSuggestionsResponse.copy(str, suggestionsList);
    }

    @NotNull
    public final String component1() {
        return this.requestId;
    }

    @NotNull
    public final SuggestionsList component2() {
        return this.suggestions;
    }

    @NotNull
    public final SearchSuggestionsResponse copy(@NotNull @Json(name = "request_id") String str, @NotNull @Json(name = "suggestions") SuggestionsList suggestionsList) {
        Intrinsics.checkNotNullParameter(str, PurchaseInfo.REQUEST_ID);
        Intrinsics.checkNotNullParameter(suggestionsList, "suggestions");
        return new SearchSuggestionsResponse(str, suggestionsList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchSuggestionsResponse)) {
            return false;
        }
        SearchSuggestionsResponse searchSuggestionsResponse = (SearchSuggestionsResponse) obj;
        return Intrinsics.areEqual((Object) this.requestId, (Object) searchSuggestionsResponse.requestId) && Intrinsics.areEqual((Object) this.suggestions, (Object) searchSuggestionsResponse.suggestions);
    }

    @NotNull
    public final List<ProductSuggestion> getProductSuggestions() {
        return this.productSuggestions;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final SuggestionsList getSuggestions() {
        return this.suggestions;
    }

    @NotNull
    public SearchResponse.TrackingData getTrackingData() {
        return this.trackingData;
    }

    public int hashCode() {
        return (this.requestId.hashCode() * 31) + this.suggestions.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.requestId;
        SuggestionsList suggestionsList = this.suggestions;
        return "SearchSuggestionsResponse(requestId=" + str + ", suggestions=" + suggestionsList + ")";
    }
}
