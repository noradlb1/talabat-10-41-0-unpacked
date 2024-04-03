package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.RequiresApi;
import androidx.appcompat.resources.Compatibility;
import androidx.core.content.res.ResourcesCompat;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

class ResourcesWrapper extends Resources {
    private final Resources mResources;

    public ResourcesWrapper(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.mResources = resources;
    }

    public final Drawable a(int i11) throws Resources.NotFoundException {
        return super.getDrawable(i11);
    }

    public XmlResourceParser getAnimation(int i11) throws Resources.NotFoundException {
        return this.mResources.getAnimation(i11);
    }

    public boolean getBoolean(int i11) throws Resources.NotFoundException {
        return this.mResources.getBoolean(i11);
    }

    public int getColor(int i11) throws Resources.NotFoundException {
        return this.mResources.getColor(i11);
    }

    public ColorStateList getColorStateList(int i11) throws Resources.NotFoundException {
        return this.mResources.getColorStateList(i11);
    }

    public Configuration getConfiguration() {
        return this.mResources.getConfiguration();
    }

    public float getDimension(int i11) throws Resources.NotFoundException {
        return this.mResources.getDimension(i11);
    }

    public int getDimensionPixelOffset(int i11) throws Resources.NotFoundException {
        return this.mResources.getDimensionPixelOffset(i11);
    }

    public int getDimensionPixelSize(int i11) throws Resources.NotFoundException {
        return this.mResources.getDimensionPixelSize(i11);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.mResources.getDisplayMetrics();
    }

    public Drawable getDrawable(int i11) throws Resources.NotFoundException {
        return this.mResources.getDrawable(i11);
    }

    @RequiresApi(15)
    public Drawable getDrawableForDensity(int i11, int i12) throws Resources.NotFoundException {
        return ResourcesCompat.getDrawableForDensity(this.mResources, i11, i12, (Resources.Theme) null);
    }

    public float getFraction(int i11, int i12, int i13) {
        return this.mResources.getFraction(i11, i12, i13);
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.mResources.getIdentifier(str, str2, str3);
    }

    public int[] getIntArray(int i11) throws Resources.NotFoundException {
        return this.mResources.getIntArray(i11);
    }

    public int getInteger(int i11) throws Resources.NotFoundException {
        return this.mResources.getInteger(i11);
    }

    public XmlResourceParser getLayout(int i11) throws Resources.NotFoundException {
        return this.mResources.getLayout(i11);
    }

    public Movie getMovie(int i11) throws Resources.NotFoundException {
        return this.mResources.getMovie(i11);
    }

    public String getQuantityString(int i11, int i12, Object... objArr) throws Resources.NotFoundException {
        return this.mResources.getQuantityString(i11, i12, objArr);
    }

    public CharSequence getQuantityText(int i11, int i12) throws Resources.NotFoundException {
        return this.mResources.getQuantityText(i11, i12);
    }

    public String getResourceEntryName(int i11) throws Resources.NotFoundException {
        return this.mResources.getResourceEntryName(i11);
    }

    public String getResourceName(int i11) throws Resources.NotFoundException {
        return this.mResources.getResourceName(i11);
    }

    public String getResourcePackageName(int i11) throws Resources.NotFoundException {
        return this.mResources.getResourcePackageName(i11);
    }

    public String getResourceTypeName(int i11) throws Resources.NotFoundException {
        return this.mResources.getResourceTypeName(i11);
    }

    public String getString(int i11) throws Resources.NotFoundException {
        return this.mResources.getString(i11);
    }

    public String[] getStringArray(int i11) throws Resources.NotFoundException {
        return this.mResources.getStringArray(i11);
    }

    public CharSequence getText(int i11) throws Resources.NotFoundException {
        return this.mResources.getText(i11);
    }

    public CharSequence[] getTextArray(int i11) throws Resources.NotFoundException {
        return this.mResources.getTextArray(i11);
    }

    public void getValue(int i11, TypedValue typedValue, boolean z11) throws Resources.NotFoundException {
        this.mResources.getValue(i11, typedValue, z11);
    }

    @RequiresApi(15)
    public void getValueForDensity(int i11, int i12, TypedValue typedValue, boolean z11) throws Resources.NotFoundException {
        Compatibility.Api15Impl.getValueForDensity(this.mResources, i11, i12, typedValue, z11);
    }

    public XmlResourceParser getXml(int i11) throws Resources.NotFoundException {
        return this.mResources.getXml(i11);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.mResources.obtainAttributes(attributeSet, iArr);
    }

    public TypedArray obtainTypedArray(int i11) throws Resources.NotFoundException {
        return this.mResources.obtainTypedArray(i11);
    }

    public InputStream openRawResource(int i11) throws Resources.NotFoundException {
        return this.mResources.openRawResource(i11);
    }

    public AssetFileDescriptor openRawResourceFd(int i11) throws Resources.NotFoundException {
        return this.mResources.openRawResourceFd(i11);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.mResources.parseBundleExtra(str, attributeSet, bundle);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.mResources.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.mResources;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @RequiresApi(21)
    public Drawable getDrawable(int i11, Resources.Theme theme) throws Resources.NotFoundException {
        return ResourcesCompat.getDrawable(this.mResources, i11, theme);
    }

    @RequiresApi(21)
    public Drawable getDrawableForDensity(int i11, int i12, Resources.Theme theme) {
        return ResourcesCompat.getDrawableForDensity(this.mResources, i11, i12, theme);
    }

    public String getQuantityString(int i11, int i12) throws Resources.NotFoundException {
        return this.mResources.getQuantityString(i11, i12);
    }

    public String getString(int i11, Object... objArr) throws Resources.NotFoundException {
        return this.mResources.getString(i11, objArr);
    }

    public CharSequence getText(int i11, CharSequence charSequence) {
        return this.mResources.getText(i11, charSequence);
    }

    public void getValue(String str, TypedValue typedValue, boolean z11) throws Resources.NotFoundException {
        this.mResources.getValue(str, typedValue, z11);
    }

    public InputStream openRawResource(int i11, TypedValue typedValue) throws Resources.NotFoundException {
        return this.mResources.openRawResource(i11, typedValue);
    }
}
