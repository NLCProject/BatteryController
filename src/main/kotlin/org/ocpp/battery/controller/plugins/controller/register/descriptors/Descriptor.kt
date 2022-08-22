package org.ocpp.battery.controller.plugins.controller.register.descriptors

import kotlinx.serialization.Serializable
import org.ocpp.battery.controller.plugins.controller.register.descriptors.enums.DescriptorType

/**
 *
 */
@Serializable
abstract class Descriptor(var type: DescriptorType)
