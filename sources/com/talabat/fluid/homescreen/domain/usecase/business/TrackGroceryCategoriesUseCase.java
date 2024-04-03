package com.talabat.fluid.homescreen.domain.usecase.business;

import com.deliveryhero.fluid.widgets.collections.Cell;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H&J\u001c\u0010\t\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH&J\u001c\u0010\r\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH&J\u001c\u0010\u000e\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH&¨\u0006\u000f"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackGroceryCategoriesUseCase;", "", "onCategoriesSwiped", "", "itemImpressionIndexes", "", "", "items", "Lcom/deliveryhero/fluid/widgets/collections/Cell;", "trackCategoriesTitleClicked", "params", "", "", "trackCategoriesViewStoreClicked", "trackCategoryItemClicked", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TrackGroceryCategoriesUseCase {
    void onCategoriesSwiped(@NotNull List<Integer> list, @NotNull List<? extends Cell> list2);

    void trackCategoriesTitleClicked(@NotNull Map<String, String> map);

    void trackCategoriesViewStoreClicked(@NotNull Map<String, String> map);

    void trackCategoryItemClicked(@NotNull Map<String, String> map);
}
