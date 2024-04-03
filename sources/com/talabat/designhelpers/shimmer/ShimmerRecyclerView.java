package com.talabat.designhelpers.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;

public class ShimmerRecyclerView extends RecyclerView {
    private RecyclerView.Adapter mActualAdapter;
    private RecyclerView.LayoutManager mActualLayoutManager;
    /* access modifiers changed from: private */
    public boolean mCanScroll;
    private RecyclerView.AdapterDataObserver mDataObserver = new RecyclerView.AdapterDataObserver() {
        public void onChanged() {
            super.onChanged();
            ShimmerRecyclerView.this.updateEmptyView();
        }
    };
    private View mEmptyView;
    private int mGridCount = 2;
    private LayoutMangerType mLayoutMangerType = LayoutMangerType.LINEAR_VERTICAL;
    private int mLayoutReference = R.layout.layout_sample_view;
    private ShimmerAdapter mShimmerAdapter;
    private RecyclerView.LayoutManager mShimmerLayoutManager;

    /* renamed from: com.talabat.designhelpers.shimmer.ShimmerRecyclerView$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f58294a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.talabat.designhelpers.shimmer.ShimmerRecyclerView$LayoutMangerType[] r0 = com.talabat.designhelpers.shimmer.ShimmerRecyclerView.LayoutMangerType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f58294a = r0
                com.talabat.designhelpers.shimmer.ShimmerRecyclerView$LayoutMangerType r1 = com.talabat.designhelpers.shimmer.ShimmerRecyclerView.LayoutMangerType.LINEAR_VERTICAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f58294a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.talabat.designhelpers.shimmer.ShimmerRecyclerView$LayoutMangerType r1 = com.talabat.designhelpers.shimmer.ShimmerRecyclerView.LayoutMangerType.LINEAR_HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f58294a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.talabat.designhelpers.shimmer.ShimmerRecyclerView$LayoutMangerType r1 = com.talabat.designhelpers.shimmer.ShimmerRecyclerView.LayoutMangerType.GRID     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.designhelpers.shimmer.ShimmerRecyclerView.AnonymousClass5.<clinit>():void");
        }
    }

    public enum LayoutMangerType {
        LINEAR_VERTICAL,
        LINEAR_HORIZONTAL,
        GRID
    }

    public ShimmerRecyclerView(Context context) {
        super(context);
        init((AttributeSet) null);
    }

    private int getColor(int i11) {
        return getContext().getColor(i11);
    }

    /* JADX INFO: finally extract failed */
    private void init(AttributeSet attributeSet) {
        this.mShimmerAdapter = new ShimmerAdapter();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.talabat.talabatcommon.R.styleable.ShimmerRecyclerView, 0, 0);
        try {
            if (obtainStyledAttributes.hasValue(3)) {
                setDemoLayoutReference(obtainStyledAttributes.getResourceId(3, R.layout.layout_sample_view));
            }
            if (obtainStyledAttributes.hasValue(1)) {
                setDemoChildCount(obtainStyledAttributes.getInteger(1, 1));
            }
            if (obtainStyledAttributes.hasValue(4)) {
                int integer = obtainStyledAttributes.getInteger(4, 0);
                if (integer == 1) {
                    setDemoLayoutManager(LayoutMangerType.LINEAR_HORIZONTAL);
                } else if (integer != 2) {
                    setDemoLayoutManager(LayoutMangerType.LINEAR_VERTICAL);
                } else {
                    setDemoLayoutManager(LayoutMangerType.GRID);
                }
            }
            if (obtainStyledAttributes.hasValue(2)) {
                setGridChildCount(obtainStyledAttributes.getInteger(2, 2));
            }
            int integer2 = obtainStyledAttributes.getInteger(0, 20);
            int color = obtainStyledAttributes.getColor(5, getColor(R.color.default_shimmer_color));
            Drawable drawable = obtainStyledAttributes.getDrawable(6);
            obtainStyledAttributes.recycle();
            this.mShimmerAdapter.setShimmerAngle(integer2);
            this.mShimmerAdapter.setShimmerColor(color);
            this.mShimmerAdapter.setShimmerItemBackground(drawable);
            showShimmerAdapter();
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    private void initShimmerManager() {
        int i11 = AnonymousClass5.f58294a[this.mLayoutMangerType.ordinal()];
        if (i11 == 1) {
            this.mShimmerLayoutManager = new LinearLayoutManager(getContext()) {
                public boolean canScrollVertically() {
                    return ShimmerRecyclerView.this.mCanScroll;
                }
            };
        } else if (i11 == 2) {
            this.mShimmerLayoutManager = new LinearLayoutManager(getContext(), 0, false) {
                public boolean canScrollHorizontally() {
                    return ShimmerRecyclerView.this.mCanScroll;
                }
            };
        } else if (i11 == 3) {
            this.mShimmerLayoutManager = new GridLayoutManager(getContext(), this.mGridCount) {
                public boolean canScrollVertically() {
                    return ShimmerRecyclerView.this.mCanScroll;
                }
            };
        }
    }

    /* access modifiers changed from: private */
    public void updateEmptyView() {
        boolean z11;
        int i11;
        if (this.mEmptyView != null && getAdapter() != null) {
            int i12 = 0;
            if (getAdapter().getItemCount() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            View view = this.mEmptyView;
            if (z11) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            view.setVisibility(i11);
            if (z11) {
                i12 = 8;
            }
            setVisibility(i12);
        }
    }

    public RecyclerView.Adapter getActualAdapter() {
        return this.mActualAdapter;
    }

    public int getLayoutReference() {
        return this.mLayoutReference;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter == null) {
            this.mActualAdapter = null;
        } else if (adapter != this.mShimmerAdapter) {
            this.mActualAdapter = adapter;
        }
        if (getAdapter() != null) {
            getAdapter().unregisterAdapterDataObserver(this.mDataObserver);
        }
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mDataObserver);
        }
        super.setAdapter(adapter);
        updateEmptyView();
    }

    public void setDemoChildCount(int i11) {
        this.mShimmerAdapter.setMinItemCount(i11);
    }

    public void setDemoLayoutManager(LayoutMangerType layoutMangerType) {
        this.mLayoutMangerType = layoutMangerType;
    }

    public void setDemoLayoutReference(int i11) {
        this.mLayoutReference = i11;
        this.mShimmerAdapter.setLayoutReference(getLayoutReference());
    }

    public void setEmptyView(View view) {
        this.mEmptyView = view;
    }

    public void setGridChildCount(int i11) {
        this.mGridCount = i11;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager == null) {
            this.mActualLayoutManager = null;
        } else if (layoutManager != this.mShimmerLayoutManager) {
            this.mActualLayoutManager = layoutManager;
        }
        super.setLayoutManager(layoutManager);
    }

    public void setShimmerColor(int i11) {
        this.mShimmerAdapter.setShimmerColor(i11);
    }

    public void showShimmerAdapter() {
        this.mCanScroll = false;
        if (this.mShimmerLayoutManager == null) {
            initShimmerManager();
        }
        setLayoutManager(this.mShimmerLayoutManager);
        setAdapter(this.mShimmerAdapter);
    }

    public ShimmerRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public ShimmerRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(attributeSet);
    }
}
