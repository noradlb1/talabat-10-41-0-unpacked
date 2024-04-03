package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.lang3.CharUtils;

public abstract class ViewOscillator extends KeyCycleOscillator {
    private static final String TAG = "ViewOscillator";

    public static class AlphaSet extends ViewOscillator {
        public void setProperty(View view, float f11) {
            view.setAlpha(get(f11));
        }
    }

    public static class CustomSet extends ViewOscillator {

        /* renamed from: b  reason: collision with root package name */
        public float[] f10856b = new float[1];

        /* renamed from: c  reason: collision with root package name */
        public ConstraintAttribute f10857c;

        public void a(Object obj) {
            this.f10857c = (ConstraintAttribute) obj;
        }

        public void setProperty(View view, float f11) {
            this.f10856b[0] = get(f11);
            CustomSupport.setInterpolatedValue(this.f10857c, view, this.f10856b);
        }
    }

    public static class ElevationSet extends ViewOscillator {
        public void setProperty(View view, float f11) {
            view.setElevation(get(f11));
        }
    }

    public static class PathRotateSet extends ViewOscillator {
        public void setPathRotate(View view, float f11, double d11, double d12) {
            view.setRotation(get(f11) + ((float) Math.toDegrees(Math.atan2(d12, d11))));
        }

        public void setProperty(View view, float f11) {
        }
    }

    public static class ProgressSet extends ViewOscillator {

        /* renamed from: b  reason: collision with root package name */
        public boolean f10858b = false;

        public void setProperty(View view, float f11) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f11));
            } else if (!this.f10858b) {
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.f10858b = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(get(f11))});
                    } catch (IllegalAccessException e11) {
                        Log.e(ViewOscillator.TAG, "unable to setProgress", e11);
                    } catch (InvocationTargetException e12) {
                        Log.e(ViewOscillator.TAG, "unable to setProgress", e12);
                    }
                }
            }
        }
    }

    public static class RotationSet extends ViewOscillator {
        public void setProperty(View view, float f11) {
            view.setRotation(get(f11));
        }
    }

    public static class RotationXset extends ViewOscillator {
        public void setProperty(View view, float f11) {
            view.setRotationX(get(f11));
        }
    }

    public static class RotationYset extends ViewOscillator {
        public void setProperty(View view, float f11) {
            view.setRotationY(get(f11));
        }
    }

    public static class ScaleXset extends ViewOscillator {
        public void setProperty(View view, float f11) {
            view.setScaleX(get(f11));
        }
    }

    public static class ScaleYset extends ViewOscillator {
        public void setProperty(View view, float f11) {
            view.setScaleY(get(f11));
        }
    }

    public static class TranslationXset extends ViewOscillator {
        public void setProperty(View view, float f11) {
            view.setTranslationX(get(f11));
        }
    }

    public static class TranslationYset extends ViewOscillator {
        public void setProperty(View view, float f11) {
            view.setTranslationY(get(f11));
        }
    }

    public static class TranslationZset extends ViewOscillator {
        public void setProperty(View view, float f11) {
            view.setTranslationZ(get(f11));
        }
    }

    public static ViewOscillator makeSpline(String str) {
        if (str.startsWith("CUSTOM")) {
            return new CustomSet();
        }
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
            case -40300674:
                if (str.equals("rotation")) {
                    c11 = 9;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c11 = 10;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c11 = 11;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c11 = 12;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c11 = CharUtils.CR;
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
                return new RotationSet();
            case 10:
                return new ElevationSet();
            case 11:
                return new PathRotateSet();
            case 12:
                return new AlphaSet();
            case 13:
                return new AlphaSet();
            default:
                return null;
        }
    }

    public abstract void setProperty(View view, float f11);
}
