package com.nineoldandroids.animation;

import android.view.View;
import com.huawei.hms.flutter.map.constants.Param;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;

final class PreHoneycombCompat {

    /* renamed from: a  reason: collision with root package name */
    public static Property<View, Float> f52811a = new FloatProperty<View>("alpha") {
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getAlpha());
        }

        public void setValue(View view, float f11) {
            AnimatorProxy.wrap(view).setAlpha(f11);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static Property<View, Float> f52812b = new FloatProperty<View>("pivotX") {
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getPivotX());
        }

        public void setValue(View view, float f11) {
            AnimatorProxy.wrap(view).setPivotX(f11);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static Property<View, Float> f52813c = new FloatProperty<View>("pivotY") {
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getPivotY());
        }

        public void setValue(View view, float f11) {
            AnimatorProxy.wrap(view).setPivotY(f11);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static Property<View, Float> f52814d = new FloatProperty<View>("translationX") {
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getTranslationX());
        }

        public void setValue(View view, float f11) {
            AnimatorProxy.wrap(view).setTranslationX(f11);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static Property<View, Float> f52815e = new FloatProperty<View>("translationY") {
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getTranslationY());
        }

        public void setValue(View view, float f11) {
            AnimatorProxy.wrap(view).setTranslationY(f11);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static Property<View, Float> f52816f = new FloatProperty<View>("rotation") {
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotation());
        }

        public void setValue(View view, float f11) {
            AnimatorProxy.wrap(view).setRotation(f11);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static Property<View, Float> f52817g = new FloatProperty<View>("rotationX") {
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotationX());
        }

        public void setValue(View view, float f11) {
            AnimatorProxy.wrap(view).setRotationX(f11);
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public static Property<View, Float> f52818h = new FloatProperty<View>("rotationY") {
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotationY());
        }

        public void setValue(View view, float f11) {
            AnimatorProxy.wrap(view).setRotationY(f11);
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public static Property<View, Float> f52819i = new FloatProperty<View>("scaleX") {
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getScaleX());
        }

        public void setValue(View view, float f11) {
            AnimatorProxy.wrap(view).setScaleX(f11);
        }
    };

    /* renamed from: j  reason: collision with root package name */
    public static Property<View, Float> f52820j = new FloatProperty<View>("scaleY") {
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getScaleY());
        }

        public void setValue(View view, float f11) {
            AnimatorProxy.wrap(view).setScaleY(f11);
        }
    };

    /* renamed from: k  reason: collision with root package name */
    public static Property<View, Integer> f52821k = new IntProperty<View>("scrollX") {
        public Integer get(View view) {
            return Integer.valueOf(AnimatorProxy.wrap(view).getScrollX());
        }

        public void setValue(View view, int i11) {
            AnimatorProxy.wrap(view).setScrollX(i11);
        }
    };

    /* renamed from: l  reason: collision with root package name */
    public static Property<View, Integer> f52822l = new IntProperty<View>("scrollY") {
        public Integer get(View view) {
            return Integer.valueOf(AnimatorProxy.wrap(view).getScrollY());
        }

        public void setValue(View view, int i11) {
            AnimatorProxy.wrap(view).setScrollY(i11);
        }
    };

    /* renamed from: m  reason: collision with root package name */
    public static Property<View, Float> f52823m = new FloatProperty<View>(Param.X) {
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getX());
        }

        public void setValue(View view, float f11) {
            AnimatorProxy.wrap(view).setX(f11);
        }
    };

    /* renamed from: n  reason: collision with root package name */
    public static Property<View, Float> f52824n = new FloatProperty<View>(Param.Y) {
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getY());
        }

        public void setValue(View view, float f11) {
            AnimatorProxy.wrap(view).setY(f11);
        }
    };

    private PreHoneycombCompat() {
    }
}
