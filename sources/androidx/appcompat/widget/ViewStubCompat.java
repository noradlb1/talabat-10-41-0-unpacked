package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ViewStubCompat extends View {
    private OnInflateListener mInflateListener;
    private int mInflatedId;
    private WeakReference<View> mInflatedViewRef;
    private LayoutInflater mInflater;
    private int mLayoutResource;

    public interface OnInflateListener {
        void onInflate(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void dispatchDraw(Canvas canvas) {
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.mInflatedId;
    }

    public LayoutInflater getLayoutInflater() {
        return this.mInflater;
    }

    public int getLayoutResource() {
        return this.mLayoutResource;
    }

    public View inflate() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.mLayoutResource != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            LayoutInflater layoutInflater = this.mInflater;
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.mLayoutResource, viewGroup, false);
            int i11 = this.mInflatedId;
            if (i11 != -1) {
                inflate.setId(i11);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.mInflatedViewRef = new WeakReference<>(inflate);
            OnInflateListener onInflateListener = this.mInflateListener;
            if (onInflateListener != null) {
                onInflateListener.onInflate(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i11) {
        this.mInflatedId = i11;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.mInflater = layoutInflater;
    }

    public void setLayoutResource(int i11) {
        this.mLayoutResource = i11;
    }

    public void setOnInflateListener(OnInflateListener onInflateListener) {
        this.mInflateListener = onInflateListener;
    }

    public void setVisibility(int i11) {
        WeakReference<View> weakReference = this.mInflatedViewRef;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(i11);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i11);
        if (i11 == 0 || i11 == 4) {
            inflate();
        }
    }

    public ViewStubCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mLayoutResource = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewStubCompat, i11, 0);
        this.mInflatedId = obtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_inflatedId, -1);
        this.mLayoutResource = obtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
