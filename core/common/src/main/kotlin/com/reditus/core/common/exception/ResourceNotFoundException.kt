package com.reditus.core.common.exception

class ResourceNotFoundException(message: String) : RuntimeException(message){
    constructor(dataSource: String, id: Long) : this("${dataSource}에서 ID ${id}를 찾을 수 없습니다.")
    constructor(dataSource: String, id: String) : this("${dataSource}에서 ID ${id}를 찾을 수 없습니다.")
}