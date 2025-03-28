package io.ing9990.external.client

import feign.Logger
import feign.Logger.Level.BASIC
import feign.Request
import feign.codec.Decoder
import feign.codec.Encoder
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration
@EnableFeignClients(basePackages = ["io.ing9990.external.client"])
class TTChainClientConfiguration {

    @Value("\${feign.client.config.default.connectTimeout}")
    private val connectTimeout: Long = 5000

    @Value("\${feign.client.config.default.readTimeout}")
    private val readTimeout: Long = 5000

    /**
     * Custom timeout configuration
     */
    @Bean
    fun options(): Request.Options {
        return Request.Options(
            connectTimeout, TimeUnit.MILLISECONDS,
            readTimeout, TimeUnit.MILLISECONDS,
            true
        )
    }

    /**
     * JSON encoder for requests
     */
    @Bean
    fun encoder(): Encoder {
        return JacksonEncoder()
    }

    /**
     * JSON decoder for responses
     */
    @Bean
    fun decoder(): Decoder {
        return JacksonDecoder()
    }

    /**
     * Logging level configuration
     */
    @Bean
    fun feignLoggerLevel(): Logger.Level {
        return BASIC
    }
}