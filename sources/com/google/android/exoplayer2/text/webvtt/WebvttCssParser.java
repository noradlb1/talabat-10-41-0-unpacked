package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import datamodels.TypesAliasesKt;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class WebvttCssParser {
    private static final Pattern FONT_SIZE_PATTERN = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private static final String PROPERTY_BGCOLOR = "background-color";
    private static final String PROPERTY_COLOR = "color";
    private static final String PROPERTY_FONT_FAMILY = "font-family";
    private static final String PROPERTY_FONT_SIZE = "font-size";
    private static final String PROPERTY_FONT_STYLE = "font-style";
    private static final String PROPERTY_FONT_WEIGHT = "font-weight";
    private static final String PROPERTY_RUBY_POSITION = "ruby-position";
    private static final String PROPERTY_TEXT_COMBINE_UPRIGHT = "text-combine-upright";
    private static final String PROPERTY_TEXT_DECORATION = "text-decoration";
    private static final String RULE_END = "}";
    private static final String RULE_START = "{";
    private static final String TAG = "WebvttCssParser";
    private static final String VALUE_ALL = "all";
    private static final String VALUE_BOLD = "bold";
    private static final String VALUE_DIGITS = "digits";
    private static final String VALUE_ITALIC = "italic";
    private static final String VALUE_OVER = "over";
    private static final String VALUE_UNDER = "under";
    private static final String VALUE_UNDERLINE = "underline";
    private static final Pattern VOICE_NAME_PATTERN = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private final StringBuilder stringBuilder = new StringBuilder();
    private final ParsableByteArray styleInput = new ParsableByteArray();

    private void applySelectorToStyle(WebvttCssStyle webvttCssStyle, String str) {
        if (!"".equals(str)) {
            int indexOf = str.indexOf(91);
            if (indexOf != -1) {
                Matcher matcher = VOICE_NAME_PATTERN.matcher(str.substring(indexOf));
                if (matcher.matches()) {
                    webvttCssStyle.setTargetVoice((String) Assertions.checkNotNull(matcher.group(1)));
                }
                str = str.substring(0, indexOf);
            }
            String[] split = Util.split(str, "\\.");
            String str2 = split[0];
            int indexOf2 = str2.indexOf(35);
            if (indexOf2 != -1) {
                webvttCssStyle.setTargetTagName(str2.substring(0, indexOf2));
                webvttCssStyle.setTargetId(str2.substring(indexOf2 + 1));
            } else {
                webvttCssStyle.setTargetTagName(str2);
            }
            if (split.length > 1) {
                webvttCssStyle.setTargetClasses((String[]) Util.nullSafeArrayCopyOfRange(split, 1, split.length));
            }
        }
    }

    private static boolean maybeSkipComment(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        byte[] data = parsableByteArray.getData();
        if (position + 2 > limit) {
            return false;
        }
        int i11 = position + 1;
        if (data[position] != 47) {
            return false;
        }
        int i12 = i11 + 1;
        if (data[i11] != 42) {
            return false;
        }
        while (true) {
            int i13 = i12 + 1;
            if (i13 >= limit) {
                parsableByteArray.skipBytes(limit - parsableByteArray.getPosition());
                return true;
            } else if (((char) data[i12]) == '*' && ((char) data[i13]) == '/') {
                i12 = i13 + 1;
                limit = i12;
            } else {
                i12 = i13;
            }
        }
    }

    private static boolean maybeSkipWhitespace(ParsableByteArray parsableByteArray) {
        char peekCharAtPosition = peekCharAtPosition(parsableByteArray, parsableByteArray.getPosition());
        if (peekCharAtPosition != 9 && peekCharAtPosition != 10 && peekCharAtPosition != 12 && peekCharAtPosition != 13 && peekCharAtPosition != ' ') {
            return false;
        }
        parsableByteArray.skipBytes(1);
        return true;
    }

    private static void parseFontSize(String str, WebvttCssStyle webvttCssStyle) {
        Matcher matcher = FONT_SIZE_PATTERN.matcher(Ascii.toLowerCase(str));
        if (!matcher.matches()) {
            Log.w(TAG, "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) Assertions.checkNotNull(matcher.group(2));
        str2.hashCode();
        char c11 = 65535;
        switch (str2.hashCode()) {
            case 37:
                if (str2.equals("%")) {
                    c11 = 0;
                    break;
                }
                break;
            case 3240:
                if (str2.equals(UserDataStore.EMAIL)) {
                    c11 = 1;
                    break;
                }
                break;
            case 3592:
                if (str2.equals("px")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                webvttCssStyle.setFontSizeUnit(3);
                break;
            case 1:
                webvttCssStyle.setFontSizeUnit(2);
                break;
            case 2:
                webvttCssStyle.setFontSizeUnit(1);
                break;
            default:
                throw new IllegalStateException();
        }
        webvttCssStyle.setFontSize(Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1))));
    }

    private static String parseIdentifier(ParsableByteArray parsableByteArray, StringBuilder sb2) {
        boolean z11 = false;
        sb2.setLength(0);
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        while (position < limit && !z11) {
            char c11 = (char) parsableByteArray.getData()[position];
            if ((c11 < 'A' || c11 > 'Z') && ((c11 < 'a' || c11 > 'z') && !((c11 >= '0' && c11 <= '9') || c11 == '#' || c11 == '-' || c11 == '.' || c11 == '_'))) {
                z11 = true;
            } else {
                position++;
                sb2.append(c11);
            }
        }
        parsableByteArray.skipBytes(position - parsableByteArray.getPosition());
        return sb2.toString();
    }

    @Nullable
    public static String parseNextToken(ParsableByteArray parsableByteArray, StringBuilder sb2) {
        skipWhitespaceAndComments(parsableByteArray);
        if (parsableByteArray.bytesLeft() == 0) {
            return null;
        }
        String parseIdentifier = parseIdentifier(parsableByteArray, sb2);
        if (!"".equals(parseIdentifier)) {
            return parseIdentifier;
        }
        return "" + ((char) parsableByteArray.readUnsignedByte());
    }

    @Nullable
    private static String parsePropertyValue(ParsableByteArray parsableByteArray, StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder();
        boolean z11 = false;
        while (!z11) {
            int position = parsableByteArray.getPosition();
            String parseNextToken = parseNextToken(parsableByteArray, sb2);
            if (parseNextToken == null) {
                return null;
            }
            if (RULE_END.equals(parseNextToken) || TypesAliasesKt.separator.equals(parseNextToken)) {
                parsableByteArray.setPosition(position);
                z11 = true;
            } else {
                sb3.append(parseNextToken);
            }
        }
        return sb3.toString();
    }

    @Nullable
    private static String parseSelector(ParsableByteArray parsableByteArray, StringBuilder sb2) {
        String str;
        skipWhitespaceAndComments(parsableByteArray);
        if (parsableByteArray.bytesLeft() < 5 || !"::cue".equals(parsableByteArray.readString(5))) {
            return null;
        }
        int position = parsableByteArray.getPosition();
        String parseNextToken = parseNextToken(parsableByteArray, sb2);
        if (parseNextToken == null) {
            return null;
        }
        if (RULE_START.equals(parseNextToken)) {
            parsableByteArray.setPosition(position);
            return "";
        }
        if ("(".equals(parseNextToken)) {
            str = readCueTarget(parsableByteArray);
        } else {
            str = null;
        }
        if (!")".equals(parseNextToken(parsableByteArray, sb2))) {
            return null;
        }
        return str;
    }

    private static void parseStyleDeclaration(ParsableByteArray parsableByteArray, WebvttCssStyle webvttCssStyle, StringBuilder sb2) {
        skipWhitespaceAndComments(parsableByteArray);
        String parseIdentifier = parseIdentifier(parsableByteArray, sb2);
        if (!"".equals(parseIdentifier) && CertificateUtil.DELIMITER.equals(parseNextToken(parsableByteArray, sb2))) {
            skipWhitespaceAndComments(parsableByteArray);
            String parsePropertyValue = parsePropertyValue(parsableByteArray, sb2);
            if (parsePropertyValue != null && !"".equals(parsePropertyValue)) {
                int position = parsableByteArray.getPosition();
                String parseNextToken = parseNextToken(parsableByteArray, sb2);
                if (!TypesAliasesKt.separator.equals(parseNextToken)) {
                    if (RULE_END.equals(parseNextToken)) {
                        parsableByteArray.setPosition(position);
                    } else {
                        return;
                    }
                }
                if ("color".equals(parseIdentifier)) {
                    webvttCssStyle.setFontColor(ColorParser.parseCssColor(parsePropertyValue));
                } else if (PROPERTY_BGCOLOR.equals(parseIdentifier)) {
                    webvttCssStyle.setBackgroundColor(ColorParser.parseCssColor(parsePropertyValue));
                } else {
                    boolean z11 = true;
                    if (PROPERTY_RUBY_POSITION.equals(parseIdentifier)) {
                        if (VALUE_OVER.equals(parsePropertyValue)) {
                            webvttCssStyle.setRubyPosition(1);
                        } else if (VALUE_UNDER.equals(parsePropertyValue)) {
                            webvttCssStyle.setRubyPosition(2);
                        }
                    } else if (PROPERTY_TEXT_COMBINE_UPRIGHT.equals(parseIdentifier)) {
                        if (!"all".equals(parsePropertyValue) && !parsePropertyValue.startsWith(VALUE_DIGITS)) {
                            z11 = false;
                        }
                        webvttCssStyle.setCombineUpright(z11);
                    } else if (PROPERTY_TEXT_DECORATION.equals(parseIdentifier)) {
                        if ("underline".equals(parsePropertyValue)) {
                            webvttCssStyle.setUnderline(true);
                        }
                    } else if (PROPERTY_FONT_FAMILY.equals(parseIdentifier)) {
                        webvttCssStyle.setFontFamily(parsePropertyValue);
                    } else if (PROPERTY_FONT_WEIGHT.equals(parseIdentifier)) {
                        if ("bold".equals(parsePropertyValue)) {
                            webvttCssStyle.setBold(true);
                        }
                    } else if (PROPERTY_FONT_STYLE.equals(parseIdentifier)) {
                        if ("italic".equals(parsePropertyValue)) {
                            webvttCssStyle.setItalic(true);
                        }
                    } else if (PROPERTY_FONT_SIZE.equals(parseIdentifier)) {
                        parseFontSize(parsePropertyValue, webvttCssStyle);
                    }
                }
            }
        }
    }

    private static char peekCharAtPosition(ParsableByteArray parsableByteArray, int i11) {
        return (char) parsableByteArray.getData()[i11];
    }

    private static String readCueTarget(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        boolean z11 = false;
        while (position < limit && !z11) {
            int i11 = position + 1;
            if (((char) parsableByteArray.getData()[position]) == ')') {
                z11 = true;
            } else {
                z11 = false;
            }
            position = i11;
        }
        return parsableByteArray.readString((position - 1) - parsableByteArray.getPosition()).trim();
    }

    public static void skipStyleBlock(ParsableByteArray parsableByteArray) {
        do {
        } while (!TextUtils.isEmpty(parsableByteArray.readLine()));
    }

    public static void skipWhitespaceAndComments(ParsableByteArray parsableByteArray) {
        while (true) {
            boolean z11 = true;
            while (parsableByteArray.bytesLeft() > 0 && z11) {
                if (!maybeSkipWhitespace(parsableByteArray) && !maybeSkipComment(parsableByteArray)) {
                    z11 = false;
                }
            }
            return;
        }
    }

    public List<WebvttCssStyle> parseBlock(ParsableByteArray parsableByteArray) {
        boolean z11;
        this.stringBuilder.setLength(0);
        int position = parsableByteArray.getPosition();
        skipStyleBlock(parsableByteArray);
        this.styleInput.reset(parsableByteArray.getData(), parsableByteArray.getPosition());
        this.styleInput.setPosition(position);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String parseSelector = parseSelector(this.styleInput, this.stringBuilder);
            if (parseSelector == null || !RULE_START.equals(parseNextToken(this.styleInput, this.stringBuilder))) {
                return arrayList;
            }
            WebvttCssStyle webvttCssStyle = new WebvttCssStyle();
            applySelectorToStyle(webvttCssStyle, parseSelector);
            String str = null;
            boolean z12 = false;
            while (!z12) {
                int position2 = this.styleInput.getPosition();
                String parseNextToken = parseNextToken(this.styleInput, this.stringBuilder);
                if (parseNextToken == null || RULE_END.equals(parseNextToken)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    this.styleInput.setPosition(position2);
                    parseStyleDeclaration(this.styleInput, webvttCssStyle, this.stringBuilder);
                }
                str = parseNextToken;
                z12 = z11;
            }
            if (RULE_END.equals(str)) {
                arrayList.add(webvttCssStyle);
            }
        }
    }
}
