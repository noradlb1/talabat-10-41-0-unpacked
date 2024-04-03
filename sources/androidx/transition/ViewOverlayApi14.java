package androidx.transition;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Method;
import java.util.ArrayList;

class ViewOverlayApi14 implements ViewOverlayImpl {

    /* renamed from: a  reason: collision with root package name */
    public OverlayViewGroup f37817a;

    public void add(@NonNull Drawable drawable) {
        this.f37817a.add(drawable);
    }

    public void remove(@NonNull Drawable drawable) {
        this.f37817a.remove(drawable);
    }

    public static class OverlayViewGroup extends ViewGroup {

        /* renamed from: e  reason: collision with root package name */
        public static Method f37818e;

        /* renamed from: b  reason: collision with root package name */
        public ViewGroup f37819b;

        /* renamed from: c  reason: collision with root package name */
        public View f37820c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<Drawable> f37821d;
        private boolean mDisposed;

        static {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                Class cls2 = Integer.TYPE;
                f37818e = cls.getDeclaredMethod("invalidateChildInParentFast", new Class[]{cls2, cls2, Rect.class});
            } catch (NoSuchMethodException unused) {
            }
        }

        private void assertNotDisposed() {
            if (this.mDisposed) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void disposeIfEmpty() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f37821d;
                if (arrayList == null || arrayList.size() == 0) {
                    this.mDisposed = true;
                    this.f37819b.removeView(this);
                }
            }
        }

        private void getOffset(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f37819b.getLocationOnScreen(iArr2);
            this.f37820c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void add(Drawable drawable) {
            assertNotDisposed();
            if (this.f37821d == null) {
                this.f37821d = new ArrayList<>();
            }
            if (!this.f37821d.contains(drawable)) {
                this.f37821d.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        public void dispatchDraw(Canvas canvas) {
            int i11;
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f37819b.getLocationOnScreen(iArr);
            this.f37820c.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.f37820c.getWidth(), this.f37820c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f37821d;
            if (arrayList == null) {
                i11 = 0;
            } else {
                i11 = arrayList.size();
            }
            for (int i12 = 0; i12 < i11; i12++) {
                this.f37821d.get(i12).draw(canvas);
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f37819b == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f37819b != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = new int[2];
                getOffset(iArr2);
                rect.offset(iArr2[0], iArr2[1]);
                return super.invalidateChildInParent(iArr, rect);
            }
            invalidate(rect);
            return null;
        }

        public void invalidateDrawable(@NonNull Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        }

        public void remove(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f37821d;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback((Drawable.Callback) null);
                disposeIfEmpty();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
            r0 = r1.f37821d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean verifyDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable r2) {
            /*
                r1 = this;
                boolean r0 = super.verifyDrawable(r2)
                if (r0 != 0) goto L_0x0013
                java.util.ArrayList<android.graphics.drawable.Drawable> r0 = r1.f37821d
                if (r0 == 0) goto L_0x0011
                boolean r2 = r0.contains(r2)
                if (r2 == 0) goto L_0x0011
                goto L_0x0013
            L_0x0011:
                r2 = 0
                goto L_0x0014
            L_0x0013:
                r2 = 1
            L_0x0014:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ViewOverlayApi14.OverlayViewGroup.verifyDrawable(android.graphics.drawable.Drawable):boolean");
        }

        public void remove(View view) {
            super.removeView(view);
            disposeIfEmpty();
        }

        public void add(View view) {
            assertNotDisposed();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.f37819b || viewGroup.getParent() == null || !ViewCompat.isAttachedToWindow(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f37819b.getLocationOnScreen(iArr2);
                    ViewCompat.offsetLeftAndRight(view, iArr[0] - iArr2[0]);
                    ViewCompat.offsetTopAndBottom(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }
    }
}
