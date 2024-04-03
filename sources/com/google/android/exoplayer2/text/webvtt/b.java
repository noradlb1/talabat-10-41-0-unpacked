package com.google.android.exoplayer2.text.webvtt;

import java.util.Comparator;

public final /* synthetic */ class b implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return Long.compare(((WebvttCueInfo) obj).startTimeUs, ((WebvttCueInfo) obj2).startTimeUs);
    }
}
