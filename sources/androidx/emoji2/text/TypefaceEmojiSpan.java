package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TypefaceEmojiSpan extends EmojiSpan {
    @Nullable
    private static Paint sDebugPaint;

    public TypefaceEmojiSpan(@NonNull EmojiMetadata emojiMetadata) {
        super(emojiMetadata);
    }

    @NonNull
    private static Paint getDebugPaint() {
        if (sDebugPaint == null) {
            TextPaint textPaint = new TextPaint();
            sDebugPaint = textPaint;
            textPaint.setColor(EmojiCompat.get().getEmojiSpanIndicatorColor());
            sDebugPaint.setStyle(Paint.Style.FILL);
        }
        return sDebugPaint;
    }

    public void draw(@NonNull Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, @IntRange(from = 0) int i11, @IntRange(from = 0) int i12, float f11, int i13, int i14, int i15, @NonNull Paint paint) {
        if (EmojiCompat.get().isEmojiSpanIndicatorEnabled()) {
            canvas.drawRect(f11, (float) i13, f11 + ((float) a()), (float) i15, getDebugPaint());
        }
        getMetadata().draw(canvas, f11, (float) i14, paint);
    }
}
