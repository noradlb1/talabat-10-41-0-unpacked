package org.apache.commons.lang3.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

public class ExceptionUtils {
    private static final String[] CAUSE_METHOD_NAMES = {"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};
    static final String WRAPPED_MARKER = " [wrapped] ";

    @Deprecated
    public static Throwable getCause(Throwable th2) {
        return getCause(th2, CAUSE_METHOD_NAMES);
    }

    private static Throwable getCauseUsingMethodName(Throwable th2, String str) {
        Method method;
        try {
            method = th2.getClass().getMethod(str, new Class[0]);
        } catch (NoSuchMethodException | SecurityException unused) {
            method = null;
        }
        if (method != null && Throwable.class.isAssignableFrom(method.getReturnType())) {
            try {
                return (Throwable) method.invoke(th2, new Object[0]);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
            }
        }
        return null;
    }

    @Deprecated
    public static String[] getDefaultCauseMethodNames() {
        return (String[]) ArrayUtils.clone((T[]) CAUSE_METHOD_NAMES);
    }

    public static String getMessage(Throwable th2) {
        if (th2 == null) {
            return "";
        }
        String shortClassName = ClassUtils.getShortClassName(th2, (String) null);
        String message = th2.getMessage();
        return shortClassName + ": " + StringUtils.defaultString(message);
    }

    public static Throwable getRootCause(Throwable th2) {
        List<Throwable> throwableList = getThrowableList(th2);
        if (throwableList.size() < 2) {
            return null;
        }
        return throwableList.get(throwableList.size() - 1);
    }

    public static String getRootCauseMessage(Throwable th2) {
        Throwable rootCause = getRootCause(th2);
        if (rootCause != null) {
            th2 = rootCause;
        }
        return getMessage(th2);
    }

    public static String[] getRootCauseStackTrace(Throwable th2) {
        List<String> list;
        if (th2 == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        Throwable[] throwables = getThrowables(th2);
        int length = throwables.length;
        ArrayList arrayList = new ArrayList();
        int i11 = length - 1;
        List<String> stackFrameList = getStackFrameList(throwables[i11]);
        while (true) {
            length--;
            if (length < 0) {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            if (length != 0) {
                list = getStackFrameList(throwables[length - 1]);
                removeCommonFrames(stackFrameList, list);
            } else {
                list = stackFrameList;
            }
            if (length == i11) {
                arrayList.add(throwables[length].toString());
            } else {
                arrayList.add(WRAPPED_MARKER + throwables[length].toString());
            }
            for (int i12 = 0; i12 < stackFrameList.size(); i12++) {
                arrayList.add(stackFrameList.get(i12));
            }
            stackFrameList = list;
        }
    }

    public static List<String> getStackFrameList(Throwable th2) {
        StringTokenizer stringTokenizer = new StringTokenizer(getStackTrace(th2), SystemUtils.LINE_SEPARATOR);
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf("at");
            if (indexOf != -1 && nextToken.substring(0, indexOf).trim().isEmpty()) {
                arrayList.add(nextToken);
                z11 = true;
            } else if (z11) {
                break;
            }
        }
        return arrayList;
    }

    public static String[] getStackFrames(Throwable th2) {
        if (th2 == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        return getStackFrames(getStackTrace(th2));
    }

    public static String getStackTrace(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter, true));
        return stringWriter.getBuffer().toString();
    }

    public static int getThrowableCount(Throwable th2) {
        return getThrowableList(th2).size();
    }

    public static List<Throwable> getThrowableList(Throwable th2) {
        ArrayList arrayList = new ArrayList();
        while (th2 != null && !arrayList.contains(th2)) {
            arrayList.add(th2);
            th2 = getCause(th2);
        }
        return arrayList;
    }

    public static Throwable[] getThrowables(Throwable th2) {
        List<Throwable> throwableList = getThrowableList(th2);
        return (Throwable[]) throwableList.toArray(new Throwable[throwableList.size()]);
    }

    private static int indexOf(Throwable th2, Class<?> cls, int i11, boolean z11) {
        if (!(th2 == null || cls == null)) {
            if (i11 < 0) {
                i11 = 0;
            }
            Throwable[] throwables = getThrowables(th2);
            if (i11 >= throwables.length) {
                return -1;
            }
            if (z11) {
                while (i11 < throwables.length) {
                    if (cls.isAssignableFrom(throwables[i11].getClass())) {
                        return i11;
                    }
                    i11++;
                }
            } else {
                while (i11 < throwables.length) {
                    if (cls.equals(throwables[i11].getClass())) {
                        return i11;
                    }
                    i11++;
                }
            }
        }
        return -1;
    }

    public static int indexOfThrowable(Throwable th2, Class<?> cls) {
        return indexOf(th2, cls, 0, false);
    }

    public static int indexOfType(Throwable th2, Class<?> cls) {
        return indexOf(th2, cls, 0, true);
    }

    public static void printRootCauseStackTrace(Throwable th2) {
        printRootCauseStackTrace(th2, System.err);
    }

    public static void removeCommonFrames(List<String> list, List<String> list2) {
        if (list == null || list2 == null) {
            throw new IllegalArgumentException("The List must not be null");
        }
        int size = list.size() - 1;
        int size2 = list2.size() - 1;
        while (size >= 0 && size2 >= 0) {
            if (list.get(size).equals(list2.get(size2))) {
                list.remove(size);
            }
            size--;
            size2--;
        }
    }

    @Deprecated
    public static Throwable getCause(Throwable th2, String[] strArr) {
        Throwable causeUsingMethodName;
        if (th2 == null) {
            return null;
        }
        if (strArr == null) {
            strArr = CAUSE_METHOD_NAMES;
        }
        for (String str : strArr) {
            if (str != null && (causeUsingMethodName = getCauseUsingMethodName(th2, str)) != null) {
                return causeUsingMethodName;
            }
        }
        return null;
    }

    public static int indexOfThrowable(Throwable th2, Class<?> cls, int i11) {
        return indexOf(th2, cls, i11, false);
    }

    public static int indexOfType(Throwable th2, Class<?> cls, int i11) {
        return indexOf(th2, cls, i11, true);
    }

    public static void printRootCauseStackTrace(Throwable th2, PrintStream printStream) {
        if (th2 != null) {
            if (printStream != null) {
                for (String println : getRootCauseStackTrace(th2)) {
                    printStream.println(println);
                }
                printStream.flush();
                return;
            }
            throw new IllegalArgumentException("The PrintStream must not be null");
        }
    }

    public static String[] getStackFrames(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, SystemUtils.LINE_SEPARATOR);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static void printRootCauseStackTrace(Throwable th2, PrintWriter printWriter) {
        if (th2 != null) {
            if (printWriter != null) {
                for (String println : getRootCauseStackTrace(th2)) {
                    printWriter.println(println);
                }
                printWriter.flush();
                return;
            }
            throw new IllegalArgumentException("The PrintWriter must not be null");
        }
    }
}
