package com.demo.dataclasses

data class Hit(
    val _links: LinksX,
    val bookmarked: Boolean,
    val bought: Boolean,
    val recipe: Recipe
)