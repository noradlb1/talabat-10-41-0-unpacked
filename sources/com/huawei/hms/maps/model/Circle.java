package com.huawei.hms.maps.model;

import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.maps.internal.IAnimationListener;
import com.huawei.hms.maps.model.animation.Animation;
import com.huawei.hms.maps.model.animation.AnimationSet;
import com.huawei.hms.maps.model.internal.ICircleDelegate;
import com.huawei.hms.maps.utils.LogM;
import java.util.List;

public final class Circle {

    /* renamed from: a  reason: collision with root package name */
    private ICircleDelegate f49451a;

    public Circle(ICircleDelegate iCircleDelegate) {
        this.f49451a = iCircleDelegate;
    }

    private void a(Animation animation) {
        try {
            if (animation instanceof AnimationSet) {
                for (Animation a11 : ((AnimationSet) animation).getAnimations()) {
                    a(a11);
                }
            }
            final Animation.AnimationListener listener = animation.getListener();
            this.f49451a.setAnimationListener(listener == null ? null : new IAnimationListener.Stub() {
                public void onAnimationEnd() {
                    Animation.AnimationListener animationListener = listener;
                    if (animationListener != null) {
                        animationListener.onAnimationEnd();
                    }
                }

                public void onAnimationStart() {
                    Animation.AnimationListener animationListener = listener;
                    if (animationListener != null) {
                        animationListener.onAnimationStart();
                    }
                }
            });
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean clearAnimation() {
        try {
            return this.f49451a.clearAnimation();
        } catch (Exception unused) {
            LogM.e("Circle", "clearAnimation Exception:");
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Circle)) {
            return false;
        }
        try {
            return this.f49451a.equalsRemote(((Circle) obj).f49451a);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public LatLng getCenter() {
        try {
            return this.f49451a.getCenter();
        } catch (RemoteException e11) {
            LogM.d("Circle", "getCenter RemoteException: " + e11.toString());
            return null;
        }
    }

    public int getFillColor() {
        try {
            return this.f49451a.getFillColor();
        } catch (RemoteException e11) {
            LogM.d("Circle", "getFillColor RemoteException: " + e11.toString());
            return 0;
        }
    }

    public String getId() {
        try {
            return this.f49451a.getId();
        } catch (RemoteException e11) {
            LogM.d("Circle", "getId RemoteException: " + e11.toString());
            return null;
        }
    }

    public double getRadius() {
        try {
            return this.f49451a.getRadius();
        } catch (RemoteException e11) {
            LogM.d("Circle", "getRadius RemoteException: " + e11.toString());
            return 0.0d;
        }
    }

    public int getStrokeColor() {
        try {
            return this.f49451a.getStrokeColor();
        } catch (RemoteException e11) {
            LogM.d("Circle", "getStrokeColor RemoteException: " + e11.toString());
            return 0;
        }
    }

    public List<PatternItem> getStrokePattern() {
        try {
            return this.f49451a.getStrokePattern();
        } catch (RemoteException e11) {
            LogM.e("Circle", "getStrokePattern RemoteException: " + e11.toString());
            return null;
        }
    }

    public float getStrokeWidth() {
        try {
            return this.f49451a.getStrokeWidth();
        } catch (RemoteException e11) {
            LogM.d("Circle", "getStrokeWidth RemoteException: " + e11.toString());
            return 0.0f;
        }
    }

    public Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.f49451a.getTag());
        } catch (RemoteException e11) {
            LogM.d("Circle", "RemoteException: " + e11.toString());
            return null;
        }
    }

    public float getZIndex() {
        try {
            return this.f49451a.getZIndex();
        } catch (RemoteException e11) {
            LogM.e("Circle", "getZIndex RemoteException: " + e11.toString());
            return -1.0f;
        }
    }

    public int hashCode() {
        try {
            return this.f49451a.hashCodeRemote();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isClickable() {
        try {
            return this.f49451a.isClickable();
        } catch (RemoteException e11) {
            LogM.d("Circle", "RemoteException: " + e11.toString());
            return true;
        }
    }

    public boolean isVisible() {
        try {
            return this.f49451a.isVisible();
        } catch (RemoteException e11) {
            LogM.e("Circle", "isVisible RemoteException: " + e11.toString());
            return true;
        }
    }

    public void remove() {
        try {
            this.f49451a.remove();
        } catch (RemoteException e11) {
            LogM.d("Circle", "remove RemoteException: " + e11.toString());
        }
    }

    public void setAnimation(Animation animation) {
        if (animation != null) {
            try {
                a(animation);
                this.f49451a.setAnimation(animation);
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        } else {
            throw new IllegalArgumentException("animation cannot be null.");
        }
    }

    public void setCenter(LatLng latLng) {
        if (latLng != null) {
            try {
                this.f49451a.setCenter(latLng);
            } catch (RemoteException e11) {
                LogM.d("Circle", "setCenter RemoteException: " + e11.toString());
            }
        } else {
            throw new NullPointerException("Circle center cannot be null");
        }
    }

    public void setClickable(boolean z11) {
        try {
            this.f49451a.setClickable(z11);
        } catch (RemoteException e11) {
            LogM.d("Circle", "setClickable RemoteException: " + e11.toString());
        }
    }

    public void setFillColor(int i11) {
        try {
            this.f49451a.setFillColor(i11);
        } catch (RemoteException e11) {
            LogM.d("Circle", "setFillColor RemoteException: " + e11.toString());
        }
    }

    public void setRadius(double d11) {
        try {
            this.f49451a.setRadius(d11);
        } catch (RemoteException e11) {
            LogM.d("Circle", "setRadius RemoteException: " + e11.toString());
        }
    }

    public void setStrokeColor(int i11) {
        try {
            this.f49451a.setStrokeColor(i11);
        } catch (RemoteException e11) {
            LogM.d("Circle", "setStrokeColor RemoteException: " + e11.toString());
        }
    }

    public void setStrokePattern(List<PatternItem> list) {
        try {
            this.f49451a.setStrokePattern(list);
        } catch (RemoteException e11) {
            LogM.e("Circle", "setStrokePattern RemoteException: " + e11.toString());
        }
    }

    public void setStrokeWidth(float f11) {
        if (f11 >= 0.0f) {
            try {
                this.f49451a.setStrokeWidth(f11);
            } catch (RemoteException e11) {
                LogM.d("Circle", "setStrokeWidth RemoteException: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("Circle strokeWidth value is illegal ,this value must be non-negative");
        }
    }

    public <T> void setTag(T t11) {
        try {
            this.f49451a.setTag(ObjectWrapper.wrap(t11));
        } catch (RemoteException e11) {
            LogM.d("Circle", "RemoteException: " + e11.toString());
        }
    }

    public void setVisible(boolean z11) {
        try {
            this.f49451a.setVisible(z11);
        } catch (RemoteException e11) {
            LogM.e("Circle", "setVisible RemoteException: " + e11.toString());
        }
    }

    public void setZIndex(float f11) {
        try {
            this.f49451a.setZIndex(f11);
        } catch (RemoteException e11) {
            LogM.e("Circle", "setZIndex RemoteException: " + e11.toString());
        }
    }

    public void startAnimation() {
        try {
            this.f49451a.startAnimation();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }
}
