package com.google.android.exoplayer2.source;

import a8.x;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

public final class TrackGroupArray implements Bundleable {
    public static final Bundleable.Creator<TrackGroupArray> CREATOR = new x();
    public static final TrackGroupArray EMPTY = new TrackGroupArray(new TrackGroup[0]);
    private static final String FIELD_TRACK_GROUPS = Util.intToStringMaxRadix(0);
    private static final String TAG = "TrackGroupArray";
    private int hashCode;
    public final int length;
    private final ImmutableList<TrackGroup> trackGroups;

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.trackGroups = ImmutableList.copyOf((E[]) trackGroupArr);
        this.length = trackGroupArr.length;
        verifyCorrectness();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TrackGroupArray lambda$static$0(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(FIELD_TRACK_GROUPS);
        if (parcelableArrayList == null) {
            return new TrackGroupArray(new TrackGroup[0]);
        }
        return new TrackGroupArray((TrackGroup[]) BundleableUtil.fromBundleList(TrackGroup.CREATOR, parcelableArrayList).toArray(new TrackGroup[0]));
    }

    private void verifyCorrectness() {
        int i11 = 0;
        while (i11 < this.trackGroups.size()) {
            int i12 = i11 + 1;
            for (int i13 = i12; i13 < this.trackGroups.size(); i13++) {
                if (this.trackGroups.get(i11).equals(this.trackGroups.get(i13))) {
                    Log.e(TAG, "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i11 = i12;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroupArray.class != obj.getClass()) {
            return false;
        }
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        if (this.length != trackGroupArray.length || !this.trackGroups.equals(trackGroupArray.trackGroups)) {
            return false;
        }
        return true;
    }

    public TrackGroup get(int i11) {
        return this.trackGroups.get(i11);
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = this.trackGroups.hashCode();
        }
        return this.hashCode;
    }

    public int indexOf(TrackGroup trackGroup) {
        int indexOf = this.trackGroups.indexOf(trackGroup);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(FIELD_TRACK_GROUPS, BundleableUtil.toBundleArrayList(this.trackGroups));
        return bundle;
    }
}
