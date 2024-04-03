package com.google.android.exoplayer2.extractor.jpeg;

import androidx.annotation.Nullable;
import androidx.compose.material3.TextFieldImplKt;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.jpeg.MotionPhotoDescription;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

final class XmpMotionPhotoDescriptionParser {
    private static final String[] DESCRIPTION_MICRO_VIDEO_OFFSET_ATTRIBUTE_NAMES = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};
    private static final String[] DESCRIPTION_MOTION_PHOTO_PRESENTATION_TIMESTAMP_ATTRIBUTE_NAMES = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] MOTION_PHOTO_ATTRIBUTE_NAMES = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String TAG = "MotionPhotoXmpParser";

    private XmpMotionPhotoDescriptionParser() {
    }

    @Nullable
    public static MotionPhotoDescription parse(String str) throws IOException {
        try {
            return parseInternal(str);
        } catch (ParserException | NumberFormatException | XmlPullParserException unused) {
            Log.w(TAG, "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    @Nullable
    private static MotionPhotoDescription parseInternal(String str) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        newPullParser.next();
        if (XmlPullParserUtil.isStartTag(newPullParser, "x:xmpmeta")) {
            ImmutableList<MotionPhotoDescription.ContainerItem> of2 = ImmutableList.of();
            long j11 = C.TIME_UNSET;
            do {
                newPullParser.next();
                if (XmlPullParserUtil.isStartTag(newPullParser, "rdf:Description")) {
                    if (!parseMotionPhotoFlagFromDescription(newPullParser)) {
                        return null;
                    }
                    j11 = parseMotionPhotoPresentationTimestampUsFromDescription(newPullParser);
                    of2 = parseMicroVideoOffsetFromDescription(newPullParser);
                } else if (XmlPullParserUtil.isStartTag(newPullParser, "Container:Directory")) {
                    of2 = parseMotionPhotoV1Directory(newPullParser, TextFieldImplKt.ContainerId, "Item");
                } else if (XmlPullParserUtil.isStartTag(newPullParser, "GContainer:Directory")) {
                    of2 = parseMotionPhotoV1Directory(newPullParser, "GContainer", "GContainerItem");
                }
            } while (!XmlPullParserUtil.isEndTag(newPullParser, "x:xmpmeta"));
            if (of2.isEmpty()) {
                return null;
            }
            return new MotionPhotoDescription(j11, of2);
        }
        throw ParserException.createForMalformedContainer("Couldn't find xmp metadata", (Throwable) null);
    }

    private static ImmutableList<MotionPhotoDescription.ContainerItem> parseMicroVideoOffsetFromDescription(XmlPullParser xmlPullParser) {
        for (String attributeValue : DESCRIPTION_MICRO_VIDEO_OFFSET_ATTRIBUTE_NAMES) {
            String attributeValue2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, attributeValue);
            if (attributeValue2 != null) {
                return ImmutableList.of(new MotionPhotoDescription.ContainerItem(MimeTypes.IMAGE_JPEG, "Primary", 0, 0), new MotionPhotoDescription.ContainerItem(MimeTypes.VIDEO_MP4, "MotionPhoto", Long.parseLong(attributeValue2), 0));
            }
        }
        return ImmutableList.of();
    }

    private static boolean parseMotionPhotoFlagFromDescription(XmlPullParser xmlPullParser) {
        String[] strArr = MOTION_PHOTO_ATTRIBUTE_NAMES;
        int length = strArr.length;
        int i11 = 0;
        while (i11 < length) {
            String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, strArr[i11]);
            if (attributeValue == null) {
                i11++;
            } else if (Integer.parseInt(attributeValue) == 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private static long parseMotionPhotoPresentationTimestampUsFromDescription(XmlPullParser xmlPullParser) {
        for (String attributeValue : DESCRIPTION_MOTION_PHOTO_PRESENTATION_TIMESTAMP_ATTRIBUTE_NAMES) {
            String attributeValue2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, attributeValue);
            if (attributeValue2 != null) {
                long parseLong = Long.parseLong(attributeValue2);
                if (parseLong == -1) {
                    return C.TIME_UNSET;
                }
                return parseLong;
            }
        }
        return C.TIME_UNSET;
    }

    private static ImmutableList<MotionPhotoDescription.ContainerItem> parseMotionPhotoV1Directory(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        long j11;
        long j12;
        ImmutableList.Builder builder = ImmutableList.builder();
        String str3 = str + ":Item";
        String str4 = str + ":Directory";
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, str3)) {
                String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, str2 + ":Mime");
                String attributeValue2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, str2 + ":Semantic");
                String attributeValue3 = XmlPullParserUtil.getAttributeValue(xmlPullParser, str2 + ":Length");
                String attributeValue4 = XmlPullParserUtil.getAttributeValue(xmlPullParser, str2 + ":Padding");
                if (attributeValue == null || attributeValue2 == null) {
                    return ImmutableList.of();
                }
                if (attributeValue3 != null) {
                    j11 = Long.parseLong(attributeValue3);
                } else {
                    j11 = 0;
                }
                if (attributeValue4 != null) {
                    j12 = Long.parseLong(attributeValue4);
                } else {
                    j12 = 0;
                }
                builder.add((Object) new MotionPhotoDescription.ContainerItem(attributeValue, attributeValue2, j11, j12));
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, str4));
        return builder.build();
    }
}
