package io.ing9990.core.controller

import io.ing9990.core.TTChainService
import io.ing9990.external.client.model.Block
import io.ing9990.external.client.model.CallRequest
import io.ing9990.external.client.model.Transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * REST Controller for TT-Chain operations
 */
@RestController
@RequestMapping("/api/ttchain")
class TTChainController @Autowired constructor(
    private val ttChainService: TTChainService
) {

    @GetMapping("/block/number/{blockNumber}")
    fun getBlockByNumber(
        @PathVariable blockNumber: String,
        @RequestParam(defaultValue = "false") fullTransactions: Boolean
    ): ResponseEntity<Block> {
        val block = ttChainService.getBlockByNumber(blockNumber, fullTransactions)
        return if (block != null) {
            ResponseEntity.ok(block)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/block/hash/{blockHash}")
    fun getBlockByHash(
        @PathVariable blockHash: String,
        @RequestParam(defaultValue = "false") fullTransactions: Boolean
    ): ResponseEntity<Block> {
        val block = ttChainService.getBlockByHash(blockHash, fullTransactions)
        return if (block != null) {
            ResponseEntity.ok(block)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/transaction/{txHash}")
    fun getTransactionByHash(@PathVariable txHash: String): ResponseEntity<Transaction> {
        val transaction = ttChainService.getTransactionByHash(txHash)
        return if (transaction != null) {
            ResponseEntity.ok(transaction)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/transaction/send")
    fun sendRawTransaction(@RequestBody signedTx: String): ResponseEntity<String> {
        val txHash = ttChainService.sendRawTransaction(signedTx)
        return if (txHash != null) {
            ResponseEntity.ok(txHash)
        } else {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping("/call")
    fun call(
        @RequestBody callRequest: CallRequest,
        @RequestParam(defaultValue = "latest") blockParameter: String
    ): ResponseEntity<String> {
        val result = ttChainService.call(callRequest, blockParameter)
        return if (result != null) {
            ResponseEntity.ok(result)
        } else {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/balance/{address}")
    fun getBalance(
        @PathVariable address: String,
        @RequestParam(defaultValue = "latest") blockParameter: String
    ): ResponseEntity<String> {
        val balance = ttChainService.getBalance(address, blockParameter)
        return if (balance != null) {
            ResponseEntity.ok(balance)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/code/{address}")
    fun getCode(
        @PathVariable address: String,
        @RequestParam(defaultValue = "latest") blockParameter: String
    ): ResponseEntity<String> {
        val code = ttChainService.getCode(address, blockParameter)
        return if (code != null) {
            ResponseEntity.ok(code)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/storage/{address}/{position}")
    fun getStorageAt(
        @PathVariable address: String,
        @PathVariable position: String,
        @RequestParam(defaultValue = "latest") blockParameter: String
    ): ResponseEntity<String> {
        val value = ttChainService.getStorageAt(address, position, blockParameter)
        return if (value != null) {
            ResponseEntity.ok(value)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/transaction-count/{address}")
    fun getTransactionCount(
        @PathVariable address: String,
        @RequestParam(defaultValue = "latest") blockParameter: String
    ): ResponseEntity<String> {
        val count = ttChainService.getTransactionCount(address, blockParameter)
        return if (count != null) {
            ResponseEntity.ok(count)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/block/transaction-count/hash/{blockHash}")
    fun getBlockTransactionCountByHash(@PathVariable blockHash: String): ResponseEntity<String> {
        val count = ttChainService.getBlockTransactionCountByHash(blockHash)
        return if (count != null) {
            ResponseEntity.ok(count)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/block/transaction-count/number/{blockNumber}")
    fun getBlockTransactionCountByNumber(@PathVariable blockNumber: String): ResponseEntity<String> {
        val count = ttChainService.getBlockTransactionCountByNumber(blockNumber)
        return if (count != null) {
            ResponseEntity.ok(count)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}