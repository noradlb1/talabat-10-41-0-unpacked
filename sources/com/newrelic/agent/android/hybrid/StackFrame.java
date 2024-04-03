package com.newrelic.agent.android.hybrid;

import com.newrelic.agent.android.hybrid.rninterface.IStackFrame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StackFrame implements IStackFrame {
    private static final Pattern STACK_FRAME_PATTERN1 = Pattern.compile("^(?:(.*?)@)?(.*?)\\:([0-9]+)\\:([0-9]+)$");
    private static final Pattern STACK_FRAME_PATTERN2 = Pattern.compile("\\s*(?:at)\\s*(.+?)\\s*[@(](.*):([0-9]+):([0-9]+)[)]$");
    private int column;
    private String fileName;
    private int line;
    private String method;
    private final String rawJsLine;

    public StackFrame(String str) {
        this.rawJsLine = str.trim();
        parseRawJS();
    }

    private void parseRawJS() {
        String str;
        Matcher matcher = STACK_FRAME_PATTERN1.matcher(this.rawJsLine);
        Matcher matcher2 = STACK_FRAME_PATTERN2.matcher(this.rawJsLine);
        if (matcher2.find()) {
            matcher = matcher2;
        } else if (!matcher.find()) {
            this.fileName = null;
            this.method = this.rawJsLine;
            this.line = -1;
            this.column = -1;
            return;
        }
        this.fileName = matcher.group(2);
        if (matcher.group(1) == null) {
            str = "(unknown)";
        } else {
            str = matcher.group(1);
        }
        this.method = str;
        this.line = Integer.parseInt(matcher.group(3));
        this.column = Integer.parseInt(matcher.group(4));
    }

    public String getClassName() {
        return null;
    }

    public int getColumnNumber() {
        return this.column;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getLineNumber() {
        return this.line;
    }

    public String getMethodName() {
        return this.method;
    }

    public String getRawSourceLine() {
        return this.rawJsLine;
    }
}
