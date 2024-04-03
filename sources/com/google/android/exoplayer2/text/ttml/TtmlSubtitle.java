package com.google.android.exoplayer2.text.ttml;

import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class TtmlSubtitle implements Subtitle {
    private final long[] eventTimesUs;
    private final Map<String, TtmlStyle> globalStyles;
    private final Map<String, String> imageMap;
    private final Map<String, TtmlRegion> regionMap;
    private final TtmlNode root;

    public TtmlSubtitle(TtmlNode ttmlNode, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, Map<String, String> map3) {
        Map<String, TtmlStyle> map4;
        this.root = ttmlNode;
        this.regionMap = map2;
        this.imageMap = map3;
        if (map != null) {
            map4 = Collections.unmodifiableMap(map);
        } else {
            map4 = Collections.emptyMap();
        }
        this.globalStyles = map4;
        this.eventTimesUs = ttmlNode.getEventTimesUs();
    }

    public List<Cue> getCues(long j11) {
        return this.root.getCues(j11, this.globalStyles, this.regionMap, this.imageMap);
    }

    public long getEventTime(int i11) {
        return this.eventTimesUs[i11];
    }

    public int getEventTimeCount() {
        return this.eventTimesUs.length;
    }

    @VisibleForTesting
    public Map<String, TtmlStyle> getGlobalStyles() {
        return this.globalStyles;
    }

    public int getNextEventTimeIndex(long j11) {
        int binarySearchCeil = Util.binarySearchCeil(this.eventTimesUs, j11, false, false);
        if (binarySearchCeil < this.eventTimesUs.length) {
            return binarySearchCeil;
        }
        return -1;
    }

    @VisibleForTesting
    public TtmlNode getRoot() {
        return this.root;
    }
}
