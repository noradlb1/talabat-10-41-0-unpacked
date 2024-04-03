package io.flutter.plugin.editing;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextEditingDelta {
    private static final String TAG = "TextEditingDelta";
    private int deltaEnd;
    private int deltaStart;
    @NonNull
    private CharSequence deltaText;
    private int newComposingEnd;
    private int newComposingStart;
    private int newSelectionEnd;
    private int newSelectionStart;
    @NonNull
    private CharSequence oldText;

    public TextEditingDelta(@NonNull CharSequence charSequence, int i11, int i12, @NonNull CharSequence charSequence2, int i13, int i14, int i15, int i16) {
        this.newSelectionStart = i13;
        this.newSelectionEnd = i14;
        this.newComposingStart = i15;
        this.newComposingEnd = i16;
        setDeltas(charSequence, charSequence2.toString(), i11, i12);
    }

    private void setDeltas(@NonNull CharSequence charSequence, @NonNull CharSequence charSequence2, int i11, int i12) {
        this.oldText = charSequence;
        this.deltaText = charSequence2;
        this.deltaStart = i11;
        this.deltaEnd = i12;
    }

    @VisibleForTesting
    public int getDeltaEnd() {
        return this.deltaEnd;
    }

    @VisibleForTesting
    public int getDeltaStart() {
        return this.deltaStart;
    }

    @VisibleForTesting
    @NonNull
    public CharSequence getDeltaText() {
        return this.deltaText;
    }

    @VisibleForTesting
    public int getNewComposingEnd() {
        return this.newComposingEnd;
    }

    @VisibleForTesting
    public int getNewComposingStart() {
        return this.newComposingStart;
    }

    @VisibleForTesting
    public int getNewSelectionEnd() {
        return this.newSelectionEnd;
    }

    @VisibleForTesting
    public int getNewSelectionStart() {
        return this.newSelectionStart;
    }

    @VisibleForTesting
    @NonNull
    public CharSequence getOldText() {
        return this.oldText;
    }

    @NonNull
    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oldText", (Object) this.oldText.toString());
            jSONObject.put("deltaText", (Object) this.deltaText.toString());
            jSONObject.put("deltaStart", this.deltaStart);
            jSONObject.put("deltaEnd", this.deltaEnd);
            jSONObject.put("selectionBase", this.newSelectionStart);
            jSONObject.put("selectionExtent", this.newSelectionEnd);
            jSONObject.put("composingBase", this.newComposingStart);
            jSONObject.put("composingExtent", this.newComposingEnd);
        } catch (JSONException e11) {
            Log.e(TAG, "unable to create JSONObject: " + e11);
        }
        return jSONObject;
    }

    public TextEditingDelta(@NonNull CharSequence charSequence, int i11, int i12, int i13, int i14) {
        this.newSelectionStart = i11;
        this.newSelectionEnd = i12;
        this.newComposingStart = i13;
        this.newComposingEnd = i14;
        setDeltas(charSequence, "", -1, -1);
    }
}
