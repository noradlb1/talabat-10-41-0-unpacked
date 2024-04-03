package com.google.android.exoplayer2.source;

import a8.w;
import android.os.Bundle;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;

public final class TrackGroup implements Bundleable {
    public static final Bundleable.Creator<TrackGroup> CREATOR = new w();
    private static final String FIELD_FORMATS = Util.intToStringMaxRadix(0);
    private static final String FIELD_ID = Util.intToStringMaxRadix(1);
    private static final String TAG = "TrackGroup";
    private final Format[] formats;
    private int hashCode;

    /* renamed from: id  reason: collision with root package name */
    public final String f35000id;
    public final int length;
    public final int type;

    public TrackGroup(Format... formatArr) {
        this("", formatArr);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TrackGroup lambda$static$0(Bundle bundle) {
        ImmutableList<Format> immutableList;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(FIELD_FORMATS);
        if (parcelableArrayList == null) {
            immutableList = ImmutableList.of();
        } else {
            immutableList = BundleableUtil.fromBundleList(Format.CREATOR, parcelableArrayList);
        }
        return new TrackGroup(bundle.getString(FIELD_ID, ""), (Format[]) immutableList.toArray(new Format[0]));
    }

    private static void logErrorMessage(String str, @Nullable String str2, @Nullable String str3, int i11) {
        Log.e(TAG, "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i11 + ")"));
    }

    private static String normalizeLanguage(@Nullable String str) {
        if (str == null || str.equals(C.LANGUAGE_UNDETERMINED)) {
            return "";
        }
        return str;
    }

    private static int normalizeRoleFlags(int i11) {
        return i11 | 16384;
    }

    private void verifyCorrectness() {
        String normalizeLanguage = normalizeLanguage(this.formats[0].language);
        int normalizeRoleFlags = normalizeRoleFlags(this.formats[0].roleFlags);
        int i11 = 1;
        while (true) {
            Format[] formatArr = this.formats;
            if (i11 >= formatArr.length) {
                return;
            }
            if (!normalizeLanguage.equals(normalizeLanguage(formatArr[i11].language))) {
                Format[] formatArr2 = this.formats;
                logErrorMessage("languages", formatArr2[0].language, formatArr2[i11].language, i11);
                return;
            } else if (normalizeRoleFlags != normalizeRoleFlags(this.formats[i11].roleFlags)) {
                logErrorMessage("role flags", Integer.toBinaryString(this.formats[0].roleFlags), Integer.toBinaryString(this.formats[i11].roleFlags), i11);
                return;
            } else {
                i11++;
            }
        }
    }

    @CheckResult
    public TrackGroup copyWithId(String str) {
        return new TrackGroup(str, this.formats);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroup.class != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        if (!this.f35000id.equals(trackGroup.f35000id) || !Arrays.equals(this.formats, trackGroup.formats)) {
            return false;
        }
        return true;
    }

    public Format getFormat(int i11) {
        return this.formats[i11];
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((527 + this.f35000id.hashCode()) * 31) + Arrays.hashCode(this.formats);
        }
        return this.hashCode;
    }

    public int indexOf(Format format) {
        int i11 = 0;
        while (true) {
            Format[] formatArr = this.formats;
            if (i11 >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i11]) {
                return i11;
            }
            i11++;
        }
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList(this.formats.length);
        for (Format bundle2 : this.formats) {
            arrayList.add(bundle2.toBundle(true));
        }
        bundle.putParcelableArrayList(FIELD_FORMATS, arrayList);
        bundle.putString(FIELD_ID, this.f35000id);
        return bundle;
    }

    public TrackGroup(String str, Format... formatArr) {
        Assertions.checkArgument(formatArr.length > 0);
        this.f35000id = str;
        this.formats = formatArr;
        this.length = formatArr.length;
        int trackType = MimeTypes.getTrackType(formatArr[0].sampleMimeType);
        this.type = trackType == -1 ? MimeTypes.getTrackType(formatArr[0].containerMimeType) : trackType;
        verifyCorrectness();
    }
}
