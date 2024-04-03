package com.deliveryhero.customerchat.fwf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.huawei.location.lite.common.util.DeviceInfoUtil;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/customerchat/fwf/CustomJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/customerchat/fwf/Custom;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomJsonAdapter extends JsonAdapter<Custom> {
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public CustomJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("customUserId", "gid", "country", DeviceInfoUtil.DeviceProperty.USERTYPE, "deviceOsVersion", "platformName", "appVersion", "applicationId");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"customUserId\", \"gid\"…ersion\", \"applicationId\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "customUserId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…(),\n      \"customUserId\")");
        this.stringAdapter = adapter;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(28);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append(TypedValues.Custom.NAME);
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00fa, code lost:
        r11 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00fc, code lost:
        r10 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00fe, code lost:
        r9 = r18;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.deliveryhero.customerchat.fwf.Custom fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r20.beginObject()
            r2 = 0
            r4 = r2
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
        L_0x0015:
            boolean r2 = r20.hasNext()
            java.lang.String r3 = "applicationId"
            java.lang.String r12 = "appVersion"
            java.lang.String r13 = "platformName"
            java.lang.String r14 = "deviceOsVersion"
            java.lang.String r15 = "userType"
            r16 = r11
            java.lang.String r11 = "country"
            r17 = r10
            java.lang.String r10 = "gid"
            r18 = r9
            java.lang.String r9 = "customUserId"
            if (r2 == 0) goto L_0x0102
            com.squareup.moshi.JsonReader$Options r2 = r0.options
            int r2 = r1.selectName(r2)
            switch(r2) {
                case -1: goto L_0x00f4;
                case 0: goto L_0x00de;
                case 1: goto L_0x00c8;
                case 2: goto L_0x00b2;
                case 3: goto L_0x009c;
                case 4: goto L_0x0086;
                case 5: goto L_0x006c;
                case 6: goto L_0x0053;
                case 7: goto L_0x003c;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x00fa
        L_0x003c:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x0049
            goto L_0x00fc
        L_0x0049:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r3, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"applicat… \"applicationId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0053:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x0062
            r11 = r16
            goto L_0x00fe
        L_0x0062:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r12, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"appVersi…    \"appVersion\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x006c:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x007c
            r11 = r16
            r10 = r17
            goto L_0x0015
        L_0x007c:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"platform…, \"platformName\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0086:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L_0x0092
            goto L_0x00fa
        L_0x0092:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"deviceOs…deviceOsVersion\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x009c:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x00a8
            goto L_0x00fa
        L_0x00a8:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"userType…      \"userType\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00b2:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x00be
            goto L_0x00fa
        L_0x00be:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r11, r1)
            java.lang.String r2 = "unexpectedNull(\"country\"…       \"country\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00c8:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x00d4
            goto L_0x00fa
        L_0x00d4:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"gid\", \"gid\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00de:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x00ea
            goto L_0x00fa
        L_0x00ea:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r9, r9, r1)
            java.lang.String r2 = "unexpectedNull(\"customUs…, \"customUserId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00f4:
            r20.skipName()
            r20.skipValue()
        L_0x00fa:
            r11 = r16
        L_0x00fc:
            r10 = r17
        L_0x00fe:
            r9 = r18
            goto L_0x0015
        L_0x0102:
            r20.endObject()
            com.deliveryhero.customerchat.fwf.Custom r2 = new com.deliveryhero.customerchat.fwf.Custom
            if (r4 == 0) goto L_0x0168
            if (r5 == 0) goto L_0x015e
            if (r6 == 0) goto L_0x0154
            if (r7 == 0) goto L_0x014a
            if (r8 == 0) goto L_0x0140
            if (r18 == 0) goto L_0x0136
            if (r17 == 0) goto L_0x012c
            if (r16 == 0) goto L_0x0122
            r3 = r2
            r9 = r18
            r10 = r17
            r11 = r16
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return r2
        L_0x0122:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r3, r3, r1)
            java.lang.String r2 = "missingProperty(\"applica… \"applicationId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x012c:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r12, r12, r1)
            java.lang.String r2 = "missingProperty(\"appVers…n\", \"appVersion\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0136:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r13, r1)
            java.lang.String r2 = "missingProperty(\"platfor…ame\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0140:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r14, r14, r1)
            java.lang.String r2 = "missingProperty(\"deviceO…deviceOsVersion\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x014a:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r15, r1)
            java.lang.String r2 = "missingProperty(\"userType\", \"userType\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0154:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r11, r11, r1)
            java.lang.String r2 = "missingProperty(\"country\", \"country\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x015e:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r10, r1)
            java.lang.String r2 = "missingProperty(\"gid\", \"gid\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0168:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r9, r9, r1)
            java.lang.String r2 = "missingProperty(\"customU…rId\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.fwf.CustomJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.deliveryhero.customerchat.fwf.Custom");
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable Custom custom) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (custom != null) {
            jsonWriter.beginObject();
            jsonWriter.name("customUserId");
            this.stringAdapter.toJson(jsonWriter, custom.getCustomUserId());
            jsonWriter.name("gid");
            this.stringAdapter.toJson(jsonWriter, custom.getGid());
            jsonWriter.name("country");
            this.stringAdapter.toJson(jsonWriter, custom.getCountry());
            jsonWriter.name(DeviceInfoUtil.DeviceProperty.USERTYPE);
            this.stringAdapter.toJson(jsonWriter, custom.getUserType());
            jsonWriter.name("deviceOsVersion");
            this.stringAdapter.toJson(jsonWriter, custom.getDeviceOsVersion());
            jsonWriter.name("platformName");
            this.stringAdapter.toJson(jsonWriter, custom.getPlatformName());
            jsonWriter.name("appVersion");
            this.stringAdapter.toJson(jsonWriter, custom.getAppVersion());
            jsonWriter.name("applicationId");
            this.stringAdapter.toJson(jsonWriter, custom.getApplicationId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
