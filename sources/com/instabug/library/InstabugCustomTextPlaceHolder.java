package com.instabug.library;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;

public class InstabugCustomTextPlaceHolder {
    private final d delegate = new d();

    public enum Key {
        SHAKE_HINT,
        SWIPE_HINT,
        INVALID_EMAIL_MESSAGE,
        INVALID_COMMENT_MESSAGE,
        INVOCATION_HEADER,
        COMMENT_FIELD_INSUFFICIENT_CONTENT,
        REPORT_BUG {
            public int a() {
                return 35;
            }
        },
        REPORT_FEEDBACK {
            public int a() {
                return 35;
            }
        },
        REPORT_QUESTION {
            public int a() {
                return 35;
            }
        },
        REQUEST_FEATURE {
            public int a() {
                return 35;
            }
        },
        REPORT_BUG_DESCRIPTION {
            public int a() {
                return 75;
            }
        },
        REPORT_FEEDBACK_DESCRIPTION {
            public int a() {
                return 75;
            }
        },
        REPORT_QUESTION_DESCRIPTION {
            public int a() {
                return 75;
            }
        },
        REQUEST_FEATURE_DESCRIPTION {
            public int a() {
                return 75;
            }
        },
        EMAIL_FIELD_HINT,
        COMMENT_FIELD_HINT_FOR_BUG_REPORT,
        COMMENT_FIELD_HINT_FOR_FEEDBACK,
        COMMENT_FIELD_HINT_FOR_QUESTION,
        ADD_VOICE_MESSAGE,
        ADD_IMAGE_FROM_GALLERY,
        ADD_EXTRA_SCREENSHOT,
        CONVERSATIONS_LIST_TITLE,
        AUDIO_RECORDING_PERMISSION_DENIED,
        CONVERSATION_TEXT_FIELD_HINT,
        VOICE_MESSAGE_PRESS_AND_HOLD_TO_RECORD,
        VOICE_MESSAGE_RELEASE_TO_ATTACH,
        REPORT_SUCCESSFULLY_SENT,
        SUCCESS_DIALOG_HEADER,
        ADD_VIDEO,
        VIDEO_RECORDING_FAB_BUBBLE_HINT,
        FEATURES_REQUEST,
        FEATURES_REQUEST_ADD_FEATURE_TOAST,
        FEATURES_REQUEST_ADD_FEATURE_THANKS_MESSAGE,
        SURVEYS_WELCOME_SCREEN_TITLE,
        SURVEYS_WELCOME_SCREEN_SUBTITLE,
        SURVEYS_WELCOME_SCREEN_BUTTON,
        SURVEYS_STORE_RATING_THANKS_TITLE,
        SURVEYS_STORE_RATING_THANKS_SUBTITLE,
        BETA_WELCOME_MESSAGE_WELCOME_STEP_TITLE,
        BETA_WELCOME_MESSAGE_WELCOME_STEP_CONTENT,
        BETA_WELCOME_MESSAGE_HOW_TO_REPORT_STEP_TITLE,
        BETA_WELCOME_MESSAGE_HOW_TO_REPORT_STEP_CONTENT,
        BETA_WELCOME_MESSAGE_FINISH_STEP_TITLE,
        BETA_WELCOME_MESSAGE_FINISH_STEP_CONTENT,
        LIVE_WELCOME_MESSAGE_TITLE,
        LIVE_WELCOME_MESSAGE_CONTENT,
        CHATS_TEAM_STRING_NAME,
        REPLIES_NOTIFICATION_DISMISS_BUTTON,
        REPLIES_NOTIFICATION_REPLY_BUTTON,
        REPORT_DISCARD_DIALOG_TITLE,
        REPORT_DISCARD_DIALOG_BODY,
        REPORT_DISCARD_DIALOG_NEGATIVE_ACTION,
        REPORT_DISCARD_DIALOG_POSITIVE_ACTION,
        REPORT_ADD_ATTACHMENT_HEADER,
        REPORT_REPRO_STEPS_DISCLAIMER_BODY,
        REPORT_REPRO_STEPS_DISCLAIMER_LINK,
        REPRO_STEPS_PROGRESS_DIALOG_BODY,
        REPRO_STEPS_LIST_HEADER,
        REPRO_STEPS_LIST_DESCRIPTION,
        REPRO_STEPS_LIST_ITEM_NUMBERING_TITLE,
        REPRO_STEPS_LIST_EMPTY_STATE_DESCRIPTION,
        BUG_ATTACHMENT_DIALOG_OK_BUTTON,
        CHATS_TYPE_AUDIO,
        CHATS_TYPE_IMAGE,
        CHATS_TYPE_VIDEO,
        CHATS_MULTIPLE_MESSAGE_NOTIFICATION;

        public int a() {
            return -1;
        }
    }

    @Nullable
    public String get(Key key) {
        return this.delegate.a(key);
    }

    public void set(Key key, @NonNull String str) {
        this.delegate.c(key, str);
    }

    public void setPlaceHoldersMap(HashMap<Key, String> hashMap) {
        this.delegate.b(hashMap);
    }
}
