package com.github.rubensousa.gravitysnaphelper;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

public class GravitySnapRecyclerView extends OrientationAwareRecyclerView {
    private boolean isSnappingEnabled;
    @NonNull
    private final GravitySnapHelper snapHelper;

    public GravitySnapRecyclerView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void snapTo(Boolean bool, Boolean bool2) {
        View findSnapView;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null && (findSnapView = this.snapHelper.findSnapView(layoutManager, false)) != null) {
            int childAdapterPosition = getChildAdapterPosition(findSnapView);
            if (bool.booleanValue()) {
                if (bool2.booleanValue()) {
                    smoothScrollToPosition(childAdapterPosition + 1);
                } else {
                    scrollToPosition(childAdapterPosition + 1);
                }
            } else if (childAdapterPosition <= 0) {
            } else {
                if (bool2.booleanValue()) {
                    smoothScrollToPosition(childAdapterPosition - 1);
                } else {
                    scrollToPosition(childAdapterPosition - 1);
                }
            }
        }
    }

    public void enableSnapping(Boolean bool) {
        if (bool.booleanValue()) {
            this.snapHelper.attachToRecyclerView(this);
        } else {
            this.snapHelper.attachToRecyclerView((RecyclerView) null);
        }
        this.isSnappingEnabled = bool.booleanValue();
    }

    public int getCurrentSnappedPosition() {
        return this.snapHelper.getCurrentSnappedPosition();
    }

    @NonNull
    public GravitySnapHelper getSnapHelper() {
        return this.snapHelper;
    }

    public boolean isSnappingEnabled() {
        return this.isSnappingEnabled;
    }

    public void scrollToPosition(int i11) {
        if (!this.isSnappingEnabled || !this.snapHelper.scrollToPosition(i11)) {
            super.scrollToPosition(i11);
        }
    }

    public void setSnapListener(@Nullable GravitySnapHelper.SnapListener snapListener) {
        this.snapHelper.setSnapListener(snapListener);
    }

    public void smoothScrollToPosition(int i11) {
        if (!this.isSnappingEnabled || !this.snapHelper.smoothScrollToPosition(i11)) {
            super.smoothScrollToPosition(i11);
        }
    }

    public void snapToNextPosition(Boolean bool) {
        snapTo(Boolean.TRUE, bool);
    }

    public void snapToPreviousPosition(Boolean bool) {
        snapTo(Boolean.FALSE, bool);
    }

    public GravitySnapRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GravitySnapRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.isSnappingEnabled = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GravitySnapRecyclerView, i11, 0);
        int i12 = obtainStyledAttributes.getInt(R.styleable.GravitySnapRecyclerView_snapGravity, 0);
        if (i12 == 0) {
            this.snapHelper = new GravitySnapHelper(GravityCompat.START);
        } else if (i12 == 1) {
            this.snapHelper = new GravitySnapHelper(48);
        } else if (i12 == 2) {
            this.snapHelper = new GravitySnapHelper(GravityCompat.END);
        } else if (i12 == 3) {
            this.snapHelper = new GravitySnapHelper(80);
        } else if (i12 == 4) {
            this.snapHelper = new GravitySnapHelper(17);
        } else {
            throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP | CENTER constants");
        }
        this.snapHelper.setSnapToPadding(obtainStyledAttributes.getBoolean(R.styleable.GravitySnapRecyclerView_snapToPadding, false));
        this.snapHelper.setSnapLastItem(obtainStyledAttributes.getBoolean(R.styleable.GravitySnapRecyclerView_snapLastItem, false));
        this.snapHelper.setMaxFlingSizeFraction(obtainStyledAttributes.getFloat(R.styleable.GravitySnapRecyclerView_snapMaxFlingSizeFraction, -1.0f));
        this.snapHelper.setScrollMsPerInch(obtainStyledAttributes.getFloat(R.styleable.GravitySnapRecyclerView_snapScrollMsPerInch, 100.0f));
        enableSnapping(Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.GravitySnapRecyclerView_snapEnabled, true)));
        obtainStyledAttributes.recycle();
    }
}
