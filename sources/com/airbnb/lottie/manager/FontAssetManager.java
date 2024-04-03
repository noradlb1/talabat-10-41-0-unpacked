package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import java.util.HashMap;
import java.util.Map;

public class FontAssetManager {
    private final AssetManager assetManager;
    private String defaultFontFileExtension = ".ttf";
    @Nullable
    private FontAssetDelegate delegate;
    private final Map<String, Typeface> fontFamilies = new HashMap();
    private final Map<MutablePair<String>, Typeface> fontMap = new HashMap();
    private final MutablePair<String> tempPair = new MutablePair<>();

    public FontAssetManager(Drawable.Callback callback, @Nullable FontAssetDelegate fontAssetDelegate) {
        this.delegate = fontAssetDelegate;
        if (!(callback instanceof View)) {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }

    private Typeface getFontFamily(String str) {
        Typeface typeface;
        String fontPath;
        Typeface typeface2 = this.fontFamilies.get(str);
        if (typeface2 != null) {
            return typeface2;
        }
        FontAssetDelegate fontAssetDelegate = this.delegate;
        if (fontAssetDelegate != null) {
            typeface = fontAssetDelegate.fetchFont(str);
        } else {
            typeface = null;
        }
        FontAssetDelegate fontAssetDelegate2 = this.delegate;
        if (!(fontAssetDelegate2 == null || typeface != null || (fontPath = fontAssetDelegate2.getFontPath(str)) == null)) {
            typeface = Typeface.createFromAsset(this.assetManager, fontPath);
        }
        if (typeface == null) {
            typeface = Typeface.createFromAsset(this.assetManager, "fonts/" + str + this.defaultFontFileExtension);
        }
        this.fontFamilies.put(str, typeface);
        return typeface;
    }

    private Typeface typefaceForStyle(Typeface typeface, String str) {
        int i11;
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        if (contains && contains2) {
            i11 = 3;
        } else if (contains) {
            i11 = 2;
        } else if (contains2) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        if (typeface.getStyle() == i11) {
            return typeface;
        }
        return Typeface.create(typeface, i11);
    }

    public Typeface getTypeface(String str, String str2) {
        this.tempPair.set(str, str2);
        Typeface typeface = this.fontMap.get(this.tempPair);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceForStyle = typefaceForStyle(getFontFamily(str), str2);
        this.fontMap.put(this.tempPair, typefaceForStyle);
        return typefaceForStyle;
    }

    public void setDefaultFontFileExtension(String str) {
        this.defaultFontFileExtension = str;
    }

    public void setDelegate(@Nullable FontAssetDelegate fontAssetDelegate) {
        this.delegate = fontAssetDelegate;
    }
}
