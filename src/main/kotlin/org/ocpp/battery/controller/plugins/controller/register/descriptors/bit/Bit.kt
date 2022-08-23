package org.ocpp.battery.controller.plugins.controller.register.descriptors.bit

import kotlinx.serialization.Serializable
import org.ocpp.battery.controller.plugins.controller.enums.AccessType
import org.ocpp.battery.controller.plugins.controller.enums.I18nKey

/**
 *
 */
@Serializable
class Bit(

    /**
     *
     */
    var index: Int,

    /**
     *
     */
    var i18nKey: I18nKey,

    /**
     *
     */
    var accessType: AccessType,

    /**
     *
     */
    var value: String
)
