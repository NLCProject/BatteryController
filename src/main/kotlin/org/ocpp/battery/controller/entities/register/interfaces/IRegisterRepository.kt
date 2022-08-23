package org.ocpp.battery.controller.entities.register.interfaces

import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
import org.ocpp.battery.controller.entities.register.RegisterEntity
import org.ocpp.battery.controller.plugins.manufacturers.Manufacturer
import java.util.*

/**
 *
 */
interface IRegisterRepository : ICrudlRepository<RegisterEntity> {

    /**
     *
     */
    fun findByIndexAndManufacturer(index: Int, manufacturer: Manufacturer): Optional<RegisterEntity>
}
