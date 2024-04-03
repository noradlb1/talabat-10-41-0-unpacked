package com.huawei.hms.common.util;

import com.huawei.hms.common.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class Objects {

    public static final class ToStringHelper {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f48230a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f48231b;

        private ToStringHelper(Object obj) {
            this.f48231b = Preconditions.checkNotNull(obj);
            this.f48230a = new ArrayList();
        }

        public ToStringHelper add(String str, Object obj) {
            String valueOf = String.valueOf(obj);
            List<String> list = this.f48230a;
            list.add(((String) Preconditions.checkNotNull(str)) + "=" + valueOf);
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(this.f48231b.getClass().getSimpleName());
            sb2.append(AbstractJsonLexerKt.BEGIN_OBJ);
            int size = this.f48230a.size();
            for (int i11 = 0; i11 < size; i11++) {
                sb2.append(this.f48230a.get(i11));
                if (i11 < size - 1) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
            }
            sb2.append(AbstractJsonLexerKt.END_OBJ);
            return sb2.toString();
        }
    }

    private Objects() {
        throw new AssertionError("illegal argument");
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj);
    }
}
