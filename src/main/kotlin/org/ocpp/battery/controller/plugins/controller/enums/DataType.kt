package org.ocpp.battery.controller.plugins.controller.enums

/**
 *
 */
enum class DataType(

    /**
     *
     */
    var numberOfBits: Int
) {
    Uint16(numberOfBits = 1),
    Int32(numberOfBits = 2),
    String(numberOfBits = 16),
    UInt8Doubled(numberOfBits = 1)
}
