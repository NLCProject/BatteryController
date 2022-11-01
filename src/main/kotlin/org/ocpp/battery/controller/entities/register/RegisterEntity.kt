package org.ocpp.battery.controller.entities.register

import org.isc.utils.genericCrudl.models.IscEntity
import org.isc.utils.utils.Ids
import org.battery.controller.util.controller.enums.AccessType
import org.battery.controller.util.controller.enums.DataType
import org.battery.controller.util.controller.enums.I18nKey
import org.battery.controller.util.controller.modbusSimulator.ModbusCommand
import org.battery.controller.util.controller.register.descriptors.enums.DescriptorType
import org.battery.controller.util.manufacturers.enums.Manufacturer
import javax.persistence.*

/**
 * Register entity.
 */
@Entity
@Table(name = "register")
class RegisterEntity : IscEntity() {

    @Id
    @Column
    override var id: String = Ids.getRandomId()

    @Column
    override var organisationId: String = String()

    @Column
    override var timestampCreated: Long = System.currentTimeMillis()

    @Column
    override var timestampLastModified: Long = 0

    /**
     * Register Index.
     */
    @Column
    var registerIndex: Int = 0

    /**
     * I18n key.
     */
    @Enumerated(value = EnumType.STRING)
    lateinit var i18nKey: I18nKey

    /**
     * Register data type.
     */
    @Enumerated(value = EnumType.STRING)
    lateinit var dataType: DataType

    /**
     * Register access type.
     */
    @Enumerated(value = EnumType.STRING)
    lateinit var accessType: AccessType

    /**
     * Value descriptor type.
     */
    @Enumerated(value = EnumType.STRING)
    lateinit var descriptorType: DescriptorType

    /**
     * Command to access this register.
     */
    @Enumerated(value = EnumType.STRING)
    lateinit var command: ModbusCommand

    /**
     * Value descriptor.
     */
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    lateinit var descriptor: String

    /**
     * Manufacturer.
     */
    @Enumerated(value = EnumType.STRING)
    lateinit var manufacturer: Manufacturer
}
