package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import java.util.List;

public abstract class Representation {
    public static final long REVISION_ID_DEFAULT = -1;
    public final ImmutableList<BaseUrl> baseUrls;
    public final List<Descriptor> essentialProperties;
    public final Format format;
    public final List<Descriptor> inbandEventStreams;
    private final RangedUri initializationUri;
    public final long presentationTimeOffsetUs;
    public final long revisionId;
    public final List<Descriptor> supplementalProperties;

    public static class MultiSegmentRepresentation extends Representation implements DashSegmentIndex {
        @VisibleForTesting
        final SegmentBase.MultiSegmentBase segmentBase;

        public MultiSegmentRepresentation(long j11, Format format, List<BaseUrl> list, SegmentBase.MultiSegmentBase multiSegmentBase, @Nullable List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
            super(j11, format, list, multiSegmentBase, list2, list3, list4);
            this.segmentBase = multiSegmentBase;
        }

        public long getAvailableSegmentCount(long j11, long j12) {
            return this.segmentBase.getAvailableSegmentCount(j11, j12);
        }

        @Nullable
        public String getCacheKey() {
            return null;
        }

        public long getDurationUs(long j11, long j12) {
            return this.segmentBase.getSegmentDurationUs(j11, j12);
        }

        public long getFirstAvailableSegmentNum(long j11, long j12) {
            return this.segmentBase.getFirstAvailableSegmentNum(j11, j12);
        }

        public long getFirstSegmentNum() {
            return this.segmentBase.getFirstSegmentNum();
        }

        public DashSegmentIndex getIndex() {
            return this;
        }

        @Nullable
        public RangedUri getIndexUri() {
            return null;
        }

        public long getNextSegmentAvailableTimeUs(long j11, long j12) {
            return this.segmentBase.getNextSegmentAvailableTimeUs(j11, j12);
        }

        public long getSegmentCount(long j11) {
            return this.segmentBase.getSegmentCount(j11);
        }

        public long getSegmentNum(long j11, long j12) {
            return this.segmentBase.getSegmentNum(j11, j12);
        }

        public RangedUri getSegmentUrl(long j11) {
            return this.segmentBase.getSegmentUrl(this, j11);
        }

        public long getTimeUs(long j11) {
            return this.segmentBase.getSegmentTimeUs(j11);
        }

        public boolean isExplicit() {
            return this.segmentBase.isExplicit();
        }
    }

    public static class SingleSegmentRepresentation extends Representation {
        @Nullable
        private final String cacheKey;
        public final long contentLength;
        @Nullable
        private final RangedUri indexUri;
        @Nullable
        private final SingleSegmentIndex segmentIndex;
        public final Uri uri;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SingleSegmentRepresentation(long j11, Format format, List<BaseUrl> list, SegmentBase.SingleSegmentBase singleSegmentBase, @Nullable List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4, @Nullable String str, long j12) {
            super(j11, format, list, singleSegmentBase, list2, list3, list4);
            SingleSegmentIndex singleSegmentIndex;
            List<BaseUrl> list5 = list;
            this.uri = Uri.parse(list.get(0).url);
            RangedUri index = singleSegmentBase.getIndex();
            this.indexUri = index;
            this.cacheKey = str;
            this.contentLength = j12;
            if (index != null) {
                singleSegmentIndex = null;
            } else {
                singleSegmentIndex = new SingleSegmentIndex(new RangedUri((String) null, 0, j12));
            }
            this.segmentIndex = singleSegmentIndex;
        }

        public static SingleSegmentRepresentation newInstance(long j11, Format format, String str, long j12, long j13, long j14, long j15, List<Descriptor> list, @Nullable String str2, long j16) {
            return new SingleSegmentRepresentation(j11, format, ImmutableList.of(new BaseUrl(str)), new SegmentBase.SingleSegmentBase(new RangedUri((String) null, j12, (j13 - j12) + 1), 1, 0, j14, (j15 - j14) + 1), list, ImmutableList.of(), ImmutableList.of(), str2, j16);
        }

        @Nullable
        public String getCacheKey() {
            return this.cacheKey;
        }

        @Nullable
        public DashSegmentIndex getIndex() {
            return this.segmentIndex;
        }

        @Nullable
        public RangedUri getIndexUri() {
            return this.indexUri;
        }
    }

    public static Representation newInstance(long j11, Format format2, List<BaseUrl> list, SegmentBase segmentBase) {
        return newInstance(j11, format2, list, segmentBase, (List<Descriptor>) null, ImmutableList.of(), ImmutableList.of(), (String) null);
    }

    @Nullable
    public abstract String getCacheKey();

    @Nullable
    public abstract DashSegmentIndex getIndex();

    @Nullable
    public abstract RangedUri getIndexUri();

    @Nullable
    public RangedUri getInitializationUri() {
        return this.initializationUri;
    }

    private Representation(long j11, Format format2, List<BaseUrl> list, SegmentBase segmentBase, @Nullable List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
        List<Descriptor> list5;
        Assertions.checkArgument(!list.isEmpty());
        this.revisionId = j11;
        this.format = format2;
        this.baseUrls = ImmutableList.copyOf(list);
        if (list2 == null) {
            list5 = Collections.emptyList();
        } else {
            list5 = Collections.unmodifiableList(list2);
        }
        this.inbandEventStreams = list5;
        this.essentialProperties = list3;
        this.supplementalProperties = list4;
        this.initializationUri = segmentBase.getInitialization(this);
        this.presentationTimeOffsetUs = segmentBase.getPresentationTimeOffsetUs();
    }

    public static Representation newInstance(long j11, Format format2, List<BaseUrl> list, SegmentBase segmentBase, @Nullable List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4, @Nullable String str) {
        SegmentBase segmentBase2 = segmentBase;
        if (segmentBase2 instanceof SegmentBase.SingleSegmentBase) {
            return new SingleSegmentRepresentation(j11, format2, list, (SegmentBase.SingleSegmentBase) segmentBase2, list2, list3, list4, str, -1);
        } else if (segmentBase2 instanceof SegmentBase.MultiSegmentBase) {
            return new MultiSegmentRepresentation(j11, format2, list, (SegmentBase.MultiSegmentBase) segmentBase2, list2, list3, list4);
        } else {
            throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
        }
    }
}
