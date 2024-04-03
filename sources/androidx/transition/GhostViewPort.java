package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

@SuppressLint({"ViewConstructor"})
class GhostViewPort extends ViewGroup implements GhostView {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f37773b;

    /* renamed from: c  reason: collision with root package name */
    public View f37774c;

    /* renamed from: d  reason: collision with root package name */
    public final View f37775d;

    /* renamed from: e  reason: collision with root package name */
    public int f37776e;
    @Nullable
    private Matrix mMatrix;
    private final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() {
        public boolean onPreDraw() {
            View view;
            ViewCompat.postInvalidateOnAnimation(GhostViewPort.this);
            GhostViewPort ghostViewPort = GhostViewPort.this;
            ViewGroup viewGroup = ghostViewPort.f37773b;
            if (viewGroup == null || (view = ghostViewPort.f37774c) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            ViewCompat.postInvalidateOnAnimation(GhostViewPort.this.f37773b);
            GhostViewPort ghostViewPort2 = GhostViewPort.this;
            ghostViewPort2.f37773b = null;
            ghostViewPort2.f37774c = null;
            return true;
        }
    };

    public GhostViewPort(View view) {
        super(view.getContext());
        this.f37775d = view;
        setWillNotDraw(false);
        setClipChildren(false);
        setLayerType(2, (Paint) null);
    }

    public static GhostViewPort a(View view, ViewGroup viewGroup, Matrix matrix) {
        int i11;
        GhostViewHolder ghostViewHolder;
        if (view.getParent() instanceof ViewGroup) {
            GhostViewHolder b11 = GhostViewHolder.b(viewGroup);
            GhostViewPort d11 = d(view);
            if (d11 == null || (ghostViewHolder = (GhostViewHolder) d11.getParent()) == b11) {
                i11 = 0;
            } else {
                i11 = d11.f37776e;
                ghostViewHolder.removeView(d11);
                d11 = null;
            }
            if (d11 == null) {
                if (matrix == null) {
                    matrix = new Matrix();
                    b(view, viewGroup, matrix);
                }
                d11 = new GhostViewPort(view);
                d11.g(matrix);
                if (b11 == null) {
                    b11 = new GhostViewHolder(viewGroup);
                } else {
                    b11.c();
                }
                c(viewGroup, b11);
                c(viewGroup, d11);
                b11.a(d11);
                d11.f37776e = i11;
            } else if (matrix != null) {
                d11.g(matrix);
            }
            d11.f37776e++;
            return d11;
        }
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    public static void b(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        ViewUtils.j(viewGroup2, matrix);
        matrix.preTranslate((float) (-viewGroup2.getScrollX()), (float) (-viewGroup2.getScrollY()));
        ViewUtils.k(viewGroup, matrix);
    }

    public static void c(View view, View view2) {
        ViewUtils.g(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    public static GhostViewPort d(View view) {
        return (GhostViewPort) view.getTag(R.id.ghost_view);
    }

    public static void e(View view) {
        GhostViewPort d11 = d(view);
        if (d11 != null) {
            int i11 = d11.f37776e - 1;
            d11.f37776e = i11;
            if (i11 <= 0) {
                ((GhostViewHolder) d11.getParent()).removeView(d11);
            }
        }
    }

    public static void f(@NonNull View view, @Nullable GhostViewPort ghostViewPort) {
        view.setTag(R.id.ghost_view, ghostViewPort);
    }

    public void g(@NonNull Matrix matrix) {
        this.mMatrix = matrix;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f(this.f37775d, this);
        this.f37775d.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.i(this.f37775d, 4);
        if (this.f37775d.getParent() != null) {
            ((View) this.f37775d.getParent()).invalidate();
        }
    }

    public void onDetachedFromWindow() {
        this.f37775d.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.i(this.f37775d, 0);
        f(this.f37775d, (GhostViewPort) null);
        if (this.f37775d.getParent() != null) {
            ((View) this.f37775d.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        CanvasUtils.a(canvas, true);
        canvas.setMatrix(this.mMatrix);
        ViewUtils.i(this.f37775d, 0);
        this.f37775d.invalidate();
        ViewUtils.i(this.f37775d, 4);
        drawChild(canvas, this.f37775d, getDrawingTime());
        CanvasUtils.a(canvas, false);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
    }

    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
        this.f37773b = viewGroup;
        this.f37774c = view;
    }

    public void setVisibility(int i11) {
        int i12;
        super.setVisibility(i11);
        if (d(this.f37775d) == this) {
            if (i11 == 0) {
                i12 = 4;
            } else {
                i12 = 0;
            }
            ViewUtils.i(this.f37775d, i12);
        }
    }
}
