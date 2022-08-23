package org.ocpp.battery.controller.plugins.manufacturers

import org.ocpp.battery.controller.plugins.controller.register.Register

/**
 *
 */
interface IManufacturerDefinition {

    /**
     *
     */
    var manufacturer: Manufacturer

    /**
     *
     */
    var registers: List<Register>
}
