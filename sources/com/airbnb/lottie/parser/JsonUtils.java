package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.huawei.hms.flutter.map.constants.Param;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class JsonUtils {
    private static final JsonReader.Options POINT_NAMES = JsonReader.Options.of(Param.X, Param.Y);

    /* renamed from: com.airbnb.lottie.parser.JsonUtils$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40687a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.airbnb.lottie.parser.moshi.JsonReader$Token[] r0 = com.airbnb.lottie.parser.moshi.JsonReader.Token.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f40687a = r0
                com.airbnb.lottie.parser.moshi.JsonReader$Token r1 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f40687a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.parser.moshi.JsonReader$Token r1 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f40687a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.parser.moshi.JsonReader$Token r1 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.JsonUtils.AnonymousClass1.<clinit>():void");
        }
    }

    private JsonUtils() {
    }

    @ColorInt
    public static int a(JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        int nextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb(255, nextDouble, nextDouble2, nextDouble3);
    }

    public static PointF b(JsonReader jsonReader, float f11) throws IOException {
        int i11 = AnonymousClass1.f40687a[jsonReader.peek().ordinal()];
        if (i11 == 1) {
            return jsonNumbersToPoint(jsonReader, f11);
        }
        if (i11 == 2) {
            return jsonArrayToPoint(jsonReader, f11);
        }
        if (i11 == 3) {
            return jsonObjectToPoint(jsonReader, f11);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
    }

    public static List<PointF> c(JsonReader jsonReader, float f11) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(b(jsonReader, f11));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    public static float d(JsonReader jsonReader) throws IOException {
        JsonReader.Token peek = jsonReader.peek();
        int i11 = AnonymousClass1.f40687a[peek.ordinal()];
        if (i11 == 1) {
            return (float) jsonReader.nextDouble();
        }
        if (i11 == 2) {
            jsonReader.beginArray();
            float nextDouble = (float) jsonReader.nextDouble();
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            jsonReader.endArray();
            return nextDouble;
        }
        throw new IllegalArgumentException("Unknown value for token of type " + peek);
    }

    private static PointF jsonArrayToPoint(JsonReader jsonReader, float f11) throws IOException {
        jsonReader.beginArray();
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.peek() != JsonReader.Token.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new PointF(nextDouble * f11, nextDouble2 * f11);
    }

    private static PointF jsonNumbersToPoint(JsonReader jsonReader, float f11) throws IOException {
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new PointF(nextDouble * f11, nextDouble2 * f11);
    }

    private static PointF jsonObjectToPoint(JsonReader jsonReader, float f11) throws IOException {
        jsonReader.beginObject();
        float f12 = 0.0f;
        float f13 = 0.0f;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(POINT_NAMES);
            if (selectName == 0) {
                f12 = d(jsonReader);
            } else if (selectName != 1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                f13 = d(jsonReader);
            }
        }
        jsonReader.endObject();
        return new PointF(f12 * f11, f13 * f11);
    }
}
