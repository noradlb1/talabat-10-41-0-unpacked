package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.lang3.CharUtils;

public abstract class ViewSpline extends SplineSet {
    private static final String TAG = "ViewSpline";

    public static class AlphaSet extends ViewSpline {
        public void setProperty(View view, float f11) {
            view.setAlpha(get(f11));
        }
    }

    public static class CustomSet extends ViewSpline {

        /* renamed from: d  reason: collision with root package name */
        public String f10859d;

        /* renamed from: e  reason: collision with root package name */
        public SparseArray<ConstraintAttribute> f10860e;

        /* renamed from: f  reason: collision with root package name */
        public float[] f10861f;

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.f10859d = str.split(",")[1];
            this.f10860e = sparseArray;
        }

        public void setPoint(int i11, float f11) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setProperty(View view, float f11) {
            this.f10606a.getPos((double) f11, this.f10861f);
            CustomSupport.setInterpolatedValue(this.f10860e.valueAt(0), view, this.f10861f);
        }

        public void setup(int i11) {
            int size = this.f10860e.size();
            int numberOfInterpolatedValues = this.f10860e.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.f10861f = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = numberOfInterpolatedValues;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i12 = 0; i12 < size; i12++) {
                dArr[i12] = ((double) this.f10860e.keyAt(i12)) * 0.01d;
                this.f10860e.valueAt(i12).getValuesToInterpolate(this.f10861f);
                int i13 = 0;
                while (true) {
                    float[] fArr = this.f10861f;
                    if (i13 >= fArr.length) {
                        break;
                    }
                    dArr2[i12][i13] = (double) fArr[i13];
                    i13++;
                }
            }
            this.f10606a = CurveFit.get(i11, dArr, dArr2);
        }

        public void setPoint(int i11, ConstraintAttribute constraintAttribute) {
            this.f10860e.append(i11, constraintAttribute);
        }
    }

    public static class ElevationSet extends ViewSpline {
        public void setProperty(View view, float f11) {
            view.setElevation(get(f11));
        }
    }

    public static class PathRotate extends ViewSpline {
        public void setPathRotate(View view, float f11, double d11, double d12) {
            view.setRotation(get(f11) + ((float) Math.toDegrees(Math.atan2(d12, d11))));
        }

        public void setProperty(View view, float f11) {
        }
    }

    public static class PivotXset extends ViewSpline {
        public void setProperty(View view, float f11) {
            view.setPivotX(get(f11));
        }
    }

    public static class PivotYset extends ViewSpline {
        public void setProperty(View view, float f11) {
            view.setPivotY(get(f11));
        }
    }

    public static class ProgressSet extends ViewSpline {

        /* renamed from: d  reason: collision with root package name */
        public boolean f10862d = false;

        public void setProperty(View view, float f11) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f11));
            } else if (!this.f10862d) {
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.f10862d = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(get(f11))});
                    } catch (IllegalAccessException e11) {
                        Log.e(ViewSpline.TAG, "unable to setProgress", e11);
                    } catch (InvocationTargetException e12) {
                        Log.e(ViewSpline.TAG, "unable to setProgress", e12);
                    }
                }
            }
        }
    }

    public static class RotationSet extends ViewSpline {
        public void setProperty(View view, float f11) {
            view.setRotation(get(f11));
        }
    }

    public static class RotationXset extends ViewSpline {
        public void setProperty(View view, float f11) {
            view.setRotationX(get(f11));
        }
    }

    public static class RotationYset extends ViewSpline {
        public void setProperty(View view, float f11) {
            view.setRotationY(get(f11));
        }
    }

    public static class ScaleXset extends ViewSpline {
        public void setProperty(View view, float f11) {
            view.setScaleX(get(f11));
        }
    }

    public static class ScaleYset extends ViewSpline {
        public void setProperty(View view, float f11) {
            view.setScaleY(get(f11));
        }
    }

    public static class TranslationXset extends ViewSpline {
        public void setProperty(View view, float f11) {
            view.setTranslationX(get(f11));
        }
    }

    public static class TranslationYset extends ViewSpline {
        public void setProperty(View view, float f11) {
            view.setTranslationY(get(f11));
        }
    }

    public static class TranslationZset extends ViewSpline {
        public void setProperty(View view, float f11) {
            view.setTranslationZ(get(f11));
        }
    }

    public static ViewSpline makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    public static ViewSpline makeSpline(String str) {
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
            case -797520672:
                if (str.equals(Key.WAVE_VARIES_BY)) {
                    c11 = 8;
                    break;
                }
                break;
            case -760884510:
                if (str.equals(Key.PIVOT_X)) {
                    c11 = 9;
                    break;
                }
                break;
            case -760884509:
                if (str.equals(Key.PIVOT_Y)) {
                    c11 = 10;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c11 = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c11 = 12;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c11 = CharUtils.CR;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c11 = 14;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c11 = 15;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return new RotationXset();
            case 1:
                return new RotationYset();
            case 2:
                return new TranslationXset();
            case 3:
                return new TranslationYset();
            case 4:
                return new TranslationZset();
            case 5:
                return new ProgressSet();
            case 6:
                return new ScaleXset();
            case 7:
                return new ScaleYset();
            case 8:
                return new AlphaSet();
            case 9:
                return new PivotXset();
            case 10:
                return new PivotYset();
            case 11:
                return new RotationSet();
            case 12:
                return new ElevationSet();
            case 13:
                return new PathRotate();
            case 14:
                return new AlphaSet();
            case 15:
                return new AlphaSet();
            default:
                return null;
        }
    }

    public abstract void setProperty(View view, float f11);
}
