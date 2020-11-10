package com.tcs.service.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

/**
 * This is an example for Model class
 */
@Document(collection = "template-container")
data class BaseModel(
        @Id
        var id: String = "1",
        var modId: String = "1",
        var modDesc: String = "Basic"
)