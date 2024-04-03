package org.junit.platform.engine;

import j$.util.Collection;
import j$.util.DesugarArrays;
import j$.util.Map;
import j$.util.function.Supplier;
import j$.util.stream.Collectors;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.engine.UniqueId;

class UniqueIdFormat implements Serializable {
    private static final UniqueIdFormat defaultFormat = new UniqueIdFormat('[', AbstractJsonLexerKt.COLON, AbstractJsonLexerKt.END_LIST, '/');
    private static final long serialVersionUID = 1;
    private final char closeSegment;
    private final HashMap<Character, String> encodedCharacterMap;
    private final char openSegment;
    private final char segmentDelimiter;
    private final Pattern segmentPattern;
    private final char typeValueSeparator;

    public UniqueIdFormat(char c11, char c12, char c13, char c14) {
        HashMap<Character, String> hashMap = new HashMap<>();
        this.encodedCharacterMap = hashMap;
        this.openSegment = c11;
        this.typeValueSeparator = c12;
        this.closeSegment = c13;
        this.segmentDelimiter = c14;
        this.segmentPattern = Pattern.compile(String.format("%s(.+)%s(.+)%s", new Object[]{quote(c11), quote(c12), quote(c13)}), 32);
        Map.EL.computeIfAbsent(hashMap, '%', new i());
        Map.EL.computeIfAbsent(hashMap, Character.valueOf(SignatureVisitor.EXTENDS), new i());
        Map.EL.computeIfAbsent(hashMap, Character.valueOf(c11), new i());
        Map.EL.computeIfAbsent(hashMap, Character.valueOf(c12), new i());
        Map.EL.computeIfAbsent(hashMap, Character.valueOf(c13), new i());
        Map.EL.computeIfAbsent(hashMap, Character.valueOf(c14), new i());
    }

    private String checkAllowed(String str) {
        checkDoesNotContain(str, this.segmentDelimiter);
        checkDoesNotContain(str, this.typeValueSeparator);
        checkDoesNotContain(str, this.openSegment);
        checkDoesNotContain(str, this.closeSegment);
        return str;
    }

    private void checkDoesNotContain(String str, char c11) {
        Preconditions.condition(str.indexOf(c11) < 0, (Supplier<String>) new f(str, c11));
    }

    /* access modifiers changed from: private */
    public UniqueId.Segment createSegment(String str) throws JUnitException {
        Matcher matcher = this.segmentPattern.matcher(str);
        if (matcher.matches()) {
            return new UniqueId.Segment(decode(checkAllowed(matcher.group(1))), decode(checkAllowed(matcher.group(2))));
        }
        throw new JUnitException(String.format("'%s' is not a well-formed UniqueId segment", new Object[]{str}));
    }

    private static String decode(String str) {
        try {
            return URLDecoder.decode(str, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e11) {
            throw new JUnitException("UTF-8 should be supported", e11);
        }
    }

    /* access modifiers changed from: private */
    public String describe(UniqueId.Segment segment) {
        return this.openSegment + (encode(segment.getType()) + this.typeValueSeparator + encode(segment.getValue())) + this.closeSegment;
    }

    /* access modifiers changed from: private */
    public static String encode(char c11) {
        try {
            return URLEncoder.encode(String.valueOf(c11), StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e11) {
            throw new AssertionError("UTF-8 should be supported", e11);
        }
    }

    public static UniqueIdFormat f() {
        return defaultFormat;
    }

    private static String quote(char c11) {
        return Pattern.quote(String.valueOf(c11));
    }

    public String e(UniqueId uniqueId) {
        return (String) Collection.EL.stream(uniqueId.getSegments()).map(new g(this)).collect(Collectors.joining(String.valueOf(this.segmentDelimiter)));
    }

    public UniqueId g(String str) throws JUnitException {
        return new UniqueId(this, (List<UniqueId.Segment>) (List) DesugarArrays.stream((T[]) str.split(String.valueOf(this.segmentDelimiter))).map(new h(this)).collect(Collectors.toList()));
    }

    private String encode(String str) {
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            String str2 = this.encodedCharacterMap.get(Character.valueOf(charAt));
            if (str2 == null) {
                sb2.append(charAt);
            } else {
                sb2.append(str2);
            }
        }
        return sb2.toString();
    }
}
