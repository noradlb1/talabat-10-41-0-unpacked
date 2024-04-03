package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.CeaUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;

public final class SeiReader {
    private final List<Format> closedCaptionFormats;
    private final TrackOutput[] outputs;

    public SeiReader(List<Format> list) {
        this.closedCaptionFormats = list;
        this.outputs = new TrackOutput[list.size()];
    }

    public void consume(long j11, ParsableByteArray parsableByteArray) {
        CeaUtil.consume(j11, parsableByteArray, this.outputs);
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        boolean z11;
        for (int i11 = 0; i11 < this.outputs.length; i11++) {
            trackIdGenerator.generateNewId();
            TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 3);
            Format format = this.closedCaptionFormats.get(i11);
            String str = format.sampleMimeType;
            if (MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str)) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkArgument(z11, "Invalid closed caption mime type provided: " + str);
            String str2 = format.f34900id;
            if (str2 == null) {
                str2 = trackIdGenerator.getFormatId();
            }
            track.format(new Format.Builder().setId(str2).setSampleMimeType(str).setSelectionFlags(format.selectionFlags).setLanguage(format.language).setAccessibilityChannel(format.accessibilityChannel).setInitializationData(format.initializationData).build());
            this.outputs[i11] = track;
        }
    }
}
