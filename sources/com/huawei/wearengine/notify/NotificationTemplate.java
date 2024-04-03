package com.huawei.wearengine.notify;

public enum NotificationTemplate {
    NOTIFICATION_TEMPLATE_NO_BUTTON(50),
    NOTIFICATION_TEMPLATE_ONE_BUTTON(51),
    NOTIFICATION_TEMPLATE_TWO_BUTTONS(52),
    NOTIFICATION_TEMPLATE_THREE_BUTTONS(53);
    
    private int mTemplateId;

    private NotificationTemplate(int i11) {
        this.mTemplateId = i11;
    }

    public static NotificationTemplate getTemplateForTemplateId(int i11) {
        for (NotificationTemplate notificationTemplate : values()) {
            if (i11 == notificationTemplate.value()) {
                return notificationTemplate;
            }
        }
        return null;
    }

    public int value() {
        return this.mTemplateId;
    }
}
