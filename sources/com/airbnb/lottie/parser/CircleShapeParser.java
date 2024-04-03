package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class CircleShapeParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "p", "s", "hd", "d");

    private CircleShapeParser() {
    }

    public static CircleShape a(JsonReader jsonReader, LottieComposition lottieComposition, int i11) throws IOException {
        boolean z11;
        if (i11 == 3) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean z12 = z11;
        boolean z13 = false;
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                animatableValue = AnimatablePathValueParser.a(jsonReader, lottieComposition);
            } else if (selectName == 2) {
                animatablePointValue = AnimatableValueParser.e(jsonReader, lottieComposition);
            } else if (selectName == 3) {
                z13 = jsonReader.nextBoolean();
            } else if (selectName != 4) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (jsonReader.nextInt() == 3) {
                z12 = true;
            } else {
                z12 = false;
            }
        }
        return new CircleShape(str, animatableValue, animatablePointValue, z12, z13);
    }
}
