package com.tcs.service.error

import com.tcs.service.error.customexception.DataNotFoundException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import com.tcs.service.error.ErrorResponseEntity.Companion.notFound

@ControllerAdvice
class ExceptionHandlers {
    /**
     * Handler Method for Data Not Found
     */
    @ExceptionHandler(DataNotFoundException::class)
    fun resourceNotFoundException(exception: DataNotFoundException) =
            exception.message?.let { notFound(it) }

    /**
     * Handler Method for Generic Exception
     */
    @ExceptionHandler(Exception::class)
    fun internalErrorException(exception: Exception) =
            exception.message?.let { ErrorResponseEntity.serverError(it) }

}