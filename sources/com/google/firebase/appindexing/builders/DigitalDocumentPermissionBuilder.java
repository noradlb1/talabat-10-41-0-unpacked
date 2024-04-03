package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

public final class DigitalDocumentPermissionBuilder extends IndexableBuilder<DigitalDocumentPermissionBuilder> {
    @NonNull
    public static final String COMMENT_PERMISSION = "CommentPermission";
    @NonNull
    public static final String READ_PERMISSION = "ReadPermission";
    @NonNull
    public static final String WRITE_PERMISSION = "WritePermission";

    public DigitalDocumentPermissionBuilder() {
        super("DigitalDocumentPermission");
    }

    @NonNull
    public DigitalDocumentPermissionBuilder setGrantee(@NonNull PersonBuilder... personBuilderArr) {
        put("grantee", (S[]) personBuilderArr);
        return this;
    }

    @NonNull
    public DigitalDocumentPermissionBuilder setPermissionType(@NonNull String str) {
        put("permissionType", str);
        return this;
    }
}
