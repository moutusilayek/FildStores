package com.tcs.service.repository

import com.tcs.service.model.StoreMasterDataItem
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import java.awt.print.Book


@Repository
interface BaseRepository : MongoRepository<StoreMasterDataItem, String> {

    //fun findByModId(id: StrclubNoing): StoreMasterDataItem


   // @Query(value={ "city": ?null}, fields = "{ 'city' : ?null }")
    //@Query("{'city' : ?0 }" , fields = "{ 'countryCode': ? }")
    //fun findByClusterCode(city: String) :StoreMasterDataItem



    @Query("{'id: ?0' }  " )


    /*@Query({ $and :
        [
            {$or : [ { where: '?0 == null;' }, , { retrieveOpeningTimes : ?0 }]},
            {$or : [ { where: '?1 == null' } , { refDate : ?1 }]},
            {$or : [ { where: '?2 == null' } , { retrieveStoreClusterPeriods : ?2 }]}
        ]
    })*/
    fun findByIdAndParams1 (id : Int ,city: String , countryCode : String) : StoreMasterDataItem


    @Query("{\$or : [{id: ?0} ,{city: ?1}, {countryCode : ?2}]}")
    fun findByIdAndParams (id : Int ,city: String , countryCode : String) : StoreMasterDataItem

}