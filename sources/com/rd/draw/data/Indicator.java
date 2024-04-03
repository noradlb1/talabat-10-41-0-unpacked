package com.rd.draw.data;

import androidx.annotation.NonNull;
import com.rd.animation.type.AnimationType;

public class Indicator {
    public static final int COUNT_NONE = -1;
    public static final int DEFAULT_COUNT = 3;
    public static final int DEFAULT_PADDING_DP = 8;
    public static final int DEFAULT_RADIUS_DP = 6;
    public static final int IDLE_ANIMATION_DURATION = 250;
    public static final int MIN_COUNT = 1;
    private long animationDuration;
    private AnimationType animationType;
    private boolean autoVisibility;
    private int count = 3;
    private boolean dynamicCount;
    private boolean fadeOnIdle;
    private int height;
    private long idleDuration;
    private boolean interactiveAnimation;
    private boolean isIdle;
    private int lastSelectedPosition;
    private Orientation orientation;
    private int padding;
    private int paddingBottom;
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;
    private int radius;
    private RtlMode rtlMode;
    private float scaleFactor;
    private int selectedColor;
    private int selectedPosition;
    private int selectingPosition;
    private int stroke;
    private int unselectedColor;
    private int viewPagerId = -1;
    private int width;

    public long getAnimationDuration() {
        return this.animationDuration;
    }

    @NonNull
    public AnimationType getAnimationType() {
        if (this.animationType == null) {
            this.animationType = AnimationType.NONE;
        }
        return this.animationType;
    }

    public int getCount() {
        return this.count;
    }

    public int getHeight() {
        return this.height;
    }

    public long getIdleDuration() {
        return this.idleDuration;
    }

    public int getLastSelectedPosition() {
        return this.lastSelectedPosition;
    }

    @NonNull
    public Orientation getOrientation() {
        if (this.orientation == null) {
            this.orientation = Orientation.HORIZONTAL;
        }
        return this.orientation;
    }

    public int getPadding() {
        return this.padding;
    }

    public int getPaddingBottom() {
        return this.paddingBottom;
    }

    public int getPaddingLeft() {
        return this.paddingLeft;
    }

    public int getPaddingRight() {
        return this.paddingRight;
    }

    public int getPaddingTop() {
        return this.paddingTop;
    }

    public int getRadius() {
        return this.radius;
    }

    @NonNull
    public RtlMode getRtlMode() {
        if (this.rtlMode == null) {
            this.rtlMode = RtlMode.Off;
        }
        return this.rtlMode;
    }

    public float getScaleFactor() {
        return this.scaleFactor;
    }

    public int getSelectedColor() {
        return this.selectedColor;
    }

    public int getSelectedPosition() {
        return this.selectedPosition;
    }

    public int getSelectingPosition() {
        return this.selectingPosition;
    }

    public int getStroke() {
        return this.stroke;
    }

    public int getUnselectedColor() {
        return this.unselectedColor;
    }

    public int getViewPagerId() {
        return this.viewPagerId;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isAutoVisibility() {
        return this.autoVisibility;
    }

    public boolean isDynamicCount() {
        return this.dynamicCount;
    }

    public boolean isFadeOnIdle() {
        return this.fadeOnIdle;
    }

    public boolean isIdle() {
        return this.isIdle;
    }

    public boolean isInteractiveAnimation() {
        return this.interactiveAnimation;
    }

    public void setAnimationDuration(long j11) {
        this.animationDuration = j11;
    }

    public void setAnimationType(AnimationType animationType2) {
        this.animationType = animationType2;
    }

    public void setAutoVisibility(boolean z11) {
        this.autoVisibility = z11;
    }

    public void setCount(int i11) {
        this.count = i11;
    }

    public void setDynamicCount(boolean z11) {
        this.dynamicCount = z11;
    }

    public void setFadeOnIdle(boolean z11) {
        this.fadeOnIdle = z11;
    }

    public void setHeight(int i11) {
        this.height = i11;
    }

    public void setIdle(boolean z11) {
        this.isIdle = z11;
    }

    public void setIdleDuration(long j11) {
        this.idleDuration = j11;
    }

    public void setInteractiveAnimation(boolean z11) {
        this.interactiveAnimation = z11;
    }

    public void setLastSelectedPosition(int i11) {
        this.lastSelectedPosition = i11;
    }

    public void setOrientation(Orientation orientation2) {
        this.orientation = orientation2;
    }

    public void setPadding(int i11) {
        this.padding = i11;
    }

    public void setPaddingBottom(int i11) {
        this.paddingBottom = i11;
    }

    public void setPaddingLeft(int i11) {
        this.paddingLeft = i11;
    }

    public void setPaddingRight(int i11) {
        this.paddingRight = i11;
    }

    public void setPaddingTop(int i11) {
        this.paddingTop = i11;
    }

    public void setRadius(int i11) {
        this.radius = i11;
    }

    public void setRtlMode(RtlMode rtlMode2) {
        this.rtlMode = rtlMode2;
    }

    public void setScaleFactor(float f11) {
        this.scaleFactor = f11;
    }

    public void setSelectedColor(int i11) {
        this.selectedColor = i11;
    }

    public void setSelectedPosition(int i11) {
        this.selectedPosition = i11;
    }

    public void setSelectingPosition(int i11) {
        this.selectingPosition = i11;
    }

    public void setStroke(int i11) {
        this.stroke = i11;
    }

    public void setUnselectedColor(int i11) {
        this.unselectedColor = i11;
    }

    public void setViewPagerId(int i11) {
        this.viewPagerId = i11;
    }

    public void setWidth(int i11) {
        this.width = i11;
    }
}
