package ji;

import com.talabat.darkstores.data.recentsearches.local.RecentSearchesDao;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RecentSearchesDao f56924b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56925c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f56926d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f56927e;

    public /* synthetic */ a(RecentSearchesDao recentSearchesDao, String str, int i11, int i12) {
        this.f56924b = recentSearchesDao;
        this.f56925c = str;
        this.f56926d = i11;
        this.f56927e = i12;
    }

    public final void run() {
        RecentSearchesDao.DefaultImpls.m9727addQueryToRecentSearches$lambda1(this.f56924b, this.f56925c, this.f56926d, this.f56927e);
    }
}
