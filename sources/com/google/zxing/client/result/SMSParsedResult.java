package com.google.zxing.client.result;

import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class SMSParsedResult extends ParsedResult {
    private final String body;
    private final String[] numbers;
    private final String subject;
    private final String[] vias;

    public SMSParsedResult(String str, String str2, String str3, String str4) {
        super(ParsedResultType.SMS);
        this.numbers = new String[]{str};
        this.vias = new String[]{str2};
        this.subject = str3;
        this.body = str4;
    }

    public String getBody() {
        return this.body;
    }

    public String getDisplayResult() {
        StringBuilder sb2 = new StringBuilder(100);
        ParsedResult.maybeAppend(this.numbers, sb2);
        ParsedResult.maybeAppend(this.subject, sb2);
        ParsedResult.maybeAppend(this.body, sb2);
        return sb2.toString();
    }

    public String[] getNumbers() {
        return this.numbers;
    }

    public String getSMSURI() {
        boolean z11;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("sms:");
        boolean z12 = true;
        boolean z13 = true;
        for (int i11 = 0; i11 < this.numbers.length; i11++) {
            if (z13) {
                z13 = false;
            } else {
                sb2.append(AbstractJsonLexerKt.COMMA);
            }
            sb2.append(this.numbers[i11]);
            String[] strArr = this.vias;
            if (!(strArr == null || strArr[i11] == null)) {
                sb2.append(";via=");
                sb2.append(this.vias[i11]);
            }
        }
        if (this.body != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.subject == null) {
            z12 = false;
        }
        if (z11 || z12) {
            sb2.append('?');
            if (z11) {
                sb2.append("body=");
                sb2.append(this.body);
            }
            if (z12) {
                if (z11) {
                    sb2.append(Typography.amp);
                }
                sb2.append("subject=");
                sb2.append(this.subject);
            }
        }
        return sb2.toString();
    }

    public String getSubject() {
        return this.subject;
    }

    public String[] getVias() {
        return this.vias;
    }

    public SMSParsedResult(String[] strArr, String[] strArr2, String str, String str2) {
        super(ParsedResultType.SMS);
        this.numbers = strArr;
        this.vias = strArr2;
        this.subject = str;
        this.body = str2;
    }
}
