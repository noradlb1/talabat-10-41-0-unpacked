package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import java.util.Date;

public final class DigitalDocumentBuilder extends IndexableBuilder<DigitalDocumentBuilder> {
    public DigitalDocumentBuilder() {
        super("DigitalDocument");
    }

    @NonNull
    public DigitalDocumentBuilder setAuthor(@NonNull PersonBuilder... personBuilderArr) {
        put("author", (S[]) personBuilderArr);
        return this;
    }

    @NonNull
    public DigitalDocumentBuilder setDateCreated(@NonNull Date date) {
        put("dateCreated", date.getTime());
        return this;
    }

    @NonNull
    public DigitalDocumentBuilder setDateModified(@NonNull Date date) {
        put("dateModified", date.getTime());
        return this;
    }

    @NonNull
    public DigitalDocumentBuilder setHasDigitalDocumentPermission(@NonNull DigitalDocumentPermissionBuilder... digitalDocumentPermissionBuilderArr) {
        put("hasDigitalDocumentPermission", (S[]) digitalDocumentPermissionBuilderArr);
        return this;
    }

    @NonNull
    public DigitalDocumentBuilder setText(@NonNull String str) {
        put("text", str);
        return this;
    }

    public DigitalDocumentBuilder(String str) {
        super(str);
    }
}
