package com.google.firebase.perf.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface GaugeMetricOrBuilder extends MessageLiteOrBuilder {
    AndroidMemoryReading getAndroidMemoryReadings(int i11);

    int getAndroidMemoryReadingsCount();

    List<AndroidMemoryReading> getAndroidMemoryReadingsList();

    CpuMetricReading getCpuMetricReadings(int i11);

    int getCpuMetricReadingsCount();

    List<CpuMetricReading> getCpuMetricReadingsList();

    GaugeMetadata getGaugeMetadata();

    String getSessionId();

    ByteString getSessionIdBytes();

    boolean hasGaugeMetadata();

    boolean hasSessionId();
}
