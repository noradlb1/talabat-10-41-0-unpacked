package com.uxcam.datamodel;

import androidx.compose.ui.layout.LayoutCoordinates;
import java.lang.ref.WeakReference;

public class OccludeComposable {
    public float bottom;
    public Object identifier;
    public LayoutCoordinates layoutCoordinates;
    public float parentX;
    public float parentY;
    public float right;
    public float top;
    public WeakReference view;

    /* renamed from: x  reason: collision with root package name */
    public float f12929x;

    /* renamed from: y  reason: collision with root package name */
    public float f12930y;

    public OccludeComposable(Object obj, WeakReference weakReference, float f11, float f12, float f13, float f14, float f15, LayoutCoordinates layoutCoordinates2, float f16, float f17) {
        this.identifier = obj;
        this.view = weakReference;
        this.f12929x = f11;
        this.f12930y = f12;
        this.top = f13;
        this.bottom = f14;
        this.right = f15;
        this.layoutCoordinates = layoutCoordinates2;
        this.parentX = f16;
        this.parentY = f17;
    }

    public float getBottom() {
        return this.bottom;
    }

    public Object getIdentifier() {
        return this.identifier;
    }

    public LayoutCoordinates getLayoutCoordinates() {
        return this.layoutCoordinates;
    }

    public float getParentX() {
        return this.parentX;
    }

    public float getParentY() {
        return this.parentY;
    }

    public float getRight() {
        return this.right;
    }

    public float getTop() {
        return this.top;
    }

    public WeakReference getView() {
        return this.view;
    }

    public float getX() {
        return this.f12929x;
    }

    public float getY() {
        return this.f12930y;
    }
}
