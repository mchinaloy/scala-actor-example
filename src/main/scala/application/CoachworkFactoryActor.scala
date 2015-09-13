package application

import java.util.UUID


import domain.component.Coachwork

import scala.actors.Actor

class CoachworkFactoryActor(carFactoryActor: CarFactoryActor) extends Actor {

  override def act(): Unit = {
    println("CoachworkFactoryActor is starting...")
    while(true) {
      carFactoryActor ! new Coachwork(UUID.randomUUID())
    }
  }

}
