package com.nineoldandroids.animation;

import android.util.Log;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PropertyValuesHolder implements Cloneable {
    private static Class[] DOUBLE_VARIANTS;
    private static Class[] FLOAT_VARIANTS;
    private static Class[] INTEGER_VARIANTS;
    private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    private static final HashMap<Class, HashMap<String, Method>> sGetterPropertyMap = new HashMap<>();
    private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    private static final HashMap<Class, HashMap<String, Method>> sSetterPropertyMap = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public String f52825b;

    /* renamed from: c  reason: collision with root package name */
    public Property f52826c;

    /* renamed from: d  reason: collision with root package name */
    public Method f52827d;

    /* renamed from: e  reason: collision with root package name */
    public Class f52828e;

    /* renamed from: f  reason: collision with root package name */
    public KeyframeSet f52829f;

    /* renamed from: g  reason: collision with root package name */
    public final ReentrantReadWriteLock f52830g;

    /* renamed from: h  reason: collision with root package name */
    public final Object[] f52831h;
    private Object mAnimatedValue;
    private TypeEvaluator mEvaluator;
    private Method mGetter;

    static {
        Class cls = Float.TYPE;
        Class<Float> cls2 = Float.class;
        Class cls3 = Double.TYPE;
        Class cls4 = Integer.TYPE;
        Class<Double> cls5 = Double.class;
        Class<Integer> cls6 = Integer.class;
        FLOAT_VARIANTS = new Class[]{cls, cls2, cls3, cls4, cls5, cls6};
        INTEGER_VARIANTS = new Class[]{cls4, cls6, cls, cls3, cls2, cls5};
        DOUBLE_VARIANTS = new Class[]{cls3, cls5, cls, cls4, cls2, cls6};
    }

    public static String c(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        char upperCase = Character.toUpperCase(str2.charAt(0));
        String substring = str2.substring(1);
        return str + upperCase + substring;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0079, code lost:
        return r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x007a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.reflect.Method getPropertyFunction(java.lang.Class r9, java.lang.String r10, java.lang.Class r11) {
        /*
            r8 = this;
            java.lang.String r0 = r8.f52825b
            java.lang.String r10 = c(r10, r0)
            java.lang.String r0 = "PropertyValuesHolder"
            r1 = 1
            r2 = 0
            if (r11 != 0) goto L_0x003b
            java.lang.reflect.Method r9 = r9.getMethod(r10, r2)     // Catch:{ NoSuchMethodException -> 0x0012 }
            goto L_0x00a8
        L_0x0012:
            r11 = move-exception
            java.lang.reflect.Method r2 = r9.getDeclaredMethod(r10, r2)     // Catch:{ NoSuchMethodException -> 0x001c }
            r2.setAccessible(r1)     // Catch:{ NoSuchMethodException -> 0x001c }
            goto L_0x00a7
        L_0x001c:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Couldn't find no-arg method for property "
            r9.append(r10)
            java.lang.String r10 = r8.f52825b
            r9.append(r10)
            java.lang.String r10 = ": "
            r9.append(r10)
            r9.append(r11)
            java.lang.String r9 = r9.toString()
            android.util.Log.e(r0, r9)
            goto L_0x00a7
        L_0x003b:
            java.lang.Class[] r11 = new java.lang.Class[r1]
            java.lang.Class r3 = r8.f52828e
            java.lang.Class<java.lang.Float> r4 = java.lang.Float.class
            boolean r3 = r3.equals(r4)
            r4 = 0
            if (r3 == 0) goto L_0x004b
            java.lang.Class[] r3 = FLOAT_VARIANTS
            goto L_0x006b
        L_0x004b:
            java.lang.Class r3 = r8.f52828e
            java.lang.Class<java.lang.Integer> r5 = java.lang.Integer.class
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0058
            java.lang.Class[] r3 = INTEGER_VARIANTS
            goto L_0x006b
        L_0x0058:
            java.lang.Class r3 = r8.f52828e
            java.lang.Class<java.lang.Double> r5 = java.lang.Double.class
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0065
            java.lang.Class[] r3 = DOUBLE_VARIANTS
            goto L_0x006b
        L_0x0065:
            java.lang.Class[] r3 = new java.lang.Class[r1]
            java.lang.Class r5 = r8.f52828e
            r3[r4] = r5
        L_0x006b:
            int r5 = r3.length
            r6 = r4
        L_0x006d:
            if (r6 >= r5) goto L_0x0087
            r7 = r3[r6]
            r11[r4] = r7
            java.lang.reflect.Method r2 = r9.getMethod(r10, r11)     // Catch:{ NoSuchMethodException -> 0x007a }
            r8.f52828e = r7     // Catch:{ NoSuchMethodException -> 0x007a }
            return r2
        L_0x007a:
            java.lang.reflect.Method r2 = r9.getDeclaredMethod(r10, r11)     // Catch:{ NoSuchMethodException -> 0x0084 }
            r2.setAccessible(r1)     // Catch:{ NoSuchMethodException -> 0x0084 }
            r8.f52828e = r7     // Catch:{ NoSuchMethodException -> 0x0084 }
            return r2
        L_0x0084:
            int r6 = r6 + 1
            goto L_0x006d
        L_0x0087:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Couldn't find setter/getter for property "
            r9.append(r10)
            java.lang.String r10 = r8.f52825b
            r9.append(r10)
            java.lang.String r10 = " with value type "
            r9.append(r10)
            java.lang.Class r10 = r8.f52828e
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.util.Log.e(r0, r9)
        L_0x00a7:
            r9 = r2
        L_0x00a8:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nineoldandroids.animation.PropertyValuesHolder.getPropertyFunction(java.lang.Class, java.lang.String, java.lang.Class):java.lang.reflect.Method");
    }

    public static PropertyValuesHolder ofFloat(String str, float... fArr) {
        return new FloatPropertyValuesHolder(str, fArr);
    }

    public static PropertyValuesHolder ofInt(String str, int... iArr) {
        return new IntPropertyValuesHolder(str, iArr);
    }

    public static PropertyValuesHolder ofKeyframe(String str, Keyframe... keyframeArr) {
        KeyframeSet ofKeyframe = KeyframeSet.ofKeyframe(keyframeArr);
        if (ofKeyframe instanceof IntKeyframeSet) {
            return new IntPropertyValuesHolder(str, (IntKeyframeSet) ofKeyframe);
        }
        if (ofKeyframe instanceof FloatKeyframeSet) {
            return new FloatPropertyValuesHolder(str, (FloatKeyframeSet) ofKeyframe);
        }
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(str);
        propertyValuesHolder.f52829f = ofKeyframe;
        propertyValuesHolder.f52828e = keyframeArr[0].getType();
        return propertyValuesHolder;
    }

    public static PropertyValuesHolder ofObject(String str, TypeEvaluator typeEvaluator, Object... objArr) {
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(str);
        propertyValuesHolder.setObjectValues(objArr);
        propertyValuesHolder.setEvaluator(typeEvaluator);
        return propertyValuesHolder;
    }

    private void setupGetter(Class cls) {
        this.mGetter = setupSetterOrGetter(cls, sGetterPropertyMap, "get", (Class) null);
    }

    private Method setupSetterOrGetter(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        Method method;
        try {
            this.f52830g.writeLock().lock();
            HashMap hashMap2 = hashMap.get(cls);
            if (hashMap2 != null) {
                method = (Method) hashMap2.get(this.f52825b);
            } else {
                method = null;
            }
            if (method == null) {
                method = getPropertyFunction(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.f52825b, method);
            }
            return method;
        } finally {
            this.f52830g.writeLock().unlock();
        }
    }

    private void setupValue(Object obj, Keyframe keyframe) {
        Property property = this.f52826c;
        if (property != null) {
            keyframe.setValue(property.get(obj));
        }
        try {
            if (this.mGetter == null) {
                setupGetter(obj.getClass());
            }
            keyframe.setValue(this.mGetter.invoke(obj, new Object[0]));
        } catch (InvocationTargetException e11) {
            Log.e("PropertyValuesHolder", e11.toString());
        } catch (IllegalAccessException e12) {
            Log.e("PropertyValuesHolder", e12.toString());
        }
    }

    public void a(float f11) {
        this.mAnimatedValue = this.f52829f.getValue(f11);
    }

    public Object b() {
        return this.mAnimatedValue;
    }

    public void d() {
        TypeEvaluator typeEvaluator;
        if (this.mEvaluator == null) {
            Class<Float> cls = this.f52828e;
            if (cls == Integer.class) {
                typeEvaluator = sIntEvaluator;
            } else if (cls == Float.class) {
                typeEvaluator = sFloatEvaluator;
            } else {
                typeEvaluator = null;
            }
            this.mEvaluator = typeEvaluator;
        }
        TypeEvaluator typeEvaluator2 = this.mEvaluator;
        if (typeEvaluator2 != null) {
            this.f52829f.setEvaluator(typeEvaluator2);
        }
    }

    public void e(Object obj) {
        Property property = this.f52826c;
        if (property != null) {
            property.set(obj, b());
        }
        if (this.f52827d != null) {
            try {
                this.f52831h[0] = b();
                this.f52827d.invoke(obj, this.f52831h);
            } catch (InvocationTargetException e11) {
                Log.e("PropertyValuesHolder", e11.toString());
            } catch (IllegalAccessException e12) {
                Log.e("PropertyValuesHolder", e12.toString());
            }
        }
    }

    public void f(Object obj) {
        ArrayList<Keyframe> arrayList = this.f52829f.f52809e;
        setupValue(obj, arrayList.get(arrayList.size() - 1));
    }

    public void g(Class cls) {
        this.f52827d = setupSetterOrGetter(cls, sSetterPropertyMap, "set", this.f52828e);
    }

    public String getPropertyName() {
        return this.f52825b;
    }

    public void h(Object obj) {
        Property property = this.f52826c;
        if (property != null) {
            try {
                property.get(obj);
                Iterator<Keyframe> it = this.f52829f.f52809e.iterator();
                while (it.hasNext()) {
                    Keyframe next = it.next();
                    if (!next.hasValue()) {
                        next.setValue(this.f52826c.get(obj));
                    }
                }
                return;
            } catch (ClassCastException unused) {
                Log.e("PropertyValuesHolder", "No such property (" + this.f52826c.getName() + ") on target object " + obj + ". Trying reflection instead");
                this.f52826c = null;
            }
        }
        Class<?> cls = obj.getClass();
        if (this.f52827d == null) {
            g(cls);
        }
        Iterator<Keyframe> it2 = this.f52829f.f52809e.iterator();
        while (it2.hasNext()) {
            Keyframe next2 = it2.next();
            if (!next2.hasValue()) {
                if (this.mGetter == null) {
                    setupGetter(cls);
                }
                try {
                    next2.setValue(this.mGetter.invoke(obj, new Object[0]));
                } catch (InvocationTargetException e11) {
                    Log.e("PropertyValuesHolder", e11.toString());
                } catch (IllegalAccessException e12) {
                    Log.e("PropertyValuesHolder", e12.toString());
                }
            }
        }
    }

    public void i(Object obj) {
        setupValue(obj, this.f52829f.f52809e.get(0));
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        this.mEvaluator = typeEvaluator;
        this.f52829f.setEvaluator(typeEvaluator);
    }

    public void setFloatValues(float... fArr) {
        this.f52828e = Float.TYPE;
        this.f52829f = KeyframeSet.ofFloat(fArr);
    }

    public void setIntValues(int... iArr) {
        this.f52828e = Integer.TYPE;
        this.f52829f = KeyframeSet.ofInt(iArr);
    }

    public void setKeyframes(Keyframe... keyframeArr) {
        int length = keyframeArr.length;
        Keyframe[] keyframeArr2 = new Keyframe[Math.max(length, 2)];
        this.f52828e = keyframeArr[0].getType();
        for (int i11 = 0; i11 < length; i11++) {
            keyframeArr2[i11] = keyframeArr[i11];
        }
        this.f52829f = new KeyframeSet(keyframeArr2);
    }

    public void setObjectValues(Object... objArr) {
        this.f52828e = objArr[0].getClass();
        this.f52829f = KeyframeSet.ofObject(objArr);
    }

    public void setProperty(Property property) {
        this.f52826c = property;
    }

    public void setPropertyName(String str) {
        this.f52825b = str;
    }

    public String toString() {
        return this.f52825b + ": " + this.f52829f.toString();
    }

    public static class FloatPropertyValuesHolder extends PropertyValuesHolder {

        /* renamed from: i  reason: collision with root package name */
        public FloatKeyframeSet f52832i;

        /* renamed from: j  reason: collision with root package name */
        public float f52833j;
        private FloatProperty mFloatProperty;

        public FloatPropertyValuesHolder(String str, FloatKeyframeSet floatKeyframeSet) {
            super(str);
            this.f52828e = Float.TYPE;
            this.f52829f = floatKeyframeSet;
            this.f52832i = floatKeyframeSet;
        }

        public void a(float f11) {
            this.f52833j = this.f52832i.getFloatValue(f11);
        }

        public Object b() {
            return Float.valueOf(this.f52833j);
        }

        public void e(Object obj) {
            FloatProperty floatProperty = this.mFloatProperty;
            if (floatProperty != null) {
                floatProperty.setValue(obj, this.f52833j);
                return;
            }
            Property property = this.f52826c;
            if (property != null) {
                property.set(obj, Float.valueOf(this.f52833j));
            } else if (this.f52827d != null) {
                try {
                    this.f52831h[0] = Float.valueOf(this.f52833j);
                    this.f52827d.invoke(obj, this.f52831h);
                } catch (InvocationTargetException e11) {
                    Log.e("PropertyValuesHolder", e11.toString());
                } catch (IllegalAccessException e12) {
                    Log.e("PropertyValuesHolder", e12.toString());
                }
            }
        }

        public void g(Class cls) {
            if (this.f52826c == null) {
                PropertyValuesHolder.super.g(cls);
            }
        }

        public void setFloatValues(float... fArr) {
            PropertyValuesHolder.super.setFloatValues(fArr);
            this.f52832i = (FloatKeyframeSet) this.f52829f;
        }

        public FloatPropertyValuesHolder clone() {
            FloatPropertyValuesHolder floatPropertyValuesHolder = (FloatPropertyValuesHolder) PropertyValuesHolder.super.clone();
            floatPropertyValuesHolder.f52832i = (FloatKeyframeSet) floatPropertyValuesHolder.f52829f;
            return floatPropertyValuesHolder;
        }

        public FloatPropertyValuesHolder(Property property, FloatKeyframeSet floatKeyframeSet) {
            super(property);
            this.f52828e = Float.TYPE;
            this.f52829f = floatKeyframeSet;
            this.f52832i = floatKeyframeSet;
            if (property instanceof FloatProperty) {
                this.mFloatProperty = (FloatProperty) this.f52826c;
            }
        }

        public FloatPropertyValuesHolder(String str, float... fArr) {
            super(str);
            setFloatValues(fArr);
        }

        public FloatPropertyValuesHolder(Property property, float... fArr) {
            super(property);
            setFloatValues(fArr);
            if (property instanceof FloatProperty) {
                this.mFloatProperty = (FloatProperty) this.f52826c;
            }
        }
    }

    public static class IntPropertyValuesHolder extends PropertyValuesHolder {

        /* renamed from: i  reason: collision with root package name */
        public IntKeyframeSet f52834i;

        /* renamed from: j  reason: collision with root package name */
        public int f52835j;
        private IntProperty mIntProperty;

        public IntPropertyValuesHolder(String str, IntKeyframeSet intKeyframeSet) {
            super(str);
            this.f52828e = Integer.TYPE;
            this.f52829f = intKeyframeSet;
            this.f52834i = intKeyframeSet;
        }

        public void a(float f11) {
            this.f52835j = this.f52834i.getIntValue(f11);
        }

        public Object b() {
            return Integer.valueOf(this.f52835j);
        }

        public void e(Object obj) {
            IntProperty intProperty = this.mIntProperty;
            if (intProperty != null) {
                intProperty.setValue(obj, this.f52835j);
                return;
            }
            Property property = this.f52826c;
            if (property != null) {
                property.set(obj, Integer.valueOf(this.f52835j));
            } else if (this.f52827d != null) {
                try {
                    this.f52831h[0] = Integer.valueOf(this.f52835j);
                    this.f52827d.invoke(obj, this.f52831h);
                } catch (InvocationTargetException e11) {
                    Log.e("PropertyValuesHolder", e11.toString());
                } catch (IllegalAccessException e12) {
                    Log.e("PropertyValuesHolder", e12.toString());
                }
            }
        }

        public void g(Class cls) {
            if (this.f52826c == null) {
                PropertyValuesHolder.super.g(cls);
            }
        }

        public void setIntValues(int... iArr) {
            PropertyValuesHolder.super.setIntValues(iArr);
            this.f52834i = (IntKeyframeSet) this.f52829f;
        }

        public IntPropertyValuesHolder clone() {
            IntPropertyValuesHolder intPropertyValuesHolder = (IntPropertyValuesHolder) PropertyValuesHolder.super.clone();
            intPropertyValuesHolder.f52834i = (IntKeyframeSet) intPropertyValuesHolder.f52829f;
            return intPropertyValuesHolder;
        }

        public IntPropertyValuesHolder(Property property, IntKeyframeSet intKeyframeSet) {
            super(property);
            this.f52828e = Integer.TYPE;
            this.f52829f = intKeyframeSet;
            this.f52834i = intKeyframeSet;
            if (property instanceof IntProperty) {
                this.mIntProperty = (IntProperty) this.f52826c;
            }
        }

        public IntPropertyValuesHolder(String str, int... iArr) {
            super(str);
            setIntValues(iArr);
        }

        public IntPropertyValuesHolder(Property property, int... iArr) {
            super(property);
            setIntValues(iArr);
            if (property instanceof IntProperty) {
                this.mIntProperty = (IntProperty) this.f52826c;
            }
        }
    }

    public static PropertyValuesHolder ofFloat(Property<?, Float> property, float... fArr) {
        return new FloatPropertyValuesHolder((Property) property, fArr);
    }

    public static PropertyValuesHolder ofInt(Property<?, Integer> property, int... iArr) {
        return new IntPropertyValuesHolder((Property) property, iArr);
    }

    public PropertyValuesHolder clone() {
        try {
            PropertyValuesHolder propertyValuesHolder = (PropertyValuesHolder) super.clone();
            propertyValuesHolder.f52825b = this.f52825b;
            propertyValuesHolder.f52826c = this.f52826c;
            propertyValuesHolder.f52829f = this.f52829f.clone();
            propertyValuesHolder.mEvaluator = this.mEvaluator;
            return propertyValuesHolder;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    private PropertyValuesHolder(String str) {
        this.f52827d = null;
        this.mGetter = null;
        this.f52829f = null;
        this.f52830g = new ReentrantReadWriteLock();
        this.f52831h = new Object[1];
        this.f52825b = str;
    }

    public static <V> PropertyValuesHolder ofObject(Property property, TypeEvaluator<V> typeEvaluator, V... vArr) {
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(property);
        propertyValuesHolder.setObjectValues(vArr);
        propertyValuesHolder.setEvaluator(typeEvaluator);
        return propertyValuesHolder;
    }

    public static PropertyValuesHolder ofKeyframe(Property property, Keyframe... keyframeArr) {
        KeyframeSet ofKeyframe = KeyframeSet.ofKeyframe(keyframeArr);
        if (ofKeyframe instanceof IntKeyframeSet) {
            return new IntPropertyValuesHolder(property, (IntKeyframeSet) ofKeyframe);
        }
        if (ofKeyframe instanceof FloatKeyframeSet) {
            return new FloatPropertyValuesHolder(property, (FloatKeyframeSet) ofKeyframe);
        }
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(property);
        propertyValuesHolder.f52829f = ofKeyframe;
        propertyValuesHolder.f52828e = keyframeArr[0].getType();
        return propertyValuesHolder;
    }

    private PropertyValuesHolder(Property property) {
        this.f52827d = null;
        this.mGetter = null;
        this.f52829f = null;
        this.f52830g = new ReentrantReadWriteLock();
        this.f52831h = new Object[1];
        this.f52826c = property;
        if (property != null) {
            this.f52825b = property.getName();
        }
    }
}
