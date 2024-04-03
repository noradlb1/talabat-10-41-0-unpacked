package com.jakewharton.rxbinding3.widget;

import android.widget.SearchView;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "text", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 15})
public final class RxSearchView__SearchViewQueryConsumerKt$query$1<T> implements Consumer<CharSequence> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchView f52686b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f52687c;

    public RxSearchView__SearchViewQueryConsumerKt$query$1(SearchView searchView, boolean z11) {
        this.f52686b = searchView;
        this.f52687c = z11;
    }

    public final void accept(CharSequence charSequence) {
        this.f52686b.setQuery(charSequence, this.f52687c);
    }
}
