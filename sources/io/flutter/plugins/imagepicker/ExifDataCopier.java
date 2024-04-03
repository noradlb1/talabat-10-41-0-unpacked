package io.flutter.plugins.imagepicker;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;

class ExifDataCopier {
    private static void setIfNotNull(ExifInterface exifInterface, ExifInterface exifInterface2, String str) {
        if (exifInterface.getAttribute(str) != null) {
            exifInterface2.setAttribute(str, exifInterface.getAttribute(str));
        }
    }

    public void a(String str, String str2) {
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            ExifInterface exifInterface2 = new ExifInterface(str2);
            for (String ifNotNull : Arrays.asList(new String[]{ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_ISO_SPEED_RATINGS, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_WHITE_BALANCE, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_DATETIME, ExifInterface.TAG_FLASH, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_MAKE, ExifInterface.TAG_MODEL, ExifInterface.TAG_ORIENTATION})) {
                setIfNotNull(exifInterface, exifInterface2, ifNotNull);
            }
            exifInterface2.saveAttributes();
        } catch (Exception e11) {
            Log.e("ExifDataCopier", "Error preserving Exif data on selected image: " + e11);
        }
    }
}
