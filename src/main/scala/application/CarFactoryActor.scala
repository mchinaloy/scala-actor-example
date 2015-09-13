package application

import domain.component.{Coachwork, Engine, Wheel}

import scala.actors.Actor
import scala.collection.mutable.ArrayBuffer

class CarFactoryActor(carPaintingFactoryActor: CarPaintingFactoryActor) extends Actor {

  var coachworks = new ArrayBuffer[Coachwork]()
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
      }
      assembleCar()
    }
  }

  private def assembleCar(): Unit = {
    println("Attempting to assemble")
    if(coachworks.length > 0 & engines.length > 0 & wheels.length > 3){
      println("Assembling a new Car")
    }
  }

}
