package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.Map;
import java.util.TreeMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("( ");
        for (Map.Entry entry : entrySet()) {
            sb2.append(AbstractJsonLexerKt.BEGIN_OBJ);
            sb2.append(entry.getKey());
            sb2.append(AbstractJsonLexerKt.COLON);
            sb2.append(entry.getValue());
            sb2.append("}, ");
        }
        if (!isEmpty()) {
            sb2.replace(sb2.length() - 2, sb2.length(), "");
        }
        sb2.append(" )");
        return sb2.toString();
    }
}
