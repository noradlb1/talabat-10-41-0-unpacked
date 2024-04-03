package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

public class UnicodeUnpairedSurrogateRemover extends CodePointTranslator {
    public boolean translate(int i11, Writer writer) throws IOException {
        return i11 >= 55296 && i11 <= 57343;
    }
}
