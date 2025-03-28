package io.ing9990.core

import io.ing9990.external.client.model.Block
import io.ing9990.external.client.model.CallRequest
import io.ing9990.external.client.model.Transaction

/**
 * Service interface for TT-Chain operations
 */
interface TTChainService {
    /**
     * Get block by number
     *
     * @param blockNumber Block number or "latest", "earliest", "pending"
     * @param fullTransactions Include full transaction objects if true
     * @return Block data
     */
    fun getBlockByNumber(blockNumber: String, fullTransactions: Boolean): Block?

    /**
     * Get block by hash
     *
     * @param blockHash Block hash
     * @param fullTransactions Include full transaction objects if true
     * @return Block data
     */
    fun getBlockByHash(blockHash: String, fullTransactions: Boolean): Block?

    /**
     * Get transaction by hash
     *
     * @param txHash Transaction hash
     * @return Transaction data
     */
    fun getTransactionByHash(txHash: String): Transaction?

    /**
     * Send raw transaction
     *
     * @param signedTx Signed transaction data
     * @return Transaction hash
     */
    fun sendRawTransaction(signedTx: String): String?

    /**
     * Execute a contract call
     *
     * @param callRequest Call request data
     * @param blockParameter Block parameter or "latest", "earliest", "pending"
     * @return Call result
     */
    fun call(callRequest: CallRequest, blockParameter: String = "latest"): String?

    /**
     * Get account balance
     *
     * @param address Account address
     * @param blockParameter Block parameter or "latest", "earliest", "pending"
     * @return Account balance in hex
     */
    fun getBalance(address: String, blockParameter: String = "latest"): String?

    /**
     * Get contract code
     *
     * @param address Contract address
     * @param blockParameter Block parameter or "latest", "earliest", "pending"
     * @return Contract code
     */
    fun getCode(address: String, blockParameter: String = "latest"): String?

    /**
     * Get storage at specified position
     *
     * @param address Storage address
     * @param position Storage position
     * @param blockParameter Block parameter or "latest", "earliest", "pending"
     * @return Storage value
     */
    fun getStorageAt(address: String, position: String, blockParameter: String = "latest"): String?

    /**
     * Get transaction count for address
     *
     * @param address Account address
     * @param blockParameter Block parameter or "latest", "earliest", "pending"
     * @return Transaction count in hex
     */
    fun getTransactionCount(address: String, blockParameter: String = "latest"): String?

    /**
     * Get block transaction count by hash
     *
     * @param blockHash Block hash
     * @return Transaction count in hex
     */
    fun getBlockTransactionCountByHash(blockHash: String): String?

    /**
     * Get block transaction count by number
     *
     * @param blockNumber Block number or "latest", "earliest", "pending"
     * @return Transaction count in hex
     */
    fun getBlockTransactionCountByNumber(blockNumber: String): String?
}