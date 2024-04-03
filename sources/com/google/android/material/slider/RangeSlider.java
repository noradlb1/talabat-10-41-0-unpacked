package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import java.util.ArrayList;
import java.util.List;

public class RangeSlider extends BaseSlider<RangeSlider, OnChangeListener, OnSliderTouchListener> {
    private float minSeparation;
    private int separationUnit;

    public interface OnChangeListener extends BaseOnChangeListener<RangeSlider> {
    }

    public interface OnSliderTouchListener extends BaseOnSliderTouchListener<RangeSlider> {
    }

    public static class RangeSliderState extends AbsSavedState {
        public static final Parcelable.Creator<RangeSliderState> CREATOR = new Parcelable.Creator<RangeSliderState>() {
            public RangeSliderState createFromParcel(Parcel parcel) {
                return new RangeSliderState(parcel);
            }

            public RangeSliderState[] newArray(int i11) {
                return new RangeSliderState[i11];
            }
        };
        /* access modifiers changed from: private */
        public float minSeparation;
        /* access modifiers changed from: private */
        public int separationUnit;

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeFloat(this.minSeparation);
            parcel.writeInt(this.separationUnit);
        }

        public RangeSliderState(Parcelable parcelable) {
            super(parcelable);
        }

        private RangeSliderState(Parcel parcel) {
            super(parcel.readParcelable(RangeSliderState.class.getClassLoader()));
            this.minSeparation = parcel.readFloat();
            this.separationUnit = parcel.readInt();
        }
    }

    public RangeSlider(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private static List<Float> convertToFloat(TypedArray typedArray) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < typedArray.length(); i11++) {
            arrayList.add(Float.valueOf(typedArray.getFloat(i11, -1.0f)));
        }
        return arrayList;
    }

    public /* bridge */ /* synthetic */ void clearOnChangeListeners() {
        super.clearOnChangeListeners();
    }

    public /* bridge */ /* synthetic */ void clearOnSliderTouchListeners() {
        super.clearOnSliderTouchListeners();
    }

    public /* bridge */ /* synthetic */ boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return super.dispatchHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @NonNull
    public /* bridge */ /* synthetic */ CharSequence getAccessibilityClassName() {
        return super.getAccessibilityClassName();
    }

    public /* bridge */ /* synthetic */ int getActiveThumbIndex() {
        return super.getActiveThumbIndex();
    }

    public /* bridge */ /* synthetic */ int getFocusedThumbIndex() {
        return super.getFocusedThumbIndex();
    }

    @Dimension
    public /* bridge */ /* synthetic */ int getHaloRadius() {
        return super.getHaloRadius();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getHaloTintList() {
        return super.getHaloTintList();
    }

    public /* bridge */ /* synthetic */ int getLabelBehavior() {
        return super.getLabelBehavior();
    }

    public float getMinSeparation() {
        return this.minSeparation;
    }

    public /* bridge */ /* synthetic */ float getStepSize() {
        return super.getStepSize();
    }

    public /* bridge */ /* synthetic */ float getThumbElevation() {
        return super.getThumbElevation();
    }

    @Dimension
    public /* bridge */ /* synthetic */ int getThumbRadius() {
        return super.getThumbRadius();
    }

    public /* bridge */ /* synthetic */ ColorStateList getThumbStrokeColor() {
        return super.getThumbStrokeColor();
    }

    public /* bridge */ /* synthetic */ float getThumbStrokeWidth() {
        return super.getThumbStrokeWidth();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getThumbTintList() {
        return super.getThumbTintList();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTickActiveTintList() {
        return super.getTickActiveTintList();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTickInactiveTintList() {
        return super.getTickInactiveTintList();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTickTintList() {
        return super.getTickTintList();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTrackActiveTintList() {
        return super.getTrackActiveTintList();
    }

    @Dimension
    public /* bridge */ /* synthetic */ int getTrackHeight() {
        return super.getTrackHeight();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTrackInactiveTintList() {
        return super.getTrackInactiveTintList();
    }

    @Dimension
    public /* bridge */ /* synthetic */ int getTrackSidePadding() {
        return super.getTrackSidePadding();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTrackTintList() {
        return super.getTrackTintList();
    }

    @Dimension
    public /* bridge */ /* synthetic */ int getTrackWidth() {
        return super.getTrackWidth();
    }

    public /* bridge */ /* synthetic */ float getValueFrom() {
        return super.getValueFrom();
    }

    public /* bridge */ /* synthetic */ float getValueTo() {
        return super.getValueTo();
    }

    @NonNull
    public List<Float> getValues() {
        return super.getValues();
    }

    public /* bridge */ /* synthetic */ boolean hasLabelFormatter() {
        return super.hasLabelFormatter();
    }

    public /* bridge */ /* synthetic */ boolean isTickVisible() {
        return super.isTickVisible();
    }

    public /* bridge */ /* synthetic */ boolean onKeyDown(int i11, @NonNull KeyEvent keyEvent) {
        return super.onKeyDown(i11, keyEvent);
    }

    public /* bridge */ /* synthetic */ boolean onKeyUp(int i11, @NonNull KeyEvent keyEvent) {
        return super.onKeyUp(i11, keyEvent);
    }

    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        RangeSliderState rangeSliderState = (RangeSliderState) parcelable;
        super.onRestoreInstanceState(rangeSliderState.getSuperState());
        this.minSeparation = rangeSliderState.minSeparation;
        int access$100 = rangeSliderState.separationUnit;
        this.separationUnit = access$100;
        setSeparationUnit(access$100);
    }

    @NonNull
    public Parcelable onSaveInstanceState() {
        RangeSliderState rangeSliderState = new RangeSliderState(super.onSaveInstanceState());
        float unused = rangeSliderState.minSeparation = this.minSeparation;
        int unused2 = rangeSliderState.separationUnit = this.separationUnit;
        return rangeSliderState;
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void setEnabled(boolean z11) {
        super.setEnabled(z11);
    }

    public /* bridge */ /* synthetic */ void setFocusedThumbIndex(int i11) {
        super.setFocusedThumbIndex(i11);
    }

    public /* bridge */ /* synthetic */ void setHaloRadius(@Dimension @IntRange(from = 0) int i11) {
        super.setHaloRadius(i11);
    }

    public /* bridge */ /* synthetic */ void setHaloRadiusResource(@DimenRes int i11) {
        super.setHaloRadiusResource(i11);
    }

    public /* bridge */ /* synthetic */ void setHaloTintList(@NonNull ColorStateList colorStateList) {
        super.setHaloTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setLabelBehavior(int i11) {
        super.setLabelBehavior(i11);
    }

    public /* bridge */ /* synthetic */ void setLabelFormatter(@Nullable LabelFormatter labelFormatter) {
        super.setLabelFormatter(labelFormatter);
    }

    public void setMinSeparation(@Dimension float f11) {
        this.minSeparation = f11;
        this.separationUnit = 0;
        setSeparationUnit(0);
    }

    public void setMinSeparationValue(float f11) {
        this.minSeparation = f11;
        this.separationUnit = 1;
        setSeparationUnit(1);
    }

    public /* bridge */ /* synthetic */ void setStepSize(float f11) {
        super.setStepSize(f11);
    }

    public /* bridge */ /* synthetic */ void setThumbElevation(float f11) {
        super.setThumbElevation(f11);
    }

    public /* bridge */ /* synthetic */ void setThumbElevationResource(@DimenRes int i11) {
        super.setThumbElevationResource(i11);
    }

    public /* bridge */ /* synthetic */ void setThumbRadius(@Dimension @IntRange(from = 0) int i11) {
        super.setThumbRadius(i11);
    }

    public /* bridge */ /* synthetic */ void setThumbRadiusResource(@DimenRes int i11) {
        super.setThumbRadiusResource(i11);
    }

    public /* bridge */ /* synthetic */ void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        super.setThumbStrokeColor(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setThumbStrokeColorResource(@ColorRes int i11) {
        super.setThumbStrokeColorResource(i11);
    }

    public /* bridge */ /* synthetic */ void setThumbStrokeWidth(float f11) {
        super.setThumbStrokeWidth(f11);
    }

    public /* bridge */ /* synthetic */ void setThumbStrokeWidthResource(@DimenRes int i11) {
        super.setThumbStrokeWidthResource(i11);
    }

    public /* bridge */ /* synthetic */ void setThumbTintList(@NonNull ColorStateList colorStateList) {
        super.setThumbTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTickActiveTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTickInactiveTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTickTintList(@NonNull ColorStateList colorStateList) {
        super.setTickTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTickVisible(boolean z11) {
        super.setTickVisible(z11);
    }

    public /* bridge */ /* synthetic */ void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackActiveTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTrackHeight(@Dimension @IntRange(from = 0) int i11) {
        super.setTrackHeight(i11);
    }

    public /* bridge */ /* synthetic */ void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackInactiveTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTrackTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setValueFrom(float f11) {
        super.setValueFrom(f11);
    }

    public /* bridge */ /* synthetic */ void setValueTo(float f11) {
        super.setValueTo(f11);
    }

    public void setValues(@NonNull Float... fArr) {
        super.setValues(fArr);
    }

    public RangeSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    public void setValues(@NonNull List<Float> list) {
        super.setValues(list);
    }

    public RangeSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.RangeSlider, i11, BaseSlider.DEF_STYLE_RES, new int[0]);
        int i12 = R.styleable.RangeSlider_values;
        if (obtainStyledAttributes.hasValue(i12)) {
            setValues(convertToFloat(obtainStyledAttributes.getResources().obtainTypedArray(obtainStyledAttributes.getResourceId(i12, 0))));
        }
        this.minSeparation = obtainStyledAttributes.getDimension(R.styleable.RangeSlider_minSeparation, 0.0f);
        obtainStyledAttributes.recycle();
    }
}
