package org.ocpp.battery.controller.plugins.controller.smartHomeConnector

import org.ocpp.battery.controller.plugins.controller.modbusSimulator.ModbusCommand
import org.ocpp.battery.controller.plugins.controller.modbusSimulator.ModbusRequest
import org.ocpp.battery.controller.plugins.controller.modbusSimulator.ModbusResponse
import org.ocpp.battery.controller.plugins.manufacturers.Manufacturer

/**
 *
 */
interface ISmartHomeConnector {

    /**
     *
     */
    fun registerManufacturer(manufacturer: Manufacturer)

    /**
     *
     */
    fun getAllAvailableCommand(): List<ModbusCommand>

    /**
     *
     */
    fun sendCommand(request: ModbusRequest): ModbusResponse
}
