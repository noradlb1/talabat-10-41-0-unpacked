package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DashManifest implements FilterableManifest<DashManifest> {
    public final long availabilityStartTimeMs;
    public final long durationMs;
    public final boolean dynamic;
    @Nullable
    public final Uri location;
    public final long minBufferTimeMs;
    public final long minUpdatePeriodMs;
    private final List<Period> periods;
    @Nullable
    public final ProgramInformation programInformation;
    public final long publishTimeMs;
    @Nullable
    public final ServiceDescriptionElement serviceDescription;
    public final long suggestedPresentationDelayMs;
    public final long timeShiftBufferDepthMs;
    @Nullable
    public final UtcTimingElement utcTiming;

    public DashManifest(long j11, long j12, long j13, boolean z11, long j14, long j15, long j16, long j17, @Nullable ProgramInformation programInformation2, @Nullable UtcTimingElement utcTimingElement, @Nullable ServiceDescriptionElement serviceDescriptionElement, @Nullable Uri uri, List<Period> list) {
        List<Period> list2;
        this.availabilityStartTimeMs = j11;
        this.durationMs = j12;
        this.minBufferTimeMs = j13;
        this.dynamic = z11;
        this.minUpdatePeriodMs = j14;
        this.timeShiftBufferDepthMs = j15;
        this.suggestedPresentationDelayMs = j16;
        this.publishTimeMs = j17;
        this.programInformation = programInformation2;
        this.utcTiming = utcTimingElement;
        this.location = uri;
        this.serviceDescription = serviceDescriptionElement;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = list;
        }
        this.periods = list2;
    }

    private static ArrayList<AdaptationSet> copyAdaptationSets(List<AdaptationSet> list, LinkedList<StreamKey> linkedList) {
        StreamKey poll = linkedList.poll();
        int i11 = poll.periodIndex;
        ArrayList<AdaptationSet> arrayList = new ArrayList<>();
        do {
            int i12 = poll.groupIndex;
            AdaptationSet adaptationSet = list.get(i12);
            List<Representation> list2 = adaptationSet.representations;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(list2.get(poll.streamIndex));
                poll = linkedList.poll();
                if (!(poll.periodIndex == i11 && poll.groupIndex == i12)) {
                    arrayList.add(new AdaptationSet(adaptationSet.f35022id, adaptationSet.type, arrayList2, adaptationSet.accessibilityDescriptors, adaptationSet.essentialProperties, adaptationSet.supplementalProperties));
                }
                arrayList2.add(list2.get(poll.streamIndex));
                poll = linkedList.poll();
                break;
            } while (poll.groupIndex == i12);
            arrayList.add(new AdaptationSet(adaptationSet.f35022id, adaptationSet.type, arrayList2, adaptationSet.accessibilityDescriptors, adaptationSet.essentialProperties, adaptationSet.supplementalProperties));
        } while (poll.periodIndex == i11);
        linkedList.addFirst(poll);
        return arrayList;
    }

    public final Period getPeriod(int i11) {
        return this.periods.get(i11);
    }

    public final int getPeriodCount() {
        return this.periods.size();
    }

    public final long getPeriodDurationMs(int i11) {
        long j11;
        long j12;
        if (i11 == this.periods.size() - 1) {
            j12 = this.durationMs;
            if (j12 == C.TIME_UNSET) {
                return C.TIME_UNSET;
            }
            j11 = this.periods.get(i11).startMs;
        } else {
            j12 = this.periods.get(i11 + 1).startMs;
            j11 = this.periods.get(i11).startMs;
        }
        return j12 - j11;
    }

    public final long getPeriodDurationUs(int i11) {
        return Util.msToUs(getPeriodDurationMs(i11));
    }

    public final DashManifest copy(List<StreamKey> list) {
        long j11;
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j12 = 0;
        int i11 = 0;
        while (true) {
            int periodCount = getPeriodCount();
            j11 = C.TIME_UNSET;
            if (i11 >= periodCount) {
                break;
            }
            if (((StreamKey) linkedList.peek()).periodIndex != i11) {
                long periodDurationMs = getPeriodDurationMs(i11);
                if (periodDurationMs != C.TIME_UNSET) {
                    j12 += periodDurationMs;
                }
            } else {
                Period period = getPeriod(i11);
                arrayList.add(new Period(period.f35024id, period.startMs - j12, copyAdaptationSets(period.adaptationSets, linkedList), period.eventStreams));
            }
            i11++;
        }
        long j13 = this.durationMs;
        if (j13 != C.TIME_UNSET) {
            j11 = j13 - j12;
        }
        return new DashManifest(this.availabilityStartTimeMs, j11, this.minBufferTimeMs, this.dynamic, this.minUpdatePeriodMs, this.timeShiftBufferDepthMs, this.suggestedPresentationDelayMs, this.publishTimeMs, this.programInformation, this.utcTiming, this.serviceDescription, this.location, arrayList);
    }
}
