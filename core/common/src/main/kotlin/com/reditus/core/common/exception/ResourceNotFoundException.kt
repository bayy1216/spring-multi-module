package com.reditus.core.common.exception

class ResourceNotFoundException : RuntimeException {
    constructor(dataSource: String, id: Long) : super("${dataSource}에서 ID ${id}를 찾을 수 없습니다.")

    constructor(dataSource: String, id: String) : super("${dataSource}에서 ID ${id}를 찾을 수 없습니다.")

    constructor(message: String) : super(message)

    constructor(dataSource: String, id: Long, cause: Throwable) : super("${dataSource}에서 ID ${id}를 찾을 수 없습니다.", cause)

    constructor(dataSource: String, id: String, cause: Throwable) : super("${dataSource}에서 ID ${id}를 찾을 수 없습니다.", cause)

    constructor(message: String, cause: Throwable) : super(message, cause)

}