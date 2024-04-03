package io.reactivex.rxjava3.exceptions;

import io.reactivex.rxjava3.annotations.NonNull;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    public static final class ExceptionOverview extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        public ExceptionOverview(String str) {
            super(str);
        }

        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public static abstract class PrintStreamOrWriter {
        public abstract PrintStreamOrWriter a(Object obj);
    }

    public static final class WrappedPrintStream extends PrintStreamOrWriter {
        private final PrintStream printStream;

        public WrappedPrintStream(PrintStream printStream2) {
            this.printStream = printStream2;
        }

        /* renamed from: b */
        public WrappedPrintStream a(Object obj) {
            this.printStream.print(obj);
            return this;
        }
    }

    public static final class WrappedPrintWriter extends PrintStreamOrWriter {
        private final PrintWriter printWriter;

        public WrappedPrintWriter(PrintWriter printWriter2) {
            this.printWriter = printWriter2;
        }

        /* renamed from: b */
        public WrappedPrintWriter a(Object obj) {
            this.printWriter.print(obj);
            return this;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CompositeException(@NonNull Throwable... thArr) {
        this((Iterable<? extends Throwable>) thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    private void appendStackTrace(PrintStreamOrWriter printStreamOrWriter, Throwable th2, String str) {
        printStreamOrWriter.a(str).a(th2).a(10);
        for (StackTraceElement a11 : th2.getStackTrace()) {
            printStreamOrWriter.a("\t\tat ").a(a11).a(10);
        }
        if (th2.getCause() != null) {
            printStreamOrWriter.a("\tCaused by: ");
            appendStackTrace(printStreamOrWriter, th2.getCause(), "");
        }
    }

    @NonNull
    public synchronized Throwable getCause() {
        int i11;
        if (this.cause == null) {
            String property = System.getProperty("line.separator");
            if (this.exceptions.size() > 1) {
                IdentityHashMap identityHashMap = new IdentityHashMap();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Multiple exceptions (");
                sb2.append(this.exceptions.size());
                sb2.append(")");
                sb2.append(property);
                for (Throwable next : this.exceptions) {
                    int i12 = 0;
                    while (true) {
                        if (next == null) {
                            break;
                        }
                        for (int i13 = 0; i13 < i12; i13++) {
                            sb2.append("  ");
                        }
                        sb2.append("|-- ");
                        sb2.append(next.getClass().getCanonicalName());
                        sb2.append(": ");
                        String message2 = next.getMessage();
                        if (message2 == null || !message2.contains(property)) {
                            sb2.append(message2);
                            sb2.append(property);
                        } else {
                            sb2.append(property);
                            for (String str : message2.split(property)) {
                                for (int i14 = 0; i14 < i12 + 2; i14++) {
                                    sb2.append("  ");
                                }
                                sb2.append(str);
                                sb2.append(property);
                            }
                        }
                        int i15 = 0;
                        while (true) {
                            i11 = i12 + 2;
                            if (i15 >= i11) {
                                break;
                            }
                            sb2.append("  ");
                            i15++;
                        }
                        StackTraceElement[] stackTrace = next.getStackTrace();
                        if (stackTrace.length > 0) {
                            sb2.append("at ");
                            sb2.append(stackTrace[0]);
                            sb2.append(property);
                        }
                        if (!identityHashMap.containsKey(next)) {
                            identityHashMap.put(next, Boolean.TRUE);
                            next = next.getCause();
                            i12++;
                        } else {
                            Throwable cause2 = next.getCause();
                            if (cause2 != null) {
                                for (int i16 = 0; i16 < i11; i16++) {
                                    sb2.append("  ");
                                }
                                sb2.append("|-- ");
                                sb2.append("(cause not expanded again) ");
                                sb2.append(cause2.getClass().getCanonicalName());
                                sb2.append(": ");
                                sb2.append(cause2.getMessage());
                                sb2.append(property);
                            }
                        }
                    }
                }
                this.cause = new ExceptionOverview(sb2.toString().trim());
            } else {
                this.cause = this.exceptions.get(0);
            }
        }
        return this.cause;
    }

    @NonNull
    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @NonNull
    public String getMessage() {
        return this.message;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public int size() {
        return this.exceptions.size();
    }

    public void printStackTrace(PrintStream printStream) {
        printStackTrace((PrintStreamOrWriter) new WrappedPrintStream(printStream));
    }

    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace((PrintStreamOrWriter) new WrappedPrintWriter(printWriter));
    }

    public CompositeException(@NonNull Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (iterable != null) {
            for (Throwable th2 : iterable) {
                if (th2 instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th2).getExceptions());
                } else if (th2 != null) {
                    linkedHashSet.add(th2);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            List<Throwable> unmodifiableList = Collections.unmodifiableList(new ArrayList(linkedHashSet));
            this.exceptions = unmodifiableList;
            this.message = unmodifiableList.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    private void printStackTrace(PrintStreamOrWriter printStreamOrWriter) {
        printStreamOrWriter.a(this).a(StringUtils.LF);
        for (StackTraceElement a11 : getStackTrace()) {
            printStreamOrWriter.a("\tat ").a(a11).a(StringUtils.LF);
        }
        int i11 = 1;
        for (Throwable appendStackTrace : this.exceptions) {
            printStreamOrWriter.a("  ComposedException ").a(Integer.valueOf(i11)).a(" :\n");
            appendStackTrace(printStreamOrWriter, appendStackTrace, "\t");
            i11++;
        }
        printStreamOrWriter.a(StringUtils.LF);
    }
}
