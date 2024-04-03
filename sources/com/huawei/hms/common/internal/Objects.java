package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class Objects {

    public static final class ToStringHelper {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f48176a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f48177b;

        public final ToStringHelper add(String str, Object obj) {
            String str2 = (String) Preconditions.checkNotNull(str);
            String valueOf = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(str2.length() + valueOf.length() + 1);
            sb2.append(str2);
            sb2.append("=");
            sb2.append(valueOf);
            this.f48176a.add(sb2.toString());
            return this;
        }

        public final String toString() {
            String simpleName = this.f48177b.getClass().getSimpleName();
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(simpleName);
            sb2.append(AbstractJsonLexerKt.BEGIN_OBJ);
            int size = this.f48176a.size();
            for (int i11 = 0; i11 < size; i11++) {
                sb2.append(this.f48176a.get(i11));
                if (i11 < size - 1) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
            }
            sb2.append(AbstractJsonLexerKt.END_OBJ);
            return sb2.toString();
        }

        private ToStringHelper(Object obj) {
            this.f48177b = Preconditions.checkNotNull(obj);
            this.f48176a = new ArrayList();
        }
    }

    private Objects() {
        throw new AssertionError("Uninstantiable");
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        return obj != null && obj.equals(obj2);
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static boolean isNull(Object... objArr) {
        if (objArr == null) {
            return true;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj);
    }
}
