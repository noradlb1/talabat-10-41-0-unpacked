package ku;

import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.GlobalSearchViewModel;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;

public final /* synthetic */ class i implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GlobalSearchViewModel f62233b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62234c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f62235d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f62236e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f62237f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f62238g;

    public /* synthetic */ i(GlobalSearchViewModel globalSearchViewModel, String str, String str2, int i11, String str3, String str4) {
        this.f62233b = globalSearchViewModel;
        this.f62234c = str;
        this.f62235d = str2;
        this.f62236e = i11;
        this.f62237f = str3;
        this.f62238g = str4;
    }

    public final Object apply(Object obj) {
        return GlobalSearchViewModel.m10839search$lambda3(this.f62233b, this.f62234c, this.f62235d, this.f62236e, this.f62237f, this.f62238g, (Flowable) obj);
    }
}
