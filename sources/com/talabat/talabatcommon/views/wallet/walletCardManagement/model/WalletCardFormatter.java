package com.talabat.talabatcommon.views.wallet.walletCardManagement.model;

import android.text.Editable;
import android.widget.EditText;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcore.logger.LogManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u001e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\bH\u0002J(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u001c"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardFormatter;", "", "()V", "buildCorrectString", "", "digits", "", "dividerPosition", "", "divider", "", "formatCardNumber", "", "editable", "Landroid/text/Editable;", "formatDate", "expiryDateET", "Landroid/widget/EditText;", "lastInput", "currentInput", "formatExpiryDate", "getDigitArray", "s", "size", "isInputCorrect", "", "totalSymbols", "dividerModulo", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCardFormatter {
    @NotNull
    public static final WalletCardFormatter INSTANCE = new WalletCardFormatter();

    private WalletCardFormatter() {
    }

    private final String buildCorrectString(char[] cArr, int i11, char c11) {
        StringBuilder sb2 = new StringBuilder();
        int length = cArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            char c12 = cArr[i12];
            if (c12 != 0) {
                sb2.append(c12);
                if (i12 > 0 && i12 < cArr.length - 1 && (i12 + 1) % i11 == 0) {
                    sb2.append(c11);
                }
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "formatted.toString()");
        return sb3;
    }

    private final void formatDate(EditText editText, String str, String str2) {
        EditText editText2 = editText;
        String str3 = str;
        try {
            if (str2.length() == 2) {
                if (!StringsKt__StringsJVMKt.endsWith$default(str3, "/", false, 2, (Object) null)) {
                    if (Integer.parseInt(StringsKt__StringsJVMKt.replace$default(str2, "/", StringUtils.empty(StringCompanionObject.INSTANCE), false, 4, (Object) null)) <= 12) {
                        Editable text = editText.getText();
                        editText2.setText(text + "/");
                        editText2.setSelection(editText.getText().toString().length());
                        return;
                    }
                    char charAt = editText.getText().toString().charAt(0);
                    char charAt2 = editText.getText().toString().charAt(1);
                    editText2.setText("0" + charAt + "/" + charAt2);
                    editText2.setSelection(editText.getText().toString().length());
                    return;
                }
            }
            if (str2.length() == 2 && StringsKt__StringsJVMKt.endsWith$default(str3, "/", false, 2, (Object) null)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                if (Integer.parseInt(StringsKt__StringsJVMKt.replace$default(str2, "/", StringUtils.empty(stringCompanionObject), false, 4, (Object) null)) <= 12) {
                    String substring = editText.getText().toString().substring(0, 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    editText2.setText(substring);
                    editText2.setSelection(editText.getText().toString().length());
                    return;
                }
                editText2.setText(StringUtils.empty(stringCompanionObject));
                editText2.setSelection(editText.getText().toString().length());
            } else if (str2.length() == 1) {
                if (Integer.parseInt(StringsKt__StringsJVMKt.replace$default(str2, "/", StringUtils.empty(StringCompanionObject.INSTANCE), false, 4, (Object) null)) > 1) {
                    Editable text2 = editText.getText();
                    editText2.setText("0" + text2 + "/");
                    editText2.setSelection(editText.getText().toString().length());
                }
            }
        } catch (NumberFormatException e11) {
            String message = e11.getMessage();
            if (message == null) {
                message = "";
            }
            LogManager.debug(message);
        }
    }

    private final char[] getDigitArray(Editable editable, int i11) {
        char[] cArr = new char[i11];
        int i12 = 0;
        for (int i13 = 0; i13 < editable.length() && i12 < i11; i13++) {
            char charAt = editable.charAt(i13);
            if (Character.isDigit(charAt)) {
                cArr[i12] = charAt;
                i12++;
            }
        }
        return cArr;
    }

    private final boolean isInputCorrect(Editable editable, int i11, int i12, char c11) {
        boolean z11;
        boolean z12;
        if (editable.length() <= i11) {
            z11 = true;
        } else {
            z11 = false;
        }
        int length = editable.length();
        for (int i13 = 0; i13 < length; i13++) {
            if (i13 <= 0 || (i13 + 1) % i12 != 0) {
                z12 = Character.isDigit(editable.charAt(i13));
            } else if (c11 == editable.charAt(i13)) {
                z12 = true;
            } else {
                z12 = false;
            }
            z11 &= z12;
        }
        return z11;
    }

    public final void formatCardNumber(@NotNull Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "editable");
        if (!isInputCorrect(editable, 19, 5, ' ')) {
            editable.replace(0, editable.length(), buildCorrectString(getDigitArray(editable, 16), 4, ' '));
        }
    }

    public final void formatExpiryDate(@NotNull EditText editText, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(editText, "expiryDateET");
        Intrinsics.checkNotNullParameter(str, "lastInput");
        Intrinsics.checkNotNullParameter(str2, "currentInput");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy", Locale.US);
        try {
            Calendar.getInstance().setTime(simpleDateFormat.parse(str2));
        } catch (ParseException unused) {
            formatDate(editText, str, str2);
        }
    }
}
