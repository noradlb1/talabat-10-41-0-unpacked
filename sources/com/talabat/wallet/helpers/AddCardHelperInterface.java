package com.talabat.wallet.helpers;

import android.text.Editable;
import android.widget.EditText;
import datamodels.WalletCreditCard;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J&\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0016J(\u0010 \u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006#"}, d2 = {"Lcom/talabat/wallet/helpers/AddCardHelperInterface;", "", "DATE_SEPERATOR", "", "getDATE_SEPERATOR", "()Ljava/lang/String;", "buildCorrectString", "digits", "", "dividerPosition", "", "divider", "", "formatExpiryDate", "", "expiryDateET", "Landroid/widget/EditText;", "lastInput", "currentInput", "getDigitArray", "s", "Landroid/text/Editable;", "size", "getEditTextValue", "editText", "doTrim", "", "getFilledCard", "Ldatamodels/WalletCreditCard;", "cardNumberEditText", "cardExpiryDate", "securityCode", "isInputCorrect", "totalSymbols", "dividerModulo", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AddCardHelperInterface {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static String buildCorrectString(@NotNull AddCardHelperInterface addCardHelperInterface, @NotNull char[] cArr, int i11, char c11) {
            Intrinsics.checkNotNullParameter(cArr, "digits");
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

        public static void formatExpiryDate(@NotNull AddCardHelperInterface addCardHelperInterface, @NotNull EditText editText, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(editText, "expiryDateET");
            Intrinsics.checkNotNullParameter(str, "lastInput");
            Intrinsics.checkNotNullParameter(str2, "currentInput");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy", Locale.US);
            try {
                Calendar.getInstance().setTime(simpleDateFormat.parse(str2));
            } catch (ParseException unused) {
                if (str2.length() != 2 || StringsKt__StringsJVMKt.endsWith$default(str, addCardHelperInterface.getDATE_SEPERATOR(), false, 2, (Object) null)) {
                    if (str2.length() != 2 || !StringsKt__StringsJVMKt.endsWith$default(str, addCardHelperInterface.getDATE_SEPERATOR(), false, 2, (Object) null)) {
                        if (str2.length() == 1 && Integer.parseInt(StringsKt__StringsJVMKt.replace$default(str2, addCardHelperInterface.getDATE_SEPERATOR(), "", false, 4, (Object) null)) > 1) {
                            Editable text = editText.getText();
                            String date_seperator = addCardHelperInterface.getDATE_SEPERATOR();
                            editText.setText("0" + text + date_seperator);
                            editText.setSelection(editText.getText().toString().length());
                        }
                    } else if (Integer.parseInt(StringsKt__StringsJVMKt.replace$default(str2, addCardHelperInterface.getDATE_SEPERATOR(), "", false, 4, (Object) null)) <= 12) {
                        String substring = editText.getText().toString().substring(0, 1);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                        editText.setText(substring);
                        editText.setSelection(editText.getText().toString().length());
                    } else {
                        editText.setText("");
                        editText.setSelection(editText.getText().toString().length());
                    }
                } else if (Integer.parseInt(StringsKt__StringsJVMKt.replace$default(str2, addCardHelperInterface.getDATE_SEPERATOR(), "", false, 4, (Object) null)) <= 12) {
                    Editable text2 = editText.getText();
                    String date_seperator2 = addCardHelperInterface.getDATE_SEPERATOR();
                    editText.setText(text2 + date_seperator2);
                    editText.setSelection(editText.getText().toString().length());
                } else {
                    char charAt = editText.getText().toString().charAt(0);
                    String date_seperator3 = addCardHelperInterface.getDATE_SEPERATOR();
                    char charAt2 = editText.getText().toString().charAt(1);
                    editText.setText("0" + charAt + date_seperator3 + charAt2);
                    editText.setSelection(editText.getText().toString().length());
                }
            }
        }

        @NotNull
        public static char[] getDigitArray(@NotNull AddCardHelperInterface addCardHelperInterface, @NotNull Editable editable, int i11) {
            Intrinsics.checkNotNullParameter(editable, "s");
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

        @NotNull
        public static String getEditTextValue(@NotNull AddCardHelperInterface addCardHelperInterface, @NotNull EditText editText, boolean z11) {
            int i11;
            boolean z12;
            Intrinsics.checkNotNullParameter(editText, "editText");
            Editable text = editText.getText();
            if (z11) {
                String obj = text.toString();
                int length = obj.length() - 1;
                int i12 = 0;
                boolean z13 = false;
                while (i12 <= length) {
                    if (!z13) {
                        i11 = i12;
                    } else {
                        i11 = length;
                    }
                    if (Intrinsics.compare((int) obj.charAt(i11), 32) <= 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (!z13) {
                        if (!z12) {
                            z13 = true;
                        } else {
                            i12++;
                        }
                    } else if (!z12) {
                        break;
                    } else {
                        length--;
                    }
                }
                return obj.subSequence(i12, length + 1).toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(text);
            return sb2.toString();
        }

        @NotNull
        public static WalletCreditCard getFilledCard(@NotNull AddCardHelperInterface addCardHelperInterface, @Nullable EditText editText, @Nullable EditText editText2, @Nullable EditText editText3) {
            Editable editable = null;
            String valueOf = String.valueOf(editText2 != null ? editText2.getText() : null);
            int length = valueOf.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                boolean z12 = Intrinsics.compare((int) valueOf.charAt(!z11 ? i11 : length), 32) <= 0;
                if (!z11) {
                    if (!z12) {
                        z11 = true;
                    } else {
                        i11++;
                    }
                } else if (!z12) {
                    break;
                } else {
                    length--;
                }
            }
            String substring = valueOf.subSequence(i11, length + 1).toString().substring(0, 2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String valueOf2 = String.valueOf(editText2 != null ? editText2.getText() : null);
            int length2 = valueOf2.length() - 1;
            int i12 = 0;
            boolean z13 = false;
            while (i12 <= length2) {
                boolean z14 = Intrinsics.compare((int) valueOf2.charAt(!z13 ? i12 : length2), 32) <= 0;
                if (!z13) {
                    if (!z14) {
                        z13 = true;
                    } else {
                        i12++;
                    }
                } else if (!z14) {
                    break;
                } else {
                    length2--;
                }
            }
            String substring2 = valueOf2.subSequence(i12, length2 + 1).toString().substring(3, 5);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            String valueOf3 = String.valueOf(editText != null ? editText.getText() : null);
            int length3 = valueOf3.length() - 1;
            int i13 = 0;
            boolean z15 = false;
            while (i13 <= length3) {
                boolean z16 = Intrinsics.compare((int) valueOf3.charAt(!z15 ? i13 : length3), 32) <= 0;
                if (!z15) {
                    if (!z16) {
                        z15 = true;
                    } else {
                        i13++;
                    }
                } else if (!z16) {
                    break;
                } else {
                    length3--;
                }
            }
            String replace = new Regex("\\s").replace((CharSequence) valueOf3.subSequence(i13, length3 + 1).toString(), "");
            String valueOf4 = String.valueOf(editText3 != null ? editText3.getText() : null);
            int length4 = valueOf4.length() - 1;
            int i14 = 0;
            boolean z17 = false;
            while (i14 <= length4) {
                boolean z18 = Intrinsics.compare((int) valueOf4.charAt(!z17 ? i14 : length4), 32) <= 0;
                if (!z17) {
                    if (!z18) {
                        z17 = true;
                    } else {
                        i14++;
                    }
                } else if (!z18) {
                    break;
                } else {
                    length4--;
                }
            }
            String obj = valueOf4.subSequence(i14, length4 + 1).toString();
            if (editText != null) {
                editable = editText.getText();
            }
            String valueOf5 = String.valueOf(editable);
            int length5 = valueOf5.length() - 1;
            int i15 = 0;
            boolean z19 = false;
            while (i15 <= length5) {
                boolean z21 = Intrinsics.compare((int) valueOf5.charAt(!z19 ? i15 : length5), 32) <= 0;
                if (!z19) {
                    if (!z21) {
                        z19 = true;
                    } else {
                        i15++;
                    }
                } else if (!z21) {
                    break;
                } else {
                    length5--;
                }
            }
            String substring3 = new Regex("\\s").replace((CharSequence) valueOf5.subSequence(i15, length5 + 1).toString(), "").substring(0, 6);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
            return new WalletCreditCard(replace, substring3, substring, substring2, obj, "");
        }

        public static boolean isInputCorrect(@NotNull AddCardHelperInterface addCardHelperInterface, @NotNull Editable editable, int i11, int i12, char c11) {
            boolean z11;
            boolean z12;
            Intrinsics.checkNotNullParameter(editable, "s");
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
    }

    @NotNull
    String buildCorrectString(@NotNull char[] cArr, int i11, char c11);

    void formatExpiryDate(@NotNull EditText editText, @NotNull String str, @NotNull String str2);

    @NotNull
    String getDATE_SEPERATOR();

    @NotNull
    char[] getDigitArray(@NotNull Editable editable, int i11);

    @NotNull
    String getEditTextValue(@NotNull EditText editText, boolean z11);

    @NotNull
    WalletCreditCard getFilledCard(@Nullable EditText editText, @Nullable EditText editText2, @Nullable EditText editText3);

    boolean isInputCorrect(@NotNull Editable editable, int i11, int i12, char c11);
}
