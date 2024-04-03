package org.json;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.asm.Advice;

@Instrumented
public class JSONWriter {
    private static final int maxdepth = 200;
    private boolean comma = false;
    protected char mode = 'i';
    private final JSONObject[] stack = new JSONObject[200];
    private int top = 0;
    protected Appendable writer;

    public JSONWriter(Appendable appendable) {
        this.writer = appendable;
    }

    private JSONWriter append(String str) throws JSONException {
        if (str != null) {
            char c11 = this.mode;
            if (c11 == 'o' || c11 == 'a') {
                try {
                    if (this.comma && c11 == 'a') {
                        this.writer.append(AbstractJsonLexerKt.COMMA);
                    }
                    this.writer.append(str);
                    if (this.mode == 'o') {
                        this.mode = 'k';
                    }
                    this.comma = true;
                    return this;
                } catch (IOException e11) {
                    throw new JSONException((Throwable) e11);
                }
            } else {
                throw new JSONException("Value out of sequence.");
            }
        } else {
            throw new JSONException("Null pointer");
        }
    }

    private JSONWriter end(char c11, char c12) throws JSONException {
        String str;
        if (this.mode != c11) {
            if (c11 == 'a') {
                str = "Misplaced endArray.";
            } else {
                str = "Misplaced endObject.";
            }
            throw new JSONException(str);
        }
        pop(c11);
        try {
            this.writer.append(c12);
            this.comma = true;
            return this;
        } catch (IOException e11) {
            throw new JSONException((Throwable) e11);
        }
    }

    private void pop(char c11) throws JSONException {
        char c12;
        int i11 = this.top;
        if (i11 > 0) {
            JSONObject[] jSONObjectArr = this.stack;
            char c13 = 'a';
            if (jSONObjectArr[i11 - 1] == null) {
                c12 = 'a';
            } else {
                c12 = 'k';
            }
            if (c12 == c11) {
                int i12 = i11 - 1;
                this.top = i12;
                if (i12 == 0) {
                    c13 = Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL;
                } else if (jSONObjectArr[i12 - 1] != null) {
                    c13 = 'k';
                }
                this.mode = c13;
                return;
            }
            throw new JSONException("Nesting error.");
        }
        throw new JSONException("Nesting error.");
    }

    private void push(JSONObject jSONObject) throws JSONException {
        char c11;
        int i11 = this.top;
        if (i11 < 200) {
            this.stack[i11] = jSONObject;
            if (jSONObject == null) {
                c11 = 'a';
            } else {
                c11 = 'k';
            }
            this.mode = c11;
            this.top = i11 + 1;
            return;
        }
        throw new JSONException("Nesting too deep.");
    }

    public static String valueToString(Object obj) throws JSONException {
        if (obj == null || obj.equals((Object) null)) {
            return "null";
        }
        if (obj instanceof JSONString) {
            try {
                String jSONString = ((JSONString) obj).toJSONString();
                if (jSONString instanceof String) {
                    return jSONString;
                }
                throw new JSONException("Bad value from toJSONString: " + jSONString);
            } catch (Exception e11) {
                throw new JSONException((Throwable) e11);
            }
        } else if (obj instanceof Number) {
            String numberToString = JSONObject.numberToString((Number) obj);
            try {
                new BigDecimal(numberToString);
                return numberToString;
            } catch (NumberFormatException unused) {
                return JSONObject.quote(numberToString);
            }
        } else if ((obj instanceof Boolean) || (obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            return obj.toString();
        } else {
            if (obj instanceof Map) {
                return JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) (Map) obj));
            }
            if (obj instanceof Collection) {
                return JSONArrayInstrumentation.toString(new JSONArray((Collection<?>) (Collection) obj));
            }
            if (obj.getClass().isArray()) {
                return JSONArrayInstrumentation.toString(new JSONArray(obj));
            }
            if (obj instanceof Enum) {
                return JSONObject.quote(((Enum) obj).name());
            }
            return JSONObject.quote(obj.toString());
        }
    }

    public JSONWriter array() throws JSONException {
        char c11 = this.mode;
        if (c11 == 'i' || c11 == 'o' || c11 == 'a') {
            push((JSONObject) null);
            append("[");
            this.comma = false;
            return this;
        }
        throw new JSONException("Misplaced array.");
    }

    public JSONWriter endArray() throws JSONException {
        return end('a', AbstractJsonLexerKt.END_LIST);
    }

    public JSONWriter endObject() throws JSONException {
        return end('k', AbstractJsonLexerKt.END_OBJ);
    }

    public JSONWriter key(String str) throws JSONException {
        if (str == null) {
            throw new JSONException("Null key.");
        } else if (this.mode == 'k') {
            try {
                JSONObject jSONObject = this.stack[this.top - 1];
                if (!jSONObject.has(str)) {
                    jSONObject.put(str, true);
                    if (this.comma) {
                        this.writer.append(AbstractJsonLexerKt.COMMA);
                    }
                    this.writer.append(JSONObject.quote(str));
                    this.writer.append(AbstractJsonLexerKt.COLON);
                    this.comma = false;
                    this.mode = 'o';
                    return this;
                }
                throw new JSONException("Duplicate key \"" + str + "\"");
            } catch (IOException e11) {
                throw new JSONException((Throwable) e11);
            }
        } else {
            throw new JSONException("Misplaced key.");
        }
    }

    public JSONWriter object() throws JSONException {
        if (this.mode == 'i') {
            this.mode = 'o';
        }
        char c11 = this.mode;
        if (c11 == 'o' || c11 == 'a') {
            append("{");
            push(new JSONObject());
            this.comma = false;
            return this;
        }
        throw new JSONException("Misplaced object.");
    }

    public JSONWriter value(boolean z11) throws JSONException {
        return append(z11 ? "true" : "false");
    }

    public JSONWriter value(double d11) throws JSONException {
        return value((Object) Double.valueOf(d11));
    }

    public JSONWriter value(long j11) throws JSONException {
        return append(Long.toString(j11));
    }

    public JSONWriter value(Object obj) throws JSONException {
        return append(valueToString(obj));
    }
}
