package com.huawei.hms.maps.model;

import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.feature.dynamic.RuntimeRemoteException;
import com.huawei.hms.maps.internal.IAnimationListener;
import com.huawei.hms.maps.model.animation.Animation;
import com.huawei.hms.maps.model.animation.AnimationSet;
import com.huawei.hms.maps.model.internal.IMarkerDelegate;

public class Marker {

    /* renamed from: a  reason: collision with root package name */
    private final IMarkerDelegate f49505a;

    public Marker(IMarkerDelegate iMarkerDelegate) {
        if (iMarkerDelegate != null) {
            this.f49505a = iMarkerDelegate;
            return;
        }
        throw new NullPointerException("Object is null");
    }

    private void a(Animation animation) {
        try {
            if (animation instanceof AnimationSet) {
                for (Animation a11 : ((AnimationSet) animation).getAnimations()) {
                    a(a11);
                }
            }
            final Animation.AnimationListener listener = animation.getListener();
            this.f49505a.setAnimationListener(listener == null ? null : new IAnimationListener.Stub() {
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

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Marker)) {
            return false;
        }
        try {
            return this.f49505a.equalsRemote(((Marker) obj).f49505a);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final float getAlpha() {
        try {
            return this.f49505a.getAlpha();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final String getId() {
        try {
            return this.f49505a.getId();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final LatLng getPosition() {
        try {
            return this.f49505a.getPosition();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final float getRotation() {
        try {
            return this.f49505a.getRotation();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final String getSnippet() {
        try {
            return this.f49505a.getSnippet();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.f49505a.getTag());
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final String getTitle() {
        try {
            return this.f49505a.getTitle();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final float getZIndex() {
        try {
            return this.f49505a.getZIndex();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final int hashCode() {
        try {
            return this.f49505a.hashCodeRemote();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final void hideInfoWindow() {
        try {
            this.f49505a.hideInfoWindow();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isClickable() {
        try {
            return this.f49505a.isClickable();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isClusterable() {
        try {
            return this.f49505a.isClusterable();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final boolean isDraggable() {
        try {
            return this.f49505a.isDraggable();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final boolean isFlat() {
        try {
            return this.f49505a.isFlat();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final boolean isInfoWindowShown() {
        try {
            return this.f49505a.isInfoWindowShown();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final boolean isVisible() {
        try {
            return this.f49505a.isVisible();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final void remove() {
        try {
            this.f49505a.remove();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final void setAlpha(float f11) {
        try {
            this.f49505a.setAlpha(f11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @Deprecated
    public final void setAnchor(float f11, float f12) {
        try {
            this.f49505a.setAnchor(f11, f12);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setAnimation(Animation animation) {
        if (animation != null) {
            try {
                a(animation);
                this.f49505a.setAnimation(animation);
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        } else {
            throw new IllegalArgumentException("animation cannot be null.");
        }
    }

    public void setClickable(boolean z11) {
        try {
            this.f49505a.setClickable(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final void setDraggable(boolean z11) {
        try {
            this.f49505a.setDraggable(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final void setFlat(boolean z11) {
        try {
            this.f49505a.setFlat(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            try {
                this.f49505a.setIcon(ObjectWrapper.wrap(null));
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        } else {
            this.f49505a.setIcon(bitmapDescriptor.getObject());
        }
    }

    public final void setInfoWindowAnchor(float f11, float f12) {
        try {
            this.f49505a.setInfoWindowAnchor(f11, f12);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final void setMarkerAnchor(float f11, float f12) {
        try {
            this.f49505a.setMarkerAnchor(f11, f12);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final void setPosition(LatLng latLng) {
        if (latLng != null) {
            try {
                this.f49505a.setPosition(latLng);
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        } else {
            throw new IllegalArgumentException("latlng cannot be null - a position is required.");
        }
    }

    public final void setRotation(float f11) {
        try {
            this.f49505a.setRotation(f11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final void setSnippet(String str) {
        try {
            this.f49505a.setSnippet(str);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final void setTag(Object obj) {
        try {
            this.f49505a.setTag(ObjectWrapper.wrap(obj));
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final void setTitle(String str) {
        try {
            this.f49505a.setTitle(str);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final void setVisible(boolean z11) {
        try {
            this.f49505a.setVisible(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final void setZIndex(float f11) {
        try {
            this.f49505a.setZIndex(f11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final void showInfoWindow() {
        try {
            this.f49505a.showInfoWindow();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void startAnimation() {
        try {
            this.f49505a.startAnimation();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }
}
