package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;
import org.apache.commons.lang3.StringUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {
    private static final String LOG_TAG = "ReceiveContent";

    @RequiresApi(16)
    public static final class Api16Impl {
        private Api16Impl() {
        }

        public static CharSequence coerce(@NonNull Context context, @NonNull ClipData.Item item, int i11) {
            if ((i11 & 1) == 0) {
                return item.coerceToStyledText(context);
            }
            CharSequence coerceToText = item.coerceToText(context);
            if (coerceToText instanceof Spanned) {
                return coerceToText.toString();
            }
            return coerceToText;
        }
    }

    public static final class ApiImpl {
        private ApiImpl() {
        }

        public static CharSequence coerce(@NonNull Context context, @NonNull ClipData.Item item, int i11) {
            CharSequence coerceToText = item.coerceToText(context);
            if ((i11 & 1) == 0 || !(coerceToText instanceof Spanned)) {
                return coerceToText;
            }
            return coerceToText.toString();
        }
    }

    private static CharSequence coerceToText(@NonNull Context context, @NonNull ClipData.Item item, int i11) {
        return Api16Impl.coerce(context, item, i11);
    }

    private static void replaceSelection(@NonNull Editable editable, @NonNull CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int max = Math.max(0, Math.min(selectionStart, selectionEnd));
        int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, max2);
        editable.replace(max, max2, charSequence);
    }

    @Nullable
    public ContentInfoCompat onReceiveContent(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable(LOG_TAG, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onReceive: ");
            sb2.append(contentInfoCompat);
        }
        if (contentInfoCompat.getSource() == 2) {
            return contentInfoCompat;
        }
        ClipData clip = contentInfoCompat.getClip();
        int flags = contentInfoCompat.getFlags();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z11 = false;
        for (int i11 = 0; i11 < clip.getItemCount(); i11++) {
            CharSequence coerceToText = coerceToText(context, clip.getItemAt(i11), flags);
            if (coerceToText != null) {
                if (!z11) {
                    replaceSelection(editable, coerceToText);
                    z11 = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), StringUtils.LF);
                    editable.insert(Selection.getSelectionEnd(editable), coerceToText);
                }
            }
        }
        return null;
    }
}
