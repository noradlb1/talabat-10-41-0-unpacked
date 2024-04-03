package ii;

import com.talabat.darkstores.data.recentsearches.RecentSearchesRepositoryImpl;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RecentSearchesRepositoryImpl f56907b;

    public /* synthetic */ a(RecentSearchesRepositoryImpl recentSearchesRepositoryImpl) {
        this.f56907b = recentSearchesRepositoryImpl;
    }

    public final Object apply(Object obj) {
        return RecentSearchesRepositoryImpl.m9726observeRecentSearches$lambda0(this.f56907b, (List) obj);
    }
}
