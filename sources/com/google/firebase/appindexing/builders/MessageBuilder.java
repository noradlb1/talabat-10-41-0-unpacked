package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Date;

public final class MessageBuilder extends IndexableBuilder<MessageBuilder> {
    public MessageBuilder() {
        super("Message");
    }

    @NonNull
    public MessageBuilder setDateRead(@NonNull Date date) {
        Preconditions.checkNotNull(date);
        put("dateRead", date.getTime());
        return this;
    }

    @NonNull
    public MessageBuilder setDateReceived(@NonNull Date date) {
        Preconditions.checkNotNull(date);
        put("dateReceived", date.getTime());
        return this;
    }

    @NonNull
    public MessageBuilder setDateSent(@NonNull Date date) {
        Preconditions.checkNotNull(date);
        put("dateSent", date.getTime());
        return this;
    }

    @NonNull
    public MessageBuilder setMessageAttachment(@NonNull IndexableBuilder<?>... indexableBuilderArr) {
        put("messageAttachment", (S[]) indexableBuilderArr);
        return this;
    }

    @NonNull
    public MessageBuilder setRecipient(@NonNull PersonBuilder... personBuilderArr) {
        put("recipient", (S[]) personBuilderArr);
        return this;
    }

    @NonNull
    public MessageBuilder setSender(@NonNull PersonBuilder personBuilder) {
        put("sender", (S[]) new PersonBuilder[]{personBuilder});
        return this;
    }

    @NonNull
    public MessageBuilder setText(@NonNull String str) {
        put("text", str);
        return this;
    }

    public MessageBuilder(String str) {
        super("EmailMessage");
    }
}
