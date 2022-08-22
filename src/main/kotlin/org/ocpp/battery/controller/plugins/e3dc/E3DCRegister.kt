package org.ocpp.battery.controller.plugins.e3dc

import org.ocpp.battery.controller.plugins.controller.commands.ModbusCommand
import org.ocpp.battery.controller.plugins.controller.enums.AccessType
import org.ocpp.battery.controller.plugins.controller.enums.DataType
import org.ocpp.battery.controller.plugins.controller.enums.I18nKey
import org.ocpp.battery.controller.plugins.controller.register.Register
import org.ocpp.battery.controller.plugins.controller.register.descriptors.value.ValueDescriptor
import org.ocpp.battery.controller.plugins.manufacturers.Manufacturer

/**
 *
 */
object E3DCRegister {

    val manufacturer = Manufacturer.E3DC

    val registers = listOf(
        Register(
            index = 40002,
            i18nKey = I18nKey.RegisterModbusFirmwareVersion,
            dataType = DataType.UInt8Doubled,
            accessType = AccessType.Read,
            descriptor = ValueDescriptor(value = "1.0"),
            command = ModbusCommand.ModbusFirmwareVersion
        ),

        Register(
            index = 40003,
            i18nKey = I18nKey.RegisterNumberOfRegisters,
            dataType = DataType.Uint16,
            accessType = AccessType.Read,
            descriptor = ValueDescriptor(value = "6"),
            command = ModbusCommand.NumberOfRegisters
        ),

        Register(
            index = 40004,
            i18nKey = I18nKey.RegisterManufacturer,
            dataType = DataType.String,
            accessType = AccessType.Read,
            descriptor = ValueDescriptor(value = "E3DC"),
            command = ModbusCommand.Manufacturer
        ),

        Register(
            index = 40020,
            i18nKey = I18nKey.RegisterHardwareModel,
            dataType = DataType.String,
            accessType = AccessType.Read,
            descriptor = ValueDescriptor(value = "S10 E AIO"),
            command = ModbusCommand.HardwareModel
        ),

        Register(
            index = 40036,
            i18nKey = I18nKey.RegisterSerialNumber,
            dataType = DataType.String,
            accessType = AccessType.Read,
            descriptor = ValueDescriptor(value = "S10-12345678912"),
            command = ModbusCommand.SerialNumber
        ),

        Register(
            index = 40052,
            i18nKey = I18nKey.RegisterHardwareFirmwareVersion,
            dataType = DataType.String,
            accessType = AccessType.Read,
            descriptor = ValueDescriptor(value = "2.0"),
            command = ModbusCommand.HardwareFirmwareVersion
        )
    )
}
