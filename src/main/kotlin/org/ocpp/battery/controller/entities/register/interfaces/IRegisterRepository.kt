package org.ocpp.battery.controller.entities.register.interfaces

import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
import org.ocpp.battery.controller.entities.register.RegisterEntity
import org.battery.controller.util.manufacturers.enums.Manufacturer
import java.util.*

/**
 *
 */
interface IRegisterRepository : ICrudlRepository<RegisterEntity> {

    /**
     *
     */
    fun findByRegisterIndexAndManufacturer(registerIndex: Int, manufacturer: Manufacturer): Optional<RegisterEntity>
}
