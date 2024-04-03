package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.view.animation.AnimatorProxy;

public final class ViewHelper {

    public static final class Honeycomb {
        private Honeycomb() {
        }

        public static void A(View view, float f11) {
            view.setX(f11);
        }

        public static void B(View view, float f11) {
            view.setY(f11);
        }

        public static float a(View view) {
            return view.getAlpha();
        }

        public static float b(View view) {
            return view.getPivotX();
        }

        public static float c(View view) {
            return view.getPivotY();
        }

        public static float d(View view) {
            return view.getRotation();
        }

        public static float e(View view) {
            return view.getRotationX();
        }

        public static float f(View view) {
            return view.getRotationY();
        }

        public static float g(View view) {
            return view.getScaleX();
        }

        public static float h(View view) {
            return view.getScaleY();
        }

        public static float i(View view) {
            return (float) view.getScrollX();
        }

        public static float j(View view) {
            return (float) view.getScrollY();
        }

        public static float k(View view) {
            return view.getTranslationX();
        }

        public static float l(View view) {
            return view.getTranslationY();
        }

        public static float m(View view) {
            return view.getX();
        }

        public static float n(View view) {
            return view.getY();
        }

        public static void o(View view, float f11) {
            view.setAlpha(f11);
        }

        public static void p(View view, float f11) {
            view.setPivotX(f11);
        }

        public static void q(View view, float f11) {
            view.setPivotY(f11);
        }

        public static void r(View view, float f11) {
            view.setRotation(f11);
        }

        public static void s(View view, float f11) {
            view.setRotationX(f11);
        }

        public static void t(View view, float f11) {
            view.setRotationY(f11);
        }

        public static void u(View view, float f11) {
            view.setScaleX(f11);
        }

        public static void v(View view, float f11) {
            view.setScaleY(f11);
        }

        public static void w(View view, int i11) {
            view.setScrollX(i11);
        }

        public static void x(View view, int i11) {
            view.setScrollY(i11);
        }

        public static void y(View view, float f11) {
            view.setTranslationX(f11);
        }

        public static void z(View view, float f11) {
            view.setTranslationY(f11);
        }
    }

    private ViewHelper() {
    }

    public static float getAlpha(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getAlpha() : Honeycomb.a(view);
    }

    public static float getPivotX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getPivotX() : Honeycomb.b(view);
    }

    public static float getPivotY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getPivotY() : Honeycomb.c(view);
    }

    public static float getRotation(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getRotation() : Honeycomb.d(view);
    }

    public static float getRotationX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getRotationX() : Honeycomb.e(view);
    }

    public static float getRotationY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getRotationY() : Honeycomb.f(view);
    }

    public static float getScaleX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScaleX() : Honeycomb.g(view);
    }

    public static float getScaleY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScaleY() : Honeycomb.h(view);
    }

    public static float getScrollX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? (float) AnimatorProxy.wrap(view).getScrollX() : Honeycomb.i(view);
    }

    public static float getScrollY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? (float) AnimatorProxy.wrap(view).getScrollY() : Honeycomb.j(view);
    }

    public static float getTranslationX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getTranslationX() : Honeycomb.k(view);
    }

    public static float getTranslationY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getTranslationY() : Honeycomb.l(view);
    }

    public static float getX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getX() : Honeycomb.m(view);
    }

    public static float getY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getY() : Honeycomb.n(view);
    }

    public static void setAlpha(View view, float f11) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setAlpha(f11);
        } else {
            Honeycomb.o(view, f11);
        }
    }

    public static void setPivotX(View view, float f11) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setPivotX(f11);
        } else {
            Honeycomb.p(view, f11);
        }
    }

    public static void setPivotY(View view, float f11) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setPivotY(f11);
        } else {
            Honeycomb.q(view, f11);
        }
    }

    public static void setRotation(View view, float f11) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotation(f11);
        } else {
            Honeycomb.r(view, f11);
        }
    }

    public static void setRotationX(View view, float f11) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotationX(f11);
        } else {
            Honeycomb.s(view, f11);
        }
    }

    public static void setRotationY(View view, float f11) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotationY(f11);
        } else {
            Honeycomb.t(view, f11);
        }
    }

    public static void setScaleX(View view, float f11) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScaleX(f11);
        } else {
            Honeycomb.u(view, f11);
        }
    }

    public static void setScaleY(View view, float f11) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScaleY(f11);
        } else {
            Honeycomb.v(view, f11);
        }
    }

    public static void setScrollX(View view, int i11) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScrollX(i11);
        } else {
            Honeycomb.w(view, i11);
        }
    }

    public static void setScrollY(View view, int i11) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScrollY(i11);
        } else {
            Honeycomb.x(view, i11);
        }
    }

    public static void setTranslationX(View view, float f11) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setTranslationX(f11);
        } else {
            Honeycomb.y(view, f11);
        }
    }

    public static void setTranslationY(View view, float f11) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setTranslationY(f11);
        } else {
            Honeycomb.z(view, f11);
        }
    }

    public static void setX(View view, float f11) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setX(f11);
        } else {
            Honeycomb.A(view, f11);
        }
    }

    public static void setY(View view, float f11) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setY(f11);
        } else {
            Honeycomb.B(view, f11);
        }
    }
}
