package com.tcs.service.service

import com.tcs.service.constant.ExceptionMessage
import com.tcs.service.error.customexception.DataNotFoundException
import com.tcs.service.model.BaseModel
import com.tcs.service.model.StoreMasterDataItem
import com.tcs.service.repository.BaseRepository
import org.springframework.stereotype.Service
import java.util.*


@Service
class BaseService(private val repository: BaseRepository) {

    fun getBaseModelById(id: String): Optional<StoreMasterDataItem> {
        println("id is $id")
        return repository.findById(id) ?: throw DataNotFoundException(ExceptionMessage.NO_DATA_FOUND)
    }

    fun getBaseModel(): MutableList<StoreMasterDataItem> {

        return repository.findAll() ?: throw DataNotFoundException(ExceptionMessage.NO_DATA_FOUND)

    }

    fun saveModel(model: StoreMasterDataItem) {
        repository.save(model)


    }

    /*fun findByClusterCode(city:String) : StoreMasterDataItem {
        println("here in service")
        return repository.findByClusterCode(city)
    }*/

    fun findByIdAndParams (id: Int, city: String, countryCode: String  ) : StoreMasterDataItem {

        return repository.findByIdAndParams(id!! ,city, countryCode   )
    }



}