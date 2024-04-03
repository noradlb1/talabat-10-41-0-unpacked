package com.jakewharton.rxbinding3.widget;

import android.widget.SearchView;
import androidx.annotation.CheckResult;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001c\u0010\u0000\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"query", "Lio/reactivex/functions/Consumer;", "", "Landroid/widget/SearchView;", "submit", "", "rxbinding_release"}, k = 5, mv = {1, 1, 15}, xs = "com/jakewharton/rxbinding3/widget/RxSearchView")
final /* synthetic */ class RxSearchView__SearchViewQueryConsumerKt {
    @CheckResult
    @NotNull
    public static final Consumer<? super CharSequence> query(@NotNull SearchView searchView, boolean z11) {
        Intrinsics.checkParameterIsNotNull(searchView, "$this$query");
        return new RxSearchView__SearchViewQueryConsumerKt$query$1(searchView, z11);
    }
}
