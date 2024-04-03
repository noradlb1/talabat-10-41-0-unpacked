package androidx.core.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import com.google.android.exoplayer2.C;
import s1.y3;

public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final Impl mImpl;

    public static class Impl {
        public void a(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        public void b(int i11, long j11, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        public int c() {
            return 0;
        }

        public void d(int i11) {
        }

        public void e(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        public void f(int i11) {
        }

        public void g(int i11) {
        }

        public boolean isAppearanceLightNavigationBars() {
            return false;
        }

        public boolean isAppearanceLightStatusBars() {
            return false;
        }

        public void setAppearanceLightNavigationBars(boolean z11) {
        }

        public void setAppearanceLightStatusBars(boolean z11) {
        }
    }

    @RequiresApi(20)
    public static class Impl20 extends Impl {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final Window f11527a;
        @NonNull
        private final View mView;

        public Impl20(@NonNull Window window, @NonNull View view) {
            this.f11527a = window;
            this.mView = view;
        }

        private void hideForType(int i11) {
            if (i11 == 1) {
                i(4);
            } else if (i11 == 2) {
                i(2);
            } else if (i11 == 8) {
                ((InputMethodManager) this.f11527a.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f11527a.getDecorView().getWindowToken(), 0);
            }
        }

        private void showForType(int i11) {
            if (i11 == 1) {
                k(4);
                l(1024);
            } else if (i11 == 2) {
                k(2);
            } else if (i11 == 8) {
                View view = this.mView;
                if (view.isInEditMode() || view.onCheckIsTextEditor()) {
                    view.requestFocus();
                } else {
                    view = this.f11527a.getCurrentFocus();
                }
                if (view == null) {
                    view = this.f11527a.findViewById(16908290);
                }
                if (view != null && view.hasWindowFocus()) {
                    view.post(new a(view));
                }
            }
        }

        public void a(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        public void b(int i11, long j11, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        public int c() {
            return 0;
        }

        public void d(int i11) {
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i11 & i12) != 0) {
                    hideForType(i12);
                }
            }
        }

        public void e(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        public void f(int i11) {
            if (i11 == 0) {
                k(6144);
            } else if (i11 == 1) {
                k(4096);
                i(2048);
            } else if (i11 == 2) {
                k(2048);
                i(4096);
            }
        }

        public void g(int i11) {
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i11 & i12) != 0) {
                    showForType(i12);
                }
            }
        }

        public void i(int i11) {
            View decorView = this.f11527a.getDecorView();
            decorView.setSystemUiVisibility(i11 | decorView.getSystemUiVisibility());
        }

        public void j(int i11) {
            this.f11527a.addFlags(i11);
        }

        public void k(int i11) {
            View decorView = this.f11527a.getDecorView();
            decorView.setSystemUiVisibility((~i11) & decorView.getSystemUiVisibility());
        }

        public void l(int i11) {
            this.f11527a.clearFlags(i11);
        }
    }

    @RequiresApi(23)
    public static class Impl23 extends Impl20 {
        public Impl23(@NonNull Window window, @Nullable View view) {
            super(window, view);
        }

        public boolean isAppearanceLightStatusBars() {
            return (this.f11527a.getDecorView().getSystemUiVisibility() & 8192) != 0;
        }

        public void setAppearanceLightStatusBars(boolean z11) {
            if (z11) {
                l(67108864);
                j(Integer.MIN_VALUE);
                i(8192);
                return;
            }
            k(8192);
        }
    }

    @RequiresApi(26)
    public static class Impl26 extends Impl23 {
        public Impl26(@NonNull Window window, @Nullable View view) {
            super(window, view);
        }

        public boolean isAppearanceLightNavigationBars() {
            return (this.f11527a.getDecorView().getSystemUiVisibility() & 16) != 0;
        }

        public void setAppearanceLightNavigationBars(boolean z11) {
            if (z11) {
                l(C.BUFFER_FLAG_FIRST_SAMPLE);
                j(Integer.MIN_VALUE);
                i(16);
                return;
            }
            k(16);
        }
    }

    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(@NonNull WindowInsetsControllerCompat windowInsetsControllerCompat, int i11);
    }

    @RequiresApi(30)
    @Deprecated
    private WindowInsetsControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        this.mImpl = new Impl30(windowInsetsController, this);
    }

    @RequiresApi(30)
    @NonNull
    @Deprecated
    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        return new WindowInsetsControllerCompat(windowInsetsController);
    }

    public void addOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.a(onControllableInsetsChangedListener);
    }

    public void controlWindowInsetsAnimation(int i11, long j11, @Nullable Interpolator interpolator, @Nullable CancellationSignal cancellationSignal, @NonNull WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.mImpl.b(i11, j11, interpolator, cancellationSignal, windowInsetsAnimationControlListenerCompat);
    }

    @SuppressLint({"WrongConstant"})
    public int getSystemBarsBehavior() {
        return this.mImpl.c();
    }

    public void hide(int i11) {
        this.mImpl.d(i11);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.e(onControllableInsetsChangedListener);
    }

    public void setAppearanceLightNavigationBars(boolean z11) {
        this.mImpl.setAppearanceLightNavigationBars(z11);
    }

    public void setAppearanceLightStatusBars(boolean z11) {
        this.mImpl.setAppearanceLightStatusBars(z11);
    }

    public void setSystemBarsBehavior(int i11) {
        this.mImpl.f(i11);
    }

    public void show(int i11) {
        this.mImpl.g(i11);
    }

    @RequiresApi(30)
    public static class Impl30 extends Impl {

        /* renamed from: a  reason: collision with root package name */
        public final WindowInsetsControllerCompat f11528a;

        /* renamed from: b  reason: collision with root package name */
        public final WindowInsetsController f11529b;

        /* renamed from: c  reason: collision with root package name */
        public Window f11530c;
        private final SimpleArrayMap<OnControllableInsetsChangedListener, WindowInsetsController.OnControllableInsetsChangedListener> mListeners;

        public Impl30(@NonNull Window window, @NonNull WindowInsetsControllerCompat windowInsetsControllerCompat) {
            this(window.getInsetsController(), windowInsetsControllerCompat);
            this.f11530c = window;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$addOnControllableInsetsChangedListener$0(OnControllableInsetsChangedListener onControllableInsetsChangedListener, WindowInsetsController windowInsetsController, int i11) {
            if (this.f11529b == windowInsetsController) {
                onControllableInsetsChangedListener.onControllableInsetsChanged(this.f11528a, i11);
            }
        }

        public void a(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            if (!this.mListeners.containsKey(onControllableInsetsChangedListener)) {
                b bVar = new b(this, onControllableInsetsChangedListener);
                this.mListeners.put(onControllableInsetsChangedListener, bVar);
                this.f11529b.addOnControllableInsetsChangedListener(bVar);
            }
        }

        public void b(int i11, long j11, @Nullable Interpolator interpolator, @Nullable CancellationSignal cancellationSignal, @NonNull final WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
            this.f11529b.controlWindowInsetsAnimation(i11, j11, interpolator, cancellationSignal, new WindowInsetsAnimationControlListener() {
                private WindowInsetsAnimationControllerCompat mCompatAnimController = null;

                public void onCancelled(@Nullable WindowInsetsAnimationController windowInsetsAnimationController) {
                    windowInsetsAnimationControlListenerCompat.onCancelled(windowInsetsAnimationController == null ? null : this.mCompatAnimController);
                }

                public void onFinished(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
                    windowInsetsAnimationControlListenerCompat.onFinished(this.mCompatAnimController);
                }

                public void onReady(@NonNull WindowInsetsAnimationController windowInsetsAnimationController, int i11) {
                    WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
                    this.mCompatAnimController = windowInsetsAnimationControllerCompat;
                    windowInsetsAnimationControlListenerCompat.onReady(windowInsetsAnimationControllerCompat, i11);
                }
            });
        }

        @SuppressLint({"WrongConstant"})
        public int c() {
            return this.f11529b.getSystemBarsBehavior();
        }

        public void d(int i11) {
            this.f11529b.hide(i11);
        }

        public void e(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            WindowInsetsController.OnControllableInsetsChangedListener remove = this.mListeners.remove(onControllableInsetsChangedListener);
            if (remove != null) {
                this.f11529b.removeOnControllableInsetsChangedListener(remove);
            }
        }

        public void f(int i11) {
            this.f11529b.setSystemBarsBehavior(i11);
        }

        public void g(int i11) {
            Window window = this.f11530c;
            if (!(window == null || (i11 & 8) == 0 || Build.VERSION.SDK_INT >= 32)) {
                ((InputMethodManager) window.getContext().getSystemService("input_method")).isActive();
            }
            this.f11529b.show(i11);
        }

        public void i(int i11) {
            View decorView = this.f11530c.getDecorView();
            decorView.setSystemUiVisibility(i11 | decorView.getSystemUiVisibility());
        }

        public boolean isAppearanceLightNavigationBars() {
            return (y3.a(this.f11529b) & 16) != 0;
        }

        public boolean isAppearanceLightStatusBars() {
            return (y3.a(this.f11529b) & 8) != 0;
        }

        public void j(int i11) {
            View decorView = this.f11530c.getDecorView();
            decorView.setSystemUiVisibility((~i11) & decorView.getSystemUiVisibility());
        }

        public void setAppearanceLightNavigationBars(boolean z11) {
            if (z11) {
                if (this.f11530c != null) {
                    i(16);
                }
                this.f11529b.setSystemBarsAppearance(16, 16);
                return;
            }
            if (this.f11530c != null) {
                j(16);
            }
            this.f11529b.setSystemBarsAppearance(0, 16);
        }

        public void setAppearanceLightStatusBars(boolean z11) {
            if (z11) {
                if (this.f11530c != null) {
                    i(8192);
                }
                this.f11529b.setSystemBarsAppearance(8, 8);
                return;
            }
            if (this.f11530c != null) {
                j(8192);
            }
            this.f11529b.setSystemBarsAppearance(0, 8);
        }

        public Impl30(@NonNull WindowInsetsController windowInsetsController, @NonNull WindowInsetsControllerCompat windowInsetsControllerCompat) {
            this.mListeners = new SimpleArrayMap<>();
            this.f11529b = windowInsetsController;
            this.f11528a = windowInsetsControllerCompat;
        }
    }

    public WindowInsetsControllerCompat(@NonNull Window window, @NonNull View view) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            this.mImpl = new Impl30(window, this);
        } else if (i11 >= 26) {
            this.mImpl = new Impl26(window, view);
        } else {
            this.mImpl = new Impl23(window, view);
        }
    }
}
