package com.deliveryhero.customerchat.eventTracking.constants;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/constants/FeatureFlagPropertyKeys;", "", "()V", "HIDE_ADMIN_MESSAGES", "", "IS_LOCATION_SHARING_ENABLED", "IS_PHOTO_SHARING_ENABLED", "IS_REPLYING_MANDATORY", "IS_TRANSLATION_ENABLED", "PHONE_CALLING_ENABLED", "REMOTE_CONFIGURATION_ENABLED", "SHOW_SENDER_NAME", "STACK_MESSAGES_FROM_END", "VOIP_CALLING_ENABLED", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeatureFlagPropertyKeys {
    @NotNull
    public static final String HIDE_ADMIN_MESSAGES = "hide_admin_messages";
    @NotNull
    public static final FeatureFlagPropertyKeys INSTANCE = new FeatureFlagPropertyKeys();
    @NotNull
    public static final String IS_LOCATION_SHARING_ENABLED = "location_sharing";
    @NotNull
    public static final String IS_PHOTO_SHARING_ENABLED = "image_sharing";
    @NotNull
    public static final String IS_REPLYING_MANDATORY = "is_replying_mandatory";
    @NotNull
    public static final String IS_TRANSLATION_ENABLED = "is_translation_enabled";
    @NotNull
    public static final String PHONE_CALLING_ENABLED = "phone_calling_enabled";
    @NotNull
    public static final String REMOTE_CONFIGURATION_ENABLED = "is_remote_configuration_enabled";
    @NotNull
    public static final String SHOW_SENDER_NAME = "show_sender_name";
    @NotNull
    public static final String STACK_MESSAGES_FROM_END = "stack_messages_from_end";
    @NotNull
    public static final String VOIP_CALLING_ENABLED = "voip_calling";

    private FeatureFlagPropertyKeys() {
    }
}
