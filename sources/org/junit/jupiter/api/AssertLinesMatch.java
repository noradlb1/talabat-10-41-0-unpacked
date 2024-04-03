package org.junit.jupiter.api;

import j$.util.function.Supplier;
import j$.util.stream.Collectors;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import java.util.ArrayDeque;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import mb.a;
import org.junit.platform.commons.util.Preconditions;

class AssertLinesMatch {
    private static final int MAX_SNIPPET_LENGTH = 21;

    public static class LinesMatcher {
        private final List<String> actualLines;
        private final List<String> expectedLines;
        private final Object messageOrSupplier;

        public LinesMatcher(List<String> list, List<String> list2, Object obj) {
            this.expectedLines = list;
            this.actualLines = list2;
            this.messageOrSupplier = obj;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ boolean lambda$assertLinesMatch$0(int i11) {
            return AssertLinesMatch.i(this.expectedLines.get(i11), this.actualLines.get(i11));
        }

        public void b() {
            int size = this.expectedLines.size();
            int size2 = this.actualLines.size();
            if (size > size2) {
                d("expected %d lines, but only got %d", Integer.valueOf(size), Integer.valueOf(size2));
            }
            if (size != size2 || !IntStream.CC.range(0, size).allMatch(new e(this))) {
                c();
            }
        }

        public void c() {
            ArrayDeque arrayDeque = new ArrayDeque(this.expectedLines);
            ArrayDeque arrayDeque2 = new ArrayDeque(this.actualLines);
            while (true) {
                if (!arrayDeque.isEmpty()) {
                    String str = (String) arrayDeque.pop();
                    int size = this.expectedLines.size() - arrayDeque.size();
                    if (arrayDeque2.isEmpty()) {
                        d("expected line #%d:`%s` not found - actual lines depleted", Integer.valueOf(size), e(str));
                    }
                    String str2 = (String) arrayDeque2.peek();
                    if (AssertLinesMatch.i(str, str2)) {
                        arrayDeque2.pop();
                    } else if (AssertLinesMatch.h(str)) {
                        int j11 = AssertLinesMatch.j(str);
                        int size2 = arrayDeque2.size();
                        if (arrayDeque.isEmpty()) {
                            if (j11 != Integer.MAX_VALUE && j11 != size2) {
                                d("terminal fast-forward(%d) error: fast-forward(%d) expected", Integer.valueOf(j11), Integer.valueOf(size2));
                            } else {
                                return;
                            }
                        }
                        if (j11 != Integer.MAX_VALUE) {
                            if (size2 < j11) {
                                d("fast-forward(%d) error: not enough actual lines remaining (%s)", Integer.valueOf(j11), Integer.valueOf(size2));
                            }
                            for (int i11 = 0; i11 < j11; i11++) {
                                arrayDeque2.pop();
                            }
                        } else {
                            String str3 = (String) arrayDeque.peek();
                            while (true) {
                                if (arrayDeque2.isEmpty()) {
                                    d("fast-forward(∞) didn't find: `%s`", e(str3));
                                }
                                if (AssertLinesMatch.i(str3, (String) arrayDeque2.peek())) {
                                    break;
                                }
                                arrayDeque2.pop();
                            }
                        }
                    } else {
                        d("expected line #%d doesn't match actual line #%d%n\texpected: `%s`%n\t  actual: `%s`", Integer.valueOf(size), Integer.valueOf((this.actualLines.size() - arrayDeque2.size()) + 1), str, str2);
                    }
                } else if (!arrayDeque2.isEmpty()) {
                    d("more actual lines than expected: %d", Integer.valueOf(arrayDeque2.size()));
                    return;
                } else {
                    return;
                }
            }
        }

        public void d(String str, Object... objArr) {
            String lineSeparator = System.lineSeparator();
            AssertionFailureBuilder.assertionFailure().message(this.messageOrSupplier).reason(String.format(str, objArr)).expected(a.a(lineSeparator, this.expectedLines)).actual(a.a(lineSeparator, this.actualLines)).includeValuesInMessage(false).buildAndThrow();
        }

        public String e(String str) {
            if (str.length() <= 21) {
                return str;
            }
            return str.substring(0, 16) + "[...]";
        }
    }

    private AssertLinesMatch() {
    }

    public static void b(List<String> list, List<String> list2) {
        c(list, list2, (Object) null);
    }

    public static void c(List<String> list, List<String> list2, Object obj) {
        Preconditions.notNull(list, "expectedLines must not be null");
        Preconditions.notNull(list2, "actualLines must not be null");
        if (list != list2) {
            new LinesMatcher(list, list2, obj).b();
        }
    }

    public static void d(List<String> list, List<String> list2, String str) {
        c(list, list2, str);
    }

    public static void e(Stream<String> stream, Stream<String> stream2) {
        f(stream, stream2, (Object) null);
    }

    public static void f(Stream<String> stream, Stream<String> stream2, Object obj) {
        Preconditions.notNull(stream, "expectedLines must not be null");
        Preconditions.notNull(stream2, "actualLines must not be null");
        if (stream != stream2) {
            c((List) stream.collect(Collectors.toList()), (List) stream2.collect(Collectors.toList()), obj);
        }
    }

    public static void g(Stream<String> stream, Stream<String> stream2, String str) {
        f(stream, stream2, str);
    }

    public static boolean h(String str) {
        String trim = str.trim();
        if (trim.length() < 4 || !trim.startsWith(">>") || !trim.endsWith(">>")) {
            return false;
        }
        return true;
    }

    public static boolean i(String str, String str2) {
        Preconditions.notNull(str, "expected line must not be null");
        Preconditions.notNull(str2, "actual line must not be null");
        if (str.equals(str2)) {
            return true;
        }
        try {
            return str2.matches(str);
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    public static int j(String str) {
        boolean z11;
        String trim = str.trim();
        try {
            int parseInt = Integer.parseInt(trim.substring(2, trim.length() - 2).trim());
            if (parseInt > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.condition(z11, (Supplier<String>) new d(parseInt));
            return parseInt;
        } catch (NumberFormatException unused) {
            return Integer.MAX_VALUE;
        }
    }
}
