package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import net.bytebuddy.utility.JavaConstant;
import org.apache.commons.lang3.StringUtils;

final class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final String LIST_SUFFIX = "List";
    private static final String MAP_SUFFIX = "Map";

    public static final void a(StringBuilder sb2, int i11, String str, Object obj) {
        if (obj instanceof List) {
            for (Object a11 : (List) obj) {
                a(sb2, i11, str, a11);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry a12 : ((Map) obj).entrySet()) {
                a(sb2, i11, str, a12);
            }
        } else {
            sb2.append(10);
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                sb2.append(' ');
            }
            sb2.append(str);
            if (obj instanceof String) {
                sb2.append(": \"");
                sb2.append(TextFormatEscaper.c((String) obj));
                sb2.append('\"');
            } else if (obj instanceof ByteString) {
                sb2.append(": \"");
                sb2.append(TextFormatEscaper.a((ByteString) obj));
                sb2.append('\"');
            } else if (obj instanceof GeneratedMessageLite) {
                sb2.append(" {");
                reflectivePrintWithIndent((GeneratedMessageLite) obj, sb2, i11 + 2);
                sb2.append(StringUtils.LF);
                while (i12 < i11) {
                    sb2.append(' ');
                    i12++;
                }
                sb2.append("}");
            } else if (obj instanceof Map.Entry) {
                sb2.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i14 = i11 + 2;
                a(sb2, i14, "key", entry.getKey());
                a(sb2, i14, "value", entry.getValue());
                sb2.append(StringUtils.LF);
                while (i12 < i11) {
                    sb2.append(' ');
                    i12++;
                }
                sb2.append("}");
            } else {
                sb2.append(": ");
                sb2.append(obj.toString());
            }
        }
    }

    public static String b(MessageLite messageLite, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        reflectivePrintWithIndent(messageLite, sb2, 0);
        return sb2.toString();
    }

    private static final String camelCaseToSnakeCase(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (Character.isUpperCase(charAt)) {
                sb2.append(JavaConstant.Dynamic.DEFAULT_NAME);
            }
            sb2.append(Character.toLowerCase(charAt));
        }
        return sb2.toString();
    }

    private static boolean isDefaultValue(Object obj) {
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof Float) {
            if (((Float) obj).floatValue() == 0.0f) {
                return true;
            }
            return false;
        } else if (obj instanceof Double) {
            if (((Double) obj).doubleValue() == 0.0d) {
                return true;
            }
            return false;
        } else if (obj instanceof String) {
            return obj.equals("");
        } else {
            if (obj instanceof ByteString) {
                return obj.equals(ByteString.EMPTY);
            }
            if (obj instanceof MessageLite) {
                if (obj == ((MessageLite) obj).getDefaultInstanceForType()) {
                    return true;
                }
                return false;
            } else if (!(obj instanceof Enum)) {
                return false;
            } else {
                if (((Enum) obj).ordinal() == 0) {
                    return true;
                }
                return false;
            }
        }
    }

    private static void reflectivePrintWithIndent(MessageLite messageLite, StringBuilder sb2, int i11) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Method method : messageLite.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String replaceFirst = str.replaceFirst("get", "");
            boolean z11 = true;
            if (replaceFirst.endsWith(LIST_SUFFIX) && !replaceFirst.endsWith(BUILDER_LIST_SUFFIX) && !replaceFirst.equals(LIST_SUFFIX)) {
                String str2 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1, replaceFirst.length() - 4);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    a(sb2, i11, camelCaseToSnakeCase(str2), GeneratedMessageLite.p(method2, messageLite, new Object[0]));
                }
            }
            if (replaceFirst.endsWith(MAP_SUFFIX) && !replaceFirst.equals(MAP_SUFFIX)) {
                String str3 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1, replaceFirst.length() - 3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    a(sb2, i11, camelCaseToSnakeCase(str3), GeneratedMessageLite.p(method3, messageLite, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set" + replaceFirst)) != null) {
                if (replaceFirst.endsWith(BYTES_SUFFIX)) {
                    if (hashMap.containsKey("get" + replaceFirst.substring(0, replaceFirst.length() - 5))) {
                    }
                }
                String str4 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1);
                Method method4 = (Method) hashMap.get("get" + replaceFirst);
                Method method5 = (Method) hashMap.get("has" + replaceFirst);
                if (method4 != null) {
                    Object p11 = GeneratedMessageLite.p(method4, messageLite, new Object[0]);
                    if (method5 != null) {
                        z11 = ((Boolean) GeneratedMessageLite.p(method5, messageLite, new Object[0])).booleanValue();
                    } else if (isDefaultValue(p11)) {
                        z11 = false;
                    }
                    if (z11) {
                        a(sb2, i11, camelCaseToSnakeCase(str4), p11);
                    }
                }
            }
        }
        if (messageLite instanceof GeneratedMessageLite.ExtendableMessage) {
            Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> it = ((GeneratedMessageLite.ExtendableMessage) messageLite).extensions.iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                a(sb2, i11, "[" + ((GeneratedMessageLite.ExtensionDescriptor) next.getKey()).getNumber() + "]", next.getValue());
            }
        }
        UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite) messageLite).unknownFields;
        if (unknownFieldSetLite != null) {
            unknownFieldSetLite.g(sb2, i11);
        }
    }
}
