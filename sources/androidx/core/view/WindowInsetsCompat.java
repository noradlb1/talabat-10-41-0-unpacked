package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class WindowInsetsCompat {
    @NonNull
    public static final WindowInsetsCompat CONSUMED;
    private static final String TAG = "WindowInsetsCompat";
    private final Impl mImpl;

    @RequiresApi(21)
    @SuppressLint({"SoonBlockedPrivateApi"})
    public static class Api21ReflectionHolder {
        private static Field sContentInsets;
        private static boolean sReflectionSucceeded = true;
        private static Field sStableInsets;
        private static Field sViewAttachInfoField;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                sViewAttachInfoField = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                sStableInsets = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                sContentInsets = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e11) {
                Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets from AttachInfo " + e11.getMessage(), e11);
            }
        }

        private Api21ReflectionHolder() {
        }

        @Nullable
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
            if (sReflectionSucceeded && view.isAttachedToWindow()) {
                try {
                    Object obj = sViewAttachInfoField.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) sStableInsets.get(obj);
                        Rect rect2 = (Rect) sContentInsets.get(obj);
                        if (!(rect == null || rect2 == null)) {
                            WindowInsetsCompat build = new Builder().setStableInsets(Insets.of(rect)).setSystemWindowInsets(Insets.of(rect2)).build();
                            build.e(build);
                            build.a(view.getRootView());
                            return build;
                        }
                    }
                } catch (IllegalAccessException e11) {
                    Log.w(WindowInsetsCompat.TAG, "Failed to get insets from AttachInfo. " + e11.getMessage(), e11);
                }
            }
            return null;
        }
    }

    public static class BuilderImpl {

        /* renamed from: a  reason: collision with root package name */
        public Insets[] f11520a;
        private final WindowInsetsCompat mInsets;

        public BuilderImpl() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        public final void a() {
            Insets[] insetsArr = this.f11520a;
            if (insetsArr != null) {
                Insets insets = insetsArr[Type.b(1)];
                Insets insets2 = this.f11520a[Type.b(2)];
                if (insets2 == null) {
                    insets2 = this.mInsets.getInsets(2);
                }
                if (insets == null) {
                    insets = this.mInsets.getInsets(1);
                }
                i(Insets.max(insets, insets2));
                Insets insets3 = this.f11520a[Type.b(16)];
                if (insets3 != null) {
                    h(insets3);
                }
                Insets insets4 = this.f11520a[Type.b(32)];
                if (insets4 != null) {
                    f(insets4);
                }
                Insets insets5 = this.f11520a[Type.b(64)];
                if (insets5 != null) {
                    j(insets5);
                }
            }
        }

        @NonNull
        public WindowInsetsCompat b() {
            a();
            return this.mInsets;
        }

        public void c(@Nullable DisplayCutoutCompat displayCutoutCompat) {
        }

        public void d(int i11, @NonNull Insets insets) {
            if (this.f11520a == null) {
                this.f11520a = new Insets[9];
            }
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i11 & i12) != 0) {
                    this.f11520a[Type.b(i12)] = insets;
                }
            }
        }

        public void e(int i11, @NonNull Insets insets) {
            if (i11 == 8) {
                throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
            }
        }

        public void f(@NonNull Insets insets) {
        }

        public void g(@NonNull Insets insets) {
        }

        public void h(@NonNull Insets insets) {
        }

        public void i(@NonNull Insets insets) {
        }

        public void j(@NonNull Insets insets) {
        }

        public void k(int i11, boolean z11) {
        }

        public BuilderImpl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.mInsets = windowInsetsCompat;
        }
    }

    @RequiresApi(30)
    public static class BuilderImpl30 extends BuilderImpl29 {
        public BuilderImpl30() {
        }

        public void d(int i11, @NonNull Insets insets) {
            WindowInsets.Builder unused = this.f11521b.setInsets(TypeImpl30.a(i11), insets.toPlatformInsets());
        }

        public void e(int i11, @NonNull Insets insets) {
            WindowInsets.Builder unused = this.f11521b.setInsetsIgnoringVisibility(TypeImpl30.a(i11), insets.toPlatformInsets());
        }

        public void k(int i11, boolean z11) {
            WindowInsets.Builder unused = this.f11521b.setVisible(TypeImpl30.a(i11), z11);
        }

        public BuilderImpl30(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }
    }

    public static class Impl {
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public static final WindowInsetsCompat f11522b = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();

        /* renamed from: a  reason: collision with root package name */
        public final WindowInsetsCompat f11523a;

        public Impl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f11523a = windowInsetsCompat;
        }

        @NonNull
        public WindowInsetsCompat a() {
            return this.f11523a;
        }

        @NonNull
        public WindowInsetsCompat b() {
            return this.f11523a;
        }

        @NonNull
        public WindowInsetsCompat c() {
            return this.f11523a;
        }

        public void d(@NonNull View view) {
        }

        public void e(@NonNull WindowInsetsCompat windowInsetsCompat) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl)) {
                return false;
            }
            Impl impl = (Impl) obj;
            if (n() != impl.n() || m() != impl.m() || !ObjectsCompat.equals(j(), impl.j()) || !ObjectsCompat.equals(h(), impl.h()) || !ObjectsCompat.equals(f(), impl.f())) {
                return false;
            }
            return true;
        }

        @Nullable
        public DisplayCutoutCompat f() {
            return null;
        }

        @NonNull
        public Insets g() {
            return j();
        }

        @NonNull
        public Insets getInsets(int i11) {
            return Insets.NONE;
        }

        @NonNull
        public Insets getInsetsIgnoringVisibility(int i11) {
            if ((i11 & 8) == 0) {
                return Insets.NONE;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        @NonNull
        public Insets h() {
            return Insets.NONE;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Boolean.valueOf(n()), Boolean.valueOf(m()), j(), h(), f());
        }

        @NonNull
        public Insets i() {
            return j();
        }

        public boolean isVisible(int i11) {
            return true;
        }

        @NonNull
        public Insets j() {
            return Insets.NONE;
        }

        @NonNull
        public Insets k() {
            return j();
        }

        @NonNull
        public WindowInsetsCompat l(int i11, int i12, int i13, int i14) {
            return f11522b;
        }

        public boolean m() {
            return false;
        }

        public boolean n() {
            return false;
        }

        public void o(@NonNull Insets insets) {
        }

        public void p(@Nullable WindowInsetsCompat windowInsetsCompat) {
        }

        public void setOverriddenInsets(Insets[] insetsArr) {
        }

        public void setStableInsets(Insets insets) {
        }
    }

    @RequiresApi(20)
    public static class Impl20 extends Impl {
        private static Class<?> sAttachInfoClass = null;
        private static Field sAttachInfoField = null;
        private static Method sGetViewRootImplMethod = null;
        private static Field sVisibleInsetsField = null;
        private static boolean sVisibleRectReflectionFetched = false;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public final WindowInsets f11524c;

        /* renamed from: d  reason: collision with root package name */
        public Insets f11525d;
        private Insets[] mOverriddenInsets;
        private WindowInsetsCompat mRootWindowInsets;
        private Insets mSystemWindowInsets;

        public Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.mSystemWindowInsets = null;
            this.f11524c = windowInsets;
        }

        private Insets getRootStableInsets() {
            WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
            if (windowInsetsCompat != null) {
                return windowInsetsCompat.getStableInsets();
            }
            return Insets.NONE;
        }

        @Nullable
        private Insets getVisibleInsets(@NonNull View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!sVisibleRectReflectionFetched) {
                    loadReflectionField();
                }
                Method method = sGetViewRootImplMethod;
                if (!(method == null || sAttachInfoClass == null || sVisibleInsetsField == null)) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) sVisibleInsetsField.get(sAttachInfoField.get(invoke));
                        if (rect != null) {
                            return Insets.of(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e11) {
                        Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e11.getMessage(), e11);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        private static void loadReflectionField() {
            try {
                sGetViewRootImplMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                sAttachInfoClass = cls;
                sVisibleInsetsField = cls.getDeclaredField("mVisibleInsets");
                sAttachInfoField = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                sVisibleInsetsField.setAccessible(true);
                sAttachInfoField.setAccessible(true);
            } catch (ReflectiveOperationException e11) {
                Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e11.getMessage(), e11);
            }
            sVisibleRectReflectionFetched = true;
        }

        public void d(@NonNull View view) {
            Insets visibleInsets = getVisibleInsets(view);
            if (visibleInsets == null) {
                visibleInsets = Insets.NONE;
            }
            o(visibleInsets);
        }

        public void e(@NonNull WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.e(this.mRootWindowInsets);
            windowInsetsCompat.d(this.f11525d);
        }

        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f11525d, ((Impl20) obj).f11525d);
        }

        @NonNull
        public Insets getInsets(int i11) {
            return getInsets(i11, false);
        }

        @NonNull
        public Insets getInsetsIgnoringVisibility(int i11) {
            return getInsets(i11, true);
        }

        @SuppressLint({"WrongConstant"})
        public boolean isVisible(int i11) {
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i11 & i12) != 0 && !r(i12)) {
                    return false;
                }
            }
            return true;
        }

        @NonNull
        public final Insets j() {
            if (this.mSystemWindowInsets == null) {
                this.mSystemWindowInsets = Insets.of(this.f11524c.getSystemWindowInsetLeft(), this.f11524c.getSystemWindowInsetTop(), this.f11524c.getSystemWindowInsetRight(), this.f11524c.getSystemWindowInsetBottom());
            }
            return this.mSystemWindowInsets;
        }

        @NonNull
        public WindowInsetsCompat l(int i11, int i12, int i13, int i14) {
            Builder builder = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.f11524c));
            builder.setSystemWindowInsets(WindowInsetsCompat.b(j(), i11, i12, i13, i14));
            builder.setStableInsets(WindowInsetsCompat.b(h(), i11, i12, i13, i14));
            return builder.build();
        }

        public boolean n() {
            return this.f11524c.isRound();
        }

        public void o(@NonNull Insets insets) {
            this.f11525d = insets;
        }

        public void p(@Nullable WindowInsetsCompat windowInsetsCompat) {
            this.mRootWindowInsets = windowInsetsCompat;
        }

        @NonNull
        public Insets q(int i11, boolean z11) {
            int i12;
            DisplayCutoutCompat displayCutoutCompat;
            if (i11 != 1) {
                Insets insets = null;
                if (i11 != 2) {
                    if (i11 == 8) {
                        Insets[] insetsArr = this.mOverriddenInsets;
                        if (insetsArr != null) {
                            insets = insetsArr[Type.b(8)];
                        }
                        if (insets != null) {
                            return insets;
                        }
                        Insets j11 = j();
                        Insets rootStableInsets = getRootStableInsets();
                        int i13 = j11.bottom;
                        if (i13 > rootStableInsets.bottom) {
                            return Insets.of(0, 0, 0, i13);
                        }
                        Insets insets2 = this.f11525d;
                        if (insets2 == null || insets2.equals(Insets.NONE) || (i12 = this.f11525d.bottom) <= rootStableInsets.bottom) {
                            return Insets.NONE;
                        }
                        return Insets.of(0, 0, 0, i12);
                    } else if (i11 == 16) {
                        return i();
                    } else {
                        if (i11 == 32) {
                            return g();
                        }
                        if (i11 == 64) {
                            return k();
                        }
                        if (i11 != 128) {
                            return Insets.NONE;
                        }
                        WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
                        if (windowInsetsCompat != null) {
                            displayCutoutCompat = windowInsetsCompat.getDisplayCutout();
                        } else {
                            displayCutoutCompat = f();
                        }
                        if (displayCutoutCompat != null) {
                            return Insets.of(displayCutoutCompat.getSafeInsetLeft(), displayCutoutCompat.getSafeInsetTop(), displayCutoutCompat.getSafeInsetRight(), displayCutoutCompat.getSafeInsetBottom());
                        }
                        return Insets.NONE;
                    }
                } else if (z11) {
                    Insets rootStableInsets2 = getRootStableInsets();
                    Insets h11 = h();
                    return Insets.of(Math.max(rootStableInsets2.left, h11.left), 0, Math.max(rootStableInsets2.right, h11.right), Math.max(rootStableInsets2.bottom, h11.bottom));
                } else {
                    Insets j12 = j();
                    WindowInsetsCompat windowInsetsCompat2 = this.mRootWindowInsets;
                    if (windowInsetsCompat2 != null) {
                        insets = windowInsetsCompat2.getStableInsets();
                    }
                    int i14 = j12.bottom;
                    if (insets != null) {
                        i14 = Math.min(i14, insets.bottom);
                    }
                    return Insets.of(j12.left, 0, j12.right, i14);
                }
            } else if (z11) {
                return Insets.of(0, Math.max(getRootStableInsets().top, j().top), 0, 0);
            } else {
                return Insets.of(0, j().top, 0, 0);
            }
        }

        public boolean r(int i11) {
            if (!(i11 == 1 || i11 == 2)) {
                if (i11 == 4) {
                    return false;
                }
                if (!(i11 == 8 || i11 == 128)) {
                    return true;
                }
            }
            return !q(i11, false).equals(Insets.NONE);
        }

        public void setOverriddenInsets(Insets[] insetsArr) {
            this.mOverriddenInsets = insetsArr;
        }

        @SuppressLint({"WrongConstant"})
        @NonNull
        private Insets getInsets(int i11, boolean z11) {
            Insets insets = Insets.NONE;
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i11 & i12) != 0) {
                    insets = Insets.max(insets, q(i12, z11));
                }
            }
            return insets;
        }

        public Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl20 impl20) {
            this(windowInsetsCompat, new WindowInsets(impl20.f11524c));
        }
    }

    @RequiresApi(28)
    public static class Impl28 extends Impl21 {
        public Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @NonNull
        public WindowInsetsCompat a() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f11524c.consumeDisplayCutout());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl28)) {
                return false;
            }
            Impl28 impl28 = (Impl28) obj;
            if (!Objects.equals(this.f11524c, impl28.f11524c) || !Objects.equals(this.f11525d, impl28.f11525d)) {
                return false;
            }
            return true;
        }

        @Nullable
        public DisplayCutoutCompat f() {
            return DisplayCutoutCompat.b(this.f11524c.getDisplayCutout());
        }

        public int hashCode() {
            return this.f11524c.hashCode();
        }

        public Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl28 impl28) {
            super(windowInsetsCompat, (Impl21) impl28);
        }
    }

    @RequiresApi(30)
    public static class Impl30 extends Impl29 {
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        public static final WindowInsetsCompat f11526e = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);

        public Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public final void d(@NonNull View view) {
        }

        @NonNull
        public Insets getInsets(int i11) {
            return Insets.toCompatInsets(this.f11524c.getInsets(TypeImpl30.a(i11)));
        }

        @NonNull
        public Insets getInsetsIgnoringVisibility(int i11) {
            return Insets.toCompatInsets(this.f11524c.getInsetsIgnoringVisibility(TypeImpl30.a(i11)));
        }

        public boolean isVisible(int i11) {
            return this.f11524c.isVisible(TypeImpl30.a(i11));
        }

        public Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl30 impl30) {
            super(windowInsetsCompat, (Impl29) impl30);
        }
    }

    public static final class Type {

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface InsetsType {
        }

        private Type() {
        }

        @SuppressLint({"WrongConstant"})
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static int a() {
            return -1;
        }

        public static int b(int i11) {
            if (i11 == 1) {
                return 0;
            }
            if (i11 == 2) {
                return 1;
            }
            if (i11 == 4) {
                return 2;
            }
            if (i11 == 8) {
                return 3;
            }
            if (i11 == 16) {
                return 4;
            }
            if (i11 == 32) {
                return 5;
            }
            if (i11 == 64) {
                return 6;
            }
            if (i11 == 128) {
                return 7;
            }
            if (i11 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i11);
        }

        public static int captionBar() {
            return 4;
        }

        public static int displayCutout() {
            return 128;
        }

        public static int ime() {
            return 8;
        }

        public static int mandatorySystemGestures() {
            return 32;
        }

        public static int navigationBars() {
            return 2;
        }

        public static int statusBars() {
            return 1;
        }

        public static int systemBars() {
            return 7;
        }

        public static int systemGestures() {
            return 16;
        }

        public static int tappableElement() {
            return 64;
        }
    }

    @RequiresApi(30)
    public static final class TypeImpl30 {
        private TypeImpl30() {
        }

        public static int a(int i11) {
            int i12;
            int i13 = 0;
            for (int i14 = 1; i14 <= 256; i14 <<= 1) {
                if ((i11 & i14) != 0) {
                    if (i14 == 1) {
                        i12 = WindowInsets.Type.statusBars();
                    } else if (i14 == 2) {
                        i12 = WindowInsets.Type.navigationBars();
                    } else if (i14 == 4) {
                        i12 = WindowInsets.Type.captionBar();
                    } else if (i14 == 8) {
                        i12 = WindowInsets.Type.ime();
                    } else if (i14 == 16) {
                        i12 = WindowInsets.Type.systemGestures();
                    } else if (i14 == 32) {
                        i12 = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i14 == 64) {
                        i12 = WindowInsets.Type.tappableElement();
                    } else if (i14 == 128) {
                        i12 = WindowInsets.Type.displayCutout();
                    }
                    i13 |= i12;
                }
            }
            return i13;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            CONSUMED = Impl30.f11526e;
        } else {
            CONSUMED = Impl.f11522b;
        }
    }

    @RequiresApi(20)
    private WindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            this.mImpl = new Impl30(this, windowInsets);
        } else if (i11 >= 29) {
            this.mImpl = new Impl29(this, windowInsets);
        } else if (i11 >= 28) {
            this.mImpl = new Impl28(this, windowInsets);
        } else {
            this.mImpl = new Impl21(this, windowInsets);
        }
    }

    public static Insets b(@NonNull Insets insets, int i11, int i12, int i13, int i14) {
        int max = Math.max(0, insets.left - i11);
        int max2 = Math.max(0, insets.top - i12);
        int max3 = Math.max(0, insets.right - i13);
        int max4 = Math.max(0, insets.bottom - i14);
        if (max == i11 && max2 == i12 && max3 == i13 && max4 == i14) {
            return insets;
        }
        return Insets.of(max, max2, max3, max4);
    }

    @RequiresApi(20)
    @NonNull
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        return toWindowInsetsCompat(windowInsets, (View) null);
    }

    public void a(@NonNull View view) {
        this.mImpl.d(view);
    }

    public void c(Insets[] insetsArr) {
        this.mImpl.setOverriddenInsets(insetsArr);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.a();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.b();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.c();
    }

    public void d(@NonNull Insets insets) {
        this.mImpl.o(insets);
    }

    public void e(@Nullable WindowInsetsCompat windowInsetsCompat) {
        this.mImpl.p(windowInsetsCompat);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat)) {
            return false;
        }
        return ObjectsCompat.equals(this.mImpl, ((WindowInsetsCompat) obj).mImpl);
    }

    public void f(@Nullable Insets insets) {
        this.mImpl.setStableInsets(insets);
    }

    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.f();
    }

    @NonNull
    public Insets getInsets(int i11) {
        return this.mImpl.getInsets(i11);
    }

    @NonNull
    public Insets getInsetsIgnoringVisibility(int i11) {
        return this.mImpl.getInsetsIgnoringVisibility(i11);
    }

    @NonNull
    @Deprecated
    public Insets getMandatorySystemGestureInsets() {
        return this.mImpl.g();
    }

    @Deprecated
    public int getStableInsetBottom() {
        return this.mImpl.h().bottom;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return this.mImpl.h().left;
    }

    @Deprecated
    public int getStableInsetRight() {
        return this.mImpl.h().right;
    }

    @Deprecated
    public int getStableInsetTop() {
        return this.mImpl.h().top;
    }

    @NonNull
    @Deprecated
    public Insets getStableInsets() {
        return this.mImpl.h();
    }

    @NonNull
    @Deprecated
    public Insets getSystemGestureInsets() {
        return this.mImpl.i();
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.mImpl.j().bottom;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.mImpl.j().left;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.mImpl.j().right;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.mImpl.j().top;
    }

    @NonNull
    @Deprecated
    public Insets getSystemWindowInsets() {
        return this.mImpl.j();
    }

    @NonNull
    @Deprecated
    public Insets getTappableElementInsets() {
        return this.mImpl.k();
    }

    public boolean hasInsets() {
        Insets insets = getInsets(Type.a());
        Insets insets2 = Insets.NONE;
        if (!insets.equals(insets2) || !getInsetsIgnoringVisibility(Type.a() ^ Type.ime()).equals(insets2) || getDisplayCutout() != null) {
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return !this.mImpl.h().equals(Insets.NONE);
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return !this.mImpl.j().equals(Insets.NONE);
    }

    public int hashCode() {
        Impl impl = this.mImpl;
        if (impl == null) {
            return 0;
        }
        return impl.hashCode();
    }

    @NonNull
    public WindowInsetsCompat inset(@NonNull Insets insets) {
        return inset(insets.left, insets.top, insets.right, insets.bottom);
    }

    public boolean isConsumed() {
        return this.mImpl.m();
    }

    public boolean isRound() {
        return this.mImpl.n();
    }

    public boolean isVisible(int i11) {
        return this.mImpl.isVisible(i11);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int i11, int i12, int i13, int i14) {
        return new Builder(this).setSystemWindowInsets(Insets.of(i11, i12, i13, i14)).build();
    }

    @RequiresApi(20)
    @Nullable
    public WindowInsets toWindowInsets() {
        Impl impl = this.mImpl;
        if (impl instanceof Impl20) {
            return ((Impl20) impl).f11524c;
        }
        return null;
    }

    @RequiresApi(api = 20)
    public static class BuilderImpl20 extends BuilderImpl {
        private static Constructor<WindowInsets> sConstructor = null;
        private static boolean sConstructorFetched = false;
        private static Field sConsumedField = null;
        private static boolean sConsumedFieldFetched = false;
        private WindowInsets mPlatformInsets;
        private Insets mStableInsets;

        public BuilderImpl20() {
            this.mPlatformInsets = createWindowInsetsInstance();
        }

        @Nullable
        private static WindowInsets createWindowInsetsInstance() {
            Class<WindowInsets> cls = WindowInsets.class;
            if (!sConsumedFieldFetched) {
                try {
                    sConsumedField = cls.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e11) {
                    Log.i(WindowInsetsCompat.TAG, "Could not retrieve WindowInsets.CONSUMED field", e11);
                }
                sConsumedFieldFetched = true;
            }
            Field field = sConsumedField;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get((Object) null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e12) {
                    Log.i(WindowInsetsCompat.TAG, "Could not get value from WindowInsets.CONSUMED field", e12);
                }
            }
            if (!sConstructorFetched) {
                try {
                    sConstructor = cls.getConstructor(new Class[]{Rect.class});
                } catch (ReflectiveOperationException e13) {
                    Log.i(WindowInsetsCompat.TAG, "Could not retrieve WindowInsets(Rect) constructor", e13);
                }
                sConstructorFetched = true;
            }
            Constructor<WindowInsets> constructor = sConstructor;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Object[]{new Rect()});
                } catch (ReflectiveOperationException e14) {
                    Log.i(WindowInsetsCompat.TAG, "Could not invoke WindowInsets(Rect) constructor", e14);
                }
            }
            return null;
        }

        @NonNull
        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets);
            windowInsetsCompat.c(this.f11520a);
            windowInsetsCompat.f(this.mStableInsets);
            return windowInsetsCompat;
        }

        public void g(@Nullable Insets insets) {
            this.mStableInsets = insets;
        }

        public void i(@NonNull Insets insets) {
            WindowInsets windowInsets = this.mPlatformInsets;
            if (windowInsets != null) {
                this.mPlatformInsets = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
            }
        }

        public BuilderImpl20(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.mPlatformInsets = windowInsetsCompat.toWindowInsets();
        }
    }

    @RequiresApi(api = 29)
    public static class BuilderImpl29 extends BuilderImpl {

        /* renamed from: b  reason: collision with root package name */
        public final WindowInsets.Builder f11521b;

        public BuilderImpl29() {
            this.f11521b = new WindowInsets.Builder();
        }

        @NonNull
        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.f11521b.build());
            windowInsetsCompat.c(this.f11520a);
            return windowInsetsCompat;
        }

        public void c(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            WindowInsets.Builder unused = this.f11521b.setDisplayCutout(displayCutoutCompat != null ? displayCutoutCompat.a() : null);
        }

        public void f(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.f11521b.setMandatorySystemGestureInsets(insets.toPlatformInsets());
        }

        public void g(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.f11521b.setStableInsets(insets.toPlatformInsets());
        }

        public void h(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.f11521b.setSystemGestureInsets(insets.toPlatformInsets());
        }

        public void i(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.f11521b.setSystemWindowInsets(insets.toPlatformInsets());
        }

        public void j(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.f11521b.setTappableElementInsets(insets.toPlatformInsets());
        }

        public BuilderImpl29(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            WindowInsets.Builder builder;
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                builder = new WindowInsets.Builder(windowInsets);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f11521b = builder;
        }
    }

    @RequiresApi(21)
    public static class Impl21 extends Impl20 {
        private Insets mStableInsets = null;

        public Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @NonNull
        public WindowInsetsCompat b() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f11524c.consumeStableInsets());
        }

        @NonNull
        public WindowInsetsCompat c() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f11524c.consumeSystemWindowInsets());
        }

        @NonNull
        public final Insets h() {
            if (this.mStableInsets == null) {
                this.mStableInsets = Insets.of(this.f11524c.getStableInsetLeft(), this.f11524c.getStableInsetTop(), this.f11524c.getStableInsetRight(), this.f11524c.getStableInsetBottom());
            }
            return this.mStableInsets;
        }

        public boolean m() {
            return this.f11524c.isConsumed();
        }

        public void setStableInsets(@Nullable Insets insets) {
            this.mStableInsets = insets;
        }

        public Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl21 impl21) {
            super(windowInsetsCompat, (Impl20) impl21);
            this.mStableInsets = impl21.mStableInsets;
        }
    }

    @RequiresApi(20)
    @NonNull
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets, @Nullable View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(windowInsets));
        if (view != null && ViewCompat.isAttachedToWindow(view)) {
            windowInsetsCompat.e(ViewCompat.getRootWindowInsets(view));
            windowInsetsCompat.a(view.getRootView());
        }
        return windowInsetsCompat;
    }

    @NonNull
    public WindowInsetsCompat inset(@IntRange(from = 0) int i11, @IntRange(from = 0) int i12, @IntRange(from = 0) int i13, @IntRange(from = 0) int i14) {
        return this.mImpl.l(i11, i12, i13, i14);
    }

    @RequiresApi(29)
    public static class Impl29 extends Impl28 {
        private Insets mMandatorySystemGestureInsets = null;
        private Insets mSystemGestureInsets = null;
        private Insets mTappableElementInsets = null;

        public Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @NonNull
        public Insets g() {
            if (this.mMandatorySystemGestureInsets == null) {
                this.mMandatorySystemGestureInsets = Insets.toCompatInsets(this.f11524c.getMandatorySystemGestureInsets());
            }
            return this.mMandatorySystemGestureInsets;
        }

        @NonNull
        public Insets i() {
            if (this.mSystemGestureInsets == null) {
                this.mSystemGestureInsets = Insets.toCompatInsets(this.f11524c.getSystemGestureInsets());
            }
            return this.mSystemGestureInsets;
        }

        @NonNull
        public Insets k() {
            if (this.mTappableElementInsets == null) {
                this.mTappableElementInsets = Insets.toCompatInsets(this.f11524c.getTappableElementInsets());
            }
            return this.mTappableElementInsets;
        }

        @NonNull
        public WindowInsetsCompat l(int i11, int i12, int i13, int i14) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f11524c.inset(i11, i12, i13, i14));
        }

        public void setStableInsets(@Nullable Insets insets) {
        }

        public Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl29 impl29) {
            super(windowInsetsCompat, (Impl28) impl29);
        }
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect rect) {
        return new Builder(this).setSystemWindowInsets(Insets.of(rect)).build();
    }

    public static final class Builder {
        private final BuilderImpl mImpl;

        public Builder() {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 30) {
                this.mImpl = new BuilderImpl30();
            } else if (i11 >= 29) {
                this.mImpl = new BuilderImpl29();
            } else {
                this.mImpl = new BuilderImpl20();
            }
        }

        @NonNull
        public WindowInsetsCompat build() {
            return this.mImpl.b();
        }

        @NonNull
        public Builder setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.mImpl.c(displayCutoutCompat);
            return this;
        }

        @NonNull
        public Builder setInsets(int i11, @NonNull Insets insets) {
            this.mImpl.d(i11, insets);
            return this;
        }

        @NonNull
        public Builder setInsetsIgnoringVisibility(int i11, @NonNull Insets insets) {
            this.mImpl.e(i11, insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setMandatorySystemGestureInsets(@NonNull Insets insets) {
            this.mImpl.f(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setStableInsets(@NonNull Insets insets) {
            this.mImpl.g(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemGestureInsets(@NonNull Insets insets) {
            this.mImpl.h(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemWindowInsets(@NonNull Insets insets) {
            this.mImpl.i(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setTappableElementInsets(@NonNull Insets insets) {
            this.mImpl.j(insets);
            return this;
        }

        @NonNull
        public Builder setVisible(int i11, boolean z11) {
            this.mImpl.k(i11, z11);
            return this;
        }

        public Builder(@NonNull WindowInsetsCompat windowInsetsCompat) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 30) {
                this.mImpl = new BuilderImpl30(windowInsetsCompat);
            } else if (i11 >= 29) {
                this.mImpl = new BuilderImpl29(windowInsetsCompat);
            } else {
                this.mImpl = new BuilderImpl20(windowInsetsCompat);
            }
        }
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            Impl impl = windowInsetsCompat.mImpl;
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 30 && (impl instanceof Impl30)) {
                this.mImpl = new Impl30(this, (Impl30) impl);
            } else if (i11 >= 29 && (impl instanceof Impl29)) {
                this.mImpl = new Impl29(this, (Impl29) impl);
            } else if (i11 >= 28 && (impl instanceof Impl28)) {
                this.mImpl = new Impl28(this, (Impl28) impl);
            } else if (impl instanceof Impl21) {
                this.mImpl = new Impl21(this, (Impl21) impl);
            } else if (impl instanceof Impl20) {
                this.mImpl = new Impl20(this, (Impl20) impl);
            } else {
                this.mImpl = new Impl(this);
            }
            impl.e(this);
            return;
        }
        this.mImpl = new Impl(this);
    }
}
