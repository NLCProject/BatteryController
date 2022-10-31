package org.ocpp.battery.controller

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan(basePackages = ["org.ocpp.smart.home", "org.isc.utils", "org.ocpp.client", "org.ocpp.battery.controller"])
@SpringBootApplication(scanBasePackages = ["org.ocpp.smart.home", "org.isc.utils", "org.ocpp.battery.controller"])
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
