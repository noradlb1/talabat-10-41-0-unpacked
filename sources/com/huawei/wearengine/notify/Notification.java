package com.huawei.wearengine.notify;

import java.util.HashMap;

public class Notification {
    private Action mAction;
    private HashMap<Integer, String> mButtonContents;
    private String mPackageName;
    private int mRingtoneId;
    private int mTemplateId;
    private String mText;
    private String mTitle;
    private int mVibration;

    public static class Builder {
        /* access modifiers changed from: private */
        public Action mAction;
        /* access modifiers changed from: private */
        public HashMap<Integer, String> mButtonContents;
        /* access modifiers changed from: private */
        public String mPackageName;
        /* access modifiers changed from: private */
        public int mRingtoneId = -1;
        /* access modifiers changed from: private */
        public int mTemplateId = -1;
        /* access modifiers changed from: private */
        public String mText;
        /* access modifiers changed from: private */
        public String mTitle;
        /* access modifiers changed from: private */
        public int mVibration = 2;

        private Builder setRingtoneId(int i11) {
            this.mRingtoneId = i11;
            return this;
        }

        private Builder setVibration(int i11) {
            this.mVibration = i11;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }

        public Builder setAction(Action action) {
            this.mAction = action;
            return this;
        }

        public Builder setButtonContents(HashMap<Integer, String> hashMap) {
            this.mButtonContents = hashMap;
            return this;
        }

        public Builder setPackageName(String str) {
            this.mPackageName = str;
            return this;
        }

        public Builder setTemplateId(NotificationTemplate notificationTemplate) {
            this.mTemplateId = notificationTemplate == null ? -1 : notificationTemplate.value();
            return this;
        }

        public Builder setText(String str) {
            this.mText = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.mTitle = str;
            return this;
        }
    }

    private Notification(Builder builder) {
        this.mTemplateId = builder.mTemplateId;
        this.mPackageName = builder.mPackageName;
        this.mTitle = builder.mTitle;
        this.mText = builder.mText;
        this.mButtonContents = builder.mButtonContents;
        this.mVibration = builder.mVibration;
        this.mRingtoneId = builder.mRingtoneId;
        this.mAction = builder.mAction;
    }

    private int getRingtoneId() {
        return this.mRingtoneId;
    }

    private int getVibration() {
        return this.mVibration;
    }

    public Action getAction() {
        return this.mAction;
    }

    public HashMap<Integer, String> getButtonContents() {
        return this.mButtonContents;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getTemplateId() {
        return this.mTemplateId;
    }

    public String getText() {
        return this.mText;
    }

    public String getTitle() {
        return this.mTitle;
    }
}
