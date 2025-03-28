package io.ing9990.external.client.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Call request model
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class CallRequest(
    @JsonProperty("from")
    val from: String? = null,

    @JsonProperty("to")
    val to: String,

    @JsonProperty("data")
    val data: String? = null
)