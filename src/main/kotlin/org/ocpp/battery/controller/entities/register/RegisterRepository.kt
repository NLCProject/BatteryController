package org.ocpp.battery.controller.entities.register

import org.isc.utils.genericCrudl.services.RepositoryService
import org.ocpp.battery.controller.entities.register.interfaces.IRegisterRepository
import org.battery.controller.util.manufacturers.enums.Manufacturer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Register repository.
 */
@Service
class RegisterRepository @Autowired constructor(
    private val repository: IRegisterRepository
) : RepositoryService<RegisterEntity>(repository = repository) {

    /**
     * Gets all register by index and manufacturer.
     *
     * @param index .
     * @param manufacturer .
     * @return Optional of register.
     */
    fun findByIndexAndManufacturer(index: Int, manufacturer: Manufacturer): RegisterEntity {
        val optional = repository.findByRegisterIndexAndManufacturer(registerIndex = index, manufacturer = manufacturer)
        if (!optional.isPresent)
            throw Exception("No register found for index '$index' and manufacturer '$manufacturer' in repository")

        return optional.get()
    }
}
