package org.ocpp.battery.controller.plugins.manufacturers

import org.ocpp.battery.controller.plugins.e3dc.E3DCDefinition

/**
 *
 */
object ManufacturerMatcher {

    /**
     *
     */
    fun getManufacturerDefinition(manufacturer: Manufacturer): IManufacturerDefinition =
        when (manufacturer) {
            Manufacturer.E3DC -> E3DCDefinition
        }

    /**
     *
     */
    fun getAllManufacturerDefinitions(): List<IManufacturerDefinition> = listOf(E3DCDefinition)
}
