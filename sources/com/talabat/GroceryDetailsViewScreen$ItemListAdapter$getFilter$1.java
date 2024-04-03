package com.talabat;

import android.widget.Filter;
import com.talabat.GroceryDetailsViewScreen;
import datamodels.MenuItem;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0014¨\u0006\t"}, d2 = {"com/talabat/GroceryDetailsViewScreen$ItemListAdapter$getFilter$1", "Landroid/widget/Filter;", "performFiltering", "Landroid/widget/Filter$FilterResults;", "constraint", "", "publishResults", "", "results", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryDetailsViewScreen$ItemListAdapter$getFilter$1 extends Filter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsViewScreen f54100a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsViewScreen.ItemListAdapter f54101b;

    public GroceryDetailsViewScreen$ItemListAdapter$getFilter$1(GroceryDetailsViewScreen groceryDetailsViewScreen, GroceryDetailsViewScreen.ItemListAdapter itemListAdapter) {
        this.f54100a = groceryDetailsViewScreen;
        this.f54101b = itemListAdapter;
    }

    @NotNull
    public Filter.FilterResults performFiltering(@NotNull CharSequence charSequence) {
        boolean z11;
        Intrinsics.checkNotNullParameter(charSequence, "constraint");
        ArrayList arrayList = new ArrayList();
        ArrayList<MenuItem> allItemsToDisplay = this.f54100a.getGroceryDetailsPresenter().getAllItemsToDisplay();
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (charSequence.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            arrayList.addAll(allItemsToDisplay);
        } else {
            Iterator<MenuItem> it = allItemsToDisplay.iterator();
            while (it.hasNext()) {
                MenuItem next = it.next();
                String str = next.f13862name;
                Intrinsics.checkNotNullExpressionValue(str, "item.name");
                String lowerCase = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                String lowerCase2 = charSequence.toString().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null)) {
                    arrayList.add(next);
                }
            }
        }
        filterResults.values = arrayList;
        filterResults.count = arrayList.size();
        return filterResults;
    }

    public void publishResults(@NotNull CharSequence charSequence, @NotNull Filter.FilterResults filterResults) {
        Intrinsics.checkNotNullParameter(charSequence, "constraint");
        Intrinsics.checkNotNullParameter(filterResults, "results");
        if (filterResults.count == 0) {
            this.f54100a.showEmptyScreen(true, false);
            return;
        }
        this.f54101b.getGroceryContinuousMenuListModel().clear();
        ArrayList<MenuItem> groceryContinuousMenuListModel = this.f54101b.getGroceryContinuousMenuListModel();
        Object obj = filterResults.values;
        if (obj != null) {
            groceryContinuousMenuListModel.addAll((ArrayList) obj);
            this.f54100a.showEmptyScreen(false, false);
            this.f54101b.notifyDataSetChanged();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<datamodels.MenuItem>{ kotlin.collections.TypeAliasesKt.ArrayList<datamodels.MenuItem> }");
    }
}
