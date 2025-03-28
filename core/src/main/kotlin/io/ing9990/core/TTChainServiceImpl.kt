package io.ing9990.core

import io.ing9990.external.client.TTChainClient
import io.ing9990.external.client.model.Block
import io.ing9990.external.client.model.CallRequest
import io.ing9990.external.client.model.JsonRpcRequest
import io.ing9990.external.client.model.Transaction
import org.springframework.stereotype.Service

/**
 * Implementation of io.ing9990.core.TTChainService
 */
@Service
class TTChainServiceImpl(
    private val ttChainClient: TTChainClient
) : TTChainService {

    override fun getBlockByNumber(blockNumber: String, fullTransactions: Boolean): Block? {
        val request = JsonRpcRequest(
            method = "tt_getBlockByNumber",
            params = listOf(blockNumber, fullTransactions)
        )

        val response = ttChainClient.getBlockByNumber(request)
        return response.result
    }

    override fun getBlockByHash(blockHash: String, fullTransactions: Boolean): Block? {
        val request = JsonRpcRequest(
            method = "tt_getBlockByHash",
            params = listOf(blockHash, fullTransactions)
        )

        val response = ttChainClient.getBlockByHash(request)
        return response.result
    }

    override fun getTransactionByHash(txHash: String): Transaction? {
        val request = JsonRpcRequest(
            method = "tt_getTransactionByHash",
            params = listOf(txHash)
        )

        val response = ttChainClient.getTransactionByHash(request)
        return response.result
    }

    override fun sendRawTransaction(signedTx: String): String? {
        val request : JsonRpcRequest<String> = JsonRpcRequest(
            method = "tt_sendRawTransaction",
            params = listOf(signedTx)
        )

        val response = ttChainClient.sendRawTransaction(request)
        return response.result
    }

    override fun call(callRequest: CallRequest, blockParameter: String): String? {
        val request = JsonRpcRequest(
            method = "tt_call",
            params = listOf(callRequest, blockParameter)
        )

        val response = ttChainClient.call(request)
        return response.result
    }

    override fun getBalance(address: String, blockParameter: String): String? {
        val request = JsonRpcRequest(
            method = "tt_getBalance",
            params = listOf(address, blockParameter)
        )

        val response = ttChainClient.getBalance(request)
        return response.result
    }

    override fun getCode(address: String, blockParameter: String): String? {
        val request = JsonRpcRequest(
            method = "tt_getCode",
            params = listOf(address, blockParameter)
        )

        val response = ttChainClient.getCode(request)
        return response.result
    }

    override fun getStorageAt(address: String, position: String, blockParameter: String): String? {
        val request = JsonRpcRequest(
            method = "tt_getStorageAt",
            params = listOf(address, position, blockParameter)
        )

        val response = ttChainClient.getStorageAt(request)
        return response.result
    }

    override fun getTransactionCount(address: String, blockParameter: String): String? {
        val request = JsonRpcRequest(
            method = "tt_getTransactionCount",
            params = listOf(address, blockParameter)
        )

        val response = ttChainClient.getTransactionCount(request)
        return response.result
    }

    override fun getBlockTransactionCountByHash(blockHash: String): String? {
        val request = JsonRpcRequest(
            method = "tt_getBlockTransactionCountByHash",
            params = listOf(blockHash)
        )

        val response = ttChainClient.getBlockTransactionCountByHash(request)
        return response.result
    }

    override fun getBlockTransactionCountByNumber(blockNumber: String): String? {
        val request = JsonRpcRequest(
            method = "tt_getBlockTransactionCountByNumber",
            params = listOf(blockNumber)
        )

        val response = ttChainClient.getBlockTransactionCountByNumber(request)
        return response.result
    }
}