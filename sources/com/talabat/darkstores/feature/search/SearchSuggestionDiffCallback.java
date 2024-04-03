package com.talabat.darkstores.feature.search;

import androidx.recyclerview.widget.DiffUtil;
import com.talabat.darkstores.model.SearchSuggestion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/search/SearchSuggestionDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/talabat/darkstores/model/SearchSuggestion;", "()V", "areContentsTheSame", "", "old", "new", "areItemsTheSame", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class SearchSuggestionDiffCallback extends DiffUtil.ItemCallback<SearchSuggestion> {
    public boolean areContentsTheSame(@NotNull SearchSuggestion searchSuggestion, @NotNull SearchSuggestion searchSuggestion2) {
        Intrinsics.checkNotNullParameter(searchSuggestion, "old");
        Intrinsics.checkNotNullParameter(searchSuggestion2, "new");
        return Intrinsics.areEqual((Object) searchSuggestion, (Object) searchSuggestion2);
    }

    public boolean areItemsTheSame(@NotNull SearchSuggestion searchSuggestion, @NotNull SearchSuggestion searchSuggestion2) {
        Intrinsics.checkNotNullParameter(searchSuggestion, "old");
        Intrinsics.checkNotNullParameter(searchSuggestion2, "new");
        return Intrinsics.areEqual((Object) searchSuggestion, (Object) searchSuggestion2);
    }
}
