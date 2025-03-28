package io.ing9990.external.client.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Base JSON-RPC response
 */
@JsonIgnoreProperties(ignoreUnknown = true)
open class JsonRpcResponse<T>(
    @JsonProperty("jsonrpc")
    val jsonrpc: String? = null,

    @JsonProperty("id")
    val id: Int? = null,

    @JsonProperty("result")
    val result: T? = null,

    @JsonProperty("error")
    val error: JsonRpcError? = null
)
