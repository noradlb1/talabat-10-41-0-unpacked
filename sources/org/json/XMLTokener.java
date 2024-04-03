package org.json;

import java.io.Reader;
import java.util.HashMap;
import kotlin.text.Typography;
import net.bytebuddy.pool.TypePool;

public class XMLTokener extends JSONTokener {
    public static final HashMap<String, Character> entity;

    static {
        HashMap<String, Character> hashMap = new HashMap<>(8);
        entity = hashMap;
        hashMap.put("amp", XML.AMP);
        hashMap.put("apos", XML.APOS);
        hashMap.put("gt", XML.GT);
        hashMap.put("lt", XML.LT);
        hashMap.put("quot", XML.QUOT);
    }

    public XMLTokener(Reader reader) {
        super(reader);
    }

    public static String unescapeEntity(String str) {
        int i11;
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (str.charAt(0) == '#') {
            if (str.charAt(1) == 'x') {
                i11 = Integer.parseInt(str.substring(2), 16);
            } else {
                i11 = Integer.parseInt(str.substring(1));
            }
            return new String(new int[]{i11}, 0, 1);
        }
        Character ch2 = entity.get(str);
        if (ch2 != null) {
            return ch2.toString();
        }
        return Typography.amp + str + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER;
    }

    public String nextCDATA() throws JSONException {
        StringBuilder sb2 = new StringBuilder();
        while (more()) {
            sb2.append(next());
            int length = sb2.length() - 3;
            if (length >= 0 && sb2.charAt(length) == ']' && sb2.charAt(length + 1) == ']' && sb2.charAt(length + 2) == '>') {
                sb2.setLength(length);
                return sb2.toString();
            }
        }
        throw syntaxError("Unclosed CDATA");
    }

    public Object nextContent() throws JSONException {
        char next;
        do {
            next = next();
        } while (Character.isWhitespace(next));
        if (next == 0) {
            return null;
        }
        if (next == '<') {
            return XML.LT;
        }
        StringBuilder sb2 = new StringBuilder();
        while (next != 0) {
            if (next == '<') {
                back();
                return sb2.toString().trim();
            }
            if (next == '&') {
                sb2.append(nextEntity(next));
            } else {
                sb2.append(next);
            }
            next = next();
        }
        return sb2.toString().trim();
    }

    public Object nextEntity(char c11) throws JSONException {
        char next;
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            next = next();
            if (!Character.isLetterOrDigit(next) && next != '#') {
                break;
            }
            sb2.append(Character.toLowerCase(next));
        }
        if (next == ';') {
            return unescapeEntity(sb2.toString());
        }
        throw syntaxError("Missing ';' in XML entity: &" + sb2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f A[LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object nextMeta() throws org.json.JSONException {
        /*
            r6 = this;
        L_0x0000:
            char r0 = r6.next()
            boolean r1 = java.lang.Character.isWhitespace(r0)
            if (r1 != 0) goto L_0x0000
            if (r0 == 0) goto L_0x0064
            r1 = 39
            if (r0 == r1) goto L_0x0052
            r2 = 47
            if (r0 == r2) goto L_0x004f
            r3 = 33
            if (r0 == r3) goto L_0x004c
            r4 = 34
            if (r0 == r4) goto L_0x0052
            switch(r0) {
                case 60: goto L_0x0049;
                case 61: goto L_0x0046;
                case 62: goto L_0x0043;
                case 63: goto L_0x0040;
                default: goto L_0x001f;
            }
        L_0x001f:
            char r0 = r6.next()
            boolean r5 = java.lang.Character.isWhitespace(r0)
            if (r5 == 0) goto L_0x002c
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            return r0
        L_0x002c:
            if (r0 == 0) goto L_0x003a
            if (r0 == r1) goto L_0x003a
            if (r0 == r2) goto L_0x003a
            if (r0 == r3) goto L_0x003a
            if (r0 == r4) goto L_0x003a
            switch(r0) {
                case 60: goto L_0x003a;
                case 61: goto L_0x003a;
                case 62: goto L_0x003a;
                case 63: goto L_0x003a;
                default: goto L_0x0039;
            }
        L_0x0039:
            goto L_0x001f
        L_0x003a:
            r6.back()
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            return r0
        L_0x0040:
            java.lang.Character r0 = org.json.XML.QUEST
            return r0
        L_0x0043:
            java.lang.Character r0 = org.json.XML.GT
            return r0
        L_0x0046:
            java.lang.Character r0 = org.json.XML.EQ
            return r0
        L_0x0049:
            java.lang.Character r0 = org.json.XML.LT
            return r0
        L_0x004c:
            java.lang.Character r0 = org.json.XML.BANG
            return r0
        L_0x004f:
            java.lang.Character r0 = org.json.XML.SLASH
            return r0
        L_0x0052:
            char r1 = r6.next()
            if (r1 == 0) goto L_0x005d
            if (r1 != r0) goto L_0x0052
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            return r0
        L_0x005d:
            java.lang.String r0 = "Unterminated string"
            org.json.JSONException r0 = r6.syntaxError(r0)
            throw r0
        L_0x0064:
            java.lang.String r0 = "Misshaped meta tag"
            org.json.JSONException r0 = r6.syntaxError(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.XMLTokener.nextMeta():java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005a, code lost:
        throw syntaxError("Bad character in a name");
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024 A[LOOP_START, PHI: r0 
      PHI: (r0v13 char) = (r0v0 char), (r0v14 char) binds: [B:12:0x001f, B:26:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object nextToken() throws org.json.JSONException {
        /*
            r7 = this;
        L_0x0000:
            char r0 = r7.next()
            boolean r1 = java.lang.Character.isWhitespace(r0)
            if (r1 != 0) goto L_0x0000
            if (r0 == 0) goto L_0x009f
            r1 = 39
            if (r0 == r1) goto L_0x0076
            r2 = 47
            if (r0 == r2) goto L_0x0073
            r3 = 33
            if (r0 == r3) goto L_0x0070
            r4 = 34
            if (r0 == r4) goto L_0x0076
            switch(r0) {
                case 60: goto L_0x0069;
                case 61: goto L_0x0066;
                case 62: goto L_0x0063;
                case 63: goto L_0x0060;
                default: goto L_0x001f;
            }
        L_0x001f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L_0x0024:
            r5.append(r0)
            char r0 = r7.next()
            boolean r6 = java.lang.Character.isWhitespace(r0)
            if (r6 == 0) goto L_0x0036
            java.lang.String r0 = r5.toString()
            return r0
        L_0x0036:
            if (r0 == 0) goto L_0x005b
            if (r0 == r1) goto L_0x0054
            if (r0 == r2) goto L_0x004c
            r6 = 91
            if (r0 == r6) goto L_0x004c
            r6 = 93
            if (r0 == r6) goto L_0x004c
            if (r0 == r3) goto L_0x004c
            if (r0 == r4) goto L_0x0054
            switch(r0) {
                case 60: goto L_0x0054;
                case 61: goto L_0x004c;
                case 62: goto L_0x004c;
                case 63: goto L_0x004c;
                default: goto L_0x004b;
            }
        L_0x004b:
            goto L_0x0024
        L_0x004c:
            r7.back()
            java.lang.String r0 = r5.toString()
            return r0
        L_0x0054:
            java.lang.String r0 = "Bad character in a name"
            org.json.JSONException r0 = r7.syntaxError(r0)
            throw r0
        L_0x005b:
            java.lang.String r0 = r5.toString()
            return r0
        L_0x0060:
            java.lang.Character r0 = org.json.XML.QUEST
            return r0
        L_0x0063:
            java.lang.Character r0 = org.json.XML.GT
            return r0
        L_0x0066:
            java.lang.Character r0 = org.json.XML.EQ
            return r0
        L_0x0069:
            java.lang.String r0 = "Misplaced '<'"
            org.json.JSONException r0 = r7.syntaxError(r0)
            throw r0
        L_0x0070:
            java.lang.Character r0 = org.json.XML.BANG
            return r0
        L_0x0073:
            java.lang.Character r0 = org.json.XML.SLASH
            return r0
        L_0x0076:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L_0x007b:
            char r2 = r7.next()
            if (r2 == 0) goto L_0x0098
            if (r2 != r0) goto L_0x0088
            java.lang.String r0 = r1.toString()
            return r0
        L_0x0088:
            r3 = 38
            if (r2 != r3) goto L_0x0094
            java.lang.Object r2 = r7.nextEntity(r2)
            r1.append(r2)
            goto L_0x007b
        L_0x0094:
            r1.append(r2)
            goto L_0x007b
        L_0x0098:
            java.lang.String r0 = "Unterminated string"
            org.json.JSONException r0 = r7.syntaxError(r0)
            throw r0
        L_0x009f:
            java.lang.String r0 = "Misshaped element"
            org.json.JSONException r0 = r7.syntaxError(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.XMLTokener.nextToken():java.lang.Object");
    }

    public void skipPast(String str) {
        boolean z11;
        char next;
        int length = str.length();
        char[] cArr = new char[length];
        int i11 = 0;
        while (i11 < length) {
            char next2 = next();
            if (next2 != 0) {
                cArr[i11] = next2;
                i11++;
            } else {
                return;
            }
        }
        int i12 = 0;
        while (true) {
            int i13 = 0;
            int i14 = i12;
            while (true) {
                if (i13 >= length) {
                    z11 = true;
                    break;
                } else if (cArr[i14] != str.charAt(i13)) {
                    z11 = false;
                    break;
                } else {
                    i14++;
                    if (i14 >= length) {
                        i14 -= length;
                    }
                    i13++;
                }
            }
            if (!z11 && (next = next()) != 0) {
                cArr[i12] = next;
                i12++;
                if (i12 >= length) {
                    i12 -= length;
                }
            } else {
                return;
            }
        }
    }

    public XMLTokener(String str) {
        super(str);
    }
}
