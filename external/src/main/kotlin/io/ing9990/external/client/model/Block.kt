package io.ing9990.external.client.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Block model
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Block(
    @JsonProperty("number")
    val number: String? = null,

    @JsonProperty("hash")
    val hash: String? = null,

    @JsonProperty("parentHash")
    val parentHash: String? = null,

    @JsonProperty("timestamp")
    val timestamp: String? = null,

    @JsonProperty("transactions")
    val transactions: List<Any>? = null
)