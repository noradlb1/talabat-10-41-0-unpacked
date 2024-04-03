package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;

public final class WebvttDecoder extends SimpleSubtitleDecoder {
    private static final String COMMENT_START = "NOTE";
    private static final int EVENT_COMMENT = 1;
    private static final int EVENT_CUE = 3;
    private static final int EVENT_END_OF_FILE = 0;
    private static final int EVENT_NONE = -1;
    private static final int EVENT_STYLE_BLOCK = 2;
    private static final String STYLE_START = "STYLE";
    private final WebvttCssParser cssParser = new WebvttCssParser();
    private final ParsableByteArray parsableWebvttData = new ParsableByteArray();

    public WebvttDecoder() {
        super("WebvttDecoder");
    }

    private static int getNextEvent(ParsableByteArray parsableByteArray) {
        int i11 = -1;
        int i12 = 0;
        while (i11 == -1) {
            i12 = parsableByteArray.getPosition();
            String readLine = parsableByteArray.readLine();
            if (readLine == null) {
                i11 = 0;
            } else if (STYLE_START.equals(readLine)) {
                i11 = 2;
            } else if (readLine.startsWith(COMMENT_START)) {
                i11 = 1;
            } else {
                i11 = 3;
            }
        }
        parsableByteArray.setPosition(i12);
        return i11;
    }

    private static void skipComment(ParsableByteArray parsableByteArray) {
        do {
        } while (!TextUtils.isEmpty(parsableByteArray.readLine()));
    }

    public Subtitle decode(byte[] bArr, int i11, boolean z11) throws SubtitleDecoderException {
        WebvttCueInfo parseCue;
        this.parsableWebvttData.reset(bArr, i11);
        ArrayList arrayList = new ArrayList();
        try {
            WebvttParserUtil.validateWebvttHeaderLine(this.parsableWebvttData);
            do {
            } while (!TextUtils.isEmpty(this.parsableWebvttData.readLine()));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int nextEvent = getNextEvent(this.parsableWebvttData);
                if (nextEvent == 0) {
                    return new WebvttSubtitle(arrayList2);
                }
                if (nextEvent == 1) {
                    skipComment(this.parsableWebvttData);
                } else if (nextEvent == 2) {
                    if (arrayList2.isEmpty()) {
                        this.parsableWebvttData.readLine();
                        arrayList.addAll(this.cssParser.parseBlock(this.parsableWebvttData));
                    } else {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                } else if (nextEvent == 3 && (parseCue = WebvttCueParser.parseCue(this.parsableWebvttData, arrayList)) != null) {
                    arrayList2.add(parseCue);
                }
            }
        } catch (ParserException e11) {
            throw new SubtitleDecoderException((Throwable) e11);
        }
    }
}
