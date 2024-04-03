package org.junit.internal;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class TextListener extends RunListener {
    private final PrintStream writer;

    public TextListener(JUnitSystem jUnitSystem) {
        this(jUnitSystem.out());
    }

    private PrintStream getWriter() {
        return this.writer;
    }

    public String a(long j11) {
        return NumberFormat.getInstance().format(((double) j11) / 1000.0d);
    }

    public void b(Failure failure, String str) {
        PrintStream writer2 = getWriter();
        writer2.println(str + ") " + failure.getTestHeader());
        getWriter().print(failure.getTrace());
    }

    public void c(Result result) {
        List<Failure> failures = result.getFailures();
        if (failures.size() != 0) {
            int i11 = 1;
            if (failures.size() == 1) {
                PrintStream writer2 = getWriter();
                writer2.println("There was " + failures.size() + " failure:");
            } else {
                PrintStream writer3 = getWriter();
                writer3.println("There were " + failures.size() + " failures:");
            }
            for (Failure b11 : failures) {
                b(b11, "" + i11);
                i11++;
            }
        }
    }

    public void d(Result result) {
        String str;
        if (result.wasSuccessful()) {
            getWriter().println();
            getWriter().print("OK");
            PrintStream writer2 = getWriter();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" (");
            sb2.append(result.getRunCount());
            sb2.append(" test");
            if (result.getRunCount() == 1) {
                str = "";
            } else {
                str = "s";
            }
            sb2.append(str);
            sb2.append(")");
            writer2.println(sb2.toString());
        } else {
            getWriter().println();
            getWriter().println("FAILURES!!!");
            PrintStream writer3 = getWriter();
            writer3.println("Tests run: " + result.getRunCount() + ",  Failures: " + result.getFailureCount());
        }
        getWriter().println();
    }

    public void e(long j11) {
        getWriter().println();
        PrintStream writer2 = getWriter();
        writer2.println("Time: " + a(j11));
    }

    public void testFailure(Failure failure) {
        this.writer.append('E');
    }

    public void testIgnored(Description description) {
        this.writer.append('I');
    }

    public void testRunFinished(Result result) {
        e(result.getRunTime());
        c(result);
        d(result);
    }

    public void testStarted(Description description) {
        this.writer.append('.');
    }

    public TextListener(PrintStream printStream) {
        this.writer = printStream;
    }
}
