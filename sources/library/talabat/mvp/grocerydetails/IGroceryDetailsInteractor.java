package library.talabat.mvp.grocerydetails;

import JsonModels.Request.GroceryRequest.GrocerySortAndFilterRequest;
import JsonModels.Response.GroceryResponse.GrocerySearchResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H&JV\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\nH&J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\nH&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0005H&¨\u0006\u0018"}, d2 = {"Llibrary/talabat/mvp/grocerydetails/IGroceryDetailsInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "applyFilterAndSorting", "", "pageNumber", "", "grocerySortAndFilterRequest", "LJsonModels/Request/GroceryRequest/GrocerySortAndFilterRequest;", "menuSectionId", "branchId", "", "getChoiceSection", "id", "getDataFromApi", "Lio/reactivex/Single;", "LJsonModels/Response/GroceryResponse/GrocerySearchResponse;", "query", "sortBy", "sortOrder", "filterBrands", "tagIdsString", "loadMoreItems", "setTotalPages", "totalPages", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IGroceryDetailsInteractor extends IGlobalInteractor {
    void applyFilterAndSorting(int i11, @NotNull GrocerySortAndFilterRequest grocerySortAndFilterRequest, int i12, @NotNull String str);

    void getChoiceSection(int i11);

    @NotNull
    Single<GrocerySearchResponse> getDataFromApi(@NotNull String str, int i11, @NotNull String str2, int i12, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6);

    void loadMoreItems(int i11, @NotNull String str, @NotNull String str2);

    void setTotalPages(int i11);
}
