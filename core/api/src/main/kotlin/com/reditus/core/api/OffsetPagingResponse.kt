package com.reditus.core.api

import org.springframework.data.domain.Page


data class OffsetPagingResponse<T>(
    val totalPage: Int,
    val data: List<T>
) {
    companion object {
        fun <Model, Entity> from(page: Page<Entity>, converter: (Entity) -> Model): OffsetPagingResponse<Model> {
            return OffsetPagingResponse(
                totalPage = page.totalPages,
                data = page.content.map(converter),
            )
        }
    }
}

