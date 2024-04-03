package com.talabat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.talabat.talabatcommon.views.TalabatStrokeButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/talabat/GroceryDetailsViewScreen$setRecyclerView$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryDetailsViewScreen$setRecyclerView$3 implements TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsViewScreen f54110b;

    public GroceryDetailsViewScreen$setRecyclerView$3(GroceryDetailsViewScreen groceryDetailsViewScreen) {
        this.f54110b = groceryDetailsViewScreen;
    }

    public void afterTextChanged(@NotNull Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "s");
    }

    public void beforeTextChanged(@NotNull CharSequence charSequence, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
    }

    public void onTextChanged(@NotNull CharSequence charSequence, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
        this.f54110b.getGroceryDetailsPresenter().clearSearchTags();
        this.f54110b.searchPageNumber = 1;
        ((ImageView) this.f54110b._$_findCachedViewById(R.id.sort_selected)).setVisibility(8);
        if (this.f54110b.updateRequired) {
            ((TalabatStrokeButton) this.f54110b._$_findCachedViewById(R.id.reset)).performClick();
        }
        this.f54110b.resetTagsForSearch();
        this.f54110b.allItemsForCurrentKeywordLoaded = false;
        this.f54110b.showEmptyScreen(false, false);
    }
}
