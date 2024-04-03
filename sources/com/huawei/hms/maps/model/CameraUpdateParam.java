package com.huawei.hms.maps.model;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import com.huawei.hms.maps.utils.LogM;

public class CameraUpdateParam implements Parcelable {
    public static final Parcelable.Creator<CameraUpdateParam> CREATOR = new Parcelable.Creator<CameraUpdateParam>() {
        public CameraUpdateParam createFromParcel(Parcel parcel) {
            return new CameraUpdateParam(parcel);
        }

        public CameraUpdateParam[] newArray(int i11) {
            return new CameraUpdateParam[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private CameraPosition f49425a = null;

    /* renamed from: b  reason: collision with root package name */
    private LatLng f49426b = null;

    /* renamed from: c  reason: collision with root package name */
    private NewLatLngBounds f49427c = null;

    /* renamed from: d  reason: collision with root package name */
    private NewLatLngBoundsWidthHeight f49428d = null;

    /* renamed from: e  reason: collision with root package name */
    private NewLatLngZoom f49429e = null;

    /* renamed from: f  reason: collision with root package name */
    private ScrollBy f49430f = null;

    /* renamed from: g  reason: collision with root package name */
    private ZoomByWithFocus f49431g = null;

    /* renamed from: h  reason: collision with root package name */
    private ZoomBy f49432h = null;

    /* renamed from: i  reason: collision with root package name */
    private ZoomTo f49433i = null;

    public static class NewLatLngBounds implements Parcelable {
        public static final Parcelable.Creator<NewLatLngBounds> CREATOR = new Parcelable.Creator<NewLatLngBounds>() {
            public NewLatLngBounds createFromParcel(Parcel parcel) {
                return new NewLatLngBounds(parcel);
            }

            public NewLatLngBounds[] newArray(int i11) {
                return new NewLatLngBounds[i11];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private LatLngBounds f49434a;

        /* renamed from: b  reason: collision with root package name */
        private int f49435b;

        public NewLatLngBounds() {
            this.f49434a = null;
            this.f49435b = Integer.MAX_VALUE;
        }

        public NewLatLngBounds(Parcel parcel) {
            this.f49434a = null;
            this.f49435b = Integer.MAX_VALUE;
            ParcelReader parcelReader = new ParcelReader(parcel);
            this.f49434a = (LatLngBounds) parcelReader.readParcelable(2, LatLngBounds.CREATOR, null);
            this.f49435b = parcelReader.readInt(3, this.f49435b);
        }

        public NewLatLngBounds(LatLngBounds latLngBounds, int i11) {
            this.f49434a = latLngBounds;
            this.f49435b = i11;
        }

        public int describeContents() {
            return 0;
        }

        public LatLngBounds getBounds() {
            return this.f49434a;
        }

        public int getPadding() {
            return this.f49435b;
        }

        public void setBounds(LatLngBounds latLngBounds) {
            this.f49434a = latLngBounds;
        }

        public void setPadding(int i11) {
            this.f49435b = i11;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            ParcelWrite parcelWrite = new ParcelWrite(parcel);
            int beginObjectHeader = parcelWrite.beginObjectHeader();
            parcelWrite.writeParcelable(2, this.f49434a, i11, false);
            parcelWrite.writeInt(3, this.f49435b);
            parcelWrite.finishObjectHeader(beginObjectHeader);
        }
    }

    public static class NewLatLngBoundsWidthHeight implements Parcelable {
        public static final Parcelable.Creator<NewLatLngBoundsWidthHeight> CREATOR = new Parcelable.Creator<NewLatLngBoundsWidthHeight>() {
            public NewLatLngBoundsWidthHeight createFromParcel(Parcel parcel) {
                return new NewLatLngBoundsWidthHeight(parcel);
            }

            public NewLatLngBoundsWidthHeight[] newArray(int i11) {
                return new NewLatLngBoundsWidthHeight[i11];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private LatLngBounds f49436a;

        /* renamed from: b  reason: collision with root package name */
        private int f49437b;

        /* renamed from: c  reason: collision with root package name */
        private int f49438c;

        /* renamed from: d  reason: collision with root package name */
        private int f49439d;

        public NewLatLngBoundsWidthHeight() {
            this.f49436a = null;
            this.f49437b = Integer.MAX_VALUE;
            this.f49438c = Integer.MAX_VALUE;
            this.f49439d = Integer.MAX_VALUE;
        }

        public NewLatLngBoundsWidthHeight(Parcel parcel) {
            this.f49436a = null;
            this.f49437b = Integer.MAX_VALUE;
            this.f49438c = Integer.MAX_VALUE;
            this.f49439d = Integer.MAX_VALUE;
            ParcelReader parcelReader = new ParcelReader(parcel);
            this.f49436a = (LatLngBounds) parcelReader.readParcelable(2, LatLngBounds.CREATOR, null);
            this.f49437b = parcelReader.readInt(3, this.f49437b);
            this.f49438c = parcelReader.readInt(4, this.f49438c);
            this.f49439d = parcelReader.readInt(5, this.f49439d);
        }

        public NewLatLngBoundsWidthHeight(LatLngBounds latLngBounds, int i11, int i12, int i13) {
            this.f49436a = latLngBounds;
            this.f49438c = i11;
            this.f49439d = i12;
            this.f49437b = i13;
        }

        public int describeContents() {
            return 0;
        }

        public LatLngBounds getBounds() {
            return this.f49436a;
        }

        public int getHeight() {
            return this.f49439d;
        }

        public int getPadding() {
            return this.f49437b;
        }

        public int getWidth() {
            return this.f49438c;
        }

        public void setBounds(LatLngBounds latLngBounds) {
            this.f49436a = latLngBounds;
        }

        public void setHeight(int i11) {
            this.f49439d = i11;
        }

        public void setPadding(int i11) {
            this.f49437b = i11;
        }

        public void setWidth(int i11) {
            this.f49438c = i11;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            ParcelWrite parcelWrite = new ParcelWrite(parcel);
            int beginObjectHeader = parcelWrite.beginObjectHeader();
            parcelWrite.writeParcelable(2, this.f49436a, i11, false);
            parcelWrite.writeInt(3, this.f49437b);
            parcelWrite.writeInt(4, this.f49438c);
            parcelWrite.writeInt(5, this.f49439d);
            parcelWrite.finishObjectHeader(beginObjectHeader);
        }
    }

    public static class NewLatLngZoom implements Parcelable {
        public static final Parcelable.Creator<NewLatLngZoom> CREATOR = new Parcelable.Creator<NewLatLngZoom>() {
            public NewLatLngZoom createFromParcel(Parcel parcel) {
                return new NewLatLngZoom(parcel);
            }

            public NewLatLngZoom[] newArray(int i11) {
                return new NewLatLngZoom[i11];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private LatLng f49440a;

        /* renamed from: b  reason: collision with root package name */
        private float f49441b;

        public NewLatLngZoom() {
            this.f49440a = null;
            this.f49441b = -1.0f;
        }

        public NewLatLngZoom(Parcel parcel) {
            this.f49440a = null;
            this.f49441b = -1.0f;
            ParcelReader parcelReader = new ParcelReader(parcel);
            this.f49440a = (LatLng) parcelReader.readParcelable(2, LatLng.CREATOR, null);
            this.f49441b = parcelReader.readFloat(3, this.f49441b);
        }

        public NewLatLngZoom(LatLng latLng, float f11) {
            this.f49440a = latLng;
            this.f49441b = f11;
        }

        public int describeContents() {
            return 0;
        }

        public LatLng getLatLng() {
            return this.f49440a;
        }

        public float getZoom() {
            return this.f49441b;
        }

        public void setLatLng(LatLng latLng) {
            this.f49440a = latLng;
        }

        public void setZoom(float f11) {
            this.f49441b = f11;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            ParcelWrite parcelWrite = new ParcelWrite(parcel);
            int beginObjectHeader = parcelWrite.beginObjectHeader();
            parcelWrite.writeParcelable(2, this.f49440a, i11, false);
            parcelWrite.writeFloat(3, this.f49441b);
            parcelWrite.finishObjectHeader(beginObjectHeader);
        }
    }

    public static class ScrollBy implements Parcelable {
        public static final Parcelable.Creator<ScrollBy> CREATOR = new Parcelable.Creator<ScrollBy>() {
            public ScrollBy createFromParcel(Parcel parcel) {
                return new ScrollBy(parcel);
            }

            public ScrollBy[] newArray(int i11) {
                return new ScrollBy[i11];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private float f49442a;

        /* renamed from: b  reason: collision with root package name */
        private float f49443b;

        public ScrollBy() {
            this.f49442a = Float.MAX_VALUE;
            this.f49443b = Float.MAX_VALUE;
        }

        public ScrollBy(float f11, float f12) {
            this.f49442a = f11;
            this.f49443b = f12;
        }

        public ScrollBy(Parcel parcel) {
            this.f49442a = Float.MAX_VALUE;
            this.f49443b = Float.MAX_VALUE;
            ParcelReader parcelReader = new ParcelReader(parcel);
            this.f49442a = parcelReader.readFloat(2, this.f49442a);
            this.f49443b = parcelReader.readFloat(3, this.f49443b);
        }

        public int describeContents() {
            return 0;
        }

        public float getxPixel() {
            return this.f49442a;
        }

        public float getyPixel() {
            return this.f49443b;
        }

        public void setxPixel(float f11) {
            this.f49442a = f11;
        }

        public void setyPixel(float f11) {
            this.f49443b = f11;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            ParcelWrite parcelWrite = new ParcelWrite(parcel);
            int beginObjectHeader = parcelWrite.beginObjectHeader();
            parcelWrite.writeFloat(2, this.f49442a);
            parcelWrite.writeFloat(3, this.f49443b);
            parcelWrite.finishObjectHeader(beginObjectHeader);
        }
    }

    public static class ZoomBy implements Parcelable {
        public static final Parcelable.Creator<ZoomBy> CREATOR = new Parcelable.Creator<ZoomBy>() {
            public ZoomBy createFromParcel(Parcel parcel) {
                return new ZoomBy(parcel);
            }

            public ZoomBy[] newArray(int i11) {
                return new ZoomBy[i11];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private float f49444a;

        public ZoomBy(float f11) {
            this.f49444a = f11;
        }

        public ZoomBy(Parcel parcel) {
            this.f49444a = new ParcelReader(parcel).readFloat(2, 0.0f);
            LogM.d("zoomby", "zoomBy: constructor ReadDone " + this.f49444a);
        }

        public int describeContents() {
            return 0;
        }

        public float getAmount() {
            return this.f49444a;
        }

        public void setAmount(float f11) {
            this.f49444a = f11;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            LogM.d("zoomby", "zoomBy: writeToParcel " + this.f49444a);
            ParcelWrite parcelWrite = new ParcelWrite(parcel);
            int beginObjectHeader = parcelWrite.beginObjectHeader();
            parcelWrite.writeFloat(2, this.f49444a);
            parcelWrite.finishObjectHeader(beginObjectHeader);
        }
    }

    public static class ZoomByWithFocus implements Parcelable {
        public static final Parcelable.Creator<ZoomByWithFocus> CREATOR = new Parcelable.Creator<ZoomByWithFocus>() {
            public ZoomByWithFocus createFromParcel(Parcel parcel) {
                return new ZoomByWithFocus(parcel);
            }

            public ZoomByWithFocus[] newArray(int i11) {
                return new ZoomByWithFocus[i11];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private float f49445a;

        /* renamed from: b  reason: collision with root package name */
        private Point f49446b;

        public ZoomByWithFocus() {
        }

        public ZoomByWithFocus(float f11, Point point) {
            this.f49445a = f11;
            this.f49446b = point;
        }

        public ZoomByWithFocus(Parcel parcel) {
            ParcelReader parcelReader = new ParcelReader(parcel);
            this.f49445a = parcelReader.readFloat(2, 1.0f);
            this.f49446b = (Point) parcelReader.readParcelable(3, Point.CREATOR, null);
        }

        public int describeContents() {
            return 0;
        }

        public float getAmount() {
            return this.f49445a;
        }

        public Point getFocus() {
            return this.f49446b;
        }

        public void setAmount(float f11) {
            this.f49445a = f11;
        }

        public void setFocus(Point point) {
            this.f49446b = point;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            ParcelWrite parcelWrite = new ParcelWrite(parcel);
            int beginObjectHeader = parcelWrite.beginObjectHeader();
            parcelWrite.writeFloat(2, this.f49445a);
            parcelWrite.writeParcelable(3, this.f49446b, i11, false);
            parcelWrite.finishObjectHeader(beginObjectHeader);
        }
    }

    public static class ZoomTo implements Parcelable {
        public static final Parcelable.Creator<ZoomTo> CREATOR = new Parcelable.Creator<ZoomTo>() {
            public ZoomTo createFromParcel(Parcel parcel) {
                return new ZoomTo(parcel);
            }

            public ZoomTo[] newArray(int i11) {
                return new ZoomTo[i11];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private float f49447a;

        public ZoomTo(float f11) {
            this.f49447a = f11;
        }

        public ZoomTo(Parcel parcel) {
            this.f49447a = Float.MAX_VALUE;
            this.f49447a = new ParcelReader(parcel).readFloat(2, this.f49447a);
        }

        public int describeContents() {
            return 0;
        }

        public float getZoom() {
            return this.f49447a;
        }

        public void setZoom(float f11) {
            this.f49447a = f11;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            ParcelWrite parcelWrite = new ParcelWrite(parcel);
            int beginObjectHeader = parcelWrite.beginObjectHeader();
            parcelWrite.writeFloat(2, this.f49447a);
            parcelWrite.finishObjectHeader(beginObjectHeader);
        }
    }

    public CameraUpdateParam() {
    }

    public CameraUpdateParam(Parcel parcel) {
        LogM.d("ContentValues", "CameraUpdateParam: zoomBy");
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.f49425a = (CameraPosition) parcelReader.readParcelable(2, CameraPosition.CREATOR, null);
        this.f49426b = (LatLng) parcelReader.readParcelable(3, LatLng.CREATOR, null);
        this.f49427c = (NewLatLngBounds) parcelReader.readParcelable(4, NewLatLngBounds.CREATOR, null);
        this.f49429e = (NewLatLngZoom) parcelReader.readParcelable(5, NewLatLngZoom.CREATOR, null);
        this.f49430f = (ScrollBy) parcelReader.readParcelable(6, ScrollBy.CREATOR, null);
        this.f49431g = (ZoomByWithFocus) parcelReader.readParcelable(7, ZoomByWithFocus.CREATOR, null);
        this.f49432h = (ZoomBy) parcelReader.readParcelable(8, ZoomBy.CREATOR, null);
        this.f49433i = (ZoomTo) parcelReader.readParcelable(9, ZoomTo.CREATOR, null);
        this.f49428d = (NewLatLngBoundsWidthHeight) parcelReader.readParcelable(10, NewLatLngBoundsWidthHeight.CREATOR, null);
    }

    public int describeContents() {
        return 0;
    }

    public CameraPosition getCameraPosition() {
        return this.f49425a;
    }

    public LatLng getLatLng() {
        return this.f49426b;
    }

    public NewLatLngBounds getNewLatLngBounds() {
        return this.f49427c;
    }

    public NewLatLngBoundsWidthHeight getNewLatLngBoundsWidthHeight() {
        return this.f49428d;
    }

    public NewLatLngZoom getNewLatLngZoom() {
        return this.f49429e;
    }

    public ScrollBy getScrollBy() {
        return this.f49430f;
    }

    public ZoomBy getZoomBy() {
        return this.f49432h;
    }

    public ZoomByWithFocus getZoomByWithFocus() {
        return this.f49431g;
    }

    public ZoomTo getZoomTo() {
        return this.f49433i;
    }

    public void setCameraPosition(CameraPosition cameraPosition) {
        this.f49425a = cameraPosition;
    }

    public void setLatLng(LatLng latLng) {
        this.f49426b = latLng;
    }

    public void setNewLatLngBounds(NewLatLngBounds newLatLngBounds) {
        this.f49427c = newLatLngBounds;
    }

    public void setNewLatLngBoundsWidthHeight(NewLatLngBoundsWidthHeight newLatLngBoundsWidthHeight) {
        this.f49428d = newLatLngBoundsWidthHeight;
    }

    public void setNewLatLngZoom(NewLatLngZoom newLatLngZoom) {
        this.f49429e = newLatLngZoom;
    }

    public void setScrollBy(ScrollBy scrollBy) {
        this.f49430f = scrollBy;
    }

    public void setZoomBy(ZoomBy zoomBy) {
        this.f49432h = zoomBy;
    }

    public void setZoomByWithFocus(ZoomByWithFocus zoomByWithFocus) {
        this.f49431g = zoomByWithFocus;
    }

    public void setZoomTo(ZoomTo zoomTo) {
        this.f49433i = zoomTo;
    }

    public String toString() {
        return getClass().getSimpleName() + CertificateUtil.DELIMITER + "{cameraPosition=" + this.f49425a + ",latLng=" + this.f49426b + ",scrollBy=" + this.f49430f + ",zoomByWithFocus=" + this.f49431g + ",newLatLngBounds=" + this.f49427c + ",newLatLngZoom=" + this.f49429e + ",zoomBy=" + this.f49432h + ",zoomTo=" + this.f49433i + "}";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeParcelable(2, getCameraPosition(), i11, false);
        parcelWrite.writeParcelable(3, getLatLng(), i11, false);
        parcelWrite.writeParcelable(4, getNewLatLngBounds(), i11, false);
        parcelWrite.writeParcelable(5, getNewLatLngZoom(), i11, false);
        parcelWrite.writeParcelable(6, getScrollBy(), i11, false);
        parcelWrite.writeParcelable(7, getZoomByWithFocus(), i11, false);
        parcelWrite.writeParcelable(8, getZoomBy(), i11, false);
        parcelWrite.writeParcelable(9, getZoomTo(), i11, false);
        parcelWrite.writeParcelable(10, getNewLatLngBoundsWidthHeight(), i11, false);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }
}
