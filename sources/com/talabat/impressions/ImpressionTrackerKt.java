package com.talabat.impressions;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"getFirstAndLastViewedPosition", "Lkotlin/Pair;", "", "Landroidx/recyclerview/widget/RecyclerView;", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ImpressionTrackerKt {
    @NotNull
    public static final Pair<Integer, Integer> getFirstAndLastViewedPosition(@Nullable RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager;
        int i11;
        int i12;
        LinearLayoutManager linearLayoutManager;
        LinearLayoutManager linearLayoutManager2 = null;
        if (recyclerView != null) {
            layoutManager = recyclerView.getLayoutManager();
        } else {
            layoutManager = null;
        }
        int i13 = -1;
        try {
            if (!(layoutManager instanceof LinearLayoutManager)) {
                if (!(layoutManager instanceof GridLayoutManager)) {
                    i11 = -1;
                    return new Pair<>(Integer.valueOf(i13), Integer.valueOf(i11));
                }
            }
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            } else {
                linearLayoutManager = null;
            }
            if (linearLayoutManager != null) {
                i12 = linearLayoutManager.findFirstVisibleItemPosition();
            } else {
                i12 = -1;
            }
            try {
                if (layoutManager instanceof LinearLayoutManager) {
                    linearLayoutManager2 = (LinearLayoutManager) layoutManager;
                }
                if (linearLayoutManager2 != null) {
                    i13 = linearLayoutManager2.findLastVisibleItemPosition();
                }
            } catch (NullPointerException e11) {
                e = e11;
                LogManager.logException(e);
                i11 = i13;
                i13 = i12;
                return new Pair<>(Integer.valueOf(i13), Integer.valueOf(i11));
            }
        } catch (NullPointerException e12) {
            e = e12;
            i12 = -1;
            LogManager.logException(e);
            i11 = i13;
            i13 = i12;
            return new Pair<>(Integer.valueOf(i13), Integer.valueOf(i11));
        }
        i11 = i13;
        i13 = i12;
        return new Pair<>(Integer.valueOf(i13), Integer.valueOf(i11));
    }
}
