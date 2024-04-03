package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import j$.util.Optional;
import java.security.GeneralSecurityException;

@Immutable
interface JwtMacInternal {
    String computeMacAndEncodeWithKid(RawJwt rawJwt, Optional<String> optional) throws GeneralSecurityException;

    VerifiedJwt verifyMacAndDecodeWithKid(String str, JwtValidator jwtValidator, Optional<String> optional) throws GeneralSecurityException;
}
