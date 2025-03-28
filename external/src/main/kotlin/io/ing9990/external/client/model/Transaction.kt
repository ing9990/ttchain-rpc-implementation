package io.ing9990.external.client.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Transaction model
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Transaction(
    @JsonProperty("hash")
    val hash: String? = null,

    @JsonProperty("blockHash")
    val blockHash: String? = null,

    @JsonProperty("blockNumber")
    val blockNumber: String? = null,

    @JsonProperty("from")
    val from: String? = null,

    @JsonProperty("to")
    val to: String? = null,

    @JsonProperty("value")
    val value: String? = null,

    @JsonProperty("input")
    val input: String? = null
)