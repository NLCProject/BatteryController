package org.ocpp.battery.controller.plugins.controller.register

import org.ocpp.battery.controller.plugins.controller.modbusSimulator.ModbusCommand
import org.ocpp.battery.controller.plugins.controller.register.descriptors.Descriptor
import org.ocpp.battery.controller.plugins.controller.enums.AccessType
import org.ocpp.battery.controller.plugins.controller.enums.DataType
import org.ocpp.battery.controller.plugins.controller.enums.I18nKey

/**
 *
 */
class Register(

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
    var dataType: DataType,

    /**
     *
     */
    var accessType: AccessType,

    /**
     *
     */
    var descriptor: Descriptor,

    /**
     *
     */
    var command: ModbusCommand
)
