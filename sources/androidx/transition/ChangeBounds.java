package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.util.Map;

public class ChangeBounds extends Transition {
    private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY;
    private static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY;
    private static final Property<Drawable, PointF> DRAWABLE_ORIGIN_PROPERTY;
    private static final Property<View, PointF> POSITION_PROPERTY;
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY;
    private static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY;
    private static RectEvaluator sRectEvaluator = new RectEvaluator();
    private static final String[] sTransitionProperties = {PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
    private boolean mReparent = false;
    private boolean mResizeClip = false;
    private int[] mTempLocation = new int[2];

    public static class ViewBounds {
        private int mBottom;
        private int mBottomRightCalls;
        private int mLeft;
        private int mRight;
        private int mTop;
        private int mTopLeftCalls;
        private View mView;

        public ViewBounds(View view) {
            this.mView = view;
        }

        private void setLeftTopRightBottom() {
            ViewUtils.g(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }

        public void a(PointF pointF) {
            this.mRight = Math.round(pointF.x);
            this.mBottom = Math.round(pointF.y);
            int i11 = this.mBottomRightCalls + 1;
            this.mBottomRightCalls = i11;
            if (this.mTopLeftCalls == i11) {
                setLeftTopRightBottom();
            }
        }

        public void b(PointF pointF) {
            this.mLeft = Math.round(pointF.x);
            this.mTop = Math.round(pointF.y);
            int i11 = this.mTopLeftCalls + 1;
            this.mTopLeftCalls = i11;
            if (i11 == this.mBottomRightCalls) {
                setLeftTopRightBottom();
            }
        }
    }

    static {
        Class<PointF> cls = PointF.class;
        DRAWABLE_ORIGIN_PROPERTY = new Property<Drawable, PointF>(cls, "boundsOrigin") {
            private Rect mBounds = new Rect();

            public PointF get(Drawable drawable) {
                drawable.copyBounds(this.mBounds);
                Rect rect = this.mBounds;
                return new PointF((float) rect.left, (float) rect.top);
            }

            public void set(Drawable drawable, PointF pointF) {
                drawable.copyBounds(this.mBounds);
                this.mBounds.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
                drawable.setBounds(this.mBounds);
            }
        };
        TOP_LEFT_PROPERTY = new Property<ViewBounds, PointF>(cls, "topLeft") {
            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.b(pointF);
            }
        };
        BOTTOM_RIGHT_PROPERTY = new Property<ViewBounds, PointF>(cls, "bottomRight") {
            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.a(pointF);
            }
        };
        BOTTOM_RIGHT_ONLY_PROPERTY = new Property<View, PointF>(cls, "bottomRight") {
            public PointF get(View view) {
                return null;
            }

            public void set(View view, PointF pointF) {
                ViewUtils.g(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
            }
        };
        TOP_LEFT_ONLY_PROPERTY = new Property<View, PointF>(cls, "topLeft") {
            public PointF get(View view) {
                return null;
            }

            public void set(View view, PointF pointF) {
                ViewUtils.g(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
            }
        };
        POSITION_PROPERTY = new Property<View, PointF>(cls, "position") {
            public PointF get(View view) {
                return null;
            }

            public void set(View view, PointF pointF) {
                int round = Math.round(pointF.x);
                int round2 = Math.round(pointF.y);
                ViewUtils.g(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
            }
        };
    }

    public ChangeBounds() {
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (ViewCompat.isLaidOut(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            transitionValues.values.put(PROPNAME_BOUNDS, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
            if (this.mReparent) {
                transitionValues.view.getLocationInWindow(this.mTempLocation);
                transitionValues.values.put(PROPNAME_WINDOW_X, Integer.valueOf(this.mTempLocation[0]));
                transitionValues.values.put(PROPNAME_WINDOW_Y, Integer.valueOf(this.mTempLocation[1]));
            }
            if (this.mResizeClip) {
                transitionValues.values.put(PROPNAME_CLIP, ViewCompat.getClipBounds(view));
            }
        }
    }

    private boolean parentMatches(View view, View view2) {
        if (!this.mReparent) {
            return true;
        }
        TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
        if (matchedTransitionValues == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == matchedTransitionValues.view) {
            return true;
        }
        return false;
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        int i11;
        View view;
        Animator animator;
        ObjectAnimator objectAnimator;
        int i12;
        Rect rect;
        Rect rect2;
        ObjectAnimator objectAnimator2;
        TransitionValues transitionValues3 = transitionValues;
        TransitionValues transitionValues4 = transitionValues2;
        if (transitionValues3 == null || transitionValues4 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues3.values;
        Map<String, Object> map2 = transitionValues4.values;
        ViewGroup viewGroup2 = (ViewGroup) map.get(PROPNAME_PARENT);
        ViewGroup viewGroup3 = (ViewGroup) map2.get(PROPNAME_PARENT);
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = transitionValues4.view;
        if (parentMatches(viewGroup2, viewGroup3)) {
            Rect rect3 = (Rect) transitionValues3.values.get(PROPNAME_BOUNDS);
            Rect rect4 = (Rect) transitionValues4.values.get(PROPNAME_BOUNDS);
            int i13 = rect3.left;
            int i14 = rect4.left;
            int i15 = rect3.top;
            int i16 = rect4.top;
            int i17 = rect3.right;
            int i18 = rect4.right;
            int i19 = rect3.bottom;
            int i21 = rect4.bottom;
            int i22 = i17 - i13;
            int i23 = i19 - i15;
            int i24 = i18 - i14;
            int i25 = i21 - i16;
            View view3 = view2;
            Rect rect5 = (Rect) transitionValues3.values.get(PROPNAME_CLIP);
            Rect rect6 = (Rect) transitionValues4.values.get(PROPNAME_CLIP);
            if ((i22 == 0 || i23 == 0) && (i24 == 0 || i25 == 0)) {
                i11 = 0;
            } else {
                if (i13 == i14 && i15 == i16) {
                    i11 = 0;
                } else {
                    i11 = 1;
                }
                if (!(i17 == i18 && i19 == i21)) {
                    i11++;
                }
            }
            if ((rect5 != null && !rect5.equals(rect6)) || (rect5 == null && rect6 != null)) {
                i11++;
            }
            if (i11 <= 0) {
                return null;
            }
            Rect rect7 = rect6;
            Rect rect8 = rect5;
            if (!this.mResizeClip) {
                view = view3;
                ViewUtils.g(view, i13, i15, i17, i19);
                if (i11 == 2) {
                    if (i22 == i24 && i23 == i25) {
                        animator = ObjectAnimatorUtils.a(view, POSITION_PROPERTY, getPathMotion().getPath((float) i13, (float) i15, (float) i14, (float) i16));
                    } else {
                        ViewBounds viewBounds = new ViewBounds(view);
                        ObjectAnimator a11 = ObjectAnimatorUtils.a(viewBounds, TOP_LEFT_PROPERTY, getPathMotion().getPath((float) i13, (float) i15, (float) i14, (float) i16));
                        ObjectAnimator a12 = ObjectAnimatorUtils.a(viewBounds, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath((float) i17, (float) i19, (float) i18, (float) i21));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{a11, a12});
                        animatorSet.addListener(new AnimatorListenerAdapter(viewBounds) {

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ ViewBounds f37723a;
                            private ViewBounds mViewBounds;

                            {
                                this.f37723a = r2;
                                this.mViewBounds = r2;
                            }
                        });
                        animator = animatorSet;
                    }
                } else if (i13 == i14 && i15 == i16) {
                    animator = ObjectAnimatorUtils.a(view, BOTTOM_RIGHT_ONLY_PROPERTY, getPathMotion().getPath((float) i17, (float) i19, (float) i18, (float) i21));
                } else {
                    animator = ObjectAnimatorUtils.a(view, TOP_LEFT_ONLY_PROPERTY, getPathMotion().getPath((float) i13, (float) i15, (float) i14, (float) i16));
                }
            } else {
                view = view3;
                ViewUtils.g(view, i13, i15, Math.max(i22, i24) + i13, Math.max(i23, i25) + i15);
                if (i13 == i14 && i15 == i16) {
                    objectAnimator = null;
                } else {
                    objectAnimator = ObjectAnimatorUtils.a(view, POSITION_PROPERTY, getPathMotion().getPath((float) i13, (float) i15, (float) i14, (float) i16));
                }
                if (rect8 == null) {
                    i12 = 0;
                    rect = new Rect(0, 0, i22, i23);
                } else {
                    i12 = 0;
                    rect = rect8;
                }
                if (rect7 == null) {
                    rect2 = new Rect(i12, i12, i24, i25);
                } else {
                    rect2 = rect7;
                }
                if (!rect.equals(rect2)) {
                    ViewCompat.setClipBounds(view, rect);
                    RectEvaluator rectEvaluator = sRectEvaluator;
                    Object[] objArr = new Object[2];
                    objArr[i12] = rect;
                    objArr[1] = rect2;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", rectEvaluator, objArr);
                    final View view4 = view;
                    final Rect rect9 = rect7;
                    final int i26 = i14;
                    final int i27 = i16;
                    final int i28 = i18;
                    final int i29 = i21;
                    ofObject.addListener(new AnimatorListenerAdapter() {
                        private boolean mIsCanceled;

                        public void onAnimationCancel(Animator animator) {
                            this.mIsCanceled = true;
                        }

                        public void onAnimationEnd(Animator animator) {
                            if (!this.mIsCanceled) {
                                ViewCompat.setClipBounds(view4, rect9);
                                ViewUtils.g(view4, i26, i27, i28, i29);
                            }
                        }
                    });
                    objectAnimator2 = ofObject;
                } else {
                    objectAnimator2 = null;
                }
                animator = TransitionUtils.b(objectAnimator, objectAnimator2);
            }
            if (view.getParent() instanceof ViewGroup) {
                final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                ViewGroupUtils.c(viewGroup4, true);
                addListener(new TransitionListenerAdapter() {

                    /* renamed from: a  reason: collision with root package name */
                    public boolean f37732a = false;

                    public void onTransitionCancel(@NonNull Transition transition) {
                        ViewGroupUtils.c(viewGroup4, false);
                        this.f37732a = true;
                    }

                    public void onTransitionEnd(@NonNull Transition transition) {
                        if (!this.f37732a) {
                            ViewGroupUtils.c(viewGroup4, false);
                        }
                        transition.removeListener(this);
                    }

                    public void onTransitionPause(@NonNull Transition transition) {
                        ViewGroupUtils.c(viewGroup4, false);
                    }

                    public void onTransitionResume(@NonNull Transition transition) {
                        ViewGroupUtils.c(viewGroup4, true);
                    }
                });
            }
            return animator;
        }
        int intValue = ((Integer) transitionValues3.values.get(PROPNAME_WINDOW_X)).intValue();
        int intValue2 = ((Integer) transitionValues3.values.get(PROPNAME_WINDOW_Y)).intValue();
        int intValue3 = ((Integer) transitionValues4.values.get(PROPNAME_WINDOW_X)).intValue();
        int intValue4 = ((Integer) transitionValues4.values.get(PROPNAME_WINDOW_Y)).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.mTempLocation);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c11 = ViewUtils.c(view2);
        ViewUtils.h(view2, 0.0f);
        ViewUtils.b(viewGroup).add(bitmapDrawable);
        PathMotion pathMotion = getPathMotion();
        int[] iArr = this.mTempLocation;
        int i31 = iArr[0];
        int i32 = iArr[1];
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{PropertyValuesHolderUtils.a(DRAWABLE_ORIGIN_PROPERTY, pathMotion.getPath((float) (intValue - i31), (float) (intValue2 - i32), (float) (intValue3 - i31), (float) (intValue4 - i32)))});
        final ViewGroup viewGroup5 = viewGroup;
        final BitmapDrawable bitmapDrawable2 = bitmapDrawable;
        final View view5 = view2;
        final float f11 = c11;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ViewUtils.b(viewGroup5).remove(bitmapDrawable2);
                ViewUtils.h(view5, f11);
            }
        });
        return ofPropertyValuesHolder;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    @NonNull
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setResizeClip(boolean z11) {
        this.mResizeClip = z11;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f37783d);
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        setResizeClip(namedBoolean);
    }
}
