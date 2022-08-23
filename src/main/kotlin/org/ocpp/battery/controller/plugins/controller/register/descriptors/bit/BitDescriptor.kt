package org.ocpp.battery.controller.plugins.controller.register.descriptors.bit

import org.ocpp.battery.controller.plugins.controller.register.descriptors.Descriptor
import org.ocpp.battery.controller.plugins.controller.register.descriptors.enums.DescriptorType

/**
 *
 */
class BitDescriptor(

    /**
     *
     */
    var bits: List<Bit>
) : Descriptor(type = DescriptorType.Bits)
