package org.junit.runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.internal.Classes;
import org.junit.runner.FilterFactory;
import org.junit.runners.model.InitializationError;

class JUnitCommandLineParseResult {
    private final List<Class<?>> classes = new ArrayList();
    private final List<String> filterSpecs = new ArrayList();
    private final List<Throwable> parserErrors = new ArrayList();

    public static class CommandLineParserError extends Exception {
        private static final long serialVersionUID = 1;

        public CommandLineParserError(String str) {
            super(str);
        }
    }

    private Request applyFilterSpecs(Request request) {
        try {
            for (String createFilterFromFilterSpec : this.filterSpecs) {
                request = request.filterWith(FilterFactories.createFilterFromFilterSpec(request, createFilterFromFilterSpec));
            }
            return request;
        } catch (FilterFactory.FilterNotCreatedException e11) {
            return errorReport(e11);
        }
    }

    private String[] copyArray(String[] strArr, int i11, int i12) {
        ArrayList arrayList = new ArrayList();
        while (i11 != i12) {
            arrayList.add(strArr[i11]);
            i11++;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private Request errorReport(Throwable th2) {
        return Request.errorReport(JUnitCommandLineParseResult.class, th2);
    }

    public static JUnitCommandLineParseResult parse(String[] strArr) {
        JUnitCommandLineParseResult jUnitCommandLineParseResult = new JUnitCommandLineParseResult();
        jUnitCommandLineParseResult.parseArgs(strArr);
        return jUnitCommandLineParseResult;
    }

    private void parseArgs(String[] strArr) {
        b(a(strArr));
    }

    public String[] a(String... strArr) {
        String str;
        int i11 = 0;
        while (true) {
            if (i11 == strArr.length) {
                break;
            }
            String str2 = strArr[i11];
            if (str2.equals("--")) {
                return copyArray(strArr, i11 + 1, strArr.length);
            }
            if (!str2.startsWith("--")) {
                return copyArray(strArr, i11, strArr.length);
            }
            if (str2.startsWith("--filter=") || str2.equals("--filter")) {
                if (str2.equals("--filter")) {
                    i11++;
                    if (i11 >= strArr.length) {
                        this.parserErrors.add(new CommandLineParserError(str2 + " value not specified"));
                        break;
                    }
                    str = strArr[i11];
                } else {
                    str = str2.substring(str2.indexOf(61) + 1);
                }
                this.filterSpecs.add(str);
            } else {
                this.parserErrors.add(new CommandLineParserError("JUnit knows nothing about the " + str2 + " option"));
            }
            i11++;
        }
        return new String[0];
    }

    public void b(String[] strArr) {
        for (String str : strArr) {
            try {
                this.classes.add(Classes.getClass(str));
            } catch (ClassNotFoundException e11) {
                this.parserErrors.add(new IllegalArgumentException("Could not find class [" + str + "]", e11));
            }
        }
    }

    public Request createRequest(Computer computer) {
        if (!this.parserErrors.isEmpty()) {
            return errorReport(new InitializationError(this.parserErrors));
        }
        List<Class<?>> list = this.classes;
        return applyFilterSpecs(Request.classes(computer, (Class[]) list.toArray(new Class[list.size()])));
    }

    public List<Class<?>> getClasses() {
        return Collections.unmodifiableList(this.classes);
    }

    public List<String> getFilterSpecs() {
        return Collections.unmodifiableList(this.filterSpecs);
    }
}
