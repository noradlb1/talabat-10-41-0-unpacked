package com.google.android.exoplayer2.text.ssa;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.ssa.SsaStyle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public final class SsaDecoder extends SimpleSubtitleDecoder {
    private static final float DEFAULT_MARGIN = 0.05f;
    private static final String DIALOGUE_LINE_PREFIX = "Dialogue:";
    static final String FORMAT_LINE_PREFIX = "Format:";
    private static final Pattern SSA_TIMECODE_PATTERN = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    static final String STYLE_LINE_PREFIX = "Style:";
    private static final String TAG = "SsaDecoder";
    @Nullable
    private final SsaDialogueFormat dialogueFormatFromInitializationData;
    private final boolean haveInitializationData;
    private float screenHeight;
    private float screenWidth;
    private Map<String, SsaStyle> styles;

    public SsaDecoder() {
        this((List<byte[]>) null);
    }

    private static int addCuePlacerholderByTime(long j11, List<Long> list, List<List<Cue>> list2) {
        int i11;
        ArrayList arrayList;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i11 = 0;
                break;
            } else if (list.get(size).longValue() == j11) {
                return size;
            } else {
                if (list.get(size).longValue() < j11) {
                    i11 = size + 1;
                    break;
                }
                size--;
            }
        }
        list.add(i11, Long.valueOf(j11));
        if (i11 != 0) {
            arrayList = new ArrayList(list2.get(i11 - 1));
        }
        list2.add(i11, arrayList);
        return i11;
    }

    private static float computeDefaultLineOrPosition(int i11) {
        if (i11 == 0) {
            return DEFAULT_MARGIN;
        }
        if (i11 != 1) {
            return i11 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static Cue createCue(String str, @Nullable SsaStyle ssaStyle, SsaStyle.Overrides overrides, float f11, float f12) {
        SpannableString spannableString = new SpannableString(str);
        Cue.Builder text = new Cue.Builder().setText(spannableString);
        if (ssaStyle != null) {
            if (ssaStyle.primaryColor != null) {
                spannableString.setSpan(new ForegroundColorSpan(ssaStyle.primaryColor.intValue()), 0, spannableString.length(), 33);
            }
            if (ssaStyle.borderStyle == 3 && ssaStyle.outlineColor != null) {
                spannableString.setSpan(new BackgroundColorSpan(ssaStyle.outlineColor.intValue()), 0, spannableString.length(), 33);
            }
            float f13 = ssaStyle.fontSize;
            if (!(f13 == -3.4028235E38f || f12 == -3.4028235E38f)) {
                text.setTextSize(f13 / f12, 1);
            }
            boolean z11 = ssaStyle.bold;
            if (z11 && ssaStyle.italic) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z11) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (ssaStyle.italic) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (ssaStyle.underline) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (ssaStyle.strikeout) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i11 = overrides.alignment;
        if (i11 == -1) {
            if (ssaStyle != null) {
                i11 = ssaStyle.alignment;
            } else {
                i11 = -1;
            }
        }
        text.setTextAlignment(toTextAlignment(i11)).setPositionAnchor(toPositionAnchor(i11)).setLineAnchor(toLineAnchor(i11));
        PointF pointF = overrides.position;
        if (pointF == null || f12 == -3.4028235E38f || f11 == -3.4028235E38f) {
            text.setPosition(computeDefaultLineOrPosition(text.getPositionAnchor()));
            text.setLine(computeDefaultLineOrPosition(text.getLineAnchor()), 0);
        } else {
            text.setPosition(pointF.x / f11);
            text.setLine(overrides.position.y / f12, 0);
        }
        return text.build();
    }

    private Charset detectUtfCharset(ParsableByteArray parsableByteArray) {
        Charset readUtfCharsetFromBom = parsableByteArray.readUtfCharsetFromBom();
        if (readUtfCharsetFromBom != null) {
            return readUtfCharsetFromBom;
        }
        return Charsets.UTF_8;
    }

    private void parseDialogueLine(String str, SsaDialogueFormat ssaDialogueFormat, List<List<Cue>> list, List<Long> list2) {
        SsaStyle ssaStyle;
        int i11;
        Assertions.checkArgument(str.startsWith(DIALOGUE_LINE_PREFIX));
        String[] split = str.substring(9).split(",", ssaDialogueFormat.length);
        if (split.length != ssaDialogueFormat.length) {
            Log.w(TAG, "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long parseTimecodeUs = parseTimecodeUs(split[ssaDialogueFormat.startTimeIndex]);
        if (parseTimecodeUs == C.TIME_UNSET) {
            Log.w(TAG, "Skipping invalid timing: " + str);
            return;
        }
        long parseTimecodeUs2 = parseTimecodeUs(split[ssaDialogueFormat.endTimeIndex]);
        if (parseTimecodeUs2 == C.TIME_UNSET) {
            Log.w(TAG, "Skipping invalid timing: " + str);
            return;
        }
        Map<String, SsaStyle> map = this.styles;
        if (map == null || (i11 = ssaDialogueFormat.styleIndex) == -1) {
            ssaStyle = null;
        } else {
            ssaStyle = map.get(split[i11].trim());
        }
        String str2 = split[ssaDialogueFormat.textIndex];
        Cue createCue = createCue(SsaStyle.Overrides.stripStyleOverrides(str2).replace("\\N", StringUtils.LF).replace("\\n", StringUtils.LF).replace("\\h", " "), ssaStyle, SsaStyle.Overrides.parseFromDialogue(str2), this.screenWidth, this.screenHeight);
        int addCuePlacerholderByTime = addCuePlacerholderByTime(parseTimecodeUs2, list2, list);
        for (int addCuePlacerholderByTime2 = addCuePlacerholderByTime(parseTimecodeUs, list2, list); addCuePlacerholderByTime2 < addCuePlacerholderByTime; addCuePlacerholderByTime2++) {
            list.get(addCuePlacerholderByTime2).add(createCue);
        }
    }

    private void parseEventBody(ParsableByteArray parsableByteArray, List<List<Cue>> list, List<Long> list2, Charset charset) {
        SsaDialogueFormat ssaDialogueFormat;
        if (this.haveInitializationData) {
            ssaDialogueFormat = this.dialogueFormatFromInitializationData;
        } else {
            ssaDialogueFormat = null;
        }
        while (true) {
            String readLine = parsableByteArray.readLine(charset);
            if (readLine == null) {
                return;
            }
            if (readLine.startsWith(FORMAT_LINE_PREFIX)) {
                ssaDialogueFormat = SsaDialogueFormat.fromFormatLine(readLine);
            } else if (readLine.startsWith(DIALOGUE_LINE_PREFIX)) {
                if (ssaDialogueFormat == null) {
                    Log.w(TAG, "Skipping dialogue line before complete format: " + readLine);
                } else {
                    parseDialogueLine(readLine, ssaDialogueFormat, list, list2);
                }
            }
        }
    }

    private void parseHeader(ParsableByteArray parsableByteArray, Charset charset) {
        while (true) {
            String readLine = parsableByteArray.readLine(charset);
            if (readLine == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(readLine)) {
                parseScriptInfo(parsableByteArray, charset);
            } else if ("[V4+ Styles]".equalsIgnoreCase(readLine)) {
                this.styles = parseStyles(parsableByteArray, charset);
            } else if ("[V4 Styles]".equalsIgnoreCase(readLine)) {
                Log.i(TAG, "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(readLine)) {
                return;
            }
        }
    }

    private void parseScriptInfo(ParsableByteArray parsableByteArray, Charset charset) {
        while (true) {
            String readLine = parsableByteArray.readLine(charset);
            if (readLine == null) {
                return;
            }
            if (parsableByteArray.bytesLeft() == 0 || parsableByteArray.peekChar(charset) != '[') {
                String[] split = readLine.split(CertificateUtil.DELIMITER);
                if (split.length == 2) {
                    String lowerCase = Ascii.toLowerCase(split[0].trim());
                    lowerCase.hashCode();
                    if (lowerCase.equals("playresx")) {
                        this.screenWidth = Float.parseFloat(split[1].trim());
                    } else if (lowerCase.equals("playresy")) {
                        try {
                            this.screenHeight = Float.parseFloat(split[1].trim());
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    private static Map<String, SsaStyle> parseStyles(ParsableByteArray parsableByteArray, Charset charset) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SsaStyle.Format format = null;
        while (true) {
            String readLine = parsableByteArray.readLine(charset);
            if (readLine == null || (parsableByteArray.bytesLeft() != 0 && parsableByteArray.peekChar(charset) == '[')) {
                return linkedHashMap;
            }
            if (readLine.startsWith(FORMAT_LINE_PREFIX)) {
                format = SsaStyle.Format.fromFormatLine(readLine);
            } else if (readLine.startsWith(STYLE_LINE_PREFIX)) {
                if (format == null) {
                    Log.w(TAG, "Skipping 'Style:' line before 'Format:' line: " + readLine);
                } else {
                    SsaStyle fromStyleLine = SsaStyle.fromStyleLine(readLine, format);
                    if (fromStyleLine != null) {
                        linkedHashMap.put(fromStyleLine.f35052name, fromStyleLine);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private static long parseTimecodeUs(String str) {
        Matcher matcher = SSA_TIMECODE_PATTERN.matcher(str.trim());
        if (!matcher.matches()) {
            return C.TIME_UNSET;
        }
        return (Long.parseLong((String) Util.castNonNull(matcher.group(1))) * 60 * 60 * 1000000) + (Long.parseLong((String) Util.castNonNull(matcher.group(2))) * 60 * 1000000) + (Long.parseLong((String) Util.castNonNull(matcher.group(3))) * 1000000) + (Long.parseLong((String) Util.castNonNull(matcher.group(4))) * 10000);
    }

    private static int toLineAnchor(int i11) {
        switch (i11) {
            case -1:
                return Integer.MIN_VALUE;
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                return 0;
            default:
                Log.w(TAG, "Unknown alignment: " + i11);
                return Integer.MIN_VALUE;
        }
    }

    private static int toPositionAnchor(int i11) {
        switch (i11) {
            case -1:
                return Integer.MIN_VALUE;
            case 1:
            case 4:
            case 7:
                return 0;
            case 2:
            case 5:
            case 8:
                return 1;
            case 3:
            case 6:
            case 9:
                return 2;
            default:
                Log.w(TAG, "Unknown alignment: " + i11);
                return Integer.MIN_VALUE;
        }
    }

    @Nullable
    private static Layout.Alignment toTextAlignment(int i11) {
        switch (i11) {
            case -1:
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
            default:
                Log.w(TAG, "Unknown alignment: " + i11);
                return null;
        }
    }

    public Subtitle decode(byte[] bArr, int i11, boolean z11) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i11);
        Charset detectUtfCharset = detectUtfCharset(parsableByteArray);
        if (!this.haveInitializationData) {
            parseHeader(parsableByteArray, detectUtfCharset);
        }
        parseEventBody(parsableByteArray, arrayList, arrayList2, detectUtfCharset);
        return new SsaSubtitle(arrayList, arrayList2);
    }

    public SsaDecoder(@Nullable List<byte[]> list) {
        super(TAG);
        this.screenWidth = -3.4028235E38f;
        this.screenHeight = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.haveInitializationData = false;
            this.dialogueFormatFromInitializationData = null;
            return;
        }
        this.haveInitializationData = true;
        String fromUtf8Bytes = Util.fromUtf8Bytes(list.get(0));
        Assertions.checkArgument(fromUtf8Bytes.startsWith(FORMAT_LINE_PREFIX));
        this.dialogueFormatFromInitializationData = (SsaDialogueFormat) Assertions.checkNotNull(SsaDialogueFormat.fromFormatLine(fromUtf8Bytes));
        parseHeader(new ParsableByteArray(list.get(1)), Charsets.UTF_8);
    }
}
