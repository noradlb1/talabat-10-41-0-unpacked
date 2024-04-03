package junit.runner;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.NumberFormat;
import java.util.Properties;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;
import junit.framework.TestSuite;

public abstract class BaseTestRunner implements TestListener {
    public static final String SUITE_METHODNAME = "suite";

    /* renamed from: b  reason: collision with root package name */
    public static int f23728b = getPreference("maxmessage", 500);

    /* renamed from: c  reason: collision with root package name */
    public static boolean f23729c = true;
    private static Properties fPreferences;

    /* renamed from: a  reason: collision with root package name */
    public boolean f23730a = true;

    public static boolean b(String str) {
        String[] strArr = {"junit.framework.TestCase", "junit.framework.TestResult", "junit.framework.TestSuite", "junit.framework.Assert.", "junit.swingui.TestRunner", "junit.awtui.TestRunner", "junit.textui.TestRunner", "java.lang.reflect.Method.invoke("};
        for (int i11 = 0; i11 < 8; i11++) {
            if (str.indexOf(strArr[i11]) > 0) {
                return true;
            }
        }
        return false;
    }

    public static Properties c() {
        if (fPreferences == null) {
            Properties properties = new Properties();
            fPreferences = properties;
            properties.put("loading", "true");
            fPreferences.put("filterstack", "true");
            readPreferences();
        }
        return fPreferences;
    }

    public static void f(Properties properties) {
        fPreferences = properties;
    }

    public static boolean g() {
        if (!getPreference("filterstack").equals("true") || !f23729c) {
            return true;
        }
        return false;
    }

    public static String getFilteredTrace(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter));
        return getFilteredTrace(stringWriter.toString());
    }

    public static String getPreference(String str) {
        return c().getProperty(str);
    }

    private static File getPreferencesFile() {
        return new File(System.getProperty("user.home"), "junit.properties");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b A[SYNTHETIC, Splitter:B:13:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031 A[SYNTHETIC, Splitter:B:19:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void readPreferences() {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x002f, all -> 0x0025 }
            java.io.File r2 = getPreferencesFile()     // Catch:{ IOException -> 0x002f, all -> 0x0025 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x002f, all -> 0x0025 }
            java.util.Properties r0 = new java.util.Properties     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            java.util.Properties r2 = c()     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            f(r0)     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            java.util.Properties r0 = c()     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            r0.load(r1)     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            r1.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0034
        L_0x0021:
            r0 = move-exception
            goto L_0x0029
        L_0x0023:
            r0 = r1
            goto L_0x002f
        L_0x0025:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L_0x0029:
            if (r1 == 0) goto L_0x002e
            r1.close()     // Catch:{ IOException -> 0x002e }
        L_0x002e:
            throw r0
        L_0x002f:
            if (r0 == 0) goto L_0x0034
            r0.close()     // Catch:{ IOException -> 0x0034 }
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: junit.runner.BaseTestRunner.readPreferences():void");
    }

    public static void savePreferences() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(getPreferencesFile());
        try {
            c().store(fileOutputStream, "");
        } finally {
            fileOutputStream.close();
        }
    }

    public static void setPreference(String str, String str2) {
        c().put(str, str2);
    }

    public static String truncate(String str) {
        if (f23728b == -1 || str.length() <= f23728b) {
            return str;
        }
        return str.substring(0, f23728b) + "...";
    }

    public void a() {
    }

    public synchronized void addError(Test test, Throwable th2) {
        testFailed(1, test, th2);
    }

    public synchronized void addFailure(Test test, AssertionFailedError assertionFailedError) {
        testFailed(2, test, assertionFailedError);
    }

    public Class<?> d(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    public abstract void e(String str);

    public String elapsedTimeAsString(long j11) {
        return NumberFormat.getInstance().format(((double) j11) / 1000.0d);
    }

    public synchronized void endTest(Test test) {
        testEnded(test.toString());
    }

    public String extractClassName(String str) {
        if (str.startsWith("Default package for")) {
            return str.substring(str.lastIndexOf(RealDiscoveryConfigurationRepository.VERSION_DELIMETER) + 1);
        }
        return str;
    }

    public Test getTest(String str) {
        if (str.length() <= 0) {
            a();
            return null;
        }
        try {
            Class<?> d11 = d(str);
            try {
                Method method = d11.getMethod(SUITE_METHODNAME, new Class[0]);
                if (!Modifier.isStatic(method.getModifiers())) {
                    e("Suite() method must be static");
                    return null;
                }
                try {
                    Test test = (Test) method.invoke((Object) null, new Object[0]);
                    if (test == null) {
                        return test;
                    }
                    a();
                    return test;
                } catch (InvocationTargetException e11) {
                    e("Failed to invoke suite():" + e11.getTargetException().toString());
                    return null;
                } catch (IllegalAccessException e12) {
                    e("Failed to invoke suite():" + e12.toString());
                    return null;
                }
            } catch (Exception unused) {
                a();
                return new TestSuite(d11);
            }
        } catch (ClassNotFoundException e13) {
            String message = e13.getMessage();
            if (message != null) {
                str = message;
            }
            e("Class not found \"" + str + "\"");
            return null;
        } catch (Exception e14) {
            e("Error: " + e14.toString());
            return null;
        }
    }

    public void setLoading(boolean z11) {
        this.f23730a = z11;
    }

    public synchronized void startTest(Test test) {
        testStarted(test.toString());
    }

    public abstract void testEnded(String str);

    public abstract void testFailed(int i11, Test test, Throwable th2);

    public abstract void testStarted(String str);

    public static int getPreference(String str, int i11) {
        String preference = getPreference(str);
        if (preference == null) {
            return i11;
        }
        try {
            return Integer.parseInt(preference);
        } catch (NumberFormatException unused) {
            return i11;
        }
    }

    public static String getFilteredTrace(String str) {
        if (g()) {
            return str;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return stringWriter.toString();
                }
                if (!b(readLine)) {
                    printWriter.println(readLine);
                }
            } catch (Exception unused) {
                return str;
            }
        }
    }
}
