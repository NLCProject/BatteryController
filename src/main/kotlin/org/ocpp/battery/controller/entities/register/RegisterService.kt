package org.ocpp.battery.controller.entities.register

import org.isc.utils.serialization.JsonSerialization
import org.isc.utils.tests.CurrentUserFactory
import org.ocpp.battery.controller.entities.register.interfaces.IRegisterService
import org.battery.controller.util.controller.modbusSimulator.ModbusCommand
import org.battery.controller.util.controller.register.DescriptorBuilder
import org.battery.controller.util.controller.register.Register
import org.battery.controller.util.controller.register.descriptors.enums.DescriptorType
import org.battery.controller.util.manufacturers.enums.Manufacturer
import org.battery.controller.util.manufacturers.ManufacturerMatcher
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RegisterService @Autowired constructor(
    private val repositoryService: RegisterRepository
) : IRegisterService, JsonSerialization() {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun findRegisterByManufacturer(command: ModbusCommand, manufacturer: Manufacturer): Register {
        logger.info("Requesting register by command '$command' | manufacturer '$manufacturer'")
        val index = getIndex(command = command, manufacturer = manufacturer)
        val register = repositoryService.findByIndexAndManufacturer(index = index, manufacturer = manufacturer)
        return convertRegister(register = register)
    }

    override fun saveRegisterByManufacturer(
        value: String,
        command: ModbusCommand,
        manufacturer: Manufacturer
    ): Register {
        logger.info("Requesting register by command '$command' | manufacturer '$manufacturer' | value '$value'")
        val index = getIndex(command = command, manufacturer = manufacturer)
        var register = repositoryService.findByIndexAndManufacturer(index = index, manufacturer = manufacturer)
        register.descriptorType = DescriptorType.Value
        register.descriptor = value
        register = repositoryService.save(entity = register, currentUser = CurrentUserFactory.getCurrentUser())
        return convertRegister(register = register)
    }

    private fun convertRegister(register: RegisterEntity): Register = Register(
        index = register.registerIndex,
        i18nKey = register.i18nKey,
        dataType = register.dataType,
        accessType = register.accessType,
        descriptor = DescriptorBuilder.buildValue(value = register.descriptor),
        command = register.command
    )

    private fun getIndex(command: ModbusCommand, manufacturer: Manufacturer): Int = ManufacturerMatcher
        .getManufacturerDefinition(manufacturer = manufacturer)
        .registers
        .firstOrNull { it.command == command }
        ?.index
        ?: throw Exception(
            "No register found for command '$command' and manufacturer '$manufacturer' in " +
                "manufacturer definition"
        )
}
