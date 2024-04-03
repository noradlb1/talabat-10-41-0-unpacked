package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class SsManifestParser implements ParsingLoadable.Parser<SsManifest> {
    private final XmlPullParserFactory xmlParserFactory;

    public static abstract class ElementParser {
        private final String baseUri;
        private final List<Pair<String, Object>> normalizedAttributes = new LinkedList();
        @Nullable
        private final ElementParser parent;
        private final String tag;

        public ElementParser(@Nullable ElementParser elementParser, String str, String str2) {
            this.parent = elementParser;
            this.baseUri = str;
            this.tag = str2;
        }

        private ElementParser newChildParser(ElementParser elementParser, String str, String str2) {
            if (QualityLevelParser.TAG.equals(str)) {
                return new QualityLevelParser(elementParser, str2);
            }
            if (ProtectionParser.TAG.equals(str)) {
                return new ProtectionParser(elementParser, str2);
            }
            if (StreamIndexParser.TAG.equals(str)) {
                return new StreamIndexParser(elementParser, str2);
            }
            return null;
        }

        public void addChild(Object obj) {
        }

        public abstract Object build();

        @Nullable
        public final Object getNormalizedAttribute(String str) {
            for (int i11 = 0; i11 < this.normalizedAttributes.size(); i11++) {
                Pair pair = this.normalizedAttributes.get(i11);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
            }
            ElementParser elementParser = this.parent;
            if (elementParser == null) {
                return null;
            }
            return elementParser.getNormalizedAttribute(str);
        }

        public boolean handleChildInline(String str) {
            return false;
        }

        public final Object parse(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name2 = xmlPullParser.getName();
                    if (this.tag.equals(name2)) {
                        parseStartTag(xmlPullParser);
                        z11 = true;
                    } else if (z11) {
                        if (i11 > 0) {
                            i11++;
                        } else if (handleChildInline(name2)) {
                            parseStartTag(xmlPullParser);
                        } else {
                            ElementParser newChildParser = newChildParser(this, name2, this.baseUri);
                            if (newChildParser == null) {
                                i11 = 1;
                            } else {
                                addChild(newChildParser.parse(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z11 && i11 == 0) {
                        parseText(xmlPullParser);
                    }
                } else if (!z11) {
                    continue;
                } else if (i11 > 0) {
                    i11--;
                } else {
                    String name3 = xmlPullParser.getName();
                    parseEndTag(xmlPullParser);
                    if (!handleChildInline(name3)) {
                        return build();
                    }
                }
                xmlPullParser.next();
            }
        }

        public final boolean parseBoolean(XmlPullParser xmlPullParser, String str, boolean z11) {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue != null) {
                return Boolean.parseBoolean(attributeValue);
            }
            return z11;
        }

        public void parseEndTag(XmlPullParser xmlPullParser) {
        }

        public final int parseInt(XmlPullParser xmlPullParser, String str, int i11) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue == null) {
                return i11;
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e11) {
                throw ParserException.createForMalformedManifest((String) null, e11);
            }
        }

        public final long parseLong(XmlPullParser xmlPullParser, String str, long j11) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue == null) {
                return j11;
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e11) {
                throw ParserException.createForMalformedManifest((String) null, e11);
            }
        }

        public final int parseRequiredInt(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue != null) {
                try {
                    return Integer.parseInt(attributeValue);
                } catch (NumberFormatException e11) {
                    throw ParserException.createForMalformedManifest((String) null, e11);
                }
            } else {
                throw new MissingFieldException(str);
            }
        }

        public final long parseRequiredLong(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue != null) {
                try {
                    return Long.parseLong(attributeValue);
                } catch (NumberFormatException e11) {
                    throw ParserException.createForMalformedManifest((String) null, e11);
                }
            } else {
                throw new MissingFieldException(str);
            }
        }

        public final String parseRequiredString(XmlPullParser xmlPullParser, String str) throws MissingFieldException {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new MissingFieldException(str);
        }

        public void parseStartTag(XmlPullParser xmlPullParser) throws ParserException {
        }

        public void parseText(XmlPullParser xmlPullParser) {
        }

        public final void putNormalizedAttribute(String str, @Nullable Object obj) {
            this.normalizedAttributes.add(Pair.create(str, obj));
        }
    }

    public static class MissingFieldException extends ParserException {
        public MissingFieldException(String str) {
            super("Missing required field: " + str, (Throwable) null, true, 4);
        }
    }

    public static class ProtectionParser extends ElementParser {
        private static final int INITIALIZATION_VECTOR_SIZE = 8;
        public static final String KEY_SYSTEM_ID = "SystemID";
        public static final String TAG = "Protection";
        public static final String TAG_PROTECTION_HEADER = "ProtectionHeader";
        private boolean inProtectionHeader;
        private byte[] initData;
        private UUID uuid;

        public ProtectionParser(ElementParser elementParser, String str) {
            super(elementParser, str, TAG);
        }

        private static TrackEncryptionBox[] buildTrackEncryptionBoxes(byte[] bArr) {
            return new TrackEncryptionBox[]{new TrackEncryptionBox(true, (String) null, 8, getProtectionElementKeyId(bArr), 0, 0, (byte[]) null)};
        }

        private static byte[] getProtectionElementKeyId(byte[] bArr) {
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < bArr.length; i11 += 2) {
                sb2.append((char) bArr[i11]);
            }
            String sb3 = sb2.toString();
            byte[] decode = Base64.decode(sb3.substring(sb3.indexOf("<KID>") + 5, sb3.indexOf("</KID>")), 0);
            swap(decode, 0, 3);
            swap(decode, 1, 2);
            swap(decode, 4, 5);
            swap(decode, 6, 7);
            return decode;
        }

        private static String stripCurlyBraces(String str) {
            if (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') {
                return str.substring(1, str.length() - 1);
            }
            return str;
        }

        private static void swap(byte[] bArr, int i11, int i12) {
            byte b11 = bArr[i11];
            bArr[i11] = bArr[i12];
            bArr[i12] = b11;
        }

        public Object build() {
            UUID uuid2 = this.uuid;
            return new SsManifest.ProtectionElement(uuid2, PsshAtomUtil.buildPsshAtom(uuid2, this.initData), buildTrackEncryptionBoxes(this.initData));
        }

        public boolean handleChildInline(String str) {
            return TAG_PROTECTION_HEADER.equals(str);
        }

        public void parseEndTag(XmlPullParser xmlPullParser) {
            if (TAG_PROTECTION_HEADER.equals(xmlPullParser.getName())) {
                this.inProtectionHeader = false;
            }
        }

        public void parseStartTag(XmlPullParser xmlPullParser) {
            if (TAG_PROTECTION_HEADER.equals(xmlPullParser.getName())) {
                this.inProtectionHeader = true;
                this.uuid = UUID.fromString(stripCurlyBraces(xmlPullParser.getAttributeValue((String) null, KEY_SYSTEM_ID)));
            }
        }

        public void parseText(XmlPullParser xmlPullParser) {
            if (this.inProtectionHeader) {
                this.initData = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    public static class QualityLevelParser extends ElementParser {
        private static final String KEY_BITRATE = "Bitrate";
        private static final String KEY_CHANNELS = "Channels";
        private static final String KEY_CODEC_PRIVATE_DATA = "CodecPrivateData";
        private static final String KEY_FOUR_CC = "FourCC";
        private static final String KEY_INDEX = "Index";
        private static final String KEY_LANGUAGE = "Language";
        private static final String KEY_MAX_HEIGHT = "MaxHeight";
        private static final String KEY_MAX_WIDTH = "MaxWidth";
        private static final String KEY_NAME = "Name";
        private static final String KEY_SAMPLING_RATE = "SamplingRate";
        private static final String KEY_SUB_TYPE = "Subtype";
        private static final String KEY_TYPE = "Type";
        public static final String TAG = "QualityLevel";
        private Format format;

        public QualityLevelParser(ElementParser elementParser, String str) {
            super(elementParser, str, TAG);
        }

        private static List<byte[]> buildCodecSpecificData(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] bytesFromHexString = Util.getBytesFromHexString(str);
                byte[][] splitNalUnits = CodecSpecificDataUtil.splitNalUnits(bytesFromHexString);
                if (splitNalUnits == null) {
                    arrayList.add(bytesFromHexString);
                } else {
                    Collections.addAll(arrayList, splitNalUnits);
                }
            }
            return arrayList;
        }

        @Nullable
        private static String fourCCToMimeType(String str) {
            if (str.equalsIgnoreCase("H264") || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1") || str.equalsIgnoreCase("DAVC")) {
                return MimeTypes.VIDEO_H264;
            }
            if (str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH") || str.equalsIgnoreCase("AACP")) {
                return MimeTypes.AUDIO_AAC;
            }
            if (str.equalsIgnoreCase("TTML") || str.equalsIgnoreCase("DFXP")) {
                return MimeTypes.APPLICATION_TTML;
            }
            if (str.equalsIgnoreCase("ac-3") || str.equalsIgnoreCase("dac3")) {
                return MimeTypes.AUDIO_AC3;
            }
            if (str.equalsIgnoreCase("ec-3") || str.equalsIgnoreCase("dec3")) {
                return MimeTypes.AUDIO_E_AC3;
            }
            if (str.equalsIgnoreCase("dtsc")) {
                return MimeTypes.AUDIO_DTS;
            }
            if (str.equalsIgnoreCase("dtsh") || str.equalsIgnoreCase("dtsl")) {
                return MimeTypes.AUDIO_DTS_HD;
            }
            if (str.equalsIgnoreCase("dtse")) {
                return MimeTypes.AUDIO_DTS_EXPRESS;
            }
            if (str.equalsIgnoreCase("opus")) {
                return MimeTypes.AUDIO_OPUS;
            }
            return null;
        }

        public Object build() {
            return this.format;
        }

        public void parseStartTag(XmlPullParser xmlPullParser) throws ParserException {
            int i11;
            Format.Builder builder = new Format.Builder();
            String fourCCToMimeType = fourCCToMimeType(parseRequiredString(xmlPullParser, KEY_FOUR_CC));
            int intValue = ((Integer) getNormalizedAttribute(KEY_TYPE)).intValue();
            if (intValue == 2) {
                builder.setContainerMimeType(MimeTypes.VIDEO_MP4).setWidth(parseRequiredInt(xmlPullParser, KEY_MAX_WIDTH)).setHeight(parseRequiredInt(xmlPullParser, KEY_MAX_HEIGHT)).setInitializationData(buildCodecSpecificData(xmlPullParser.getAttributeValue((String) null, KEY_CODEC_PRIVATE_DATA)));
            } else if (intValue == 1) {
                if (fourCCToMimeType == null) {
                    fourCCToMimeType = MimeTypes.AUDIO_AAC;
                }
                int parseRequiredInt = parseRequiredInt(xmlPullParser, KEY_CHANNELS);
                int parseRequiredInt2 = parseRequiredInt(xmlPullParser, KEY_SAMPLING_RATE);
                List<byte[]> buildCodecSpecificData = buildCodecSpecificData(xmlPullParser.getAttributeValue((String) null, KEY_CODEC_PRIVATE_DATA));
                if (buildCodecSpecificData.isEmpty() && MimeTypes.AUDIO_AAC.equals(fourCCToMimeType)) {
                    buildCodecSpecificData = Collections.singletonList(AacUtil.buildAacLcAudioSpecificConfig(parseRequiredInt2, parseRequiredInt));
                }
                builder.setContainerMimeType(MimeTypes.AUDIO_MP4).setChannelCount(parseRequiredInt).setSampleRate(parseRequiredInt2).setInitializationData(buildCodecSpecificData);
            } else if (intValue == 3) {
                String str = (String) getNormalizedAttribute(KEY_SUB_TYPE);
                if (str != null) {
                    if (str.equals("CAPT")) {
                        i11 = 64;
                    } else if (str.equals("DESC")) {
                        i11 = 1024;
                    }
                    builder.setContainerMimeType(MimeTypes.APPLICATION_MP4).setRoleFlags(i11);
                }
                i11 = 0;
                builder.setContainerMimeType(MimeTypes.APPLICATION_MP4).setRoleFlags(i11);
            } else {
                builder.setContainerMimeType(MimeTypes.APPLICATION_MP4);
            }
            this.format = builder.setId(xmlPullParser.getAttributeValue((String) null, KEY_INDEX)).setLabel((String) getNormalizedAttribute(KEY_NAME)).setSampleMimeType(fourCCToMimeType).setAverageBitrate(parseRequiredInt(xmlPullParser, KEY_BITRATE)).setLanguage((String) getNormalizedAttribute(KEY_LANGUAGE)).build();
        }
    }

    public static class SmoothStreamingMediaParser extends ElementParser {
        private static final String KEY_DURATION = "Duration";
        private static final String KEY_DVR_WINDOW_LENGTH = "DVRWindowLength";
        private static final String KEY_IS_LIVE = "IsLive";
        private static final String KEY_LOOKAHEAD_COUNT = "LookaheadCount";
        private static final String KEY_MAJOR_VERSION = "MajorVersion";
        private static final String KEY_MINOR_VERSION = "MinorVersion";
        private static final String KEY_TIME_SCALE = "TimeScale";
        public static final String TAG = "SmoothStreamingMedia";
        private long duration;
        private long dvrWindowLength;
        private boolean isLive;
        private int lookAheadCount = -1;
        private int majorVersion;
        private int minorVersion;
        @Nullable
        private SsManifest.ProtectionElement protectionElement = null;
        private final List<SsManifest.StreamElement> streamElements = new LinkedList();
        private long timescale;

        public SmoothStreamingMediaParser(ElementParser elementParser, String str) {
            super(elementParser, str, TAG);
        }

        public void addChild(Object obj) {
            boolean z11;
            if (obj instanceof SsManifest.StreamElement) {
                this.streamElements.add((SsManifest.StreamElement) obj);
            } else if (obj instanceof SsManifest.ProtectionElement) {
                if (this.protectionElement == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Assertions.checkState(z11);
                this.protectionElement = (SsManifest.ProtectionElement) obj;
            }
        }

        public Object build() {
            int size = this.streamElements.size();
            SsManifest.StreamElement[] streamElementArr = new SsManifest.StreamElement[size];
            this.streamElements.toArray(streamElementArr);
            if (this.protectionElement != null) {
                SsManifest.ProtectionElement protectionElement2 = this.protectionElement;
                DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(protectionElement2.uuid, MimeTypes.VIDEO_MP4, protectionElement2.data));
                for (int i11 = 0; i11 < size; i11++) {
                    SsManifest.StreamElement streamElement = streamElementArr[i11];
                    int i12 = streamElement.type;
                    if (i12 == 2 || i12 == 1) {
                        Format[] formatArr = streamElement.formats;
                        for (int i13 = 0; i13 < formatArr.length; i13++) {
                            formatArr[i13] = formatArr[i13].buildUpon().setDrmInitData(drmInitData).build();
                        }
                    }
                }
            }
            return new SsManifest(this.majorVersion, this.minorVersion, this.timescale, this.duration, this.dvrWindowLength, this.lookAheadCount, this.isLive, this.protectionElement, streamElementArr);
        }

        public void parseStartTag(XmlPullParser xmlPullParser) throws ParserException {
            this.majorVersion = parseRequiredInt(xmlPullParser, KEY_MAJOR_VERSION);
            this.minorVersion = parseRequiredInt(xmlPullParser, KEY_MINOR_VERSION);
            this.timescale = parseLong(xmlPullParser, KEY_TIME_SCALE, 10000000);
            this.duration = parseRequiredLong(xmlPullParser, KEY_DURATION);
            this.dvrWindowLength = parseLong(xmlPullParser, KEY_DVR_WINDOW_LENGTH, 0);
            this.lookAheadCount = parseInt(xmlPullParser, KEY_LOOKAHEAD_COUNT, -1);
            this.isLive = parseBoolean(xmlPullParser, KEY_IS_LIVE, false);
            putNormalizedAttribute(KEY_TIME_SCALE, Long.valueOf(this.timescale));
        }
    }

    public static class StreamIndexParser extends ElementParser {
        private static final String KEY_DISPLAY_HEIGHT = "DisplayHeight";
        private static final String KEY_DISPLAY_WIDTH = "DisplayWidth";
        private static final String KEY_FRAGMENT_DURATION = "d";
        private static final String KEY_FRAGMENT_REPEAT_COUNT = "r";
        private static final String KEY_FRAGMENT_START_TIME = "t";
        private static final String KEY_LANGUAGE = "Language";
        private static final String KEY_MAX_HEIGHT = "MaxHeight";
        private static final String KEY_MAX_WIDTH = "MaxWidth";
        private static final String KEY_NAME = "Name";
        private static final String KEY_SUB_TYPE = "Subtype";
        private static final String KEY_TIME_SCALE = "TimeScale";
        private static final String KEY_TYPE = "Type";
        private static final String KEY_TYPE_AUDIO = "audio";
        private static final String KEY_TYPE_TEXT = "text";
        private static final String KEY_TYPE_VIDEO = "video";
        private static final String KEY_URL = "Url";
        public static final String TAG = "StreamIndex";
        private static final String TAG_STREAM_FRAGMENT = "c";
        private final String baseUri;
        private int displayHeight;
        private int displayWidth;
        private final List<Format> formats = new LinkedList();
        private String language;
        private long lastChunkDuration;
        private int maxHeight;
        private int maxWidth;

        /* renamed from: name  reason: collision with root package name */
        private String f35039name;
        private ArrayList<Long> startTimes;
        private String subType;
        private long timescale;
        private int type;
        private String url;

        public StreamIndexParser(ElementParser elementParser, String str) {
            super(elementParser, str, TAG);
            this.baseUri = str;
        }

        private void parseStreamElementStartTag(XmlPullParser xmlPullParser) throws ParserException {
            int parseType = parseType(xmlPullParser);
            this.type = parseType;
            putNormalizedAttribute(KEY_TYPE, Integer.valueOf(parseType));
            if (this.type == 3) {
                this.subType = parseRequiredString(xmlPullParser, KEY_SUB_TYPE);
            } else {
                this.subType = xmlPullParser.getAttributeValue((String) null, KEY_SUB_TYPE);
            }
            putNormalizedAttribute(KEY_SUB_TYPE, this.subType);
            String attributeValue = xmlPullParser.getAttributeValue((String) null, KEY_NAME);
            this.f35039name = attributeValue;
            putNormalizedAttribute(KEY_NAME, attributeValue);
            this.url = parseRequiredString(xmlPullParser, KEY_URL);
            this.maxWidth = parseInt(xmlPullParser, KEY_MAX_WIDTH, -1);
            this.maxHeight = parseInt(xmlPullParser, KEY_MAX_HEIGHT, -1);
            this.displayWidth = parseInt(xmlPullParser, KEY_DISPLAY_WIDTH, -1);
            this.displayHeight = parseInt(xmlPullParser, KEY_DISPLAY_HEIGHT, -1);
            String attributeValue2 = xmlPullParser.getAttributeValue((String) null, KEY_LANGUAGE);
            this.language = attributeValue2;
            putNormalizedAttribute(KEY_LANGUAGE, attributeValue2);
            long parseInt = (long) parseInt(xmlPullParser, KEY_TIME_SCALE, -1);
            this.timescale = parseInt;
            if (parseInt == -1) {
                this.timescale = ((Long) getNormalizedAttribute(KEY_TIME_SCALE)).longValue();
            }
            this.startTimes = new ArrayList<>();
        }

        private void parseStreamFragmentStartTag(XmlPullParser xmlPullParser) throws ParserException {
            int size = this.startTimes.size();
            long parseLong = parseLong(xmlPullParser, "t", C.TIME_UNSET);
            int i11 = 1;
            if (parseLong == C.TIME_UNSET) {
                if (size == 0) {
                    parseLong = 0;
                } else if (this.lastChunkDuration != -1) {
                    parseLong = this.lastChunkDuration + this.startTimes.get(size - 1).longValue();
                } else {
                    throw ParserException.createForMalformedManifest("Unable to infer start time", (Throwable) null);
                }
            }
            this.startTimes.add(Long.valueOf(parseLong));
            this.lastChunkDuration = parseLong(xmlPullParser, "d", C.TIME_UNSET);
            long parseLong2 = parseLong(xmlPullParser, KEY_FRAGMENT_REPEAT_COUNT, 1);
            if (parseLong2 <= 1 || this.lastChunkDuration != C.TIME_UNSET) {
                while (true) {
                    long j11 = (long) i11;
                    if (j11 < parseLong2) {
                        this.startTimes.add(Long.valueOf((this.lastChunkDuration * j11) + parseLong));
                        i11++;
                    } else {
                        return;
                    }
                }
            } else {
                throw ParserException.createForMalformedManifest("Repeated chunk with unspecified duration", (Throwable) null);
            }
        }

        private int parseType(XmlPullParser xmlPullParser) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, KEY_TYPE);
            if (attributeValue == null) {
                throw new MissingFieldException(KEY_TYPE);
            } else if ("audio".equalsIgnoreCase(attributeValue)) {
                return 1;
            } else {
                if ("video".equalsIgnoreCase(attributeValue)) {
                    return 2;
                }
                if ("text".equalsIgnoreCase(attributeValue)) {
                    return 3;
                }
                throw ParserException.createForMalformedManifest("Invalid key value[" + attributeValue + "]", (Throwable) null);
            }
        }

        public void addChild(Object obj) {
            if (obj instanceof Format) {
                this.formats.add((Format) obj);
            }
        }

        public Object build() {
            Format[] formatArr = new Format[this.formats.size()];
            this.formats.toArray(formatArr);
            SsManifest.StreamElement streamElement = r2;
            SsManifest.StreamElement streamElement2 = new SsManifest.StreamElement(this.baseUri, this.url, this.type, this.subType, this.timescale, this.f35039name, this.maxWidth, this.maxHeight, this.displayWidth, this.displayHeight, this.language, formatArr, this.startTimes, this.lastChunkDuration);
            return streamElement;
        }

        public boolean handleChildInline(String str) {
            return "c".equals(str);
        }

        public void parseStartTag(XmlPullParser xmlPullParser) throws ParserException {
            if ("c".equals(xmlPullParser.getName())) {
                parseStreamFragmentStartTag(xmlPullParser);
            } else {
                parseStreamElementStartTag(xmlPullParser);
            }
        }
    }

    public SsManifestParser() {
        try {
            this.xmlParserFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e11) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e11);
        }
    }

    public SsManifest parse(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
            newPullParser.setInput(inputStream, (String) null);
            return (SsManifest) new SmoothStreamingMediaParser((ElementParser) null, uri.toString()).parse(newPullParser);
        } catch (XmlPullParserException e11) {
            throw ParserException.createForMalformedManifest((String) null, e11);
        }
    }
}
