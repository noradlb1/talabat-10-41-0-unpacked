package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeTracer;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.location.nlp.network.OnlineLocationService;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public class DashManifestParser extends DefaultHandler implements ParsingLoadable.Parser<DashManifest> {
    private static final Pattern CEA_608_ACCESSIBILITY_PATTERN = Pattern.compile("CC([1-4])=.*");
    private static final Pattern CEA_708_ACCESSIBILITY_PATTERN = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    private static final Pattern FRAME_RATE_PATTERN = Pattern.compile("(\\d+)(?:/(\\d+))?");
    private static final int[] MPEG_CHANNEL_CONFIGURATION_MAPPING = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};
    private static final String TAG = "MpdParser";
    private final XmlPullParserFactory xmlParserFactory;

    public static final class RepresentationInfo {
        public final ImmutableList<BaseUrl> baseUrls;
        public final ArrayList<DrmInitData.SchemeData> drmSchemeDatas;
        @Nullable
        public final String drmSchemeType;
        public final List<Descriptor> essentialProperties;
        public final Format format;
        public final ArrayList<Descriptor> inbandEventStreams;
        public final long revisionId;
        public final SegmentBase segmentBase;
        public final List<Descriptor> supplementalProperties;

        public RepresentationInfo(Format format2, List<BaseUrl> list, SegmentBase segmentBase2, @Nullable String str, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2, List<Descriptor> list2, List<Descriptor> list3, long j11) {
            this.format = format2;
            this.baseUrls = ImmutableList.copyOf(list);
            this.segmentBase = segmentBase2;
            this.drmSchemeType = str;
            this.drmSchemeDatas = arrayList;
            this.inbandEventStreams = arrayList2;
            this.essentialProperties = list2;
            this.supplementalProperties = list3;
            this.revisionId = j11;
        }
    }

    public DashManifestParser() {
        try {
            this.xmlParserFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e11) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e11);
        }
    }

    private long addSegmentTimelineElementsToList(List<SegmentBase.SegmentTimelineElement> list, long j11, long j12, int i11, long j13) {
        int i12;
        if (i11 >= 0) {
            i12 = i11 + 1;
        } else {
            i12 = (int) Util.ceilDivide(j13 - j11, j12);
        }
        for (int i13 = 0; i13 < i12; i13++) {
            list.add(buildSegmentTimelineElement(j11, j12));
            j11 += j12;
        }
        return j11;
    }

    private static int checkContentTypeConsistency(int i11, int i12) {
        if (i11 == -1) {
            return i12;
        }
        if (i12 == -1) {
            return i11;
        }
        Assertions.checkState(i11 == i12);
        return i11;
    }

    @Nullable
    private static String checkLanguageConsistency(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        Assertions.checkState(str.equals(str2));
        return str;
    }

    private static void fillInClearKeyInformation(ArrayList<DrmInitData.SchemeData> arrayList) {
        String str;
        int i11 = 0;
        while (true) {
            if (i11 >= arrayList.size()) {
                str = null;
                break;
            }
            DrmInitData.SchemeData schemeData = arrayList.get(i11);
            if (C.CLEARKEY_UUID.equals(schemeData.uuid) && (str = schemeData.licenseServerUrl) != null) {
                arrayList.remove(i11);
                break;
            }
            i11++;
        }
        if (str != null) {
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                DrmInitData.SchemeData schemeData2 = arrayList.get(i12);
                if (C.COMMON_PSSH_UUID.equals(schemeData2.uuid) && schemeData2.licenseServerUrl == null) {
                    arrayList.set(i12, new DrmInitData.SchemeData(C.CLEARKEY_UUID, str, schemeData2.mimeType, schemeData2.data));
                }
            }
        }
    }

    private static void filterRedundantIncompleteSchemeDatas(ArrayList<DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.hasData()) {
                int i11 = 0;
                while (true) {
                    if (i11 >= arrayList.size()) {
                        break;
                    } else if (arrayList.get(i11).canReplace(schemeData)) {
                        arrayList.remove(size);
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        }
    }

    private static long getFinalAvailabilityTimeOffset(long j11, long j12) {
        if (j12 != C.TIME_UNSET) {
            j11 = j12;
        }
        return j11 == Long.MAX_VALUE ? C.TIME_UNSET : j11;
    }

    @Nullable
    private static String getSampleMimeType(@Nullable String str, @Nullable String str2) {
        if (MimeTypes.isAudio(str)) {
            return MimeTypes.getAudioMediaMimeType(str2);
        }
        if (MimeTypes.isVideo(str)) {
            return MimeTypes.getVideoMediaMimeType(str2);
        }
        if (MimeTypes.isText(str) || MimeTypes.isImage(str)) {
            return str;
        }
        if (!MimeTypes.APPLICATION_MP4.equals(str)) {
            return null;
        }
        String mediaMimeType = MimeTypes.getMediaMimeType(str2);
        if (MimeTypes.TEXT_VTT.equals(mediaMimeType)) {
            return MimeTypes.APPLICATION_MP4VTT;
        }
        return mediaMimeType;
    }

    private boolean isDvbProfileDeclared(String[] strArr) {
        for (String startsWith : strArr) {
            if (startsWith.startsWith("urn:dvb:dash:profile:dvb-dash:")) {
                return true;
            }
        }
        return false;
    }

    public static void maybeSkipTag(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (XmlPullParserUtil.isStartTag(xmlPullParser)) {
            int i11 = 1;
            while (i11 != 0) {
                xmlPullParser.next();
                if (XmlPullParserUtil.isStartTag(xmlPullParser)) {
                    i11++;
                } else if (XmlPullParserUtil.isEndTag(xmlPullParser)) {
                    i11--;
                }
            }
        }
    }

    public static int parseCea608AccessibilityChannel(List<Descriptor> list) {
        String str;
        for (int i11 = 0; i11 < list.size(); i11++) {
            Descriptor descriptor = list.get(i11);
            if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri) && (str = descriptor.value) != null) {
                Matcher matcher = CEA_608_ACCESSIBILITY_PATTERN.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.w(TAG, "Unable to parse CEA-608 channel number from: " + descriptor.value);
            }
        }
        return -1;
    }

    public static int parseCea708AccessibilityChannel(List<Descriptor> list) {
        String str;
        for (int i11 = 0; i11 < list.size(); i11++) {
            Descriptor descriptor = list.get(i11);
            if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.schemeIdUri) && (str = descriptor.value) != null) {
                Matcher matcher = CEA_708_ACCESSIBILITY_PATTERN.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.w(TAG, "Unable to parse CEA-708 service block number from: " + descriptor.value);
            }
        }
        return -1;
    }

    public static long parseDateTime(XmlPullParser xmlPullParser, String str, long j11) throws ParserException {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return j11;
        }
        return Util.parseXsDateTime(attributeValue);
    }

    public static Descriptor parseDescriptor(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String parseString = parseString(xmlPullParser, "schemeIdUri", "");
        String parseString2 = parseString(xmlPullParser, "value", (String) null);
        String parseString3 = parseString(xmlPullParser, "id", (String) null);
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, str));
        return new Descriptor(parseString, parseString2, parseString3);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int parseDolbyChannelConfiguration(org.xmlpull.v1.XmlPullParser r4) {
        /*
            r0 = 0
            java.lang.String r1 = "value"
            java.lang.String r4 = r4.getAttributeValue(r0, r1)
            r0 = -1
            if (r4 != 0) goto L_0x000b
            return r0
        L_0x000b:
            java.lang.String r4 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r4)
            r4.hashCode()
            int r1 = r4.hashCode()
            r2 = 2
            r3 = 1
            switch(r1) {
                case 1596796: goto L_0x003e;
                case 2937391: goto L_0x0033;
                case 3094035: goto L_0x0028;
                case 3133436: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            r4 = r0
            goto L_0x0048
        L_0x001d:
            java.lang.String r1 = "fa01"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0026
            goto L_0x001b
        L_0x0026:
            r4 = 3
            goto L_0x0048
        L_0x0028:
            java.lang.String r1 = "f801"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0031
            goto L_0x001b
        L_0x0031:
            r4 = r2
            goto L_0x0048
        L_0x0033:
            java.lang.String r1 = "a000"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x003c
            goto L_0x001b
        L_0x003c:
            r4 = r3
            goto L_0x0048
        L_0x003e:
            java.lang.String r1 = "4000"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0047
            goto L_0x001b
        L_0x0047:
            r4 = 0
        L_0x0048:
            switch(r4) {
                case 0: goto L_0x0052;
                case 1: goto L_0x0051;
                case 2: goto L_0x004f;
                case 3: goto L_0x004c;
                default: goto L_0x004b;
            }
        L_0x004b:
            return r0
        L_0x004c:
            r4 = 8
            return r4
        L_0x004f:
            r4 = 6
            return r4
        L_0x0051:
            return r2
        L_0x0052:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseDolbyChannelConfiguration(org.xmlpull.v1.XmlPullParser):int");
    }

    public static int parseDtsChannelConfiguration(XmlPullParser xmlPullParser) {
        int parseInt = parseInt(xmlPullParser, "value", -1);
        if (parseInt <= 0 || parseInt >= 33) {
            return -1;
        }
        return parseInt;
    }

    public static int parseDtsxChannelConfiguration(XmlPullParser xmlPullParser) {
        int bitCount;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "value");
        if (attributeValue == null || (bitCount = Integer.bitCount(Integer.parseInt(attributeValue, 16))) == 0) {
            return -1;
        }
        return bitCount;
    }

    public static long parseDuration(XmlPullParser xmlPullParser, String str, long j11) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return j11;
        }
        return Util.parseXsDuration(attributeValue);
    }

    public static String parseEac3SupplementalProperties(List<Descriptor> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            Descriptor descriptor = list.get(i11);
            String str = descriptor.schemeIdUri;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(descriptor.value)) {
                return MimeTypes.AUDIO_E_AC3_JOC;
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && MimeTypes.CODEC_E_AC3_JOC.equals(descriptor.value)) {
                return MimeTypes.AUDIO_E_AC3_JOC;
            }
        }
        return MimeTypes.AUDIO_E_AC3;
    }

    public static float parseFloat(XmlPullParser xmlPullParser, String str, float f11) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return f11;
        }
        return Float.parseFloat(attributeValue);
    }

    public static float parseFrameRate(XmlPullParser xmlPullParser, float f11) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "frameRate");
        if (attributeValue == null) {
            return f11;
        }
        Matcher matcher = FRAME_RATE_PATTERN.matcher(attributeValue);
        if (!matcher.matches()) {
            return f11;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        String group = matcher.group(2);
        if (!TextUtils.isEmpty(group)) {
            return ((float) parseInt) / ((float) Integer.parseInt(group));
        }
        return (float) parseInt;
    }

    public static int parseInt(XmlPullParser xmlPullParser, String str, int i11) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return i11;
        }
        return Integer.parseInt(attributeValue);
    }

    public static long parseLastSegmentNumberSupplementalProperty(List<Descriptor> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            Descriptor descriptor = list.get(i11);
            if (Ascii.equalsIgnoreCase("http://dashif.org/guidelines/last-segment-number", descriptor.schemeIdUri)) {
                return Long.parseLong(descriptor.value);
            }
        }
        return -1;
    }

    public static long parseLong(XmlPullParser xmlPullParser, String str, long j11) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return j11;
        }
        return Long.parseLong(attributeValue);
    }

    public static int parseMpegChannelConfiguration(XmlPullParser xmlPullParser) {
        int parseInt = parseInt(xmlPullParser, "value", -1);
        if (parseInt < 0) {
            return -1;
        }
        int[] iArr = MPEG_CHANNEL_CONFIGURATION_MAPPING;
        if (parseInt < iArr.length) {
            return iArr[parseInt];
        }
        return -1;
    }

    public static String parseString(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    public static String parseText(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String str2 = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                str2 = xmlPullParser.getText();
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, str));
        return str2;
    }

    public AdaptationSet buildAdaptationSet(int i11, int i12, List<Representation> list, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
        return new AdaptationSet(i11, i12, list, list2, list3, list4);
    }

    public EventMessage buildEvent(String str, String str2, long j11, long j12, byte[] bArr) {
        return new EventMessage(str, str2, j12, j11, bArr);
    }

    public EventStream buildEventStream(String str, String str2, long j11, long[] jArr, EventMessage[] eventMessageArr) {
        return new EventStream(str, str2, j11, jArr, eventMessageArr);
    }

    public Format buildFormat(@Nullable String str, @Nullable String str2, int i11, int i12, float f11, int i13, int i14, int i15, @Nullable String str3, List<Descriptor> list, List<Descriptor> list2, @Nullable String str4, List<Descriptor> list3, List<Descriptor> list4) {
        int i16;
        int i17;
        String str5 = str2;
        int i18 = i11;
        int i19 = i12;
        List<Descriptor> list5 = list;
        List<Descriptor> list6 = list3;
        String str6 = str4;
        String sampleMimeType = getSampleMimeType(str2, str6);
        if (MimeTypes.AUDIO_E_AC3.equals(sampleMimeType)) {
            sampleMimeType = parseEac3SupplementalProperties(list4);
            if (MimeTypes.AUDIO_E_AC3_JOC.equals(sampleMimeType)) {
                str6 = MimeTypes.CODEC_E_AC3_JOC;
            }
        }
        int parseSelectionFlagsFromRoleDescriptors = parseSelectionFlagsFromRoleDescriptors(list5);
        int parseRoleFlagsFromRoleDescriptors = parseRoleFlagsFromRoleDescriptors(list5) | parseRoleFlagsFromAccessibilityDescriptors(list2) | parseRoleFlagsFromProperties(list6) | parseRoleFlagsFromProperties(list4);
        Pair<Integer, Integer> parseTileCountFromProperties = parseTileCountFromProperties(list6);
        String str7 = str;
        Format.Builder language = new Format.Builder().setId(str).setContainerMimeType(str2).setSampleMimeType(sampleMimeType).setCodecs(str6).setPeakBitrate(i15).setSelectionFlags(parseSelectionFlagsFromRoleDescriptors).setRoleFlags(parseRoleFlagsFromRoleDescriptors).setLanguage(str3);
        int i21 = -1;
        if (parseTileCountFromProperties != null) {
            i16 = ((Integer) parseTileCountFromProperties.first).intValue();
        } else {
            i16 = -1;
        }
        Format.Builder tileCountHorizontal = language.setTileCountHorizontal(i16);
        if (parseTileCountFromProperties != null) {
            i17 = ((Integer) parseTileCountFromProperties.second).intValue();
        } else {
            i17 = -1;
        }
        Format.Builder tileCountVertical = tileCountHorizontal.setTileCountVertical(i17);
        if (MimeTypes.isVideo(sampleMimeType)) {
            tileCountVertical.setWidth(i11).setHeight(i19).setFrameRate(f11);
        } else if (MimeTypes.isAudio(sampleMimeType)) {
            tileCountVertical.setChannelCount(i13).setSampleRate(i14);
        } else if (MimeTypes.isText(sampleMimeType)) {
            if (MimeTypes.APPLICATION_CEA608.equals(sampleMimeType)) {
                i21 = parseCea608AccessibilityChannel(list2);
            } else if (MimeTypes.APPLICATION_CEA708.equals(sampleMimeType)) {
                i21 = parseCea708AccessibilityChannel(list2);
            }
            tileCountVertical.setAccessibilityChannel(i21);
        } else if (MimeTypes.isImage(sampleMimeType)) {
            tileCountVertical.setWidth(i11).setHeight(i19);
        }
        return tileCountVertical.build();
    }

    public DashManifest buildMediaPresentationDescription(long j11, long j12, long j13, boolean z11, long j14, long j15, long j16, long j17, @Nullable ProgramInformation programInformation, @Nullable UtcTimingElement utcTimingElement, @Nullable ServiceDescriptionElement serviceDescriptionElement, @Nullable Uri uri, List<Period> list) {
        return new DashManifest(j11, j12, j13, z11, j14, j15, j16, j17, programInformation, utcTimingElement, serviceDescriptionElement, uri, list);
    }

    public Period buildPeriod(@Nullable String str, long j11, List<AdaptationSet> list, List<EventStream> list2, @Nullable Descriptor descriptor) {
        return new Period(str, j11, list, list2, descriptor);
    }

    public RangedUri buildRangedUri(String str, long j11, long j12) {
        return new RangedUri(str, j11, j12);
    }

    public Representation buildRepresentation(RepresentationInfo representationInfo, @Nullable String str, @Nullable String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2) {
        Format.Builder buildUpon = representationInfo.format.buildUpon();
        if (str != null) {
            buildUpon.setLabel(str);
        }
        String str3 = representationInfo.drmSchemeType;
        if (str3 != null) {
            str2 = str3;
        }
        ArrayList<DrmInitData.SchemeData> arrayList3 = representationInfo.drmSchemeDatas;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            fillInClearKeyInformation(arrayList3);
            filterRedundantIncompleteSchemeDatas(arrayList3);
            buildUpon.setDrmInitData(new DrmInitData(str2, (List<DrmInitData.SchemeData>) arrayList3));
        }
        ArrayList<Descriptor> arrayList4 = representationInfo.inbandEventStreams;
        arrayList4.addAll(arrayList2);
        return Representation.newInstance(representationInfo.revisionId, buildUpon.build(), representationInfo.baseUrls, representationInfo.segmentBase, arrayList4, representationInfo.essentialProperties, representationInfo.supplementalProperties, (String) null);
    }

    public SegmentBase.SegmentList buildSegmentList(RangedUri rangedUri, long j11, long j12, long j13, long j14, @Nullable List<SegmentBase.SegmentTimelineElement> list, long j15, @Nullable List<RangedUri> list2, long j16, long j17) {
        return new SegmentBase.SegmentList(rangedUri, j11, j12, j13, j14, list, j15, list2, Util.msToUs(j16), Util.msToUs(j17));
    }

    public SegmentBase.SegmentTemplate buildSegmentTemplate(RangedUri rangedUri, long j11, long j12, long j13, long j14, long j15, List<SegmentBase.SegmentTimelineElement> list, long j16, @Nullable UrlTemplate urlTemplate, @Nullable UrlTemplate urlTemplate2, long j17, long j18) {
        return new SegmentBase.SegmentTemplate(rangedUri, j11, j12, j13, j14, j15, list, j16, urlTemplate, urlTemplate2, Util.msToUs(j17), Util.msToUs(j18));
    }

    public SegmentBase.SegmentTimelineElement buildSegmentTimelineElement(long j11, long j12) {
        return new SegmentBase.SegmentTimelineElement(j11, j12);
    }

    public SegmentBase.SingleSegmentBase buildSingleSegmentBase(RangedUri rangedUri, long j11, long j12, long j13, long j14) {
        return new SegmentBase.SingleSegmentBase(rangedUri, j11, j12, j13, j14);
    }

    public UtcTimingElement buildUtcTimingElement(String str, String str2) {
        return new UtcTimingElement(str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x030e A[LOOP:0: B:1:0x007c->B:69:0x030e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02ce A[EDGE_INSN: B:70:0x02ce->B:63:0x02ce ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.manifest.AdaptationSet parseAdaptationSet(org.xmlpull.v1.XmlPullParser r55, java.util.List<com.google.android.exoplayer2.source.dash.manifest.BaseUrl> r56, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.SegmentBase r57, long r58, long r60, long r62, long r64, long r66, boolean r68) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r54 = this;
            r15 = r54
            r14 = r55
            java.lang.String r0 = "id"
            r1 = -1
            int r27 = parseInt(r14, r0, r1)
            int r0 = r54.parseContentType(r55)
            java.lang.String r2 = "mimeType"
            r13 = 0
            java.lang.String r28 = r14.getAttributeValue(r13, r2)
            java.lang.String r2 = "codecs"
            java.lang.String r29 = r14.getAttributeValue(r13, r2)
            java.lang.String r2 = "width"
            int r30 = parseInt(r14, r2, r1)
            java.lang.String r2 = "height"
            int r31 = parseInt(r14, r2, r1)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r32 = parseFrameRate(r14, r2)
            java.lang.String r2 = "audioSamplingRate"
            int r33 = parseInt(r14, r2, r1)
            java.lang.String r12 = "lang"
            java.lang.String r2 = r14.getAttributeValue(r13, r12)
            java.lang.String r3 = "label"
            java.lang.String r3 = r14.getAttributeValue(r13, r3)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r34 = 0
            r35 = r57
            r36 = r0
            r37 = r1
            r38 = r2
            r39 = r3
            r41 = r13
            r40 = r34
            r2 = r60
            r0 = r62
        L_0x007c:
            r55.next()
            java.lang.String r13 = "BaseURL"
            boolean r13 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r13)
            if (r13 == 0) goto L_0x00bb
            if (r40 != 0) goto L_0x008f
            long r2 = r15.parseAvailabilityTimeOffsetUs(r14, r2)
            r40 = 1
        L_0x008f:
            r13 = r56
            r60 = r0
            r17 = r10
            r10 = r68
            java.util.List r0 = r15.parseBaseUrl(r14, r13, r10)
            r4.addAll(r0)
        L_0x009e:
            r0 = r60
            r42 = r2
            r15 = r5
            r45 = r7
            r46 = r8
            r47 = r9
            r49 = r11
            r50 = r12
            r3 = r17
            r51 = r36
            r53 = r38
            r52 = 0
            r36 = r4
            r38 = r6
            goto L_0x02c6
        L_0x00bb:
            r13 = r56
            r60 = r0
            r17 = r10
            r10 = r68
            java.lang.String r0 = "ContentProtection"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x00e1
            android.util.Pair r0 = r54.parseContentProtection(r55)
            java.lang.Object r1 = r0.first
            if (r1 == 0) goto L_0x00d7
            r41 = r1
            java.lang.String r41 = (java.lang.String) r41
        L_0x00d7:
            java.lang.Object r0 = r0.second
            if (r0 == 0) goto L_0x009e
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r0 = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData) r0
            r11.add(r0)
            goto L_0x009e
        L_0x00e1:
            java.lang.String r0 = "ContentComponent"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x011b
            r1 = 0
            java.lang.String r0 = r14.getAttributeValue(r1, r12)
            r15 = r38
            java.lang.String r0 = checkLanguageConsistency(r15, r0)
            int r15 = r54.parseContentType(r55)
            r13 = r36
            int r13 = checkContentTypeConsistency(r13, r15)
            r53 = r0
            r52 = r1
            r42 = r2
            r36 = r4
            r15 = r5
            r38 = r6
            r45 = r7
            r46 = r8
            r47 = r9
            r49 = r11
            r50 = r12
            r51 = r13
            r3 = r17
        L_0x0117:
            r0 = r60
            goto L_0x02c6
        L_0x011b:
            r13 = r36
            r15 = r38
            r1 = 0
            java.lang.String r0 = "Role"
            boolean r16 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r16 == 0) goto L_0x0130
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r0 = parseDescriptor(r14, r0)
            r8.add(r0)
            goto L_0x013e
        L_0x0130:
            java.lang.String r0 = "AudioChannelConfiguration"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x015b
            int r0 = r54.parseAudioChannelConfiguration(r55)
            r37 = r0
        L_0x013e:
            r52 = r1
            r42 = r2
            r36 = r4
            r38 = r6
            r45 = r7
            r46 = r8
            r47 = r9
            r49 = r11
            r50 = r12
            r51 = r13
            r53 = r15
            r3 = r17
            r0 = r60
            r15 = r5
            goto L_0x02c6
        L_0x015b:
            java.lang.String r0 = "Accessibility"
            boolean r16 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r16 == 0) goto L_0x016b
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r0 = parseDescriptor(r14, r0)
            r9.add(r0)
            goto L_0x013e
        L_0x016b:
            java.lang.String r0 = "EssentialProperty"
            boolean r16 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r16 == 0) goto L_0x017b
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r0 = parseDescriptor(r14, r0)
            r7.add(r0)
            goto L_0x013e
        L_0x017b:
            java.lang.String r0 = "SupplementalProperty"
            boolean r16 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r16 == 0) goto L_0x018b
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r0 = parseDescriptor(r14, r0)
            r6.add(r0)
            goto L_0x013e
        L_0x018b:
            java.lang.String r0 = "Representation"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x0204
            boolean r0 = r4.isEmpty()
            if (r0 != 0) goto L_0x019c
            r16 = r4
            goto L_0x019e
        L_0x019c:
            r16 = r56
        L_0x019e:
            r0 = r54
            r18 = r1
            r1 = r55
            r42 = r2
            r2 = r16
            r3 = r28
            r36 = r4
            r4 = r29
            r44 = r5
            r5 = r30
            r38 = r6
            r6 = r31
            r45 = r7
            r7 = r32
            r46 = r8
            r8 = r37
            r47 = r9
            r9 = r33
            r48 = r17
            r10 = r15
            r49 = r11
            r11 = r46
            r50 = r12
            r12 = r47
            r51 = r13
            r52 = r18
            r13 = r45
            r14 = r38
            r53 = r15
            r15 = r35
            r16 = r64
            r18 = r58
            r20 = r42
            r22 = r60
            r24 = r66
            r26 = r68
            com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo r0 = r0.parseRepresentation(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r20, r22, r24, r26)
            com.google.android.exoplayer2.Format r1 = r0.format
            java.lang.String r1 = r1.sampleMimeType
            int r1 = com.google.android.exoplayer2.util.MimeTypes.getTrackType(r1)
            r14 = r51
            int r1 = checkContentTypeConsistency(r14, r1)
            r15 = r44
            r15.add(r0)
            r14 = r55
            r51 = r1
            r3 = r48
            goto L_0x0117
        L_0x0204:
            r52 = r1
            r42 = r2
            r36 = r4
            r38 = r6
            r45 = r7
            r46 = r8
            r47 = r9
            r49 = r11
            r50 = r12
            r14 = r13
            r53 = r15
            r48 = r17
            r15 = r5
            java.lang.String r0 = "SegmentBase"
            r13 = r55
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r13, r0)
            if (r0 == 0) goto L_0x023b
            r0 = r35
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r0 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase) r0
            r11 = r54
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r0 = r11.parseSegmentBase(r13, r0)
            r35 = r0
            r51 = r14
            r3 = r48
            r0 = r60
            r14 = r13
            goto L_0x02c6
        L_0x023b:
            r11 = r54
            java.lang.String r0 = "SegmentList"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r13, r0)
            if (r0 == 0) goto L_0x026c
            r0 = r60
            long r16 = r11.parseAvailabilityTimeOffsetUs(r13, r0)
            r2 = r35
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentList r2 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList) r2
            r0 = r54
            r1 = r55
            r3 = r64
            r5 = r58
            r7 = r42
            r9 = r16
            r51 = r14
            r14 = r11
            r11 = r66
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentList r0 = r0.parseSegmentList(r1, r2, r3, r5, r7, r9, r11)
            r35 = r0
            r14 = r13
        L_0x0267:
            r0 = r16
            r3 = r48
            goto L_0x02c6
        L_0x026c:
            r0 = r60
            r51 = r14
            r14 = r11
            java.lang.String r2 = "SegmentTemplate"
            boolean r2 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r13, r2)
            if (r2 == 0) goto L_0x0299
            long r16 = r14.parseAvailabilityTimeOffsetUs(r13, r0)
            r2 = r35
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTemplate r2 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate) r2
            r0 = r54
            r1 = r55
            r3 = r38
            r4 = r64
            r6 = r58
            r8 = r42
            r10 = r16
            r14 = r13
            r12 = r66
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTemplate r0 = r0.parseSegmentTemplate(r1, r2, r3, r4, r6, r8, r10, r12)
            r35 = r0
            goto L_0x0267
        L_0x0299:
            r14 = r13
            java.lang.String r2 = "InbandEventStream"
            boolean r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r2)
            if (r3 == 0) goto L_0x02ac
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r2 = parseDescriptor(r14, r2)
            r3 = r48
            r3.add(r2)
            goto L_0x02c6
        L_0x02ac:
            r3 = r48
            java.lang.String r2 = "Label"
            boolean r2 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r2)
            if (r2 == 0) goto L_0x02bd
            java.lang.String r2 = r54.parseLabel(r55)
            r39 = r2
            goto L_0x02c6
        L_0x02bd:
            boolean r2 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r55)
            if (r2 == 0) goto L_0x02c6
            r54.parseAdaptationSetChild(r55)
        L_0x02c6:
            java.lang.String r2 = "AdaptationSet"
            boolean r2 = com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(r14, r2)
            if (r2 == 0) goto L_0x030e
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r15.size()
            r0.<init>(r1)
            r1 = r34
        L_0x02d9:
            int r2 = r15.size()
            if (r1 >= r2) goto L_0x02fb
            java.lang.Object r2 = r15.get(r1)
            com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo r2 = (com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.RepresentationInfo) r2
            r55 = r54
            r56 = r2
            r57 = r39
            r58 = r41
            r59 = r49
            r60 = r3
            com.google.android.exoplayer2.source.dash.manifest.Representation r2 = r55.buildRepresentation(r56, r57, r58, r59, r60)
            r0.add(r2)
            int r1 = r1 + 1
            goto L_0x02d9
        L_0x02fb:
            r55 = r54
            r56 = r27
            r57 = r51
            r58 = r0
            r59 = r47
            r60 = r45
            r61 = r38
            com.google.android.exoplayer2.source.dash.manifest.AdaptationSet r0 = r55.buildAdaptationSet(r56, r57, r58, r59, r60, r61)
            return r0
        L_0x030e:
            r10 = r3
            r5 = r15
            r4 = r36
            r6 = r38
            r2 = r42
            r7 = r45
            r8 = r46
            r9 = r47
            r11 = r49
            r12 = r50
            r36 = r51
            r13 = r52
            r38 = r53
            r15 = r54
            goto L_0x007c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseAdaptationSet(org.xmlpull.v1.XmlPullParser, java.util.List, com.google.android.exoplayer2.source.dash.manifest.SegmentBase, long, long, long, long, long, boolean):com.google.android.exoplayer2.source.dash.manifest.AdaptationSet");
    }

    public void parseAdaptationSetChild(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        maybeSkipTag(xmlPullParser);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int parseAudioChannelConfiguration(org.xmlpull.v1.XmlPullParser r4) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "schemeIdUri"
            r1 = 0
            java.lang.String r0 = parseString(r4, r0, r1)
            r0.hashCode()
            int r1 = r0.hashCode()
            r2 = -1
            switch(r1) {
                case -2128649360: goto L_0x0056;
                case -1352850286: goto L_0x004b;
                case -1138141449: goto L_0x0040;
                case -986633423: goto L_0x0035;
                case -79006963: goto L_0x002a;
                case 312179081: goto L_0x001f;
                case 2036691300: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            r0 = r2
            goto L_0x0060
        L_0x0014:
            java.lang.String r1 = "urn:dolby:dash:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x001d
            goto L_0x0012
        L_0x001d:
            r0 = 6
            goto L_0x0060
        L_0x001f:
            java.lang.String r1 = "tag:dts.com,2018:uhd:audio_channel_configuration"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0028
            goto L_0x0012
        L_0x0028:
            r0 = 5
            goto L_0x0060
        L_0x002a:
            java.lang.String r1 = "tag:dts.com,2014:dash:audio_channel_configuration:2012"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0033
            goto L_0x0012
        L_0x0033:
            r0 = 4
            goto L_0x0060
        L_0x0035:
            java.lang.String r1 = "urn:mpeg:mpegB:cicp:ChannelConfiguration"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003e
            goto L_0x0012
        L_0x003e:
            r0 = 3
            goto L_0x0060
        L_0x0040:
            java.lang.String r1 = "tag:dolby.com,2014:dash:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0049
            goto L_0x0012
        L_0x0049:
            r0 = 2
            goto L_0x0060
        L_0x004b:
            java.lang.String r1 = "urn:mpeg:dash:23003:3:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0054
            goto L_0x0012
        L_0x0054:
            r0 = 1
            goto L_0x0060
        L_0x0056:
            java.lang.String r1 = "urn:dts:dash:audio_channel_configuration:2012"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x005f
            goto L_0x0012
        L_0x005f:
            r0 = 0
        L_0x0060:
            switch(r0) {
                case 0: goto L_0x007a;
                case 1: goto L_0x0073;
                case 2: goto L_0x006e;
                case 3: goto L_0x0069;
                case 4: goto L_0x007a;
                case 5: goto L_0x0064;
                case 6: goto L_0x006e;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x007e
        L_0x0064:
            int r2 = parseDtsxChannelConfiguration(r4)
            goto L_0x007e
        L_0x0069:
            int r2 = parseMpegChannelConfiguration(r4)
            goto L_0x007e
        L_0x006e:
            int r2 = parseDolbyChannelConfiguration(r4)
            goto L_0x007e
        L_0x0073:
            java.lang.String r0 = "value"
            int r2 = parseInt(r4, r0, r2)
            goto L_0x007e
        L_0x007a:
            int r2 = parseDtsChannelConfiguration(r4)
        L_0x007e:
            r4.next()
            java.lang.String r0 = "AudioChannelConfiguration"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(r4, r0)
            if (r0 == 0) goto L_0x007e
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseAudioChannelConfiguration(org.xmlpull.v1.XmlPullParser):int");
    }

    public long parseAvailabilityTimeOffsetUs(XmlPullParser xmlPullParser, long j11) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j11;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return (long) (Float.parseFloat(attributeValue) * 1000000.0f);
    }

    public List<BaseUrl> parseBaseUrl(XmlPullParser xmlPullParser, List<BaseUrl> list, boolean z11) throws XmlPullParserException, IOException {
        int i11;
        int i12;
        String str;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "dvb:priority");
        if (attributeValue != null) {
            i11 = Integer.parseInt(attributeValue);
        } else if (z11) {
            i11 = 1;
        } else {
            i11 = Integer.MIN_VALUE;
        }
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, "dvb:weight");
        if (attributeValue2 != null) {
            i12 = Integer.parseInt(attributeValue2);
        } else {
            i12 = 1;
        }
        String attributeValue3 = xmlPullParser.getAttributeValue((String) null, "serviceLocation");
        String parseText = parseText(xmlPullParser, "BaseURL");
        if (UriUtil.isAbsolute(parseText)) {
            if (attributeValue3 == null) {
                attributeValue3 = parseText;
            }
            return Lists.newArrayList((E[]) new BaseUrl[]{new BaseUrl(parseText, attributeValue3, i11, i12)});
        }
        ArrayList arrayList = new ArrayList();
        for (int i13 = 0; i13 < list.size(); i13++) {
            BaseUrl baseUrl = list.get(i13);
            String resolve = UriUtil.resolve(baseUrl.url, parseText);
            if (attributeValue3 == null) {
                str = resolve;
            } else {
                str = attributeValue3;
            }
            if (z11) {
                i11 = baseUrl.priority;
                i12 = baseUrl.weight;
                str = baseUrl.serviceLocation;
            }
            arrayList.add(new BaseUrl(resolve, str, i11, i12));
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.util.UUID} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v29, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v30, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v31, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v32, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008a, code lost:
        r0 = null;
        r4 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Pair<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData.SchemeData> parseContentProtection(org.xmlpull.v1.XmlPullParser r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "schemeIdUri"
            r1 = 0
            java.lang.String r0 = r11.getAttributeValue(r1, r0)
            r2 = 0
            if (r0 == 0) goto L_0x0090
            java.lang.String r0 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r0)
            r0.hashCode()
            int r3 = r0.hashCode()
            r4 = -1
            switch(r3) {
                case -1980789791: goto L_0x003b;
                case 489446379: goto L_0x0030;
                case 755418770: goto L_0x0025;
                case 1812765994: goto L_0x001a;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x0045
        L_0x001a:
            java.lang.String r3 = "urn:mpeg:dash:mp4protection:2011"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0023
            goto L_0x0045
        L_0x0023:
            r4 = 3
            goto L_0x0045
        L_0x0025:
            java.lang.String r3 = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x002e
            goto L_0x0045
        L_0x002e:
            r4 = 2
            goto L_0x0045
        L_0x0030:
            java.lang.String r3 = "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0039
            goto L_0x0045
        L_0x0039:
            r4 = 1
            goto L_0x0045
        L_0x003b:
            java.lang.String r3 = "urn:uuid:e2719d58-a985-b3c9-781a-b030af78d30e"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r4 = r2
        L_0x0045:
            switch(r4) {
                case 0: goto L_0x008d;
                case 1: goto L_0x0088;
                case 2: goto L_0x0085;
                case 3: goto L_0x0049;
                default: goto L_0x0048;
            }
        L_0x0048:
            goto L_0x0090
        L_0x0049:
            java.lang.String r0 = "value"
            java.lang.String r0 = r11.getAttributeValue(r1, r0)
            java.lang.String r3 = "default_KID"
            java.lang.String r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValueIgnorePrefix(r11, r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0083
            java.lang.String r4 = "00000000-0000-0000-0000-000000000000"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0083
            java.lang.String r4 = "\\s+"
            java.lang.String[] r3 = r3.split(r4)
            int r4 = r3.length
            java.util.UUID[] r4 = new java.util.UUID[r4]
            r5 = r2
        L_0x006d:
            int r6 = r3.length
            if (r5 >= r6) goto L_0x007b
            r6 = r3[r5]
            java.util.UUID r6 = java.util.UUID.fromString(r6)
            r4[r5] = r6
            int r5 = r5 + 1
            goto L_0x006d
        L_0x007b:
            java.util.UUID r3 = com.google.android.exoplayer2.C.COMMON_PSSH_UUID
            byte[] r4 = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.buildPsshAtom(r3, r4, r1)
            r5 = r1
            goto L_0x0094
        L_0x0083:
            r3 = r1
            goto L_0x0092
        L_0x0085:
            java.util.UUID r3 = com.google.android.exoplayer2.C.WIDEVINE_UUID
            goto L_0x008a
        L_0x0088:
            java.util.UUID r3 = com.google.android.exoplayer2.C.PLAYREADY_UUID
        L_0x008a:
            r0 = r1
            r4 = r0
            goto L_0x0093
        L_0x008d:
            java.util.UUID r3 = com.google.android.exoplayer2.C.CLEARKEY_UUID
            goto L_0x008a
        L_0x0090:
            r0 = r1
            r3 = r0
        L_0x0092:
            r4 = r3
        L_0x0093:
            r5 = r4
        L_0x0094:
            r11.next()
            java.lang.String r6 = "clearkey:Laurl"
            boolean r6 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r11, r6)
            r7 = 4
            if (r6 == 0) goto L_0x00ac
            int r6 = r11.next()
            if (r6 != r7) goto L_0x00ac
            java.lang.String r5 = r11.getText()
            goto L_0x010f
        L_0x00ac:
            java.lang.String r6 = "ms:laurl"
            boolean r6 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r11, r6)
            if (r6 == 0) goto L_0x00bb
            java.lang.String r5 = "licenseUrl"
            java.lang.String r5 = r11.getAttributeValue(r1, r5)
            goto L_0x010f
        L_0x00bb:
            if (r4 != 0) goto L_0x00e7
            java.lang.String r6 = "pssh"
            boolean r6 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTagIgnorePrefix(r11, r6)
            if (r6 == 0) goto L_0x00e7
            int r6 = r11.next()
            if (r6 != r7) goto L_0x00e7
            java.lang.String r3 = r11.getText()
            byte[] r3 = android.util.Base64.decode(r3, r2)
            java.util.UUID r4 = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.parseUuid(r3)
            if (r4 != 0) goto L_0x00e3
            java.lang.String r3 = "MpdParser"
            java.lang.String r6 = "Skipping malformed cenc:pssh data"
            com.google.android.exoplayer2.util.Log.w(r3, r6)
            r3 = r4
            r4 = r1
            goto L_0x010f
        L_0x00e3:
            r9 = r4
            r4 = r3
            r3 = r9
            goto L_0x010f
        L_0x00e7:
            if (r4 != 0) goto L_0x010c
            java.util.UUID r6 = com.google.android.exoplayer2.C.PLAYREADY_UUID
            boolean r8 = r6.equals(r3)
            if (r8 == 0) goto L_0x010c
            java.lang.String r8 = "mspr:pro"
            boolean r8 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r11, r8)
            if (r8 == 0) goto L_0x010c
            int r8 = r11.next()
            if (r8 != r7) goto L_0x010c
            java.lang.String r4 = r11.getText()
            byte[] r4 = android.util.Base64.decode(r4, r2)
            byte[] r4 = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.buildPsshAtom(r6, r4)
            goto L_0x010f
        L_0x010c:
            maybeSkipTag(r11)
        L_0x010f:
            java.lang.String r6 = "ContentProtection"
            boolean r6 = com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(r11, r6)
            if (r6 == 0) goto L_0x0094
            if (r3 == 0) goto L_0x0120
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r1 = new com.google.android.exoplayer2.drm.DrmInitData$SchemeData
            java.lang.String r11 = "video/mp4"
            r1.<init>(r3, r5, r11, r4)
        L_0x0120:
            android.util.Pair r11 = android.util.Pair.create(r0, r1)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseContentProtection(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    public int parseContentType(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if (MimeTypes.BASE_TYPE_AUDIO.equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        if ("text".equals(attributeValue)) {
            return 3;
        }
        if ("image".equals(attributeValue)) {
            return 4;
        }
        return -1;
    }

    public Pair<Long, EventMessage> parseEvent(XmlPullParser xmlPullParser, String str, String str2, long j11, long j12, ByteArrayOutputStream byteArrayOutputStream) throws IOException, XmlPullParserException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        long parseLong = parseLong(xmlPullParser2, "id", 0);
        long parseLong2 = parseLong(xmlPullParser2, "duration", C.TIME_UNSET);
        long parseLong3 = parseLong(xmlPullParser2, "presentationTime", 0);
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(parseLong2, 1000, j11);
        long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(parseLong3 - j12, 1000000, j11);
        String parseString = parseString(xmlPullParser2, "messageData", (String) null);
        byte[] parseEventObject = parseEventObject(xmlPullParser2, byteArrayOutputStream);
        Long valueOf = Long.valueOf(scaleLargeTimestamp2);
        if (parseString != null) {
            parseEventObject = Util.getUtf8Bytes(parseString);
        }
        return Pair.create(valueOf, buildEvent(str, str2, parseLong, scaleLargeTimestamp, parseEventObject));
    }

    public byte[] parseEventObject(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        byteArrayOutputStream.reset();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(byteArrayOutputStream, Charsets.UTF_8.name());
        xmlPullParser.nextToken();
        while (!XmlPullParserUtil.isEndTag(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    newSerializer.startDocument((String) null, Boolean.FALSE);
                    break;
                case 1:
                    newSerializer.endDocument();
                    break;
                case 2:
                    newSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i11 = 0; i11 < xmlPullParser.getAttributeCount(); i11++) {
                        newSerializer.attribute(xmlPullParser.getAttributeNamespace(i11), xmlPullParser.getAttributeName(i11), xmlPullParser.getAttributeValue(i11));
                    }
                    break;
                case 3:
                    newSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    newSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    newSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    newSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    newSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    newSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    newSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    newSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        newSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public EventStream parseEventStream(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        long j11;
        ByteArrayOutputStream byteArrayOutputStream;
        ArrayList arrayList;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String parseString = parseString(xmlPullParser2, "schemeIdUri", "");
        String parseString2 = parseString(xmlPullParser2, "value", "");
        long parseLong = parseLong(xmlPullParser2, "timescale", 1);
        long parseLong2 = parseLong(xmlPullParser2, "presentationTimeOffset", 0);
        ArrayList arrayList2 = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(512);
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Event")) {
                byteArrayOutputStream = byteArrayOutputStream2;
                long j12 = parseLong2;
                j11 = parseLong2;
                arrayList = arrayList2;
                arrayList.add(parseEvent(xmlPullParser, parseString, parseString2, parseLong, j12, byteArrayOutputStream));
            } else {
                byteArrayOutputStream = byteArrayOutputStream2;
                j11 = parseLong2;
                arrayList = arrayList2;
                maybeSkipTag(xmlPullParser);
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser2, "EventStream")) {
                break;
            }
            arrayList2 = arrayList;
            byteArrayOutputStream2 = byteArrayOutputStream;
            parseLong2 = j11;
        }
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            Pair pair = (Pair) arrayList.get(i11);
            jArr[i11] = ((Long) pair.first).longValue();
            eventMessageArr[i11] = (EventMessage) pair.second;
        }
        return buildEventStream(parseString, parseString2, parseLong, jArr, eventMessageArr);
    }

    public RangedUri parseInitialization(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "sourceURL", BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
    }

    public String parseLabel(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return parseText(xmlPullParser, "Label");
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01e7 A[LOOP:0: B:23:0x00a4->B:79:0x01e7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01a3 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.manifest.DashManifest parseMediaPresentationDescription(org.xmlpull.v1.XmlPullParser r47, android.net.Uri r48) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r46 = this;
            r14 = r46
            r12 = r47
            r0 = 0
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.String r2 = "profiles"
            java.lang.String[] r1 = r14.parseProfiles(r12, r2, r1)
            boolean r13 = r14.isDvbProfileDeclared(r1)
            java.lang.String r1 = "availabilityStartTime"
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r15 = parseDateTime(r12, r1, r9)
            java.lang.String r1 = "mediaPresentationDuration"
            long r17 = parseDuration(r12, r1, r9)
            java.lang.String r1 = "minBufferTime"
            long r19 = parseDuration(r12, r1, r9)
            java.lang.String r1 = "type"
            r11 = 0
            java.lang.String r1 = r12.getAttributeValue(r11, r1)
            java.lang.String r2 = "dynamic"
            boolean r21 = r2.equals(r1)
            if (r21 == 0) goto L_0x0040
            java.lang.String r1 = "minimumUpdatePeriod"
            long r1 = parseDuration(r12, r1, r9)
            r22 = r1
            goto L_0x0042
        L_0x0040:
            r22 = r9
        L_0x0042:
            if (r21 == 0) goto L_0x004d
            java.lang.String r1 = "timeShiftBufferDepth"
            long r1 = parseDuration(r12, r1, r9)
            r24 = r1
            goto L_0x004f
        L_0x004d:
            r24 = r9
        L_0x004f:
            if (r21 == 0) goto L_0x005a
            java.lang.String r1 = "suggestedPresentationDelay"
            long r1 = parseDuration(r12, r1, r9)
            r26 = r1
            goto L_0x005c
        L_0x005a:
            r26 = r9
        L_0x005c:
            java.lang.String r1 = "publishTime"
            long r28 = parseDateTime(r12, r1, r9)
            if (r21 == 0) goto L_0x0067
            r3 = 0
            goto L_0x0068
        L_0x0067:
            r3 = r9
        L_0x0068:
            com.google.android.exoplayer2.source.dash.manifest.BaseUrl r5 = new com.google.android.exoplayer2.source.dash.manifest.BaseUrl
            java.lang.String r6 = r48.toString()
            java.lang.String r7 = r48.toString()
            r8 = 1
            if (r13 == 0) goto L_0x0077
            r1 = r8
            goto L_0x007b
        L_0x0077:
            r30 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r30
        L_0x007b:
            r5.<init>(r6, r7, r1, r8)
            com.google.android.exoplayer2.source.dash.manifest.BaseUrl[] r1 = new com.google.android.exoplayer2.source.dash.manifest.BaseUrl[r8]
            r1[r0] = r5
            java.util.ArrayList r7 = com.google.common.collect.Lists.newArrayList((E[]) r1)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            if (r21 == 0) goto L_0x0094
            r1 = r9
            goto L_0x0096
        L_0x0094:
            r1 = 0
        L_0x0096:
            r30 = r0
            r31 = r30
            r32 = r1
            r34 = r11
            r35 = r34
            r36 = r35
            r37 = r36
        L_0x00a4:
            r47.next()
            java.lang.String r0 = "BaseURL"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r12, r0)
            if (r0 == 0) goto L_0x00bf
            if (r30 != 0) goto L_0x00b7
            long r3 = r14.parseAvailabilityTimeOffsetUs(r12, r3)
            r30 = r8
        L_0x00b7:
            java.util.List r0 = r14.parseBaseUrl(r12, r7, r13)
            r6.addAll(r0)
            goto L_0x00cd
        L_0x00bf:
            java.lang.String r0 = "ProgramInformation"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r12, r0)
            if (r0 == 0) goto L_0x00d9
            com.google.android.exoplayer2.source.dash.manifest.ProgramInformation r0 = r46.parseProgramInformation(r47)
            r34 = r0
        L_0x00cd:
            r41 = r6
            r43 = r7
            r42 = r8
            r44 = r9
            r14 = r11
            r11 = r5
            goto L_0x019b
        L_0x00d9:
            java.lang.String r0 = "UTCTiming"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r12, r0)
            if (r0 == 0) goto L_0x00e8
            com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement r0 = r46.parseUtcTiming(r47)
            r35 = r0
            goto L_0x00cd
        L_0x00e8:
            java.lang.String r0 = "Location"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r12, r0)
            if (r0 == 0) goto L_0x00ff
            java.lang.String r0 = r48.toString()
            java.lang.String r1 = r47.nextText()
            android.net.Uri r0 = com.google.android.exoplayer2.util.UriUtil.resolveToUri(r0, r1)
            r36 = r0
            goto L_0x00cd
        L_0x00ff:
            java.lang.String r0 = "ServiceDescription"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r12, r0)
            if (r0 == 0) goto L_0x010e
            com.google.android.exoplayer2.source.dash.manifest.ServiceDescriptionElement r0 = r46.parseServiceDescription(r47)
            r37 = r0
            goto L_0x00cd
        L_0x010e:
            java.lang.String r0 = "Period"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r12, r0)
            if (r0 == 0) goto L_0x018a
            if (r31 != 0) goto L_0x018a
            boolean r0 = r6.isEmpty()
            if (r0 != 0) goto L_0x0120
            r2 = r6
            goto L_0x0121
        L_0x0120:
            r2 = r7
        L_0x0121:
            r0 = r46
            r1 = r47
            r38 = r3
            r3 = r32
            r40 = r5
            r41 = r6
            r5 = r38
            r43 = r7
            r42 = r8
            r7 = r15
            r44 = r9
            r9 = r24
            r14 = r11
            r11 = r13
            android.util.Pair r0 = r0.parsePeriod(r1, r2, r3, r5, r7, r9, r11)
            java.lang.Object r1 = r0.first
            com.google.android.exoplayer2.source.dash.manifest.Period r1 = (com.google.android.exoplayer2.source.dash.manifest.Period) r1
            long r2 = r1.startMs
            int r2 = (r2 > r44 ? 1 : (r2 == r44 ? 0 : -1))
            if (r2 != 0) goto L_0x0169
            if (r21 == 0) goto L_0x014f
            r11 = r40
            r8 = r42
            goto L_0x0187
        L_0x014f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unable to determine start of period "
            r0.append(r1)
            int r1 = r40.size()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r0, r14)
            throw r0
        L_0x0169:
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r2 = r0.longValue()
            int r0 = (r2 > r44 ? 1 : (r2 == r44 ? 0 : -1))
            if (r0 != 0) goto L_0x017a
            r11 = r40
            r9 = r44
            goto L_0x0180
        L_0x017a:
            long r4 = r1.startMs
            long r9 = r4 + r2
            r11 = r40
        L_0x0180:
            r11.add(r1)
            r32 = r9
            r8 = r31
        L_0x0187:
            r31 = r8
            goto L_0x0199
        L_0x018a:
            r38 = r3
            r41 = r6
            r43 = r7
            r42 = r8
            r44 = r9
            r14 = r11
            r11 = r5
            maybeSkipTag(r47)
        L_0x0199:
            r3 = r38
        L_0x019b:
            java.lang.String r0 = "MPD"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(r12, r0)
            if (r0 == 0) goto L_0x01e7
            int r0 = (r17 > r44 ? 1 : (r17 == r44 ? 0 : -1))
            if (r0 != 0) goto L_0x01b8
            int r0 = (r32 > r44 ? 1 : (r32 == r44 ? 0 : -1))
            if (r0 == 0) goto L_0x01ae
            r3 = r32
            goto L_0x01ba
        L_0x01ae:
            if (r21 == 0) goto L_0x01b1
            goto L_0x01b8
        L_0x01b1:
            java.lang.String r0 = "Unable to determine duration of static manifest."
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r0, r14)
            throw r0
        L_0x01b8:
            r3 = r17
        L_0x01ba:
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x01e0
            r0 = r46
            r1 = r15
            r5 = r19
            r7 = r21
            r8 = r22
            r38 = r11
            r10 = r24
            r12 = r26
            r14 = r28
            r16 = r34
            r17 = r35
            r18 = r37
            r19 = r36
            r20 = r38
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r0 = r0.buildMediaPresentationDescription(r1, r3, r5, r7, r8, r10, r12, r14, r16, r17, r18, r19, r20)
            return r0
        L_0x01e0:
            java.lang.String r0 = "No periods found."
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r0, r14)
            throw r0
        L_0x01e7:
            r5 = r11
            r11 = r14
            r6 = r41
            r8 = r42
            r7 = r43
            r9 = r44
            r14 = r46
            goto L_0x00a4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseMediaPresentationDescription(org.xmlpull.v1.XmlPullParser, android.net.Uri):com.google.android.exoplayer2.source.dash.manifest.DashManifest");
    }

    public Pair<Period, Long> parsePeriod(XmlPullParser xmlPullParser, List<BaseUrl> list, long j11, long j12, long j13, long j14, boolean z11) throws XmlPullParserException, IOException {
        long j15;
        long j16;
        ArrayList arrayList;
        Object obj;
        ArrayList arrayList2;
        ArrayList arrayList3;
        long j17;
        long j18;
        SegmentBase parseSegmentTemplate;
        ArrayList arrayList4;
        DashManifestParser dashManifestParser = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        Object obj2 = null;
        String attributeValue = xmlPullParser2.getAttributeValue((String) null, "id");
        long parseDuration = parseDuration(xmlPullParser2, "start", j11);
        long j19 = C.TIME_UNSET;
        if (j13 != C.TIME_UNSET) {
            j15 = j13 + parseDuration;
        } else {
            j15 = -9223372036854775807L;
        }
        long parseDuration2 = parseDuration(xmlPullParser2, "duration", C.TIME_UNSET);
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        long j21 = j12;
        boolean z12 = false;
        long j22 = -9223372036854775807L;
        SegmentBase segmentBase = null;
        Descriptor descriptor = null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "BaseURL")) {
                if (!z12) {
                    j21 = dashManifestParser.parseAvailabilityTimeOffsetUs(xmlPullParser2, j21);
                    z12 = true;
                }
                arrayList7.addAll(dashManifestParser.parseBaseUrl(xmlPullParser2, list, z11));
                arrayList = arrayList6;
                arrayList2 = arrayList7;
                j16 = j19;
                obj = obj2;
                arrayList3 = arrayList5;
            } else {
                List<BaseUrl> list2 = list;
                boolean z13 = z11;
                if (XmlPullParserUtil.isStartTag(xmlPullParser2, "AdaptationSet")) {
                    if (!arrayList7.isEmpty()) {
                        arrayList4 = arrayList7;
                    } else {
                        arrayList4 = list2;
                    }
                    j17 = j21;
                    arrayList2 = arrayList7;
                    arrayList3 = arrayList5;
                    arrayList3.add(parseAdaptationSet(xmlPullParser, arrayList4, segmentBase, parseDuration2, j21, j22, j15, j14, z11));
                    xmlPullParser2 = xmlPullParser;
                    arrayList = arrayList6;
                } else {
                    j17 = j21;
                    ArrayList arrayList8 = arrayList6;
                    arrayList2 = arrayList7;
                    arrayList3 = arrayList5;
                    xmlPullParser2 = xmlPullParser;
                    if (XmlPullParserUtil.isStartTag(xmlPullParser2, "EventStream")) {
                        ArrayList arrayList9 = arrayList8;
                        arrayList9.add(parseEventStream(xmlPullParser));
                        arrayList = arrayList9;
                    } else {
                        ArrayList arrayList10 = arrayList8;
                        if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentBase")) {
                            arrayList = arrayList10;
                            segmentBase = parseSegmentBase(xmlPullParser2, (SegmentBase.SingleSegmentBase) null);
                            obj = null;
                            j21 = j17;
                            j16 = C.TIME_UNSET;
                        } else {
                            arrayList = arrayList10;
                            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentList")) {
                                long parseAvailabilityTimeOffsetUs = parseAvailabilityTimeOffsetUs(xmlPullParser2, C.TIME_UNSET);
                                obj = null;
                                parseSegmentTemplate = parseSegmentList(xmlPullParser, (SegmentBase.SegmentList) null, j15, parseDuration2, j17, parseAvailabilityTimeOffsetUs, j14);
                                j22 = parseAvailabilityTimeOffsetUs;
                                j21 = j17;
                                j16 = C.TIME_UNSET;
                            } else {
                                obj = null;
                                if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTemplate")) {
                                    long parseAvailabilityTimeOffsetUs2 = parseAvailabilityTimeOffsetUs(xmlPullParser2, C.TIME_UNSET);
                                    j16 = -9223372036854775807L;
                                    parseSegmentTemplate = parseSegmentTemplate(xmlPullParser, (SegmentBase.SegmentTemplate) null, ImmutableList.of(), j15, parseDuration2, j17, parseAvailabilityTimeOffsetUs2, j14);
                                    j22 = parseAvailabilityTimeOffsetUs2;
                                    j21 = j17;
                                } else {
                                    j18 = C.TIME_UNSET;
                                    if (XmlPullParserUtil.isStartTag(xmlPullParser2, "AssetIdentifier")) {
                                        descriptor = parseDescriptor(xmlPullParser2, "AssetIdentifier");
                                    } else {
                                        maybeSkipTag(xmlPullParser);
                                    }
                                    j21 = j17;
                                }
                            }
                            segmentBase = parseSegmentTemplate;
                        }
                    }
                }
                obj = null;
                j18 = C.TIME_UNSET;
                j21 = j17;
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser2, "Period")) {
                return Pair.create(buildPeriod(attributeValue, parseDuration, arrayList3, arrayList, descriptor), Long.valueOf(parseDuration2));
            }
            arrayList5 = arrayList3;
            arrayList7 = arrayList2;
            obj2 = obj;
            arrayList6 = arrayList;
            j19 = j16;
            dashManifestParser = this;
        }
    }

    public String[] parseProfiles(XmlPullParser xmlPullParser, String str, String[] strArr) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return strArr;
        }
        return attributeValue.split(",");
    }

    public ProgramInformation parseProgramInformation(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String str = null;
        String parseString = parseString(xmlPullParser, "moreInformationURL", (String) null);
        String parseString2 = parseString(xmlPullParser, "lang", (String) null);
        String str2 = null;
        String str3 = null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Title")) {
                str = xmlPullParser.nextText();
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "Source")) {
                str2 = xmlPullParser.nextText();
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, ExifInterface.TAG_COPYRIGHT)) {
                str3 = xmlPullParser.nextText();
            } else {
                maybeSkipTag(xmlPullParser);
            }
            String str4 = str3;
            if (XmlPullParserUtil.isEndTag(xmlPullParser, "ProgramInformation")) {
                return new ProgramInformation(str, str2, str4, parseString, parseString2);
            }
            str3 = str4;
        }
    }

    public RangedUri parseRangedUrl(XmlPullParser xmlPullParser, String str, String str2) {
        long j11;
        long j12;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
            j12 = Long.parseLong(split[0]);
            if (split.length == 2) {
                j11 = (Long.parseLong(split[1]) - j12) + 1;
                return buildRangedUri(attributeValue, j12, j11);
            }
        } else {
            j12 = 0;
        }
        j11 = -1;
        return buildRangedUri(attributeValue, j12, j11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v0, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v4, resolved type: com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v3, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v4, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v5, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v6, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v7, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v8, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v9, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v10, resolved type: java.util.ArrayList} */
    /* JADX WARNING: type inference failed for: r31v1 */
    /* JADX WARNING: type inference failed for: r31v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01ee A[LOOP:0: B:1:0x006a->B:53:0x01ee, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0198 A[EDGE_INSN: B:54:0x0198->B:45:0x0198 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.RepresentationInfo parseRepresentation(org.xmlpull.v1.XmlPullParser r36, java.util.List<com.google.android.exoplayer2.source.dash.manifest.BaseUrl> r37, @androidx.annotation.Nullable java.lang.String r38, @androidx.annotation.Nullable java.lang.String r39, int r40, int r41, float r42, int r43, int r44, @androidx.annotation.Nullable java.lang.String r45, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> r46, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> r47, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> r48, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> r49, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.SegmentBase r50, long r51, long r53, long r55, long r57, long r59, boolean r61) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r35 = this;
            r15 = r35
            r14 = r36
            java.lang.String r0 = "id"
            r1 = 0
            java.lang.String r16 = r14.getAttributeValue(r1, r0)
            java.lang.String r0 = "bandwidth"
            r2 = -1
            int r17 = parseInt(r14, r0, r2)
            java.lang.String r0 = "mimeType"
            r2 = r38
            java.lang.String r18 = parseString(r14, r0, r2)
            java.lang.String r0 = "codecs"
            r2 = r39
            java.lang.String r19 = parseString(r14, r0, r2)
            java.lang.String r0 = "width"
            r2 = r40
            int r20 = parseInt(r14, r0, r2)
            java.lang.String r0 = "height"
            r2 = r41
            int r21 = parseInt(r14, r0, r2)
            r0 = r42
            float r22 = parseFrameRate(r14, r0)
            java.lang.String r0 = "audioSamplingRate"
            r2 = r44
            int r23 = parseInt(r14, r0, r2)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r0 = r48
            r12.<init>(r0)
            java.util.ArrayList r9 = new java.util.ArrayList
            r10 = r49
            r9.<init>(r10)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r0 = 0
            r24 = r43
            r5 = r55
            r25 = r0
            r26 = r1
            r0 = r50
            r1 = r57
        L_0x006a:
            r36.next()
            java.lang.String r3 = "BaseURL"
            boolean r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r3 == 0) goto L_0x0090
            if (r25 != 0) goto L_0x007d
            long r5 = r15.parseAvailabilityTimeOffsetUs(r14, r5)
            r25 = 1
        L_0x007d:
            r8 = r37
            r3 = r61
            java.util.List r4 = r15.parseBaseUrl(r14, r8, r3)
            r7.addAll(r4)
        L_0x0088:
            r31 = r7
            r15 = r13
            r7 = r24
            r24 = r0
            goto L_0x00a6
        L_0x0090:
            r8 = r37
            r3 = r61
            java.lang.String r4 = "AudioChannelConfiguration"
            boolean r4 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r4)
            if (r4 == 0) goto L_0x00aa
            int r4 = r35.parseAudioChannelConfiguration(r36)
            r24 = r0
            r31 = r7
            r15 = r13
            r7 = r4
        L_0x00a6:
            r13 = r11
            r11 = r9
            goto L_0x0190
        L_0x00aa:
            java.lang.String r4 = "SegmentBase"
            boolean r4 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r4)
            if (r4 == 0) goto L_0x00b9
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r0 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase) r0
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r0 = r15.parseSegmentBase(r14, r0)
            goto L_0x0088
        L_0x00b9:
            java.lang.String r4 = "SegmentList"
            boolean r4 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r4)
            if (r4 == 0) goto L_0x00f5
            long r27 = r15.parseAvailabilityTimeOffsetUs(r14, r1)
            r2 = r0
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentList r2 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList) r2
            r0 = r35
            r1 = r36
            r3 = r51
            r29 = r5
            r5 = r53
            r31 = r7
            r7 = r29
            r32 = r9
            r9 = r27
            r33 = r11
            r34 = r12
            r11 = r59
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentList r0 = r0.parseSegmentList(r1, r2, r3, r5, r7, r9, r11)
            r15 = r13
        L_0x00e5:
            r7 = r24
            r1 = r27
        L_0x00e9:
            r5 = r29
            r11 = r32
            r13 = r33
            r12 = r34
        L_0x00f1:
            r24 = r0
            goto L_0x0190
        L_0x00f5:
            r29 = r5
            r31 = r7
            r32 = r9
            r33 = r11
            r34 = r12
            java.lang.String r3 = "SegmentTemplate"
            boolean r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r3 == 0) goto L_0x0124
            long r27 = r15.parseAvailabilityTimeOffsetUs(r14, r1)
            r2 = r0
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTemplate r2 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate) r2
            r0 = r35
            r1 = r36
            r3 = r49
            r4 = r51
            r6 = r53
            r8 = r29
            r10 = r27
            r15 = r13
            r12 = r59
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTemplate r0 = r0.parseSegmentTemplate(r1, r2, r3, r4, r6, r8, r10, r12)
            goto L_0x00e5
        L_0x0124:
            r15 = r13
            java.lang.String r3 = "ContentProtection"
            boolean r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r3 == 0) goto L_0x0145
            android.util.Pair r3 = r35.parseContentProtection(r36)
            java.lang.Object r4 = r3.first
            if (r4 == 0) goto L_0x0139
            r26 = r4
            java.lang.String r26 = (java.lang.String) r26
        L_0x0139:
            java.lang.Object r3 = r3.second
            if (r3 == 0) goto L_0x0142
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r3 = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData) r3
            r15.add(r3)
        L_0x0142:
            r7 = r24
            goto L_0x00e9
        L_0x0145:
            java.lang.String r3 = "InbandEventStream"
            boolean r4 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r4 == 0) goto L_0x015b
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r3 = parseDescriptor(r14, r3)
            r13 = r33
            r13.add(r3)
            r11 = r32
            r12 = r34
            goto L_0x018a
        L_0x015b:
            r13 = r33
            java.lang.String r3 = "EssentialProperty"
            boolean r4 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r4 == 0) goto L_0x0171
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r3 = parseDescriptor(r14, r3)
            r12 = r34
            r12.add(r3)
            r11 = r32
            goto L_0x018a
        L_0x0171:
            r12 = r34
            java.lang.String r3 = "SupplementalProperty"
            boolean r4 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r4 == 0) goto L_0x0185
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r3 = parseDescriptor(r14, r3)
            r11 = r32
            r11.add(r3)
            goto L_0x018a
        L_0x0185:
            r11 = r32
            maybeSkipTag(r36)
        L_0x018a:
            r7 = r24
            r5 = r29
            goto L_0x00f1
        L_0x0190:
            java.lang.String r0 = "Representation"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(r14, r0)
            if (r0 == 0) goto L_0x01ee
            r0 = r35
            r1 = r16
            r2 = r18
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r7
            r7 = r23
            r8 = r17
            r9 = r45
            r10 = r46
            r27 = r11
            r11 = r47
            r28 = r12
            r12 = r19
            r29 = r13
            r13 = r28
            r14 = r27
            com.google.android.exoplayer2.Format r0 = r0.buildFormat(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            if (r24 == 0) goto L_0x01c2
            goto L_0x01c9
        L_0x01c2:
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r1 = new com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase
            r1.<init>()
            r24 = r1
        L_0x01c9:
            com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo r1 = new com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo
            boolean r2 = r31.isEmpty()
            if (r2 != 0) goto L_0x01d2
            goto L_0x01d4
        L_0x01d2:
            r31 = r37
        L_0x01d4:
            r2 = -1
            r36 = r1
            r37 = r0
            r38 = r31
            r39 = r24
            r40 = r26
            r41 = r15
            r42 = r29
            r43 = r28
            r44 = r27
            r45 = r2
            r36.<init>(r37, r38, r39, r40, r41, r42, r43, r44, r45)
            return r1
        L_0x01ee:
            r10 = r49
            r9 = r11
            r11 = r13
            r13 = r15
            r0 = r24
            r15 = r35
            r24 = r7
            r7 = r31
            goto L_0x006a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseRepresentation(org.xmlpull.v1.XmlPullParser, java.util.List, java.lang.String, java.lang.String, int, int, float, int, int, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, com.google.android.exoplayer2.source.dash.manifest.SegmentBase, long, long, long, long, long, boolean):com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo");
    }

    public int parseRoleFlagsFromAccessibilityDescriptors(List<Descriptor> list) {
        int parseTvaAudioPurposeCsValue;
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            Descriptor descriptor = list.get(i12);
            if (Ascii.equalsIgnoreCase("urn:mpeg:dash:role:2011", descriptor.schemeIdUri)) {
                parseTvaAudioPurposeCsValue = parseRoleFlagsFromDashRoleScheme(descriptor.value);
            } else if (Ascii.equalsIgnoreCase("urn:tva:metadata:cs:AudioPurposeCS:2007", descriptor.schemeIdUri)) {
                parseTvaAudioPurposeCsValue = parseTvaAudioPurposeCsValue(descriptor.value);
            }
            i11 |= parseTvaAudioPurposeCsValue;
        }
        return i11;
    }

    public int parseRoleFlagsFromDashRoleScheme(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2060497896:
                if (str.equals("subtitle")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1724546052:
                if (str.equals("description")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1580883024:
                if (str.equals("enhanced-audio-intelligibility")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1574842690:
                if (str.equals("forced_subtitle")) {
                    c11 = 3;
                    break;
                }
                break;
            case -1408024454:
                if (str.equals("alternate")) {
                    c11 = 4;
                    break;
                }
                break;
            case -1396432756:
                if (str.equals("forced-subtitle")) {
                    c11 = 5;
                    break;
                }
                break;
            case 99825:
                if (str.equals("dub")) {
                    c11 = 6;
                    break;
                }
                break;
            case 3343801:
                if (str.equals("main")) {
                    c11 = 7;
                    break;
                }
                break;
            case 3530173:
                if (str.equals("sign")) {
                    c11 = 8;
                    break;
                }
                break;
            case 552573414:
                if (str.equals(ShareConstants.FEED_CAPTION_PARAM)) {
                    c11 = 9;
                    break;
                }
                break;
            case 899152809:
                if (str.equals("commentary")) {
                    c11 = 10;
                    break;
                }
                break;
            case 1629013393:
                if (str.equals("emergency")) {
                    c11 = 11;
                    break;
                }
                break;
            case 1855372047:
                if (str.equals("supplementary")) {
                    c11 = 12;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 3:
            case 5:
                return 128;
            case 1:
                return 512;
            case 2:
                return 2048;
            case 4:
                return 2;
            case 6:
                return 16;
            case 7:
                return 1;
            case 8:
                return 256;
            case 9:
                return 64;
            case 10:
                return 8;
            case 11:
                return 32;
            case 12:
                return 4;
            default:
                return 0;
        }
    }

    public int parseRoleFlagsFromProperties(List<Descriptor> list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (Ascii.equalsIgnoreCase("http://dashif.org/guidelines/trickmode", list.get(i12).schemeIdUri)) {
                i11 |= 16384;
            }
        }
        return i11;
    }

    public int parseRoleFlagsFromRoleDescriptors(List<Descriptor> list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            Descriptor descriptor = list.get(i12);
            if (Ascii.equalsIgnoreCase("urn:mpeg:dash:role:2011", descriptor.schemeIdUri)) {
                i11 |= parseRoleFlagsFromDashRoleScheme(descriptor.value);
            }
        }
        return i11;
    }

    public SegmentBase.SingleSegmentBase parseSegmentBase(XmlPullParser xmlPullParser, @Nullable SegmentBase.SingleSegmentBase singleSegmentBase) throws XmlPullParserException, IOException {
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SingleSegmentBase singleSegmentBase2 = singleSegmentBase;
        if (singleSegmentBase2 != null) {
            j11 = singleSegmentBase2.timescale;
        } else {
            j11 = 1;
        }
        long parseLong = parseLong(xmlPullParser2, "timescale", j11);
        long j16 = 0;
        if (singleSegmentBase2 != null) {
            j12 = singleSegmentBase2.presentationTimeOffset;
        } else {
            j12 = 0;
        }
        long parseLong2 = parseLong(xmlPullParser2, "presentationTimeOffset", j12);
        if (singleSegmentBase2 != null) {
            j13 = singleSegmentBase2.indexStart;
        } else {
            j13 = 0;
        }
        if (singleSegmentBase2 != null) {
            j16 = singleSegmentBase2.indexLength;
        }
        RangedUri rangedUri = null;
        String attributeValue = xmlPullParser2.getAttributeValue((String) null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
            j15 = Long.parseLong(split[0]);
            j14 = (Long.parseLong(split[1]) - j15) + 1;
        } else {
            j14 = j16;
            j15 = j13;
        }
        if (singleSegmentBase2 != null) {
            rangedUri = singleSegmentBase2.initialization;
        }
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentBase"));
        return buildSingleSegmentBase(rangedUri, parseLong, parseLong2, j15, j14);
    }

    public SegmentBase.SegmentList parseSegmentList(XmlPullParser xmlPullParser, @Nullable SegmentBase.SegmentList segmentList, long j11, long j12, long j13, long j14, long j15) throws XmlPullParserException, IOException {
        long j16;
        long j17;
        long j18;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SegmentList segmentList2 = segmentList;
        long j19 = 1;
        if (segmentList2 != null) {
            j16 = segmentList2.timescale;
        } else {
            j16 = 1;
        }
        long parseLong = parseLong(xmlPullParser2, "timescale", j16);
        if (segmentList2 != null) {
            j17 = segmentList2.presentationTimeOffset;
        } else {
            j17 = 0;
        }
        long parseLong2 = parseLong(xmlPullParser2, "presentationTimeOffset", j17);
        if (segmentList2 != null) {
            j18 = segmentList2.duration;
        } else {
            j18 = C.TIME_UNSET;
        }
        long parseLong3 = parseLong(xmlPullParser2, "duration", j18);
        if (segmentList2 != null) {
            j19 = segmentList2.startNumber;
        }
        long parseLong4 = parseLong(xmlPullParser2, "startNumber", j19);
        long finalAvailabilityTimeOffset = getFinalAvailabilityTimeOffset(j13, j14);
        List<SegmentBase.SegmentTimelineElement> list = null;
        List list2 = null;
        RangedUri rangedUri = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTimeline")) {
                list = parseSegmentTimeline(xmlPullParser, parseLong, j12);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentURL")) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(parseSegmentUrl(xmlPullParser));
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentList"));
        if (segmentList2 != null) {
            if (rangedUri == null) {
                rangedUri = segmentList2.initialization;
            }
            if (list == null) {
                list = segmentList2.segmentTimeline;
            }
            if (list2 == null) {
                list2 = segmentList2.mediaSegments;
            }
        }
        return buildSegmentList(rangedUri, parseLong, parseLong2, parseLong4, parseLong3, list, finalAvailabilityTimeOffset, list2, j15, j11);
    }

    public SegmentBase.SegmentTemplate parseSegmentTemplate(XmlPullParser xmlPullParser, @Nullable SegmentBase.SegmentTemplate segmentTemplate, List<Descriptor> list, long j11, long j12, long j13, long j14, long j15) throws XmlPullParserException, IOException {
        long j16;
        long j17;
        long j18;
        UrlTemplate urlTemplate;
        UrlTemplate urlTemplate2;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SegmentTemplate segmentTemplate2 = segmentTemplate;
        long j19 = 1;
        if (segmentTemplate2 != null) {
            j16 = segmentTemplate2.timescale;
        } else {
            j16 = 1;
        }
        long parseLong = parseLong(xmlPullParser2, "timescale", j16);
        if (segmentTemplate2 != null) {
            j17 = segmentTemplate2.presentationTimeOffset;
        } else {
            j17 = 0;
        }
        long parseLong2 = parseLong(xmlPullParser2, "presentationTimeOffset", j17);
        if (segmentTemplate2 != null) {
            j18 = segmentTemplate2.duration;
        } else {
            j18 = C.TIME_UNSET;
        }
        long parseLong3 = parseLong(xmlPullParser2, "duration", j18);
        if (segmentTemplate2 != null) {
            j19 = segmentTemplate2.startNumber;
        }
        long parseLong4 = parseLong(xmlPullParser2, "startNumber", j19);
        long parseLastSegmentNumberSupplementalProperty = parseLastSegmentNumberSupplementalProperty(list);
        long finalAvailabilityTimeOffset = getFinalAvailabilityTimeOffset(j13, j14);
        List<SegmentBase.SegmentTimelineElement> list2 = null;
        if (segmentTemplate2 != null) {
            urlTemplate = segmentTemplate2.mediaTemplate;
        } else {
            urlTemplate = null;
        }
        UrlTemplate parseUrlTemplate = parseUrlTemplate(xmlPullParser2, ShareConstants.WEB_DIALOG_PARAM_MEDIA, urlTemplate);
        if (segmentTemplate2 != null) {
            urlTemplate2 = segmentTemplate2.initializationTemplate;
        } else {
            urlTemplate2 = null;
        }
        UrlTemplate parseUrlTemplate2 = parseUrlTemplate(xmlPullParser2, "initialization", urlTemplate2);
        RangedUri rangedUri = null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTimeline")) {
                list2 = parseSegmentTimeline(xmlPullParser, parseLong, j12);
            } else {
                maybeSkipTag(xmlPullParser);
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentTemplate")) {
                break;
            }
        }
        if (segmentTemplate2 != null) {
            if (rangedUri == null) {
                rangedUri = segmentTemplate2.initialization;
            }
            if (list2 == null) {
                list2 = segmentTemplate2.segmentTimeline;
            }
        }
        return buildSegmentTemplate(rangedUri, parseLong, parseLong2, parseLong4, parseLastSegmentNumberSupplementalProperty, parseLong3, list2, finalAvailabilityTimeOffset, parseUrlTemplate2, parseUrlTemplate, j15, j11);
    }

    public List<SegmentBase.SegmentTimelineElement> parseSegmentTimeline(XmlPullParser xmlPullParser, long j11, long j12) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        ArrayList arrayList = new ArrayList();
        long j13 = 0;
        long j14 = -9223372036854775807L;
        boolean z11 = false;
        int i11 = 0;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, ExifInterface.LATITUDE_SOUTH)) {
                long parseLong = parseLong(xmlPullParser2, "t", C.TIME_UNSET);
                if (z11) {
                    j13 = addSegmentTimelineElementsToList(arrayList, j13, j14, i11, parseLong);
                }
                if (parseLong == C.TIME_UNSET) {
                    parseLong = j13;
                }
                j14 = parseLong(xmlPullParser2, "d", C.TIME_UNSET);
                i11 = parseInt(xmlPullParser2, "r", 0);
                z11 = true;
                j13 = parseLong;
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentTimeline"));
        if (z11) {
            addSegmentTimelineElementsToList(arrayList, j13, j14, i11, Util.scaleLargeTimestamp(j12, j11, 1000));
        }
        return arrayList;
    }

    public RangedUri parseSegmentUrl(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, ShareConstants.WEB_DIALOG_PARAM_MEDIA, "mediaRange");
    }

    public int parseSelectionFlagsFromDashRoleScheme(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        if (str.equals("forced_subtitle") || str.equals("forced-subtitle")) {
            return 2;
        }
        return 0;
    }

    public int parseSelectionFlagsFromRoleDescriptors(List<Descriptor> list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            Descriptor descriptor = list.get(i12);
            if (Ascii.equalsIgnoreCase("urn:mpeg:dash:role:2011", descriptor.schemeIdUri)) {
                i11 |= parseSelectionFlagsFromDashRoleScheme(descriptor.value);
            }
        }
        return i11;
    }

    public ServiceDescriptionElement parseServiceDescription(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        long j11 = -9223372036854775807L;
        long j12 = -9223372036854775807L;
        long j13 = -9223372036854775807L;
        float f11 = -3.4028235E38f;
        float f12 = -3.4028235E38f;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Latency")) {
                j11 = parseLong(xmlPullParser2, "target", C.TIME_UNSET);
                j12 = parseLong(xmlPullParser2, "min", C.TIME_UNSET);
                j13 = parseLong(xmlPullParser2, RichContentLoadTimeTracer.MAX, C.TIME_UNSET);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "PlaybackRate")) {
                f11 = parseFloat(xmlPullParser2, "min", -3.4028235E38f);
                f12 = parseFloat(xmlPullParser2, RichContentLoadTimeTracer.MAX, -3.4028235E38f);
            }
            long j14 = j11;
            long j15 = j12;
            long j16 = j13;
            float f13 = f11;
            float f14 = f12;
            if (XmlPullParserUtil.isEndTag(xmlPullParser2, "ServiceDescription")) {
                return new ServiceDescriptionElement(j14, j15, j16, f13, f14);
            }
            j11 = j14;
            j12 = j15;
            j13 = j16;
            f11 = f13;
            f12 = f14;
        }
    }

    @Nullable
    public Pair<Integer, Integer> parseTileCountFromProperties(List<Descriptor> list) {
        String str;
        for (int i11 = 0; i11 < list.size(); i11++) {
            Descriptor descriptor = list.get(i11);
            if ((Ascii.equalsIgnoreCase("http://dashif.org/thumbnail_tile", descriptor.schemeIdUri) || Ascii.equalsIgnoreCase("http://dashif.org/guidelines/thumbnail_tile", descriptor.schemeIdUri)) && (str = descriptor.value) != null) {
                String[] split = Util.split(str, Param.X);
                if (split.length != 2) {
                    continue;
                } else {
                    try {
                        return Pair.create(Integer.valueOf(Integer.parseInt(split[0])), Integer.valueOf(Integer.parseInt(split[1])));
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        return null;
    }

    public int parseTvaAudioPurposeCsValue(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c11 = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                    c11 = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                    c11 = 2;
                    break;
                }
                break;
            case 52:
                if (str.equals(OnlineLocationService.SRC_DEFAULT)) {
                    c11 = 3;
                    break;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 512;
            case 1:
                return 2048;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    @Nullable
    public UrlTemplate parseUrlTemplate(XmlPullParser xmlPullParser, String str, @Nullable UrlTemplate urlTemplate) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue != null) {
            return UrlTemplate.compile(attributeValue);
        }
        return urlTemplate;
    }

    public UtcTimingElement parseUtcTiming(XmlPullParser xmlPullParser) {
        return buildUtcTimingElement(xmlPullParser.getAttributeValue((String) null, "schemeIdUri"), xmlPullParser.getAttributeValue((String) null, "value"));
    }

    public DashManifest parse(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
            newPullParser.setInput(inputStream, (String) null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return parseMediaPresentationDescription(newPullParser, uri);
            }
            throw ParserException.createForMalformedManifest("inputStream does not contain a valid media presentation description", (Throwable) null);
        } catch (XmlPullParserException e11) {
            throw ParserException.createForMalformedManifest((String) null, e11);
        }
    }
}
