package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import j$.util.Optional;
import java.security.GeneralSecurityException;

@Immutable
public interface JwtPublicKeyVerifyInternal {
    VerifiedJwt verifyAndDecodeWithKid(String str, JwtValidator jwtValidator, Optional<String> optional) throws GeneralSecurityException;
}
