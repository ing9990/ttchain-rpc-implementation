package io.ing9990.external.client

import io.ing9990.external.client.model.Block
import io.ing9990.external.client.model.JsonRpcRequest
import io.ing9990.external.client.model.JsonRpcResponse
import io.ing9990.external.client.model.Transaction
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

/**
 * FeignClient interface for TTChain JSON-RPC API
 */
@FeignClient(
    name = "ttchain-rpc-client",
    url = "\${ttchain.rpc.url}",
    configuration = [TTChainClientConfiguration::class]
)
interface TTChainClient {

    /**
     * Get block by number
     *
     * @param request JSON-RPC request with block number
     * @return Block data
     */
    @PostMapping
    fun getBlockByNumber(
        @RequestBody request: JsonRpcRequest<Any>
    ): JsonRpcResponse<Block>

    /**
     * Get block by hash
     *
     * @param request JSON-RPC request with block hash
     * @return Block data
     */
    @PostMapping
    fun getBlockByHash(
        @RequestBody request: JsonRpcRequest<Any>
    ): JsonRpcResponse<Block>

    /**
     * Get transaction by hash
     *
     * @param request JSON-RPC request with transaction hash
     * @return Transaction data
     */
    @PostMapping
    fun getTransactionByHash(
        @RequestBody request: JsonRpcRequest<Any>
    ): JsonRpcResponse<Transaction>

    /**
     * Send raw transaction
     *
     * @param request JSON-RPC request with signed transaction data
     * @return Transaction hash
     */
    @PostMapping
    fun sendRawTransaction(
        @RequestBody request: JsonRpcRequest<Any>
    ): JsonRpcResponse<String>

    /**
     * Execute a contract call
     *
     * @param request JSON-RPC request with call data
     * @return Call result
     */
    @PostMapping
    fun call(
        @RequestBody request: JsonRpcRequest<Any>
    ): JsonRpcResponse<String>

    /**
     * Get account balance
     *
     * @param request JSON-RPC request with address
     * @return Account balance
     */
    @PostMapping
    fun getBalance(
        @RequestBody request: JsonRpcRequest<Any>
    ): JsonRpcResponse<String>

    /**
     * Get contract code
     *
     * @param request JSON-RPC request with contract address
     * @return Contract code
     */
    @PostMapping
    fun getCode(
        @RequestBody request: JsonRpcRequest<Any>
    ): JsonRpcResponse<String>

    /**
     * Get storage at specified position
     *
     * @param request JSON-RPC request with storage address and position
     * @return Storage value
     */
    @PostMapping
    fun getStorageAt(
        @RequestBody request: JsonRpcRequest<Any>
    ): JsonRpcResponse<String>

    /**
     * Get transaction count for address
     *
     * @param request JSON-RPC request with address
     * @return Transaction count
     */
    @PostMapping
    fun getTransactionCount(
        @RequestBody request: JsonRpcRequest<Any>
    ): JsonRpcResponse<String>

    /**
     * Get block transaction count by hash
     *
     * @param request JSON-RPC request with block hash
     * @return Transaction count
     */
    @PostMapping
    fun getBlockTransactionCountByHash(
        @RequestBody request: JsonRpcRequest<Any>
    ): JsonRpcResponse<String>

    /**
     * Get block transaction count by number
     *
     * @param request JSON-RPC request with block number
     * @return Transaction count
     */
    @PostMapping
    fun getBlockTransactionCountByNumber(
        @RequestBody request: JsonRpcRequest<Any>
    ): JsonRpcResponse<String>
}