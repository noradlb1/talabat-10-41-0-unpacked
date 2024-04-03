package androidx.constraintlayout.core.parser;

import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class CLArray extends CLContainer {
    public CLArray(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLArray(cArr);
    }

    public String toFormattedJSON(int i11, int i12) {
        StringBuilder sb2 = new StringBuilder();
        String json = toJSON();
        if (i12 > 0 || json.length() + i11 >= CLElement.f10660e) {
            sb2.append("[\n");
            Iterator<CLElement> it = this.f10659g.iterator();
            boolean z11 = true;
            while (it.hasNext()) {
                CLElement next = it.next();
                if (!z11) {
                    sb2.append(",\n");
                } else {
                    z11 = false;
                }
                a(sb2, CLElement.f10661f + i11);
                sb2.append(next.toFormattedJSON(CLElement.f10661f + i11, i12 - 1));
            }
            sb2.append(StringUtils.LF);
            a(sb2, i11);
            sb2.append("]");
        } else {
            sb2.append(json);
        }
        return sb2.toString();
    }

    public String toJSON() {
        StringBuilder sb2 = new StringBuilder(b() + "[");
        boolean z11 = true;
        for (int i11 = 0; i11 < this.f10659g.size(); i11++) {
            if (!z11) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            } else {
                z11 = false;
            }
            sb2.append(this.f10659g.get(i11).toJSON());
        }
        return sb2 + "]";
    }
}
