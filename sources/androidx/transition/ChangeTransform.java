package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform extends Transition {
    private static final Property<PathAnimatorMatrix, float[]> NON_TRANSLATIONS_PROPERTY = new Property<PathAnimatorMatrix, float[]>(float[].class, "nonTranslations") {
        public float[] get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        public void set(PathAnimatorMatrix pathAnimatorMatrix, float[] fArr) {
            pathAnimatorMatrix.c(fArr);
        }
    };
    private static final String PROPNAME_INTERMEDIATE_MATRIX = "android:changeTransform:intermediateMatrix";
    private static final String PROPNAME_INTERMEDIATE_PARENT_MATRIX = "android:changeTransform:intermediateParentMatrix";
    private static final String PROPNAME_MATRIX = "android:changeTransform:matrix";
    private static final String PROPNAME_PARENT = "android:changeTransform:parent";
    private static final String PROPNAME_PARENT_MATRIX = "android:changeTransform:parentMatrix";
    private static final String PROPNAME_TRANSFORMS = "android:changeTransform:transforms";
    private static final boolean SUPPORTS_VIEW_REMOVAL_SUPPRESSION = true;
    private static final Property<PathAnimatorMatrix, PointF> TRANSLATIONS_PROPERTY = new Property<PathAnimatorMatrix, PointF>(PointF.class, "translations") {
        public PointF get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        public void set(PathAnimatorMatrix pathAnimatorMatrix, PointF pointF) {
            pathAnimatorMatrix.b(pointF);
        }
    };
    private static final String[] sTransitionProperties = {PROPNAME_MATRIX, PROPNAME_TRANSFORMS, PROPNAME_PARENT_MATRIX};

    /* renamed from: b  reason: collision with root package name */
    public boolean f37738b = true;
    private boolean mReparent = true;
    private Matrix mTempMatrix = new Matrix();

    public static class GhostListener extends TransitionListenerAdapter {
        private GhostView mGhostView;
        private View mView;

        public GhostListener(View view, GhostView ghostView) {
            this.mView = view;
            this.mGhostView = ghostView;
        }

        public void onTransitionEnd(@NonNull Transition transition) {
            transition.removeListener(this);
            GhostViewUtils.b(this.mView);
            this.mView.setTag(R.id.transition_transform, (Object) null);
            this.mView.setTag(R.id.parent_matrix, (Object) null);
        }

        public void onTransitionPause(@NonNull Transition transition) {
            this.mGhostView.setVisibility(4);
        }

        public void onTransitionResume(@NonNull Transition transition) {
            this.mGhostView.setVisibility(0);
        }
    }

    public static class PathAnimatorMatrix {
        private final Matrix mMatrix = new Matrix();
        private float mTranslationX;
        private float mTranslationY;
        private final float[] mValues;
        private final View mView;

        public PathAnimatorMatrix(View view, float[] fArr) {
            this.mView = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.mValues = fArr2;
            this.mTranslationX = fArr2[2];
            this.mTranslationY = fArr2[5];
            setAnimationMatrix();
        }

        private void setAnimationMatrix() {
            float[] fArr = this.mValues;
            fArr[2] = this.mTranslationX;
            fArr[5] = this.mTranslationY;
            this.mMatrix.setValues(fArr);
            ViewUtils.f(this.mView, this.mMatrix);
        }

        public Matrix a() {
            return this.mMatrix;
        }

        public void b(PointF pointF) {
            this.mTranslationX = pointF.x;
            this.mTranslationY = pointF.y;
            setAnimationMatrix();
        }

        public void c(float[] fArr) {
            System.arraycopy(fArr, 0, this.mValues, 0, fArr.length);
            setAnimationMatrix();
        }
    }

    public static class Transforms {

        /* renamed from: a  reason: collision with root package name */
        public final float f37745a;

        /* renamed from: b  reason: collision with root package name */
        public final float f37746b;

        /* renamed from: c  reason: collision with root package name */
        public final float f37747c;

        /* renamed from: d  reason: collision with root package name */
        public final float f37748d;

        /* renamed from: e  reason: collision with root package name */
        public final float f37749e;

        /* renamed from: f  reason: collision with root package name */
        public final float f37750f;

        /* renamed from: g  reason: collision with root package name */
        public final float f37751g;

        /* renamed from: h  reason: collision with root package name */
        public final float f37752h;

        public Transforms(View view) {
            this.f37745a = view.getTranslationX();
            this.f37746b = view.getTranslationY();
            this.f37747c = ViewCompat.getTranslationZ(view);
            this.f37748d = view.getScaleX();
            this.f37749e = view.getScaleY();
            this.f37750f = view.getRotationX();
            this.f37751g = view.getRotationY();
            this.f37752h = view.getRotation();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Transforms)) {
                return false;
            }
            Transforms transforms = (Transforms) obj;
            if (transforms.f37745a == this.f37745a && transforms.f37746b == this.f37746b && transforms.f37747c == this.f37747c && transforms.f37748d == this.f37748d && transforms.f37749e == this.f37749e && transforms.f37750f == this.f37750f && transforms.f37751g == this.f37751g && transforms.f37752h == this.f37752h) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i11;
            int i12;
            int i13;
            int i14;
            int i15;
            int i16;
            int i17;
            float f11 = this.f37745a;
            int i18 = 0;
            if (f11 != 0.0f) {
                i11 = Float.floatToIntBits(f11);
            } else {
                i11 = 0;
            }
            int i19 = i11 * 31;
            float f12 = this.f37746b;
            if (f12 != 0.0f) {
                i12 = Float.floatToIntBits(f12);
            } else {
                i12 = 0;
            }
            int i21 = (i19 + i12) * 31;
            float f13 = this.f37747c;
            if (f13 != 0.0f) {
                i13 = Float.floatToIntBits(f13);
            } else {
                i13 = 0;
            }
            int i22 = (i21 + i13) * 31;
            float f14 = this.f37748d;
            if (f14 != 0.0f) {
                i14 = Float.floatToIntBits(f14);
            } else {
                i14 = 0;
            }
            int i23 = (i22 + i14) * 31;
            float f15 = this.f37749e;
            if (f15 != 0.0f) {
                i15 = Float.floatToIntBits(f15);
            } else {
                i15 = 0;
            }
            int i24 = (i23 + i15) * 31;
            float f16 = this.f37750f;
            if (f16 != 0.0f) {
                i16 = Float.floatToIntBits(f16);
            } else {
                i16 = 0;
            }
            int i25 = (i24 + i16) * 31;
            float f17 = this.f37751g;
            if (f17 != 0.0f) {
                i17 = Float.floatToIntBits(f17);
            } else {
                i17 = 0;
            }
            int i26 = (i25 + i17) * 31;
            float f18 = this.f37752h;
            if (f18 != 0.0f) {
                i18 = Float.floatToIntBits(f18);
            }
            return i26 + i18;
        }

        public void restore(View view) {
            ChangeTransform.b(view, this.f37745a, this.f37746b, this.f37747c, this.f37748d, this.f37749e, this.f37750f, this.f37751g, this.f37752h);
        }
    }

    public ChangeTransform() {
    }

    public static void a(View view) {
        b(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    public static void b(View view, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        view.setTranslationX(f11);
        view.setTranslationY(f12);
        ViewCompat.setTranslationZ(view, f13);
        view.setScaleX(f14);
        view.setScaleY(f15);
        view.setRotationX(f16);
        view.setRotationY(f17);
        view.setRotation(f18);
    }

    private void captureValues(TransitionValues transitionValues) {
        Matrix matrix;
        View view = transitionValues.view;
        if (view.getVisibility() != 8) {
            transitionValues.values.put(PROPNAME_PARENT, view.getParent());
            transitionValues.values.put(PROPNAME_TRANSFORMS, new Transforms(view));
            Matrix matrix2 = view.getMatrix();
            if (matrix2 == null || matrix2.isIdentity()) {
                matrix = null;
            } else {
                matrix = new Matrix(matrix2);
            }
            transitionValues.values.put(PROPNAME_MATRIX, matrix);
            if (this.mReparent) {
                Matrix matrix3 = new Matrix();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                ViewUtils.j(viewGroup, matrix3);
                matrix3.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                transitionValues.values.put(PROPNAME_PARENT_MATRIX, matrix3);
                transitionValues.values.put(PROPNAME_INTERMEDIATE_MATRIX, view.getTag(R.id.transition_transform));
                transitionValues.values.put(PROPNAME_INTERMEDIATE_PARENT_MATRIX, view.getTag(R.id.parent_matrix));
            }
        }
    }

    private void createGhostView(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view = transitionValues2.view;
        Matrix matrix = new Matrix((Matrix) transitionValues2.values.get(PROPNAME_PARENT_MATRIX));
        ViewUtils.k(viewGroup, matrix);
        GhostView a11 = GhostViewUtils.a(view, viewGroup, matrix);
        if (a11 != null) {
            a11.reserveEndViewTransition((ViewGroup) transitionValues.values.get(PROPNAME_PARENT), transitionValues.view);
            Transition transition = this;
            while (true) {
                Transition transition2 = transition.mParent;
                if (transition2 == null) {
                    break;
                }
                transition = transition2;
            }
            transition.addListener(new GhostListener(view, a11));
            if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
                View view2 = transitionValues.view;
                if (view2 != transitionValues2.view) {
                    ViewUtils.h(view2, 0.0f);
                }
                ViewUtils.h(view, 1.0f);
            }
        }
    }

    private ObjectAnimator createTransformAnimator(TransitionValues transitionValues, TransitionValues transitionValues2, boolean z11) {
        Matrix matrix = (Matrix) transitionValues.values.get(PROPNAME_MATRIX);
        Matrix matrix2 = (Matrix) transitionValues2.values.get(PROPNAME_MATRIX);
        if (matrix == null) {
            matrix = MatrixUtils.f37778a;
        }
        if (matrix2 == null) {
            matrix2 = MatrixUtils.f37778a;
        }
        final Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        final Transforms transforms = (Transforms) transitionValues2.values.get(PROPNAME_TRANSFORMS);
        final View view = transitionValues2.view;
        a(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        final PathAnimatorMatrix pathAnimatorMatrix = new PathAnimatorMatrix(view, fArr);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(pathAnimatorMatrix, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(NON_TRANSLATIONS_PROPERTY, new FloatArrayEvaluator(new float[9]), new float[][]{fArr, fArr2}), PropertyValuesHolderUtils.a(TRANSLATIONS_PROPERTY, getPathMotion().getPath(fArr[2], fArr[5], fArr2[2], fArr2[5]))});
        final boolean z12 = z11;
        AnonymousClass3 r12 = new AnimatorListenerAdapter() {
            private boolean mIsCanceled;
            private Matrix mTempMatrix = new Matrix();

            private void setCurrentMatrix(Matrix matrix) {
                this.mTempMatrix.set(matrix);
                view.setTag(R.id.transition_transform, this.mTempMatrix);
                transforms.restore(view);
            }

            public void onAnimationCancel(Animator animator) {
                this.mIsCanceled = true;
            }

            public void onAnimationEnd(Animator animator) {
                if (!this.mIsCanceled) {
                    if (!z12 || !ChangeTransform.this.f37738b) {
                        view.setTag(R.id.transition_transform, (Object) null);
                        view.setTag(R.id.parent_matrix, (Object) null);
                    } else {
                        setCurrentMatrix(matrix3);
                    }
                }
                ViewUtils.f(view, (Matrix) null);
                transforms.restore(view);
            }

            public void onAnimationPause(Animator animator) {
                setCurrentMatrix(pathAnimatorMatrix.a());
            }

            public void onAnimationResume(Animator animator) {
                ChangeTransform.a(view);
            }
        };
        ofPropertyValuesHolder.addListener(r12);
        AnimatorUtils.a(ofPropertyValuesHolder, r12);
        return ofPropertyValuesHolder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r5 == r4.view) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        if (r4 == r5) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean parentsMatch(android.view.ViewGroup r4, android.view.ViewGroup r5) {
        /*
            r3 = this;
            boolean r0 = r3.isValidTarget(r4)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001a
            boolean r0 = r3.isValidTarget(r5)
            if (r0 != 0) goto L_0x000f
            goto L_0x001a
        L_0x000f:
            androidx.transition.TransitionValues r4 = r3.getMatchedTransitionValues(r4, r1)
            if (r4 == 0) goto L_0x001f
            android.view.View r4 = r4.view
            if (r5 != r4) goto L_0x001d
            goto L_0x001e
        L_0x001a:
            if (r4 != r5) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r1 = r2
        L_0x001e:
            r2 = r1
        L_0x001f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.parentsMatch(android.view.ViewGroup, android.view.ViewGroup):boolean");
    }

    private void setMatricesForParent(TransitionValues transitionValues, TransitionValues transitionValues2) {
        Matrix matrix = (Matrix) transitionValues2.values.get(PROPNAME_PARENT_MATRIX);
        transitionValues2.view.setTag(R.id.parent_matrix, matrix);
        Matrix matrix2 = this.mTempMatrix;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) transitionValues.values.get(PROPNAME_MATRIX);
        if (matrix3 == null) {
            matrix3 = new Matrix();
            transitionValues.values.put(PROPNAME_MATRIX, matrix3);
        }
        matrix3.postConcat((Matrix) transitionValues.values.get(PROPNAME_PARENT_MATRIX));
        matrix3.postConcat(matrix2);
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
        if (!SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
            ((ViewGroup) transitionValues.view.getParent()).startViewTransition(transitionValues.view);
        }
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        boolean z11;
        if (transitionValues == null || transitionValues2 == null || !transitionValues.values.containsKey(PROPNAME_PARENT) || !transitionValues2.values.containsKey(PROPNAME_PARENT)) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) transitionValues.values.get(PROPNAME_PARENT);
        ViewGroup viewGroup3 = (ViewGroup) transitionValues2.values.get(PROPNAME_PARENT);
        if (!this.mReparent || parentsMatch(viewGroup2, viewGroup3)) {
            z11 = false;
        } else {
            z11 = true;
        }
        Matrix matrix = (Matrix) transitionValues.values.get(PROPNAME_INTERMEDIATE_MATRIX);
        if (matrix != null) {
            transitionValues.values.put(PROPNAME_MATRIX, matrix);
        }
        Matrix matrix2 = (Matrix) transitionValues.values.get(PROPNAME_INTERMEDIATE_PARENT_MATRIX);
        if (matrix2 != null) {
            transitionValues.values.put(PROPNAME_PARENT_MATRIX, matrix2);
        }
        if (z11) {
            setMatricesForParent(transitionValues, transitionValues2);
        }
        ObjectAnimator createTransformAnimator = createTransformAnimator(transitionValues, transitionValues2, z11);
        if (z11 && createTransformAnimator != null && this.f37738b) {
            createGhostView(viewGroup, transitionValues, transitionValues2);
        } else if (!SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
            viewGroup2.endViewTransition(transitionValues.view);
        }
        return createTransformAnimator;
    }

    public boolean getReparent() {
        return this.mReparent;
    }

    public boolean getReparentWithOverlay() {
        return this.f37738b;
    }

    @NonNull
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setReparent(boolean z11) {
        this.mReparent = z11;
    }

    public void setReparentWithOverlay(boolean z11) {
        this.f37738b = z11;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f37786g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.f37738b = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.mReparent = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }
}
