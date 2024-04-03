package com.deliveryhero.impression.view;

import android.view.View;
import androidx.annotation.IntRange;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/deliveryhero/impression/view/ItemVisibleArea;", "", "position", "", "view", "Landroid/view/View;", "percent", "(ILandroid/view/View;I)V", "getPercent", "()I", "getPosition", "getView", "()Landroid/view/View;", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ItemVisibleArea {
    public static final int $stable = 8;
    private final int percent;
    private final int position;
    @Nullable
    private final View view;

    public ItemVisibleArea(int i11, @Nullable View view2, @IntRange(from = 1, to = 100) int i12) {
        this.position = i11;
        this.view = view2;
        this.percent = i12;
    }

    public final int getPercent() {
        return this.percent;
    }

    public final int getPosition() {
        return this.position;
    }

    @Nullable
    public final View getView() {
        return this.view;
    }
}
