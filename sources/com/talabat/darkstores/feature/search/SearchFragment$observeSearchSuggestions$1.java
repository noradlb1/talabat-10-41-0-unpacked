package com.talabat.darkstores.feature.search;

import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.model.SearchSuggestion;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "result", "Lcom/talabat/darkstores/common/Result;", "", "Lcom/talabat/darkstores/model/SearchSuggestion;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SearchFragment$observeSearchSuggestions$1 extends Lambda implements Function1<Result<List<? extends SearchSuggestion>>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SearchFragment f56573g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchFragment$observeSearchSuggestions$1(SearchFragment searchFragment) {
        super(1);
        this.f56573g = searchFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Result<List<SearchSuggestion>>) (Result) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.NotNull com.talabat.darkstores.common.Result<java.util.List<com.talabat.darkstores.model.SearchSuggestion>> r9) {
        /*
            r8 = this;
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.talabat.darkstores.feature.search.SearchFragment r0 = r8.f56573g
            int r1 = com.talabat.darkstores.R.id.container
            android.view.View r0 = r0._$_findCachedViewById(r1)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            java.lang.String r1 = "container"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r1 = r9.isSuccess()
            r2 = 8
            r3 = 0
            if (r1 == 0) goto L_0x001f
            r1 = r3
            goto L_0x0020
        L_0x001f:
            r1 = r2
        L_0x0020:
            r0.setVisibility(r1)
            com.talabat.darkstores.feature.search.SearchFragment r0 = r8.f56573g
            int r1 = com.talabat.darkstores.R.id.progressBar
            android.view.View r0 = r0._$_findCachedViewById(r1)
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
            java.lang.String r1 = "progressBar"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r1 = r9.isLoading()
            if (r1 == 0) goto L_0x003a
            r1 = r3
            goto L_0x003b
        L_0x003a:
            r1 = r2
        L_0x003b:
            r0.setVisibility(r1)
            boolean r0 = r9 instanceof com.talabat.darkstores.common.Result.Success
            r1 = 1
            if (r0 == 0) goto L_0x0054
            r4 = r9
            com.talabat.darkstores.common.Result$Success r4 = (com.talabat.darkstores.common.Result.Success) r4
            java.lang.Object r4 = r4.getData()
            java.util.List r4 = (java.util.List) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0054
            r4 = r1
            goto L_0x0055
        L_0x0054:
            r4 = r3
        L_0x0055:
            com.talabat.darkstores.feature.search.SearchFragment r5 = r8.f56573g
            int r6 = com.talabat.darkstores.R.id.tvEmpty
            android.view.View r5 = r5._$_findCachedViewById(r6)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            java.lang.String r6 = "tvEmpty"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            if (r4 == 0) goto L_0x0083
            com.talabat.darkstores.feature.search.SearchFragment r6 = r8.f56573g
            int r7 = com.talabat.darkstores.R.id.searchView
            android.view.View r6 = r6._$_findCachedViewById(r7)
            androidx.appcompat.widget.SearchView r6 = (androidx.appcompat.widget.SearchView) r6
            java.lang.CharSequence r6 = r6.getQuery()
            java.lang.String r7 = "searchView.query"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            boolean r6 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r6)
            r6 = r6 ^ r1
            if (r6 == 0) goto L_0x0083
            r6 = r1
            goto L_0x0084
        L_0x0083:
            r6 = r3
        L_0x0084:
            if (r6 == 0) goto L_0x0087
            r2 = r3
        L_0x0087:
            r5.setVisibility(r2)
            com.talabat.darkstores.feature.search.SearchFragment r2 = r8.f56573g
            int r5 = com.talabat.darkstores.R.id.tvNoResultsTitle
            android.view.View r2 = r2._$_findCachedViewById(r5)
            android.widget.TextView r2 = (android.widget.TextView) r2
            com.talabat.darkstores.feature.search.SearchFragment r5 = r8.f56573g
            int r6 = com.talabat.localization.R.string.no_results_title
            java.lang.Object[] r1 = new java.lang.Object[r1]
            int r7 = com.talabat.darkstores.R.id.searchView
            android.view.View r7 = r5._$_findCachedViewById(r7)
            androidx.appcompat.widget.SearchView r7 = (androidx.appcompat.widget.SearchView) r7
            java.lang.CharSequence r7 = r7.getQuery()
            r1[r3] = r7
            java.lang.String r1 = r5.getString(r6, r1)
            r2.setText(r1)
            com.talabat.darkstores.feature.search.SearchFragment r1 = r8.f56573g
            int r2 = com.talabat.darkstores.R.id.recyclerView
            android.view.View r2 = r1._$_findCachedViewById(r2)
            androidx.recyclerview.widget.RecyclerView r2 = (androidx.recyclerview.widget.RecyclerView) r2
            java.lang.String r3 = "recyclerView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r1.selectAdapter(r2, r4)
            com.talabat.darkstores.feature.search.SearchFragment r1 = r8.f56573g
            if (r0 == 0) goto L_0x00d0
            com.talabat.darkstores.common.Result$Success r9 = (com.talabat.darkstores.common.Result.Success) r9
            java.lang.Object r9 = r9.getData()
            java.util.List r9 = (java.util.List) r9
            r1.onDataReceived(r9)
        L_0x00d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.search.SearchFragment$observeSearchSuggestions$1.invoke(com.talabat.darkstores.common.Result):void");
    }
}
