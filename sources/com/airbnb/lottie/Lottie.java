package com.airbnb.lottie;

import androidx.annotation.NonNull;

public class Lottie {
    private Lottie() {
    }

    public static void initialize(@NonNull LottieConfig lottieConfig) {
        L.setFetcher(lottieConfig.f40422a);
        L.setCacheProvider(lottieConfig.f40423b);
        L.setTraceEnabled(lottieConfig.f40424c);
    }
}
