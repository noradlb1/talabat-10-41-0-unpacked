package com.google.android.material.transition.platform;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.transition.PathMotion;
import android.transition.PatternPathMotion;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.PathParser;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

@RequiresApi(21)
class TransitionUtils {
    @AttrRes
    static final int NO_ATTR_RES_ID = 0;
    static final int NO_DURATION = -1;
    private static final int PATH_TYPE_ARC = 1;
    private static final int PATH_TYPE_LINEAR = 0;
    private static final RectF transformAlphaRectF = new RectF();

    public interface CanvasOperation {
        void run(Canvas canvas);
    }

    public interface CornerSizeBinaryOperator {
        @NonNull
        CornerSize apply(@NonNull CornerSize cornerSize, @NonNull CornerSize cornerSize2);
    }

    private TransitionUtils() {
    }

    public static float calculateArea(@NonNull RectF rectF) {
        return rectF.width() * rectF.height();
    }

    public static ShapeAppearanceModel convertToRelativeCornerSizes(ShapeAppearanceModel shapeAppearanceModel, final RectF rectF) {
        return shapeAppearanceModel.withTransformedCornerSizes(new ShapeAppearanceModel.CornerSizeUnaryOperator() {
            @NonNull
            public CornerSize apply(@NonNull CornerSize cornerSize) {
                if (cornerSize instanceof RelativeCornerSize) {
                    return cornerSize;
                }
                return new RelativeCornerSize(cornerSize.getCornerSize(rectF) / rectF.height());
            }
        });
    }

    public static Shader createColorShader(@ColorInt int i11) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i11, i11, Shader.TileMode.CLAMP);
    }

    @NonNull
    public static <T> T defaultIfNull(@Nullable T t11, @NonNull T t12) {
        return t11 != null ? t11 : t12;
    }

    public static View findAncestorById(View view, @IdRes int i11) {
        String resourceName = view.getResources().getResourceName(i11);
        while (view != null) {
            if (view.getId() != i11) {
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(resourceName + " is not a valid ancestor");
    }

    public static View findDescendantOrAncestorById(View view, @IdRes int i11) {
        View findViewById = view.findViewById(i11);
        if (findViewById != null) {
            return findViewById;
        }
        return findAncestorById(view, i11);
    }

    public static RectF getLocationOnScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i11 = iArr[0];
        int i12 = iArr[1];
        return new RectF((float) i11, (float) i12, (float) (view.getWidth() + i11), (float) (view.getHeight() + i12));
    }

    public static RectF getRelativeBounds(View view) {
        return new RectF((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
    }

    public static Rect getRelativeBoundsRect(View view) {
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    private static boolean isShapeAppearanceSignificant(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        if (shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF) == 0.0f) {
            return false;
        }
        return true;
    }

    public static float lerp(float f11, float f12, float f13) {
        return f11 + (f13 * (f12 - f11));
    }

    public static float lerp(float f11, float f12, @FloatRange(from = 0.0d, to = 1.0d) float f13, @FloatRange(from = 0.0d, to = 1.0d) float f14, @FloatRange(from = 0.0d, to = 1.0d) float f15) {
        return lerp(f11, f12, f13, f14, f15, false);
    }

    public static void maybeAddTransition(TransitionSet transitionSet, @Nullable Transition transition) {
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
    }

    public static boolean maybeApplyThemeDuration(Transition transition, Context context, @AttrRes int i11) {
        int resolveThemeDuration;
        if (i11 == 0 || transition.getDuration() != -1 || (resolveThemeDuration = MotionUtils.resolveThemeDuration(context, i11, -1)) == -1) {
            return false;
        }
        transition.setDuration((long) resolveThemeDuration);
        return true;
    }

    public static boolean maybeApplyThemeInterpolator(Transition transition, Context context, @AttrRes int i11, TimeInterpolator timeInterpolator) {
        if (i11 == 0 || transition.getInterpolator() != null) {
            return false;
        }
        transition.setInterpolator(MotionUtils.resolveThemeInterpolator(context, i11, timeInterpolator));
        return true;
    }

    public static boolean maybeApplyThemePath(Transition transition, Context context, @AttrRes int i11) {
        PathMotion resolveThemePath;
        if (i11 == 0 || (resolveThemePath = resolveThemePath(context, i11)) == null) {
            return false;
        }
        transition.setPathMotion(resolveThemePath);
        return true;
    }

    public static void maybeRemoveTransition(TransitionSet transitionSet, @Nullable Transition transition) {
        if (transition != null) {
            transitionSet.removeTransition(transition);
        }
    }

    @Nullable
    public static PathMotion resolveThemePath(Context context, @AttrRes int i11) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i11, typedValue, true)) {
            return null;
        }
        int i12 = typedValue.type;
        if (i12 == 16) {
            int i13 = typedValue.data;
            if (i13 == 0) {
                return null;
            }
            if (i13 == 1) {
                return new MaterialArcMotion();
            }
            throw new IllegalArgumentException("Invalid motion path type: " + i13);
        } else if (i12 == 3) {
            return new PatternPathMotion(PathParser.createPathFromPathData(String.valueOf(typedValue.string)));
        } else {
            throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
        }
    }

    private static int saveLayerAlphaCompat(Canvas canvas, Rect rect, int i11) {
        RectF rectF = transformAlphaRectF;
        rectF.set(rect);
        return canvas.saveLayerAlpha(rectF, i11);
    }

    public static void transform(Canvas canvas, Rect rect, float f11, float f12, float f13, int i11, CanvasOperation canvasOperation) {
        if (i11 > 0) {
            int save = canvas.save();
            canvas.translate(f11, f12);
            canvas.scale(f13, f13);
            if (i11 < 255) {
                saveLayerAlphaCompat(canvas, rect, i11);
            }
            canvasOperation.run(canvas);
            canvas.restoreToCount(save);
        }
    }

    public static ShapeAppearanceModel transformCornerSizes(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, CornerSizeBinaryOperator cornerSizeBinaryOperator) {
        ShapeAppearanceModel shapeAppearanceModel3;
        if (isShapeAppearanceSignificant(shapeAppearanceModel, rectF)) {
            shapeAppearanceModel3 = shapeAppearanceModel;
        } else {
            shapeAppearanceModel3 = shapeAppearanceModel2;
        }
        return shapeAppearanceModel3.toBuilder().setTopLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel2.getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel2.getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel2.getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomRightCornerSize(), shapeAppearanceModel2.getBottomRightCornerSize())).build();
    }

    public static float lerp(float f11, float f12, @FloatRange(from = 0.0d, to = 1.0d) float f13, @FloatRange(from = 0.0d, to = 1.0d) float f14, @FloatRange(from = 0.0d) float f15, boolean z11) {
        if (z11 && (f15 < 0.0f || f15 > 1.0f)) {
            return lerp(f11, f12, f15);
        }
        if (f15 < f13) {
            return f11;
        }
        if (f15 > f14) {
            return f12;
        }
        return lerp(f11, f12, (f15 - f13) / (f14 - f13));
    }

    public static int lerp(int i11, int i12, @FloatRange(from = 0.0d, to = 1.0d) float f11, @FloatRange(from = 0.0d, to = 1.0d) float f12, @FloatRange(from = 0.0d, to = 1.0d) float f13) {
        if (f13 < f11) {
            return i11;
        }
        return f13 > f12 ? i12 : (int) lerp((float) i11, (float) i12, (f13 - f11) / (f12 - f11));
    }

    public static ShapeAppearanceModel lerp(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, @FloatRange(from = 0.0d, to = 1.0d) float f11, @FloatRange(from = 0.0d, to = 1.0d) float f12, @FloatRange(from = 0.0d, to = 1.0d) float f13) {
        if (f13 < f11) {
            return shapeAppearanceModel;
        }
        if (f13 > f12) {
            return shapeAppearanceModel2;
        }
        final RectF rectF3 = rectF;
        final RectF rectF4 = rectF2;
        final float f14 = f11;
        final float f15 = f12;
        final float f16 = f13;
        return transformCornerSizes(shapeAppearanceModel, shapeAppearanceModel2, rectF, new CornerSizeBinaryOperator() {
            @NonNull
            public CornerSize apply(@NonNull CornerSize cornerSize, @NonNull CornerSize cornerSize2) {
                return new AbsoluteCornerSize(TransitionUtils.lerp(cornerSize.getCornerSize(rectF3), cornerSize2.getCornerSize(rectF4), f14, f15, f16));
            }
        });
    }
}
