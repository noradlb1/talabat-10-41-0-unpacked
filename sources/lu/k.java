package lu;

import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.SuggestionsViewModel;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;

public final /* synthetic */ class k implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SuggestionsViewModel f62289b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62290c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f62291d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f62292e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f62293f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f62294g;

    public /* synthetic */ k(SuggestionsViewModel suggestionsViewModel, String str, String str2, int i11, String str3, String str4) {
        this.f62289b = suggestionsViewModel;
        this.f62290c = str;
        this.f62291d = str2;
        this.f62292e = i11;
        this.f62293f = str3;
        this.f62294g = str4;
    }

    public final Object apply(Object obj) {
        return SuggestionsViewModel.m10850getSuggestionsDishes$lambda3(this.f62289b, this.f62290c, this.f62291d, this.f62292e, this.f62293f, this.f62294g, (Flowable) obj);
    }
}
