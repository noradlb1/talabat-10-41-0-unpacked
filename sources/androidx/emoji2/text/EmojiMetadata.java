package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi(19)
@AnyThread
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class EmojiMetadata {
    public static final int HAS_GLYPH_ABSENT = 1;
    public static final int HAS_GLYPH_EXISTS = 2;
    public static final int HAS_GLYPH_UNKNOWN = 0;
    private static final ThreadLocal<MetadataItem> sMetadataItem = new ThreadLocal<>();
    private volatile int mHasGlyph = 0;
    private final int mIndex;
    @NonNull
    private final MetadataRepo mMetadataRepo;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HasGlyph {
    }

    public EmojiMetadata(@NonNull MetadataRepo metadataRepo, @IntRange(from = 0) int i11) {
        this.mMetadataRepo = metadataRepo;
        this.mIndex = i11;
    }

    private MetadataItem getMetadataItem() {
        ThreadLocal<MetadataItem> threadLocal = sMetadataItem;
        MetadataItem metadataItem = threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        this.mMetadataRepo.getMetadataList().list(metadataItem, this.mIndex);
        return metadataItem;
    }

    public void draw(@NonNull Canvas canvas, float f11, float f12, @NonNull Paint paint) {
        Typeface c11 = this.mMetadataRepo.c();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(c11);
        Canvas canvas2 = canvas;
        canvas2.drawText(this.mMetadataRepo.getEmojiCharArray(), this.mIndex * 2, 2, f11, f12, paint);
        paint.setTypeface(typeface);
    }

    public int getCodepointAt(int i11) {
        return getMetadataItem().codepoints(i11);
    }

    public int getCodepointsLength() {
        return getMetadataItem().codepointsLength();
    }

    public short getCompatAdded() {
        return getMetadataItem().compatAdded();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getHasGlyph() {
        return this.mHasGlyph;
    }

    public short getHeight() {
        return getMetadataItem().height();
    }

    public int getId() {
        return getMetadataItem().id();
    }

    public short getSdkAdded() {
        return getMetadataItem().sdkAdded();
    }

    @NonNull
    public Typeface getTypeface() {
        return this.mMetadataRepo.c();
    }

    public short getWidth() {
        return getMetadataItem().width();
    }

    public boolean isDefaultEmoji() {
        return getMetadataItem().emojiStyle();
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public void resetHasGlyphCache() {
        this.mHasGlyph = 0;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setHasGlyph(boolean z11) {
        this.mHasGlyph = z11 ? 2 : 1;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(", id:");
        sb2.append(Integer.toHexString(getId()));
        sb2.append(", codepoints:");
        int codepointsLength = getCodepointsLength();
        for (int i11 = 0; i11 < codepointsLength; i11++) {
            sb2.append(Integer.toHexString(getCodepointAt(i11)));
            sb2.append(" ");
        }
        return sb2.toString();
    }
}
