package com.google.android.exoplayer2.source;

import a8.l;
import android.annotation.SuppressLint;
import android.media.MediaParser;
import android.net.Uri;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.mediaparser.InputReaderAdapterV30;
import com.google.android.exoplayer2.source.mediaparser.MediaParserUtil;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RequiresApi(30)
public final class MediaParserExtractorAdapter implements ProgressiveMediaExtractor {
    public static final ProgressiveMediaExtractor.Factory FACTORY = new l();
    private final InputReaderAdapterV30 inputReaderAdapter = new InputReaderAdapterV30();
    private final MediaParser mediaParser;
    private final OutputConsumerAdapterV30 outputConsumerAdapter;
    private String parserName;

    @SuppressLint({"WrongConstant"})
    public MediaParserExtractorAdapter(PlayerId playerId) {
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = new OutputConsumerAdapterV30();
        this.outputConsumerAdapter = outputConsumerAdapterV30;
        MediaParser a11 = MediaParser.create(outputConsumerAdapterV30, new String[0]);
        this.mediaParser = a11;
        Boolean bool = Boolean.TRUE;
        MediaParser unused = a11.setParameter(MediaParserUtil.PARAMETER_EAGERLY_EXPOSE_TRACK_TYPE, bool);
        MediaParser unused2 = a11.setParameter(MediaParserUtil.PARAMETER_IN_BAND_CRYPTO_INFO, bool);
        MediaParser unused3 = a11.setParameter(MediaParserUtil.PARAMETER_INCLUDE_SUPPLEMENTAL_DATA, bool);
        this.parserName = "android.media.mediaparser.UNKNOWN";
        if (Util.SDK_INT >= 31) {
            MediaParserUtil.setLogSessionIdOnMediaParser(a11, playerId);
        }
    }

    public void disableSeekingOnMp3Streams() {
        if ("android.media.mediaparser.Mp3Parser".equals(this.parserName)) {
            this.outputConsumerAdapter.disableSeeking();
        }
    }

    public long getCurrentInputPosition() {
        return this.inputReaderAdapter.getPosition();
    }

    public void init(DataReader dataReader, Uri uri, Map<String, List<String>> map, long j11, long j12, ExtractorOutput extractorOutput) throws IOException {
        this.outputConsumerAdapter.setExtractorOutput(extractorOutput);
        this.inputReaderAdapter.setDataReader(dataReader, j12);
        this.inputReaderAdapter.setCurrentPosition(j11);
        String a11 = this.mediaParser.getParserName();
        if ("android.media.mediaparser.UNKNOWN".equals(a11)) {
            boolean unused = this.mediaParser.advance(this.inputReaderAdapter);
            String a12 = this.mediaParser.getParserName();
            this.parserName = a12;
            this.outputConsumerAdapter.setSelectedParserName(a12);
        } else if (!a11.equals(this.parserName)) {
            String a13 = this.mediaParser.getParserName();
            this.parserName = a13;
            this.outputConsumerAdapter.setSelectedParserName(a13);
        }
    }

    public int read(PositionHolder positionHolder) throws IOException {
        boolean a11 = this.mediaParser.advance(this.inputReaderAdapter);
        long andResetSeekPosition = this.inputReaderAdapter.getAndResetSeekPosition();
        positionHolder.position = andResetSeekPosition;
        if (!a11) {
            return -1;
        }
        if (andResetSeekPosition != -1) {
            return 1;
        }
        return 0;
    }

    public void release() {
        this.mediaParser.release();
    }

    public void seek(long j11, long j12) {
        Object obj;
        this.inputReaderAdapter.setCurrentPosition(j11);
        Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> seekPoints = this.outputConsumerAdapter.getSeekPoints(j12);
        MediaParser mediaParser2 = this.mediaParser;
        if (((MediaParser.SeekPoint) seekPoints.second).position == j11) {
            obj = seekPoints.second;
        } else {
            obj = seekPoints.first;
        }
        mediaParser2.seek((MediaParser.SeekPoint) obj);
    }
}
