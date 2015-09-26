package application.component

import java.util.UUID

import application.CarFactoryActor
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
