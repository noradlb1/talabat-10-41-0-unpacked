package com.talabat.darkstores.domain.recentsearches;

import com.talabat.darkstores.domain.model.RecentSearch;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H&¨\u0006\u000e"}, d2 = {"Lcom/talabat/darkstores/domain/recentsearches/RecentSearchesRepository;", "", "addQueryToRecentSearches", "Lio/reactivex/Completable;", "query", "", "vendorId", "", "clearRecentSearches", "observeRecentSearches", "Lio/reactivex/Observable;", "", "Lcom/talabat/darkstores/domain/model/RecentSearch;", "limit", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RecentSearchesRepository {
    @NotNull
    Completable addQueryToRecentSearches(@NotNull String str, int i11);

    @NotNull
    Completable clearRecentSearches(int i11);

    @NotNull
    Observable<List<RecentSearch>> observeRecentSearches(int i11, int i12);
}
