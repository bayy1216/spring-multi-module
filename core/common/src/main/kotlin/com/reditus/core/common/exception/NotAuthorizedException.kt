package com.reditus.core.common.exception

class NotAuthorizedException: RuntimeException {
    constructor(message: String): super(message)
    constructor(message: String, cause: Throwable): super(message, cause)

}