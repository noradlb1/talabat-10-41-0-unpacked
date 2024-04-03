package fwfd.com.fwfsdk.util;

import androidx.room.TypeConverter;
import java.io.IOException;

public class FWFAnyConverter {
    @TypeConverter
    public static Object toObject(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return FWFBytes.toObject(bArr);
        } catch (IOException e11) {
            e11.printStackTrace();
            FWFLogger.logError(FWFHelper.ERROR_CONVERTER_BLOB_VARIATION);
            return null;
        } catch (ClassNotFoundException e12) {
            e12.printStackTrace();
            FWFLogger.logError(FWFHelper.ERROR_CONVERTER_BLOB_VARIATION);
            return null;
        }
    }

    @TypeConverter
    public byte[] toString(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return FWFBytes.toByteArray(obj);
        } catch (IOException e11) {
            e11.printStackTrace();
            FWFLogger.logError(FWFHelper.ERROR_CONVERTER_OBJECT_VARIATION);
            return null;
        }
    }
}
