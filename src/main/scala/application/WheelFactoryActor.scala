package application

import java.util.UUID


import domain.component.Wheel

import scala.actors.Actor

class WheelFactoryActor(carFactoryActor: CarFactoryActor) extends Actor {

  override def act(): Unit = {
    println("WheelFactoryActor is starting...")
    while(true) {
      carFactoryActor ! new Wheel(UUID.randomUUID())
    }
  }

}
