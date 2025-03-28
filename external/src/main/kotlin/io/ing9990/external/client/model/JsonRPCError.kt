package io.ing9990.external.client.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * JSON-RPC error
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class JsonRpcError(
    @JsonProperty("code")
    val code: Int,

    @JsonProperty("message")
    val message: String
)
