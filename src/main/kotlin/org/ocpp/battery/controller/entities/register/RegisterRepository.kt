package org.ocpp.battery.controller.entities.register

import org.isc.utils.genericCrudl.services.RepositoryService
import org.ocpp.battery.controller.entities.register.interfaces.IRegisterRepository
import org.battery.controller.util.manufacturers.enums.Manufacturer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RegisterRepository @Autowired constructor(
    private val repository: IRegisterRepository
) : RepositoryService<RegisterEntity>(repository = repository) {

    /**
     *
     */
    fun findByIndexAndManufacturer(index: Int, manufacturer: Manufacturer): RegisterEntity {
        val optional = repository.findByIndexAndManufacturer(index = index, manufacturer = manufacturer)
        if (!optional.isPresent)
            throw Exception("No register found for index '$index' and manufacturer '$manufacturer' in repository")

        return optional.get()
    }
}
