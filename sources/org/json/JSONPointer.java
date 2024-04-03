package org.json;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JSONPointer {
    private static final String ENCODING = "utf-8";
    private final List<String> refTokens;

    public JSONPointer(String str) {
        String str2;
        if (str == null) {
            throw new NullPointerException("pointer cannot be null");
        } else if (str.isEmpty() || str.equals("#")) {
            this.refTokens = Collections.emptyList();
        } else {
            if (str.startsWith("#/")) {
                try {
                    str2 = URLDecoder.decode(str.substring(2), ENCODING);
                } catch (UnsupportedEncodingException e11) {
                    throw new RuntimeException(e11);
                }
            } else if (str.startsWith("/")) {
                str2 = str.substring(1);
            } else {
                throw new IllegalArgumentException("a JSON pointer should start with '/' or '#/'");
            }
            this.refTokens = new ArrayList();
            int i11 = -1;
            while (true) {
                int i12 = i11 + 1;
                int indexOf = str2.indexOf(47, i12);
                if (i12 == indexOf || i12 == str2.length()) {
                    this.refTokens.add("");
                } else if (indexOf >= 0) {
                    this.refTokens.add(unescape(str2.substring(i12, indexOf)));
                } else {
                    this.refTokens.add(unescape(str2.substring(i12)));
                }
                if (indexOf >= 0) {
                    i11 = indexOf;
                } else {
                    return;
                }
            }
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private String escape(String str) {
        return str.replace("~", "~0").replace("/", "~1").replace("\\", "\\\\").replace("\"", "\\\"");
    }

    private Object readByIndexToken(Object obj, String str) throws JSONPointerException {
        int parseInt;
        try {
            parseInt = Integer.parseInt(str);
            JSONArray jSONArray = (JSONArray) obj;
            if (parseInt < jSONArray.length()) {
                return jSONArray.get(parseInt);
            }
            throw new JSONPointerException(String.format("index %d is out of bounds - the array has %d elements", new Object[]{Integer.valueOf(parseInt), Integer.valueOf(jSONArray.length())}));
        } catch (JSONException e11) {
            throw new JSONPointerException("Error reading value at index position " + parseInt, e11);
        } catch (NumberFormatException e12) {
            throw new JSONPointerException(String.format("%s is not an array index", new Object[]{str}), e12);
        }
    }

    private String unescape(String str) {
        return str.replace("~1", "/").replace("~0", "~").replace("\\\"", "\"").replace("\\\\", "\\");
    }

    public Object queryFrom(Object obj) throws JSONPointerException {
        if (this.refTokens.isEmpty()) {
            return obj;
        }
        for (String next : this.refTokens) {
            if (obj instanceof JSONObject) {
                obj = ((JSONObject) obj).opt(unescape(next));
            } else if (obj instanceof JSONArray) {
                obj = readByIndexToken(obj, next);
            } else {
                throw new JSONPointerException(String.format("value [%s] is not an array or object therefore its key %s cannot be resolved", new Object[]{obj, next}));
            }
        }
        return obj;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("");
        for (String escape : this.refTokens) {
            sb2.append('/');
            sb2.append(escape(escape));
        }
        return sb2.toString();
    }

    public String toURIFragment() {
        try {
            StringBuilder sb2 = new StringBuilder("#");
            for (String encode : this.refTokens) {
                sb2.append('/');
                sb2.append(URLEncoder.encode(encode, ENCODING));
            }
            return sb2.toString();
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static class Builder {
        private final List<String> refTokens = new ArrayList();

        public Builder append(String str) {
            if (str != null) {
                this.refTokens.add(str);
                return this;
            }
            throw new NullPointerException("token cannot be null");
        }

        public JSONPointer build() {
            return new JSONPointer(this.refTokens);
        }

        public Builder append(int i11) {
            this.refTokens.add(String.valueOf(i11));
            return this;
        }
    }

    public JSONPointer(List<String> list) {
        this.refTokens = new ArrayList(list);
    }
}
