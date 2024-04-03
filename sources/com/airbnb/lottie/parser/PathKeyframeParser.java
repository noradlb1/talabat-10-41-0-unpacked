package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;

class PathKeyframeParser {
    private PathKeyframeParser() {
    }

    public static PathKeyframe a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z11;
        if (jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
            z11 = true;
        } else {
            z11 = false;
        }
        return new PathKeyframe(lottieComposition, KeyframeParser.a(jsonReader, lottieComposition, Utils.dpScale(), PathParser.INSTANCE, z11, false));
    }
}
