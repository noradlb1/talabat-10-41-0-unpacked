package com.google.android.gms.location.places.internal;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzi {
    public static CharSequence zzb(String str, List<zzb> list, @Nullable CharacterStyle characterStyle) {
        if (characterStyle == null) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        for (zzb next : list) {
            CharacterStyle wrap = CharacterStyle.wrap(characterStyle);
            int i11 = next.offset;
            spannableString.setSpan(wrap, i11, next.length + i11, 0);
        }
        return spannableString;
    }

    @Nullable
    public static String zzc(@Nullable Collection<String> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        return TextUtils.join(IndicativeSentencesGeneration.DEFAULT_SEPARATOR, collection);
    }
}
