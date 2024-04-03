package com.talabat.core.fwfprojectskeys.domain.projects.user;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/fwfprojectskeys/domain/projects/user/UserExperimentsKeys;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "value", "", "projectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;)V", "getProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getValue", "()Ljava/lang/String;", "EXP_USER_AUTHENTICATION_API_MIGRATION", "EXP_USER_ENABLE_FLUTTER_ADDRESS_MAPS", "EXP_USER_FLUTTER_FORGOT_PASSWORD_SCREEN", "EXP_USER_FLUTTER_REGISTRATION_SCREEN", "EXP_USER_FLUTTER_LOGIN_SCREEN", "EXP_USER_FLUTTER_LOGIN_EMAIL_SCREEN", "EXP_USER_FLUTTER_LOGIN_MOBILE_SCREEN", "EXP_USER_FLUTTER_SETTINGS_SCREEN", "EXP_USER_FLUTTER_GUEST_ADDRESS_FORM_SCREEN", "com_talabat_core_fwf-projects-keys_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum UserExperimentsKeys implements FWFKey {
    EXP_USER_AUTHENTICATION_API_MIGRATION("exp_user_authentication_api_migration", (int) null, 2, (FWFProjectName) null),
    EXP_USER_ENABLE_FLUTTER_ADDRESS_MAPS("exp_user_enable_flutter_address_maps", (int) null, 2, (FWFProjectName) null),
    EXP_USER_FLUTTER_FORGOT_PASSWORD_SCREEN("exp_user_flutter_forgot_password_screen", (int) null, 2, (FWFProjectName) null),
    EXP_USER_FLUTTER_REGISTRATION_SCREEN("exp_user_flutter_registration_screen", (int) null, 2, (FWFProjectName) null),
    EXP_USER_FLUTTER_LOGIN_SCREEN("exp_user_flutter_login_screen", (int) null, 2, (FWFProjectName) null),
    EXP_USER_FLUTTER_LOGIN_EMAIL_SCREEN("exp_user_flutter_login_email_screen", (int) null, 2, (FWFProjectName) null),
    EXP_USER_FLUTTER_LOGIN_MOBILE_SCREEN("exp_user_flutter_login_mobile_screen", (int) null, 2, (FWFProjectName) null),
    EXP_USER_FLUTTER_SETTINGS_SCREEN("exp_user_flutter_settings_screen", (int) null, 2, (FWFProjectName) null),
    EXP_USER_FLUTTER_GUEST_ADDRESS_FORM_SCREEN("exp_user_flutter_guest_address_form_screen", (int) null, 2, (FWFProjectName) null);
    
    @NotNull
    private final FWFProjectName projectName;
    @NotNull
    private final String value;

    private UserExperimentsKeys(String str, FWFProjectName fWFProjectName) {
        this.value = str;
        this.projectName = fWFProjectName;
    }

    @NotNull
    public FWFProjectName getProjectName() {
        return this.projectName;
    }

    @NotNull
    public String getValue() {
        return this.value;
    }
}
