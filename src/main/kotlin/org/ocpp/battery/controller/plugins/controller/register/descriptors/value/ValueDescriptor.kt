package org.ocpp.battery.controller.plugins.controller.register.descriptors.value

import org.ocpp.battery.controller.plugins.controller.register.descriptors.Descriptor
import org.ocpp.battery.controller.plugins.controller.register.descriptors.enums.DescriptorType

/**
 *
 */
class ValueDescriptor(

    /**
     *
     */
    var value: String
) : Descriptor(type = DescriptorType.Value)
