package com.huawei.hms.common.webserverpic;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

public class WebServerPic {
    public static final Parcelable.Creator<WebServerPic> CREATOR = new WebServerPicCreator();

    /* renamed from: a  reason: collision with root package name */
    private final Uri f48232a;

    /* renamed from: b  reason: collision with root package name */
    private final int f48233b;

    /* renamed from: c  reason: collision with root package name */
    private final int f48234c;

    public WebServerPic(Uri uri, int i11, int i12) throws IllegalArgumentException {
        this.f48232a = uri;
        this.f48233b = i11;
        this.f48234c = i12;
        if (uri == null) {
            throw new IllegalArgumentException("url is not able to be null");
        } else if (i11 < 0 || i12 < 0) {
            throw new IllegalArgumentException("width and height should be positive or 0");
        }
    }

    public final int getHeight() {
        return this.f48234c;
    }

    public final Uri getUrl() {
        return this.f48232a;
    }

    public final int getWidth() {
        return this.f48233b;
    }

    public final String toString() {
        return String.format(Locale.ENGLISH, "Image %dx%d %s", new Object[]{Integer.valueOf(this.f48233b), Integer.valueOf(this.f48234c), this.f48232a.toString()});
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUrl(), i11, false);
        SafeParcelWriter.writeInt(parcel, 2, getWidth());
        SafeParcelWriter.writeInt(parcel, 3, getHeight());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public WebServerPic(Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }
}
