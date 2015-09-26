package application

import application.paint.CarPaintingFactoryActor
import domain.Car
import domain.component.{Coachwork, Engine, Wheel}

import scala.actors.Actor
import scala.collection.mutable.ArrayBuffer

class CarFactoryActor(carPaintingFactoryActor: CarPaintingFactoryActor) extends Actor {

  val coachworks = new ArrayBuffer[Coachwork]()
  val engines = new ArrayBuffer[Engine]()
  val wheels = new ArrayBuffer[Wheel]()

  override def act(): Unit = {
    println("CarFactoryActor is starting...")
    while (true) {
      receive {
        case msg =>
          msg match {
            case coachwork: Coachwork =>
              coachworks += coachwork
            case engine: Engine =>
              engines += engine
            case wheel: Wheel =>
              wheels += wheel
          }
          if (canAssembleCar) {
            carPaintingFactoryActor ! assembleCar()
          }
      }
    }
  }

  private def assembleCar(): Car = {
    val wheelsToUse = wheels.slice(0, 4)

    for (i <- 0 to 3) {
      wheels.remove(0)
    }

    new Car(engines.remove(0), coachworks.remove(0), wheelsToUse.toArray)
  }

  private def canAssembleCar: Boolean = {
    if (coachworks.length > 0 & engines.length > 0 & wheels.length > 3) {
      return true
    }
    false
  }

}
