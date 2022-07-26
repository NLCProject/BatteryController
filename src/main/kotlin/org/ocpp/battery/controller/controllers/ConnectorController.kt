package org.ocpp.battery.controller.controllers

import org.battery.controller.util.controller.modbusSimulator.ModbusCommand
import org.battery.controller.util.controller.register.Register
import org.battery.controller.util.manufacturers.enums.Manufacturer
import org.isc.utils.genericCrudl.controller.CrossOriginData
import org.ocpp.battery.controller.entities.register.interfaces.IRegisterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

/**
 * REST controller for connectors.
 */
@Controller
@Transactional
@RequestMapping(path = ["/connector"])
@CrossOrigin(origins = [CrossOriginData.origins], allowedHeaders = [CrossOriginData.allowedHeaders])
class ConnectorController @Autowired constructor(
    private val registerService: IRegisterService
) {

    /**
     * Get all registers by command and manufacturer.
     *
     * @param command .
     * @param manufacturer .
     * @return Register.
     */
    @GetMapping(value = ["/get"])
    fun get(@RequestParam command: ModbusCommand, @RequestParam manufacturer: Manufacturer): ResponseEntity<Register> {
        val register = registerService.findRegisterByManufacturer(command = command, manufacturer = manufacturer)
        return ResponseEntity(register, HttpStatus.OK)
    }

    /**
     * Updates register by given command and value.
     *
     * @param value New value
     * @param command .
     * @param manufacturer .
     * @return Updated register.
     *
     */
    @GetMapping(value = ["/post"])
    fun post(
        @RequestParam command: ModbusCommand,
        @RequestParam value: String,
        @RequestParam manufacturer: Manufacturer
    ): ResponseEntity<Register> {
        val register = registerService.saveRegisterByManufacturer(
            value = value,
            command = command,
            manufacturer = manufacturer
        )

        return ResponseEntity(register, HttpStatus.OK)
    }
}
