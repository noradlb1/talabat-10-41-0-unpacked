package com.google.android.exoplayer2.source.hls;

import androidx.annotation.Nullable;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.io.IOException;

public final class SampleQueueMappingException extends IOException {
    public SampleQueueMappingException(@Nullable String str) {
        super("Unable to bind a sample queue to TrackGroup with mime type " + str + RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
    }
}
