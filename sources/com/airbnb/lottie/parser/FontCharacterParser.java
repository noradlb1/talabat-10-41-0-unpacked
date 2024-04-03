package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import java.io.IOException;
import java.util.ArrayList;

class FontCharacterParser {
    private static final JsonReader.Options DATA_NAMES = JsonReader.Options.of("shapes");
    private static final JsonReader.Options NAMES = JsonReader.Options.of("ch", BindingAdaptersKt.QUERY_SIZE, "w", "style", "fFamily", "data");

    private FontCharacterParser() {
    }

    public static FontCharacter a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        double d11 = 0.0d;
        String str = null;
        String str2 = null;
        char c11 = 0;
        double d12 = 0.0d;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                c11 = jsonReader.nextString().charAt(0);
            } else if (selectName == 1) {
                d12 = jsonReader.nextDouble();
            } else if (selectName == 2) {
                d11 = jsonReader.nextDouble();
            } else if (selectName == 3) {
                str = jsonReader.nextString();
            } else if (selectName == 4) {
                str2 = jsonReader.nextString();
            } else if (selectName != 5) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    if (jsonReader.selectName(DATA_NAMES) != 0) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    } else {
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            arrayList.add((ShapeGroup) ContentModelParser.a(jsonReader, lottieComposition));
                        }
                        jsonReader.endArray();
                    }
                }
                jsonReader.endObject();
            }
        }
        jsonReader.endObject();
        return new FontCharacter(arrayList, c11, d12, d11, str, str2);
    }
}
