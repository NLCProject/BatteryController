package org.ocpp.battery.controller.plugins.controller.smartHomeConnector

import org.ocpp.battery.controller.plugins.controller.modbusSimulator.ModbusCommand
import org.ocpp.battery.controller.plugins.controller.modbusSimulator.ModbusRequest
import org.ocpp.battery.controller.plugins.controller.modbusSimulator.ModbusResponse
import org.ocpp.battery.controller.plugins.exceptions.ManufacturerNotRegisteredException
import org.ocpp.battery.controller.plugins.manufacturers.Manufacturer
import org.ocpp.battery.controller.plugins.manufacturers.ManufacturerMatcher
import org.ocpp.battery.controller.plugins.restTemplate.RestGetTemplate
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class SmartHomeConnector : ISmartHomeConnector {

    private var manufacturer: Manufacturer? = null
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun registerManufacturer(manufacturer: Manufacturer) {
        logger.info("Registering controller of manufacturer '$manufacturer'")
        this.manufacturer = manufacturer
    }

    override fun getAllAvailableCommand(): List<ModbusCommand> = ManufacturerMatcher
        .getManufacturerDefinition(manufacturer = manufacturer ?: throw ManufacturerNotRegisteredException())
        .registers
        .map { it.command }

    override fun sendCommand(request: ModbusRequest): ModbusResponse {
        logger.info("Sending request with command '${request.command}'")
        return RestGetTemplate.sendCommand(request = request)
    }
}
