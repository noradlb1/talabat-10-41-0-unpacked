package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class MoreObjects {

    public static final class ToStringHelper {
        private final String className;
        private final ValueHolder holderHead;
        private ValueHolder holderTail;
        private boolean omitEmptyValues;
        private boolean omitNullValues;

        public static final class UnconditionalValueHolder extends ValueHolder {
            private UnconditionalValueHolder() {
                super();
            }
        }

        public static class ValueHolder {
            @CheckForNull

            /* renamed from: name  reason: collision with root package name */
            String f44610name;
            @CheckForNull
            ValueHolder next;
            @CheckForNull
            Object value;

            private ValueHolder() {
            }
        }

        private ValueHolder addHolder() {
            ValueHolder valueHolder = new ValueHolder();
            this.holderTail.next = valueHolder;
            this.holderTail = valueHolder;
            return valueHolder;
        }

        private UnconditionalValueHolder addUnconditionalHolder() {
            UnconditionalValueHolder unconditionalValueHolder = new UnconditionalValueHolder();
            this.holderTail.next = unconditionalValueHolder;
            this.holderTail = unconditionalValueHolder;
            return unconditionalValueHolder;
        }

        private static boolean isEmpty(Object obj) {
            if (obj instanceof CharSequence) {
                if (((CharSequence) obj).length() == 0) {
                    return true;
                }
                return false;
            } else if (obj instanceof Collection) {
                return ((Collection) obj).isEmpty();
            } else {
                if (obj instanceof Map) {
                    return ((Map) obj).isEmpty();
                }
                if (obj instanceof Optional) {
                    return !((Optional) obj).isPresent();
                }
                if (!obj.getClass().isArray()) {
                    return false;
                }
                if (Array.getLength(obj) == 0) {
                    return true;
                }
                return false;
            }
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, @CheckForNull Object obj) {
            return addHolder(str, obj);
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(@CheckForNull Object obj) {
            return addHolder(obj);
        }

        @CanIgnoreReturnValue
        public ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        public String toString() {
            boolean z11 = this.omitNullValues;
            boolean z12 = this.omitEmptyValues;
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(this.className);
            sb2.append(AbstractJsonLexerKt.BEGIN_OBJ);
            String str = "";
            for (ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
                Object obj = valueHolder.value;
                if (!(valueHolder instanceof UnconditionalValueHolder)) {
                    if (obj == null) {
                        if (z11) {
                        }
                    } else if (z12 && isEmpty(obj)) {
                    }
                }
                sb2.append(str);
                String str2 = valueHolder.f44610name;
                if (str2 != null) {
                    sb2.append(str2);
                    sb2.append(SignatureVisitor.INSTANCEOF);
                }
                if (obj == null || !obj.getClass().isArray()) {
                    sb2.append(obj);
                } else {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    sb2.append(deepToString, 1, deepToString.length() - 1);
                }
                str = IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
            }
            sb2.append(AbstractJsonLexerKt.END_OBJ);
            return sb2.toString();
        }

        private ToStringHelper(String str) {
            ValueHolder valueHolder = new ValueHolder();
            this.holderHead = valueHolder;
            this.holderTail = valueHolder;
            this.omitNullValues = false;
            this.omitEmptyValues = false;
            this.className = (String) Preconditions.checkNotNull(str);
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, boolean z11) {
            return addUnconditionalHolder(str, String.valueOf(z11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(boolean z11) {
            return addUnconditionalHolder(String.valueOf(z11));
        }

        @CanIgnoreReturnValue
        private ToStringHelper addHolder(@CheckForNull Object obj) {
            addHolder().value = obj;
            return this;
        }

        @CanIgnoreReturnValue
        private ToStringHelper addUnconditionalHolder(Object obj) {
            addUnconditionalHolder().value = obj;
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, char c11) {
            return addUnconditionalHolder(str, String.valueOf(c11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(char c11) {
            return addUnconditionalHolder(String.valueOf(c11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, double d11) {
            return addUnconditionalHolder(str, String.valueOf(d11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(double d11) {
            return addUnconditionalHolder(String.valueOf(d11));
        }

        @CanIgnoreReturnValue
        private ToStringHelper addHolder(String str, @CheckForNull Object obj) {
            ValueHolder addHolder = addHolder();
            addHolder.value = obj;
            addHolder.f44610name = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @CanIgnoreReturnValue
        private ToStringHelper addUnconditionalHolder(String str, Object obj) {
            UnconditionalValueHolder addUnconditionalHolder = addUnconditionalHolder();
            addUnconditionalHolder.value = obj;
            addUnconditionalHolder.f44610name = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, float f11) {
            return addUnconditionalHolder(str, String.valueOf(f11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(float f11) {
            return addUnconditionalHolder(String.valueOf(f11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, int i11) {
            return addUnconditionalHolder(str, String.valueOf(i11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(int i11) {
            return addUnconditionalHolder(String.valueOf(i11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, long j11) {
            return addUnconditionalHolder(str, String.valueOf(j11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(long j11) {
            return addUnconditionalHolder(String.valueOf(j11));
        }
    }

    private MoreObjects() {
    }

    public static <T> T firstNonNull(@CheckForNull T t11, @CheckForNull T t12) {
        if (t11 != null) {
            return t11;
        }
        if (t12 != null) {
            return t12;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }

    public static ToStringHelper toStringHelper(Class<?> cls) {
        return new ToStringHelper(cls.getSimpleName());
    }

    public static ToStringHelper toStringHelper(String str) {
        return new ToStringHelper(str);
    }
}
