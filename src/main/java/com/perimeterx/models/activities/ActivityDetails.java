package com.perimeterx.models.activities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.perimeterx.models.PXContext;
import com.perimeterx.models.risk.BlockReason;
import com.perimeterx.utils.Constants;

/**
 * ActivityDetails model
 * <p>
 * Created by shikloshi on 06/07/2016.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ActivityDetails {

    private String blockModule = Constants.MODULE;
    @JsonProperty("block_score")
    private int blockScore;
    @JsonProperty("block_reason")
    private BlockReason blockReason;
    private String blockUuid;
    @JsonProperty("http_method")
    private String httpMethod;
    @JsonProperty("http_version")
    private String httpVersion;

    public ActivityDetails(PXContext context) {
        this.blockScore = context.getScore();
        this.blockReason = context.getBlockReason();
        this.blockUuid = context.getUuid();
        this.httpMethod = context.getHttpMethod();
        this.httpVersion = context.getHttpVersion();
    }

    public String getBlockModule() {
        return blockModule;
    }

    public int getBlockScore() {
        return blockScore;
    }

    public BlockReason getBlockReason() {
        return blockReason;
    }

    public String getBlockUuid() {
        return blockUuid;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getHttpVersion() {
        return httpVersion;
    }
}