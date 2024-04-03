package com.facebook.appevents.ml;

import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0006H\u0007J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/ml/Utils;", "", "()V", "DIR_NAME", "", "getMlDir", "Ljava/io/File;", "normalizeString", "str", "parseModelWeights", "", "Lcom/facebook/appevents/ml/MTensor;", "file", "vectorize", "", "texts", "maxLen", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public final class Utils {
    @NotNull
    private static final String DIR_NAME = "facebook_ml/";
    @NotNull
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    @JvmStatic
    @Nullable
    public static final File getMlDir() {
        File file = new File(FacebookSdk.getApplicationContext().getFilesDir(), DIR_NAME);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    @JvmStatic
    @Nullable
    public static final Map<String, MTensor> parseModelWeights(@NotNull File file) {
        File file2 = file;
        Intrinsics.checkNotNullParameter(file2, "file");
        try {
            FileInputStream fileInputStream = new FileInputStream(file2);
            int available = fileInputStream.available();
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            byte[] bArr = new byte[available];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            if (available < 4) {
                return null;
            }
            int i11 = 0;
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, 4);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int i12 = wrap.getInt();
            int i13 = i12 + 4;
            if (available < i13) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(new String(bArr, 4, i12, Charsets.UTF_8));
            JSONArray names = jSONObject.names();
            int length = names.length();
            String[] strArr = new String[length];
            int i14 = length - 1;
            if (i14 >= 0) {
                int i15 = 0;
                while (true) {
                    int i16 = i15 + 1;
                    strArr[i15] = names.getString(i15);
                    if (i16 > i14) {
                        break;
                    }
                    i15 = i16;
                }
            }
            ArraysKt___ArraysJvmKt.sort((T[]) strArr);
            HashMap hashMap = new HashMap();
            int i17 = 0;
            while (i17 < length) {
                String str = strArr[i17];
                i17++;
                if (str != null) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    int length2 = jSONArray.length();
                    int[] iArr = new int[length2];
                    int i18 = length2 - 1;
                    int i19 = 1;
                    if (i18 >= 0) {
                        int i21 = i11;
                        while (true) {
                            int i22 = i21 + 1;
                            int i23 = jSONArray.getInt(i21);
                            iArr[i21] = i23;
                            i19 *= i23;
                            if (i22 > i18) {
                                break;
                            }
                            i21 = i22;
                        }
                    }
                    int i24 = i19 * 4;
                    int i25 = i13 + i24;
                    if (i25 > available) {
                        return null;
                    }
                    ByteBuffer wrap2 = ByteBuffer.wrap(bArr, i13, i24);
                    wrap2.order(ByteOrder.LITTLE_ENDIAN);
                    MTensor mTensor = new MTensor(iArr);
                    wrap2.asFloatBuffer().get(mTensor.getData(), 0, i19);
                    hashMap.put(str, mTensor);
                    i13 = i25;
                    i11 = 0;
                }
            }
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    @NotNull
    public final String normalizeString(@NotNull String str) {
        int i11;
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "str");
        int length = str.length() - 1;
        int i12 = 0;
        boolean z12 = false;
        while (i12 <= length) {
            if (!z12) {
                i11 = i12;
            } else {
                i11 = length;
            }
            if (Intrinsics.compare((int) str.charAt(i11), 32) <= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z12) {
                if (!z11) {
                    z12 = true;
                } else {
                    i12++;
                }
            } else if (!z11) {
                break;
            } else {
                length--;
            }
        }
        Object[] array = new Regex("\\s+").split(str.subSequence(i12, length + 1).toString(), 0).toArray(new String[0]);
        if (array != null) {
            String join = TextUtils.join(" ", (String[]) array);
            Intrinsics.checkNotNullExpressionValue(join, "join(\" \", strArray)");
            return join;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public final int[] vectorize(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "texts");
        int[] iArr = new int[i11];
        String normalizeString = normalizeString(str);
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-8\")");
        if (normalizeString != null) {
            byte[] bytes = normalizeString.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            if (i11 > 0) {
                int i12 = 0;
                while (true) {
                    int i13 = i12 + 1;
                    if (i12 < bytes.length) {
                        iArr[i12] = bytes[i12] & 255;
                    } else {
                        iArr[i12] = 0;
                    }
                    if (i13 >= i11) {
                        break;
                    }
                    i12 = i13;
                }
            }
            return iArr;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
