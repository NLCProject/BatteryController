package org.ocpp.battery.controller.plugins.controller.modbusSimulator

import org.ocpp.battery.controller.plugins.controller.register.Register

/**
 *
 */
class ModbusResponse(

    /**
     *
     */
    var command: ModbusCommand,

    /**
     *
     */
    var value: Register
)
