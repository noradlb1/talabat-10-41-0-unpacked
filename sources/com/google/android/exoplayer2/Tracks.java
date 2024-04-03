package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Booleans;
import g7.r3;
import g7.s3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Tracks implements Bundleable {
    public static final Bundleable.Creator<Tracks> CREATOR = new r3();
    public static final Tracks EMPTY = new Tracks(ImmutableList.of());
    private static final String FIELD_TRACK_GROUPS = Util.intToStringMaxRadix(0);
    private final ImmutableList<Group> groups;

    public static final class Group implements Bundleable {
        public static final Bundleable.Creator<Group> CREATOR = new s3();
        private static final String FIELD_ADAPTIVE_SUPPORTED = Util.intToStringMaxRadix(4);
        private static final String FIELD_TRACK_GROUP = Util.intToStringMaxRadix(0);
        private static final String FIELD_TRACK_SELECTED = Util.intToStringMaxRadix(3);
        private static final String FIELD_TRACK_SUPPORT = Util.intToStringMaxRadix(1);
        private final boolean adaptiveSupported;
        public final int length;
        private final TrackGroup mediaTrackGroup;
        private final boolean[] trackSelected;
        private final int[] trackSupport;

        public Group(TrackGroup trackGroup, boolean z11, int[] iArr, boolean[] zArr) {
            boolean z12;
            int i11 = trackGroup.length;
            this.length = i11;
            boolean z13 = false;
            if (i11 == iArr.length && i11 == zArr.length) {
                z12 = true;
            } else {
                z12 = false;
            }
            Assertions.checkArgument(z12);
            this.mediaTrackGroup = trackGroup;
            if (z11 && i11 > 1) {
                z13 = true;
            }
            this.adaptiveSupported = z13;
            this.trackSupport = (int[]) iArr.clone();
            this.trackSelected = (boolean[]) zArr.clone();
        }

        public Group copyWithId(String str) {
            return new Group(this.mediaTrackGroup.copyWithId(str), this.adaptiveSupported, this.trackSupport, this.trackSelected);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Group.class != obj.getClass()) {
                return false;
            }
            Group group = (Group) obj;
            if (this.adaptiveSupported != group.adaptiveSupported || !this.mediaTrackGroup.equals(group.mediaTrackGroup) || !Arrays.equals(this.trackSupport, group.trackSupport) || !Arrays.equals(this.trackSelected, group.trackSelected)) {
                return false;
            }
            return true;
        }

        public TrackGroup getMediaTrackGroup() {
            return this.mediaTrackGroup;
        }

        public Format getTrackFormat(int i11) {
            return this.mediaTrackGroup.getFormat(i11);
        }

        public int getTrackSupport(int i11) {
            return this.trackSupport[i11];
        }

        public int getType() {
            return this.mediaTrackGroup.type;
        }

        public int hashCode() {
            return (((((this.mediaTrackGroup.hashCode() * 31) + (this.adaptiveSupported ? 1 : 0)) * 31) + Arrays.hashCode(this.trackSupport)) * 31) + Arrays.hashCode(this.trackSelected);
        }

        public boolean isAdaptiveSupported() {
            return this.adaptiveSupported;
        }

        public boolean isSelected() {
            return Booleans.contains(this.trackSelected, true);
        }

        public boolean isSupported() {
            return isSupported(false);
        }

        public boolean isTrackSelected(int i11) {
            return this.trackSelected[i11];
        }

        public boolean isTrackSupported(int i11) {
            return isTrackSupported(i11, false);
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBundle(FIELD_TRACK_GROUP, this.mediaTrackGroup.toBundle());
            bundle.putIntArray(FIELD_TRACK_SUPPORT, this.trackSupport);
            bundle.putBooleanArray(FIELD_TRACK_SELECTED, this.trackSelected);
            bundle.putBoolean(FIELD_ADAPTIVE_SUPPORTED, this.adaptiveSupported);
            return bundle;
        }

        public boolean isSupported(boolean z11) {
            for (int i11 = 0; i11 < this.trackSupport.length; i11++) {
                if (isTrackSupported(i11, z11)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isTrackSupported(int i11, boolean z11) {
            int i12 = this.trackSupport[i11];
            return i12 == 4 || (z11 && i12 == 3);
        }
    }

    public Tracks(List<Group> list) {
        this.groups = ImmutableList.copyOf(list);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Tracks lambda$static$0(Bundle bundle) {
        ImmutableList<Group> immutableList;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(FIELD_TRACK_GROUPS);
        if (parcelableArrayList == null) {
            immutableList = ImmutableList.of();
        } else {
            immutableList = BundleableUtil.fromBundleList(Group.CREATOR, parcelableArrayList);
        }
        return new Tracks(immutableList);
    }

    public boolean containsType(int i11) {
        for (int i12 = 0; i12 < this.groups.size(); i12++) {
            if (this.groups.get(i12).getType() == i11) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Tracks.class != obj.getClass()) {
            return false;
        }
        return this.groups.equals(((Tracks) obj).groups);
    }

    public ImmutableList<Group> getGroups() {
        return this.groups;
    }

    public int hashCode() {
        return this.groups.hashCode();
    }

    public boolean isEmpty() {
        return this.groups.isEmpty();
    }

    public boolean isTypeSelected(int i11) {
        for (int i12 = 0; i12 < this.groups.size(); i12++) {
            Group group = this.groups.get(i12);
            if (group.isSelected() && group.getType() == i11) {
                return true;
            }
        }
        return false;
    }

    public boolean isTypeSupported(int i11) {
        return isTypeSupported(i11, false);
    }

    @Deprecated
    public boolean isTypeSupportedOrEmpty(int i11) {
        return isTypeSupportedOrEmpty(i11, false);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(FIELD_TRACK_GROUPS, BundleableUtil.toBundleArrayList(this.groups));
        return bundle;
    }

    public boolean isTypeSupported(int i11, boolean z11) {
        for (int i12 = 0; i12 < this.groups.size(); i12++) {
            if (this.groups.get(i12).getType() == i11 && this.groups.get(i12).isSupported(z11)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean isTypeSupportedOrEmpty(int i11, boolean z11) {
        return !containsType(i11) || isTypeSupported(i11, z11);
    }
}
