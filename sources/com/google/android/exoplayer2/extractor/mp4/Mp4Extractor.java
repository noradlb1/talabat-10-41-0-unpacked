package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrueHdSampleRechunker;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import r7.c;
import r7.d;

public final class Mp4Extractor implements Extractor, SeekMap {
    public static final ExtractorsFactory FACTORY = new c();
    private static final int FILE_TYPE_HEIC = 2;
    private static final int FILE_TYPE_MP4 = 0;
    private static final int FILE_TYPE_QUICKTIME = 1;
    public static final int FLAG_READ_MOTION_PHOTO_METADATA = 2;
    public static final int FLAG_READ_SEF_DATA = 4;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 1;
    private static final long MAXIMUM_READ_AHEAD_BYTES_STREAM = 10485760;
    private static final long RELOAD_MINIMUM_SEEK_DISTANCE = 262144;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private static final int STATE_READING_SEF = 3;
    private long[][] accumulatedSampleSizes;
    @Nullable
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private final ArrayDeque<Atom.ContainerAtom> containerAtoms;
    private long durationUs;
    private ExtractorOutput extractorOutput;
    private int fileType;
    private int firstVideoTrackIndex;
    private final int flags;
    @Nullable
    private MotionPhotoMetadata motionPhotoMetadata;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleTrackIndex;
    private final ParsableByteArray scratch;
    private final SefReader sefReader;
    private final List<Metadata.Entry> slowMotionMetadataEntries;
    private Mp4Track[] tracks;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class Mp4Track {
        public int sampleIndex;
        public final TrackSampleTable sampleTable;
        public final Track track;
        public final TrackOutput trackOutput;
        @Nullable
        public final TrueHdSampleRechunker trueHdSampleRechunker;

        public Mp4Track(Track track2, TrackSampleTable trackSampleTable, TrackOutput trackOutput2) {
            TrueHdSampleRechunker trueHdSampleRechunker2;
            this.track = track2;
            this.sampleTable = trackSampleTable;
            this.trackOutput = trackOutput2;
            if (MimeTypes.AUDIO_TRUEHD.equals(track2.format.sampleMimeType)) {
                trueHdSampleRechunker2 = new TrueHdSampleRechunker();
            } else {
                trueHdSampleRechunker2 = null;
            }
            this.trueHdSampleRechunker = trueHdSampleRechunker2;
        }
    }

    public Mp4Extractor() {
        this(0);
    }

    private static int brandToFileType(int i11) {
        if (i11 != 1751476579) {
            return i11 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static long[][] calculateAccumulatedSampleSizes(Mp4Track[] mp4TrackArr) {
        long[][] jArr = new long[mp4TrackArr.length][];
        int[] iArr = new int[mp4TrackArr.length];
        long[] jArr2 = new long[mp4TrackArr.length];
        boolean[] zArr = new boolean[mp4TrackArr.length];
        for (int i11 = 0; i11 < mp4TrackArr.length; i11++) {
            jArr[i11] = new long[mp4TrackArr[i11].sampleTable.sampleCount];
            jArr2[i11] = mp4TrackArr[i11].sampleTable.timestampsUs[0];
        }
        long j11 = 0;
        int i12 = 0;
        while (i12 < mp4TrackArr.length) {
            long j12 = Long.MAX_VALUE;
            int i13 = -1;
            for (int i14 = 0; i14 < mp4TrackArr.length; i14++) {
                if (!zArr[i14]) {
                    long j13 = jArr2[i14];
                    if (j13 <= j12) {
                        i13 = i14;
                        j12 = j13;
                    }
                }
            }
            int i15 = iArr[i13];
            long[] jArr3 = jArr[i13];
            jArr3[i15] = j11;
            TrackSampleTable trackSampleTable = mp4TrackArr[i13].sampleTable;
            j11 += (long) trackSampleTable.sizes[i15];
            int i16 = i15 + 1;
            iArr[i13] = i16;
            if (i16 < jArr3.length) {
                jArr2[i13] = trackSampleTable.timestampsUs[i16];
            } else {
                zArr[i13] = true;
                i12++;
            }
        }
        return jArr;
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private static int getSynchronizationSampleIndex(TrackSampleTable trackSampleTable, long j11) {
        int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j11);
        if (indexOfEarlierOrEqualSynchronizationSample == -1) {
            return trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j11);
        }
        return indexOfEarlierOrEqualSynchronizationSample;
    }

    private int getTrackIndexOfNextReadSample(long j11) {
        boolean z11;
        int i11 = -1;
        int i12 = -1;
        int i13 = 0;
        long j12 = Long.MAX_VALUE;
        boolean z12 = true;
        long j13 = Long.MAX_VALUE;
        boolean z13 = true;
        long j14 = Long.MAX_VALUE;
        while (true) {
            Mp4Track[] mp4TrackArr = this.tracks;
            if (i13 >= mp4TrackArr.length) {
                break;
            }
            Mp4Track mp4Track = mp4TrackArr[i13];
            int i14 = mp4Track.sampleIndex;
            TrackSampleTable trackSampleTable = mp4Track.sampleTable;
            if (i14 != trackSampleTable.sampleCount) {
                long j15 = trackSampleTable.offsets[i14];
                long j16 = ((long[][]) Util.castNonNull(this.accumulatedSampleSizes))[i13][i14];
                long j17 = j15 - j11;
                if (j17 < 0 || j17 >= 262144) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if ((!z11 && z13) || (z11 == z13 && j17 < j14)) {
                    z13 = z11;
                    j14 = j17;
                    i12 = i13;
                    j13 = j16;
                }
                if (j16 < j12) {
                    z12 = z11;
                    i11 = i13;
                    j12 = j16;
                }
            }
            i13++;
        }
        if (j12 == Long.MAX_VALUE || !z12 || j13 < j12 + MAXIMUM_READ_AHEAD_BYTES_STREAM) {
            return i12;
        }
        return i11;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Track lambda$processMoovAtom$1(Track track) {
        return track;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new Mp4Extractor()};
    }

    private static long maybeAdjustSeekOffset(TrackSampleTable trackSampleTable, long j11, long j12) {
        int synchronizationSampleIndex = getSynchronizationSampleIndex(trackSampleTable, j11);
        if (synchronizationSampleIndex == -1) {
            return j12;
        }
        return Math.min(trackSampleTable.offsets[synchronizationSampleIndex], j12);
    }

    private void maybeSkipRemainingMetaAtomHeaderBytes(ExtractorInput extractorInput) throws IOException {
        this.scratch.reset(8);
        extractorInput.peekFully(this.scratch.getData(), 0, 8);
        AtomParsers.maybeSkipRemainingMetaAtomHeaderBytes(this.scratch);
        extractorInput.skipFully(this.scratch.getPosition());
        extractorInput.resetPeekPosition();
    }

    private void processAtomEnded(long j11) throws ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j11) {
            Atom.ContainerAtom pop = this.containerAtoms.pop();
            if (pop.type == 1836019574) {
                processMoovAtom(pop);
                this.containerAtoms.clear();
                this.parserState = 2;
            } else if (!this.containerAtoms.isEmpty()) {
                this.containerAtoms.peek().add(pop);
            }
        }
        if (this.parserState != 2) {
            enterReadingAtomHeaderState();
        }
    }

    private void processEndOfStreamReadingAtomHeader() {
        Metadata metadata;
        if (this.fileType == 2 && (this.flags & 2) != 0) {
            TrackOutput track = this.extractorOutput.track(0, 4);
            if (this.motionPhotoMetadata == null) {
                metadata = null;
            } else {
                metadata = new Metadata(this.motionPhotoMetadata);
            }
            track.format(new Format.Builder().setMetadata(metadata).build());
            this.extractorOutput.endTracks();
            this.extractorOutput.seekMap(new SeekMap.Unseekable(C.TIME_UNSET));
        }
    }

    private static int processFtypAtom(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int brandToFileType = brandToFileType(parsableByteArray.readInt());
        if (brandToFileType != 0) {
            return brandToFileType;
        }
        parsableByteArray.skipBytes(4);
        while (parsableByteArray.bytesLeft() > 0) {
            int brandToFileType2 = brandToFileType(parsableByteArray.readInt());
            if (brandToFileType2 != 0) {
                return brandToFileType2;
            }
        }
        return 0;
    }

    private void processMoovAtom(Atom.ContainerAtom containerAtom) throws ParserException {
        boolean z11;
        Metadata metadata;
        Metadata metadata2;
        Metadata metadata3;
        boolean z12;
        int i11;
        List<TrackSampleTable> list;
        int i12;
        Metadata metadata4;
        int i13;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        ArrayList arrayList = new ArrayList();
        if (this.fileType == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
        Atom.LeafAtom leafAtomOfType = containerAtom2.getLeafAtomOfType(Atom.TYPE_udta);
        if (leafAtomOfType != null) {
            Pair<Metadata, Metadata> parseUdta = AtomParsers.parseUdta(leafAtomOfType);
            Metadata metadata5 = (Metadata) parseUdta.first;
            Metadata metadata6 = (Metadata) parseUdta.second;
            if (metadata5 != null) {
                gaplessInfoHolder.setFromMetadata(metadata5);
            }
            metadata2 = metadata6;
            metadata = metadata5;
        } else {
            metadata2 = null;
            metadata = null;
        }
        Atom.ContainerAtom containerAtomOfType = containerAtom2.getContainerAtomOfType(Atom.TYPE_meta);
        if (containerAtomOfType != null) {
            metadata3 = AtomParsers.parseMdtaFromMeta(containerAtomOfType);
        } else {
            metadata3 = null;
        }
        if ((this.flags & 1) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        Metadata metadata7 = metadata3;
        List<TrackSampleTable> parseTraks = AtomParsers.parseTraks(containerAtom, gaplessInfoHolder, C.TIME_UNSET, (DrmInitData) null, z12, z11, new d());
        int size = parseTraks.size();
        long j11 = C.TIME_UNSET;
        long j12 = -9223372036854775807L;
        int i14 = 0;
        int i15 = -1;
        while (i14 < size) {
            TrackSampleTable trackSampleTable = parseTraks.get(i14);
            if (trackSampleTable.sampleCount == 0) {
                list = parseTraks;
                i11 = size;
            } else {
                Track track = trackSampleTable.track;
                list = parseTraks;
                i11 = size;
                long j13 = track.durationUs;
                if (j13 == j11) {
                    j13 = trackSampleTable.durationUs;
                }
                long max = Math.max(j12, j13);
                Mp4Track mp4Track = new Mp4Track(track, trackSampleTable, this.extractorOutput.track(i14, track.type));
                if (MimeTypes.AUDIO_TRUEHD.equals(track.format.sampleMimeType)) {
                    i12 = trackSampleTable.maximumSize * 16;
                } else {
                    i12 = trackSampleTable.maximumSize + 30;
                }
                Format.Builder buildUpon = track.format.buildUpon();
                buildUpon.setMaxInputSize(i12);
                if (track.type == 2 && j13 > 0 && (i13 = trackSampleTable.sampleCount) > 1) {
                    buildUpon.setFrameRate(((float) i13) / (((float) j13) / 1000000.0f));
                }
                MetadataUtil.setFormatGaplessInfo(track.type, gaplessInfoHolder, buildUpon);
                int i16 = track.type;
                Metadata[] metadataArr = new Metadata[2];
                metadataArr[0] = metadata2;
                if (this.slowMotionMetadataEntries.isEmpty()) {
                    metadata4 = null;
                } else {
                    metadata4 = new Metadata((List<? extends Metadata.Entry>) this.slowMotionMetadataEntries);
                }
                metadataArr[1] = metadata4;
                MetadataUtil.setFormatMetadata(i16, metadata, metadata7, buildUpon, metadataArr);
                mp4Track.trackOutput.format(buildUpon.build());
                if (track.type == 2) {
                    if (i15 == -1) {
                        i15 = arrayList.size();
                    }
                }
                arrayList.add(mp4Track);
                j12 = max;
            }
            i14++;
            parseTraks = list;
            size = i11;
            j11 = C.TIME_UNSET;
        }
        this.firstVideoTrackIndex = i15;
        this.durationUs = j12;
        Mp4Track[] mp4TrackArr = (Mp4Track[]) arrayList.toArray(new Mp4Track[0]);
        this.tracks = mp4TrackArr;
        this.accumulatedSampleSizes = calculateAccumulatedSampleSizes(mp4TrackArr);
        this.extractorOutput.endTracks();
        this.extractorOutput.seekMap(this);
    }

    private void processUnparsedAtom(long j11) {
        if (this.atomType == 1836086884) {
            int i11 = this.atomHeaderBytesRead;
            this.motionPhotoMetadata = new MotionPhotoMetadata(0, j11, C.TIME_UNSET, j11 + ((long) i11), this.atomSize - ((long) i11));
        }
    }

    private boolean readAtomHeader(ExtractorInput extractorInput) throws IOException {
        boolean z11;
        boolean z12;
        Atom.ContainerAtom peek;
        if (this.atomHeaderBytesRead == 0) {
            if (!extractorInput.readFully(this.atomHeader.getData(), 0, 8, true)) {
                processEndOfStreamReadingAtomHeader();
                return false;
            }
            this.atomHeaderBytesRead = 8;
            this.atomHeader.setPosition(0);
            this.atomSize = this.atomHeader.readUnsignedInt();
            this.atomType = this.atomHeader.readInt();
        }
        long j11 = this.atomSize;
        if (j11 == 1) {
            extractorInput.readFully(this.atomHeader.getData(), 8, 8);
            this.atomHeaderBytesRead += 8;
            this.atomSize = this.atomHeader.readUnsignedLongToLong();
        } else if (j11 == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && (peek = this.containerAtoms.peek()) != null) {
                length = peek.endPosition;
            }
            if (length != -1) {
                this.atomSize = (length - extractorInput.getPosition()) + ((long) this.atomHeaderBytesRead);
            }
        }
        if (this.atomSize >= ((long) this.atomHeaderBytesRead)) {
            if (shouldParseContainerAtom(this.atomType)) {
                long position = extractorInput.getPosition();
                long j12 = this.atomSize;
                int i11 = this.atomHeaderBytesRead;
                long j13 = (position + j12) - ((long) i11);
                if (j12 != ((long) i11) && this.atomType == 1835365473) {
                    maybeSkipRemainingMetaAtomHeaderBytes(extractorInput);
                }
                this.containerAtoms.push(new Atom.ContainerAtom(this.atomType, j13));
                if (this.atomSize == ((long) this.atomHeaderBytesRead)) {
                    processAtomEnded(j13);
                } else {
                    enterReadingAtomHeaderState();
                }
            } else if (shouldParseLeafAtom(this.atomType)) {
                if (this.atomHeaderBytesRead == 8) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Assertions.checkState(z11);
                if (this.atomSize <= 2147483647L) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                Assertions.checkState(z12);
                ParsableByteArray parsableByteArray = new ParsableByteArray((int) this.atomSize);
                System.arraycopy(this.atomHeader.getData(), 0, parsableByteArray.getData(), 0, 8);
                this.atomData = parsableByteArray;
                this.parserState = 1;
            } else {
                processUnparsedAtom(extractorInput.getPosition() - ((long) this.atomHeaderBytesRead));
                this.atomData = null;
                this.parserState = 1;
            }
            return true;
        }
        throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean readAtomPayload(com.google.android.exoplayer2.extractor.ExtractorInput r10, com.google.android.exoplayer2.extractor.PositionHolder r11) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.atomSize
            int r2 = r9.atomHeaderBytesRead
            long r2 = (long) r2
            long r0 = r0 - r2
            long r2 = r10.getPosition()
            long r2 = r2 + r0
            com.google.android.exoplayer2.util.ParsableByteArray r4 = r9.atomData
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0044
            byte[] r11 = r4.getData()
            int r7 = r9.atomHeaderBytesRead
            int r0 = (int) r0
            r10.readFully(r11, r7, r0)
            int r10 = r9.atomType
            r11 = 1718909296(0x66747970, float:2.8862439E23)
            if (r10 != r11) goto L_0x0029
            int r10 = processFtypAtom(r4)
            r9.fileType = r10
            goto L_0x004f
        L_0x0029:
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.Atom$ContainerAtom> r10 = r9.containerAtoms
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x004f
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.Atom$ContainerAtom> r10 = r9.containerAtoms
            java.lang.Object r10 = r10.peek()
            com.google.android.exoplayer2.extractor.mp4.Atom$ContainerAtom r10 = (com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom) r10
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r11 = new com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom
            int r0 = r9.atomType
            r11.<init>(r0, r4)
            r10.add((com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) r11)
            goto L_0x004f
        L_0x0044:
            r7 = 262144(0x40000, double:1.295163E-318)
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 >= 0) goto L_0x0051
            int r11 = (int) r0
            r10.skipFully(r11)
        L_0x004f:
            r10 = r6
            goto L_0x0059
        L_0x0051:
            long r7 = r10.getPosition()
            long r7 = r7 + r0
            r11.position = r7
            r10 = r5
        L_0x0059:
            r9.processAtomEnded(r2)
            if (r10 == 0) goto L_0x0064
            int r10 = r9.parserState
            r11 = 2
            if (r10 == r11) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            r5 = r6
        L_0x0065:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.readAtomPayload(com.google.android.exoplayer2.extractor.ExtractorInput, com.google.android.exoplayer2.extractor.PositionHolder):boolean");
    }

    private int readSample(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i11;
        PositionHolder positionHolder2;
        ExtractorInput extractorInput2 = extractorInput;
        long position = extractorInput.getPosition();
        if (this.sampleTrackIndex == -1) {
            int trackIndexOfNextReadSample = getTrackIndexOfNextReadSample(position);
            this.sampleTrackIndex = trackIndexOfNextReadSample;
            if (trackIndexOfNextReadSample == -1) {
                return -1;
            }
        }
        Mp4Track mp4Track = this.tracks[this.sampleTrackIndex];
        TrackOutput trackOutput = mp4Track.trackOutput;
        int i12 = mp4Track.sampleIndex;
        TrackSampleTable trackSampleTable = mp4Track.sampleTable;
        long j11 = trackSampleTable.offsets[i12];
        int i13 = trackSampleTable.sizes[i12];
        TrueHdSampleRechunker trueHdSampleRechunker = mp4Track.trueHdSampleRechunker;
        long j12 = (j11 - position) + ((long) this.sampleBytesRead);
        if (j12 < 0) {
            i11 = 1;
            positionHolder2 = positionHolder;
        } else if (j12 >= 262144) {
            positionHolder2 = positionHolder;
            i11 = 1;
        } else {
            if (mp4Track.track.sampleTransformation == 1) {
                j12 += 8;
                i13 -= 8;
            }
            extractorInput2.skipFully((int) j12);
            Track track = mp4Track.track;
            if (track.nalUnitLengthFieldLength == 0) {
                if (MimeTypes.AUDIO_AC4.equals(track.format.sampleMimeType)) {
                    if (this.sampleBytesWritten == 0) {
                        Ac4Util.getAc4SampleHeader(i13, this.scratch);
                        trackOutput.sampleData(this.scratch, 7);
                        this.sampleBytesWritten += 7;
                    }
                    i13 += 7;
                } else if (trueHdSampleRechunker != null) {
                    trueHdSampleRechunker.startSample(extractorInput2);
                }
                while (true) {
                    int i14 = this.sampleBytesWritten;
                    if (i14 >= i13) {
                        break;
                    }
                    int sampleData = trackOutput.sampleData((DataReader) extractorInput2, i13 - i14, false);
                    this.sampleBytesRead += sampleData;
                    this.sampleBytesWritten += sampleData;
                    this.sampleCurrentNalBytesRemaining -= sampleData;
                }
            } else {
                byte[] data = this.nalLength.getData();
                data[0] = 0;
                data[1] = 0;
                data[2] = 0;
                int i15 = mp4Track.track.nalUnitLengthFieldLength;
                int i16 = 4 - i15;
                while (this.sampleBytesWritten < i13) {
                    int i17 = this.sampleCurrentNalBytesRemaining;
                    if (i17 == 0) {
                        extractorInput2.readFully(data, i16, i15);
                        this.sampleBytesRead += i15;
                        this.nalLength.setPosition(0);
                        int readInt = this.nalLength.readInt();
                        if (readInt >= 0) {
                            this.sampleCurrentNalBytesRemaining = readInt;
                            this.nalStartCode.setPosition(0);
                            trackOutput.sampleData(this.nalStartCode, 4);
                            this.sampleBytesWritten += 4;
                            i13 += i16;
                        } else {
                            throw ParserException.createForMalformedContainer("Invalid NAL length", (Throwable) null);
                        }
                    } else {
                        int sampleData2 = trackOutput.sampleData((DataReader) extractorInput2, i17, false);
                        this.sampleBytesRead += sampleData2;
                        this.sampleBytesWritten += sampleData2;
                        this.sampleCurrentNalBytesRemaining -= sampleData2;
                    }
                }
            }
            int i18 = i13;
            TrackSampleTable trackSampleTable2 = mp4Track.sampleTable;
            long j13 = trackSampleTable2.timestampsUs[i12];
            int i19 = trackSampleTable2.flags[i12];
            if (trueHdSampleRechunker != null) {
                int i21 = i18;
                TrueHdSampleRechunker trueHdSampleRechunker2 = trueHdSampleRechunker;
                trueHdSampleRechunker.sampleMetadata(trackOutput, j13, i19, i21, 0, (TrackOutput.CryptoData) null);
                if (i12 + 1 == mp4Track.sampleTable.sampleCount) {
                    trueHdSampleRechunker2.outputPendingSampleMetadata(trackOutput, (TrackOutput.CryptoData) null);
                }
            } else {
                trackOutput.sampleMetadata(j13, i19, i18, 0, (TrackOutput.CryptoData) null);
            }
            mp4Track.sampleIndex++;
            this.sampleTrackIndex = -1;
            this.sampleBytesRead = 0;
            this.sampleBytesWritten = 0;
            this.sampleCurrentNalBytesRemaining = 0;
            return 0;
        }
        positionHolder2.position = j11;
        return i11;
    }

    private int readSefData(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int read = this.sefReader.read(extractorInput, positionHolder, this.slowMotionMetadataEntries);
        if (read == 1 && positionHolder.position == 0) {
            enterReadingAtomHeaderState();
        }
        return read;
    }

    private static boolean shouldParseContainerAtom(int i11) {
        return i11 == 1836019574 || i11 == 1953653099 || i11 == 1835297121 || i11 == 1835626086 || i11 == 1937007212 || i11 == 1701082227 || i11 == 1835365473;
    }

    private static boolean shouldParseLeafAtom(int i11) {
        return i11 == 1835296868 || i11 == 1836476516 || i11 == 1751411826 || i11 == 1937011556 || i11 == 1937011827 || i11 == 1937011571 || i11 == 1668576371 || i11 == 1701606260 || i11 == 1937011555 || i11 == 1937011578 || i11 == 1937013298 || i11 == 1937007471 || i11 == 1668232756 || i11 == 1953196132 || i11 == 1718909296 || i11 == 1969517665 || i11 == 1801812339 || i11 == 1768715124;
    }

    private void updateSampleIndex(Mp4Track mp4Track, long j11) {
        TrackSampleTable trackSampleTable = mp4Track.sampleTable;
        int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j11);
        if (indexOfEarlierOrEqualSynchronizationSample == -1) {
            indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j11);
        }
        mp4Track.sampleIndex = indexOfEarlierOrEqualSynchronizationSample;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap.SeekPoints getSeekPoints(long j11) {
        return getSeekPoints(j11, -1);
    }

    public void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
    }

    public boolean isSeekable() {
        return true;
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            int i11 = this.parserState;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        return readSample(extractorInput, positionHolder);
                    }
                    if (i11 == 3) {
                        return readSefData(extractorInput, positionHolder);
                    }
                    throw new IllegalStateException();
                } else if (readAtomPayload(extractorInput, positionHolder)) {
                    return 1;
                }
            } else if (!readAtomHeader(extractorInput)) {
                return -1;
            }
        }
    }

    public void release() {
    }

    public void seek(long j11, long j12) {
        this.containerAtoms.clear();
        this.atomHeaderBytesRead = 0;
        this.sampleTrackIndex = -1;
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        if (j11 != 0) {
            for (Mp4Track mp4Track : this.tracks) {
                updateSampleIndex(mp4Track, j12);
                TrueHdSampleRechunker trueHdSampleRechunker = mp4Track.trueHdSampleRechunker;
                if (trueHdSampleRechunker != null) {
                    trueHdSampleRechunker.reset();
                }
            }
        } else if (this.parserState != 3) {
            enterReadingAtomHeaderState();
        } else {
            this.sefReader.reset();
            this.slowMotionMetadataEntries.clear();
        }
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return Sniffer.sniffUnfragmented(extractorInput, (this.flags & 2) != 0);
    }

    public Mp4Extractor(int i11) {
        this.flags = i11;
        this.parserState = (i11 & 4) != 0 ? 3 : 0;
        this.sefReader = new SefReader();
        this.slowMotionMetadataEntries = new ArrayList();
        this.atomHeader = new ParsableByteArray(16);
        this.containerAtoms = new ArrayDeque<>();
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.scratch = new ParsableByteArray();
        this.sampleTrackIndex = -1;
        this.extractorOutput = ExtractorOutput.PLACEHOLDER;
        this.tracks = new Mp4Track[0];
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long r17, int r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r19
            com.google.android.exoplayer2.extractor.mp4.Mp4Extractor$Mp4Track[] r4 = r0.tracks
            int r5 = r4.length
            if (r5 != 0) goto L_0x0013
            com.google.android.exoplayer2.extractor.SeekMap$SeekPoints r1 = new com.google.android.exoplayer2.extractor.SeekMap$SeekPoints
            com.google.android.exoplayer2.extractor.SeekPoint r2 = com.google.android.exoplayer2.extractor.SeekPoint.START
            r1.<init>(r2)
            return r1
        L_0x0013:
            r5 = -1
            if (r3 == r5) goto L_0x0018
            r6 = r3
            goto L_0x001a
        L_0x0018:
            int r6 = r0.firstVideoTrackIndex
        L_0x001a:
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = -1
            if (r6 == r5) goto L_0x0058
            r4 = r4[r6]
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r4 = r4.sampleTable
            int r6 = getSynchronizationSampleIndex(r4, r1)
            if (r6 != r5) goto L_0x0035
            com.google.android.exoplayer2.extractor.SeekMap$SeekPoints r1 = new com.google.android.exoplayer2.extractor.SeekMap$SeekPoints
            com.google.android.exoplayer2.extractor.SeekPoint r2 = com.google.android.exoplayer2.extractor.SeekPoint.START
            r1.<init>(r2)
            return r1
        L_0x0035:
            long[] r11 = r4.timestampsUs
            r12 = r11[r6]
            long[] r11 = r4.offsets
            r14 = r11[r6]
            int r11 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r11 >= 0) goto L_0x005e
            int r11 = r4.sampleCount
            int r11 = r11 + -1
            if (r6 >= r11) goto L_0x005e
            int r1 = r4.getIndexOfLaterOrEqualSynchronizationSample(r1)
            if (r1 == r5) goto L_0x005e
            if (r1 == r6) goto L_0x005e
            long[] r2 = r4.timestampsUs
            r9 = r2[r1]
            long[] r2 = r4.offsets
            r1 = r2[r1]
            goto L_0x0060
        L_0x0058:
            r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12 = r1
        L_0x005e:
            r1 = r9
            r9 = r7
        L_0x0060:
            if (r3 != r5) goto L_0x007f
            r3 = 0
        L_0x0063:
            com.google.android.exoplayer2.extractor.mp4.Mp4Extractor$Mp4Track[] r4 = r0.tracks
            int r5 = r4.length
            if (r3 >= r5) goto L_0x007f
            int r5 = r0.firstVideoTrackIndex
            if (r3 == r5) goto L_0x007c
            r4 = r4[r3]
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r4 = r4.sampleTable
            long r14 = maybeAdjustSeekOffset(r4, r12, r14)
            int r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r5 == 0) goto L_0x007c
            long r1 = maybeAdjustSeekOffset(r4, r9, r1)
        L_0x007c:
            int r3 = r3 + 1
            goto L_0x0063
        L_0x007f:
            com.google.android.exoplayer2.extractor.SeekPoint r3 = new com.google.android.exoplayer2.extractor.SeekPoint
            r3.<init>(r12, r14)
            int r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r4 != 0) goto L_0x008e
            com.google.android.exoplayer2.extractor.SeekMap$SeekPoints r1 = new com.google.android.exoplayer2.extractor.SeekMap$SeekPoints
            r1.<init>(r3)
            return r1
        L_0x008e:
            com.google.android.exoplayer2.extractor.SeekPoint r4 = new com.google.android.exoplayer2.extractor.SeekPoint
            r4.<init>(r9, r1)
            com.google.android.exoplayer2.extractor.SeekMap$SeekPoints r1 = new com.google.android.exoplayer2.extractor.SeekMap$SeekPoints
            r1.<init>(r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.getSeekPoints(long, int):com.google.android.exoplayer2.extractor.SeekMap$SeekPoints");
    }
}
