package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import w7.a;

public final class IcyHeaders implements Metadata.Entry {
    public static final Parcelable.Creator<IcyHeaders> CREATOR = new Parcelable.Creator<IcyHeaders>() {
        public IcyHeaders createFromParcel(Parcel parcel) {
            return new IcyHeaders(parcel);
        }

        public IcyHeaders[] newArray(int i11) {
            return new IcyHeaders[i11];
        }
    };
    public static final String REQUEST_HEADER_ENABLE_METADATA_NAME = "Icy-MetaData";
    public static final String REQUEST_HEADER_ENABLE_METADATA_VALUE = "1";
    private static final String RESPONSE_HEADER_BITRATE = "icy-br";
    private static final String RESPONSE_HEADER_GENRE = "icy-genre";
    private static final String RESPONSE_HEADER_METADATA_INTERVAL = "icy-metaint";
    private static final String RESPONSE_HEADER_NAME = "icy-name";
    private static final String RESPONSE_HEADER_PUB = "icy-pub";
    private static final String RESPONSE_HEADER_URL = "icy-url";
    private static final String TAG = "IcyHeaders";
    public final int bitrate;
    @Nullable
    public final String genre;
    public final boolean isPublic;
    public final int metadataInterval;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    public final String f34963name;
    @Nullable
    public final String url;

    public IcyHeaders(int i11, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z11, int i12) {
        Assertions.checkArgument(i12 == -1 || i12 > 0);
        this.bitrate = i11;
        this.genre = str;
        this.f34963name = str2;
        this.url = str3;
        this.isPublic = z11;
        this.metadataInterval = i12;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.metadata.icy.IcyHeaders parse(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r13) {
        /*
            java.lang.String r0 = "Invalid metadata interval: "
            java.lang.String r1 = "icy-br"
            java.lang.Object r1 = r13.get(r1)
            java.util.List r1 = (java.util.List) r1
            java.lang.String r2 = "IcyHeaders"
            r3 = 1
            r4 = 0
            r5 = -1
            if (r1 == 0) goto L_0x0050
            java.lang.Object r1 = r1.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            int r6 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0038 }
            int r6 = r6 * 1000
            if (r6 <= 0) goto L_0x0021
            r1 = r3
            goto L_0x004e
        L_0x0021:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0039 }
            r7.<init>()     // Catch:{ NumberFormatException -> 0x0039 }
            java.lang.String r8 = "Invalid bitrate: "
            r7.append(r8)     // Catch:{ NumberFormatException -> 0x0039 }
            r7.append(r1)     // Catch:{ NumberFormatException -> 0x0039 }
            java.lang.String r7 = r7.toString()     // Catch:{ NumberFormatException -> 0x0039 }
            com.google.android.exoplayer2.util.Log.w(r2, r7)     // Catch:{ NumberFormatException -> 0x0039 }
            r1 = r4
            r6 = r5
            goto L_0x004e
        L_0x0038:
            r6 = r5
        L_0x0039:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Invalid bitrate header: "
            r7.append(r8)
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            com.google.android.exoplayer2.util.Log.w(r2, r1)
            r1 = r4
        L_0x004e:
            r7 = r6
            goto L_0x0052
        L_0x0050:
            r1 = r4
            r7 = r5
        L_0x0052:
            java.lang.String r6 = "icy-genre"
            java.lang.Object r6 = r13.get(r6)
            java.util.List r6 = (java.util.List) r6
            r8 = 0
            if (r6 == 0) goto L_0x0066
            java.lang.Object r1 = r6.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            r9 = r1
            r1 = r3
            goto L_0x0067
        L_0x0066:
            r9 = r8
        L_0x0067:
            java.lang.String r6 = "icy-name"
            java.lang.Object r6 = r13.get(r6)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x007a
            java.lang.Object r1 = r6.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            r10 = r1
            r1 = r3
            goto L_0x007b
        L_0x007a:
            r10 = r8
        L_0x007b:
            java.lang.String r6 = "icy-url"
            java.lang.Object r6 = r13.get(r6)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x008e
            java.lang.Object r1 = r6.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            r11 = r1
            r1 = r3
            goto L_0x008f
        L_0x008e:
            r11 = r8
        L_0x008f:
            java.lang.String r6 = "icy-pub"
            java.lang.Object r6 = r13.get(r6)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x00a8
            java.lang.Object r1 = r6.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r6 = "1"
            boolean r1 = r1.equals(r6)
            r12 = r1
            r1 = r3
            goto L_0x00a9
        L_0x00a8:
            r12 = r4
        L_0x00a9:
            java.lang.String r6 = "icy-metaint"
            java.lang.Object r13 = r13.get(r6)
            java.util.List r13 = (java.util.List) r13
            if (r13 == 0) goto L_0x00e9
            java.lang.Object r13 = r13.get(r4)
            java.lang.String r13 = (java.lang.String) r13
            int r4 = java.lang.Integer.parseInt(r13)     // Catch:{ NumberFormatException -> 0x00d7 }
            if (r4 <= 0) goto L_0x00c1
            r5 = r4
            goto L_0x00d4
        L_0x00c1:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00d6 }
            r3.<init>()     // Catch:{ NumberFormatException -> 0x00d6 }
            r3.append(r0)     // Catch:{ NumberFormatException -> 0x00d6 }
            r3.append(r13)     // Catch:{ NumberFormatException -> 0x00d6 }
            java.lang.String r3 = r3.toString()     // Catch:{ NumberFormatException -> 0x00d6 }
            com.google.android.exoplayer2.util.Log.w(r2, r3)     // Catch:{ NumberFormatException -> 0x00d6 }
            r3 = r1
        L_0x00d4:
            r1 = r3
            goto L_0x00e9
        L_0x00d6:
            r5 = r4
        L_0x00d7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r13)
            java.lang.String r13 = r3.toString()
            com.google.android.exoplayer2.util.Log.w(r2, r13)
        L_0x00e9:
            if (r1 == 0) goto L_0x00f7
            com.google.android.exoplayer2.metadata.icy.IcyHeaders r13 = new com.google.android.exoplayer2.metadata.icy.IcyHeaders
            r6 = r13
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r5
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r8 = r13
        L_0x00f7:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.icy.IcyHeaders.parse(java.util.Map):com.google.android.exoplayer2.metadata.icy.IcyHeaders");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyHeaders.class != obj.getClass()) {
            return false;
        }
        IcyHeaders icyHeaders = (IcyHeaders) obj;
        if (this.bitrate != icyHeaders.bitrate || !Util.areEqual(this.genre, icyHeaders.genre) || !Util.areEqual(this.f34963name, icyHeaders.f34963name) || !Util.areEqual(this.url, icyHeaders.url) || this.isPublic != icyHeaders.isPublic || this.metadataInterval != icyHeaders.metadataInterval) {
            return false;
        }
        return true;
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return a.a(this);
    }

    public /* synthetic */ Format getWrappedMetadataFormat() {
        return a.b(this);
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13 = (527 + this.bitrate) * 31;
        String str = this.genre;
        int i14 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i15 = (i13 + i11) * 31;
        String str2 = this.f34963name;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i16 = (i15 + i12) * 31;
        String str3 = this.url;
        if (str3 != null) {
            i14 = str3.hashCode();
        }
        return ((((i16 + i14) * 31) + (this.isPublic ? 1 : 0)) * 31) + this.metadataInterval;
    }

    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.f34963name;
        if (str != null) {
            builder.setStation(str);
        }
        String str2 = this.genre;
        if (str2 != null) {
            builder.setGenre(str2);
        }
    }

    public String toString() {
        return "IcyHeaders: name=\"" + this.f34963name + "\", genre=\"" + this.genre + "\", bitrate=" + this.bitrate + ", metadataInterval=" + this.metadataInterval;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.bitrate);
        parcel.writeString(this.genre);
        parcel.writeString(this.f34963name);
        parcel.writeString(this.url);
        Util.writeBoolean(parcel, this.isPublic);
        parcel.writeInt(this.metadataInterval);
    }

    public IcyHeaders(Parcel parcel) {
        this.bitrate = parcel.readInt();
        this.genre = parcel.readString();
        this.f34963name = parcel.readString();
        this.url = parcel.readString();
        this.isPublic = Util.readBoolean(parcel);
        this.metadataInterval = parcel.readInt();
    }
}
