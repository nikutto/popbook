package com.example.popbook.dao

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator

@Entity
class Book(
    @Id
    @SequenceGenerator(name = "book_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val author: String,
    val itemUrl: String,
    val imageUrl: String,
    val createdAt: LocalDateTime?
)
