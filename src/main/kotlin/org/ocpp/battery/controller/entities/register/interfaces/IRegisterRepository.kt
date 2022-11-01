package org.ocpp.battery.controller.entities.register.interfaces

import org.isc.utils.genericCrudl.interfaces.ICrudlRepository
import org.ocpp.battery.controller.entities.register.RegisterEntity
import org.battery.controller.util.manufacturers.enums.Manufacturer
import java.util.*

/**
 * Register repository interface.
 */
interface IRegisterRepository : ICrudlRepository<RegisterEntity> {

    /**
     * Gets all register by index and manufacturer.
     *
     * @param registerIndex .
     * @param manufacturer .
     * @return Optional of register.
     */
    fun findByRegisterIndexAndManufacturer(registerIndex: Int, manufacturer: Manufacturer): Optional<RegisterEntity>
}
