package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.lang3.CharUtils;
import org.json.HTTP;

public final class AddressBookAUResultParser extends ResultParser {
    private static String[] matchMultipleValuePrefix(String str, int i11, String str2, boolean z11) {
        ArrayList arrayList = null;
        for (int i12 = 1; i12 <= i11; i12++) {
            String matchSinglePrefixedField = ResultParser.matchSinglePrefixedField(str + i12 + AbstractJsonLexerKt.COLON, str2, CharUtils.CR, z11);
            if (matchSinglePrefixedField == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList(i11);
            }
            arrayList.add(matchSinglePrefixedField);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public AddressBookParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        String[] strArr = null;
        if (!massagedText.contains("MEMORY") || !massagedText.contains(HTTP.CRLF)) {
            return null;
        }
        String matchSinglePrefixedField = ResultParser.matchSinglePrefixedField("NAME1:", massagedText, CharUtils.CR, true);
        String matchSinglePrefixedField2 = ResultParser.matchSinglePrefixedField("NAME2:", massagedText, CharUtils.CR, true);
        String[] matchMultipleValuePrefix = matchMultipleValuePrefix("TEL", 3, massagedText, true);
        String[] matchMultipleValuePrefix2 = matchMultipleValuePrefix("MAIL", 3, massagedText, true);
        String matchSinglePrefixedField3 = ResultParser.matchSinglePrefixedField("MEMORY:", massagedText, CharUtils.CR, false);
        String matchSinglePrefixedField4 = ResultParser.matchSinglePrefixedField("ADD:", massagedText, CharUtils.CR, true);
        if (matchSinglePrefixedField4 != null) {
            strArr = new String[]{matchSinglePrefixedField4};
        }
        return new AddressBookParsedResult(ResultParser.maybeWrap(matchSinglePrefixedField), (String[]) null, matchSinglePrefixedField2, matchMultipleValuePrefix, (String[]) null, matchMultipleValuePrefix2, (String[]) null, (String) null, matchSinglePrefixedField3, strArr, (String[]) null, (String) null, (String) null, (String) null, (String[]) null, (String[]) null);
    }
}
