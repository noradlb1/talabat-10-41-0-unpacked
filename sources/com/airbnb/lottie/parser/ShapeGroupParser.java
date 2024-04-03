package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

class ShapeGroupParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "hd", "it");

    private ShapeGroupParser() {
    }

    public static ShapeGroup a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z11 = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                z11 = jsonReader.nextBoolean();
            } else if (selectName != 2) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    ContentModel a11 = ContentModelParser.a(jsonReader, lottieComposition);
                    if (a11 != null) {
                        arrayList.add(a11);
                    }
                }
                jsonReader.endArray();
            }
        }
        return new ShapeGroup(str, arrayList, z11);
    }
}
