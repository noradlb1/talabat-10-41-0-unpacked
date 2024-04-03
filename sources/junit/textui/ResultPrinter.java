package junit.textui;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.security.CertificateUtil;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Enumeration;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestFailure;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.runner.BaseTestRunner;

public class ResultPrinter implements TestListener {

    /* renamed from: a  reason: collision with root package name */
    public PrintStream f23731a;

    /* renamed from: b  reason: collision with root package name */
    public int f23732b = 0;

    public ResultPrinter(PrintStream printStream) {
        this.f23731a = printStream;
    }

    public String a(long j11) {
        return NumberFormat.getInstance().format(((double) j11) / 1000.0d);
    }

    public void addError(Test test, Throwable th2) {
        getWriter().print(ExifInterface.LONGITUDE_EAST);
    }

    public void addFailure(Test test, AssertionFailedError assertionFailedError) {
        getWriter().print("F");
    }

    public synchronized void b(TestResult testResult, long j11) {
        i(j11);
        f(testResult);
        g(testResult);
        h(testResult);
    }

    public void c(TestFailure testFailure, int i11) {
        PrintStream writer = getWriter();
        writer.print(i11 + ") " + testFailure.failedTest());
    }

    public void d(TestFailure testFailure) {
        getWriter().print(BaseTestRunner.getFilteredTrace(testFailure.trace()));
    }

    public void e(Enumeration<TestFailure> enumeration, int i11, String str) {
        if (i11 != 0) {
            if (i11 == 1) {
                getWriter().println("There was " + i11 + " " + str + CertificateUtil.DELIMITER);
            } else {
                getWriter().println("There were " + i11 + " " + str + "s:");
            }
            int i12 = 1;
            while (enumeration.hasMoreElements()) {
                printDefect(enumeration.nextElement(), i12);
                i12++;
            }
        }
    }

    public void endTest(Test test) {
    }

    public void f(TestResult testResult) {
        e(testResult.errors(), testResult.errorCount(), "error");
    }

    public void g(TestResult testResult) {
        e(testResult.failures(), testResult.failureCount(), "failure");
    }

    public PrintStream getWriter() {
        return this.f23731a;
    }

    public void h(TestResult testResult) {
        String str;
        if (testResult.wasSuccessful()) {
            getWriter().println();
            getWriter().print("OK");
            PrintStream writer = getWriter();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" (");
            sb2.append(testResult.runCount());
            sb2.append(" test");
            if (testResult.runCount() == 1) {
                str = "";
            } else {
                str = "s";
            }
            sb2.append(str);
            sb2.append(")");
            writer.println(sb2.toString());
        } else {
            getWriter().println();
            getWriter().println("FAILURES!!!");
            PrintStream writer2 = getWriter();
            writer2.println("Tests run: " + testResult.runCount() + ",  Failures: " + testResult.failureCount() + ",  Errors: " + testResult.errorCount());
        }
        getWriter().println();
    }

    public void i(long j11) {
        getWriter().println();
        PrintStream writer = getWriter();
        writer.println("Time: " + a(j11));
    }

    public void j() {
        getWriter().println();
        getWriter().println("<RETURN> to continue");
    }

    public void printDefect(TestFailure testFailure, int i11) {
        c(testFailure, i11);
        d(testFailure);
    }

    public void startTest(Test test) {
        getWriter().print(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        int i11 = this.f23732b;
        this.f23732b = i11 + 1;
        if (i11 >= 40) {
            getWriter().println();
            this.f23732b = 0;
        }
    }
}
