package org.ocpp.battery.controller.entities.register.interfaces

import org.battery.controller.util.controller.modbusSimulator.ModbusCommand
import org.battery.controller.util.controller.register.Register
import org.battery.controller.util.manufacturers.enums.Manufacturer

/**
 *
 */
interface IRegisterService {

    /**
     *
     */
    fun findRegisterByManufacturer(command: ModbusCommand, manufacturer: Manufacturer): Register

    /**
     *
     */
    fun saveRegisterByManufacturer(value: String, command: ModbusCommand, manufacturer: Manufacturer): Register
}
