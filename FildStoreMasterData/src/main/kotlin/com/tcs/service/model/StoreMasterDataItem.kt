package com.tcs.service.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection="FildStoresData")
data class   StoreMasterDataItem(
        @Id
    val id: String?=null,
    val address: String?=null,
    val addressCodeEan: String?=null,
    val city: String?=null,
      val cluster : String?=null,
    val countryCode: String?=null,
    val countryName: String?=null,
    val eslStartDate: String?=null,
    val eslVendor: String?=null,
    val formatPeriods: List<FormatPeriod>?=emptyList(),
    val isFranchise: String?=null,
    val lifeCycleStatus: String?=null,
    val name: String?=null,
    val openingTimes: List<OpeningTime>?=emptyList(),
    val phoneNumber: String?=null,
    val postalCode: String?=null,
    val region: String?=null,
    val storeClusterPeriods: List<StoreClusterPeriod>?=emptyList(),
    val temporaryClosurePeriods: List<TemporaryClosurePeriod>?=emptyList()
)



