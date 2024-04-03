package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ViewTimeCycle extends TimeCycleSplineSet {
    private static final String TAG = "ViewTimeCycle";

    public static class AlphaSet extends ViewTimeCycle {
        public boolean setProperty(View view, float f11, long j11, KeyCache keyCache) {
            view.setAlpha(get(f11, j11, view, keyCache));
            return this.f10627h;
        }
    }

    public static class CustomSet extends ViewTimeCycle {

        /* renamed from: l  reason: collision with root package name */
        public String f10863l;

        /* renamed from: m  reason: collision with root package name */
        public SparseArray<ConstraintAttribute> f10864m;

        /* renamed from: n  reason: collision with root package name */
        public SparseArray<float[]> f10865n = new SparseArray<>();

        /* renamed from: o  reason: collision with root package name */
        public float[] f10866o;

        /* renamed from: p  reason: collision with root package name */
        public float[] f10867p;

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.f10863l = str.split(",")[1];
            this.f10864m = sparseArray;
        }

        public void setPoint(int i11, float f11, float f12, int i12, float f13) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(View view, float f11, long j11, KeyCache keyCache) {
            boolean z11;
            View view2 = view;
            long j12 = j11;
            this.f10620a.getPos((double) f11, this.f10866o);
            float[] fArr = this.f10866o;
            float f12 = fArr[fArr.length - 2];
            float f13 = fArr[fArr.length - 1];
            long j13 = j12 - this.f10628i;
            if (Float.isNaN(this.f10629j)) {
                float floatValue = keyCache.getFloatValue(view2, this.f10863l, 0);
                this.f10629j = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.f10629j = 0.0f;
                }
            }
            float f14 = (float) ((((double) this.f10629j) + ((((double) j13) * 1.0E-9d) * ((double) f12))) % 1.0d);
            this.f10629j = f14;
            this.f10628i = j12;
            float a11 = a(f14);
            this.f10627h = false;
            int i11 = 0;
            while (true) {
                float[] fArr2 = this.f10867p;
                if (i11 >= fArr2.length) {
                    break;
                }
                boolean z12 = this.f10627h;
                float f15 = this.f10866o[i11];
                if (((double) f15) != 0.0d) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                this.f10627h = z12 | z11;
                fArr2[i11] = (f15 * a11) + f13;
                i11++;
            }
            CustomSupport.setInterpolatedValue(this.f10864m.valueAt(0), view2, this.f10867p);
            if (f12 != 0.0f) {
                this.f10627h = true;
            }
            return this.f10627h;
        }

        public void setup(int i11) {
            int size = this.f10864m.size();
            int numberOfInterpolatedValues = this.f10864m.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i12 = numberOfInterpolatedValues + 2;
            this.f10866o = new float[i12];
            this.f10867p = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = i12;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i13 = 0; i13 < size; i13++) {
                int keyAt = this.f10864m.keyAt(i13);
                float[] valueAt = this.f10865n.valueAt(i13);
                dArr[i13] = ((double) keyAt) * 0.01d;
                this.f10864m.valueAt(i13).getValuesToInterpolate(this.f10866o);
                int i14 = 0;
                while (true) {
                    float[] fArr = this.f10866o;
                    if (i14 >= fArr.length) {
                        break;
                    }
                    dArr2[i13][i14] = (double) fArr[i14];
                    i14++;
                }
                double[] dArr3 = dArr2[i13];
                dArr3[numberOfInterpolatedValues] = (double) valueAt[0];
                dArr3[numberOfInterpolatedValues + 1] = (double) valueAt[1];
            }
            this.f10620a = CurveFit.get(i11, dArr, dArr2);
        }

        public void setPoint(int i11, ConstraintAttribute constraintAttribute, float f11, int i12, float f12) {
            this.f10864m.append(i11, constraintAttribute);
            this.f10865n.append(i11, new float[]{f11, f12});
            this.f10621b = Math.max(this.f10621b, i12);
        }
    }

    public static class ElevationSet extends ViewTimeCycle {
        public boolean setProperty(View view, float f11, long j11, KeyCache keyCache) {
            view.setElevation(get(f11, j11, view, keyCache));
            return this.f10627h;
        }
    }

    public static class PathRotate extends ViewTimeCycle {
        public boolean setPathRotate(View view, KeyCache keyCache, float f11, long j11, double d11, double d12) {
            view.setRotation(get(f11, j11, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d12, d11))));
            return this.f10627h;
        }

        public boolean setProperty(View view, float f11, long j11, KeyCache keyCache) {
            return this.f10627h;
        }
    }

    public static class ProgressSet extends ViewTimeCycle {

        /* renamed from: l  reason: collision with root package name */
        public boolean f10868l = false;

        public boolean setProperty(View view, float f11, long j11, KeyCache keyCache) {
            Method method;
            View view2 = view;
            if (view2 instanceof MotionLayout) {
                ((MotionLayout) view2).setProgress(get(f11, j11, view, keyCache));
            } else if (this.f10868l) {
                return false;
            } else {
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.f10868l = true;
                    method = null;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, new Object[]{Float.valueOf(get(f11, j11, view, keyCache))});
                    } catch (IllegalAccessException e11) {
                        Log.e(ViewTimeCycle.TAG, "unable to setProgress", e11);
                    } catch (InvocationTargetException e12) {
                        Log.e(ViewTimeCycle.TAG, "unable to setProgress", e12);
                    }
                }
            }
            return this.f10627h;
        }
    }

    public static class RotationSet extends ViewTimeCycle {
        public boolean setProperty(View view, float f11, long j11, KeyCache keyCache) {
            view.setRotation(get(f11, j11, view, keyCache));
            return this.f10627h;
        }
    }

    public static class RotationXset extends ViewTimeCycle {
        public boolean setProperty(View view, float f11, long j11, KeyCache keyCache) {
            view.setRotationX(get(f11, j11, view, keyCache));
            return this.f10627h;
        }
    }

    public static class RotationYset extends ViewTimeCycle {
        public boolean setProperty(View view, float f11, long j11, KeyCache keyCache) {
            view.setRotationY(get(f11, j11, view, keyCache));
            return this.f10627h;
        }
    }

    public static class ScaleXset extends ViewTimeCycle {
        public boolean setProperty(View view, float f11, long j11, KeyCache keyCache) {
            view.setScaleX(get(f11, j11, view, keyCache));
            return this.f10627h;
        }
    }

    public static class ScaleYset extends ViewTimeCycle {
        public boolean setProperty(View view, float f11, long j11, KeyCache keyCache) {
            view.setScaleY(get(f11, j11, view, keyCache));
            return this.f10627h;
        }
    }

    public static class TranslationXset extends ViewTimeCycle {
        public boolean setProperty(View view, float f11, long j11, KeyCache keyCache) {
            view.setTranslationX(get(f11, j11, view, keyCache));
            return this.f10627h;
        }
    }

    public static class TranslationYset extends ViewTimeCycle {
        public boolean setProperty(View view, float f11, long j11, KeyCache keyCache) {
            view.setTranslationY(get(f11, j11, view, keyCache));
            return this.f10627h;
        }
    }

    public static class TranslationZset extends ViewTimeCycle {
        public boolean setProperty(View view, float f11, long j11, KeyCache keyCache) {
            view.setTranslationZ(get(f11, j11, view, keyCache));
            return this.f10627h;
        }
    }

    public static ViewTimeCycle makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    public static ViewTimeCycle makeSpline(String str, long j11) {
        ViewTimeCycle viewTimeCycle;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c11 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c11 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c11 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c11 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c11 = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c11 = 8;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c11 = 9;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c11 = 10;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c11 = 11;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                viewTimeCycle = new RotationXset();
                break;
            case 1:
                viewTimeCycle = new RotationYset();
                break;
            case 2:
                viewTimeCycle = new TranslationXset();
                break;
            case 3:
                viewTimeCycle = new TranslationYset();
                break;
            case 4:
                viewTimeCycle = new TranslationZset();
                break;
            case 5:
                viewTimeCycle = new ProgressSet();
                break;
            case 6:
                viewTimeCycle = new ScaleXset();
                break;
            case 7:
                viewTimeCycle = new ScaleYset();
                break;
            case 8:
                viewTimeCycle = new RotationSet();
                break;
            case 9:
                viewTimeCycle = new ElevationSet();
                break;
            case 10:
                viewTimeCycle = new PathRotate();
                break;
            case 11:
                viewTimeCycle = new AlphaSet();
                break;
            default:
                return null;
        }
        viewTimeCycle.b(j11);
        return viewTimeCycle;
    }

    public float get(float f11, long j11, View view, KeyCache keyCache) {
        boolean z11;
        long j12 = j11;
        View view2 = view;
        KeyCache keyCache2 = keyCache;
        this.f10620a.getPos((double) f11, this.f10626g);
        float[] fArr = this.f10626g;
        float f12 = fArr[1];
        int i11 = (f12 > 0.0f ? 1 : (f12 == 0.0f ? 0 : -1));
        if (i11 == 0) {
            this.f10627h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f10629j)) {
            float floatValue = keyCache2.getFloatValue(view2, this.f10625f, 0);
            this.f10629j = floatValue;
            if (Float.isNaN(floatValue)) {
                this.f10629j = 0.0f;
            }
        }
        float f13 = (float) ((((double) this.f10629j) + ((((double) (j12 - this.f10628i)) * 1.0E-9d) * ((double) f12))) % 1.0d);
        this.f10629j = f13;
        keyCache2.setFloatValue(view2, this.f10625f, 0, f13);
        this.f10628i = j12;
        float f14 = this.f10626g[0];
        float a11 = (a(this.f10629j) * f14) + this.f10626g[2];
        if (f14 == 0.0f && i11 == 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.f10627h = z11;
        return a11;
    }

    public abstract boolean setProperty(View view, float f11, long j11, KeyCache keyCache);
}
