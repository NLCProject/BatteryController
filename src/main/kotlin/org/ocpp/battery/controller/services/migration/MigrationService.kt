package org.ocpp.battery.controller.services.migration

import org.ocpp.battery.controller.entities.register.RegisterEntity
import org.ocpp.battery.controller.entities.register.interfaces.IRegisterRepository
import org.battery.controller.util.controller.register.Register
import org.battery.controller.util.controller.register.descriptors.value.ValueDescriptor
import org.battery.controller.util.manufacturers.enums.Manufacturer
import org.battery.controller.util.manufacturers.ManufacturerMatcher
import org.battery.controller.util.manufacturers.interfaces.IManufacturerDefinition
import org.ocpp.battery.controller.services.migration.interfaces.IMigrationService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MigrationService @Autowired constructor(
    private val registerRepository: IRegisterRepository
) : IMigrationService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun startMigration() {
        logger.info("Starting data migration")
        val definitions = ManufacturerMatcher.getAllManufacturerDefinitions()
        logger.info("Found ${definitions.size} manufacturer definitions to import")
        definitions.forEach { importDefinition(definition = it) }
        logger.info("Data migration finished")
    }

    private fun importDefinition(definition: IManufacturerDefinition) {
        try {
            logger.info("Importing definition of manufacturer '${definition.manufacturer}'")
            definition
                .registers
                .forEach { importRegister(register = it, manufacturer = definition.manufacturer) }
        } catch (ex: Exception) {
            logger.error("Error while importing definition: '${ex.message}'")
        }
    }

    private fun importRegister(register: Register, manufacturer: Manufacturer) {
        logger.info("Importing register with index '${register.index}'")
        val entity = RegisterEntity()
        entity.index = register.index
        entity.i18nKey = register.i18nKey
        entity.dataType = register.dataType
        entity.accessType = register.accessType
        // TODO Currently only value descriptor is supported -> this means descriptor == value
        entity.descriptor = (register.descriptor as ValueDescriptor).value
        entity.command = register.command
        entity.manufacturer = manufacturer
        registerRepository.save(entity)
    }
}
