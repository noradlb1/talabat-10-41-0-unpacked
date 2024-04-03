package org.mockito.internal.matchers.text;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.lang.reflect.Array;
import java.util.Map;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class ValuePrinter {
    private ValuePrinter() {
    }

    private static String descriptionOf(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (RuntimeException unused) {
            return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
        }
    }

    public static String print(final Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof String) {
            return '\"' + obj.toString() + '\"';
        } else if (obj instanceof Character) {
            return printChar(((Character) obj).charValue());
        } else {
            if (obj instanceof Long) {
                return obj + "L";
            } else if (obj instanceof Double) {
                return obj + "d";
            } else if (obj instanceof Float) {
                return obj + "f";
            } else if (obj instanceof Short) {
                return "(short) " + obj;
            } else if (obj instanceof Byte) {
                return String.format("(byte) 0x%02X", new Object[]{(Byte) obj});
            } else if (obj instanceof Map) {
                return printMap((Map) obj);
            } else {
                if (obj.getClass().isArray()) {
                    return printValues("[", IndicativeSentencesGeneration.DEFAULT_SEPARATOR, "]", new Object() {
                        private int currentIndex = 0;

                        public /* synthetic */ void forEachRemaining(Consumer consumer) {
                            Iterator.CC.$default$forEachRemaining(this, consumer);
                        }

                        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                        }

                        public boolean hasNext() {
                            return this.currentIndex < Array.getLength(obj);
                        }

                        public Object next() {
                            Object obj = obj;
                            int i11 = this.currentIndex;
                            this.currentIndex = i11 + 1;
                            return Array.get(obj, i11);
                        }

                        public void remove() {
                            throw new UnsupportedOperationException("cannot remove items from an array");
                        }
                    });
                }
                if (obj instanceof FormattedText) {
                    return ((FormattedText) obj).getText();
                }
                return descriptionOf(obj);
            }
        }
    }

    private static String printChar(char c11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('\'');
        if (c11 == 9) {
            sb2.append("\\t");
        } else if (c11 == 10) {
            sb2.append("\\n");
        } else if (c11 == 13) {
            sb2.append("\\r");
        } else if (c11 != '\"') {
            sb2.append(c11);
        } else {
            sb2.append("\\\"");
        }
        sb2.append('\'');
        return sb2.toString();
    }

    private static String printMap(Map<?, ?> map) {
        StringBuilder sb2 = new StringBuilder();
        java.util.Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            sb2.append(print(next.getKey()));
            sb2.append(" = ");
            sb2.append(print(next.getValue()));
            if (it.hasNext()) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
        }
        return "{" + sb2 + "}";
    }

    public static String printValues(String str, String str2, String str3, java.util.Iterator<?> it) {
        if (str == null) {
            str = "(";
        }
        if (str2 == null) {
            str2 = ",";
        }
        if (str3 == null) {
            str3 = ")";
        }
        StringBuilder sb2 = new StringBuilder(str);
        while (it.hasNext()) {
            sb2.append(print(it.next()));
            if (it.hasNext()) {
                sb2.append(str2);
            }
        }
        sb2.append(str3);
        return sb2.toString();
    }
}
