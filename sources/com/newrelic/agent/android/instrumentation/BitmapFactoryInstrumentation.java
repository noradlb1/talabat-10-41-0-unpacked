package com.newrelic.agent.android.instrumentation;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.TypedValue;
import com.facebook.share.internal.ShareConstants;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class BitmapFactoryInstrumentation {
    private static final ArrayList<String> categoryParams = new ArrayList<>(Arrays.asList(new String[]{"category", MetricCategory.class.getName(), ShareConstants.IMAGE_URL}));

    private BitmapFactoryInstrumentation() {
    }

    @ReplaceCallSite(isStatic = true, scope = "android.graphics.BitmapFactory")
    public static Bitmap decodeByteArray(byte[] bArr, int i11, int i12, BitmapFactory.Options options) {
        TraceMachine.enterMethod("BitmapFactory#decodeByteArray", categoryParams);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, i11, i12, options);
        TraceMachine.exitMethod();
        return decodeByteArray;
    }

    @ReplaceCallSite(isStatic = true, scope = "android.graphics.BitmapFactory")
    public static Bitmap decodeFile(String str, BitmapFactory.Options options) {
        TraceMachine.enterMethod("BitmapFactory#decodeFile", categoryParams);
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        TraceMachine.exitMethod();
        return decodeFile;
    }

    @ReplaceCallSite(isStatic = true, scope = "android.graphics.BitmapFactory")
    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        TraceMachine.enterMethod("BitmapFactory#decodeFileDescriptor", categoryParams);
        Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
        TraceMachine.exitMethod();
        return decodeFileDescriptor;
    }

    @ReplaceCallSite(isStatic = true, scope = "android.graphics.BitmapFactory")
    public static Bitmap decodeResource(Resources resources, int i11, BitmapFactory.Options options) {
        TraceMachine.enterMethod("BitmapFactory#decodeResource", categoryParams);
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i11, options);
        TraceMachine.exitMethod();
        return decodeResource;
    }

    @ReplaceCallSite(isStatic = true, scope = "android.graphics.BitmapFactory")
    public static Bitmap decodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        TraceMachine.enterMethod("BitmapFactory#decodeResourceStream", categoryParams);
        Bitmap decodeResourceStream = BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
        TraceMachine.exitMethod();
        return decodeResourceStream;
    }

    @ReplaceCallSite(isStatic = true, scope = "android.graphics.BitmapFactory")
    public static Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        TraceMachine.enterMethod("BitmapFactory#decodeStream", categoryParams);
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, rect, options);
        TraceMachine.exitMethod();
        return decodeStream;
    }

    @ReplaceCallSite(isStatic = true, scope = "android.graphics.BitmapFactory")
    public static Bitmap decodeByteArray(byte[] bArr, int i11, int i12) {
        TraceMachine.enterMethod("BitmapFactory#decodeByteArray", categoryParams);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, i11, i12);
        TraceMachine.exitMethod();
        return decodeByteArray;
    }

    @ReplaceCallSite(isStatic = true, scope = "android.graphics.BitmapFactory")
    public static Bitmap decodeFile(String str) {
        TraceMachine.enterMethod("BitmapFactory#decodeFile", categoryParams);
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        TraceMachine.exitMethod();
        return decodeFile;
    }

    @ReplaceCallSite(isStatic = true, scope = "android.graphics.BitmapFactory")
    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor) {
        TraceMachine.enterMethod("BitmapFactory#decodeFileDescriptor", categoryParams);
        Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        TraceMachine.exitMethod();
        return decodeFileDescriptor;
    }

    @ReplaceCallSite(isStatic = true, scope = "android.graphics.BitmapFactory")
    public static Bitmap decodeResource(Resources resources, int i11) {
        TraceMachine.enterMethod("BitmapFactory#decodeResource", categoryParams);
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i11);
        TraceMachine.exitMethod();
        return decodeResource;
    }

    @ReplaceCallSite(isStatic = true, scope = "android.graphics.BitmapFactory")
    public static Bitmap decodeStream(InputStream inputStream) {
        TraceMachine.enterMethod("BitmapFactory#decodeStream", categoryParams);
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
        TraceMachine.exitMethod();
        return decodeStream;
    }
}
