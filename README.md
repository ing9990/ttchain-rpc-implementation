# TTChain JSONRPC Client

A Spring Boot 3 client for TT-Chain blockchain JSON-RPC API implemented in Kotlin using FeignClient.

## Overview

This project provides a client library for interacting with TT-Chain blockchain through its JSON-RPC
API. It includes:

- OpenAPI Specification for the TT-Chain RPC API
    - [TTChain Documentation](https://ttchain-docs.readthedocs.io/en/latest/)
    - [TTChain OpenAPI Specification](./api-spec.yml)
- Kotlin models for JSON-RPC requests and responses
- FeignClient implementation for API communication
- Service layer with business logic
- REST controllers for easy integration

## Getting Started

### Prerequisites

- JDK 17 or higher
- Gradle 7.5+ or Maven 3.8+

### Configuration

Configure the TT-Chain RPC endpoint in `application.properties`:

```properties
ttchain.rpc.url=web3.ttchain.io
```

### Building the Project

```bash
./gradlew build
```

### Running the Application

```bash
./gradlew bootRun
```

## API Documentation

### Available Endpoints

| HTTP Method | Endpoint                                                    | Description                           |
|-------------|-------------------------------------------------------------|---------------------------------------|
| GET         | `/api/ttchain/block/number/{blockNumber}`                   | Get block by number                   |
| GET         | `/api/ttchain/block/hash/{blockHash}`                       | Get block by hash                     |
| GET         | `/api/ttchain/transaction/{txHash}`                         | Get transaction by hash               |
| POST        | `/api/ttchain/transaction/send`                             | Send raw transaction                  |
| POST        | `/api/ttchain/call`                                         | Execute contract call                 |
| GET         | `/api/ttchain/balance/{address}`                            | Get account balance                   |
| GET         | `/api/ttchain/code/{address}`                               | Get contract code                     |
| GET         | `/api/ttchain/storage/{address}/{position}`                 | Get storage at position               |
| GET         | `/api/ttchain/transaction-count/{address}`                  | Get transaction count for address     |
| GET         | `/api/ttchain/block/transaction-count/hash/{blockHash}`     | Get block transaction count by hash   |
| GET         | `/api/ttchain/block/transaction-count/number/{blockNumber}` | Get block transaction count by number |

## JSON-RPC Methods

The client supports the following TT-Chain JSON-RPC methods:

| Method                              | Description                           |
|-------------------------------------|---------------------------------------|
| tt_getBlockByNumber                 | Get block by number                   |
| tt_getBlockByHash                   | Get block by hash                     |
| tt_getTransactionByHash             | Get transaction by hash               |
| tt_sendRawTransaction               | Send raw transaction                  |
| tt_call                             | Execute contract call                 |
| tt_getBalance                       | Get account balance                   |
| tt_getCode                          | Get contract code                     |
| tt_getStorageAt                     | Get storage at position               |
| tt_getTransactionCount              | Get transaction count                 |
| tt_getBlockTransactionCountByHash   | Get block transaction count by hash   |
| tt_getBlockTransactionCountByNumber | Get block transaction count by number |

## Usage Examples

### Get Block by Number

```kotlin
// Using the service
val block = ttChainService.getBlockByNumber("0x1", false)

// REST API request
GET / api / ttchain / block / number / 0x1?fullTransactions = false
```

### Send a Transaction

```kotlin
// Using the service
val txHash = ttChainService.sendRawTransaction("0x...")

// REST API request
POST / api / ttchain / transaction / send
Body: "0x..."
```

### Call a Contract

```kotlin
// Using the service
val callRequest = CallRequest(
    from = "0x...",
    to = "0x...",
    data = "0x..."
)
val result = ttChainService.call(callRequest, "latest")

// REST API request
POST / api / ttchain / call?blockParameter = latest
Body: { "from": "0x...", "to": "0x...", "data": "0x..." }
```
