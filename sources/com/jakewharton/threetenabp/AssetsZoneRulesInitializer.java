package com.jakewharton.threetenabp;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import org.threeten.bp.zone.TzdbZoneRulesProvider;
import org.threeten.bp.zone.ZoneRulesInitializer;
import org.threeten.bp.zone.ZoneRulesProvider;

final class AssetsZoneRulesInitializer extends ZoneRulesInitializer {
    private final String assetPath;
    private final Context context;

    public AssetsZoneRulesInitializer(Context context2, String str) {
        this.context = context2;
        this.assetPath = str;
    }

    public void b() {
        InputStream inputStream = null;
        try {
            inputStream = this.context.getAssets().open(this.assetPath);
            TzdbZoneRulesProvider tzdbZoneRulesProvider = new TzdbZoneRulesProvider(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            ZoneRulesProvider.registerProvider(tzdbZoneRulesProvider);
        } catch (IOException e11) {
            throw new IllegalStateException(this.assetPath + " missing from assets", e11);
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th2;
        }
    }
}
