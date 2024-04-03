package androidx.constraintlayout.core.parser;

import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class CLObject extends CLContainer implements Iterable<CLKey> {

    public class CLObjectIterator implements Iterator {

        /* renamed from: b  reason: collision with root package name */
        public CLObject f10666b;

        /* renamed from: c  reason: collision with root package name */
        public int f10667c = 0;

        public CLObjectIterator(CLObject cLObject) {
            this.f10666b = cLObject;
        }

        public boolean hasNext() {
            return this.f10667c < this.f10666b.size();
        }

        public Object next() {
            CLKey cLKey = (CLKey) this.f10666b.f10659g.get(this.f10667c);
            this.f10667c++;
            return cLKey;
        }
    }

    public CLObject(char[] cArr) {
        super(cArr);
    }

    public static CLObject allocate(char[] cArr) {
        return new CLObject(cArr);
    }

    public Iterator iterator() {
        return new CLObjectIterator(this);
    }

    public String toFormattedJSON() {
        return toFormattedJSON(0, 0);
    }

    public String toJSON() {
        StringBuilder sb2 = new StringBuilder(b() + "{ ");
        Iterator<CLElement> it = this.f10659g.iterator();
        boolean z11 = true;
        while (it.hasNext()) {
            CLElement next = it.next();
            if (!z11) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            } else {
                z11 = false;
            }
            sb2.append(next.toJSON());
        }
        sb2.append(" }");
        return sb2.toString();
    }

    public String toFormattedJSON(int i11, int i12) {
        StringBuilder sb2 = new StringBuilder(b());
        sb2.append("{\n");
        Iterator<CLElement> it = this.f10659g.iterator();
        boolean z11 = true;
        while (it.hasNext()) {
            CLElement next = it.next();
            if (!z11) {
                sb2.append(",\n");
            } else {
                z11 = false;
            }
            sb2.append(next.toFormattedJSON(CLElement.f10661f + i11, i12 - 1));
        }
        sb2.append(StringUtils.LF);
        a(sb2, i11);
        sb2.append("}");
        return sb2.toString();
    }
}
