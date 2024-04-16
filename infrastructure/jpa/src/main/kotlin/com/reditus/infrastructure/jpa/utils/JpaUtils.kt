package com.reditus.infrastructure.jpa.utils

import com.reditus.core.common.exception.ResourceNotFoundException
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull

/**
 * Find entity by id or throw ResourceNotFoundException
 * reified는 inline 함수에서만 사용 가능
 * 해당 키워드는 런타임에 제네릭 타입 정보를 알 수 있게 해준다.
 */
inline fun <reified T, ID> CrudRepository<T, ID>.findByIdOrThrow(id: ID) : T{
    return this.findByIdOrNull(id) ?: throw ResourceNotFoundException(T::class.simpleName ?: "Entity", id.toString())
}