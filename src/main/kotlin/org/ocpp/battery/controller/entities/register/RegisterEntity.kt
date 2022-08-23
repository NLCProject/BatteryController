package org.ocpp.battery.controller.entities.register

import org.isc.utils.genericCrudl.models.IscEntity
import org.isc.utils.utils.Ids
import org.ocpp.battery.controller.plugins.controller.enums.AccessType
import org.ocpp.battery.controller.plugins.controller.enums.DataType
import org.ocpp.battery.controller.plugins.controller.enums.I18nKey
import org.ocpp.battery.controller.plugins.controller.modbusSimulator.ModbusCommand
import org.ocpp.battery.controller.plugins.controller.register.descriptors.enums.DescriptorType
import org.ocpp.battery.controller.plugins.manufacturers.Manufacturer
import javax.persistence.*

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
     *
     */
    @Column
    var index: Int = 0

    /**
     *
     */
    @Enumerated(value = EnumType.STRING)
    lateinit var i18nKey: I18nKey

    /**
     *
     */
    @Enumerated(value = EnumType.STRING)
    lateinit var dataType: DataType

    /**
     *
     */
    @Enumerated(value = EnumType.STRING)
    lateinit var accessType: AccessType

    /**
     *
     */
    @Enumerated(value = EnumType.STRING)
    lateinit var descriptorType: DescriptorType

    /**
     *
     */
    @Enumerated(value = EnumType.STRING)
    lateinit var command: ModbusCommand

    /**
     *
     */
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    lateinit var descriptor: String

    /**
     *
     */
    @Enumerated(value = EnumType.STRING)
    lateinit var manufacturer: Manufacturer
}
