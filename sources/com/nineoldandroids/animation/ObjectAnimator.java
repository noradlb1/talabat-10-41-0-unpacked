package com.nineoldandroids.animation;

import android.view.View;
import com.huawei.hms.flutter.map.constants.Param;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.util.HashMap;
import java.util.Map;

public final class ObjectAnimator extends ValueAnimator {
    private static final boolean DBG = false;
    private static final Map<String, Property> PROXY_PROPERTIES;
    private Property mProperty;
    private String mPropertyName;
    private Object mTarget;

    static {
        HashMap hashMap = new HashMap();
        PROXY_PROPERTIES = hashMap;
        hashMap.put("alpha", PreHoneycombCompat.f52811a);
        hashMap.put("pivotX", PreHoneycombCompat.f52812b);
        hashMap.put("pivotY", PreHoneycombCompat.f52813c);
        hashMap.put("translationX", PreHoneycombCompat.f52814d);
        hashMap.put("translationY", PreHoneycombCompat.f52815e);
        hashMap.put("rotation", PreHoneycombCompat.f52816f);
        hashMap.put("rotationX", PreHoneycombCompat.f52817g);
        hashMap.put("rotationY", PreHoneycombCompat.f52818h);
        hashMap.put("scaleX", PreHoneycombCompat.f52819i);
        hashMap.put("scaleY", PreHoneycombCompat.f52820j);
        hashMap.put("scrollX", PreHoneycombCompat.f52821k);
        hashMap.put("scrollY", PreHoneycombCompat.f52822l);
        hashMap.put(Param.X, PreHoneycombCompat.f52823m);
        hashMap.put(Param.Y, PreHoneycombCompat.f52824n);
    }

    public ObjectAnimator() {
    }

    public static ObjectAnimator ofFloat(Object obj, String str, float... fArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.setFloatValues(fArr);
        return objectAnimator;
    }

    public static ObjectAnimator ofInt(Object obj, String str, int... iArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.setIntValues(iArr);
        return objectAnimator;
    }

    public static ObjectAnimator ofObject(Object obj, String str, TypeEvaluator typeEvaluator, Object... objArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.setObjectValues(objArr);
        objectAnimator.setEvaluator(typeEvaluator);
        return objectAnimator;
    }

    public static ObjectAnimator ofPropertyValuesHolder(Object obj, PropertyValuesHolder... propertyValuesHolderArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.mTarget = obj;
        objectAnimator.setValues(propertyValuesHolderArr);
        return objectAnimator;
    }

    public String getPropertyName() {
        return this.mPropertyName;
    }

    public Object getTarget() {
        return this.mTarget;
    }

    public void l(float f11) {
        super.l(f11);
        for (PropertyValuesHolder e11 : this.f52840g) {
            e11.e(this.mTarget);
        }
    }

    public void n() {
        if (!this.f52839f) {
            if (this.mProperty == null && AnimatorProxy.NEEDS_PROXY && (this.mTarget instanceof View)) {
                Map<String, Property> map = PROXY_PROPERTIES;
                if (map.containsKey(this.mPropertyName)) {
                    setProperty(map.get(this.mPropertyName));
                }
            }
            for (PropertyValuesHolder h11 : this.f52840g) {
                h11.h(this.mTarget);
            }
            super.n();
        }
    }

    public void setFloatValues(float... fArr) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.f52840g;
        if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
            Property property = this.mProperty;
            if (property != null) {
                setValues(PropertyValuesHolder.ofFloat((Property<?, Float>) property, fArr));
                return;
            }
            setValues(PropertyValuesHolder.ofFloat(this.mPropertyName, fArr));
            return;
        }
        super.setFloatValues(fArr);
    }

    public void setIntValues(int... iArr) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.f52840g;
        if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
            Property property = this.mProperty;
            if (property != null) {
                setValues(PropertyValuesHolder.ofInt((Property<?, Integer>) property, iArr));
                return;
            }
            setValues(PropertyValuesHolder.ofInt(this.mPropertyName, iArr));
            return;
        }
        super.setIntValues(iArr);
    }

    public void setObjectValues(Object... objArr) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.f52840g;
        if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
            Property property = this.mProperty;
            if (property != null) {
                setValues(PropertyValuesHolder.ofObject(property, (TypeEvaluator) null, (V[]) objArr));
                return;
            }
            setValues(PropertyValuesHolder.ofObject(this.mPropertyName, (TypeEvaluator) null, objArr));
            return;
        }
        super.setObjectValues(objArr);
    }

    public void setProperty(Property property) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.f52840g;
        if (propertyValuesHolderArr != null) {
            PropertyValuesHolder propertyValuesHolder = propertyValuesHolderArr[0];
            String propertyName = propertyValuesHolder.getPropertyName();
            propertyValuesHolder.setProperty(property);
            this.f52841h.remove(propertyName);
            this.f52841h.put(this.mPropertyName, propertyValuesHolder);
        }
        if (this.mProperty != null) {
            this.mPropertyName = property.getName();
        }
        this.mProperty = property;
        this.f52839f = false;
    }

    public void setPropertyName(String str) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.f52840g;
        if (propertyValuesHolderArr != null) {
            PropertyValuesHolder propertyValuesHolder = propertyValuesHolderArr[0];
            String propertyName = propertyValuesHolder.getPropertyName();
            propertyValuesHolder.setPropertyName(str);
            this.f52841h.remove(propertyName);
            this.f52841h.put(str, propertyValuesHolder);
        }
        this.mPropertyName = str;
        this.f52839f = false;
    }

    public void setTarget(Object obj) {
        Object obj2 = this.mTarget;
        if (obj2 != obj) {
            this.mTarget = obj;
            if (obj2 == null || obj == null || obj2.getClass() != obj.getClass()) {
                this.f52839f = false;
            }
        }
    }

    public void setupEndValues() {
        n();
        for (PropertyValuesHolder f11 : this.f52840g) {
            f11.f(this.mTarget);
        }
    }

    public void setupStartValues() {
        n();
        for (PropertyValuesHolder i11 : this.f52840g) {
            i11.i(this.mTarget);
        }
    }

    public void start() {
        super.start();
    }

    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.mTarget;
        if (this.f52840g != null) {
            for (int i11 = 0; i11 < this.f52840g.length; i11++) {
                str = str + "\n    " + this.f52840g[i11].toString();
            }
        }
        return str;
    }

    private ObjectAnimator(Object obj, String str) {
        this.mTarget = obj;
        setPropertyName(str);
    }

    public static <T> ObjectAnimator ofFloat(T t11, Property<T, Float> property, float... fArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(t11, property);
        objectAnimator.setFloatValues(fArr);
        return objectAnimator;
    }

    public static <T> ObjectAnimator ofInt(T t11, Property<T, Integer> property, int... iArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(t11, property);
        objectAnimator.setIntValues(iArr);
        return objectAnimator;
    }

    public ObjectAnimator setDuration(long j11) {
        super.setDuration(j11);
        return this;
    }

    public static <T, V> ObjectAnimator ofObject(T t11, Property<T, V> property, TypeEvaluator<V> typeEvaluator, V... vArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(t11, property);
        objectAnimator.setObjectValues(vArr);
        objectAnimator.setEvaluator(typeEvaluator);
        return objectAnimator;
    }

    public ObjectAnimator clone() {
        return (ObjectAnimator) super.clone();
    }

    private <T> ObjectAnimator(T t11, Property<T, ?> property) {
        this.mTarget = t11;
        setProperty(property);
    }
}
