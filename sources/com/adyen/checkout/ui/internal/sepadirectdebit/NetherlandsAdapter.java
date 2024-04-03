package com.adyen.checkout.ui.internal.sepadirectdebit;

import android.widget.EditText;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class NetherlandsAdapter extends CountryAdapter {
    private static final String[] BANK_CODES = {"ABNA", "INGB", "RABO", "SNSB", "TRIO", "ASNB", "BUNQ", "FRBK", "FVLB", "RBRB"};
    private static final int MAX_SUGGESTIONS = 4;

    private boolean isLastIndexSelected(@NonNull EditText editText) {
        int length = editText.length();
        if (editText.getSelectionStart() == length && editText.getSelectionEnd() == length) {
            return true;
        }
        return false;
    }

    @NonNull
    public List<Suggestion> a(@NonNull EditText editText, @NonNull String str) {
        ArrayList arrayList = new ArrayList();
        if (isLastIndexSelected(editText) && str.length() >= 4) {
            String substring = str.substring(4);
            if (substring.length() < 4) {
                for (String str2 : BANK_CODES) {
                    if (str2.startsWith(substring)) {
                        arrayList.add(new Suggestion(str2, str2.replaceFirst(substring, ""), editText.getText().length()));
                    }
                    if (arrayList.size() > 4) {
                        break;
                    }
                }
            }
        }
        return arrayList;
    }
}
