package org.ocpp.battery.controller.entities.register.interfaces

import org.ocpp.battery.controller.plugins.controller.modbusSimulator.ModbusCommand
import org.ocpp.battery.controller.plugins.controller.register.Register
import org.ocpp.battery.controller.plugins.manufacturers.Manufacturer

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
    fun saveRegisterByManufacturer(command: ModbusCommand, value: String, manufacturer: Manufacturer): Register
}
