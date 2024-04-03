package com.instabug.bug.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import com.instabug.bug.screenrecording.a;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.State;

public class b {
    @SuppressLint({"CheckResult"})
    public d a(Context context) {
        d dVar = new d(System.currentTimeMillis() + "", (State) null, a.IN_PROGRESS);
        if (a.a().isEnabled()) {
            Uri autoScreenRecordingFileUri = a.a().getAutoScreenRecordingFileUri();
            a.a().clear();
            if (autoScreenRecordingFileUri != null) {
                Attachment attachment = new Attachment();
                attachment.setName(autoScreenRecordingFileUri.getLastPathSegment());
                attachment.setLocalPath(autoScreenRecordingFileUri.getPath());
                attachment.setType(Attachment.Type.AUTO_SCREEN_RECORDING_VIDEO);
                dVar.a().add(attachment);
            }
        }
        dVar.a(InstabugCore.getFeatureState(Feature.VIEW_HIERARCHY_V2) == Feature.State.ENABLED);
        return dVar;
    }
}
