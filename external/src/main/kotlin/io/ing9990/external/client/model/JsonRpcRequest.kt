package io.ing9990.external.client.model

import com.fasterxml.jackson.annotation.JsonProperty

data class JsonRpcRequest<out T>(
    @JsonProperty("jsonrpc")
    val jsonrpc: String = "2.0",

    @JsonProperty("method")
    val method: String,

    @JsonProperty("params")
    val params: List<T>,

    @JsonProperty("id")
    val id: Int = 1
)