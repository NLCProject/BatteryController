package org.ocpp.battery.controller.entities.register.interfaces

import org.battery.controller.util.controller.modbusSimulator.ModbusCommand
import org.battery.controller.util.controller.register.Register
import org.battery.controller.util.manufacturers.enums.Manufacturer

/**
 * Register repository interface.
 */
interface IRegisterService {

    /**
     * Get all registers by manufacturer.
     *
     * @param command .
     * @param manufacturer .
     * @return Register.
     */
    fun findRegisterByManufacturer(command: ModbusCommand, manufacturer: Manufacturer): Register

    /**
     * Save register by manufacturer.
     *
     * @param value New value.
     * @param command .
     * @param manufacturer .
     * @return Updated register.
     */
    fun saveRegisterByManufacturer(value: String, command: ModbusCommand, manufacturer: Manufacturer): Register
}
