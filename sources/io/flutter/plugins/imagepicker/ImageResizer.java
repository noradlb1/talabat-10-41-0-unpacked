package io.flutter.plugins.imagepicker;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Instrumented
class ImageResizer {
    private final ExifDataCopier exifDataCopier;
    private final File externalFilesDirectory;

    public ImageResizer(File file, ExifDataCopier exifDataCopier2) {
        this.externalFilesDirectory = file;
        this.exifDataCopier = exifDataCopier2;
    }

    private void copyExif(String str, String str2) {
        this.exifDataCopier.a(str, str2);
    }

    private File createFile(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        return file2;
    }

    private File createImageOnExternalDirectory(String str, Bitmap bitmap, int i11) throws IOException {
        Bitmap.CompressFormat compressFormat;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap.hasAlpha()) {
            compressFormat = Bitmap.CompressFormat.PNG;
        } else {
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        bitmap.compress(compressFormat, i11, byteArrayOutputStream);
        File createFile = createFile(this.externalFilesDirectory, str);
        FileOutputStream createOutputStream = createOutputStream(createFile);
        createOutputStream.write(byteArrayOutputStream.toByteArray());
        createOutputStream.close();
        return createFile;
    }

    private FileOutputStream createOutputStream(File file) throws IOException {
        return new FileOutputStream(file);
    }

    private Bitmap createScaledBitmap(Bitmap bitmap, int i11, int i12, boolean z11) {
        return Bitmap.createScaledBitmap(bitmap, i11, i12, z11);
    }

    private Bitmap decodeFile(String str) {
        return BitmapFactoryInstrumentation.decodeFile(str);
    }

    private boolean isImageQualityValid(Integer num) {
        return num != null && num.intValue() > 0 && num.intValue() < 100;
    }

    private File resizedImage(Bitmap bitmap, Double d11, Double d12, Integer num, String str) throws IOException {
        boolean z11;
        boolean z12;
        double d13;
        double d14;
        boolean z13;
        boolean z14;
        double width = ((double) bitmap.getWidth()) * 1.0d;
        double height = ((double) bitmap.getHeight()) * 1.0d;
        Integer num2 = num;
        if (!isImageQualityValid(num2)) {
            num2 = 100;
        }
        boolean z15 = true;
        if (d11 != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (d12 != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11) {
            d13 = Math.min(width, d11.doubleValue());
        } else {
            d13 = width;
        }
        Double valueOf = Double.valueOf(d13);
        if (z12) {
            d14 = Math.min(height, d12.doubleValue());
        } else {
            d14 = height;
        }
        Double valueOf2 = Double.valueOf(d14);
        if (!z11 || d11.doubleValue() >= width) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (!z12 || d12.doubleValue() >= height) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (!z13 && !z14) {
            z15 = false;
        }
        if (z15) {
            double doubleValue = (valueOf2.doubleValue() / height) * width;
            double doubleValue2 = (valueOf.doubleValue() / width) * height;
            if (valueOf.doubleValue() < valueOf2.doubleValue()) {
                if (!z11) {
                    valueOf = Double.valueOf(doubleValue);
                } else {
                    valueOf2 = Double.valueOf(doubleValue2);
                }
            } else if (valueOf2.doubleValue() < valueOf.doubleValue()) {
                if (!z12) {
                    valueOf2 = Double.valueOf(doubleValue2);
                } else {
                    valueOf = Double.valueOf(doubleValue);
                }
            } else if (width < height) {
                valueOf = Double.valueOf(doubleValue);
            } else if (height < width) {
                valueOf2 = Double.valueOf(doubleValue2);
            }
        }
        return createImageOnExternalDirectory("/scaled_" + str, createScaledBitmap(bitmap, valueOf.intValue(), valueOf2.intValue(), false), num2.intValue());
    }

    public String a(String str, @Nullable Double d11, @Nullable Double d12, @Nullable Integer num) {
        boolean z11;
        Bitmap decodeFile = decodeFile(str);
        if (decodeFile == null) {
            return null;
        }
        if (d11 == null && d12 == null && !isImageQualityValid(num)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            return str;
        }
        try {
            String[] split = str.split("/");
            File resizedImage = resizedImage(decodeFile, d11, d12, num, split[split.length - 1]);
            copyExif(str, resizedImage.getPath());
            return resizedImage.getPath();
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }
}
