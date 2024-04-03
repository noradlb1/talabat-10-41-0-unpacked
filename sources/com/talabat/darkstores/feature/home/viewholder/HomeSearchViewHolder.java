package com.talabat.darkstores.feature.home.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.extensions.SearchViewExtensionsKt;
import com.talabat.darkstores.feature.home.SearchViewHolderData;
import gj.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/darkstores/feature/home/viewholder/HomeSearchViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "onSearchClickListener", "Lkotlin/Function0;", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "bind", "itemData", "Lcom/talabat/darkstores/feature/home/SearchViewHolderData;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeSearchViewHolder extends RecyclerView.ViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeSearchViewHolder(@NotNull View view, @NotNull Function0<Unit> function0) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function0, "onSearchClickListener");
        this.itemView.findViewById(R.id.btnSearch).setOnClickListener(new a(function0));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m9977_init_$lambda0(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onSearchClickListener");
        function0.invoke();
    }

    public final void bind(@NotNull SearchViewHolderData searchViewHolderData) {
        Intrinsics.checkNotNullParameter(searchViewHolderData, "itemData");
        if (searchViewHolderData.getCanShowTopHeaderChanges()) {
            View view = this.itemView;
            int i11 = R.id.search_bottom_view;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(i11);
            Intrinsics.checkNotNullExpressionValue(linearLayout, "itemView.search_bottom_view");
            linearLayout.setVisibility(0);
            ((LinearLayout) this.itemView.findViewById(i11)).setBackgroundResource(com.designsystem.marshmallow.R.color.ds_neutral_4);
        }
        if (searchViewHolderData.getCanShowGreySearchBar()) {
            SearchView searchView = (SearchView) this.itemView.findViewById(R.id.searchView);
            Intrinsics.checkNotNullExpressionValue(searchView, "itemView.searchView");
            SearchViewExtensionsKt.styleGreySearchBar(searchView);
            return;
        }
        SearchView searchView2 = (SearchView) this.itemView.findViewById(R.id.searchView);
        Intrinsics.checkNotNullExpressionValue(searchView2, "itemView.searchView");
        SearchViewExtensionsKt.styleMarshmallowSearchBar(searchView2);
    }
}
