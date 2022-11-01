package org.ocpp.battery.controller.services.migration.interfaces

import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener

/**
 * Migration service to import data.
 */
interface IMigrationService {

    /**
     * Start migration on start up.
     */
    @EventListener(ApplicationReadyEvent::class)
    fun startMigration()
}
