package androidx.compose.ui.text.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.text.font.FontVariation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0010¢\u0006\u0002\b\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/font/AndroidAssetFont;", "Landroidx/compose/ui/text/font/AndroidPreloadedFont;", "assetManager", "Landroid/content/res/AssetManager;", "path", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "(Landroid/content/res/AssetManager;Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAssetManager", "()Landroid/content/res/AssetManager;", "cacheKey", "getCacheKey", "()Ljava/lang/String;", "getPath", "doLoad", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "doLoad$ui_text_release", "equals", "", "other", "", "hashCode", "", "toString", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidAssetFont extends AndroidPreloadedFont {
    @NotNull
    private final AssetManager assetManager;
    @NotNull
    private final String cacheKey;
    @NotNull
    private final String path;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidAssetFont(AssetManager assetManager2, String str, FontWeight fontWeight, int i11, FontVariation.Settings settings, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(assetManager2, str, (i12 & 4) != 0 ? FontWeight.Companion.getNormal() : fontWeight, (i12 & 8) != 0 ? FontStyle.Companion.m5129getNormal_LCdwA() : i11, settings, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ AndroidAssetFont(AssetManager assetManager2, String str, FontWeight fontWeight, int i11, FontVariation.Settings settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(assetManager2, str, fontWeight, i11, settings);
    }

    @Nullable
    public Typeface doLoad$ui_text_release(@Nullable Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return TypefaceBuilderCompat.INSTANCE.createFromAssets(this.assetManager, this.path, context, getVariationSettings());
        }
        return Typeface.createFromAsset(this.assetManager, this.path);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidAssetFont)) {
            return false;
        }
        AndroidAssetFont androidAssetFont = (AndroidAssetFont) obj;
        if (Intrinsics.areEqual((Object) this.path, (Object) androidAssetFont.path) && Intrinsics.areEqual((Object) getVariationSettings(), (Object) androidAssetFont.getVariationSettings())) {
            return true;
        }
        return false;
    }

    @NotNull
    public final AssetManager getAssetManager() {
        return this.assetManager;
    }

    @NotNull
    public String getCacheKey() {
        return this.cacheKey;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public int hashCode() {
        return (this.path.hashCode() * 31) + getVariationSettings().hashCode();
    }

    @NotNull
    public String toString() {
        return "Font(assetManager, path=" + this.path + ", weight=" + getWeight() + ", style=" + FontStyle.m5126toStringimpl(m5078getStyle_LCdwA()) + ')';
    }

    private AndroidAssetFont(AssetManager assetManager2, String str, FontWeight fontWeight, int i11, FontVariation.Settings settings) {
        super(fontWeight, i11, settings, (DefaultConstructorMarker) null);
        this.assetManager = assetManager2;
        this.path = str;
        setTypeface$ui_text_release(doLoad$ui_text_release((Context) null));
        this.cacheKey = "asset:" + str;
    }
}
