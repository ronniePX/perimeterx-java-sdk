package com.perimeterx.models.httpmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.perimeterx.models.PXContext;
import com.perimeterx.models.risk.CustomParameters;
import com.perimeterx.models.risk.S2SCallReason;
import com.perimeterx.utils.Constants;

import java.io.IOException;


/**
 * Created by shikloshi on 06/08/2016.
 */
public class Additional {

    @JsonProperty("px_cookie")
    public String pxCookie;
    @JsonProperty("http_method")
    public String httpMethod;
    @JsonProperty("http_version")
    public String httpVersion;
    @JsonProperty("s2s_call_reason")
    public S2SCallReason callReason;
    @JsonProperty("px_cookie_orig")
    public String pxCookieOrig;
    @JsonProperty("cookie_origin")
    public String pxCookieOrigin;
    @JsonProperty("module_version")
    public final String moduleVersion = Constants.SDK_VERSION;
    @JsonUnwrapped
    public CustomParameters customParameters;

    public static Additional fromContext(PXContext ctx) {
        Additional additional = new Additional();
        additional.pxCookie = ctx.getRiskCookie();
        additional.httpMethod = ctx.getHttpMethod();
        additional.httpVersion = ctx.getHttpVersion();
        additional.callReason = ctx.getS2sCallReason();
        additional.pxCookieOrig = ctx.getPxCookieOrig();
        additional.pxCookieOrigin = ctx.getCookieOrigin();
        additional.customParameters = ctx.getCustomParameters();

        return additional;
    }
}
