package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.extractor.VorbisUtil;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class OpusReader extends StreamReader {
    private static final byte[] OPUS_COMMENT_HEADER_SIGNATURE = {79, 112, 117, 115, 84, 97, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 115};
    private static final byte[] OPUS_ID_HEADER_SIGNATURE = {79, 112, 117, 115, 72, 101, 97, 100};
    private boolean firstCommentHeaderSeen;

    private static boolean peekPacketStartsWith(ParsableByteArray parsableByteArray, byte[] bArr) {
        if (parsableByteArray.bytesLeft() < bArr.length) {
            return false;
        }
        int position = parsableByteArray.getPosition();
        byte[] bArr2 = new byte[bArr.length];
        parsableByteArray.readBytes(bArr2, 0, bArr.length);
        parsableByteArray.setPosition(position);
        return Arrays.equals(bArr2, bArr);
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        return peekPacketStartsWith(parsableByteArray, OPUS_ID_HEADER_SIGNATURE);
    }

    public long preparePayload(ParsableByteArray parsableByteArray) {
        return convertTimeToGranule(OpusUtil.getPacketDurationUs(parsableByteArray.getData()));
    }

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean readHeaders(ParsableByteArray parsableByteArray, long j11, StreamReader.SetupData setupData) throws ParserException {
        if (peekPacketStartsWith(parsableByteArray, OPUS_ID_HEADER_SIGNATURE)) {
            byte[] copyOf = Arrays.copyOf(parsableByteArray.getData(), parsableByteArray.limit());
            int channelCount = OpusUtil.getChannelCount(copyOf);
            List<byte[]> buildInitializationData = OpusUtil.buildInitializationData(copyOf);
            if (setupData.format != null) {
                return true;
            }
            setupData.format = new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_OPUS).setChannelCount(channelCount).setSampleRate(OpusUtil.SAMPLE_RATE).setInitializationData(buildInitializationData).build();
            return true;
        }
        byte[] bArr = OPUS_COMMENT_HEADER_SIGNATURE;
        if (peekPacketStartsWith(parsableByteArray, bArr)) {
            Assertions.checkStateNotNull(setupData.format);
            if (this.firstCommentHeaderSeen) {
                return true;
            }
            this.firstCommentHeaderSeen = true;
            parsableByteArray.skipBytes(bArr.length);
            Metadata parseVorbisComments = VorbisUtil.parseVorbisComments(ImmutableList.copyOf((E[]) VorbisUtil.readVorbisCommentHeader(parsableByteArray, false, false).comments));
            if (parseVorbisComments == null) {
                return true;
            }
            setupData.format = setupData.format.buildUpon().setMetadata(parseVorbisComments.copyWithAppendedEntriesFrom(setupData.format.metadata)).build();
            return true;
        }
        Assertions.checkStateNotNull(setupData.format);
        return false;
    }

    public void reset(boolean z11) {
        super.reset(z11);
        if (z11) {
            this.firstCommentHeaderSeen = false;
        }
    }
}
