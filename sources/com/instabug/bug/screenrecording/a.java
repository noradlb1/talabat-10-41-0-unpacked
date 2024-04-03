package com.instabug.bug.screenrecording;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.instabug.library.internal.video.InternalAutoScreenRecorderHelper;
import com.instabug.library.internal.video.ScreenRecordingContract;

public class a implements ScreenRecordingContract {

    /* renamed from: a  reason: collision with root package name */
    private static a f45718a;

    private a() {
    }

    public static a a() {
        if (f45718a == null) {
            f45718a = new a();
        }
        return f45718a;
    }

    public void clear() {
        InternalAutoScreenRecorderHelper.getInstance().clear();
    }

    public void delete() {
        InternalAutoScreenRecorderHelper.getInstance().delete();
    }

    @Nullable
    public Uri getAutoScreenRecordingFileUri() {
        return InternalAutoScreenRecorderHelper.getInstance().getAutoScreenRecordingFileUri();
    }

    public boolean isEnabled() {
        return InternalAutoScreenRecorderHelper.getInstance().isEnabled();
    }
}
