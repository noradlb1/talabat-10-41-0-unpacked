package io.flutter.plugin.editing;

import android.os.Bundle;
import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.systemchannels.SpellCheckChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.localization.LocalizationPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class SpellCheckPlugin implements SpellCheckChannel.SpellCheckMethodHandler, SpellCheckerSession.SpellCheckerSessionListener {
    public static final String END_INDEX_KEY = "endIndex";
    private static final int MAX_SPELL_CHECK_SUGGESTIONS = 5;
    public static final String START_INDEX_KEY = "startIndex";
    public static final String SUGGESTIONS_KEY = "suggestions";
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public MethodChannel.Result f14245a;
    private final SpellCheckChannel mSpellCheckChannel;
    private SpellCheckerSession mSpellCheckerSession;
    private final TextServicesManager mTextServicesManager;

    public SpellCheckPlugin(@NonNull TextServicesManager textServicesManager, @NonNull SpellCheckChannel spellCheckChannel) {
        this.mTextServicesManager = textServicesManager;
        this.mSpellCheckChannel = spellCheckChannel;
        spellCheckChannel.setSpellCheckMethodHandler(this);
    }

    public void destroy() {
        this.mSpellCheckChannel.setSpellCheckMethodHandler((SpellCheckChannel.SpellCheckMethodHandler) null);
        SpellCheckerSession spellCheckerSession = this.mSpellCheckerSession;
        if (spellCheckerSession != null) {
            spellCheckerSession.close();
        }
    }

    public void initiateSpellCheck(@NonNull String str, @NonNull String str2, @NonNull MethodChannel.Result result) {
        if (this.f14245a != null) {
            result.error("error", "Previous spell check request still pending.", (Object) null);
            return;
        }
        this.f14245a = result;
        performSpellCheck(str, str2);
    }

    public void onGetSentenceSuggestions(SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr) {
        if (sentenceSuggestionsInfoArr.length == 0) {
            this.f14245a.success(new ArrayList());
            this.f14245a = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        SentenceSuggestionsInfo sentenceSuggestionsInfo = sentenceSuggestionsInfoArr[0];
        for (int i11 = 0; i11 < sentenceSuggestionsInfo.getSuggestionsCount(); i11++) {
            SuggestionsInfo suggestionsInfoAt = sentenceSuggestionsInfo.getSuggestionsInfoAt(i11);
            int suggestionsCount = suggestionsInfoAt.getSuggestionsCount();
            if (suggestionsCount > 0) {
                HashMap hashMap = new HashMap();
                int offsetAt = sentenceSuggestionsInfo.getOffsetAt(i11);
                int lengthAt = sentenceSuggestionsInfo.getLengthAt(i11) + offsetAt;
                hashMap.put(START_INDEX_KEY, Integer.valueOf(offsetAt));
                hashMap.put(END_INDEX_KEY, Integer.valueOf(lengthAt));
                ArrayList arrayList2 = new ArrayList();
                for (int i12 = 0; i12 < suggestionsCount; i12++) {
                    arrayList2.add(suggestionsInfoAt.getSuggestionAt(i12));
                }
                hashMap.put("suggestions", arrayList2);
                arrayList.add(hashMap);
            }
        }
        this.f14245a.success(arrayList);
        this.f14245a = null;
    }

    public void onGetSuggestions(SuggestionsInfo[] suggestionsInfoArr) {
    }

    public void performSpellCheck(@NonNull String str, @NonNull String str2) {
        Locale localeFromString = LocalizationPlugin.localeFromString(str);
        if (this.mSpellCheckerSession == null) {
            this.mSpellCheckerSession = this.mTextServicesManager.newSpellCheckerSession((Bundle) null, localeFromString, this, true);
        }
        this.mSpellCheckerSession.getSentenceSuggestions(new TextInfo[]{new TextInfo(str2)}, 5);
    }
}
