package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class ShapePathParser {

    /* renamed from: a  reason: collision with root package name */
    public static JsonReader.Options f40693a = JsonReader.Options.of("nm", "ind", "ks", "hd");

    private ShapePathParser() {
    }

    public static ShapePath a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        int i11 = 0;
        boolean z11 = false;
        AnimatableShapeValue animatableShapeValue = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(f40693a);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                i11 = jsonReader.nextInt();
            } else if (selectName == 2) {
                animatableShapeValue = AnimatableValueParser.g(jsonReader, lottieComposition);
            } else if (selectName != 3) {
                jsonReader.skipValue();
            } else {
                z11 = jsonReader.nextBoolean();
            }
        }
        return new ShapePath(str, i11, animatableShapeValue, z11);
    }
}
