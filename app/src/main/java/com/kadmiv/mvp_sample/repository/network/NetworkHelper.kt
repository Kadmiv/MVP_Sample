package com.kadmiv.mvp_sample.repository.network

import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created by Kadmiv on 01.11.2020 12:14
 */

abstract class AbstractNetworkHelper {

}

class NetworkHelper : AbstractNetworkHelper(), KoinComponent {

    var LOG: Logger = LoggerFactory.getLogger(NetworkHelper::class.java)

    val appDatabase: IApi by inject()


}