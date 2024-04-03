package com.talabat.restaurants;

import android.content.Context;
import com.talabat.configuration.country.Country;
import com.talabat.helpers.GlobalDataModel;
import io.reactivex.functions.Consumer;
import java.io.IOException;
import java.io.InputStream;

class KuwaitViewInitializer implements Consumer<Context> {
    private String inputStreamToString(Context context) {
        try {
            InputStream open = context.getAssets().open("top_items.json");
            int available = open.available();
            byte[] bArr = new byte[available];
            open.read(bArr, 0, available);
            return new String(bArr);
        } catch (IOException unused) {
            return null;
        }
    }

    public void accept(Context context) {
        if (GlobalDataModel.SelectedCountryId == Country.KUWAIT.getCountryId()) {
            GlobalDataModel.TOP_ITEMS_JSON = inputStreamToString(context);
        }
    }
}
