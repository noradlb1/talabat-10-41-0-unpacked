package com.apptimize;

import java.io.IOException;
import java.net.ProtocolException;

public final class fs {

    /* renamed from: a  reason: collision with root package name */
    public final int f42469a;

    /* renamed from: b  reason: collision with root package name */
    public final String f42470b;

    public fs(int i11, String str) {
        this.f42469a = i11;
        this.f42470b = str;
    }

    public static fs a(String str) throws IOException {
        int i11;
        String str2;
        if (str == null) {
            return null;
        }
        if (str.startsWith("HTTP/1.")) {
            i11 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            i11 = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i12 = i11 + 3;
        if (str.length() >= i12) {
            try {
                int parseInt = Integer.parseInt(str.substring(i11, i12));
                if (str.length() <= i12) {
                    str2 = "";
                } else if (str.charAt(i12) == ' ') {
                    str2 = str.substring(i11 + 4);
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                return new fs(parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f42469a);
        if (this.f42470b != null) {
            sb2.append(' ');
            sb2.append(this.f42470b);
        }
        return sb2.toString();
    }
}
