package com.google.android.exoplayer2.text;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;

public class SubtitleDecoderException extends DecoderException {
    public SubtitleDecoderException(String str) {
        super(str);
    }

    public SubtitleDecoderException(@Nullable Throwable th2) {
        super(th2);
    }

    public SubtitleDecoderException(String str, @Nullable Throwable th2) {
        super(str, th2);
    }
}
