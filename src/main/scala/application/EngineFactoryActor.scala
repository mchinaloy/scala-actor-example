package application

import java.util.UUID


import domain.component.Engine

import scala.actors.Actor

class EngineFactoryActor(carFactoryActor: CarFactoryActor) extends Actor {

  override def act(): Unit = {
    println("EngineFactoryActor is starting...")
    while(true) {
      carFactoryActor ! new Engine(UUID.randomUUID())
    }
  }

}
