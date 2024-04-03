package com.talabat.filters.presentation;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\u0010\t\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"EXTRA_FILTER", "", "EXTRA_TYPE", "TYPE_COLLECTIONS", "", "TYPE_VENDORS", "fragment", "Lcom/talabat/filters/presentation/FiltersFragment;", "type", "(Ljava/lang/Integer;)Lcom/talabat/filters/presentation/FiltersFragment;", "resultExtras", "Landroid/content/Intent;", "Lcom/talabat/filters/presentation/FiltersViewModel;", "com_talabat_Components_filters_filters"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FiltersScreenKt {
    @NotNull
    public static final String EXTRA_FILTER = "EXTRA_FILTER";
    @NotNull
    public static final String EXTRA_TYPE = "EXTRA_TYPE";
    public static final int TYPE_COLLECTIONS = 2;
    public static final int TYPE_VENDORS = 1;

    @NotNull
    public static final FiltersFragment fragment(@Nullable Integer num) {
        if (SharedPreferencesManager.getInstance().getLastFavVerticalId() == 0) {
            if (num != null && num.intValue() == 1) {
                return new FiltersFragment(FiltersViewModelBEFiltration.class);
            }
            if (num != null && num.intValue() == 2) {
                return new FiltersFragment(CollectionFiltersViewModelBEFiltration.class);
            }
            throw new UnsupportedOperationException("please pass one of the known types : [1,2]");
        } else if (num != null && num.intValue() == 1) {
            return new FiltersFragment(FiltersViewModel.class);
        } else {
            if (num != null && num.intValue() == 2) {
                return new FiltersFragment(CollectionFiltersViewModel.class);
            }
            throw new UnsupportedOperationException("please pass one of the known types : [1,2]");
        }
    }

    /* access modifiers changed from: private */
    public static final Intent resultExtras(FiltersViewModel filtersViewModel) {
        Intent putExtra = new Intent().putExtra(EXTRA_FILTER, FiltersViewModelKt.selectedFilterSortWrapper(filtersViewModel));
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent()\n    .putExtra(E…ectedFilterSortWrapper())");
        return putExtra;
    }
}
