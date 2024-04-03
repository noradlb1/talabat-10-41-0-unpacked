package com.instabug.chat.settings;

import java.io.Serializable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class AttachmentTypesState implements Serializable {
    private boolean imageFromGalleryEnabled;
    private boolean screenRecordingEnabled;
    private boolean screenshotEnabled;

    public AttachmentTypesState() {
        this.screenshotEnabled = true;
        this.imageFromGalleryEnabled = true;
        this.screenRecordingEnabled = true;
    }

    public AttachmentTypesState(boolean z11, boolean z12, boolean z13) {
        this.screenshotEnabled = z11;
        this.imageFromGalleryEnabled = z12;
        this.screenRecordingEnabled = z13;
    }

    public boolean isImageFromGalleryEnabled() {
        return this.imageFromGalleryEnabled;
    }

    public boolean isScreenRecordingEnabled() {
        return this.screenRecordingEnabled;
    }

    public boolean isScreenshotEnabled() {
        return this.screenshotEnabled;
    }

    public AttachmentTypesState setImageFromGalleryEnabled(boolean z11) {
        this.imageFromGalleryEnabled = z11;
        return this;
    }

    public AttachmentTypesState setScreenRecordingEnabled(boolean z11) {
        this.screenRecordingEnabled = z11;
        return this;
    }

    public AttachmentTypesState setScreenshotEnabled(boolean z11) {
        this.screenshotEnabled = z11;
        return this;
    }

    public String toString() {
        return this.screenshotEnabled + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.imageFromGalleryEnabled + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.screenRecordingEnabled;
    }
}
