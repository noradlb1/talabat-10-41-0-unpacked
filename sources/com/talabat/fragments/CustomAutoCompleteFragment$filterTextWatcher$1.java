package com.talabat.fragments;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Filter;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.adapters.PlacesAutoCompleteAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/talabat/fragments/CustomAutoCompleteFragment$filterTextWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomAutoCompleteFragment$filterTextWatcher$1 implements TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CustomAutoCompleteFragment f59795b;

    public CustomAutoCompleteFragment$filterTextWatcher$1(CustomAutoCompleteFragment customAutoCompleteFragment) {
        this.f59795b = customAutoCompleteFragment;
    }

    public void afterTextChanged(@NotNull Editable editable) {
        Filter filter;
        Intrinsics.checkNotNullParameter(editable, "s");
        Integer num = null;
        if (Intrinsics.areEqual((Object) editable.toString(), (Object) "") || !this.f59795b.isStartAutoComplete) {
            View access$getListCardView$p = this.f59795b.listCardView;
            if (access$getListCardView$p != null) {
                num = Integer.valueOf(access$getListCardView$p.getVisibility());
            }
            if (num == 0) {
                View access$getListCardView$p2 = this.f59795b.listCardView;
                if (access$getListCardView$p2 != null) {
                    access$getListCardView$p2.setVisibility(8);
                }
                View access$getClearView$p = this.f59795b.clearView;
                if (access$getClearView$p != null) {
                    access$getClearView$p.setVisibility(4);
                }
                RecyclerView access$getMPlaceRecyclerView$p = this.f59795b.mPlaceRecyclerView;
                if (access$getMPlaceRecyclerView$p != null) {
                    access$getMPlaceRecyclerView$p.setVisibility(8);
                    return;
                }
                return;
            }
            return;
        }
        PlacesAutoCompleteAdapter access$getMAutoCompleteAdapter$p = this.f59795b.mAutoCompleteAdapter;
        if (!(access$getMAutoCompleteAdapter$p == null || (filter = access$getMAutoCompleteAdapter$p.getFilter()) == null)) {
            filter.filter(editable.toString());
        }
        View access$getListCardView$p3 = this.f59795b.listCardView;
        if (access$getListCardView$p3 != null) {
            num = Integer.valueOf(access$getListCardView$p3.getVisibility());
        }
        if (num == 8) {
            View access$getListCardView$p4 = this.f59795b.listCardView;
            if (access$getListCardView$p4 != null) {
                access$getListCardView$p4.setVisibility(0);
            }
            View access$getClearView$p2 = this.f59795b.clearView;
            if (access$getClearView$p2 != null) {
                access$getClearView$p2.setVisibility(0);
            }
            RecyclerView access$getMPlaceRecyclerView$p2 = this.f59795b.mPlaceRecyclerView;
            if (access$getMPlaceRecyclerView$p2 != null) {
                access$getMPlaceRecyclerView$p2.setVisibility(0);
            }
        }
    }

    public void beforeTextChanged(@NotNull CharSequence charSequence, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
    }

    public void onTextChanged(@NotNull CharSequence charSequence, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
    }
}
