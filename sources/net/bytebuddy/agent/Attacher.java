package net.bytebuddy.agent;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.InvocationTargetException;

public class Attacher {
    private static final String ATTACH_METHOD_NAME = "attach";
    private static final String DETACH_METHOD_NAME = "detach";
    private static final String LOAD_AGENT_METHOD_NAME = "loadAgent";
    private static final String LOAD_AGENT_PATH_METHOD_NAME = "loadAgentPath";
    private static final Object STATIC_MEMBER = null;

    private Attacher() {
        throw new UnsupportedOperationException("This class is a utility class and not supposed to be instantiated");
    }

    public static void a(Class<?> cls, String str, String str2, boolean z11, String str3) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String str4;
        Class<String> cls2 = String.class;
        Object invoke = cls.getMethod(ATTACH_METHOD_NAME, new Class[]{cls2}).invoke(STATIC_MEMBER, new Object[]{str});
        if (z11) {
            str4 = LOAD_AGENT_PATH_METHOD_NAME;
        } else {
            str4 = LOAD_AGENT_METHOD_NAME;
        }
        try {
            cls.getMethod(str4, new Class[]{cls2, cls2}).invoke(invoke, new Object[]{str2, str3});
        } finally {
            cls.getMethod(DETACH_METHOD_NAME, new Class[0]).invoke(invoke, new Object[0]);
        }
    }

    @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback", value = {"REC_CATCH_EXCEPTION"})
    public static void main(String[] strArr) {
        String str;
        try {
            if (strArr.length >= 5) {
                if (strArr[4].length() != 0) {
                    StringBuilder sb2 = new StringBuilder(strArr[4].substring(1));
                    for (int i11 = 5; i11 < strArr.length; i11++) {
                        sb2.append(' ');
                        sb2.append(strArr[i11]);
                    }
                    str = sb2.toString();
                    a(Class.forName(strArr[0]), strArr[1], strArr[2], Boolean.parseBoolean(strArr[3]), str);
                }
            }
            str = null;
            a(Class.forName(strArr[0]), strArr[1], strArr[2], Boolean.parseBoolean(strArr[3]), str);
        } catch (Throwable unused) {
            System.exit(1);
        }
    }
}
