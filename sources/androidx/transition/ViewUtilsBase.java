package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewUtilsBase {
    private static final String TAG = "ViewUtilsBase";
    private static final int VISIBILITY_MASK = 12;
    private static boolean sSetFrameFetched;
    private static Method sSetFrameMethod;
    private static Field sViewFlagsField;
    private static boolean sViewFlagsFieldFetched;
    private float[] mMatrixValues;

    @SuppressLint({"PrivateApi", "SoonBlockedPrivateApi"})
    private void fetchSetFrame() {
        if (!sSetFrameFetched) {
            Class<View> cls = View.class;
            try {
                Class cls2 = Integer.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("setFrame", new Class[]{cls2, cls2, cls2, cls2});
                sSetFrameMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e11) {
                Log.i(TAG, "Failed to retrieve setFrame method", e11);
            }
            sSetFrameFetched = true;
        }
    }

    public void clearNonTransitionAlpha(@NonNull View view) {
        if (view.getVisibility() == 0) {
            view.setTag(R.id.save_non_transition_alpha, (Object) null);
        }
    }

    public float getTransitionAlpha(@NonNull View view) {
        Float f11 = (Float) view.getTag(R.id.save_non_transition_alpha);
        if (f11 != null) {
            return view.getAlpha() / f11.floatValue();
        }
        return view.getAlpha();
    }

    public void saveNonTransitionAlpha(@NonNull View view) {
        int i11 = R.id.save_non_transition_alpha;
        if (view.getTag(i11) == null) {
            view.setTag(i11, Float.valueOf(view.getAlpha()));
        }
    }

    public void setAnimationMatrix(@NonNull View view, @Nullable Matrix matrix) {
        int i11;
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX((float) (view.getWidth() / 2));
            view.setPivotY((float) (view.getHeight() / 2));
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            return;
        }
        float[] fArr = this.mMatrixValues;
        if (fArr == null) {
            fArr = new float[9];
            this.mMatrixValues = fArr;
        }
        matrix.getValues(fArr);
        float f11 = fArr[3];
        float sqrt = (float) Math.sqrt((double) (1.0f - (f11 * f11)));
        if (fArr[0] < 0.0f) {
            i11 = -1;
        } else {
            i11 = 1;
        }
        float f12 = sqrt * ((float) i11);
        float degrees = (float) Math.toDegrees(Math.atan2((double) f11, (double) f12));
        float f13 = fArr[0] / f12;
        float f14 = fArr[4] / f12;
        float f15 = fArr[2];
        float f16 = fArr[5];
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(f15);
        view.setTranslationY(f16);
        view.setRotation(degrees);
        view.setScaleX(f13);
        view.setScaleY(f14);
    }

    public void setLeftTopRightBottom(@NonNull View view, int i11, int i12, int i13, int i14) {
        fetchSetFrame();
        Method method = sSetFrameMethod;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e11) {
                throw new RuntimeException(e11.getCause());
            }
        }
    }

    public void setTransitionAlpha(@NonNull View view, float f11) {
        Float f12 = (Float) view.getTag(R.id.save_non_transition_alpha);
        if (f12 != null) {
            view.setAlpha(f12.floatValue() * f11);
        } else {
            view.setAlpha(f11);
        }
    }

    public void setTransitionVisibility(@NonNull View view, int i11) {
        if (!sViewFlagsFieldFetched) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                sViewFlagsField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i(TAG, "fetchViewFlagsField: ");
            }
            sViewFlagsFieldFetched = true;
        }
        Field field = sViewFlagsField;
        if (field != null) {
            try {
                sViewFlagsField.setInt(view, i11 | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void transformMatrixToGlobal(@NonNull View view, @NonNull Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            transformMatrixToGlobal(view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            matrix.preConcat(matrix2);
        }
    }

    public void transformMatrixToLocal(@NonNull View view, @NonNull Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            transformMatrixToLocal(view2, matrix);
            matrix.postTranslate((float) view2.getScrollX(), (float) view2.getScrollY());
        }
        matrix.postTranslate((float) (-view.getLeft()), (float) (-view.getTop()));
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            Matrix matrix3 = new Matrix();
            if (matrix2.invert(matrix3)) {
                matrix.postConcat(matrix3);
            }
        }
    }
}
